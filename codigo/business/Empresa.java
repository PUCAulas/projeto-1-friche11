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
	 private List<Cliente> clientes;
	 private List<Equipamento> equipamentos;
	 
	 public Empresa() {
		this.alugueisAtuais = new ArrayList<>();
	     this.alugueisPassados = new ArrayList<>();
	     this.codigosEquipamentos = new HashSet<>();
		this.clientes = new ArrayList<>();
	     this.equipamentos = new ArrayList<>();
	    }
	 
	 public double calcularValorTotalAluguel(Aluguel aluguel) {
	     long diasAlugados = aluguel.getInicio().until(aluguel.getTermino()).getDays();
	     return diasAlugados * aluguel.getEquipamento().getValorDiario();
	    }
	 
	 public double gerarRelatorioMensal(LocalDate data) {
		    double faturamentoTotal = 0.0;
		    int mesDesejado = data.getMonthValue();
	        List<String> alugueisDetalhados = new ArrayList<>();

	        
	        // Verificar aluguéis atuais
	        for (Aluguel aluguel : alugueisAtuais) {
	        	if (aluguel.getTermino().getMonthValue() == mesDesejado) {
	        		String detalhesAluguel = "Cliente: " + aluguel.getCliente().getNome() +
	                        ", Equipamento: " + aluguel.getEquipamento().getDescricao() +
	                        ", Data de Início: " + aluguel.getInicio() +
	                        ", Data de Término: " + aluguel.getTermino();
	        		alugueisDetalhados.add(detalhesAluguel);
		            faturamentoTotal += calcularValorTotalAluguel(aluguel);
		        }
	        }
	        
	        // Verificar aluguéis passados
	        for (Aluguel aluguel : alugueisPassados) {
	        	if (aluguel.getTermino().getMonthValue() == mesDesejado) {
	        		String detalhesAluguel = "Cliente: " + aluguel.getCliente().getNome() +
	                        ", Equipamento: " + aluguel.getEquipamento().getDescricao() +
	                        ", Data de Início: " + aluguel.getInicio() +
	                        ", Data de Término: " + aluguel.getTermino();
	        		alugueisDetalhados.add(detalhesAluguel);
		            faturamentoTotal += calcularValorTotalAluguel(aluguel);
		        }
	        }

		    return faturamentoTotal;
		}

	 public void registrarAluguel(Cliente cliente, Equipamento equipamento, LocalDate dataInicio, LocalDate dataFim) {
	        if (!codigosEquipamentos.contains(equipamento.getCodigo())) {
	            throw new IllegalArgumentException("Equipamento não registrado: " + equipamento.getCodigo());
	        }

	        Aluguel aluguel = new Aluguel(cliente, equipamento, dataInicio, dataFim);
	        alugueisAtuais.add(aluguel);

	        LocalDate hoje = LocalDate.now();
	        if (dataFim.isBefore(hoje)) {
	            alugueisPassados.add(aluguel);
	            alugueisAtuais.remove(aluguel);
	        }
	    }

	public void registrarEquipamento(Equipamento equipamento) {
	    int codigo = equipamento.getCodigo();
	    if (codigosEquipamentos.contains(codigo)) {
	        System.out.println("O código do equipamento já está em uso.");
	    }
	    codigosEquipamentos.add(codigo);
	equipamentos.add(equipamento); // Adicionar o equipamento à lista
	}

	public Set<Integer> getCodigosEquipamentos() {
        return codigosEquipamentos;
    }
	
	public List<String> getAlugueisClienteDetalhados(Cliente cliente) {
        List<String> alugueisDetalhados = new ArrayList<>();

        for (Aluguel aluguel : alugueisAtuais) {
            if (aluguel.getCliente().equals(cliente)) {
                String detalhesAluguel = "Cliente: " + aluguel.getCliente().getNome() +
                ", Equipamento: " + aluguel.getEquipamento().getDescricao() +
                ", Data de Início: " + aluguel.getInicio() +
                ", Data de Término: " + aluguel.getTermino();
                alugueisDetalhados.add(detalhesAluguel);
            }
        }

        for (Aluguel aluguel : alugueisPassados) {
            if (aluguel.getCliente().equals(cliente)) {
                String detalhesAluguel = "Cliente: " + aluguel.getCliente().getNome() +
                ", Equipamento: " + aluguel.getEquipamento().getDescricao() +
                ", Data de Início: " + aluguel.getInicio() +
                ", Data de Término: " + aluguel.getTermino();
                alugueisDetalhados.add(detalhesAluguel);
            }
        }
		return alugueisDetalhados;
    }

	 public void registrarCliente(Cliente novoCliente) {
	        clientes.add(novoCliente);
	    }

	public Cliente getClientePeloNome(String nomeCliente) {
	    for (Cliente cliente : clientes) {
	        if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
	            return cliente;
	        }
	    }
	    return null; // Retorna null se o cliente não for encontrado
	}

	public Equipamento getEquipamentoPeloCodigo(int codigoEquipamento) {
	    for (Equipamento equipamento : equipamentos) {
	        if (equipamento.getCodigo() == codigoEquipamento) {
	            return equipamento;
	        }
	    }
	    return null; // Retorna null se o equipamento não for encontrado
	}

}
