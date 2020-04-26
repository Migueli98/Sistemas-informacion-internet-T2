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

@Named(value ="controladorBuscarActividades")
@SessionScoped

public class controladorBuscarActividades implements Serializable{
	private ArrayList<Actividades> actividades;
	private Actividades actividad;
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

	public controladorBuscarActividades() throws ParseException{
		actividades = new ArrayList<>();
		SimpleDateFormat dateformat1 = new SimpleDateFormat("dd/MM/yyyy");
		actividades.add(new Actividades(1L,"Recogida Puerteña","Voluntariado",dateformat1.parse("01/05/2021"), "Puerto de la Torre","Recoger basura",Estado.EN_CURSO));
		actividades.add(new Actividades(2L,"Compra de comida a ancianos","Voluntariado",dateformat1.parse("05/10/2021"), "Teatinos","Ayudar ancianos Clínico",Estado.BUSCANDO_PARTICIPANTES));
		actividades.add(new Actividades(3L,"Control plagas","Voluntariado",dateformat1.parse("06/10/2022"), "Puerto de la Torre","Fumigar",Estado.BUSCANDO_PARTICIPANTES));
		actividades.add(new Actividades(4L,"Dar de comer a indigentes de Algaidas","ApyS",dateformat1.parse("15/11/2020"), "Villanueva de Algaidas","Dar comida",Estado.BUSCANDO_PARTICIPANTES));
		actividades.add(new Actividades(5L,"Recogida de de alimentos en teatinos","ApyS",dateformat1.parse("07/06/2020"), "Teatinos","Recoger alimentos",Estado.BUSCANDO_PARTICIPANTES));
	}
	
	public String borrarBuscarActividad(int id){
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
        return "buscarActividades.xhtml";
    }
	
	public Actividades getById(int id){
        return actividades.get(id);
    }
	
	public String verBuscarActividades(){
	     return "verBuscarActividades.xhtml";
	}
	
	public String inscribirseActividad() {
		return "buscarActividades.xhtml";
	}
	public String modificarBuscarActividad(){
        return "modificarBuscarActividad.xhtml";
    }
	
}
