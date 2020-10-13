import java.io.IOException;

public class Arvore {
	private No raiz;
	private String binario;
	private String contador;
	
	public Arvore() 
	{
		binario = null;
		raiz = null;
		contador = "";
	}
	
	public No criarArvore(FilaPrioridade fila) 
	{
		while (true) {
            No no1 = fila.dequeue();
            No no2 = fila.dequeue();
            No no = new No(no1, no2, no1.quantidade+no2.quantidade);
            if(fila.empty()) 
            {
            	return no;
            }
            fila.enqueue(no);
        }
		
	}
		
	public void exibirPreOrdem(No raiz) {
		
		if(raiz.filho()==true) 
		{
			Contador c = new Contador();
			contador = contador + "1"+c.decBin((int)raiz.letra);
 		}
		else 
		{
			contador = contador + "0";
			exibirPreOrdem(raiz.esquerda);
			exibirPreOrdem(raiz.direita);
		}
	}
	
	public void codigoPreOrdem(ListaDinamica lista, No raiz, String bit) 
	{
		if(raiz.filho()==true) 
		{
			lista.adicionarInicio(raiz.letra, bit);
		}
		else 
		{
		codigoPreOrdem(lista,raiz.esquerda, bit + "0");
		codigoPreOrdem(lista,raiz.direita, bit + "1");	
        }
	}	
	public String tabelaCodigo(ListaDinamica lista,String texto) 
	{ 
		char[] letras = texto.toCharArray();
		StringBuilder saida = new StringBuilder();
		for(char l : letras) 
		{
			saida.append(lista.busca(l));
		}
		
		return saida.toString();
	}
	
	public No construirArvore() 
	{
		if(binario.charAt(0) == '0') 
		{
			No novo = new No(null,null,0);
			binario = binario.substring(1);		
			novo.esquerda = construirArvore();
			novo.direita = construirArvore();
			return novo;
		}
		else 
		{
			No novo = new No((char) Integer.parseInt(binario.substring(1, 9),2));
			binario = binario.substring(9);
			return novo;
		}
	}
	
	public String decodificar(String entrada) 
	{
		binario = entrada;
		String saida = "";
		raiz = construirArvore();
		No tmp = raiz;
		
		if ( binario.length() == 0 ) 
		{
            saida = Character.toString(tmp.letra);
        }
		
		else 
		{   
			while (binario.length() != 0 ) 
			{

                if (binario.charAt(0) == '0' ) 
                {
                    tmp = tmp.esquerda;
                } 
                else 
                {

                    tmp = tmp.direita;
                }

                if (tmp.filho()==true) 
                {

                    saida += Character.toString(tmp.letra);
                    tmp = raiz;
                }

                binario = binario.substring(1);
            }
        }
		return saida;
	}
	
	public String codificar(String entrada) 
	{
		String bit = "";
		String saida ="";
		Contador c = new Contador();
		FilaPrioridade fila = new FilaPrioridade();
		ListaDinamica lista = new ListaDinamica(); 
		c.adicionar(entrada, fila);
		raiz = criarArvore(fila);
	    exibirPreOrdem(raiz);
	    codigoPreOrdem(lista, raiz, bit);
	    saida = contador + tabelaCodigo(lista,entrada);
	    return saida;
	}
}
