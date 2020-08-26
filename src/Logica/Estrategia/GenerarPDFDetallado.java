/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Estrategia;


import Logica.fabrica.Motocicleta;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class GenerarPDFDetallado extends DocumentoDetallado{

    @Override
    void generarDocumentoDetallado(ArrayList<Motocicleta> catalogo) {

        System.out.println("Generar documento catalogo");
//        
//        List<Motos> listamotos = new ArrayList<Motos>();
//        
//        listamotos.add(new Motos(900, "Yamaha","FSZ","2021","Rojo"));
//        listamotos.add(new Motos(900, "Yamaha","FSZ","2021","Azul"));        
//        listamotos.add(new Motos(900, "Yamaha","FSZ","2021","Negro"));
//        listamotos.add(new Motos(900, "Yamaha","FSZ","2021","Gris"));
//        listamotos.add(new Motos(900, "Yamaha","FSZ","2021", "Verde"));
//        
//        System.out.println("Se encontraron "+listamotos.size()+" registros");
//        
//        MotosDB motosdb = new MotosDB();
//        ResultSet res = null;
//        
        try {
            crearPDF(catalogo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenerarPDFSencillo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(GenerarPDFSencillo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenerarPDFDetallado.class.getName()).log(Level.SEVERE, null, ex);
        }
//        
    }
    
    public static void crearPDF(ArrayList<Motocicleta> lista) throws FileNotFoundException, DocumentException, BadElementException, IOException {
        // Se crea el documento
        Document documento = new Document();
        
        //Aquí colocas tu objeto tipo Date
        Date myDate = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
        //Aquí obtienes el formato que deseas
        System.out.println(fecha.format(myDate));
        // El OutPutStream para el fichero donde crearemos el PDF
        FileOutputStream ficheroPDF = new FileOutputStream("ListaMotosDetallado"+fecha.format(myDate)+".pdf");
        
        // Se asocia el documento de OutPutStream
        PdfWriter.getInstance(documento, ficheroPDF);
        
        // Se abre el documento
        documento.open();

        //Paragraph titulo = new Paragraph("Moto1 : "+lista.get(2).getLinea()+" Moto2 : " +lista.get(6).getLinea(),
        Paragraph titulo = new Paragraph("Catálogo: Lista motos disponibles ",
                FontFactory.getFont("arial",22,Font.BOLD,BaseColor.RED));        

        // Parrafo
        Paragraph parrafo = new Paragraph(""
                + "A continuación se lista de manera general y a detalle "
                + "el consolidado de motos diponibles en nuestro consecionario."
                + "\n\n",
                FontFactory.getFont("arial",
                                    12,
                                    Font.PLAIN,
                                    BaseColor.GRAY
                                    )
        );                
        
        String separador = System.getProperty("user.dir");
        String ruta = separador+"/src";
        // Creamos una tabla
        PdfPTable tabla = new PdfPTable(6);
        tabla.addCell("Ref.");
        tabla.addCell("Linea");
        tabla.addCell("Marca");
        tabla.addCell("Categoría");
        tabla.addCell("Modelo");
        tabla.addCell("Valor");                    
        
        for(int i = 0 ; i < lista.size() ; i++) {              
                //Image imagen = Image.getInstance(moto.getImagen());             
                URL urlImg = GenerarPDFDetallado.class.getClassLoader().getResource(lista.get(i).getImagen());
                Image imagen = Image.getInstance(ruta+(lista.get(i).getImagen()));
                //Image imagen = Image.getInstance(urlImg);            
                imagen.setAlignment(Element.ALIGN_CENTER);
                imagen.setAbsolutePosition(0f, 0f);
                imagen.scaleAbsoluteHeight(10f);            
                imagen.scaleAbsoluteWidth(10f);            
                tabla.addCell(imagen);
                tabla.addCell(lista.get(i).getLinea());
                tabla.addCell(lista.get(i).getMarca());
                tabla.addCell(lista.get(i).getCategoria());
                tabla.addCell(String.valueOf(lista.get(i).getModelo()));
                tabla.addCell(String.valueOf(lista.get(i).getPrecio()));

        }
        
        // Añadimos el titulo, arrafo y tabla al documento
        documento.add(titulo);
        documento.add(parrafo);      
        documento.add(tabla);
        
        System.out.println("Se añade información de las motos almacenadas en la base de datos");
        
        // Se cierra el documento
        documento.close();        
        System.out.println("Se realiza el cierre del documento");
    }
  
}