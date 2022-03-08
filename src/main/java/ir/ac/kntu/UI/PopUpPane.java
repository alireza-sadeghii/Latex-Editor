package ir.ac.kntu.UI;

import ir.ac.kntu.Coder.Informations;
import ir.ac.kntu.Global.Scales;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * @author Alireza Sadeghi
 * @see Informations
 * pop up class for made a popUp pane as package adder and remover
 */
public class PopUpPane {
    private Informations info;
    private String stageTitle;
    private TextField packName;
    private Button action;
    private Button cancel;
    private Pane popUp;
    private Stage stage;


    public PopUpPane(String title, Informations info) {
        this.info = info;
        this.stageTitle = title;
        this.packName = new TextField();
        this.action = new Button(this.stageTitle);
        this.cancel = new Button("Cancel");
    }

    /**
     * make a pop-up stage for add or remove packages from document
     */
    public void makeStage(){
        stage = new Stage();
        stage.setResizable(false);
        popUp = new Pane();
        this.popUp.setPrefHeight(Scales.POP_UP_HEIGHT);
        this.popUp.setPrefWidth(Scales.POP_UP_WIDTH);

        preparePackField();
        preparePackLabel();
        makeButton();
        makeCancelButton();

        stage.setTitle(this.stageTitle);
        stage.setScene(new Scene(popUp));
        stage.show();
    }

    /**
     * make package names text field
     */
    private void preparePackField(){
        this.packName.setLayoutX(Scales.POP_UP_TXT_X);
        this.packName.setLayoutY(Scales.POP_UP_TXT_Y);
        this.packName.setPrefHeight(Scales.POP_UP_TXT_HEIGHT);
        this.packName.setPrefWidth(Scales.POP_UP_TXT_WIDTH);
        this.packName.setPromptText("Package Name");
        this.packName.setAlignment(Pos.CENTER);
        this.popUp.getChildren().add(this.packName);
    }

    /**
     * make label for package text-field
     */
    private void preparePackLabel(){
        Label pack = new Label();
        pack.setText("Package Name");
        pack.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,12));
        pack.setAlignment(Pos.CENTER);
        pack.setLayoutX(Scales.POP_UP_TXT_X + 50);
        pack.setLayoutY(Scales.POP_UP_TXT_Y - 20);
        this.popUp.getChildren().add(pack);
    }

    /**
     * make submit button for add or remove action
     */
    private void makeButton(){
        this.action.setLayoutX(Scales.POP_UP_TXT_X);
        this.action.setLayoutY(Scales.POP_UP_TXT_Y + 50);
        this.action.setPrefHeight(30);
        this.action.setPrefWidth(100);
        this.popUp.getChildren().add(this.action);
        this.action.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                buttonAction();
            }
        });
    }

    /**
     * remove or add a package in base of stage title
     */
    private void buttonAction(){
        if(this.stageTitle.equalsIgnoreCase("add")){
            this.info.addPackage(this.packName.getText());
        }else{
            this.info.removePackage(this.packName.getText());
        }
        closeStage();
    }

    /**
     * make a cancel button for closing a stage
     */
    private void makeCancelButton(){
        this.cancel.setLayoutX(Scales.POP_UP_TXT_X + 110);
        this.cancel.setLayoutY(Scales.POP_UP_TXT_Y + 50);
        this.cancel.setPrefHeight(30);
        this.cancel.setPrefWidth(100);
        this.popUp.getChildren().add(this.cancel);
        this.cancel.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg0) {
                closeStage();
            };
        });
    }

    /**
     * close the pop-up stage
     */
    private void closeStage(){
        this.stage.close();
    }

}
