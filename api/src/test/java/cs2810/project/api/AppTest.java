package cs2810.project.api;

import static org.junit.Assert.assertEquals;
import static spark.Spark.awaitInitialization;
import static spark.Spark.stop;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

  /**
   *
   * @param endpoint - API endpoint to test.
   * @return Response form the API endpoint.
   * @throws Exception
   */
  protected String getRequest(String endpoint) throws Exception {
    URL url = new URL("http://localhost:4567/api/" + endpoint);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");

    InputStream resp = new BufferedInputStream(connection.getInputStream());

    try (Scanner scanner = new Scanner(resp)) {
      String respBody = scanner.useDelimiter("\\A").next();

      return respBody;
    }
  }

  // Setup the tests.
  @Before
  public void initTests() {
    String[] args = {};
    App.main(args);

    awaitInitialization();
  }

  // Clean up after the tests.
  @After
  public void endTests() throws Exception {
    stop();
  }

  // Test the status endpoint to verify that the API is working.
  @Test
  public void testStatus() {
    String expected = "OK";
    String result = "";

    try {
      result = getRequest("status");
    } catch (Exception e) {
      e.printStackTrace();
    }

    assertEquals("API status should be OK", expected, result);
  }
}
