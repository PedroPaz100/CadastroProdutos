package aplicacao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImport;
import entidades.ProdutoUsado;
public class Main {

	public static void main(String[] args) {
	Locale.setDefault(Locale.US);
	Scanner sc= new Scanner(System.in);
	System.out.println("Numero de produtos");
	int n=sc.nextInt();
	sc.nextLine();
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	List<Produto> produtos=new ArrayList<>();
	
	for(int i = 0; i < n; i++) {
	    System.out.println("Produto #" + (i + 1));
	    System.out.println("Novo, Usado, Importado (N/U/I)");
	    String estado = sc.nextLine();
	    
	    if(estado.equalsIgnoreCase("N")) {
	    	System.out.println("Nome:");
	        String nome=sc.nextLine();
	        System.out.println("Preço:");
	        double preco=sc.nextDouble();
	        sc.nextLine();
	        Produto x=new Produto(nome,preco);
	        produtos.add(x);
	    } 
	    else if(estado.equalsIgnoreCase("U")) {
	    	System.out.println("Nome:");
	        String nome=sc.nextLine();
	        System.out.println("Preço:");
	        double preco=sc.nextDouble();
	        sc.nextLine();
	        System.out.println("Data de Fabricação:(dd/mm/yyy)");
	        String data=sc.nextLine();
	        LocalDate dataFabricacao = LocalDate.parse(data, fmt);
	        Produto y=new ProdutoUsado(nome,preco,dataFabricacao);
	        produtos.add(y);
	       
	    } else if(estado.equalsIgnoreCase("I")) {
	    	System.out.println("Nome:");
	        String nome=sc.nextLine();
	        System.out.println("Preço:");
	        double preco=sc.nextDouble();
	        sc.nextLine();
	        System.out.println("Imposto:");
	        Double imposto=sc.nextDouble();
	        sc.nextLine();
	        Produto z=new ProdutoImport(nome,preco,imposto);
	        produtos.add(z);
	    } else {
            System.out.println("Estado inválido. Por favor, insira N, U ou I.");
            
        }
	}
	System.out.println("Preço Etiquetas:");
    for (Produto produto : produtos) {
        System.out.println(produto.etiqueta());
    }
	sc.close();

	}

}
