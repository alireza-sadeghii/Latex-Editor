package ir.ac.kntu.Coder;

import ir.ac.kntu.LatexReq.Section;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;

/**
 * @author Alireza sadeghi
 * this class write and prepare command for tex file
 */
public class Editor{
    private String fileAdd = "Document.tex";
    private BufferedWriter writer;


    public Editor() {
        try{
            writer = new BufferedWriter(new FileWriter(new File(this.fileAdd)));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * write each of commands that give from other coder methods
     * @param command - String var that pass from other methods
     */
    private void writeCommand(String command){
        try{
            writer.write(command + "\n");
            writer.flush();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    /**
     * this method add document class in latex fiDocumentClasses
     * @param docClass - DocumentClasses is an enum that store some doc classes of Latex
     */
    public void setDocumentClass(String docClass){
        String command = "\\documentclass{" + docClass.toLowerCase() + "}";
        writeCommand(command);
    }


    /**
     * this is a method that add packages for latex file
     * @param packName - name of desired package
     */
    public void addPackage(String packName){
        //todo : maybe need a enum for packages :: check it
        String command = "\\usepackage{" + packName + "}";
        writeCommand(command);
    }


    /**
     * add title to tex file
     * @param title - desired title for document
     */
    public void writeTitle(String title){
        String command = "\\title{" + title + "}";
        writeCommand(command);
    }


    /**
     * add author name
     * @param authorName - document author name
     */
    public void writeAuthor(String authorName){
        String command = "\\author{" + authorName + "}";
        writeCommand(command);
    }


    /**
     * make a date for Latex file
     * @param date - date of making document
     */
    public void writeDate(LocalDate date){
        String command = "\\date{" + (date.equals(LocalDate.now()) ? "\\today" : date) + "}";
        writeCommand(command);
    }

    /**
     * write university or company name for document
     * @param uni - institute name
     */
    public void writeUniversity(String uni){
        String command = "\\affil{" + uni + "}";
        writeCommand(command);
    }

    /**
     * write start command and build titles
     */
    public void prepareEditor(){
        startDocument();
        makeTitle();
    }

    /**
     * starter command
     */
    private void startDocument(){
        String command = "\\begin{document}";
        writeCommand(command);
    }

    /**
     * make a title and author and date for file
     */
    public void makeTitle(){
        String command = "\\maketitle{}";
        writeCommand(command);
    }


    /**
     * write title of section
     * @param title - title of section
     */
    private void writeSectionTitle(String title){
        String command = "\\section{" + title + "}";
        writeCommand(command);
    }

    /**
     * write a paragraph segment of a section
     * @param par - paragraph of section
     */
    private void WriteSectionParagraph(String par){
        writeParagraph(par);
    }

    /**
     * add section in document
     * @param section - desired section that need to write in document
     * @see Section
     */
    public void addSection(Section section){
        writeSectionTitle(section.getTitle());
        WriteSectionParagraph(section.getParagraph());
    }


    /**
     * write a entire paragraph
     * @param inp - text of paragraph
     */
    public void writeParagraph(String inp){
        writeCommand(inp);
    }

    /**
     * close command
     */
    public void closeDocument(){
        String command = "\\end{document}";
        writeCommand(command);
    }

    /**
     * start bibliography segment
     * @param size - number of references
     */
    public void startBiblio(int size){
        String command = "\\begin{thebibliography}{" + size + "}";
        writeCommand(command);
    }

    /**
     * close bibliography segment
     */
    public void closeBiblio(){
        String command = "\\end{thebibliography}";
        writeCommand(command);
    }

    /**
     * add new references for biblio segment
     * @param ref - name of reference
     */
    public void addBiblio(String ref){
        String command = "\\bibitem{texbook}";
        writeCommand(command);
        writeCommand(ref + "\n");
    }
}