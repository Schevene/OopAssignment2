/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopassignmenttwo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author schev
 */
public class ComicsTest {
    Comics comic;
    public ComicsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
     comic = new Comics("Ms. Marvel", "Marvel", "G. Willow Wilson", 
        "Adrian Alphona", 4, 1, 2014);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTitle method, of class Comics.
     */
    @Test
    public void testGetTitle() {
        String expResult = "Ms. Marvel";
        String result = comic.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class Comics.
     */
    @Test
    public void testSetTitle() {
        String title = "Ms. Marvel";
        comic.setTitle(title);
    }
    
    /**
     * Test of the setTitle method with invalid input
     */
    @Test
    public void testSetTitleInvalid(){
        try{
            comic.setTitle("");
            fail("An empty title should have triggered an exception");
        }catch(IllegalArgumentException error){
            System.out.printf("Empty title: %s%n", error.getMessage());
        }
    }

    /**
     * Test of getPublisher method, of class Comics.
     */
    @Test
    public void testGetPublisher() {
        String expResult = "Marvel";
        String result = comic.getPublisher();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPublisher method, of class Comics.
     */
    @Test
    public void testSetPublisher() {
        String publisher = "Marvel";
        comic.setPublisher(publisher);
    }
    
    /**
     * Test of setPublisher with empty input
     */
     @Test
    public void testSetPublisherInvalidEmpty(){
        try{
            comic.setPublisher("");
            fail("An empty publisher should have triggered an exception");
        }catch(IllegalArgumentException error){
            System.out.printf("Empty publisher: %s%n", error.getMessage());
        }
    }
    
      /**
     * Test of setPublisher with null
     */
     @Test
    public void testSetPublisherInvalidNull(){
        try{
            comic.setPublisher(null);
            fail("A null publisher should have triggered an exception");
        }catch(IllegalArgumentException error){
            System.out.printf("Null publisher: %s%n", error.getMessage());
        }
    }
    
      /**
     * Test of setPublisher with a publisher not in the array
     */
     @Test
    public void testSetPublisherInvalid(){
        try{
            comic.setPublisher("Nothing");
            fail("An invalid publisher should have triggered an exception");
        }catch(IllegalArgumentException error){
            System.out.printf("Invalid publisher: %s%n", error.getMessage());
        }
    }

    /**
     * Test of getWriter method, of class Comics.
     */
    @Test
    public void testGetWriter() {
        String expResult = "G. Willow Wilson";
        String result = comic.getWriter();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWriter method, of class Comics.
     */
    @Test
    public void testSetWriter() {
        String writer = "G. Willow Wilson";
        comic.setWriter(writer);
    }
    
    /**
    * Test of setWriter with an empty value
    */
    @Test
    public void testSetWriterInvalid(){
        try{
            comic.setWriter("");
            fail("An empty writer should have triggered an exception");
        }catch(IllegalArgumentException error){
            System.out.printf("Empty writer: %s%n", error.getMessage());
        }
    }

    /**
     * Test of getArtist method, of class Comics.
     */
    @Test
    public void testGetArtist() {
        String expResult = "Adrian Alphona";
        String result = comic.getArtist();
        assertEquals(expResult, result);
    }

    /**
     * Test of setArtist method, of class Comics.
     */
    @Test
    public void testSetArtist() {
        String artist = "Adrian Alphona";
        comic.setArtist(artist);
    }
    
    /**
    * Test of setArtist with an empty value
    */
    @Test
    public void testSetArtistInvalid(){
        try{
            comic.setArtist("");
            fail("An empty artist should have triggered an exception");
        }catch(IllegalArgumentException error){
            System.out.printf("Empty artist: %s%n", error.getMessage());
        }
    }

    /**
     * Test of getCollection method, of class Comics.
     */
    @Test
    public void testGetCollection() {
        int expResult = 4;
        int result = comic.getCollection();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCollection method, of class Comics.
     */
    @Test
    public void testSetCollection() {
        int collection = 4;
        comic.setCollection(collection);
    }
    
    /**
    * Test of setCollection with a value not in the acceptable range
    */
    @Test
    public void testSetCollectionInvalid(){
        try{
            comic.setCollection(-1);
            fail("A negative should have triggered an exception because it is"
                    + "not within the acceptable range");
        }catch(IllegalArgumentException error){
            System.out.printf("Invalid collection: %s%n", error.getMessage());
        }
    }

    /**
     * Test of getVolume method, of class Comics.
     */
    @Test
    public void testGetVolume() {
        int expResult = 1;
        int result = comic.getVolume();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVolume method, of class Comics.
     */
    @Test
    public void testSetVolume() {
        int volume = 1;
        comic.setVolume(volume);
    }
    
    /**
    * Test of setVolume with a value not in the acceptable range
    */
    @Test
    public void testSetVolumeInvalid(){
        try{
            comic.setVolume(-1);
            fail("A negative should have triggered an exception because it is"
                    + "not within the acceptable range");
        }catch(IllegalArgumentException error){
            System.out.printf("Invalid volume: %s%n", error.getMessage());
        }
    }

    /**
     * Test of getReleaseDate method, of class Comics.
     */
    @Test
    public void testGetReleaseDate() {
        double expResult = 2014;
        double result = comic.getReleaseDate();
        assertEquals(expResult, result, 2014);
    }

    /**
     * Test of setReleaseDate method, of class Comics.
     */
    @Test
    public void testSetReleaseDate() {
        double releaseDate = 2014;
        comic.setReleaseDate(releaseDate);
    }
    
    /**
    * Test of setReleaseDate with a value not in the acceptable range
    */
    @Test
    public void testSetReleaseDateInvalid(){
        try{
            comic.setReleaseDate(1895);
            fail("An integer not within the acceptable range should "
                    + "have triggered an exception");
        }catch(IllegalArgumentException error){
            System.out.printf("Invalid release date: %s%n", error.getMessage());
        }
    }

    /**
     * Test of getPublishers method, of class Comics.
     */
    @Test
    public void testGetPublishers() {
        String[] expResult = {"Marvel","DC Entertainment",
        "Image Comics", "Dark Horse Comics", "IDW Publishing", "BOOM! Studios", 
        "Archie Comics", "Top Cow"};
        String[] result = Comics.getPublishers();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Comics.
     */
    @Test
    public void testToString() {
        String expResult = "Title: Ms. Marvel Publisher: Marvel Writer: "
                + "G. Willow Wilson Artist: Adrian Alphona Collection: 4 "
                + "Volume: 1 Release Date: 2014";
        String result = comic.toString();
        assertEquals(expResult, result);
    }
}
