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

	public void registrarAluguel(Cliente cliente1, Equipamento equipamento1, LocalDate dataInicio1,
			LocalDate dataFim1) {
		
		
	}

}
