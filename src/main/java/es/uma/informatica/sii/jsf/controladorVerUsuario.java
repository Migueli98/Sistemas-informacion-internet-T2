package es.uma.informatica.sii.jsf;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


import es.uma.informatica.sii.jpa.Usuario;
import es.uma.informatica.sii.jpa.Usuario.Rol;;

@Named(value ="controladorVerUsuario")
@SessionScoped
public class controladorVerUsuario implements Serializable{
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;
	
    
    public controladorVerUsuario() throws ParseException{
    	usuarios = new ArrayList<>();
    	usuarios.add(new Usuario(1L, "antoniorubio@uma.es", "q", Rol.PASPDI, "Antonio", "Rubio"));
    	usuarios.add(new Usuario(2L, "cristina@uma.es", "q", Rol.ALUMNO, "Cristina", "Morena"));
    	usuarios.add(new Usuario(3L, "ruben@uma.es", "q", Rol.PASPDI, "Ruben", "Castaño"));
    	usuarios.add(new Usuario(4L, "sara@uma.es", "q", Rol.ONG, "Sara", "Pelirroja"));
    }

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
    
	
	//borrar
	public String borrarUsuario(int id){
    	boolean encontrado =  false;
    	int cont = 0;
    	while(!encontrado) {
    		Usuario ac = usuarios.get(cont);
    		if(ac.getId() == (id)) {
    			usuarios.remove(cont);
    			encontrado = true;
    		}
    		cont++;
    	}
        return "verUsuariosAd.xhtml";
    }
    
	//modificar
    public String modificarUsuario(){
     
        return "modificarUsuarioAd.xhtml";
    }
    
    public Usuario getById(int id){
        return usuarios.get(id);
    }
 
    //ver
    public String verUsuario(){
       return "verUsuario.xhtml";
    }
    
    //crear
    public String crearUsuario() {
    	return "crearUsuarioAd.xhtml";
    }
    
}
