
public class Contador {

	public void adicionar(String texto, FilaPrioridade fila) 
	{
		int v[] = new int[256];
		int codigo;
		int tamanho = texto.length();
		
		for(int i = 0; i<tamanho; i++) 
		{
			codigo = (int) texto.charAt(i);
			v[codigo]++;
		}
		
		inserir(fila,v);
	}
	
	public void inserir(FilaPrioridade fila,int v[]) 
	{
		int tamanho = v.length;
		for(int i = 0; i<tamanho; i++) 
		{
			if(v[i] > 0) 
			{
				char letra = (char) i;
				No novo = new No(letra, v[i]); 
				fila.enqueue(novo);
			}
		}
	}
	
	public String decBin(int num) 
	{
		int valor;
		String binario = "";
		do 
		{
			valor = num % 2;
			binario += valor;
			num = num / 2;
		}
		while(num != 0);
		
		while(binario.length()<8) 
		{
			binario = binario+"0";
		}
		
		binario = new StringBuilder(binario).reverse().toString();
		
		return binario;
	}
}
