/**
 * Class representing a movie.
 */
public class Movie {
    /** IMDB ID of the movie. */
    private String id;

    /** Title of the movie. */
    private String title;

    /** Year the movie was made. */
    private int year;

    /** Runtime of the movie, in minutes. */
    private int time;

    /**
     * Default constructor. Set string fields to n/a
     * and integer fields to zero.
     */
    public Movie() {
        setId("n/a");
        setTitle("n/a");
        setYear(0);
        setTime(0);
    }

    /**
     * Initializing constructor. Set fields according to the
     * parameters below.
     *
     * @param id IMDB ID of the movie
     * @param title Movie title
     * @param year Year movie was made
     * @param time Runtime of the movie, in minutes
     */
    public Movie(String id, String title, int year, int time) {
        this.setId(id);
        this.setTitle(title);
        this.setYear(year);
        this.setTime(time);
    }

    @Override
    public String toString() {
        return getTitle() + " (" + getYear() + "): " + getTime() +" min.";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
