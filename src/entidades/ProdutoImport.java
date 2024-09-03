package entidades;

public class ProdutoImport extends Produto {
	protected Double imposto;

	public ProdutoImport() {
		super();
	}

	public ProdutoImport(String nome, Double preco,Double imposto) {
		super(nome, preco);
		this.imposto = imposto;
	}

	public Double getImposto() {
		return imposto;
	}

	public void setImposto(Double imposto) {
		this.imposto = imposto;
	}
	public double precototal() {
		double pt=preco+imposto;
		return pt;
	}
	@Override
	  public String etiqueta() {
        // Verifica se o imposto é nulo e define um valor padrão se for o caso.
        double impostoReal = (imposto != null) ? imposto : 0.0;
        double precoFinal = getPreco() + impostoReal;
        return "Produto: " + getNome() + ", Preço: R$ " + String.format("%.2f", getPreco()) +
               " (Importado) - Imposto: R$ " + String.format("%.2f", impostoReal) +
               ", Preço final: R$ " + String.format("%.2f", precoFinal);
    }
}
