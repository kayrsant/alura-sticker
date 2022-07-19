import java.net.URI;
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

    //String url = "https://api.mocki.io/v2/549a5d8b"; // endereço alternativo ao usado na aula
    System.out.println("Hey, o que vc quer?");
    System.out.println("1- Top 250 Filmes\n2- Top 250 Series\n3- Most Popular Movies\n4- Most Popular Series");
    Scanner lerOpcao = new Scanner(System.in);
    Integer opcaoEscolhida = lerOpcao.nextInt();
    
    String url = CreateUrl.setUrl(opcaoEscolhida);

    HttpClient client = HttpClient.newHttpClient();
    URI endereco = URI.create(url);
    var request = HttpRequest.newBuilder(endereco).GET().build();
    HttpResponse < String > response = client.send(request, BodyHandlers.ofString());
    String body = response.body();
    var parser = new JsonParser();
    List < Map < String, String >> listaDeFilmes = parser.parse(body);

    for (Map < String, String > filme: listaDeFilmes) {

      String nomeDoFilme = filme.get("title");
      System.out.println("\033[0;41m" + "Nome do filme:" + "\033[0;1m " + nomeDoFilme + RESET);
      //System.out.println(filme.get("image"));
      String notaDoFilme = filme.get("imDbRating");
            System.out.println("\033[44m" +  "Nota do filme:" + "\033[0;1m " + notaDoFilme);
            String stars = "";
            for (int i=0; i<Math.round(Float.parseFloat(notaDoFilme)); i++){
                stars += "\u2B50";
            }
            System.out.println(stars);
      System.out.println();
    }

  }

}