package es.ufv.dis.final2024.ALB.service;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;


import es.ufv.dis.final2024.ALB.model.Starship;

import java.io.File;
import java.io.FileOutputStream;

public class PDFManager {

    public static void generatePDF(Starship starship) {
        try {
            // Crea carpeta si no existe
            File folder = new File("naves");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String pdfPath = "naves/" + starship.getName().replace(" ", "_") + ".pdf";

            Document doc = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter.getInstance(doc, new FileOutputStream(pdfPath));
            doc.open();

            doc.add(new Paragraph("Datos de la nave:"));
            doc.add(new Paragraph("Nombre: " + starship.getName()));
            doc.add(new Paragraph("Modelo: " + starship.getModel()));
            doc.add(new Paragraph("Clase: " + starship.getStarship_class()));
            doc.add(new Paragraph("Tripulación: " + starship.getCrew()));
            doc.add(new Paragraph("Número de películas: " +
                    (starship.getFilms() != null ? starship.getFilms().size() : 0)));

            doc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
