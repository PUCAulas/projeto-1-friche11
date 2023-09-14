package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import business.Equipamento;

class EquipamentoTest {

	@Test
	public void testEquipamento() {
        Equipamento equipamento = new Equipamento(1, "Escavadeira", 100.0);
        assertEquals(1, equipamento.getCodigo());
        assertEquals("Escavadeira", equipamento.getDescricao());
        assertEquals(100.0, equipamento.getValorDiario(), 0.01);
    }

}
