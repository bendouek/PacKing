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
public class ghost {
    public int x = 0;
    public int y = 0;
    public int oldx = 0;
    public int oldy = 0;
    public int oldp = 0;
    public int newp = 0;
    public int points = 0;
    public BufferedImage image = null;
    private world w;
    
    public ghost(int xin, int yin, world wIn) {
        x = xin;
        y = yin;
        w = wIn;
        try {
            image = ImageIO.read(new File("src/packing/ghost.png"));
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
    
    public void ghostMove() throws Exception {
        oldp = newp;
        int tmpx = x;
        int tmpy = y;
        
        if(w.p.x > x && w.grid[tmpx+1][tmpy] != 3 && w.grid[tmpx+1][tmpy] != 5){
            tmpx+=1;
        } else if (w.p.x < x && w.grid[tmpx-1][tmpy] != 3 && w.grid[tmpx-1][tmpy] != 5){
            tmpx-=1;
        }
        
        if(w.p.y > y && w.grid[tmpx][tmpy+1] != 3 && w.grid[tmpx][tmpy+1] != 5 ){
            tmpy+=1;
        } else if (w.p.y < y && w.grid[tmpx][tmpy-1] != 3 && w.grid[tmpx][tmpy-1] != 5){
            tmpy-=1;
        }
        
        setX(tmpx);
        setY(tmpy);
        if(tmpx != oldx || tmpy != oldy){
            newp = w.grid[tmpx][tmpy];
        }
        if(w.grid[tmpx][tmpy] == 1){
            if(!w.gameEnd){
                w.gameOverDeath();
            }
        }
        w.grid[oldx][oldy] = oldp;
        w.grid[x][y] = 5;
    }
}
