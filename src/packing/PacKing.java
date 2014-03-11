/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Ben
 */
public class PacKing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        world frame = new world(1);
        frame.setSize(620, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        game g = new game(frame);
    }
}
