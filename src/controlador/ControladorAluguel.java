package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import basicas.Aluguel;
import basicas.Cliente;
import basicas.Veiculo;
import repositorio.RepositorioAluguel;

public class ControladorAluguel {
	
	public void inserirAluguel(Aluguel aluguel)throws Exception {
		System.out.println("Chamando o repositorio no controlador para inserir o aluguel");
		
		RepositorioAluguel rep = RepositorioAluguel.getInstancia();
		
		rep.inserirAluguel(aluguel); 
		
		
	}
	
	public boolean consultaAluguel (Veiculo veiculo, Cliente cliente)throws Exception {
		
		Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/dados;user=user;password=123");
		
		PreparedStatement stmt = conn.prepareStatement("SELECT cpf FROM CLIENTE WHERE cpf=?");
		stmt.setString(1, cliente.getCpf());
		ResultSet resultadoDaConsulta = stmt.executeQuery();

		boolean existe = false;
		if(resultadoDaConsulta != null) {
			while(resultadoDaConsulta.next()) {
				String cpfDoBanco = resultadoDaConsulta.getString("cpf");
				
				if(cpfDoBanco != null) {
					existe = true;
				}
			}
		}
		conn.commit();
		conn.close();
		
		return false;
	}
	
	public void deletarAluguel(Aluguel aluguel) {
		RepositorioAluguel rep = RepositorioAluguel.getInstancia();
		rep.deletar(aluguel);
	}
	
	public void alterarAluguel(Aluguel aluguel, Aluguel novoAluguel) {
		RepositorioAluguel rep = RepositorioAluguel.getInstancia();
		rep.alterar(aluguel, novoAluguel);
	}
		
}
