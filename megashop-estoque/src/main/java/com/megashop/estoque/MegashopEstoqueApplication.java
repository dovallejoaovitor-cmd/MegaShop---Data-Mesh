package com.megashop.estoque;

import com.megashop.estoque.Entities.Product;
import com.megashop.estoque.Service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class MegashopEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MegashopEstoqueApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ProductService service){
		return args ->{
			Scanner sc = new Scanner(System.in);

			System.out.println("===MEGASHOPR ESTOQUE===");
			System.out.println("1 - Cadastrar produto");
			System.out.println("2 - Listar produto");
			System.out.println("3 - Buscar produto");
			System.out.println("4 - Atualizar preço e/ou quantidade");
			System.out.println("5 - Excluir produto");

			int option = sc.nextInt();

			sc.nextLine();

			switch (option){
				case 1:

					System.out.println("Nome: ");
					String name = sc.nextLine();

					System.out.println("Preço: ");
					Double price = sc.nextDouble();

					System.out.println("Quantidade: ");
					Integer quantity = sc.nextInt();

					Product p = new Product();

					p.setName(name);
					p.setPrice(price);
					p.setQuantity(quantity);

					Product saved = service.insert(p);

					System.out.println("Produto Cdastrado!");
					System.out.println("ID: " + saved.getId());

					break;

				case 2:

					service.findAll().forEach(System.out::println);

					break;

				case 3:

					System.out.println("Digite o id do produto: ");
					Long id = sc.nextLong();

					Product product = service.findById(id);

					System.out.println(product);

					break;

				case 4:

					System.out.println("1 - Alterar quantidade e preço");
					System.out.println("2 - Alterar somente a quantidade");
					System.out.println("3 - Alterar somente o preço");

					int option2 = sc.nextInt();

					sc.nextLine();

					switch(option2){

						case 1:

							System.out.println("Digite o id: ");
							Long id1 = sc.nextLong();

							System.out.println("Digite o novo preço: ");
							Double newPrice = sc.nextDouble();

							System.out.println("Digite a nova quantidade: ");
							Integer newQuantity = sc.nextInt();

							Product pr = new Product();
							pr.setPrice(newPrice);
							pr.setQuantity(newQuantity);

							service.updatePriceQuantity(id1, pr);

							break;

						case 2:

							System.out.println("Digite o id: ");
							Long id2 = sc.nextLong();

							System.out.println("Digite a nova quantidade: ");
							Integer newQtd = sc.nextInt();

							Product newPr = new Product();
							newPr.setQuantity(newQtd);

							service.updateQuantity(id2, newPr);

							break;

						case 3:

							System.out.println("Digite o id: ");
							Long id3 = sc.nextLong();

							System.out.println("Digite o novo preço: ");
							Double newPri = sc.nextDouble();

							Product pro = new Product();
							pro.setPrice(newPri);

							service.updatePrice(id3, pro);

							break;

						default:

							System.out.println("Inválido");

							break;
					}
				case 5:

					System.out.println("Digite o id: ");
					Long id4 = sc.nextLong();

					service.delete(id4);

					break;
			}


			sc.close();
		};
	}
}
