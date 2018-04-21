package oopassignmenttwo;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author schev
 */
public class Comics {
    private String title, publisher, writer, artist; //BOOM!, Marvel, DC, IDW, Image, Dark Horse
    private int collection, volume;
    private double releaseDate;
    private static final String[] majorPublishers = {"Marvel","DC Entertainment",
        "Image Comics", "Dark Horse Comics", "IDW Publishing", "BOOM! Studios", 
        "Archie Comics", "Top Cow"};
    
    /**
     * Constructor for the Comics class instantiating the variables
    * @param title
    * @param publisher
    * @param writer
    * @param artist
    * @param collection
    * @param volume
    * @param releaseDate 
    */
    public Comics(String title, String publisher, String writer, String artist, int collection, int volume, double releaseDate) {
        setTitle(title);
        setPublisher(publisher);
        setWriter(writer);
        setArtist(artist);
        setCollection(collection);
        setVolume(volume);
        setReleaseDate(releaseDate);
    }

    /**
     * get method for title
     * @return 0
     */
    public String getTitle() {
        return title;
    }

    /**
     * set method that will ensure the field is not empty
     * @param title 
     */
    public void setTitle(String title) {
        if (title.isEmpty())
        {
            throw new IllegalArgumentException("Please enter a title.");
        }
        else this.title = title;
    }

    /**
     * get method for publisher
     * @return 
     */
    public String getPublisher() {
        return publisher;
    }
    
    /**
     * set method for the publisher that will verify that the publisher is not
     * empty and one of the valid selections
     * @param publisher 
     */
    public void setPublisher(String publisher) {
        if(publisher == null)
            {
                throw new IllegalArgumentException("Please enter "
                            + "a major publisher option.");
            }
        else if (publisher.isEmpty())
            {
                throw new IllegalArgumentException("Please enter a "
                            + "a publisher's name.");
            }
        else
            for (String validPublisher: majorPublishers)
            {
                if (validPublisher.equals(publisher))
                    {
                       this.publisher = publisher;
                        return;
                    }
            }
             throw new IllegalArgumentException("Please enter a major publisher.");
    }
    
    /**
     * get method for writer
     * @return 
     */
    public String getWriter() {
        return writer;
    }

    /**
     * set method that will ensure the field is not empty
     * @param writer
     */
    public void setWriter(String writer) {
           if (writer.isEmpty())
        {
            throw new IllegalArgumentException("Please enter an writer.");
        }
           else this.writer = writer;
    }

    /**
     * get method for artist
     * @return 
     */
    public String getArtist() {
        return artist;
    }

    /**
     * set method that will ensure the field is not empty
     * @param artist 
     */
    public void setArtist(String artist) {
           if (artist.isEmpty())
        {
            throw new IllegalArgumentException("Please enter an artist.");
        }
           else this.artist = artist;
    }

    /**
     * get method for collection
     * @return 
     */
    public int getCollection() {
        return collection;
    }

    /**
     * set method that will ensure there is a number greater than zero and 
     * below 15
     * @param collection 
     */
    public void setCollection(int collection) {
        if (collection < 0 && collection > 15)
        {
            throw new IllegalArgumentException("Please enter a number between"
                    + "1 and 15.");
        }
        else this.collection = collection;
    }
    
    /**
     *get method for volume 
     * @return 
     */
    public int getVolume() {
        return volume;
    }
    
    /**
     * set method that will ensure there is a non-negative number that is below 
     * 15
     * @param volume 
     */
    public void setVolume(int volume) {
        if (volume <= 0 && volume < 15)
        {
            throw new IllegalArgumentException("Please enter a number between"
                    + "0 and 15.");
        }
        else this.volume = volume;
    }
    
    /**
     * get method for releaseDate
     * @return 
     */
    public double getReleaseDate() {
        return releaseDate;
    }

    /**
     * Set method for the release date that verifies that it ranges from
     * the year of the first comic book to the present date
     * @param releaseDate 
     */
    public void setReleaseDate(double releaseDate) {
        if (releaseDate <= LocalDate.now().getYear() && releaseDate > 1937)
            this.releaseDate = releaseDate;
        else throw new IllegalArgumentException("Please enter a year between"
                + "1937 and the current year.");
    }
    
    /**
     * This method will run through and return the validPublishers so that
     * the ComicsViewController may retrieve them
     */
    public static String[] getPublishers(){
        return majorPublishers;
    }
    
    /**
      * ToString method to save the information as a string
      */
    public String toString()
    {
        return String.format("Title: %s Publisher: %s Writer: %s Artist: %s "
                             + "Collection: %s Volume: %s Release Date: %.4s", 
                            this.title, this.publisher, this.writer, 
                            this.artist, this.collection, this.volume,
                            this.releaseDate);
    }
}
