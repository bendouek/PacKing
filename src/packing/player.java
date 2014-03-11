/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Ben
 */
public class player {
    public int x = 0;
    public int y = 0;
    public int oldx = 0;
    public int oldy = 0;
    public int points = 0;
    public boolean pacR = true;
    public BufferedImage image = null;
    public BufferedImage left = null;
    public BufferedImage right = null;
    
    public player(int xin, int yin) {
        x = xin;
        y = yin;
        try {
            left = ImageIO.read(new File("src/packing/pacR.png"));
            right = ImageIO.read(new File("src/packing/pac.png"));
            image = left;
        } catch (IOException ex) {
            System.out.println("not found");
        }
    }
    
    public void setX(int xin){
        oldx = x;
        x = xin;
    }
    
    public void setY(int yin){
        oldy = y;
        y = yin;
    }
}
