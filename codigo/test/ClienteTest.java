package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Cliente;



class ClienteTest {

	 private Cliente cliente;

	    @BeforeEach
	    public void setUp() {
	        // Configuração inicial para cada teste
	        cliente = new Cliente("João da Silva", "123.456.789-00");
	    }

	    @Test
	    public void testGetNome() {
	        assertEquals("João da Silva", cliente.getNome());
	    }

	    @Test
	    public void testGetCpf() {
	        assertEquals("123.456.789-00", cliente.getCpf());
	    }

	    @Test
	    public void testConstrutor() {
	        assertEquals("João da Silva", cliente.getNome());
	        assertEquals("123.456.789-00", cliente.getCpf());
	    }

	    @Test
	    public void testAlterarNome() {
	        cliente = new Cliente("Maria Souza", "987.654.321-00");
	        assertEquals("Maria Souza", cliente.getNome());
	        assertEquals("987.654.321-00", cliente.getCpf());
	    }


	
}
