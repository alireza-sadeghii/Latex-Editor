package ir.ac.kntu;

import ir.ac.kntu.Coder.Informations;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alireza SAdeghi
 * @see Informations
 * Test class for test pack and biblio adding and removing
 */
public class LatexTest {
    private Informations testInfo = new Informations();

    /**
     * test add a new package to informations class
     * @see Informations
     */
    @Test
    public void packAdding(){
        this.testInfo.addPackage("authblk");
        assertEquals(1,this.testInfo.getPackSize());
    }

    /**
     * test add a duplicate package to informations class
     * @see Informations
     */
    @Test
    public void duplicatePackAdding(){
        this.testInfo.addPackage("authblk");
        this.testInfo.addPackage("authblk"); // It should not add duplicate packages
        assertEquals(1,this.testInfo.getPackSize());
    }

    /**
     * test remove package from informations class
     * @see Informations
     */
    @Test
    public void packRemoving(){
        this.testInfo.addPackage("authblk");
        this.testInfo.removePackage("authblk");
        assertEquals(0,this.testInfo.getPackSize());
    }

    /**
     * test adding a new biblio to informations class
     * @see Informations
     */
    @Test
    public void biblioAdding(){
        this.testInfo.addBiblio("Test reference");
        this.testInfo.addBiblio("Second reference");
        assertEquals(2,this.testInfo.getBiblioSize());
    }
}
