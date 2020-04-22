/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol;

/**
*
* @author francis
*/
@Named(value = "login")
@RequestScoped
public class Login {

   private String usuario;
   private String contrasenia;
   private List<Usuario> usuarios;
   
   @Inject
   private ControlAutorizacion ctrl;

   /**
    * Creates a new instance of Login
    */
   public Login() {
       usuarios = new ArrayList<Usuario>();
       usuarios.add(new Usuario("abel", "qwerty", Rol.ALUMNO));
       usuarios.add(new Usuario("fchicano", "qwerty", Rol.ADMIN));
       usuarios.add(new Usuario("caritas", "qwerty", Rol.ONG));
       usuarios.add(new Usuario("enriquesoler", "qwerty", Rol.PASPDI));
   }

   public String getUsuario() {
       return usuario;
   }

   public String getContrasenia() {
       return contrasenia;
   }

   public void setUsuario(String usuario) {
       this.usuario = usuario;
   }

   public void setContrasenia(String contrasenia) {
       this.contrasenia = contrasenia;
   }

   public String autenticar() {
       // Implementar este método
       FacesContext ctx = FacesContext.getCurrentInstance();
       
       if(usuario == null) { //si no se introduce usuario
       	return "login.xhtml";
       }
       
       //creo un iterador para buscar en la lista y un comprobador
       boolean esta = false;
       Iterator i = usuarios.iterator(); //el metodo contains no puede usarse porque se introduce una clase Usuario
       //creamos un auxiliar para guardar el usuario encontrado si es que se encuentra
       Usuario act = null;
               
       //recorremos la lista y comprobamos si se encuentra el usuario
       while(i.hasNext() && !esta) {
       	act = (Usuario) i.next();
       	if(act.getUsuario().equals(usuario)) {
       		esta = true;
       	}
       }
       
       //si el usuario esta en la lista, se comprueba que su contraseña sea valida
       if(esta) {
       	if(act.getContrasenia().equals(contrasenia)) {
       		ctrl.setUsuario(act);
       		return ctrl.home();
       		
       	}else {//si la contraseña no es correcta, muestra error
       		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR. Contraseña equivocada", "ERROR. Contraseña equivocada"));
       	}
       }else {//si el usuario no esta en la lista, se muestra error
       	ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Este usuario no existe", "Este usuario no existe"));
       }
       
       
       //ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", ""));
       return null;
   }
}
