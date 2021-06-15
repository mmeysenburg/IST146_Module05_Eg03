import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class showing how to read from an online JSON source.
 *
 * @author Mark M. Meysenburg
 * @version 02/19/2021
 */
public class Main {
  /**
   * Application entry point.
   *
   * @param args Command-line arguments; ignored by this application.
   */
  public static void main(String[] args) {
    // URL of the movies JSON file
    String resource = "http://ist.doane.edu/movies.json";

    try {
      // connect a scanner to the URL
      URL url = new URL(resource);
      InputStream is = url.openStream();
      Scanner dataSource = new Scanner(is);

      String json = "";
      String s = null;

      // read lines of the JSON file, appending each to
      // a string
      while (dataSource.hasNext()) {
        s = dataSource.nextLine();
        json += s;
      }

      // convert the string to a JSON object
      JSONObject movieObj = new JSONObject(json);

      // grab the movies JSON array
      JSONArray movieArr = movieObj.getJSONArray("movies");

      // iterate through the JSON array, placing each movie into
      // a Java Movie object
      List<Movie> movieList = new ArrayList<>(movieArr.length());

      for (int i = 0; i < movieArr.length(); i++) {
        JSONObject movie = movieArr.getJSONObject(i);

        // pull out the fields
        String id = movie.getString("id");
        String title = movie.getString("title").toUpperCase();

        // use a try / catch for fields that may have invalid data
        int year = 0;
        try {
          year = Integer.parseInt(movie.getString("year"));
        } catch (NumberFormatException nfe) {
        }

        int time = 0;
        try {
          time = Integer.parseInt(movie.getString("time"));
        } catch (NumberFormatException nfe) {
        }

        // create the Java Movie object and add to the list
        movieList.add(new Movie(id, title, year, time));
      }

      // sort list based on title; note usage of a lambda
      movieList.sort((x, y) -> x.getTitle().compareTo(y.getTitle()));

      // print the movies to the console
      for (Movie m : movieList) {
        System.out.println(m);
      }

    } catch (MalformedURLException mue) {
      System.err.println("Malformed URL");
      System.err.println(mue.getMessage());
    } catch (IOException e) {
      System.err.println("IO exception");
      System.err.println(e.getMessage());
    }
  }
}
