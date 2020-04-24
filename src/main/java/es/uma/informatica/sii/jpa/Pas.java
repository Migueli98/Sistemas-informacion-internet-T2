package es.uma.informatica.sii.jpa;

import es.uma.informatica.sii.jpa.Usuario;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pas
 *
 */
@Entity

public class Pas extends Usuario {

	@Column(nullable = false)
	private String grupo;
	private static final long serialVersionUID = 1L;

	public Pas() {
		super();
	}   
	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
   
}
