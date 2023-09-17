package business;
import java.time.LocalDate;

public class Aluguel {
	private Cliente cliente;
	private Equipamento equipamento;
	private LocalDate inicio;
	private LocalDate termino;
	private int valor;

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public LocalDate getTermino() {
		return termino;
	}
	public void setTermino(LocalDate termino) {
		this.termino = termino;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

	public Aluguel(Cliente cliente, Equipamento equipamento, LocalDate inicio, LocalDate termino) {
		this.cliente = cliente;
		this.equipamento = equipamento;
		this.inicio = inicio;
		this.termino = termino;
	}
	
	

}
