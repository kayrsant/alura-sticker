import java.util.Scanner;

public class CreateUrl {

  private static String url = "";
  private static String topMovies = "TopMovies.json";
  private static String topSeries = "TopTVs.json";
  private static String mostPopularMovies = "MostPopularMovies.json";
  private static String mostPopularSeries = "MostPopularTVs.json";
  private static String urlNasa = "";
  private static String urlLinguagensApi = "http://localhost:8080/linguagens";

  public static String setUrl(String api) {

    switch (api) {

    case "IMDB":
      System.out.println("1- Top 250 Filmes\n2- Top 250 Series\n3- Most Popular Movies\n4- Most Popular Series");
      Scanner lerOpcao = new Scanner(System.in);
      Integer opcaoEscolhida = lerOpcao.nextInt();
      if (opcaoEscolhida == 1) {
        url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/" + topMovies;
        return url;
      } else if (opcaoEscolhida == 2) {
        url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/" + topSeries;
        return url;
      } else if (opcaoEscolhida == 3) {
        url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/" + mostPopularMovies;
        return url;
      } else if (opcaoEscolhida == 4) {
        url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/" + mostPopularSeries;
        return url;
      }

      case "NASA":
        String apiKeyNasa = APIKey.getApiKeyNASA();
        String date = "&start_date=2022-07-18&end_date=2022-07-21";
        urlNasa = "https://api.nasa.gov/planetary/apod?api_key=" + apiKeyNasa + date;
        return urlNasa;

      case "LINGUAGENS":
      url = "http://localhost:8080/linguagens";
      return url;
    }
    return null;
  }
}