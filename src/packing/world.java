/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packing;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;

/**
 *
 * @author Ben
 */
public class world extends JFrame{
    
    levelOne lev = new levelOne();
    public String levelData; 
    public static int scale = 20;
    public int grid[][] = new int[64][64];
    public int zeroCount = 0;
    public player p = new player(0,0);
    public String points = "Score: 0";
    public String win = "";
    public boolean gameEnd = false;
    public Color messageColor = Color.BLUE;
    public ghost[] gh = new ghost[10];
    public playSound curp;
    public int level;
    public boolean gameLevelUp = false;
    
    private coin c = new coin(0,0);
    private wall w = new wall(0,0);
    
    
    public world (int levNum) { 
        level = levNum;
        if(level == 1){
          levelData = lev.getlevelOne(); 
        }
        else if (level == 2){
          levelData = lev.getlevelTwo(); 
        }
         else if (level == 3){
          levelData = lev.getlevelThree(); 
        }
        loadGrid();
    }
    
    public void paint(Graphics g){
        //g.clearRect(0, 0, 620, 620);
        int k = 0;
        for(int i=1; i < 30 ; i++){
            for(int j=0; j < 30 ; j++){
                Graphics2D g1 = (Graphics2D)g;
                if (grid[i][j] == 3){
                    g1.drawImage(w.image, i*scale, j*scale+30, null);
                } else if (grid[i][j] == 2){
                    g1.setPaint(Color.black);
                    Rectangle2D rect = new Rectangle2D.Double(i*scale,j*scale+30,scale,scale);
                    g1.draw(rect);
                    g1.fill(rect);
                } else if (grid[i][j] == 1){
                    g1.drawImage(p.image, i*scale, j*scale+30, null);
                } else if (grid[i][j] == 0){
                    g1.drawImage(c.image, i*scale, j*scale+30, null);
                } else if (grid[i][j] == 4){
                    g1.drawImage(c.imageExp, i*scale, j*scale+30, null);
                } else if (grid[i][j] == 5){
                    g1.drawImage(gh[k].image, i*scale, j*scale+30, null);
                    k++;
                }
            }
        } 
        Graphics2D g2 = (Graphics2D)g;
        g2.setPaint(Color.RED);
        Font f = new Font( "Impact", Font.BOLD, 22);
        g2.setFont(f);
        g2.setColor(Color.RED);
        g2.drawString(points, 450, 50);
        
        g2.setPaint(messageColor);
        Font f2 = new Font( "Impact", Font.BOLD, 80);
        g2.setFont(f2);
        g2.setColor(messageColor);
        g2.drawString(win, 180, 260);
    }
    
    
    
    public void loadGrid(){
        int curx = 0;
        int cury = 0;
        int k = 0;
        for(int i=0; i < levelData.length() ; i++){
              if (levelData.charAt(i) == '\n'){
                  curx = 0;
                  cury++;
              } else {
                  curx++;                  
                  if (levelData.charAt(i) == '#'){
                      grid[curx][cury] = 3;
                  } else if (levelData.charAt(i) == '0'){
                      grid[curx][cury] = 0;
                      zeroCount++;
                  } else if (levelData.charAt(i) == '2'){
                      grid[curx][cury] = 2;
                  }else if (levelData.charAt(i) == '1'){
                      grid[curx][cury] = 1;
                      p.setX(curx);
                      p.setY(cury);
                  } else if (levelData.charAt(i) == '5'){
                      grid[curx][cury] = 5;
                      gh[k] = new ghost(curx,cury,this);
                      gh[k].setX(curx);
                      gh[k].setY(cury);
                      k++;
                  }
              }            
        }
    }
    
    public void gameOverWin(){
        if(level == 1){
            levelData = lev.getlevelTwo(); 
            levelUp();
        } 
        else if(level == 2){
            levelData = lev.getlevelThree(); 
            levelUp();
        }
        else {
          points = "You Win!";
          messageColor = Color.RED;
          win = "You Win!";
          gameEnd = true;
          curp.interrupt();
          (new playSound("src/packing/win.wav")).start();
        }
    }

    public void levelUp(){
      loadGrid();
      level += 1;
      win = "LEVEL UP!";
      messageColor = Color.RED;
      gameLevelUp = true;
    }
    
    public void gameOverDeath(){
        messageColor = Color.RED;
        points = "Looser!";
        win = "Death!";
        gameEnd = true;
        curp.interrupt();
        (new playSound("src/packing/lose.wav")).start();
        for(int i=1; i < 30 ; i++){
            for(int j=0; j < 30 ; j++){
                grid[i][j] = 3;
            }
        }
    }
    
}
