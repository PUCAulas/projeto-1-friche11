package business;

public class Equipamento {

	private int codigo;
    private String descricao;
    private double valorDiario;

    public Equipamento(int codigo, String descricao, double valorDiario) {
    	 if (descricao.length() < 5) {
            System.out.println("O código do equipamento deve ter pelo menos 5 caracteres.");
         }
         if (descricao == null || descricao.isEmpty()) {
        	 System.out.println("A descrição do equipamento não pode estar vazia.");
         }

         this.codigo = codigo;
         this.descricao = descricao;
         this.valorDiario = valorDiario;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
    	if (descricao.length() < 5) {
            System.out.println("O código do equipamento deve ter pelo menos 5 caracteres.");
         }
         if (descricao == null || descricao.isEmpty()) {
        	 System.out.println("A descrição do equipamento não pode estar vazia.");
         }
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }
    
    
}
