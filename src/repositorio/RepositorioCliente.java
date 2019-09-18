
package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import basicas.Cliente;

public class RepositorioCliente {

	private static RepositorioCliente instanciaCli;

	private RepositorioCliente() {

	}

	public static RepositorioCliente getInstancia() {
		if (instanciaCli == null) {
			instanciaCli = new RepositorioCliente();
		}
		return instanciaCli;
	}

	public void inserir(Cliente cliente) throws Exception {
		// carregar driver
		System.out.println("Carregando o drive do derby");
		Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		System.out.println("Drive do derby carregado");

		// abrir conexão com o banco
		System.out.println("Abrindo conexão com o banco");
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/dados;create=true;user=user;password=123");
		System.out.println("Conexão aberta");

		// realizar consulta no banco
		System.out.println("Inserindo dados no banco");
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO CLIENTE (nome, cpf, rg, endereco, fone) VALUES (?,?,?,?,?)");
		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getCpf());
		stmt.setString(3, cliente.getRg());
		stmt.setString(4, cliente.getEndereco());
		stmt.setString(5, cliente.getFone());
		stmt.execute();
		System.out.println("Dados inseridos");

		// fehcar conexão
		conn.commit();
		conn.close();
		System.out.println("Conexão do banco fechada");

	}

	public void deletar(Cliente cliente) {
		
	}

	public void alterar(Cliente cliente, Cliente novoCliente) {
		
	}

	public boolean existeCliente(Cliente cliente) throws Exception {
		boolean existe = false;
		
		Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/dados;create=true;user=user;password=123");
		
		PreparedStatement stmt = conn.prepareStatement("SELECT cpf FROM CLIENTE WHHERE cpf=?");
		stmt.setString(1, cliente.getCpf());
		ResultSet resultadoDaConsulta = stmt.executeQuery();

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
		
		return existe;
	}
}


