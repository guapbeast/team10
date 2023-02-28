import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class CurrencyConverter {
  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
    server.createContext("/convertCurrency", new ConvertCurrencyHandler());
    server.setExecutor(null);
    server.start();
  }

  static class ConvertCurrencyHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
      String requestMethod = exchange.getRequestMethod();
      if (requestMethod.equalsIgnoreCase("POST")) {
        InputStream requestBody = exchange.getRequestBody();
        String requestBodyString = new String(requestBody.readAllBytes());

        String[] requestBodyValues = requestBodyString.split(",");
        Double dollarAmount = Double.parseDouble(requestBodyValues[0].trim());
        String countryCurrency = requestBodyValues[1].trim();

        Double convertedCurrency = convertCurrency(dollarAmount, countryCurrency);

        String responseBody = "<html><body><h2>Converted currency: " + convertedCurrency + "</h2></body></html>";

        exchange.sendResponseHeaders(200, responseBody.getBytes().length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(responseBody.getBytes());
        outputStream.flush();
        outputStream.close();
      } else {
        exchange.sendResponseHeaders(405, -1);
      }
    }
  }

  private static Double convertCurrency(Double dollarAmount, String countryCurrency) {
    Double exchangeRate;
    switch (countryCurrency) {
      case "EUR":
        exchangeRate = 0.82;
        break;
      case "GBP":
        exchangeRate = 0.72;
        break;
      case "JPY":
        exchangeRate = 105.72;
        break;
      default:
        exchangeRate = 1.0;
        break;
    }
    return dollarAmount * exchangeRate;
  }
}
