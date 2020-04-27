package es.uma.informatica.sii.jsf;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.Actividades;
import es.uma.informatica.sii.jpa.Asignaturas;
import es.uma.informatica.sii.jpa.Servicios;
import es.uma.informatica.sii.jpa.Actividades.Estado;

@Named(value ="controladorAsignaturas")
@SessionScoped
public class controladorAsignaturas implements Serializable{

private ArrayList<Asignaturas> asignaturas;
private Asignaturas asignatura;


public controladorAsignaturas() throws ParseException{
asignaturas = new ArrayList<>();

Asignaturas aa1 = new Asignaturas(302L, 6, "Anatomía I");
Asignaturas aa2 = new Asignaturas(105L, 6, "Psicología");
Asignaturas aa3 = new Asignaturas(207L, 6, "Anatomía II");
Asignaturas aa4 = new Asignaturas(208L, 6, "Biología");
Asignaturas aa5 = new Asignaturas(209L, 6, "Psicología");
Asignaturas aa6 = new Asignaturas(210L, 6, "Patologías I");
asignaturas.add(aa1);
asignaturas.add(aa2);
asignaturas.add(aa3);
asignaturas.add(aa4);
asignaturas.add(aa5);
asignaturas.add(aa6);

	
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

public String borrarAsignatura(int id){
	boolean encontrado =  false;
	int cont = 0;
	while(!encontrado) {
		Asignaturas ac = asignaturas.get(cont);
		if(ac.getCodigoAsignatura() == (id)) {
			asignaturas.remove(cont);
			encontrado = true;
		}
		cont++;
	}
    return "asignaturas.xhtml";
}



public String asignaturas() {
	return "asignaturas.xhtml";
}

public String crearAsignatura() {
	return "crearAsignatura.xhtml";
}
	
	
	
}
