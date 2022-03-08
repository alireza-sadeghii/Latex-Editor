package ir.ac.kntu.Coder;

import ir.ac.kntu.LatexReq.Section;

import java.time.LocalDate;
import java.util.ArrayList;


/**
 * @author Alireza Sadeghi
 * @see Editor
 * this class store all segments and biblio and others for tex file
 */
public class Informations {
    private String docClass;
    private String title;
    private String author;
    private LocalDate date;
    private String university;
    private ArrayList<String> packages;
    private ArrayList<Section> sections;
    private ArrayList<String> biblios;
    private Editor editor;


    public Informations() {
        this.packages = new ArrayList<>();
        addPackage("authblk");
        this.sections = new ArrayList<>();
        this.biblios = new ArrayList<>();
    }

    /**
     * write all commands and segments on tex file
     */
    public void flush(){
        this.editor = new Editor();
        this.editor.setDocumentClass(this.docClass);
        includePackages();
        this.editor.writeTitle(this.title);
        this.editor.writeAuthor(this.author);
        this.editor.writeUniversity(this.university);
        this.editor.writeDate(this.date);
        this.editor.prepareEditor();
        mountSections();
        makeBiblios();
        this.editor.closeDocument();
        compileTex();
    }

    /**
     * convert tex file to pdf file in base of os
     */
    private void compileTex(){
        try{
            String os = System.getProperty("os.name");
            if (os.equalsIgnoreCase("Linux")){
                Runtime.getRuntime().exec("./compile.sh");
            }else{
                Runtime.getRuntime().exec("cmd /c start compile.bat");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * write packages in tex
     */
    private void includePackages(){
        for(String packName : packages){
            this.editor.addPackage(packName);
        }
    }

    /**
     * write sections
     */
    private void mountSections(){
        for(Section section : this.sections){
            this.editor.addSection(section);
        }
    }

    /**
     * write bibliography segment
     */
    private void makeBiblios(){
        this.editor.startBiblio(this.biblios.size());
        for(String ref : this.biblios){
            this.editor.addBiblio(ref);
        }
        this.editor.closeBiblio();
    }


    /**
     * set document class
     * @param docClass - desired document class for document
     */
    public void setDocClass(String docClass) {
        this.docClass = docClass;
    }


    /**
     * set title of document
     * @param title - document title
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * set author of document
     * @param author - document author name
     */
    public void setAuthor(String author) {
        this.author = author;
    }


    /**
     * set date of document preparation
     * @param date - document date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }


    /**
     * add package for a document
     * @param packName - desired package name
     */
    public void addPackage(String packName){
        if(this.packages.contains(packName)){
            return;
        }
        this.packages.add(packName);
    }


    /**
     * remove package from document
     * @param packName - desired package name
     */
    public void removePackage(String packName){
        this.packages.remove(packName);
    }


    /**
     * set your institute name
     * @param university - institute name
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * add new Section
     * @see Section
     * @param section - new section
     */
    public void addSection(Section section){
        this.sections.add(section);
    }

    /**
     * make a biblio item for document
     * @param ref - reference name
     */
    public void addBiblio(String ref){
        this.biblios.add(ref);
    }

    /**
     * a getter method for test package adding
     * @return size of package array
     */
    public int getPackSize(){
        return this.packages.size();
    }

    /**
     * a getter method for test biblio adding
     * @return size of biblio array
     */
    public int getBiblioSize(){
        return this.biblios.size();
    }

}
