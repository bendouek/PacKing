/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packing;

/**
 *
 * @author Ben
 */
public class levelOne {
    private static String levelData = 
                "#############################"
            + "\n#############################"
            + "\n#000000000000005#00000000000#"
            + "\n#0000000000######00000000000#"
            + "\n#2222222222#2222222222222222#"
            + "\n#2222222222#5222222222222222#"
            + "\n#2222222222###########222222#"
            + "\n#22222222222222222222#222222#"
            + "\n#22222222222222222222#222222#"
            + "\n#00000000000000000000#000000#"
            + "\n#0000#000000000000000#000000#"
            + "\n#0000#0000000000000000000000#"
            + "\n#0000#0000000000000000000000#"
            + "\n#2222#222222222222222#222222#"
            + "\n#2222#22222222222222##222222#"
            + "\n#2222#222222222222####222222#"
            + "\n#2222#222222222222####222222#"
            + "\n#000000000000000######000000#"
            + "\n#000000000000000000000000000#"
            + "\n#000000000000000000000000000#"
            + "\n#000000000000000000000000000#"
            + "\n#222222222222222222222222222#"
            + "\n#22######22222222222######22#"
            + "\n#2222222222222#2222222222222#"
            + "\n#222222222222###222222222222#"
            + "\n#000000000000000000000000000#"
            + "\n#000000000000000000000000000#"
            + "\n#000000000000000000000000000#"
            + "\n#100000000000000000000000000#"
            + "\n#############################";


    private static String levelData2 = 
                "#############################"
            + "\n#############################"
            + "\n#00000#2#22#2222222220000000#"
            + "\n#00000#2#22222##22###0000000#"
            + "\n#00000##222#22#2#2#2#0000000#"
            + "\n#00000#2#22##2#2#22##0000000#"
            + "\n#00000#2#222222222###0000000#"
            + "\n#000000000000000000000000005#"
            + "\n#####00000000000000##########"
            + "\n#000000000000000000000000000#"
            + "\n#000000000000000000000000000#"
            + "\n#000005000000#00000000000000#"
            + "\n#00000000000###0000000000000#"
            + "\n#0000000000#####000000000000#"
            + "\n#0000#0000000000000000000000#"
            + "\n#0000#0000000000000000000000#"
            + "\n#0000#0000000500000000000000#"
            + "\n#0000#00000#000#000000000000#"
            + "\n#0000#00000#000#000000000000#"
            + "\n#0000#00000#000#000000000000#"
            + "\n#0000000000#000##############"
            + "\n#000000000000000000000000050#"
            + "\n#0000000000000000000000#0000#"
            + "\n#0000000000000000000000#0000#"
            + "\n#0000#0000#########000000000#"
            + "\n#0000#00000000#0000000000000#"
            + "\n#0000#00000000#0000000000000#"
            + "\n#0000000000####0000000000000#"
            + "\n#100000000000000000000000000#"
            + "\n#############################";


        private static String levelData3 = 
                "#############################"
            + "\n#############################"
            + "\n#00000#2#22#2222222220000000#"
            + "\n#00000#2#22222##22###0005000#"
            + "\n#00000##222#22#2#2#2#0050500#"
            + "\n#00000#2#22##2#2#22##0005000#"
            + "\n#00000#2#222222222###0000000#"
            + "\n#00000#2#22#2222222220000000#"
            + "\n#00000#2#22222##22###0000000#"
            + "\n#00000##222#22#2#2#2#0000000#"
            + "\n#00000#2#22##2#2#22##0000000#"
            + "\n#00000#2#222222222###0000000#"
            + "\n#00000000000###0000000000000#"
            + "\n#0000000000#####000000000000#"
            + "\n#0000#0000000000000000000000#"
            + "\n#0000#0000000000000000000000#"
            + "\n#0000#0000000500000000000000#"
            + "\n#00000#2#22#2222222220000000#"
            + "\n#00000#2#22222##22###0000000#"
            + "\n#00000##222#22#2#2#2#0000000#"
            + "\n#00000#2#22##2#2#22##0000000#"
            + "\n#00000#2#222222222###0000000#"
            + "\n#0000000000000000000000#0000#"
            + "\n#0000000000000000000000#0000#"
            + "\n#0000#0000#########000000000#"
            + "\n#0000#00000000#0000000000000#"
            + "\n#0000#00000000#0000000000000#"
            + "\n#0000000000####0000000000000#"
            + "\n#100000000000000000000000000#"
            + "\n#############################";
    
    public static String getlevelOne(){
        return levelData;
    }

    public static String getlevelTwo(){
        return levelData2;
    }

    public static String getlevelThree(){
        return levelData3;
    }
}
