public class CreateUrl {

    private static String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/";
    private static String topMovies = "TopMovies.json";
    private static String topSeries = "TopTVs.json";
    private static String mostPopularMovies = "MostPopularMovies.json";
    private static String mostPopularSeries = "MostPopularTVs.json";
 
    public static String setUrl(int opcaoEscolhida) {
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
       return null;
 
    }
 
 }