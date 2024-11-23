package ar.edu.Unlam.PBII.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import ar.edu.Unlam.PBII.Estructura.Alumno;

import ar.edu.Unlam.PBII.Estructura.Cursos;
import ar.edu.Unlam.PBII.Estructura.DivisionJardin;
import ar.edu.Unlam.PBII.Estructura.DivisionPrimaria;
import ar.edu.Unlam.PBII.Estructura.Docente;
import ar.edu.Unlam.PBII.Estructura.Persona;

public class Pruebas {
	
	
	
	@Test 
	public void queSePuesaCrearUnAlumno() {
		//Preparacion
		String nombre="Lucas";
		String apellido="Gomez";
		Integer edad=6;
		Integer dni=45674368;
		//Ejecucion
		Persona alum= new Alumno(nombre,apellido,edad,dni);
		//Validacion
		assertEquals(nombre,alum.getNombre());
		assertEquals(apellido,alum.getApellido());
		assertEquals(edad,alum.getEdad());
		assertEquals(dni,alum.getDni());
		
	}
	
	@Test 
	public void queLucasPuedaAsistirALaPrimeraClase() {
		//Preparacion
		String nombre="Lucas";
		String apellido="Gomez";
		Integer edad=6;
		Integer dni=45674368,numeroDeClase=1;
		Alumno lucas= new Alumno(nombre,apellido,edad,dni);
		//Ejecucion
		lucas.asistir(true);
		//Validacion
		assertTrue(lucas.asistio(numeroDeClase));
	}
	
	@Test 
	public void queLucasPuedaFaltarALaPrimeraClase() {
		//Preparacion
		String nombre="Lucas";
		String apellido="Gomez";
		Integer edad=6;
		Integer dni=45674368,numeroDeClase=1;
		Alumno lucas= new Alumno(nombre,apellido,edad,dni);
		//Ejecucion
		lucas.asistir(false);
		lucas.asistir(true);
		lucas.asistir(true);
		lucas.asistir(true);
		//Validacion
		assertFalse(lucas.asistio(numeroDeClase));
	}
	
	@Test 
	public void queSiLucasAsisteATodasLasClasesElPorcentajeDeAsistenciaSeaCienPorciento() {
		//Preparacion
		String nombre="Lucas", apellido="Gomez";
		Integer edad=6, dni=45674368;
		Integer cantidadDeClases=190;
		Double porcentajeEsperado=100.0;
		Alumno lucas= new Alumno(nombre,apellido,edad,dni);
		//Ejecucion
		for(int i=1;i<=cantidadDeClases;i++) {
			lucas.asistir(true);
			assertTrue(lucas.asistio(i));
		}
		//Validacion
		assertEquals(porcentajeEsperado,lucas.getPorcentajeDeAsistencia(),0.01);
	}
	
	@Test 
	public void queSiLucasNoAsisteANingunaDeLasClasesElPorcentajeDeAsistenciaSeaCeroPorciento() {
		//Preparacion
		String nombre="Lucas", apellido="Gomez";
		Integer edad=6, dni=45674368;
		Double porcentajeEsperado=0.0;
		Alumno lucas= new Alumno(nombre,apellido,edad,dni);
		//Ejecucion
		//Validacion
		assertEquals(porcentajeEsperado,lucas.getPorcentajeDeAsistencia(),0.01);
	}
	
	@Test 
	public void queSiLucasAsisteALaMitadDeLasClasesElPorcentajeDeAsistenciaSeaCincuentaPorciento() {
		//Preparacion
		String nombre="Lucas", apellido="Gomez";
		Integer edad=6, dni=45674368;
		Integer cantidadDeClasesALaQueAsiste=100;
		Double porcentajeEsperado=50.0;
		Alumno lucas= new Alumno(nombre,apellido,edad,dni);
		//Ejecucion
		for(int i=1;i<=cantidadDeClasesALaQueAsiste;i++) {
			if(i%2==0) {
				lucas.asistir(true);
			}
			else {
				lucas.asistir(false);
			}
		}
			
		//Validacion
			assertEquals(porcentajeEsperado,lucas.getPorcentajeDeAsistencia(),0.01);
	}
	
	@Test 
	public void queSePuesaCrearUnDocente() {
		//Preparacion
		String nombre="Juan",apellido="Torres";
		Integer dni=45687654,edad=35;
		//Ejecucion
		Docente Juan=new Docente(nombre,apellido,edad,dni);
		//Validacion
		assertEquals(nombre,Juan.getNombre());
		assertEquals(apellido,Juan.getApellido());
		assertEquals(edad,Juan.getEdad());
		assertEquals(dni,Juan.getDni());
		;
	}
	
	@Test 
	public void queSePuedaCrearElPrimerGrado() {
		//Preparacion
		String nombre="Juan",apellido="Torres";
		Integer dni=45687654,edad=35;
		DivisionPrimaria tipo= DivisionPrimaria.PRIMERO;
		Docente Juan=new Docente(nombre,apellido,edad,dni);
		Cursos nuevo;
		//Ejecucion
		
		nuevo=new Cursos(tipo,Juan);
		//Validacion
		assertNotNull(nuevo);
		assertEquals(Juan,nuevo.getDocente());
	}
	
	@Test 
	public void queSePuedaAgregarALucasAPrimerGrado() {
		//Preparacion
		String nombre="Lucas",apellido="Gomez";
		Integer edad=6,dni=45674368;
		String nombreDocente="Juan",apellidoDocente="Torres";
		Integer dniDocente=45687654,edadDocente=35;
		DivisionPrimaria tipo= DivisionPrimaria.PRIMERO;
		Docente Juan=new Docente(nombreDocente,apellidoDocente,edadDocente,dniDocente);
		Alumno Lucas= new Alumno(nombre,apellido,edad,dni);
		Cursos primerGrado=new Cursos(tipo,Juan);
		//Ejecucion
		assertTrue(primerGrado.agregarAlumno(Lucas));
		
		//Validacion
		assertEquals(Lucas.getDni(),primerGrado.buscar(dni).getDni());
		
	}
	
	@Test 
	public void queSiSeBuscaALucasEnUnGradoQueNoEstaElResultadoSeaNull() {
		//Preparacion
		String nombre="Lucas",apellido="Gomez";
		Integer edad=6,dni=45674368;
		Alumno Lucas= new Alumno(nombre,apellido,edad,dni);
		String nombreDocente="Juan",apellidoDocente="Torres";
		Integer dniDocente=45687654,edadDocente=35;
		Docente Juan=new Docente(nombreDocente,apellidoDocente,edadDocente,dniDocente);
		DivisionPrimaria primero= DivisionPrimaria.PRIMERO;
		DivisionPrimaria segundo= DivisionPrimaria.SEGUNDO;
		Cursos primerGrado=new Cursos(primero,Juan);
		Cursos segundoGrado=new Cursos(segundo,new Docente("luciano","Rojas",40,34567554));
		//Ejecucion
		assertTrue(primerGrado.agregarAlumno(Lucas));
		
		//Validacion
		assertNull(segundoGrado.buscar(dni));
	}
	
	@Test 
	public void queNoSePuedaAgregarDosAlumnosConUnMismoDni() {
		//Preparacion
				
		String nombrelucas="Lucas",apellidolucas="Gomez";
		Integer edadlucas=6,dnilucas=45674368;
		Alumno Lucas= new Alumno(nombrelucas,apellidolucas,edadlucas,dnilucas);
		String nombrepedro="Pedro",apellidopedro="Alvarez";
		Integer edadpedro=6,dnipedro=45674368;
		Alumno Pedro= new Alumno(nombrepedro,apellidopedro,edadpedro,dnipedro);
		String nombreDocente="Juan",apellidoDocente="Torres";
		Integer dniDocente=45687654,edadDocente=35;
		Docente Juan=new Docente(nombreDocente,apellidoDocente,edadDocente,dniDocente);
		DivisionPrimaria primero= DivisionPrimaria.PRIMERO;
		Cursos primerGrado=new Cursos(primero,Juan);
		//Ejecucion
		assertTrue(primerGrado.agregarAlumno(Lucas));
		
		//Validacion
		assertFalse(primerGrado.agregarAlumno(Pedro));
	}
	
	
	
	

	@Test
	public void queSePuedaObtenerUnListadoDeLosAlumnosQueEstanInscriptosEnLosCursosOrdenadoAlfabeticamente() {
	    // Preparación
	    DivisionPrimaria segundo = DivisionPrimaria.SEGUNDO;
	    Cursos segundoGrado = new Cursos(segundo, new Docente("luciano", "Rojas", 40, 34567554));
	    Alumno Lucas = new Alumno("Lucas", "Gomez", 7, 45674368);
	    Alumno Esteban = new Alumno("Esteban", "Alvarez", 7, 45674468);
	    Alumno Noelia = new Alumno("Noelia", "Romero", 7, 5467766);

	    segundoGrado.agregarAlumno(Noelia);
	    segundoGrado.agregarAlumno(Lucas);
	    segundoGrado.agregarAlumno(Esteban);

	    // Ejecución
	    LinkedList<Alumno> alumnosOrdenados = segundoGrado.obtenerAlumnosOrdenados();

	   

	    // Validación
	    assertEquals( Esteban.getApellido(), alumnosOrdenados.get(0).getApellido());
	    assertEquals( Lucas.getApellido(), alumnosOrdenados.get(1).getApellido());
	    assertEquals( Noelia.getApellido(), alumnosOrdenados.get(2).getApellido());
	}

			
			

	@Test 
	public void ObtenerUnListadoDeAlumnosOrdenadosPorDniDeMenorAMayor() {
		//Preparacion
		DivisionPrimaria segundo = DivisionPrimaria.SEGUNDO;
	    Cursos segundoGrado = new Cursos(segundo, new Docente("luciano", "Rojas", 40, 34567554));
	    Alumno Lucas = new Alumno("Lucas", "Gomez", 7, 45674368);
	    Alumno Esteban = new Alumno("Esteban", "Alvarez", 7, 45674468);
	    Alumno Noelia = new Alumno("Noelia", "Romero", 7, 5467766);

	    segundoGrado.agregarAlumno(Noelia);
	    segundoGrado.agregarAlumno(Lucas);
	    segundoGrado.agregarAlumno(Esteban);
	    
		//Ejecucion
	    LinkedList<Alumno> alumnosOrdenadosPorDni = segundoGrado.obtenerAlumnosOrdenadosPorDni();
		//Validacion
	    assertEquals(Noelia.getDni(),alumnosOrdenadosPorDni.get(0).getDni());
	    assertEquals(Lucas.getDni(),alumnosOrdenadosPorDni.get(1).getDni());
	    assertEquals(Esteban.getDni(),alumnosOrdenadosPorDni.get(2).getDni());
	     
	    
	}
	
	@Test //Este test no me funciona pero no encuentro el porque.
	public void queSePuedaBuscarUnAlumnoEnUnaSala() {
		//Preparacion
		DivisionJardin celeste= DivisionJardin.CELESTE;
		Cursos sala=new Cursos(celeste,new Docente("Pablo","Berutti",35,33466887));
		
		 Alumno Soledad = new Alumno("soledad", "Perez", 7, 58998766);
		//Ejecucion
		 sala.agregarAlumno(Soledad);
		
		 Persona alumBuscado= sala.buscar(58998766);
		//Validacion
		 assertNotNull(alumBuscado);
		 assertEquals(Soledad,alumBuscado);
		 
	}
}
	


	
