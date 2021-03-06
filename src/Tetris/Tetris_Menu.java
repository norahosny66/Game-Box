package Tetris;

import GameLoop.GameBox_Core;
import GameLoop.Games;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Tetris_Menu {

    public static int count_for_back_btn = 0;
    private static VBox text_pane = new VBox(22);
    private static VBox hardness_pane = new VBox(22);
    static Image m = new Image("Resources/Tetris/Effect.png", 470, 750, false, false);
    static ImageView mv = new ImageView(m);
    static ImageView mv2 = new ImageView(m);
    static Pane menu = new Pane();
    public static Scene scene = new Scene(menu, 1370, 750);
    static Button new_game_btn = new Button("New game ");
    static Button help_btn = new Button("How to play");
    static Button back_btn = new Button("Back");
    static Button exit_btn = new Button("Exit");
    static Button easy = new Button("Easy");
    static Button mediam = new Button("Medium");
    static Button hard = new Button("Hard");

    public static Scene start() {

        scene.getStylesheets().add(Tetris_Menu.class.getResource("cs.css").toExternalForm());
        text_pane.getChildren().addAll(new_game_btn, help_btn, back_btn, exit_btn);
        menu.getChildren().addAll(mv, mv2, text_pane);
        mv.setLayoutX(0);
        mv.setLayoutY(0);
        mv2.setLayoutX(1370 - 470);
        mv2.setLayoutY(0);
        menu.setStyle("-fx-background-color: black");

        new_game_btn.setLayoutX(100);
        new_game_btn.setLayoutY(100);

        text_pane.setLayoutX(580);
        text_pane.setLayoutY(180);
        text_pane.setPrefSize(280, 400);

        help_btn.setLayoutX(100);
        help_btn.setLayoutY(150);

        back_btn.setLayoutX(100);
        back_btn.setLayoutY(200);

        exit_btn.setLayoutX(100);
        exit_btn.setLayoutY(250);
        //===============================//
        easy.setLayoutX(100);
        easy.setLayoutY(100);

        hardness_pane.setLayoutX(580);
        hardness_pane.setLayoutY(180);
        hardness_pane.setPrefSize(280, 400);
        mediam.setLayoutX(100);
        mediam.setLayoutY(150);

        hard.setLayoutX(100);
        hard.setLayoutY(200);
        easy.setId("btn");
        mediam.setId("btn");
        hard.setId("btn");
        hardness_pane.getChildren().addAll(easy, mediam, hard);

        easy.setOnAction(e -> {
            Tetris_sound.back_sound();
            Tetris_Main.getInstanceFromTetris().start_Tetris(GameBox_Core.Root, 300);
            GameBox_Core.Root.setScene(Tetris_Main.Tetris_scene);
        });
        mediam.setOnAction(e -> {
            Tetris_sound.back_sound();
            Tetris_Main.getInstanceFromTetris().start_Tetris(GameBox_Core.Root, 200);
            GameBox_Core.Root.setScene(Tetris_Main.Tetris_scene);
        });
        hard.setOnAction(e -> {
            Tetris_sound.back_sound();
            Tetris_Main.getInstanceFromTetris().start_Tetris(GameBox_Core.Root, 150);
            GameBox_Core.Root.setScene(Tetris_Main.Tetris_scene);
        });
        //===============================//
        new_game_btn.setOnAction(e -> {

            menu.getChildren().remove(text_pane);
            menu.getChildren().add(hardness_pane);

        });
        exit_btn.setOnMouseClicked(e -> {

            GameBox_Core.Root.close();

        });
        back_btn.setOnAction(e -> {
            GameBox_Core.Root.setScene(Games.gamesScene);
            count_for_back_btn++;
        });
        help_btn.setOnAction(e -> {
            Help help_obj = new Help();
            GameBox_Core.Root.setScene(help_obj.help_scene);

        });

        exit_btn.setId("btn");
        new_game_btn.setId("btn");
        back_btn.setId("btn");
        help_btn.setId("btn");

        return scene;

    }
}
