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

public class InformeActividades implements Serializable {

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
	@JoinColumn(name = "actividades")
	private Actividades act;

	
	private static final long serialVersionUID = 1L;

	public InformeActividades() {
		super();
	}   
	
	public InformeActividades(Long id, String ip, String io, Actividades a) {
        idInforme = id;
        informeProfesor = ip;
        informeONG = io;
        act = a;
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
	public Actividades getAct() {
		return act;
	}
	
	public String getNombreAct() {
		return act.getNombreActividad();
	}
	
	public void setAct(Actividades act) {
		this.act = act;
	}
	
}
