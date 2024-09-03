package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ProdutoUsado extends Produto{
	 private LocalDate DataFabricacao;

	public ProdutoUsado() {
		super();
	}

	public ProdutoUsado(String nome, Double preco,LocalDate DataFabricacao) {
		super(nome, preco);
		this.DataFabricacao = DataFabricacao;
	}

	public LocalDate getDataFabricacao() {
		return DataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		DataFabricacao = dataFabricacao;
	}
	 @Override
	  public String etiqueta() {
	        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        String dataFormatada = (DataFabricacao != null) ? DataFabricacao.format(fmt) : "Data não informada";
	        return "Produto: " + getNome() + ", Preço: R$ " + String.format("%.2f", getPreco()) +
	               " (Usado) - Data de fabricação: " + dataFormatada;
	    }
}
