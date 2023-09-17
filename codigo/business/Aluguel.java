package business;
import java.time.LocalTime;

public class Aluguel {
	private Cliente cliente;
	private Equipamento equipamento;
	private LocalTime inicio;
	private LocalTime termino;
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
	public LocalTime getInicio() {
		return inicio;
	}
	public void setInicio(LocalTime inicio) {
		this.inicio = inicio;
	}
	public LocalTime getTermino() {
		return termino;
	}
	public void setTermino(LocalTime termino) {
		this.termino = termino;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

	public Aluguel(Cliente cliente, Equipamento equipamento, LocalTime inicio, LocalTime termino) {
		this.cliente = cliente;
		this.equipamento = equipamento;
		this.inicio = inicio;
		this.termino = termino;
	}
	
	

}
