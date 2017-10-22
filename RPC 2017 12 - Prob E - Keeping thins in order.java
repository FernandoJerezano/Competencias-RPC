// Problema: Keeping thins in order
// Autor:    FernandoJerezano
// Fecha:    21-Octubre-2017
import java.io.*;
import java.util.*;

class E{
	
	public static boolean visited[] = new boolean[30];
	static int mat_adj[][] = new int [30][30];
	static int tot;
	static int valores[] = new int[200];

	public static void main(String[]args)throws IOException{
		
		BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(
		new OutputStreamWriter(System.out));
		
		String s;
		
		int palas,nums;
		int tpalas,tnums;
		boolean posiciones[] = new boolean[200];
		String str[];
		int t;
		
		int numeros[];
		Palabra palabras[];
		
		//50, 7, kitten, puppy, 2, orangutan, 52, -100, bird, worm, 7, beetle.
		while(true){
			s = br.readLine();
			if(s.equals("."))
				break;
			s = s.replaceAll(",","");
			s = s.replaceAll("\\.","");
			str = s.split("\\s");
			nums = 0;
			palas = 0;
			
			for(int i=0;i<str.length;i++){
				if(esNumero(str[i])){
					posiciones[i] = true;
					nums++;
				}else{
					posiciones[i] = false;
					palas++;
				}
			}
			
			palabras = new Palabra[palas];
			numeros = new int[nums];
			nums = palas = 0;
			
			for(int i=0;i<str.length;i++){
				if(esNumero(str[i])){
					numeros[nums] = Integer.parseInt(str[i]);
					nums++;
				}else{
					palabras[palas] = new Palabra(str[i]);
					palas++;
				}
			}
			
			Arrays.sort(palabras,new Palabra());
			Arrays.sort(numeros);
			tpalas = palas;
			tnums = nums;			
			
			nums = palas = 0;
			
			// numero es tru
			// palabra es false
			int total_ele = 0;
			
			for(int i=0;i<str.length;i++){
				if(posiciones[i]){
					pw.print(numeros[nums]);
					nums++;
					total_ele++;
					if(total_ele!=str.length)
						pw.print(", ");
				}else{
					pw.print(palabras[palas].pal);
					palas++;
					total_ele++;
					if(total_ele!=str.length)
						pw.print(", ");
				}
			}
			pw.println(".");
		}
		
		pw.close();
	}
	
	public static boolean esNumero(String s){
		
		
		boolean r;
		
		for(int i=0;i<s.length();i++){
			
			if(s.charAt(i)!='-'){
				r = (s.charAt(i)>='0' && s.charAt(i)<='9');
				if(!r)
					return false;
			}
		}
		return true;
	}
	
}

class Palabra implements Comparator<Palabra>{
	
	String pal;
	
	Palabra(){	
	}
	
	Palabra(String s){
		pal = s;
	}
	
	public int compare(Palabra p1, Palabra p2){
		return ((p1.pal).compareToIgnoreCase(p2.pal));
	}
	
}
