package com.devpredator.PROF2022_control1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Vector;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

class MatriculaTest {

	Matricula matricula;
	Vector<Asignatura> asignatura;
	Matricula m;
	Asignatura a;
	Double suma;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.printf("Empieza los test.\n");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.printf("Todos los test se ha ejecutado correctamente.\n");
	}

	@BeforeEach
	void setUp() throws Exception {
		matricula = new Matricula(null);
		asignatura = new Vector<Asignatura>();
		m = mock(Matricula.class);
		suma = 0.0;
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void matriculaVacia() {
		assertNull(matricula.vectorAsignaturas);
		System.out.printf("La matricula no llevan ninguna asignatura.\n");
	}

	@Test
	void calculaImporte() throws Exception {
		matricula = m;
		when(m.getImporte()).thenReturn(10.0);
		suma += matricula.getImporte();
		when(m.getImporte()).thenReturn(20.0);
		suma += matricula.getImporte();
		when(m.getImporte()).thenReturn(50.0);
		suma += matricula.getImporte();
		assertEquals(80.0, suma);
		
	}
	
	@Test
	void calculaImporte2() throws Exception {
		matricula = m;
		matricula.getImporte();
		matricula.getImporte();
		matricula.getImporte();
		verify(matricula, times(3)).getImporte();
	}
}
