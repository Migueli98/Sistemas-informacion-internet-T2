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
import es.uma.informatica.sii.jpa.InformeActividades;
import es.uma.informatica.sii.jpa.Usuario;




@Named(value ="controladorActividades")
@SessionScoped
public class controladorActividades implements Serializable {
	
	private ArrayList<Actividades> actividades;
	private Usuario email;
	private Actividades actividad;
	private ArrayList<InformeActividades> informes;
	private InformeActividades informe;
	

	    public void setEmail(Usuario usuario) {
	        this.email = usuario;
	    }

	    public Usuario getEmail() {
	        return email;
	    }
	    
	   
	    public controladorActividades() throws ParseException {
	    	actividades = new ArrayList<>();
            informes = new ArrayList<>();
            SimpleDateFormat dateformat1 = new SimpleDateFormat("dd/MM/yyyy");
            Actividades a1 = new Actividades(1L,"Recogida Puerteña","Voluntariado",dateformat1.parse("01/05/2021"), "Puerto de la Torre","Recoger basura",Estado.ACEPTADA);
            Actividades a2 = new Actividades(2L,"Compra de comida a ancianos","Voluntariado",dateformat1.parse("05/10/2021"), "Teatinos","Ayudar ancianos Clínico",Estado.REALIZADA);
            actividades.add(a1);
            actividades.add(a2);
            InformeActividades ia1 = new InformeActividades(1L,"Fernando Vega", "Save The Children", a1);
            InformeActividades ia2 = new InformeActividades(2L,"Francisco Chicano", "Save The World", a2);
            informes.add(ia1);
            informes.add(ia2);
	    }

	    public ArrayList<Actividades> getActividades() {
	        return actividades;
	    }

	    public void setActividades(ArrayList<Actividades> actividades) {
	        this.actividades = actividades;
	    }
	   
	    
	    public ArrayList<InformeActividades> getInformes() {
			return informes;
		}

		public void setInformes(ArrayList<InformeActividades> informes) {
			this.informes = informes;
		}
		
		/*public Actividades getAct(ArrayList<InformeActividades> informes) {
			
		}
		*/
		
		public String igual (Long i, Long a) {
			if (i == a) {
				return "si";
			}
			return "no";
		}
		

		public InformeActividades getInforme() {
			return informe;
		}

		public void setInforme(InformeActividades informe) {
			this.informe = informe;
		}

		public String borrarActividad(int id){
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
	        return "MisActividades.xhtml";
	    }
	    
	    public String modificarActividad(){
	        return "ModificarActividades.xhtml";
	    }
	 
	    public Actividades getById(int id){
	        return actividades.get(id);
	    }
	 
	    public String verActividades(){
	       return "verActividades.xhtml";
	     }
	    
	    public String guardarValoracion() {
	    	return "MisActividades.xhtml";
	    }
	     
	    public String crearActividad(){
	       return "crearActividad.xhtml";
	    }

	    public Actividades getActividad() {
	        return actividad;
	    }

	    public void setActividad(Actividades actividad) {
	        this.actividad = actividad;
	    }
	    
	    
	    
	    public String verInformeActividad() {
	    	return "verInformeActividad.xhtml";
	    }
	    
	    public String valorarActividad() {
	    	return "valorarActividad.xhtml";
	    }
	
}
