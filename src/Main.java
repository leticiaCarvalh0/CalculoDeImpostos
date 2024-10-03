import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		double valor, frete, seguro, baseCalculo, IPI, ICMS, margemLucro, valorIPI, valorS, aliquotaPraticada, ISS, valorISS,  margemS, aliquota=0;
		int opcao=0, trajeto=0;
		
		while(opcao!=3)
		{
			System.out.println("***************MENU***************");
			System.out.println("1 - Preço Final do Produto");
			System.out.println("2 - Preço Final do Serviço");
			System.out.println("3 - Fechar");
			System.out.println("Escolha uma opção: ");
			opcao= scanner.nextInt();
			
			
			switch(opcao) {
			case 1: 
				System.out.println("Digite o valor do Produto: ");
				valor = scanner.nextDouble();
				System.out.println("Digite o frete do Produto: ");
				frete = scanner.nextDouble();
				System.out.println("Digite o valor do seguro do Produto: ");
				seguro = scanner.nextDouble();
				System.out.println("Digite a margem de lucro do Produto (decimal): ");
				margemLucro = scanner.nextDouble();
				System.out.println("Qual o trajeto do produto: \n SP para MG: 1\n MG para ES: 2\n  MG para RJ: 3");
				trajeto = scanner.nextInt();
				
				if(trajeto == 1) {
					aliquota = 0.18;
				}
				else if(trajeto == 2) {
					aliquota=0.07;
				}
				else if(trajeto == 3) {
					aliquota = 0.12;
				}
				else {
					System.out.println("Opção Inválida");
				}
			
			
			baseCalculo = valor+frete+seguro;
			ICMS = valor*aliquota;
			IPI = baseCalculo*(15/100);
			valorIPI = valor+IPI+ICMS+margemLucro;
			System.out.println("Preço Final (SP para MG): "+ valorIPI);
			break;
			
			
			case 2:
				System.out.println("Valor do Serviço: ");
				valorS = scanner.nextDouble();
				System.out.println("Aliquota do Serviço: ");
				aliquotaPraticada = scanner.nextDouble();
				aliquotaPraticada = aliquotaPraticada/100;
				System.out.println("Margem de Lucro do Serviço (decimal): ");
				margemS = scanner.nextDouble();
				
				ISS = aliquotaPraticada*valorS;
				ICMS = valorS*(12/100);
				valorISS = valorS+ICMS+ISS+margemS;
				
				System.out.println("Preco Final do Servico: "+ valorISS);
				break;
			case 3:
				System.out.println("Fechando....");
			default:
					System.out.println("Opção inválida");
			}
		}scanner.close();
	}
}
