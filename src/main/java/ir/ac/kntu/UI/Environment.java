package ir.ac.kntu.UI;

import ir.ac.kntu.Coder.Informations;
import ir.ac.kntu.Global.Scales;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * @author Alireza Sadeghi
 * @see Informations
 * the abstract Environment class that make a page with menubar and title label
 */
public abstract class Environment {
    private Informations info;
    private MenuBar menuBar;
    private Pane pane;
    private Label title;

    public Environment(Pane pane, Informations info, String title){
        this.pane = pane;
        this.info = info;
        this.pane.getChildren().clear();
        this.menuBar = new MenuBar();
        this.title = new Label(title);
        prepareTitle();
    }

    /**
     * prepare title of page as a label
     */
    private void prepareTitle(){
        this.title.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,25));
        this.title.setLayoutX(Scales.PANE_TITLE_X - (this.title.getText().length()-3)*10 );
        this.title.setLayoutY(Scales.PANE_TITLE_Y);
        this.pane.getChildren().add(title);
    }

    public Informations getInfo() {
        return info;
    }

    public Pane getPane() {
        return pane;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }
}
