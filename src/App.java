import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class App {

   public static final String RESET = "\033[0m";
   public static void main(String[] args) throws Exception {

      System.out.println("E ai, qual a de hoje?");
      System.out.println("1- Top 250 Filmes\n2- Top 250 Series\n3- Most Popular Movies\n4- Most Popular Series");
      try (Scanner lerOpcao = new Scanner(System.in)) {
         Integer opcaoEscolhida = lerOpcao.nextInt();

         String url = CreateUrl.setUrl(opcaoEscolhida);

         ClienteHttp http = new ClienteHttp();
         String json = http.buscaDados(url);

         ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
         List<Conteudo> conteudos = extrator.extraiConteudos(json);
        
         GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();

         for (int i = 0; i < conteudos.size(); i++) {

            Conteudo conteudo = conteudos.get(i);
            String nomeArquivo = conteudo.getTitulo().replace(":", " -") + ".png";
           

            try {
               InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
               System.out.println("Gerando imagem - [" + conteudo.getTitulo() + "]");
               geradora.cria(inputStream, nomeArquivo);
            } catch (java.io.FileNotFoundException err) {
               System.out.println("Imagem não encontrada ou link inválido");
            }

            System.out.println("\033[0;41m" + "Nome do filme:" + "\033[0;1m " + conteudo.getTitulo() + RESET);
            /*String notaDoFilme = conteudo.get("imDbRating");
            System.out.println("\033[44m" + "Nota do filme:" + "\033[0;1m " + notaDoFilme);
            String stars = "";
            for (int i = 0; i < Math.round(Float.parseFloat(notaDoFilme)); i++) {
               stars += "\u2B50";
            }
            System.out.println(stars); */
            System.out.println();
         }
      } catch (Exception e) {
         System.out.println("O numero informado nao esta registrado.");
      }

   }

}