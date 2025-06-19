import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiExchangeRate {

    private MonedasRecord dataMonedas;

    public MonedasRecord getDataMonedas() {
        return dataMonedas;
    }

    public ApiExchangeRate() throws IOException, InterruptedException {

        // Obtener json de la API
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/ea7c039a3a450af8f276ab9b/latest/USD"))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        // Convertir en jsonObject
        JsonObject jsonObj = JsonParser.parseString(json).getAsJsonObject();

        // Convertir el campo conversion_rates en otro jsonObject
        JsonObject campoConversionRates = jsonObj.getAsJsonObject("conversion_rates");

        // Deserializar
        this.dataMonedas = gson.fromJson(campoConversionRates, MonedasRecord.class);
    }


}
