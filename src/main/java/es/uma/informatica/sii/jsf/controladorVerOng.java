package es.uma.informatica.sii.jsf;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.Ong;
import es.uma.informatica.sii.jpa.Usuario;
import es.uma.informatica.sii.jpa.Usuario.Rol;

@Named(value ="controladorVerOng")
@SessionScoped
public class controladorVerOng implements Serializable{
	private ArrayList<Ong> ongs;
	private Ong ong;
	
	public controladorVerOng() throws ParseException{
		ongs = new ArrayList<>();
		ongs.add(new Ong(1L, "caritas@gmail.com", "q", Rol.ONG, "Caritas", "c/ viktor nos han vuelto a engañar", "Krakov", "Rusia"));
		ongs.add(new Ong(2L, "unicef@gmail.com", "q", Rol.ONG, "Unicef", "c/manhatthan 15", "New York City", "USA"));
		ongs.add(new Ong(3L, "savethechildren@gmail.com", "q", Rol.ONG, "Save the Children", "c/ Rockstar 34", "Londres", "UK"));
		
	}

	public ArrayList<Ong> getOngs() {
		return ongs;
	}

	public void setOngs(ArrayList<Ong> ongs) {
		this.ongs = ongs;
	}

	public Ong getOng() {
		return ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
	}
	
	//borrar
	public String borrarOng(int id){
    	boolean encontrado =  false;
    	int cont = 0;
    	while(!encontrado) {
    		Ong ac = ongs.get(cont);
    		if(ac.getId() == (id)) {
    			ongs.remove(cont);
    			encontrado = true;
    		}
    		cont++;
    	}
        return "verOngsAd.xhtml";
    }
    
	//modificar
    public String modificarOng(){
     
        return "modificarOngAd.xhtml";
    }
    
    public Ong getById(int id){
        return ongs.get(id);
    }
 
    //ver
    public String verOng(){
       return "verOng.xhtml";
    }
    
    //crear
    public String crearOngAd() {
    	return "crearOngAd.xhtml";
    }
}
