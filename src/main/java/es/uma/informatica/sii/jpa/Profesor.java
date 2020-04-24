package es.uma.informatica.sii.jpa;

import es.uma.informatica.sii.jpa.Usuario;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Profesor
 *
 */
@Entity

public class Profesor extends Usuario {

	@Column(nullable = false)
	private String departamento;
	
	@ManyToMany
	private List<Asignaturas> imparte;
	
	private static final long serialVersionUID = 1L;

	public Profesor() {
		super();
	}   
	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public List<Asignaturas> getImparte() {
		return imparte;
	}
	public void setImparte(List<Asignaturas> imparte) {
		this.imparte = imparte;
	}
   
}
