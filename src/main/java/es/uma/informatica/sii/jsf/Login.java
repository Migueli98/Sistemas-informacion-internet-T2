/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.Usuario;
import es.uma.informatica.sii.jpa.Usuario.Rol;

@Named(value = "login")
@RequestScoped
public class Login {

   private String email;
   private String contraseña;
   private List<Usuario> usuarios;
   
   @Inject
   private ControlAutorizacion ctrl;

   /**
    * Creates a new instance of Login
    */
   public Login() {
       usuarios = new ArrayList<Usuario>();
       usuarios.add(new Usuario(1L,"alu", "q", Rol.ALUMNO, "Miguel", "Valadez"));
       usuarios.add(new Usuario(2L,"ad", "q", Rol.ADMIN, "Francisco", "Chicano"));
       usuarios.add(new Usuario(3L,"ong", "q", Rol.ONG, "Lorenz", "Werthmann"));
       usuarios.add(new Usuario(4L,"pp", "q", Rol.PASPDI, "Enrique", "Soler"));
   }

   public String getEmail() {
       return email;
   }

   public String getContraseña() {
       return contraseña;
   }

   public void setEmail(String usuario) {
       this.email = usuario;
   }

   public void setContraseña(String contrasenia) {
       this.contraseña = contrasenia;
   }

   public String autenticar() {
       // Implementar este método
       FacesContext ctx = FacesContext.getCurrentInstance();
       
       if(email == null) { //si no se introduce usuario
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
       	if(act.getEmail().equals(email)) {
       		esta = true;
       	}
       }
       
       //si el usuario esta en la lista, se comprueba que su contraseña sea valida
       if(esta) {
       	if(act.getContraseña().equals(contraseña)) {
       		ctrl.setEmail(act);
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
