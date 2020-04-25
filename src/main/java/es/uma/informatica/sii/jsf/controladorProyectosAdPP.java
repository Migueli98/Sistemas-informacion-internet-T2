package es.uma.informatica.sii.jsf;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.Servicios;
import es.uma.informatica.sii.jpa.Usuario;

@Named(value ="controladorProyectosAdPP")
@SessionScoped
public class controladorProyectosAdPP implements Serializable{
	private ArrayList<Servicios> servicios;
	private Servicios servicio;
	
    
    public controladorProyectosAdPP() throws ParseException{
    	servicios = new ArrayList<>();
    	servicios.add(new Servicios(200L, "ApyS", "Veneno costero", "Medusas venenosas en la costa, se requiere personal", 200,"Torremolinos"));
    	servicios.add(new Servicios(100L, "ApyS", "Respiradores anti moho", "La zona del palo sufre la infeccion de un moho maleficioso para el ser humano, se quiere personal capacitado", 150,"El palo"));
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
    
	//borrar
	public String borrarProyecto(int id){
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
        return "ProyectosAdPasPdi.xhtml";
    }
    
	//modificar
    public String modificarProyecto(){
     
        return "modificarProyecto.xhtml";
    }
    
    public Servicios getById(int id){
        return servicios.get(id);
    }
 
    //ver
    public String verProyecto(){
       return "verProyecto.xhtml";
    }
    
    //crear
    public String crearProyecto() {
    	return "crearProyecto.xhtml";
    }
    

}
