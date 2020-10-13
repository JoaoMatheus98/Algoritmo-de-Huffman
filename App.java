import java.io.IOException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException {
		String caminho,caminho2;
		String texto;
		int op;
		Scanner entrada = new Scanner(System.in);
		Arvore arv = new Arvore();
		Arquivo arq = new Arquivo();
		
		System.out.println("Digite 1 para codificar e 2 para decodificar");
		op = entrada.nextInt();
		
		if(op==1) 
		{
			System.out.println("Digite o caminho do arquivo");	
			caminho = entrada.next();
			texto = arq.texto(caminho);
			System.out.println("Digite o caminho de saida do arquivo");
			caminho2 = entrada.next();
			arq.escritorEnc(caminho2, arv, texto);
		}
		else 
		{
			System.out.println("Digite o caminho do arquivo");	
			caminho = entrada.next();
			texto = arq.texto(caminho);
			System.out.println("Digite o caminho de saida do arquivo");	
			caminho2 = entrada.next();
			arq.escritorDec(caminho2, arv, texto);
		}
	}

}
