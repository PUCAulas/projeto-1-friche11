package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Cliente;
import business.Aluguel;
import business.Empresa;

class AluguelTest {
	
	Aluguel a1;
	LocalDate i, t;
	Cliente c;
	Empresa e;
	
	@BeforeEach
	void setUp() {
		e = new Empresa();
		c = new Cliente("Vitor", "0");
		a1 = new Aluguel(c, e, i, t);
	}
	
	@Before
	void setBefore() {
		i.plusDays(10);
		t.toString();
		
	}
	
	@Test
	void aluguelTest() {
		assertEquals(a1.getCliente(), c);
		assertEquals(e, null);
		assertEquals(i, null);
		
	}

}
