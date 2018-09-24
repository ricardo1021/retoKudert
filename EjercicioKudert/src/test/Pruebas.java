package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import principal.RetoEjercicio;

class Pruebas {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	
	@Test
	@Ignore
	public void comprarProductoMarciano() {
		
		RetoEjercicio.obtenerValorPedido("MC");
		RetoEjercicio.obtenerValorPedido("1100");
		
	}
}
