import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

   public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

      BufferedImage imagemOriginal = ImageIO.read(inputStream);
      BufferedImage joinha = ImageIO.read(new File("entradas/like.png"));

      int largura = imagemOriginal.getWidth();
      int altura = imagemOriginal.getHeight();
      int novaAltura = altura + 200;
      BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

      Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
      graphics.drawImage(imagemOriginal, 0, 0, null);
      graphics.drawImage(joinha, -120, novaAltura - 350, null);

      Font fonte = new Font("Impact", Font.BOLD, (int)(largura / 15));
      graphics.setColor(Color.WHITE);
      graphics.setFont(fonte);
      String frase = "THE BEST OF BESTS";
      int textWidth = graphics.getFontMetrics().stringWidth(frase);
      int center = (largura / 2) - (textWidth / 2);
      graphics.drawString(frase, center, novaAltura - 100);

      try {
         String saida = "saida/";
         Path path = Paths.get(saida);
         Files.createDirectory(path);
         ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
      } catch (Exception e) {
         ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
      }

   }

}