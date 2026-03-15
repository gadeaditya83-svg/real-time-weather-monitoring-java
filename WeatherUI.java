import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WeatherUI extends JFrame {

    JTextField cityField;
    JTextArea resultArea;

    public WeatherUI() {

        setTitle("Weather Monitoring System");
        setSize(450,350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel title = new JLabel("Real-Time Weather App");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        add(new JLabel("Enter City"));

        cityField = new JTextField(15);
        add(cityField);

        JButton searchButton = new JButton("Get Weather");
        add(searchButton);

        resultArea = new JTextArea(10,30);
        resultArea.setEditable(false);
        add(resultArea);

        searchButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String city = cityField.getText();

                WeatherData data = ApiService.getWeather(city);

                if(data != null){

                    resultArea.setText(
                            "Temperature : " + data.getTemperature() + " °C\n"
                            + "Humidity : " + data.getHumidity() + "%\n"
                            + "Wind Speed : " + data.getWindSpeed() + " m/s\n"
                            + "Condition : " + data.getDescription()
                    );

                } else {

                    resultArea.setText("City not found or internet error.");

                }

            }

        });

        setVisible(true);
    }

    public static void main(String[] args) {

        new WeatherUI();

    }
}