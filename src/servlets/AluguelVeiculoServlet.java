package servlets;

import java.io.IOException;
import java.nio.channels.DatagramChannel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basicas.Aluguel;
import controlador.ControladorAluguel;
import repositorio.RepositorioAluguel;

@WebServlet("/AluguelVeiculoServlet")
public class AluguelVeiculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Double valor = (Double.parseDouble(request.getParameter("valorAluguel")));
		String veiculo = request.getParameter("veiculoAluguel");
		String cliente = request.getParameter("clienteAluguel");

		Aluguel novoAluguel = new Aluguel(valor, veiculo, cliente);

		ControladorAluguel controlador = new ControladorAluguel();

		RepositorioAluguel repA = RepositorioAluguel.getInstancia();

		try {
			if (repA.existeAluguel(cliente, veiculo) == true) {
				controlador.inserirAluguel(novoAluguel);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("Deu merda");
		}

		/*try {
			controlador.inserirAluguel(novoAluguel);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		System.out.println("Aluguel do veiculo " + novoAluguel.getVeiculo() + " para o cliente "
				+ novoAluguel.getCliente() + " realizado!");
	}

}
