public class WeatherData {

    private double temperature;
    private int humidity;
    private double windSpeed;
    private String description;

    public WeatherData(double temperature, int humidity, double windSpeed, String description) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getDescription() {
        return description;
    }
}