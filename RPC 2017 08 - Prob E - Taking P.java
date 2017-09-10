// Problema:	Talking P
// Autor:	FernandoJerezano
// Fecha:	02-Septiembre-2017
import java.io.*;
	
class talkingp{
	
	public static void main(String[]args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n;
		String s;
		
		n = Integer.parseInt(br.readLine());
		char c;
		
		for(int i=0;i<n;i++){
			
			s = br.readLine();
			
			for(int j=0;j<s.length();j++){
				c = s.charAt(j);
				pw.print(c);
				switch(c){
					case 'a':
						pw.print("pa");
						break;
					case 'e':
						pw.print("pe");
						break;
					case 'i':
						pw.print("pi");
						break;
					case 'o':
						pw.print("po");
						break;
					case 'u':
						pw.print("pu");
						break;
				}
			}
			pw.println();
		}
				
		br.close();
		pw.close();
	}
}
