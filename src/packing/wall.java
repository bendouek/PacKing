/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Ben
 */
public class wall {
    public int x = 0;
    public int y = 0;
    public BufferedImage image = null;
    
    public wall(int xin, int yin) {
        x = xin;
        y = yin;
        try {
            image = ImageIO.read(new File("src/packing/wall.png"));
        } catch (IOException ex) {
            System.out.println("not found");
        }
    }
}
