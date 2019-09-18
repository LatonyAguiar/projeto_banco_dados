package basicas;

public class Aluguel {

	private Double valor;
	private String veiculo;
	private String cliente;
	
	public Aluguel(Double valor, String veiculo, String cliente) {
		this.valor = valor;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	
	
	/*public int getTotalDeHoras() {
		int result = 0;

		long tempoDeChegada = this.dataChegada.getTime();
		long tempoDeSaida = this.getDataSaida().getTime();

		result = (int) (tempoDeChegada - tempoDeSaida);
		return result;
	}*/
}
