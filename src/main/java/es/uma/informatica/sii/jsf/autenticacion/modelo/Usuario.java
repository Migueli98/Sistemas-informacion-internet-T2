/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 *
 * @author francis
 */
@Entity
public class Usuario implements Serializable {
    
    public enum Rol {
      ADMINISTRADOR,
      NORMAL
    };
    
    private static final long serialVersionUID = 1L;
    @Id
    private String usuario;
    private String contrasenia;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    
    public Usuario()
    {
        
    }
    
    public Usuario (String usuario, String contrasenia, Rol rol)
    {
        setUsuario(usuario);
        setContrasenia(contrasenia);
        setRol(rol);
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", rol=" + rol + "]";
	}
    
    
}
