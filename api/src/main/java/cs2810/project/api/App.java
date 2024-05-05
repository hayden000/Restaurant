package cs2810.project.api;

import static spark.Spark.*;

public class App {

  // default port is 4567

  public static void main(String[] args) {
    path(
      "/api",
      () -> {
        get("/status", (req, res) -> "OK");
      }
    );
  }
}
