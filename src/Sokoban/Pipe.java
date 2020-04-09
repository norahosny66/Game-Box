
package Sokoban;

import static Sokoban.Player.player_imageView;
import javafx.scene.image.ImageView;


public class Pipe {
    
     /*
     *  This Method is used to check if the desired position have a pipe or not
     */
      protected static int checkPipe(int dir_x, int dir_y) {
          int i = 1 ;
        for (ImageView pipe_iv : map.Pipes_Imageviews_Array) {

            if (player_imageView.getX() + dir_x * 50 == pipe_iv.getX()
                    && player_imageView.getY() + dir_y * 50 == pipe_iv.getY()) {
                return i;
            }
            ++i;
        }    
        return 3;
    }
    
     /*
     *  This Method is used to check if the desired position have a pipe or not
     */
      protected static boolean checkIfThereIsABoxNextToThePipe(int desiredX , int desiredY) {

        for (ImageView box_iv : map.Boxes_Imageviews_Array) {

            if (desiredX == box_iv.getX() && desiredY== box_iv.getY()) {
                return true;
            }
        }    
        return false;
    }
}