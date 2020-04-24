package es.uma.informatica.sii.jpa;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Informe_Para_Alumnos
 *
 */
@Entity

public class Informe_Para_Alumnos implements Serializable {

	@Id @GeneratedValue
	private Long idInforme;
	@Column(nullable = false)
	private String informeProfesor;
	private String informeONG;
	private String valoracionAlumno;
	
	@ManyToOne
	@JoinColumn(name = "profesor")
	private Profesor profe; 
	
	@ManyToOne
	@JoinColumn(name = "alumno")
	private Alumno alumn;
	
	@ManyToOne
	@JoinColumn(name = "servicio")
	private Servicios serv;

	
	private static final long serialVersionUID = 1L;

	public Informe_Para_Alumnos() {
		super();
	}   
	public Long getIdInforme() {
		return this.idInforme;
	}

	public void setIdInforme(Long idInforme) {
		this.idInforme = idInforme;
	}   
	public String getInformeProfesor() {
		return this.informeProfesor;
	}

	public void setInformeProfesor(String informeProfesor) {
		this.informeProfesor = informeProfesor;
	}   
	public String getInformeONG() {
		return this.informeONG;
	}

	public void setInformeONG(String informeONG) {
		this.informeONG = informeONG;
	}   
	public String getValoracionAlumno() {
		return this.valoracionAlumno;
	}

	public void setValoracionAlumno(String valoracionAlumno) {
		this.valoracionAlumno = valoracionAlumno;
	}
	public Profesor getProfe() {
		return profe;
	}
	public void setProfe(Profesor profe) {
		this.profe = profe;
	}
	public Alumno getAlumn() {
		return alumn;
	}
	public void setAlumn(Alumno alumn) {
		this.alumn = alumn;
	}
	public Servicios getServ() {
		return serv;
	}
	public void setServ(Servicios serv) {
		this.serv = serv;
	}
   
}
