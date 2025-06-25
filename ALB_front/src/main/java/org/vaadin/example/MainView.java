package org.vaadin.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Route("")
public class MainView extends VerticalLayout {

    private Grid<Starship> grid = new Grid<>(Starship.class, false);

    public MainView() {
        setSizeFull();
        grid.setSizeFull();

        // Columnas del grid con nombres bonitos
        grid.addColumn(Starship::getName).setHeader("Nombre");
        grid.addColumn(Starship::getModel).setHeader("Modelo");
        grid.addColumn(Starship::getCost_in_credits).setHeader("Coste en créditos");
        grid.addColumn(Starship::getCrew).setHeader("Tripulación");
        grid.addColumn(Starship::getCargo_capacity).setHeader("Capacidad de carga");
        grid.addColumn(Starship::getConsumables).setHeader("Consumibles");
        grid.addColumn(Starship::getHyperdrive_rating).setHeader("Hiperimpulsor");
        grid.addColumn(Starship::getStarship_class).setHeader("Clase");
        grid.addColumn(starship -> String.join(", ", starship.getPilots() != null ? starship.getPilots() : new ArrayList<>()))
                .setHeader("Pilotos");
        grid.addColumn(starship -> String.join(", ", starship.getFilms() != null ? starship.getFilms() : new ArrayList<>()))
                .setHeader("Películas");

        // Columna del botón "Generar"
        grid.addComponentColumn(starship -> {
            Button btn = new Button("Generar");
            btn.addClickListener(e -> {
                generatePdfForShip(starship.getName());
            });
            return btn;
        }).setHeader("Generar PDF");

        add(grid);

        // Cargar los datos automáticamente al abrir
        loadStarships();
    }

    private void loadStarships() {
        try {
            URL url = new URL("http://localhost:8085/api/starships");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            try (InputStreamReader reader = new InputStreamReader(conn.getInputStream())) {
                Type listType = new TypeToken<ArrayList<Starship>>() {}.getType();
                List<Starship> starships = new Gson().fromJson(reader, listType);
                grid.setItems(starships);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generatePdfForShip(String shipName) {
        System.out.println("Intentando generar PDF para: " + shipName);
        try {
            URL url = new URL("http://localhost:8085/api/starships/pdf");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInput = "{\"ship\":\"" + shipName + "\"}";
            conn.getOutputStream().write(jsonInput.getBytes());

            conn.getInputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
