package com.bhavishay97.connectfour;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static final int COLUMNS = 7;
    private static final int ROWS = 6;
    private static final int CIRCLE_DIAMETER = 80;
    private static final String discColor1 = "#24303e";
    private static final String discColor2 = "#4caa88";

    private static String PLAYER_ONE = "Player 1";
    private static String PLAYER_TWO = "Player 2";

    private boolean isPlayer1Turn = true;

    @FXML
    public GridPane rootGridPane;

    @FXML
    public Pane insertedDiscsPane;

    @FXML
    public Label playerNameLabel;

    public void createPlayground() {
        Shape rectangleWithHoles = getGameGrid();
        rootGridPane.add(rectangleWithHoles, 0, 1);
    }

    private Shape getGameGrid() {
        Shape rectangleWithHoles = new Rectangle((COLUMNS + 1) * CIRCLE_DIAMETER, (ROWS + 1) * CIRCLE_DIAMETER);

        for (int row =0; row < ROWS; row++) {
            for (int col =0; col < COLUMNS; col++) {
                Circle circle = new Circle();
                circle.setRadius(CIRCLE_DIAMETER / 2);
                circle.setCenterX(CIRCLE_DIAMETER / 2);
                circle.setCenterY(CIRCLE_DIAMETER / 2);

                circle.setTranslateX(col * (CIRCLE_DIAMETER + 5) + (CIRCLE_DIAMETER / 4));
                circle.setTranslateY(row * (CIRCLE_DIAMETER + 5) + (CIRCLE_DIAMETER / 4));
                rectangleWithHoles = Shape.subtract(rectangleWithHoles, circle);
            }
        }

        rectangleWithHoles.setFill(Color.WHITE);
        return rectangleWithHoles;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
