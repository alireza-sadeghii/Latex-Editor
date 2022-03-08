package ir.ac.kntu.UI;

import ir.ac.kntu.Coder.Informations;
import ir.ac.kntu.Global.Scales;
import ir.ac.kntu.LatexReq.DocumentClasses;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * @author Alireza Sadeghi
 * @see Informations
 * starter class that make first page
 */
public class Starter {
    private ComboBox<DocumentClasses> DCBox;
    private TextField titleField;
    private TextField authorField;
    private DatePicker datePick;
    private TextField uniField;
    private Button submit;
    private Pane pane;
    private Informations info;



    public Starter(Informations info) {
        this.pane = new Pane();
        this.DCBox = new ComboBox<DocumentClasses>();
        this.titleField = new TextField();
        this.authorField = new TextField();
        this.datePick = new DatePicker();
        this.uniField = new TextField();
        this.submit = new Button();
        this.info = info;
        preparePane();
    }

    /**
     * make label and prepare picker or fields of page
     */
    private void preparePane(){
        docClassProperties();
        titleProperties();
        authorProperties();
        dateProperties();
        instituteProperties();
        makeSubmitButton();
        this.pane.setPrefHeight(Scales.PANE_HEIGHT);
        this.pane.setPrefWidth(Scales.PANE_WIDTH);
    }

    /**
     * prepare label and field of document class
     */
    private void docClassProperties(){
        makeDCLabel();
        makeDCBox();
    }

    /**
     * prepare label and field of document title
     */
    private void titleProperties(){
        titleMaker();
        makeTitleLabel();
    }

    /**
     * prepare label and field of document author
     */
    private void authorProperties(){
        makeAuthor();
        makeAuthorLabel();
    }

    /**
     * prepare label and field of document date
     */
    private void dateProperties(){
        makeDatePicker();
        makeDateLabel();
    }

    /**
     * prepare label and field of document institute
     */
    private void instituteProperties(){
        makeUniField();
        makeUniLabel();
    }

    /**
     * prepare label of document class combo box
     */
    private void makeDCLabel(){
        Label DC = new Label();
        DC.setText("Select Your Document Class");
        DC.setFont(Font.font("arial",FontWeight.BOLD,FontPosture.REGULAR,12));
        DC.setLayoutY(Scales.DC_COMBO_Y - 20);
        DC.setLayoutX(Scales.DC_COMBO_X + 3);
        this.pane.getChildren().add(DC);
        bulletMaker(Scales.DC_COMBO_X + Scales.DC_COMBO_WIDTH + 5,Scales.DC_COMBO_Y + 2);
        bulletMaker(Scales.DC_COMBO_X - 21,Scales.DC_COMBO_Y + 2);
    }

    /**
     * make a bullet before and after a combo box
     * @param layoutX - x layout of bullet
     * @param layoutY - y layout of bullet
     */
    private void bulletMaker(int layoutX, int layoutY){
        Label bullet = new Label();
        bullet.setText("::");
        bullet.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,18));
        bullet.setLayoutX(layoutX);
        bullet.setLayoutY(layoutY);
        this.pane.getChildren().add(bullet);
    }

    /**
     * add document classes to a combo box
     * @see DocumentClasses
     */
    private void makeDCBox(){
        for(DocumentClasses DC : DocumentClasses.values()){
            this.DCBox.getItems().add(DC);
        }
        this.DCBox.setLayoutX(Scales.DC_COMBO_X);
        this.DCBox.setLayoutY(Scales.DC_COMBO_Y);
        this.DCBox.setPrefHeight(Scales.DC_COMBO_HEIGHT);
        this.DCBox.setPrefWidth(Scales.DC_COMBO_WIDTH);
        this.DCBox.getSelectionModel().select(DocumentClasses.ARTICLE);
        this.DCBox.setPromptText("Document Class");
        this.pane.getChildren().add(this.DCBox);
    }

    /**
     * set properties of author text field and add to pane
     */
    private void titleMaker(){
        this.titleField.setPromptText("Document Title");
        this.titleField.setAlignment(Pos.CENTER);
        this.titleField.setLayoutX(Scales.TITLE_X);
        this.titleField.setLayoutY(Scales.TITLE_Y);
        this.titleField.setPrefHeight(Scales.TITLE_HEIGHT);
        this.titleField.setPrefWidth(Scales.TITLE_WIDTH);
        this.pane.getChildren().add(this.titleField);
    }

    /**
     * add label and bullet for author text field
     */
    private void makeTitleLabel(){
        Label title = new Label();
        title.setText("Enter Title Of Document");
        title.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,12));
        title.setLayoutX(Scales.TITLE_X + 18);
        title.setLayoutY(Scales.TITLE_Y - 20);
        this.pane.getChildren().add(title);
        bulletMaker(Scales.TITLE_X + Scales.TITLE_WIDTH + 5,Scales.TITLE_Y + 2);
        bulletMaker(Scales.TITLE_X - 21,Scales.TITLE_Y + 2);
    }

    /**
     * this method make a author text field and add it to pane
     */
    private void makeAuthor(){
        this.authorField.setPromptText("Author Name");
        this.authorField.setAlignment(Pos.CENTER);
        this.authorField.setLayoutX(Scales.AUTHOR_X);
        this.authorField.setLayoutY(Scales.AUTHOR_Y);
        this.authorField.setPrefHeight(Scales.AUTHOR_HEIGHT);
        this.authorField.setPrefWidth(Scales.AUTHOR_WIDTH);
        this.pane.getChildren().add(this.authorField);
    }

    /**
     * make bullet and label for author text field
     */
    private void makeAuthorLabel(){
        Label author = new Label();
        author.setText("Enter Name Of Author");
        author.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,12));
        author.setLayoutX(Scales.AUTHOR_X + 25);
        author.setLayoutY(Scales.AUTHOR_Y - 20);
        this.pane.getChildren().add(author);
        bulletMaker(Scales.AUTHOR_X + Scales.AUTHOR_WIDTH + 5,Scales.AUTHOR_Y + 2);
        bulletMaker(Scales.AUTHOR_X - 21,Scales.AUTHOR_Y + 2);
    }

    /**
     * make a datePicker and add it to pane
     */
    private void makeDatePicker(){
        this.datePick.setLayoutX(Scales.DATE_X);
        this.datePick.setLayoutY(Scales.DATE_Y);
        this.datePick.setPrefHeight(Scales.DATE_HEIGHT);
        this.datePick.setPrefWidth(Scales.DATE_WIDTH);
        this.datePick.setPromptText("Document Date");
        this.datePick.getEditor().setAlignment(Pos.CENTER);
        this.datePick.setShowWeekNumbers(true);
        this.pane.getChildren().add(this.datePick);
    }

    /**
     * add bullet and label for date picker
     */
    private void makeDateLabel(){
        Label date = new Label();
        date.setText("Select Your Desired Date");
        date.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,12));
        date.setLayoutX(Scales.DATE_X + 13);
        date.setLayoutY(Scales.DATE_Y - 20);
        this.pane.getChildren().add(date);
        bulletMaker(Scales.DATE_X + Scales.DATE_WIDTH + 5, Scales.DATE_Y + 2);
        bulletMaker(Scales.DATE_X - 21, Scales.DATE_Y + 2);
    }

    /**
     * make university or company name field
     */
    private void makeUniField(){
        this.uniField.setPromptText("Company Or University");
        this.uniField.setAlignment(Pos.CENTER);
        this.uniField.setLayoutX(Scales.UNI_X);
        this.uniField.setLayoutY(Scales.UNI_Y);
        this.uniField.setPrefHeight(Scales.UNI_HEIGHT);
        this.uniField.setPrefWidth(Scales.UNI_WIDTH);
        this.pane.getChildren().add(this.uniField);
    }

    /**
     * prepare label of institute field
     */
    private void makeUniLabel(){
        Label uni = new Label();
        uni.setText("Enter University Name");
        uni.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,12));
        uni.setLayoutX(Scales.UNI_X + 18);
        uni.setLayoutY(Scales.UNI_Y - 20);
        this.pane.getChildren().add(uni);
        bulletMaker(Scales.UNI_X + Scales.UNI_WIDTH + 5 , Scales.UNI_Y + 2);
        bulletMaker(Scales.UNI_X - 21, Scales.UNI_Y + 2);
    }

    /**
     * prepare submit button
     */
    private void makeSubmitButton(){
        this.submit.setLayoutY(Scales.SUBMIT_Y);
        this.submit.setLayoutX(Scales.SUBMIT_X);
        this.submit.setPrefHeight(Scales.SUBMIT_HEIGHT);
        this.submit.setPrefWidth(Scales.SUBMIT_WIDTH);
        this.submit.setText("Submit");
        this.submit.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,12));
        this.submit.setOnAction(e -> submitAction());
        this.pane.getChildren().add(this.submit);
    }

    /**
     * handle set on action of submit button
     */
    private void submitAction(){
        this.info.setDocClass(this.DCBox.getSelectionModel().getSelectedItem().toString());
        this.info.setTitle(this.titleField.getText());
        this.info.setAuthor(this.authorField.getText());
        this.info.setDate(this.datePick.getValue());
        this.info.setUniversity(this.uniField.getText());
        new DevEnvironment(this.pane,this.info);
    }


    /**
     * @return Pane
     */
    public Pane getPane() {
        return pane;
    }
}
