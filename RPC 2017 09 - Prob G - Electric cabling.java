// Problema:	Electric cabling
// Autor:     FernandoJerezano
// Fecha:     09-Septiembre-2017
import java.io.*;

class G{
	
	public static void main(String[]args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		//BufferedReader br = new BufferedReader(new FileReader("entrada.txt"));
		//PrintWriter pw = new PrintWriter("salida.txt");
		
		int t = Integer.parseInt(br.readLine());
		
		String s,str[];
		int arr[];
		int cont;
		int band;
		
		while(t>0){
			s = br.readLine();
			str = s.split("\\s+");
			arr = new int[str.length];
			for(int i=0;i<str.length;i++){
				arr[i] = Integer.parseInt(str[i]);
			}
			int m = -1;
			for(int i=0;i<arr.length;i++){
				m = maximo(m,arr[i]);
			}
			
			cont = 0;
			for(int i=0;i<arr.length;i++){
				if(arr[i]==m){
					cont++;
				}
			}
			band = 0;
			
			if(cont==1){
				cont = 0;
				for(int i=0;i<arr.length;i++){
					if(m==arr[i]){
						cont = arr.length-i;
					}
				}
			}else{
				if(cont%2==0){
					cont = 0;
					for(int i=0;i<arr.length;i++){
						if(arr[i]==m){
							cont++;
							i++;
							while(i<arr.length && arr[i]!=m){
								cont++;
								i++;
							}
							cont++;
						}
					}
				}else{
					int tot2 = cont;
					int cont2 = 0;
					cont = 0;
					band = 0;
					int tot = 0;
					int i;
					
					for(i=0;i<arr.length;i++){
						if(arr[i]==m){
							tot++;
							if(band==1)
								cont++;
							band = 1-band;
						}
						if(band==1){
							cont++;
						}
					}
				}
			}		
			pw.println(cont);
			
			
			t--;
		}
		
		br.close();
		pw.close();
	}
	
	public static int maximo(int a, int b){
		return a>b?a:b;
	}
	
}
