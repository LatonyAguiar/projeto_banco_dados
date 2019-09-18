package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basicas.Veiculo;
import controlador.ControladorVeiculo;

@WebServlet("/CadastroVeiculoServlet")
public class CadastroVeiculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String placa = request.getParameter("placaVeiculo");
		String chassi = request.getParameter("chassiVeiculo");
		String modelo = request.getParameter("modeloVeiculo");
		String cor = request.getParameter("corVeiculo");
		
		Veiculo novoVeiculo = new Veiculo(placa, modelo, cor, chassi);
		ControladorVeiculo controlador = new ControladorVeiculo();
		
		try {
			controlador.cadastrarVeiculo(novoVeiculo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Cadastro do veiculo de placa: "+ placa + " Cor " + cor+ " feito!");
	}

}
