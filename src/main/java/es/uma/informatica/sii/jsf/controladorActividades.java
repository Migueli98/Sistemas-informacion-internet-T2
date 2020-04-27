package es.uma.informatica.sii.jsf;



import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.Actividades;
import es.uma.informatica.sii.jpa.Alumno;
import es.uma.informatica.sii.jpa.Asignaturas;
import es.uma.informatica.sii.jpa.Curriculum;
import es.uma.informatica.sii.jpa.Actividades.Estado;
import es.uma.informatica.sii.jpa.Usuario.Rol;
import es.uma.informatica.sii.jpa.InformeActividades;
import es.uma.informatica.sii.jpa.Profesor;
import es.uma.informatica.sii.jpa.Usuario;




@Named(value ="controladorActividades")
@SessionScoped
public class controladorActividades implements Serializable {
	
	private ArrayList<Actividades> actividades;
	private Actividades actividad;
	private ArrayList<InformeActividades> informes;
	private InformeActividades informe;
	private ArrayList<Actividades> inscripciones;
	private Actividades inscripcion;
	private ArrayList<Actividades> supervisiones;
	private Actividades supervision;
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;
	private ArrayList<Asignaturas> asignaturas;
	private Asignaturas asignatura;

	    
	   
	    public controladorActividades() throws ParseException {
	    	actividades = new ArrayList<>();
            informes = new ArrayList<>();
            inscripciones = new ArrayList<>();
            supervisiones = new ArrayList<>();
            asignaturas = new ArrayList<>();
            SimpleDateFormat dateformat1 = new SimpleDateFormat("dd/MM/yyyy");
            Actividades a1 = new Actividades(1L,"Recogida Puerteña","Voluntariado",dateformat1.parse("01/05/2021"), "Puerto de la Torre","Recoger basura",Estado.ACEPTADA);
            Actividades a2 = new Actividades(2L,"Compra de comida a ancianos","Voluntariado",dateformat1.parse("05/10/2021"), "Teatinos","Ayudar ancianos Clínico",Estado.REALIZADA);
            actividades.add(a1);
            actividades.add(a2);
            InformeActividades ia1 = new InformeActividades(1L,"Fernando Vega", "Save The Children", a1);
            InformeActividades ia2 = new InformeActividades(2L,"Francisco Chicano", "Save The World", a2);
            informes.add(ia1);
            informes.add(ia2);
            Actividades s1 = new Actividades(3L,"Deshovar Limos Nether","Voluntariado",dateformat1.parse("01/05/2021"), "Jaén","Deshovar Limos",Estado.BUSCANDO_PARTICIPANTES);
            Actividades s2 = new Actividades(4L,"Limpieza jaulas perrera Huelin","Voluntariado",dateformat1.parse("05/10/2021"), "Málaga","Limpiar jaulas perros",Estado.BUSCANDO_PARTICIPANTES);
            Actividades s3 = new Actividades(5L,"La importancia de la higiene","ApyS",dateformat1.parse("05/10/2021"), "Nigeria","Informar sobre la importancia de la higiene",Estado.BUSCANDO_PARTICIPANTES);
            inscripciones.add(s1);
            inscripciones.add(s2);
            inscripciones.add(s3);
            supervisiones.add(a1);
            supervisiones.add(a2);
            usuarios = new ArrayList<>();
            Asignaturas aa1 = new Asignaturas(302L, 6, "Anatomía I");
            Asignaturas aa2 = new Asignaturas(105L, 6, "Psicología");
            Asignaturas aa3 = new Asignaturas(207L, 6, "Anatomía II");
            Asignaturas aa4 = new Asignaturas(208L, 6, "Biología");
            asignaturas.add(aa1);
            asignaturas.add(aa2);
            asignaturas.add(aa3);
            asignaturas.add(aa4);
            
            Curriculum c1 = new Curriculum(1L, "Español, Inglés, Italiano", "Camarero, Enfermero, Pintor", "Lunes, Martes, Miércoles", asignaturas);
            Curriculum c2 = new Curriculum(2L, "Chino, Inglés, Italiano", "Albañil, Médico, Pintor", "Miércoles, Jueves, Viernes", asignaturas);

            usuarios.add(new Alumno(100L, "reshulon", "1234", Rol.ALUMNO, "Javi", "Olea", 120, 5, c1));
            usuarios.add(new Alumno(101L,"alu", "q", Rol.ALUMNO, "Miguel", "Valadez",108,-1, c2));       	
 
	    }
	    
	    

	    public ArrayList<Asignaturas> getAsignaturas() {
			return asignaturas;
		}



		public void setAsignaturas(ArrayList<Asignaturas> asignaturas) {
			this.asignaturas = asignaturas;
		}



		public Asignaturas getAsignatura() {
			return asignatura;
		}



		public void setAsignatura(Asignaturas asignatura) {
			this.asignatura = asignatura;
		}



		public ArrayList<Usuario> getUsuarios() {
			return usuarios;
		}



		public void setUsuarios(ArrayList<Usuario> usuarios) {
			this.usuarios = usuarios;
		}



		public Usuario getUsuario() {
			return usuario;
		}



		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}



		public ArrayList<Actividades> getSupervisiones() {
			return supervisiones;
		}



		public void setSupervisiones(ArrayList<Actividades> supervisiones) {
			this.supervisiones = supervisiones;
		}



		public Actividades getSupervision() {
			return supervision;
		}



		public void setSupervision(Actividades supervision) {
			this.supervision = supervision;
		}



		public ArrayList<Actividades> getInscripciones() {
			return inscripciones;
		}



		public void setInscripciones(ArrayList<Actividades> inscripciones) {
			this.inscripciones = inscripciones;
		}



		public Actividades getInscripcion() {
			return inscripcion;
		}



		public void setInscripcion(Actividades inscripcion) {
			this.inscripcion = inscripcion;
		}



		public ArrayList<Actividades> getActividades() {
	        return actividades;
	    }

	    public void setActividades(ArrayList<Actividades> actividades) {
	        this.actividades = actividades;
	    }
	   
	    
	    public ArrayList<InformeActividades> getInformes() {
			return informes;
		}

		public void setInformes(ArrayList<InformeActividades> informes) {
			this.informes = informes;
		}
		
		/*public Actividades getAct(ArrayList<InformeActividades> informes) {
			
		}
		*/
		
		public String igual (Long i, Long a) {
			if (i == a) {
				return "si";
			}
			return "no";
		}
		

		public InformeActividades getInforme() {
			return informe;
		}

		public void setInforme(InformeActividades informe) {
			this.informe = informe;
		}

		public String borrarActividad(int id){
	    	boolean encontrado =  false;
	    	int cont = 0;
	    	while(!encontrado) {
	    		Actividades ac = actividades.get(cont);
	    		if(ac.getIdActividad() == (id)) {
	    			actividades.remove(cont);
	    			encontrado = true;
	    		}
	    		cont++;
	    	}
	        return "inscripcionActividad.xhtml";
	    }
	    
		public String cancelarInscripcion(int id){
	    	boolean encontrado =  false;
	    	int cont = 0;
	    	while(!encontrado) {
	    		Actividades ac = inscripciones.get(cont);
	    		if(ac.getIdActividad() == (id)) {
	    			inscripciones.remove(cont);
	    			encontrado = true;
	    		}
	    		cont++;
	    	}
	        return "inscripcionActividad.xhtml";
	    }
		
		
	    public String modificarActividad(){
	        return "ModificarActividades.xhtml";
	    }
	 
	    public Actividades getById(int id){
	        return actividades.get(id);
	    }
	 
	    public String verActividades(){
	       return "verActividades.xhtml";
	     }
	    
	    public String guardarValoracion() {
	    	return "MisActividades.xhtml";
	    }
	     
	    public String crearActividad(){
	       return "crearActividad.xhtml";
	    }

	    public Actividades getActividad() {
	        return actividad;
	    }

	    public void setActividad(Actividades actividad) {
	        this.actividad = actividad;
	    }
	    
	    public String verInformeActividad(Long id) {
	    	Iterator<InformeActividades> i = informes.iterator();
            Boolean encontrado = false;
            while (i.hasNext() && !encontrado) {
                informe = i.next();
                if (informe.getAct().getIdActividad()==id) {
                    encontrado = true;
                }
            }
            return "verInformeActividad.xhtml";
	    }
	    
	    public String valorarActividad() {
	    	return "valorarActividad.xhtml";
	    }
	    
	    public String inscripcionActividad() {
	    	return "inscripcionActividad.xhtml";
	    }
	    
	    public String supervisionActividad() {
	    	return "supervisionActividad.xhtml";
	    }
	    
	    public String usuariosInscritos() {
	    	return "usuariosInscritos.xhtml";
	    }
	
}
