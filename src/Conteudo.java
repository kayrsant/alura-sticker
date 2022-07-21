public class Conteudo {

    private final String titulo;
    private final String urlImagem;
    private final String imDbRating;
  
    public Conteudo(String titulo, String urlImagem, String imDbRating) {
      this.titulo = titulo;
      this.urlImagem = urlImagem;
      this.imDbRating = imDbRating;
    }
  
    public String getTitulo() {
      return titulo;
    }
  
    public String getUrlImagem() {
      return urlImagem;
    }
  
    public String getImDbRating() {
      return imDbRating;
    }
  
  }