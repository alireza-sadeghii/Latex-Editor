package ir.ac.kntu.UI;

import ir.ac.kntu.Coder.Informations;
import ir.ac.kntu.Global.Scales;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * @author Alireza Sadeghi
 * @see Informations
 * @see Environment
 * biblio environment that inherit from environment class
 */
public class BiblioEnvironment extends Environment{
    private Pane pane;
    private Informations info;
    private MenuBar menuBar;
    private Menu finish;
    private TextArea reference;
    private Button add;

    public BiblioEnvironment(Pane pane, Informations info){
        super(pane, info,"Bibliography");
        this.pane = getPane();
        this.info = getInfo();
        this.menuBar = getMenuBar();
        this.finish = new Menu("Finish");
        this.reference = new TextArea();
        this.add = new Button();
        preparePane();
    }

    /**
     * make menu items and prepare pane
     */
    private void preparePane(){
        makeFileMenu();
        this.menuBar.setPrefSize(Scales.PANE_WIDTH,20);
        this.pane.getChildren().add(this.menuBar);
        prepareRef();
        prepareAdd();
    }

    private void makeFileMenu(){
        prepareFinish();
    }

    /**
     * prepare finish menu item and add to menu bar
     */
    private void prepareFinish(){
        MenuItem save = new MenuItem("Save And Make Tex");
        save.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                flushInformations();
            };
        });
        this.finish.getItems().add(save);
        this.menuBar.getMenus().add(this.finish);
    }

    /**
     * call flush method from informations class
     * @see Informations
     */
    private void flushInformations(){
        this.info.flush();
    }

    /**
     * prepare biblio text area
     */
    private void prepareRef(){
        Label label = new Label("Biblio Item");
        label.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,16));
        label.setLayoutX(Scales.SEC_PAR_X);
        label.setLayoutY(Scales.SEC_PAR_Y - 50);
        this.reference.setLayoutX(Scales.SEC_PAR_X);
        this.reference.setLayoutY(Scales.SEC_PAR_Y - 20);
        this.reference.setPrefHeight(Scales.SEC_PAR_HEIGHT);
        this.reference.setPrefWidth(Scales.SEC_PAR_WIDTH);
        this.pane.getChildren().add(label);
        this.pane.getChildren().add(reference);
    }

    /**
     * prepare add button and add it to pain
     */
    private void prepareAdd(){
        ImageView view = new ImageView(new Image("icon/plus.png"));
        view.setFitHeight(Scales.ADD_SEC_BUTTON_HEIGHT);
        view.setFitWidth(Scales.ADD_SEC_BUTTON_WIDTH);
        this.add.setGraphic(view);
        this.add.setLayoutX(Scales.ADD_SEC_BUTTON_X);
        this.add.setLayoutY(Scales.ADD_SEC_BUTTON_Y + 40);
        this.add.setPrefHeight(Scales.ADD_SEC_BUTTON_HEIGHT);
        this.add.setPrefWidth(Scales.ADD_SEC_BUTTON_WIDTH);
        this.add.setOnAction(e -> {
            addBiblio();
            clearRef();
        });
        this.pane.getChildren().add(this.add);
    }

    /**
     * add new reference to reference arrays in information class
     * @see Informations
     */
    private void addBiblio(){
        if(!this.reference.getText().isEmpty()){
            this.info.addBiblio(this.reference.getText());
        }
    }

    /**
     * clear fields
     */
    private void clearRef(){
        this.reference.clear();
    }

}
