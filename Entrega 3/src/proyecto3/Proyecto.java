 package proyecto3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Proyecto {

	private String nombre;
	private String descripcion;
	private LocalDate fechainicio;
	private Participante dueno;
	private ArrayList<Actividad> listaactividades;
	private ArrayList<Participante> listaparticipantes;
	private ArrayList<Paquete> listaplan;
	private LocalDate fechafin;
	private ArrayList<String> tipos;
	
	public Proyecto(String tnombre, String tdescripcion, LocalDate fechainicio2, 
			Participante tdueno, LocalDate fechafin2) {
		nombre = tnombre;
		descripcion = tdescripcion;
		fechainicio = fechainicio2;
		fechafin = fechafin2;
		dueno = tdueno;
		listaparticipantes = new ArrayList<Participante>();
		listaactividades = new ArrayList<Actividad>();
		listaplan = new ArrayList<Paquete>();
		tipos = new ArrayList<String>();
	}
	
	public void agregarParticipantes(Participante tparticipante) {
		listaparticipantes.add(tparticipante);
	}
	
	public void agregarActividades(Actividad tactividad) {
		listaactividades.add(tactividad);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public Participante getDueno() {
		return dueno;
	}
	
	public LocalDate getFechaI() {
		return fechainicio;
	}
	
	public LocalDate getFechaF() {
		return fechafin;
	}
	
	public String getFechaIStr() {
		String fechares = fechainicio.toString();
		
		return fechares;
	}
	
	public String getFechaFStr() {
		String fechares = fechafin.toString();
		
		return fechares;
	}
	
	
	public ArrayList<String> getTipos(){
		return tipos;
	}
	
	public ArrayList<Participante> getParticipantes(){
		return listaparticipantes;
	}

	public void setDueno(Participante tdueno) {
		dueno = tdueno;
	}
	
	public void agregarTipos(String ttipo) {
		tipos.add(ttipo);
	}
	
	public boolean buscarTipo(String ttipo) {
		boolean res = false;
		for (int j=0;j<tipos.size();j++) {
			
			if (tipos.get(j).equals(ttipo))
			{
				res = true;
			}
		}
		return res;
	}
	
	public ArrayList<Actividad> getActividades() {
		return listaactividades;
	}
	
	public void agregarPacks(Paquete pack) {
		listaplan.add(pack);
	}
	
	public ArrayList<Paquete> getRamas(){
		return listaplan;
	}
}
