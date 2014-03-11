package packing;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Timer;

public class game implements KeyListener {
    private world w;
    private int afterGame = 0;
    private int levelDelay = 2030; //milliseconds
    private int levelUp = 0;
    public Timer count;
    private ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=1; i < 30 ; i++){
                    for(int j=0; j < 30 ; j++){
                        int r = (int)(Math.random()*12);
                        if (w.grid[i][j] == 4 && r%6 == 0){
                            //start randomly making old coin locations disapear
                            w.grid[i][j] = 2;
                            if(!checkFreeze()){
                                setPac();
                                if(!w.gameEnd){
                                    w.win = "";
                                }
                            }
                        }
                    }
                }
                for(int k=0; k<w.gh.length; k++){
                    try{
                        w.gh[k].ghostMove();
                    } catch(Exception h){
                        
                    }
                }
                if(w.gameEnd){
                    afterGame += 1;
                }
                if (afterGame == 3){
                    System.exit(0);
                }
                if(w.gameLevelUp){
                    levelUp += 1;
                }
                if (levelUp == 3){
                    levelUp = 0;
                    w.gameLevelUp = false;
                    w.win = "";
                    levelSpeedUp();
                    count.start();
                }
                w.repaint();
            }
    };

    public game(world wIn){
        w = wIn;
        w.addKeyListener(this);
        (w.curp = new playSound("src/packing/beat2.wav")).start();
        int levelNum = w.level*2;
        levelDelay = levelDelay - levelNum*100; //milliseconds
        count = new Timer(levelDelay, taskPerformer);
        count.start();
    }
    
    public void gameUpdate(){
        if(w.grid[w.p.x][w.p.y] == 3 || w.grid[w.p.x][w.p.y] == 4){
            //collision with wall or old path
            w.p.setX(w.p.oldx);
            w.p.setY(w.p.oldy);
        } else if (w.grid[w.p.x][w.p.y] == 0) {
            //collision with coin
            w.grid[w.p.x][w.p.y] = 1;
            w.grid[w.p.oldx][w.p.oldy] = 4;
            //(new playSound("src/packing/ding.wav")).start();
            w.p.points++;
            w.points = "Score: "+Integer.toString(w.p.points);
            if (w.p.points == w.zeroCount){
                w.gameOverWin();
            }
            if(checkFreeze()){
                try {
                    w.p.image = ImageIO.read(new File("src/packing/pacFreeze.png"));
                } catch (IOException ex) {
                    System.out.println("not found");
                }
                w.points = "FROZEN!";
                w.messageColor = Color.BLUE;
                w.win = "FROZEN!";
            } else {
                setPac();
            }
        } else if (w.grid[w.p.x][w.p.y] == 2) {
             //collision with black space
            w.grid[w.p.x][w.p.y] = 1;
            w.grid[w.p.oldx][w.p.oldy] = 2;
        } else if (w.grid[w.p.x][w.p.y] == 5) { 
            //collision with ghost
            if(!w.gameEnd){
                w.gameOverDeath();
            }
        }
        w.repaint();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        int tmpy = w.p.y;
        int tmpx = w.p.x;
        switch( keyCode ) { 
            case KeyEvent.VK_UP:
                // handle up
                //System.out.println("Up! "+ w.p.y +"/" + w.p.x +" "+ w.p.oldy +"/"+ w.p.oldx +" ");
                w.p.setY(tmpy-1);
                w.p.setX(tmpx);
                gameUpdate();
                break;
            case KeyEvent.VK_DOWN:
                // handle down 
                //System.out.println("Down! "+ w.p.y +"/" + w.p.x +" "+ w.p.oldy +"/"+ w.p.oldx +" ");
                w.p.setY(tmpy+1);
                w.p.setX(tmpx);
                gameUpdate();
                break;
            case KeyEvent.VK_LEFT:
                // handle left
                //System.out.println("Left! "+ w.p.y +"/" + w.p.x +" "+ w.p.oldy +"/"+ w.p.oldx +" ");
                w.p.setY(tmpy);
                w.p.setX(tmpx-1);
                if(w.p.pacR){
                    w.p.pacR = false;
                }
                gameUpdate();
                break;
            case KeyEvent.VK_RIGHT :
                // handle right
                //System.out.println("Right! "+ w.p.y +"/" + w.p.x +" "+ w.p.oldy +"/"+ w.p.oldx +" ");
                w.p.setY(tmpy);
                w.p.setX(tmpx+1);
                if(!w.p.pacR){
                    w.p.pacR = true;
                }
                gameUpdate();
                break;
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void levelSpeedUp(){
        int levelNum = w.level*2;
        levelDelay = levelDelay - levelNum*100; //milliseconds
        count.stop();
        count = new Timer(levelDelay, taskPerformer);
        (w.curp = new playSound("src/packing/bass.wav")).start();
    }
    
    public boolean checkFreeze(){
        if ( 
            (w.grid[w.p.x][w.p.y+1] == 3 || w.grid[w.p.x][w.p.y+1] == 4 ) && 
            (w.grid[w.p.x-1][w.p.y] == 3 || w.grid[w.p.x-1][w.p.y] == 4 ) && 
            (w.grid[w.p.x][w.p.y] == 1 ) &&
            (w.grid[w.p.x+1][w.p.y] == 3 || w.grid[w.p.x+1][w.p.y] == 4 ) && 
            (w.grid[w.p.x][w.p.y-1] == 3 || w.grid[w.p.x][w.p.y-1] == 4 ) 
            ){
                return true;
        }
        return false;
    }
    
    public void setPac(){
        if(w.p.pacR){
            w.p.image = w.p.left;
        } else {
            w.p.image = w.p.right;
        }
    }
}