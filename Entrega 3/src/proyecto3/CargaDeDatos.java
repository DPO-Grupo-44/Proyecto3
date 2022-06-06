package proyecto3;

import javax.swing.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CargaDeDatos {
    private String ruta_participantes = "info/Libro2.csv";
    private  String ruta_proyectos = "info/infoProyecto.csv";

    private BufferedReader lector_participantes;
    private String linea_participantes;
    private String partes_participantes[];

    private BufferedReader lector_proyectos;
    private String linea_proyectos;
    private String partes_proyectos[];

    private String[] secc;
    private String nom;
    private String corr;

    private int var1 = 1;
    private int var2 = 1;


    public void leerArchivo_participantes(Laboratorio laboratorio){
        try {
        	
            lector_participantes = new BufferedReader((new FileReader(ruta_participantes)));
            while ((linea_participantes = lector_participantes.readLine()) != null){
                partes_participantes = linea_participantes.split(",");
            
                
                    Participante nuevo = new Participante(partes_participantes[0].substring(3, partes_participantes[0].length()),partes_participantes[1].substring(0,partes_participantes[1].length()));
                    Proyecto proy = laboratorio.buscarProyecto(partes_participantes[2].substring(0,partes_participantes[2].length()));
                    
                    proy.agregarParticipantes(nuevo);
                                   
                    
               
            }
            lector_participantes.close();
            linea_participantes = null;
            partes_participantes = null;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
 
    public void leerArchivo_proyectos(Laboratorio laboratorio){

        try {
        
            lector_proyectos = new BufferedReader((new FileReader(ruta_proyectos)));
            while ((linea_proyectos = lector_proyectos.readLine()) != null){
            	
                partes_proyectos = linea_proyectos.split(",");
                if (var2 == 1){
                    String inicio = partes_proyectos[2].substring(0, partes_proyectos[2].length());
                    String fin = partes_proyectos[5].substring(0, partes_proyectos[5].length());
                    
                    
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

                    LocalDate fechainicio = LocalDate.parse(inicio, formatter);
                    LocalDate fechafin = LocalDate.parse(fin, formatter);
                    String part = partes_proyectos[3].substring(0, partes_proyectos[3].length());
                    String part2 = partes_proyectos[4].substring(0, partes_proyectos[4].length());
                             
           
                    Participante persona = new Participante(part, part2);
                    



                    Proyecto nuevo = new Proyecto(partes_proyectos[0].substring(3, partes_proyectos[0].length()), partes_proyectos[1].substring(0, partes_proyectos[1].length()), fechainicio,  persona, fechafin);
                    nuevo.agregarParticipantes(persona);
                
                    laboratorio.agregarProyectos(nuevo);
                }
                var2 = 1;
            }
            lector_proyectos.close();
            linea_proyectos = null;
            partes_proyectos = null;
        }
        catch (Exception e){
            JOptionPane.showInputDialog("No se encontro el archivo", e);
        }
    }

}
