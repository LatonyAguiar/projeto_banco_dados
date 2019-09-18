package basicas;

public class Veiculo {

	private String placa;
	private String modelo;
	private String cor;
	private String chassi;

	public Veiculo(String placa, String modelo, String cor, String chassi) {
		this.placa = placa;
		this.modelo = modelo;
		this.cor = cor;
		this.chassi = chassi;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

}
