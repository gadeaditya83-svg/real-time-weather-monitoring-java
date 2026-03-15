import java.io.*;
import java.net.*;
import org.json.*;

public class ApiService {

    private static final String API_KEY = "68e95ffbe8f1a08cdf548fcffd8bc14f";

    public static WeatherData getWeather(String city) {

        try {

            String urlString =
                    "https://api.openweathermap.org/data/2.5/weather?q="
                            + city
                            + "&appid="
                            + API_KEY
                            + "&units=metric";

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            JSONObject obj = new JSONObject(response.toString());

            double temp = obj.getJSONObject("main").getDouble("temp");
            int humidity = obj.getJSONObject("main").getInt("humidity");
            double wind = obj.getJSONObject("wind").getDouble("speed");
            String desc =
                    obj.getJSONArray("weather")
                            .getJSONObject(0)
                            .getString("description");

            return new WeatherData(temp, humidity, wind, desc);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}