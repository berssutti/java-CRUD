import java.util.ArrayList;
import java.util.Scanner;

/* Esse é um programa de um sistema de cadastros que permite o usurio cadastrar, pessoas, produtos e vendas,
 * além de permitir a busca por produtos e cliente ja cadastrados e visualizar o estoque
 */
public class SistemaCadastro {


		// Mostra o menu do usuario
	public static void menu(){
			System.out.println("Bom dia!\nO que desaja fazer ?");	
			System.out.println("Digite 1 para fazer cadastro de clientes.");
			System.out.println("Digite 2 para buscar por um cliente.");
			System.out.println("Digite 3 para cadastrar um novo produto.");
			System.out.println("Digite 4 para buscar por um produtos.");
			System.out.println("Digite 5 para ir ao cadastro de venda.");
			System.out.println("Digite 6 para mostrar os produtos em estoque.");
			System.out.println("Digite 7 para sair.");
		}
		
		// Main, onde se encontra o loop principal do codigo, que faz a interface ser mostrada no final de cada caso
	public static void main(String[] args) {
			
			// Atribuições
			ArrayList<String> nomes = new ArrayList<String>();
			ArrayList<String> telefones = new ArrayList<String>();
			ArrayList<String> ceps = new ArrayList<String>();
			ArrayList<String> produtos = new ArrayList<String>();
			ArrayList<String> descricao = new ArrayList<String>();
			ArrayList<String> valor = new ArrayList<String>();
			ArrayList<String> lucro = new ArrayList<String>();
			ArrayList<Integer> quantidade = new ArrayList<Integer>();
			ArrayList<String> compra = new ArrayList<String>();
			addCadastro( produtos,descricao,valor,lucro,quantidade,nomes,telefones,ceps);
			int escolha=0;
			
			//Loop principal do codigo
			while(escolha<1 || escolha>7){
				menu();
				escolha = escolhaMenu();
				switch(escolha){
					case 1:
						cadastroCliente(nomes, telefones, ceps);
						System.out.println("Pessoas cadastrados: \n");
						for(int i=0;i<nomes.size();i++){
							System.out.println("nome: " + nomes.get(i) + " / telefone: " + telefones.get(i) + " / CEP: " + ceps.get(i));
						}
						escolha = 0;
						break;
					case 2:
						mostraCliente(nomes, telefones, ceps);
						escolha = 0;
						break;
					case 3:
						cadastroProduto(produtos,descricao,valor,lucro, quantidade);
						System.out.println("Produtos cadastrados: \n");
						for(int i=0;i<produtos.size();i++){
							System.out.println("produto: " + produtos.get(i) + " / descricao: " + descricao.get(i) + "\n" + "/ valor: " + valor.get(i) + "/ lucro: " + lucro.get(i) + "/ quantidade em estoque: " + quantidade.get(i)+"\n");
						}
						escolha = 0;
						break;
					case 4:
						mostraProduto(produtos,descricao,valor,lucro,quantidade);
						escolha = 0;
						break;
					case 5:
						
						cadastroVenda(produtos,quantidade,nomes,compra);
						escolha = 0;
						break;
					case 6:
						mostraEstoque(produtos,quantidade);
						escolha = 0;
						break;
					case 7:
						break;
					default:
						System.out.println("Opcao nao encontrada, digite novamente");
				}
			}
			
		}
		
		// Lista  previa de cadastro de produtos e pessoas
	public static void addCadastro(ArrayList<String> produtos,ArrayList<String> descricao,ArrayList<String> valor,ArrayList<String> lucro,ArrayList<Integer> quantidade,ArrayList<String> nomes,ArrayList<String> telefones,ArrayList<String> ceps) {
			nomes.add("Victor");
			nomes.add("João Marcos");
			nomes.add("Bernardo");
			nomes.add("Guilherme");
			nomes.add("Enzo");
			nomes.add("Gabriela");
			nomes.add("Arthur");
			nomes.add("Fernanda");
			nomes.add("Caroline");
			nomes.add("Amanda");
			telefones.add("123456789");
			telefones.add("234567890");
			telefones.add("345567890");
			telefones.add("4567890912");
			telefones.add("567890123");
			telefones.add("678901234");
			telefones.add("789012345");
			telefones.add("890123456");
			telefones.add("901234567");
			telefones.add("907856342");
			ceps.add("21567395");
			ceps.add("12345678");
			ceps.add("23456789");
			ceps.add("45678901");
			ceps.add("34567890");
			ceps.add("56789012");
			ceps.add("67890123");
			ceps.add("78901234");
			ceps.add("89012345");
			ceps.add("90123456");
			produtos.add("Cama");
			produtos.add("Armario");
			produtos.add("Escrivaninha");
			produtos.add("Lampada");
			produtos.add("Azulejo");
			produtos.add("Estante");
			produtos.add("Mesa");
			produtos.add("Cadeira");
			produtos.add("Abajur");
			produtos.add("Gaveta");
			descricao.add("Confortavel");
			descricao.add("Cabe muito roupa");
			descricao.add("cor: Branca");
			descricao.add("De led");
			descricao.add("Bonito");
			descricao.add("Alta");
			descricao.add("Robusta");
			descricao.add("Acochoada");
			descricao.add("Tem luz forte");
			descricao.add("Para o armario");
			valor.add("500");
			valor.add("1200");
			valor.add("375");
			valor.add("20");
			valor.add("15");
			valor.add("400");
			valor.add("560");
			valor.add("670");
			valor.add("56");
			valor.add("36");
			lucro.add("15");
			lucro.add("15");
			lucro.add("15");
			lucro.add("15");
			lucro.add("15");
			lucro.add("15");
			lucro.add("15");
			lucro.add("15");
			lucro.add("15");
			lucro.add("15");
			quantidade.add(14);
			quantidade.add(24);
			quantidade.add(24);
			quantidade.add(70);
			quantidade.add(300);
			quantidade.add(24);
			quantidade.add(24);
			quantidade.add(24);
			quantidade.add(55);
			quantidade.add(65);
		

		}

		// Restorna a escolha que o usuario fez no menu (1,2,3,4,5,6 ou 7) para ser usado no switch da main
	public static int escolhaMenu() {
			Scanner ler = new Scanner(System.in);
			int escolha = ler.nextInt();
				
			return(escolha);
		}
		
		// Faz o cadastro de um cliente
	public static void cadastroCliente(ArrayList<String> nomes,ArrayList<String> telefones,ArrayList<String> ceps ) {
			Scanner ler = new Scanner(System.in);
			String nome;
			String cep;
			String telefone;
		
			System.out.printf("Quantos clientes serao cadastrados? \n");
			int qtdCadastros = ler.nextInt();
			ler.nextLine();
			
			
			for(int cont = 0; cont<qtdCadastros;cont++) {
				System.out.println("Digite um nome que deseja cadastrar: \n");
				nome = ler.nextLine();
				nomes.add(nome);
				
				System.out.println("Digite o telefone: \n");
				telefone = ler.nextLine(); 
				telefones.add(telefone);
				
				System.out.println("Digite o CEP: \n");
				cep = ler.nextLine();
				ceps.add(cep);
			}
		}
		
		// Faz a busca no cadastro pela pessoa que o usuario digitou
	public static void mostraCliente(ArrayList<String> nomes,ArrayList<String> telefones,ArrayList<String> ceps) {
			Scanner ler = new Scanner(System.in);
		
			System.out.println("Digite um nome que deseja procurar: \n");
			String cliente = ler.nextLine();
			int i = 0;
			boolean encontrou = false;
			// logica para mostrar o cliente, caso exista, caso não exista mostra "esse cliente não foi cadastrado"
			do{
				if(nomes.get(i).equals(cliente)) {
					System.out.println("Cliente encontrado: " + "nome: " + nomes.get(i) + " / telefone: " + telefones.get(i) + " / CEP: " + ceps.get(i));
					encontrou = true;
					break;
					
				}else i++;
				
			}while(i<nomes.size());
			if(encontrou == false) {
				System.out.println("Esse nome não foi encontrado\n");

			}
		}
		
		// Permite o usuario cadastrar um novo produto e suas especificacoes
	public static void cadastroProduto(ArrayList<String> produtos,ArrayList<String> descricao,ArrayList<String> valor,ArrayList<String> lucro,ArrayList<Integer> quantidade) {
			Scanner ler = new Scanner(System.in);
			String produto;
			String descri;
			String val;
			String luc;
			int qtd;
			
			System.out.printf("Quantos produtos serao cadastrados? \n");
			int qtdProdutos = ler.nextInt();
			ler.nextLine();
			
			for(int cont = 0; cont<qtdProdutos;cont++) {
				System.out.println("Digite um produto que deseja cadastrar: \n");
				produto = ler.nextLine();
				produtos.add(produto);
				
				System.out.println("Digite a descricao do produto: \n");
				descri = ler.nextLine(); 
				descricao.add(descri);
				
				System.out.println("Digite o valor do produto: \n");
				val = ler.nextLine();
				valor.add(val);
				
				System.out.println("Digite a porcentagem de lucro (nao precisa do %): \n");
				luc = ler.nextLine();
				lucro.add(luc);
				
				System.out.println("Digite a quantidade em estoque do produto: \n");
				qtd = ler.nextInt();ler.nextLine();
				quantidade.add(qtd);
			}
			
			
		}
		
		// Faz a busca no cadastro pelo produto que o usuario digitou
	public static void mostraProduto(ArrayList<String> produtos,ArrayList<String> descricao,ArrayList<String> valor,ArrayList<String> lucro,ArrayList<Integer> quantidade) {
			Scanner ler = new Scanner(System.in);
			
			System.out.println("Digite um produto que deseja procurar: \n");
			String produto = ler.nextLine();
			int i = 0;
			boolean encontrou = false;
			// logica para mostrar o cliente, caso exista, caso não exista mostra "esse cliente não foi cadastrado"
			do{
				if(produtos.get(i).equals(produto)) {
					System.out.println("Produto encontrado: " + "Produto: " + produtos.get(i) + " / descrição: " + descricao.get(i) + " / valor: " + valor.get(i) + " / lucro: " + lucro.get(i) + "/ quantidade: " + quantidade.get(i) + "\n");
					encontrou = true;
					break;
					
				}else i++;
				
			}while(i<produtos.size());
			if(encontrou == false) {
				System.out.println("Esse produto não foi encontrado\n");

			}
		}
		
		// Faz o cadastro de uma venda feita por algum cliente previamente cadastrado, e atualiza a quantidade desse produto no estoque
	public static void cadastroVenda(ArrayList<String> produtos,ArrayList<Integer> quantidade,ArrayList<String> nomes,ArrayList<String> compras) {
			Scanner ler = new Scanner(System.in);
			int j = 1;
			int escolha; // para o nome
			int escolhap; // para o produto
			int i;
			int k;
			String compra;
			boolean repete = false;
			// escolher o nome
			do{
				System.out.println("Selecione o numero correspondente ao nome que deseja cadastrar a venda: \n");
				for(i=0;i<nomes.size();i++){
					System.out.println(j + " " + nomes.get(i) + "\n");
					j++;
				}
				escolha = ler.nextInt();
				if( escolha - 1 < 0 || escolha > nomes.size()) {
					repete = true;
					System.out.println("A opcao que vc escolheu nao existe, escolha novamente \n");
					j = 1;
				}
				else
					repete = false;
			}while(repete == true);
			j = 1;
			repete = false;
			boolean repete1 = false;
			// escolher produto
			do {
				do{
					System.out.println("Selecione o numero correspondente ao produto que deseja cadastrar a venda: \n");
					for( k=0;k<produtos.size();k++){
						System.out.println(j + " " + produtos.get(k) + "\n");
						j++;
					}
					escolhap = ler.nextInt();
					if( escolhap - 1 < 0 || escolhap > produtos.size()) {
						repete = true;
						System.out.println("A opcao que vc escolheu nao existe, escolha novamente \n");
						j = 1;
					}else repete = false;
				}while(repete == true);
				j = 1;
				System.out.println("Quantos desse produto que deseja cadastrar? \n");
				int qtdCompra = ler.nextInt();ler.nextLine();
					while(qtdCompra > quantidade.get(escolhap - 1)){
						System.out.println("Nao ha quantidade suficiente em estoque! \n");
						System.out.println("Quantos desse produto que deseja cadastrar? \n");
						qtdCompra = ler.nextInt();ler.nextLine();
					}
				compras.add(nomes.get(escolha - 1) + " comprou " + qtdCompra + " unidades do produto " + produtos.get(escolhap - 1) + "\n");

				// Subtrai a quantidade comprada do total em estoque
				int antes = quantidade.get(escolhap -1);
				quantidade.remove(escolhap -1);
				quantidade.add(escolhap -1, antes - qtdCompra);
				for(int l=0;l<compras.size();l++){
					System.out.println(compras.get(l) + "\n");
				}

				
				// Condicao para o loo ocorrer
				System.out.println("Deseja cadastrar outro produto para esse cliente?(S/N) \n");
				char simNao = ler.nextLine().charAt(0);
				char simNaolower = Character.toLowerCase(simNao);
				if(simNaolower == 's') {
					repete1 = true;
				}
				else
					repete1 = false;
				j = 1;
			}while(repete1 == true);
			
		}
		
		// Mostra os produtos cadastrados e a quantidade deles
	public static void mostraEstoque(ArrayList<String> produtos,ArrayList<Integer> quantidade){
			for(int i=0;i<produtos.size();i++){
				System.out.println("Produto: " + produtos.get(i) + " / Quantidade do produto em estoque: " + quantidade.get(i));
			}
		}
}