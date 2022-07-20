import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

   public static final String RESET = "\033[0m";
   public static void main(String[] args) throws Exception {

      System.out.println("E ai, qual a de hoje?");
      System.out.println("1- Top 250 Filmes\n2- Top 250 Series\n3- Most Popular Movies\n4- Most Popular Series");
      try (Scanner lerOpcao = new Scanner(System.in)) {
         Integer opcaoEscolhida = lerOpcao.nextInt();

         String url = CreateUrl.setUrl(opcaoEscolhida);
         HttpClient client = HttpClient.newHttpClient();
         URI endereco = URI.create(url);
         var request = HttpRequest.newBuilder(endereco).GET().build();
         HttpResponse < String > response = client.send(request, BodyHandlers.ofString());
         String body = response.body();
         var parser = new JsonParser();
         List < Map < String, String >> listaDeFilmes = parser.parse(body);
         GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();

         for (Map < String, String > filme: listaDeFilmes) {

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            String nomeArquivo = titulo.replace(":", "-") + ".png";

            try {
               InputStream inputStream = new URL(urlImagem).openStream();
               System.out.println("Gerando imagem - [" + titulo + "]");
               geradora.cria(inputStream, nomeArquivo);
            } catch (java.io.FileNotFoundException err) {
               System.out.println("Imagem não encontrada ou link inválido");
            }

            System.out.println("\033[0;41m" + "Nome do filme:" + "\033[0;1m " + titulo + RESET);
            String notaDoFilme = filme.get("imDbRating");
            System.out.println("\033[44m" + "Nota do filme:" + "\033[0;1m " + notaDoFilme);
            String stars = "";
            for (int i = 0; i < Math.round(Float.parseFloat(notaDoFilme)); i++) {
               stars += "\u2B50";
            }
            System.out.println(stars);
            System.out.println();
         }
      } catch (Exception e) {
         System.out.println("O numero informado nao esta registrado.");
      }

   }

}