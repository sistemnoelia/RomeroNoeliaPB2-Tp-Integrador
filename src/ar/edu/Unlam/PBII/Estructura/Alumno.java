package ar.edu.Unlam.PBII.Estructura;

import java.util.ArrayList;
import java.util.Objects;

public class Alumno extends Persona implements Comparable<Alumno> {
	private ArrayList<Boolean>clases;

	public Alumno(String nombre, String apellido, Integer edad, Integer dni) {
		super(nombre,apellido,edad,dni);
		clases=new ArrayList<Boolean>();
	}

	

	public void asistir(Boolean asistio) {
		clases.add(asistio);
		
	}
	public void modificarAsistencia(Integer numeroDeClase,Boolean asistio) {
		if(numeroDeClase<clases.size()) {
			clases.add(numeroDeClase,asistio);
		}
	}

	public boolean asistio(Integer numeroDeClase) {
		
		return clases.get(numeroDeClase-1);
	}

	public double getPorcentajeDeAsistencia() {
		Integer cantidadDeAsistencia=0;
		Double porcentajeDeAsistencia=0.0;
		for(Boolean clase:clases) {
			if(clase) {
				 cantidadDeAsistencia++;
			}
		}
		if(clases.size()>0) {
			porcentajeDeAsistencia=((cantidadDeAsistencia*100.0)/clases.size());	
		}
		
		return porcentajeDeAsistencia;
	}



	@Override
	public int compareTo(Alumno nuevoAlumno) {
	    // Comparar por apellido primero
	    int comparoApellidos = this.getApellido().compareTo(nuevoAlumno.getApellido());

	    // Si los apellidos son iguales, comparar por nombre
	    if (comparoApellidos == 0) {
	        return this.getNombre().compareTo(nuevoAlumno.getNombre());
	    }

	    return comparoApellidos;
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alumno alumno = (Alumno) obj;
        return Objects.equals(getDni(), alumno.getDni());  
    }

    
    @Override
    public int hashCode() {
        return Objects.hash(getDni());  
    }
}


