package es.uma.informatica.sii.jsf;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.Alumno;
import es.uma.informatica.sii.jpa.Asignaturas;
import es.uma.informatica.sii.jpa.Curriculum;
import es.uma.informatica.sii.jpa.Ong;
import es.uma.informatica.sii.jpa.Profesor;
import es.uma.informatica.sii.jpa.Usuario;
import es.uma.informatica.sii.jpa.Usuario.Rol;

@Named(value = "controladorPerfil")
@SessionScoped
public class controladorPerfil implements Serializable{

	private ArrayList<Usuario> usuarios;
	private Alumno usuario;

	private ArrayList<Alumno> alumnos;
	private Alumno alumno;

	private ArrayList<Profesor> profesores;
	private Profesor profesor;

	private ArrayList<Ong> organizaciones;
	private Ong organizacion;

	public controladorPerfil() throws ParseException {

		SimpleDateFormat dateformat1 = new SimpleDateFormat("dd/MM/yyyy");
		List<Asignaturas> asigs = new ArrayList<>();
		asigs.add(new Asignaturas(101L, 6, "Sistemas de Información en Internet"));
		Curriculum cv = new Curriculum(346L, "Chino, Japones, Indio", "Camarero", dateformat1.parse("01/05/2021"),
				asigs);
		alumnos = new ArrayList<>();
		Alumno a1 = new Alumno(1L, "alu", "q", Rol.ALUMNO, 120, 5);
		a1.setApellido("Valadez");
		a1.setNombre("Miguel");
		a1.setCv(cv);
		Alumno a2 = new Alumno(5L, "alu2", "q", Rol.ALUMNO, 120, 5);
		a2.setNombre("Christian");
		a2.setApellido("Martos");
		a2.setCv(cv);
		alumnos.add(a1);
		alumnos.add(a2);

		profesores = new ArrayList<>();
		profesores.add(new Profesor(4L, "pp", "q", Rol.PASPDI, "Ciencias de la Computacion"));

		organizaciones = new ArrayList<>();
		Ong o1 = new Ong(3L, "ong", "q", Rol.ONG, "Caritas", "C/El Congo Nº 20", "Kinsasa",
				"República Democrática del Congo");
		Ong o2 = new Ong(8L, "ong1", "q", Rol.ONG, "UNICEF", "C/Misco Nº 20", "Lagos", "Nigeria");
		organizaciones.add(o1);
		organizaciones.add(o2);

		usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario(1L, "alu", "q", Rol.ALUMNO));
		usuarios.add(new Usuario(2L, "ad", "q", Rol.ADMIN));
		usuarios.add(new Usuario(3L, "ong", "q", Rol.ONG));
		usuarios.add(new Usuario(4L, "pp", "q", Rol.PASPDI));

	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Alumno getUsuario() {
		return usuario;
	}

	public void setUsuario(Alumno usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public ArrayList<Ong> getOrganizaciones() {
		return organizaciones;
	}

	public void setOrganizaciones(ArrayList<Ong> organizaciones) {
		this.organizaciones = organizaciones;
	}

	public Ong getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Ong organizacion) {
		this.organizacion = organizacion;
	}

	public String getEmail() {
		return this.usuario.getEmail();
	}

	public Rol getRol() {
		return this.usuario.getRol();
	}

	public String miPerfilAlumno() {
		return "miPerfilAlumno.xhtml";
	}

	public String miPerfilPasPdi() {
		return "miPerfilPasPdi.xhtml";
	}

	public String miPerfilOng() {
		return "miPerfilOng.xhtml";
	}

	public String miPerfilAdmin() {
		return "miPerfilAdmin.xhtml";
	}

	public String home() {
		// No inicia sesion
		String cad = null;
		if (getEmail() == null) {
			cad = "login.xhtml";
		}
		// Usuario ALUMNO
		if (getRol().equals(Rol.ALUMNO)) {
			cad = "miPerfilAlumno.xhtml";
		}
		// USUARIO PASPDI
		if (getRol().equals(Rol.PASPDI)) {
			cad = "miPerfilPasPdi.xhtml";
		}
		// USUARIO ONG
		if (getRol().equals(Rol.ONG)) {
			cad = "miPerfilOng.xhtml";
		}
		// USUAIRO ADMIN
		if (getRol().equals(Rol.ADMIN)) {
			cad = "miPerfilAdmin.xhtml";
		}
		return cad;
	}

	public String logout() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.getExternalContext().invalidateSession();
		usuario = null;
		return "login.xhtml";
	}

}
