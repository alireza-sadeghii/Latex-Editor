package ir.ac.kntu.LatexReq;

/**
 * @author Alireza Sadeghi
 */
public class Section {
    /**
     * title of Section
     */
    private String title;
    /**
     * Text Field of Section
     */
    private String paragraph;

    public Section(String title, String paragraph){
        setTitle(title);
        setParagraph(paragraph);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public String getTitle() {
        return title;
    }

    public String getParagraph() {
        return paragraph;
    }

}
