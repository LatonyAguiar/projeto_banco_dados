package controlador;

import basicas.Cliente;
import repositorio.RepositorioCliente;

public class ControladorCliente {

	public void inserirCliente(Cliente novoCliente) throws Exception {
		
		System.out.println("Chamando o controlador para chamar o repositorio");
		RepositorioCliente rep = RepositorioCliente.getInstancia();
		rep.inserir(novoCliente);
		/*try {
			System.out.println("Chamando o controlador para chamar o repositorio");
			RepositorioCliente rep = RepositorioCliente.getInstancia();

			boolean existe = false;
			existe = rep.existeCliente(novoCliente);

			if (!existe) {
				rep.inserir(novoCliente);
				System.out.println("Metodo inserir do repositorio no controlador chamado");
			} else {
				System.out.println("Usuario ja cadastrado!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void deletarCliente(Cliente cliente) {

	}

	public void alterarCliente(Cliente cliente, Cliente novoCliente) {

	}

}
