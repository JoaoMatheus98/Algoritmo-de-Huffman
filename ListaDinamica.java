
public class ListaDinamica {
	public No primeiro;
	public No ultimo;
	
	public ListaDinamica() {
		primeiro = null;
		ultimo = null;
	}

	public void adicionarInicio(char letra, String bit) 
	{
		No novo = new No(letra, bit);

		if (primeiro == null) {
			primeiro = novo;
			ultimo = novo;
		} else {
			novo.proximo = primeiro;
			primeiro = novo;
		}
	}
	
	public String busca(char letra) 
	{
		No aux = primeiro;
		while(aux!=null) 
		{
			if(aux.letra==letra) 
			{
				return aux.bit;
			}
			aux = aux.proximo;
		}
		
		return null;
	}

}
