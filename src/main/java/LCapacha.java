import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import java.util.UUID;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;

import javax.imageio.ImageIO;

public class LCapacha
{
    String corr;
    LCapacha()
    {
        createString();
    }
    void createString()
    {
        Random r = new Random();
        Integer x = r.nextInt(999999) + 1000000;
        corr = x.toString();
        corr = corr.substring(1, 7);
    }
    boolean createImg(OutputStream o) throws IOException
    {
        Random ra = new Random();
        String sp = System.getProperty("file.separator");
        String uuid = UUID.randomUUID().toString();
        File fi = new File(System.getProperty("user.dir")+"\\WebLogIn\\src\\image\\"+uuid+".png");
        Integer width = 100;
        Integer height = 50;
        Font f = new Font("Curlz MT", Font.PLAIN, 32);
        BufferedImage i = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics g = i.getGraphics();
        g.setClip(0, 0, width, height);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.WHITE);
        g.setFont(f);
        Rectangle r  = g.getClipBounds();
        FontMetrics fm = g.getFontMetrics(f);
        Integer ascent = fm.getAscent();
        Integer descent = fm.getDescent();
        Integer y = (r.height - ascent - descent) / 2 + ascent;
        for(int j=0;j<6;j++)
        {
            g.drawString(corr, j*680, y);
        }
        for(int j=0;j<20;j++){
			int xj = ra.nextInt(width);
			int yj = ra.nextInt(height);
			i.setRGB(xj, yj,(int)(Math.random()*255));
		}
        g.dispose();
        ImageIO.write(i, "png", o);
        return true;
    }
    String getCapacha()
    {
        return corr;
    }
    public static void main(String[] args) throws IOException
    {
        LCapacha l = new LCapacha();
        //l.createImg();
    }
}