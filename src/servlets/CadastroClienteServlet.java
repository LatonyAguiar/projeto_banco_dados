package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basicas.Cliente;
import controlador.ControladorCliente;

@WebServlet("/CadastroClienteServlet")
public class CadastroClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nomeCliente");
		String cpf = request.getParameter("cpfCliente");
		String rg = request.getParameter("rgCliente");
		String endereco = request.getParameter("enderecoCliente");
		String fone = request.getParameter("foneCliente");

		System.out.println("Criando novo cliente ");
		Cliente novoCliente = new Cliente(nome, cpf, rg, endereco, fone);
		System.out.println("instanciando controlador que vai chamar o repositorio");
		ControladorCliente crtCliente = new ControladorCliente();
		
		
		try {
			System.out.println("Chamando metodo inserir do controlador que vai chamar do repositorio");
			crtCliente.inserirCliente(novoCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Cliente " + novoCliente.getNome() + " cadastrado com sucesso!");
	}

}
