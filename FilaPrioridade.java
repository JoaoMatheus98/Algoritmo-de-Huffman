
public class FilaPrioridade {
	public No primeiro;
	public No ultimo;
	
	public FilaPrioridade() {
		this.primeiro = null;
		this.ultimo = null;
	}
	
	public void enqueue(No novo) 
	{
		
		if(primeiro==null) 
		{
			primeiro = novo;
			ultimo = novo;
			ultimo.proximo = null;			
		}
		
		else 
		{
			No aux;
			No anterior;
			anterior = null;
			aux = primeiro;
			while(aux != null && novo.quantidade >= aux.quantidade) 
			{
				anterior = aux;
				aux = aux.proximo;
			}
			
			if(anterior == null) 
			{
				novo.proximo = primeiro;
				primeiro = novo;
			}
			
			else if(aux == null) 
			{
				ultimo.proximo = novo;
				ultimo = novo;
				ultimo.proximo = null;
			}
			
			else 
			{
				anterior.proximo = novo;
				novo.proximo = aux;
			}
		}
	}
	
	public boolean empty() 
	{
		if(primeiro==null) return true; 
		else return false;
	}
		
	public No dequeue() 
	{
		if(primeiro!=null) 
		{
			No aux = primeiro;
			primeiro = primeiro.proximo;
			aux.proximo = null;
			return aux;
		}
		
		return null;
	}
	
}
