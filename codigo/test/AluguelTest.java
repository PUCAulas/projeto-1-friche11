package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Cliente;
import business.Aluguel;
import business.Equipamento;

class AluguelTest {
	
	Aluguel a1;
	LocalDate i, t;
	Cliente c;
	Equipamento e;
	
	@BeforeEach
	void setUp() {
		e = new Equipamento(1, "Descrição", 10);
		c = new Cliente("Vitor", "0");
		a1 = new Aluguel(c, e, i, t);
		i = LocalDate.now();
		t = LocalDate.now().plusDays(10);
	}
	
	@Test
	void aluguelTest() {
		assertEquals(a1.getCliente(), c);
		assertEquals(e.getDescricao(), "Descrição");
		assertEquals(i.getDayOfMonth(), 17);
		assertEquals(i.getMonthValue(), 9);
		assertEquals(i.getYear(), 2023);
	}
}
