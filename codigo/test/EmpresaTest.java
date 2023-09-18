package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Aluguel;
import business.Cliente;
import business.Empresa;
import business.Equipamento;

class EmpresaTest {
	
	Aluguel aluguel;
	private Empresa empresa;
    private Cliente cliente1;
    private Equipamento equipamento1, equipamento2;
    List<String> alugueisDetalhados;
    LocalDate dataInicio;
    LocalDate dataFim;
    
    @BeforeEach
    public void setUp() {
        empresa = new Empresa();
        cliente1 = new Cliente("Victor", "123456789");
        equipamento1 = new Equipamento(1, "Escavadeira", 100.0);
        equipamento2 = new Equipamento(2, "Furadeira", 50.0);
    }

    @Test
    public void testCalcularValorTotalAluguel() {
        LocalDate dataInicio = LocalDate.of(2023, 9, 1);
        LocalDate dataFim = LocalDate.of(2023, 9, 11);
        aluguel = new Aluguel(cliente1, equipamento1, dataInicio, dataFim);

        double valorTotal = empresa.calcularValorTotalAluguel(aluguel);

        assertEquals(1000.0, valorTotal, 0.01);
    }
    
    @Test
    public void testGerarRelatorioMensal() {
        LocalDate dataInicio1 = LocalDate.of(2023, 9, 1);
        LocalDate dataFim1 = LocalDate.of(2023, 9, 11);
        LocalDate dataInicio2 = LocalDate.of(2023, 9, 5);
        LocalDate dataFim2 = LocalDate.of(2023, 9, 15);
        empresa.registrarEquipamento(equipamento1);
        empresa.registrarEquipamento(equipamento2);
        try{
	        empresa.registrarAluguel(cliente1, equipamento1, dataInicio1, dataFim1);
	        empresa.registrarAluguel(cliente1, equipamento2, dataInicio2, dataFim2);
        }
        catch(Exception e){
        	System.out.println(e);
        }
        double faturamento = empresa.gerarRelatorioMensal(LocalDate.of(2023, 9, 1));

        assertEquals(1500, faturamento, 0.01);
    }
    
    @Test
    public void testRegistrarEquipamento() {
        // Registrar equipamento1
    	empresa.registrarEquipamento(equipamento1);

        // Verificar se equipamento1 está registrado
        assertTrue(empresa.getCodigosEquipamentos().contains(1));

        // Registrar equipamento2
        empresa.registrarEquipamento(equipamento2);

        // Verificar se equipamento2 está registrado
        assertTrue(empresa.getCodigosEquipamentos().contains(2));
    }
    
    @Test
    public void testAchaAluguel() {
    	cliente1 = new Cliente("V", "0");
        equipamento1 = new Equipamento(1, "Descrição", 10);
        alugueisDetalhados = new ArrayList<>();
    	dataInicio = LocalDate.now();
        dataFim = LocalDate.now();
    	empresa.registrarEquipamento(equipamento1);
    	try {
      		empresa.registrarAluguel(cliente1, equipamento1, dataInicio, dataFim);
      	}
      	catch(Exception e) {
      		System.out.println(e);
      	}
        alugueisDetalhados = empresa.getAlugueisClienteDetalhados(cliente1);
        String detalhesAluguel = alugueisDetalhados.get(0);
        assertEquals(detalhesAluguel,"Cliente: V, Equipamento: Descrição, Data de Início: 2023-09-17, Data de Término: 2023-09-17");
    }

}
