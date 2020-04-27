package es.uma.informatica.sii.jsf;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.Actividades;
import es.uma.informatica.sii.jpa.InformeActividades;
import es.uma.informatica.sii.jpa.Actividades.Estado;

@Named(value ="controladorValoraciones")
@SessionScoped
public class controladorValoraciones implements Serializable{
	private Actividades actividad;
	private ArrayList<Actividades> actividades;
	private InformeActividades informe;
	private ArrayList<InformeActividades> informes;
	private ArrayList<InformeActividades> informesValorados;
	

	public controladorValoraciones() throws ParseException{
		actividades = new ArrayList<>();
		informes = new ArrayList<>();
		
		
		SimpleDateFormat dateformat1 = new SimpleDateFormat("dd/MM/yyyy");
		Actividades a1 = new Actividades(1L,"Recogida Puerteña","Voluntariado",dateformat1.parse("01/05/2021"), "Puerto de la Torre","Recoger basura",Estado.EN_CURSO);
        Actividades a2 = new Actividades(2L,"Compra de comida a ancianos","Voluntariado",dateformat1.parse("05/10/2021"), "Teatinos","Ayudar ancianos Clínico",Estado.REALIZADA);
        actividades.add(a1);
        actividades.add(a2);
        
        InformeActividades ia1 = new InformeActividades(1L,"Muy gratificante, me ha encantado :)", a1);
        InformeActividades ia2 = new InformeActividades(2L,"No me ha gustado, no he aprendido nada", a1);
        InformeActividades ia3 = new InformeActividades(3L,"Genial ambiente, todo el mundo muy amable, me ha servido mucho para crecer profesionalmente!!", a2);
        InformeActividades ia4 = new InformeActividades(4L,"Hola, yo me llamo Ralph", a2);
        informes.add(ia1);
        informes.add(ia2);
        informes.add(ia3);
        informes.add(ia4);
	}


	public Actividades getActividad() {
		return actividad;
	}


	public void setActividad(Actividades actividad) {
		this.actividad = actividad;
	}


	public ArrayList<Actividades> getActividades() {
		return actividades;
	}


	public void setActividades(ArrayList<Actividades> actividades) {
		this.actividades = actividades;
	}


	public InformeActividades getInforme() {
		return informe;
	}


	public void setInforme(InformeActividades informe) {
		this.informe = informe;
	}


	public ArrayList<InformeActividades> getInformes() {
		return informes;
	}


	public void setInformes(ArrayList<InformeActividades> informes) {
		this.informes = informes;
	}
	
	
	
	public ArrayList<InformeActividades> getInformesValorados() {
		return informesValorados;
	}


	public void setInformesValorados(ArrayList<InformeActividades> informesValorados) {
		this.informesValorados = informesValorados;
	}


	public String verValoracion(Long id) {
    	Iterator<InformeActividades> i = informes.iterator();
    	informesValorados = new ArrayList<>();
        while (i.hasNext()) {
            informe = i.next();
            if (informe.getAct().getIdActividad()==id) {
                informesValorados.add(informe);
            }
        }
        return "verValoracionActividad.xhtml";
    }
	
	
	
}
