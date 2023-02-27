import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class CurrencyConverterServer {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/convertCurrency", new ConvertCurrencyHandler());
        server.setExecutor(null);
        server.start();
    }

    static class ConvertCurrencyHandler implements HttpHandler {

        public void handle(HttpExchange exchange) throws IOException {

	    if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
		    // Handle preflight request
		    Headers headers = exchange.getResponseHeaders();
		    headers.add("Access-Control-Allow-Origin", "*");
		    headers.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
		    headers.add("Access-Control-Allow-Headers", "Content-Type");
		    exchange.sendResponseHeaders(204, -1);
		    return;
  	    }

            // Handle actual request
            if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
                // Get the request body and split into dollar amount and currency
                InputStream is = exchange.getRequestBody();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                String input = br.readLine();
                String[] values = input.split(", ");
                Double dollarAmount = Double.parseDouble(values[0]);
                String countryCurrency = values[1];

                // Convert the currency
                Double convertedCurrency = convertCurrency(dollarAmount, countryCurrency);

                // Send the response
                String response = "Converted currency value: " + convertedCurrency.toString();
	        Headers headers = exchange.getResponseHeaders();
	        headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
		headers.add("Access-Control-Allow-Headers", "Content-Type");
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else {
                // Send an error response for non-POST requests
                String response = "Invalid request method";
                exchange.sendResponseHeaders(405, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }

    public static Double convertCurrency(Double dollarAmount, String countryCurrency) {
        // Implement the currency conversion logic here
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
	    // Convert the currency and return the result
	    return dollarAmount * exchangeRate;
	}
}
