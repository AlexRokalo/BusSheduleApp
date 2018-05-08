package OnlineReadBase;

import BusesShedule.BusSchedule;
import BusesShedule.Deserializer.BusScheduleDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OnlineReadJSON implements OnlineRead {
    public BusSchedule makeSchedule() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/AlexRokalo/JSONBASE/master/BASE.json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(BusSchedule.class, new BusScheduleDeserializer())
                    .create();

            BusSchedule busSchedule = gson.fromJson(new BufferedReader
                    (new InputStreamReader(connection.getInputStream())), BusSchedule.class);

            return busSchedule;
        } catch (MalformedURLException e) {
            System.out.println("Ошибка в чтениие JSON Файла! :" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка в записи :" + e.getMessage());
        }

        return null;
    }
}