package controlador;

import basicas.Veiculo;
import repositorio.RepositorioVeiculo;

public class ControladorVeiculo {

		public void cadastrarVeiculo(Veiculo veiculo) throws Exception {
		
			RepositorioVeiculo rep = RepositorioVeiculo.getInstancia();
			rep.inserir(veiculo);
		}
		public void deletarVeiculo(Veiculo veiculo) {
			RepositorioVeiculo rep = RepositorioVeiculo.getInstancia();
			rep.deletar(veiculo);
		}
		public void alterarVeiculo (Veiculo veiculo, Veiculo novoVeiculo) {
			RepositorioVeiculo rep = RepositorioVeiculo.getInstancia();
			rep.alterarVeic(veiculo, novoVeiculo);
		}
		
}
