package business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Empresa {
	
	 private List<Aluguel> alugueisAtuais;
	 private List<Aluguel> alugueisPassados;
	 private Set<Integer> codigosEquipamentos;
	 
	 public Empresa() {
		 this.alugueisAtuais = new ArrayList<>();
	     this.alugueisPassados = new ArrayList<>();
	     this.codigosEquipamentos = new HashSet<>();
	    }
	 
	 public double calcularValorTotalAluguel(Aluguel aluguel) {
	     long diasAlugados = aluguel.getInicio().until(aluguel.getTermino()).getDays();
	     return diasAlugados * aluguel.getEquipamento().getValorDiario();
	    }
	 
	 public double gerarRelatorioMensal(LocalDate data) {
		    double faturamentoTotal = 0.0;
		    int mesDesejado = data.getMonthValue();

		    // Verificar aluguéis atuais
		    for (int i = 0; i < alugueisAtuais.size(); i++) {
		        Aluguel aluguel = alugueisAtuais.get(i);
		        LocalDate dataAluguel = aluguel.getInicio();
		        if (dataAluguel.getMonthValue() == mesDesejado) {
		            faturamentoTotal += calcularValorTotalAluguel(aluguel);
		        }
		    }

		    // Verificar aluguéis passados
		    for (int i = 0; i < alugueisPassados.size(); i++) {
		        Aluguel aluguel = alugueisPassados.get(i);
		        LocalDate dataAluguel = aluguel.getInicio();
		        if (dataAluguel.getMonthValue() == mesDesejado) {
		            faturamentoTotal += calcularValorTotalAluguel(aluguel);
		        }
		    }

		    return faturamentoTotal;
		}

	public void registrarAluguel(Cliente cliente1, Equipamento equipamento1, LocalDate dataInicio1,
			LocalDate dataFim1) {
		
		
	}

	public void registrarEquipamento(Equipamento equipamento1) {
		
		
	}

	public Set<Integer> getCodigosEquipamentos() {
        return codigosEquipamentos;
    }
	
	

}
