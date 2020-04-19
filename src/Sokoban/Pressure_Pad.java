package Sokoban;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pressure_Pad {

    private static Image boxOnPad = new Image("Resources/Sokoban/crate_39.png", 50, 50, true, true);
    private static ImageView boxOnPad_iv = new ImageView();
    protected static int pressure_pad_posX;
    protected static int pressure_pad_posY;

    protected void check_pad_isPressed() {

        boolean BoxOnPad = checkBoxOnPad();
        boolean PlayerOnPad = checkPlayerOnPad();

        if (BoxOnPad) {
           boxOnPad_iv.setImage(boxOnPad);
           boxOnPad_iv.setX(pressure_pad_posX);
           boxOnPad_iv.setY(pressure_pad_posY);
           Sokoban_Main.root.getChildren().add(boxOnPad_iv);
        }else{
             Sokoban_Main.root.getChildren().remove(boxOnPad_iv);
        }

        if (BoxOnPad || PlayerOnPad) {
            openGates();
        } else {
            closeGates();
        }
    }

    private static void openGates() {
        for (ImageView gate_iv : Map.Gates_Imageviews_Array) {
            gate_iv.setImage(null);
        }
    }

    private static void closeGates() {
        for (ImageView gate_iv : Map.Gates_Imageviews_Array) {
            gate_iv.setImage(Map.gate);
        }
    }

    private static boolean checkBoxOnPad() {
        for (ImageView box_iv : Map.Boxes_Imageviews_Array) {

            if (pressure_pad_posX == box_iv.getX() && pressure_pad_posY == box_iv.getY()) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkPlayerOnPad() {
        System.out.println(Player.player_imageView.getX() + "  " + Player.player_imageView.getY());
        if (Player.player_imageView.getX() == pressure_pad_posX && Player.player_imageView.getY() == pressure_pad_posY) {
            return true;
        }
        return false;
    }

}