package ar.edu.Unlam.PBII.Estructura;

import java.util.Collections;
import java.util.LinkedList;

public class Cursos {
	private Division tipo;
	private Docente docente;
	private LinkedList<Alumno>alumnos;
	
	public Cursos(Division tipo, Docente docente) {
		this.tipo = tipo;
		this.docente = docente;
		this.alumnos=new LinkedList<Alumno>();
	}
	public Division getTipo() {
		return tipo;
	}
	public void setTipo(Division tipo) {
		this.tipo = tipo;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public Boolean agregarAlumno(Alumno alum) {
		if(alumnos.contains(alum)) {
			return false;
		}
		return alumnos.add(alum);
	}
	public Persona buscar(Integer dni) {
		for(Alumno actual:alumnos) {
			if(actual.getDni()==dni) {
				return actual;
			}
		}
		return null;
	}
	
	public LinkedList<Alumno> obtenerAlumnosOrdenados() {
	    
	    Collections.sort(alumnos);  
	    return alumnos;
	}
	public LinkedList<Alumno> obtenerAlumnosOrdenadosPorDni() {
	    
	    Collections.sort(alumnos, (a1, a2) -> a1.getDni().compareTo(a2.getDni()));
	    return new LinkedList<>(alumnos);
	}


	

}
