package ir.ac.kntu.LatexReq;

/**
 * @author Alireza Sadeghi
 * store some classe for tex file
 */
public enum DocumentClasses {
    REPORT , ARTICLE , BOOK , MEMOIR , BEAMER , PROC;

    @Override
    public String toString() {
        return super.toString().charAt(0) + super.toString().substring(1).toLowerCase();
    }
}
