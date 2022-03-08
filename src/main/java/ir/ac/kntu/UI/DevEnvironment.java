package ir.ac.kntu.UI;

import ir.ac.kntu.Coder.Informations;
import ir.ac.kntu.Global.Scales;
import ir.ac.kntu.LatexReq.Section;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * @author Alireza Sadeghi
 * @see Environment
 * @see Informations
 * development environment that inherit from environment class
 */
public class DevEnvironment extends Environment {
    private Informations info;
    private MenuBar menuBar;
    private Menu packages;
    private Menu biblio;
    private Button addSection;
    private TextField secTitle;
    private TextArea secPargraph;
    private Pane pane;

    public DevEnvironment(Pane pane, Informations info) {
        super(pane, info,"Sections");
        this.info = getInfo();
        this.pane = getPane();
        this.menuBar = getMenuBar();
        this.packages = new Menu("Package");
        this.biblio = new Menu("Bibliography");
        this.addSection = new Button();
        this.secTitle = new TextField();
        this.secPargraph = new TextArea();
        preparePane();
    }

    /**
     * make menu items and prepare pane
     */
    private void preparePane(){
        makeFileMenu();
        this.menuBar.setPrefSize(Scales.PANE_WIDTH,20);
        this.pane.getChildren().add(this.menuBar);
    }

    private void makeFileMenu(){
        addPackage();
        removePackage();
        this.menuBar.getMenus().add(this.packages);
        finishEditor();
        this.menuBar.getMenus().add(this.biblio);
        prepareSecTitle();
        prepareSecParagraph();
        prepareAddSection();
        prepareLineGuide();
    }

    /**
     * extend add item in package menu for adding a new package to document
     */
    private void addPackage(){
        MenuItem add = new MenuItem("Add Package");
        add.setOnAction(e -> addPopUp("Add"));
        this.packages.getItems().add(add);
    }

    /**
     * extend remove item in package menu for removing a package from document
     */
    private void removePackage(){
        MenuItem remove = new MenuItem("Remove Package");
        remove.setOnAction(e -> addPopUp("Remove"));
        this.packages.getItems().add(remove);
    }

    /**
     * make a popup stage for remove or add package
     * @param type - type of pop up stage for remove or add
     * @see PopUpPane
     */
    private void addPopUp(String type){
        PopUpPane popUp = new PopUpPane(type,this.info);
        popUp.makeStage();
    }

    /**
     * Save all sections and go to biblio page
     */
    private void finishEditor(){
        MenuItem make = new MenuItem("Finish and Make Biblio");
        make.setOnAction(e -> makeBiblio());
        this.biblio.getItems().add(make);
    }

    /**
     * @see BiblioEnvironment
     */
    private void makeBiblio(){
        new BiblioEnvironment(pane, info);
    }

    /**
     * prepare section title text field
     */
    private void prepareSecTitle(){
        Label title = new Label("Section Title");
        title.setLayoutX(Scales.SEC_TITLE_X);
        title.setLayoutY(Scales.SEC_TITLE_Y - 20);
        title.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,12));
        this.pane.getChildren().add(title);
        this.secTitle.setLayoutX(Scales.SEC_TITLE_X);
        this.secTitle.setLayoutY(Scales.SEC_TITLE_Y);
        this.secTitle.setPrefHeight(Scales.SEC_TITLE_HEIGHT);
        this.secTitle.setPrefWidth(Scales.SEC_TITLE_WIDTH);
        this.pane.getChildren().add(this.secTitle);
    }

    /**
     * prepare paragraph text field for sections
     */
    private void prepareSecParagraph(){
        Label par = new Label("Section Paragraph");
        par.setLayoutY(Scales.SEC_PAR_Y - 20);
        par.setLayoutX(Scales.SEC_PAR_X);
        par.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,12));
        this.pane.getChildren().add(par);
        this.secPargraph.setLayoutX(Scales.SEC_PAR_X);
        this.secPargraph.setLayoutY(Scales.SEC_PAR_Y);
        this.secPargraph.setPrefHeight(Scales.SEC_PAR_HEIGHT);
        this.secPargraph.setPrefWidth(Scales.SEC_PAR_WIDTH);
        this.pane.getChildren().add(this.secPargraph);
    }

    /**
     * prepare add button for adding a new section
     */
    private void prepareAddSection(){
        ImageView view = new ImageView(new Image("icon/plus.png"));
        view.setFitHeight(Scales.ADD_SEC_BUTTON_HEIGHT);
        view.setFitWidth(Scales.ADD_SEC_BUTTON_WIDTH);
        this.addSection.setGraphic(view);
        this.addSection.setLayoutY(Scales.ADD_SEC_BUTTON_Y);
        this.addSection.setLayoutX(Scales.ADD_SEC_BUTTON_X);
        this.addSection.setPrefHeight(Scales.ADD_SEC_BUTTON_HEIGHT);
        this.addSection.setPrefWidth(Scales.ADD_SEC_BUTTON_WIDTH);
        this.addSection.setOnAction(e -> {
            addSecAction();
            clearTextFields();
        });
        this.pane.getChildren().add(this.addSection);
    }

    /**
     * @see Section
     * add a new section for document
     */
    private void addSecAction(){
        Section newSection;
        if(!this.secTitle.getText().isEmpty() && !this.secPargraph.getText().isEmpty()){
            newSection = new Section(this.secTitle.getText(), this.secPargraph.getText());
            this.info.addSection(newSection);
        }
    }

    /**
     * clear text fields
     */
    private void clearTextFields(){
        this.secTitle.clear();
        this.secPargraph.clear();
    }

    /**
     * prepare a guideline for insert new line in section paragraph
     */
    private void prepareLineGuide(){
        String ch = "\\\\";
        Label guide = new Label("* To Insert A new Line Use \" " + ch + " \" Character *");
        guide.setLayoutX(Scales.SEC_TITLE_X);
        guide.setLayoutY(Scales.SEC_PAR_Y + Scales.SEC_PAR_HEIGHT + 5);
        guide.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,12));
        this.pane.getChildren().add(guide);
    }
}
