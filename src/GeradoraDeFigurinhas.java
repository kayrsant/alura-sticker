import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{

        // leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        //InputStream inputStream = 
        //            new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        
        // criar nova imagem em memoria com transparencia e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original à nova (em memória)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar fonte
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD,  (int)(largura/15));
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
        

        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", (int)(largura/3), novaAltura-110);

        // escrever em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));



    }

}
