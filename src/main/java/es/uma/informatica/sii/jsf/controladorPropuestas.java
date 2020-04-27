package es.uma.informatica.sii.jsf;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.Actividades;
import es.uma.informatica.sii.jpa.Actividades.Estado;
import es.uma.informatica.sii.jpa.Servicios;

@Named(value ="controladorPropuestas")
@SessionScoped
public class controladorPropuestas implements Serializable{
	private ArrayList<Actividades> actividades;
	private Actividades actividad;
	private ArrayList<Servicios> servicios;
	private Servicios servicio;
	
	public controladorPropuestas() throws ParseException{
		actividades = new ArrayList<>();
        servicios = new ArrayList<>();
        Servicios s1 = new Servicios(200L, "ApyS", "Veneno costero", "Medusas venenosas en la costa, se requiere personal", 200,"Torremolinos");
        Servicios s2 = new Servicios(100L, "ApyS", "Respiradores anti moho", "La zona del palo sufre la infeccion de un moho maleficioso para el ser humano, se quiere personal capacitado", 150,"El palo");
        servicios.add(s1);
        servicios.add(s2);
        SimpleDateFormat dateformat1 = new SimpleDateFormat("dd/MM/yyyy");
        Actividades a1 = new Actividades(1L,"Recogida Puerteña","Voluntariado",dateformat1.parse("01/05/2021"), "Puerto de la Torre","Recoger basura",Estado.PENDIENTE, s1);
        Actividades a2 = new Actividades(2L,"Compra de comida a ancianos","Voluntariado",dateformat1.parse("05/10/2021"), "Teatinos","Ayudar ancianos Clínico",Estado.RECHAZADA, s2);
        actividades.add(a1);
        actividades.add(a2);
	}

	public ArrayList<Actividades> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<Actividades> actividades) {
		this.actividades = actividades;
	}

	public Actividades getActividad() {
		return actividad;
	}

	public void setActividad(Actividades actividad) {
		this.actividad = actividad;
	}

	public ArrayList<Servicios> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<Servicios> servicios) {
		this.servicios = servicios;
	}

	public Servicios getServicio() {
		return servicio;
	}

	public void setServicio(Servicios servicio) {
		this.servicio = servicio;
	}
	
	//BORRAR
	public String borrarPropuestaActividad(int id){
    	boolean encontrado =  false;
    	int cont = 0;
    	while(!encontrado) {
    		Actividades ac = actividades.get(cont);
    		if(ac.getIdActividad() == (id)) {
    			actividades.remove(cont);
    			encontrado = true;
    		}
    		cont++;
    	}
        return "propuestas.xhtml";
    }
	
	public String borrarPropuestaServicio(int id){
    	boolean encontrado =  false;
    	int cont = 0;
    	while(!encontrado) {
    		Servicios ac = servicios.get(cont);
    		if(ac.getCodigoServicio() == (id)) {
    			servicios.remove(cont);
    			encontrado = true;
    		}
    		cont++;
    	}
        return "propuestas.xhtml";
    }
    
	//MODIFICAR
    public String modificarPropuestaActividad(){
        return "modificarPropuestaActividad.xhtml";
    }
    
    public String modificarPropuestaServicio(){
        return "modificarPropuestaServicio.xhtml";
    }
    //s
    //VER
    public String verPropuestaActividad(){
       return "verPropuestaActividad.xhtml";
     }
    
    public String verPropuestaServicio(){
        return "verPropuestaServicio.xhtml";
      }
    
    //GUARDAR
    public String guardarPropuestaActividad() {
    	return "propuesta.xhtml";
    }
    
    public String guardarPropuestaServicio() {
    	return "propuestas.xhtml";
    }
    
    //MODIFICAR
    public String crearPropuestaActividad(){
       return "crearPropuestaActividad.xhtml";
    }
    
    public String crearPropuestaServicio(){
        return "crearPropuestaServicio.xhtml";
     }
}
