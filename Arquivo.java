import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
 
public class Arquivo {
	
	public static String texto(String caminho) throws IOException 
	{
	    String texto = new String(Files.readAllBytes(Paths.get(caminho)));
	    return texto;
	}
  
    public static void escritorDec(String path, Arvore arv, String entrada) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = arv.decodificar(entrada);
        buffWrite.append(linha);
        buffWrite.close();
    }
    
    public static void escritorEnc(String path, Arvore arv, String entrada) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = arv.codificar(entrada);
        buffWrite.append(linha);
        buffWrite.close();
    }
 
}