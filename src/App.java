import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {

    Cores cor = new Cores();
    String reset = "\u001B[0m";
    String atencao = "\u26A0\uFE0F ";
    String cinema = " \uD83D\uDCFD\uFE0F";
    String foguete = " \uD83D\uDE80";

    System.out.println(atencao + " Escolha entre as apis: " + atencao);
    System.out.println((cor.backYellowTextWhiteB.format("1-IMDB" + reset + cinema)));
    System.out.println((cor.backBlueTextWhiteB.format("2- NASA" + reset + foguete)));

    try (Scanner lerOpcaoApi = new Scanner(System.in)) {
      Integer opcaoEscolhida = lerOpcaoApi.nextInt();
      System.out.println("\u2705 " + cor.backGreenTextBlackB.format("Sucesso!"));

      if (opcaoEscolhida == 1) {
        try {
          String api = "IMDB";
          String url = CreateUrl.setUrl(api);
          ClienteHttp http = new ClienteHttp();
          String json = http.buscaDados(url);
          ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
          List < Conteudo > conteudos = extrator.extraiConteudos(json);
          var geradora = new GeradoraDeFigurinhas();

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

            System.out.println(cor.backCyanTextWhiteB.format("Nome do Filme:") +
              " " + cor.negrito.format(conteudo.getTitulo()));
            String notaDoFilme = conteudo.getImDbRating();
            String stars = "";
            for (int contador = 0; contador < Math.round(Float.parseFloat(notaDoFilme)); contador++) {
              stars += "\u2B50";
            }
            System.out.println(cor.backYellowTextWhiteB.format("Classificação:") + " " +
              stars + " " + cor.backBlueTextWhiteB.format(notaDoFilme));
            System.out.println();
            System.out.println("\u2705 " + cor.backGreenTextBlackB.format("Sucesso!"));
            System.out.println();
          }

        } catch (Exception e) {
          System.out.println("Algo inesperado aconteceu.");
        }
      } else if (opcaoEscolhida == 2) {
        String api = "NASA";
        String url = CreateUrl.setUrl(api);
        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(url);
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        List < Conteudo > conteudosNasa = extrator.extraiConteudos(json);
        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < conteudosNasa.size(); i++) {
          Conteudo conteudo = conteudosNasa.get(i);
          String nomeArquivo = conteudo.getTitulo().replace(":", " -") + ".png";

          try {
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            System.out.println(("Gerando imagem - [" + conteudo.getTitulo() + "]"));
            geradora.cria(inputStream, nomeArquivo);
            System.out.println("\u2705 " + cor.backGreenTextBlackB.format("Sucesso!"));
            System.out.println();
          } catch (java.io.FileNotFoundException err) {
            System.out.println(cor.backRedTextWhiteB.format("Imagem não encontrada ou link inválido"));
          }
        }
      } else if(opcaoEscolhida == 3){
        String api = "LINGUAGENS";
        String url = CreateUrl.setUrl(api);
        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(url);
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoLinguagensAPI();
        List<Conteudo> conteudosLinguagens = extrator.extraiConteudos(json);
        var geradora = new GeradoraDeFigurinhas();

        for(int i = 0; i < conteudosLinguagens.size(); i++){
          Conteudo conteudo = conteudosLinguagens.get(i);
          String nomeArquivo = conteudo.getTitulo().replace(":", " -") + ".png";
          
        try{
          InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
          System.out.println();
          System.out.println(("Gerando imagem - [" + conteudo.getTitulo() + "]"));
          geradora.cria(inputStream, nomeArquivo);
          System.out.println("\u2705 " + cor.backGreenTextBlackB.format("Sucesso!"));
          System.out.println();
        } catch(Exception e){
          System.out.println("Algo aconteceu.");
        }
        
        }
      }
    }
  }
}