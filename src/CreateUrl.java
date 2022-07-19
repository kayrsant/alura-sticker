public class CreateUrl {

    private static String url = "https://api.mocki.io/v2/549a5d8b/";
    private static String topMovies = "Top250Movies/";
    private static String topSeries = "Top250TVs/";
    private static String mostPopularMovies = "MostPopularMovies/";
    private static String mostPopularSeries = "MostPopularTVs/";
 
    public static String setUrl(int opcaoEscolhida) {
       if (opcaoEscolhida == 1) {
          url = "https://api.mocki.io/v2/549a5d8b/" + topMovies;
          return url;
       } else if (opcaoEscolhida == 2) {
         url = "https://api.mocki.io/v2/549a5d8b/" + topSeries;
          return url;
       } else if (opcaoEscolhida == 3) {
         url = "https://api.mocki.io/v2/549a5d8b/" + mostPopularMovies;
          return url;
       } else if (opcaoEscolhida == 4) {
         url = "https://api.mocki.io/v2/549a5d8b/" + mostPopularSeries;
         return url;
       }
       return null;
 
    }
 
 }