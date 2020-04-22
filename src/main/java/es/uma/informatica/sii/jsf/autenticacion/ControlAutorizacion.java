/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import static es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol.ADMIN;
import static es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol.ALUMNO;
import static es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol.ONG;
import static es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol.PASPDI;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
*
* @author francis
*/
@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

   private Usuario usuario;

   public void setUsuario(Usuario usuario) {
       this.usuario = usuario;
   }

   public Usuario getUsuario() {
       return usuario;
   }

   public String home() {
	   String cad = "login.xhtml";
	   
   	if(usuario.getRol().equals(Usuario.Rol.ADMIN)) {
   		cad = "inicio.xhtml";
   	
   	}else if(usuario.getRol().equals(Usuario.Rol.ALUMNO)) {
   		cad = "inicio.xhtml";
   		
   	}else if(usuario.getRol().equals(Usuario.Rol.ONG)) {
   		cad = "inicio.xhtml";
   		
   	}else if(usuario.getRol().equals(Usuario.Rol.PASPDI)) {
   		cad = "inicio.xhtml";
   		
   	}
   	
   	return cad;
   }
   
   public String logout()
   {
       // Destruye la sesión (y con ello, el ámbito de este bean)
       FacesContext ctx = FacesContext.getCurrentInstance();
       ctx.getExternalContext().invalidateSession();
       usuario = null;
       return "login.xhtml";
   }

   /**
    * Creates a new instance of ControlAutorizacion
    */
   public ControlAutorizacion() {
   }
}
