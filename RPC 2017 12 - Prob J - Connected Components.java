// Problema: Connected Components
// Autor:    FernandoJerezano
// Fecha:    21-Octubre-2017
import java.io.*;

class J{
	
	public static boolean visited[] = new boolean[30];
	static int mat_adj[][] = new int [30][30];
	static int tot;
	static int valores[] = new int[200];

	public static void main(String[]args)throws IOException{
		
		BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(
		new OutputStreamWriter(System.out));
		
		init();
		
		String s,con;
		int a,b;
		
		char c;
		int t;
		int cont = 0;
		
		while(true){
			s = br.readLine();
			
			if(s==null){
				break;
			}
			c = s.charAt(0);
			t = tot = valores[c];
			
			init_visited();
			
			while(true){
				s = br.readLine();
				if(s==null)
					break;
				if(s.equals(""))
					break;
				c = s.charAt(0);
				a = valores[c];
				c = s.charAt(1);
				b = valores[c];
				mat_adj[a][b] = 1;
				mat_adj[b][a] = 1;
			}
			
			/*
			for(int i=0;i<26;i++){
				for(int j=0;j<26;j++){
					System.out.print(mat_adj[i][j]+" ");
				}
				System.out.println();
			}
			*/
			
			cont = 0;
			for(int i=0;i<=t;i++){
				if(visited[i]==false){
					dfs(i);
					cont++;
				}
			}
			//pw.println(cont);
			System.out.println(cont);
		}
		
		pw.close();
		
	}
	
	public static void init(){
	
		
		int val = 0;
		for(int i='A';i<='Z';i++){
			valores[i] = val++;
		}
		
	}
	
	public static void init_visited(){
		
		
		for(int i=0;i<30;i++){
			for(int j=0;j<30;j++){
				mat_adj[i][j] = 0;
			}
		}
		for(int i=0;i<30;i++){
			visited[i] = false;
		}
	}
	
	public static void dfs(int u){
		
		visited[u] = true;
		int j;
		
		for(int i=0;i<30;i++){
			if(visited[i]==false && mat_adj[u][i]==1){
				//System.out.println(u+" visita "+i);
				dfs(i);
				tot--;
			}
		}
	}
}
