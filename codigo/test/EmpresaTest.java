package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import business.Aluguel;
import business.Cliente;
import business.Empresa;
import business.Equipamento;

class EmpresaTest {
	
	private Empresa empresa;
    private Cliente cliente1, cliente2;
    private Equipamento equipamento1, equipamento2;

    @Before
    public void setUp() {
        empresa = new Empresa();
        cliente1 = new Cliente("Victor", "123456789");
        cliente2 = new Cliente("Saulo", "987654321");
        equipamento1 = new Equipamento(1, "Escavadeira", 100.0);
        equipamento2 = new Equipamento(2, "Furadeira", 50.0);
    }

    @Test
    public void testCalcularValorTotalAluguel() {
        LocalDate dataInicio = LocalDate.of(2023, 9, 1);
        LocalDate dataFim = LocalDate.of(2023, 9, 10);
        Aluguel aluguel = new Aluguel(cliente1, equipamento1, dataInicio, dataFim);

        double valorTotal = empresa.calcularValorTotalAluguel(aluguel);

        assertEquals(1000.0, valorTotal, 0.01);
    }

}
