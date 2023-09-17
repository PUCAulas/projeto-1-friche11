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
	 
	 

}
