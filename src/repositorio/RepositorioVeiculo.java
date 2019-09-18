package repositorio;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;


import basicas.Veiculo;

public class RepositorioVeiculo {
	
	public static RepositorioVeiculo instanciaVei;
	
	private RepositorioVeiculo() {
		
	}
	
	public static RepositorioVeiculo getInstancia() {
		if(instanciaVei == null) {
			instanciaVei = new RepositorioVeiculo();
		}
		return instanciaVei;
	}
	
	public void inserir (Veiculo veiculo)throws Exception {
		Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/dados;create=true;user=user;password=123");
		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO VEICULO (placa, modelo, cor, chassi) VALUES (?,?,?,?)");
		stmt.setString(1, veiculo.getPlaca());
		stmt.setString(2, veiculo.getModelo());
		stmt.setString(3, veiculo.getCor());
		stmt.setString(4, veiculo.getChassi());
		stmt.execute();
		
		conn.commit();
		conn.close();
		
	}
	
	public boolean existeVeiculo(Veiculo veiculo) throws Exception {
		boolean existe = false;
		
		Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/dados;user=user;password=123");
		
		PreparedStatement stmt = conn.prepareStatement("SELECT placa FROM CLIENTE WHHERE placa=?");
		stmt.setString(1, veiculo.getPlaca());
		ResultSet resultadoDaConsulta = stmt.executeQuery();

		if(resultadoDaConsulta != null) {
			while(resultadoDaConsulta.next()) {
				String placaDoBanco = resultadoDaConsulta.getString("placa");
				
				if(placaDoBanco != null) {
					existe = true;
				}
			}
		}
		conn.commit();
		conn.close();
		
		return false;
	}
		
	
	public void deletar(Veiculo veiculo) {
		
	}
	
	public void alterarVeic(Veiculo veiculo, Veiculo novoVeiculo) {
		
	}
	

}
