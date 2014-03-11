/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packing;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Ben
 */
public class coin {
    public int x = 0;
    public int y = 0;
    public BufferedImage image = null;
    public BufferedImage imageExp = null;
    
    public coin(int xin, int yin) {
        x = xin;
        y = yin;
        try {
            image = ImageIO.read(new File("src/packing/coin.png"));
        } catch (IOException ex) {
            System.out.println("not found");
        }
        
        try {
            imageExp = ImageIO.read(new File("src/packing/coinExp.png"));
        } catch (IOException ex) {
            System.out.println("not found");
        }
    }
}
