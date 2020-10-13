
public class No {
	public char letra;
	public int quantidade;
	public String bit;
	public No proximo;
	public No esquerda;
	public No direita;
	
	public No(char letra, int quantidade) {
		this.proximo = null;
		this.letra = letra;
		this.quantidade = quantidade;
	}
	
	public No(No esquerda, No direita, int quantidade) 
	{
		this.letra = '/';
		this.esquerda = esquerda;
		this.direita = direita;
		this.quantidade = quantidade;
	}
	
	public No(char letra) {
		this.letra = letra;
		this.esquerda = null;
		this.direita = null;
	}
	
	public No(char letra,String bit) {
		this.letra = letra;
		this.bit = bit;
		this.esquerda = null;
		this.direita = null;
	}
	
	public boolean filho() 
	{
		if (esquerda == null && direita == null) 
		{
			return true;
		}
		
		else return false;
	}	

}