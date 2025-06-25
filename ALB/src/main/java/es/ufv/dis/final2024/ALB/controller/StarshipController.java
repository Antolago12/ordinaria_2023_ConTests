package es.ufv.dis.final2024.ALB.controller;

import es.ufv.dis.final2024.ALB.model.Starship;
import es.ufv.dis.final2024.ALB.model.ShipRequest;
import es.ufv.dis.final2024.ALB.service.PDFManager;
import es.ufv.dis.final2024.ALB.service.StarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/starships")
public class StarshipController {

    @Autowired
    private StarshipService starshipService;

    // GET: /api/starships
    @GetMapping
    public List<Starship> getAllStarships() {
        return starshipService.getAllStarships();
    }

    // POST: /api/starships/pdf
    @PostMapping("/pdf")
    public ResponseEntity<?> generateStarshipPDF(@RequestBody ShipRequest request) {
        String name = request.getShip();
        Starship starship = starshipService.findStarshipByName(name);

        if (starship == null) {
            return ResponseEntity.notFound().build();
        }

        // Llama al generador de PDF
        PDFManager.generatePDF(starship);

        // Aquí también deberías actualizar el contador JSON (si quieres)
        // PeticionesManager.updateCount(name);

        return ResponseEntity.ok("PDF generado correctamente para " + name);
    }

}
