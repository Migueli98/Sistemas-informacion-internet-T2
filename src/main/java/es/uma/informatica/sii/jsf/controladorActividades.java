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
import es.uma.informatica.sii.jpa.Usuario;




@Named(value ="controladorActividades")
@SessionScoped
public class controladorActividades implements Serializable {
	
	private ArrayList<Actividades> actividades;
	private Usuario email;
	private Actividades actividad;
	private Actividades act = new Actividades();

	    public Actividades getA() {
	        return act;
	    }

	    public void setA(Actividades a) {
	        this.act = a;
	    }

	    public void setEmail(Usuario usuario) {
	        this.email = usuario;
	    }

	    public Usuario getEmail() {
	        return email;
	    }
	    
	   
	    public controladorActividades() throws ParseException {
	    	actividades = new ArrayList<>();
	        SimpleDateFormat dateformat1 = new SimpleDateFormat("dd/MM/yyyy");
	        actividades.add(new Actividades(1L,"Recogida Puerteña","Voluntariado",dateformat1.parse("01/05/2021"), "Puerto de la Torre","Recoger basura",Estado.ACEPTADA));
	        actividades.add(new Actividades(2L,"Compra de comida a ancianos","Voluntariado",dateformat1.parse("05/10/2021"), "Teatinos","Ayudar ancianos Clínico",Estado.PENDIENTE));

	    }

	    public ArrayList<Actividades> getActividades() {
	        return actividades;
	    }

	    public void setActividades(ArrayList<Actividades> actividades) {
	        this.actividades = actividades;
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
	     
	    public String crearActividad(){
	       return "crearActividad.xhtml";
	    }

	    public Actividades getActividad() {
	        return actividad;
	    }

	    public void setActividad(Actividades actividad) {
	        this.actividad = actividad;
	    }
	     
	    public String home(){
	        
	       
	        String cad = "login.xhtml";
	 	   
	       	if(email.getRol().equals(Usuario.Rol.ADMIN)) {
	       		cad = "MisActividades.xhtml";
	       	
	       	}else if(email.getRol().equals(Usuario.Rol.ALUMNO)) {
	       		cad = "MisActividades.xhtml";
	       		
	       	}else if(email.getRol().equals(Usuario.Rol.ONG)) {
	       		cad = "MisActividades.xhtml";
	       		
	       	}else if(email.getRol().equals(Usuario.Rol.PASPDI)) {
	       		cad = "MisActividades.xhtml";
	       		
	       	}
	        return cad;
	    }
	    
	    public String logout(){
	        FacesContext ctx = FacesContext.getCurrentInstance();
	        ctx.getExternalContext().invalidateSession();
	        email = null;
	        return "login.xhtml";
	    }
	
}
