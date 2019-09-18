package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import basicas.Aluguel;
import basicas.Cliente;
import basicas.Veiculo;

public class RepositorioAluguel {

	private static RepositorioAluguel instanciaAlug;

	private RepositorioAluguel() {

	}

	public static RepositorioAluguel getInstancia() {
		if (RepositorioAluguel.instanciaAlug == null) {
			RepositorioAluguel.instanciaAlug = new RepositorioAluguel();
		}
		return RepositorioAluguel.instanciaAlug;
	}

	public void inserirAluguel(Aluguel aluguel) throws Exception {

		Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		Connection conn = DriverManager
				.getConnection("jdbc:derby://localhost:1527/dados;create=true;user=user;password=123");

		PreparedStatement stmt = conn.prepareStatement("INSERT INTO ALUGUEL (valor, veiculo, cliente) VALUES (?,?,?)");

		stmt.setDouble(1, aluguel.getValor());
		stmt.setString(2, aluguel.getVeiculo());
		stmt.setString(3, aluguel.getCliente());
		stmt.execute();
		conn.commit();
		conn.close();
	}

	public boolean existeAluguel(String cliente, String veiculo) throws Exception {

		boolean existeC = false;
		boolean existeP = false;

		Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/dados;user=user;password=123");

		PreparedStatement stmt = conn.prepareStatement("SELECT cpf FROM CLIENTE WHERE cpf=?");
		stmt.setString(1, cliente);
		ResultSet resultadoCpf = stmt.executeQuery();

		if (resultadoCpf != null) {
			while (resultadoCpf.next()) {
				String cpfBanco = resultadoCpf.getString("cpf");

				if (cpfBanco != null) {
					existeC = true;
				}
			}
		}
		stmt = conn.prepareStatement("SELECT placa FROM VEICULO WHERE placa=?");
		stmt.setString(1, veiculo);
		ResultSet resultadoPlaca = stmt.executeQuery();

		if (resultadoPlaca != null) {
			while (resultadoPlaca.next()) {
				String placaBanco = resultadoPlaca.getString("placa");

				if (placaBanco != null) {
					existeP = true;
				}
			}
		}
		if (existeC && existeP == false) {
			return false;
		}

		conn.commit();
		conn.close();

		return true;
	}
	public void deletar(Aluguel aluguel) {

	}

	public void alterar(Aluguel aluguel, Aluguel novoAluguel) {

	}

}
