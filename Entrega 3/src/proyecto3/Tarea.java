package proyecto3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Tarea {
	private String nombre;
	private String descr;
	private String tipo;
	private LocalTime tiempo;
	private LocalDate fecha;
	private ArrayList<Participante> encargados;
	private ArrayList<Actividad> asociadas;
	private boolean terminada;
	
	public Tarea(String tnombre, String tdescr, String ttipo, LocalTime ttiempo, LocalDate tfecha) {
		nombre = tnombre;
		descr = tdescr;
		tipo = ttipo;
		tiempo = ttiempo;
		fecha = tfecha;
		encargados = new ArrayList<Participante>();
		asociadas = new ArrayList<Actividad>();
		terminada = false;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombret) {
		nombre = nombret;
	}
	
	public LocalTime getTiempo() {
		return tiempo;
	}
	
	public void setTiempo(String tiempot) {
		DateTimeFormatter formateadort = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime time = LocalTime.parse(tiempot, formateadort);
		tiempo = time;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(String fechat) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate date = LocalDate.parse(fechat, formatter);
		fecha = date;
	}
	
	public ArrayList<Participante> getParts(){
		return encargados;
	}
	
	public void removeParts(String nombre) {
		for (int i = 0; i < encargados.size(); i++) {
			if (encargados.get(i).getNombre().equals(nombre)){
				encargados.remove(i);
			}
		}
	}
	
	public void addParts(Participante nuevo) {
		encargados.add(nuevo);
	}
	
	public ArrayList<Actividad> getActs(){
		return asociadas;
	}
	
	public void removeActs(String nombre) {
		for (int i = 0; i < asociadas.size(); i++) {
			if (asociadas.get(i).getNombre().equals(nombre)){
				asociadas.remove(i);
			}
		}
	}
	
	public boolean getProgreso() {
		return terminada;
	}
	
	public void setProgreso() {
		terminada = true;
	}
}
