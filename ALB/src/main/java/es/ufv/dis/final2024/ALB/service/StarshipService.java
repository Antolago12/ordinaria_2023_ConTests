package es.ufv.dis.final2024.ALB.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import es.ufv.dis.final2024.ALB.model.Starship;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class StarshipService {

    private static final String DATA_JSON_PATH = "data.json"; // Ajusta el path según tu estructura

    public List<Starship> getAllStarships() {
        List<Starship> starships = new ArrayList<>();
        try (
                InputStream is = getClass().getClassLoader().getResourceAsStream("data.json");
                Reader reader = new InputStreamReader(is)
        ) {
            Type listType = new TypeToken<ArrayList<Starship>>() {}.getType();
            starships = new Gson().fromJson(reader, listType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return starships;
    }


    public Starship findStarshipByName(String name) {
        return getAllStarships().stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
