package GAME.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {
    public static BufferedImage LoadImage(String path) throws ImageNotFoundException {
        try
        {
            return ImageIO.read(ImageLoader.class.getResource(path));
        }
        catch(Exception e)
        {
            throw new ImageNotFoundException("Image not found");
        }
    }
}
