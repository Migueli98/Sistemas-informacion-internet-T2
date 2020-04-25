package es.uma.informatica.sii.jpa;

import es.uma.informatica.sii.jpa.Usuario;
import es.uma.informatica.sii.jpa.Usuario.Rol;

import java.lang.Integer;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Alumno
 *
 */
@Entity

public class Alumno extends Usuario{

	@Column(nullable = false)
	private Integer creditos;
	private Integer horasLibre;
	
	@OneToOne
	@JoinColumn(name = "CV")
	private Curriculum cv;
	
	@ManyToMany
	private List<Asignaturas> matriculadoEn;
	
	private static final long serialVersionUID = 1L;

	public Alumno() {
		super();
	}   
	
	public Alumno(Long ID, String EMAIL, String PASS, Rol R,Integer c, Integer hL) {
		super(ID, EMAIL, PASS, R);
		this.creditos = c;
		this.horasLibre = hL;
	}   
	
	public Integer getCreditos() {
		return this.creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}   
	public Integer getHorasLibre() {
		return this.horasLibre;
	}

	public void setHorasLibre(Integer horasLibre) {
		this.horasLibre = horasLibre;
	}
	public Curriculum getCv() {
		return cv;
	}
	public void setCv(Curriculum cv) {
		this.cv = cv;
	}
	public List<Asignaturas> getMatriculadoEn() {
		return matriculadoEn;
	}
	public void setMatriculadoEn(List<Asignaturas> matriculadoEn) {
		this.matriculadoEn = matriculadoEn;
	}
   
}
