// Problema:	Urban Map
// Autor:	FernandoJerezano
// Fecha:	09-Septiembre-2017
import java.io.*;

class F{
	
	
	static int R,C;
	static int dr[] = {1,-1, 0, 0};
	static int dc[] = {0, 0, 1,-1};
	static char mat[][] = new char[50][50];	
	
	public static void main(String[]args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		//BufferedReader br = new BufferedReader(new FileReader("entrada.txt"));
		//PrintWriter pw = new PrintWriter("salida.txt");
		
		int t = Integer.parseInt(br.readLine());
		int r,c;
		int res = 0;
		
		String s,str[];
		
		while(t>0){
			t--;
			r = Integer.parseInt(br.readLine());
			c = Integer.parseInt(br.readLine());
			R = r;
			C = c;
			for(int i=0;i<r;i++){
				mat[i] = br.readLine().toCharArray();
			}
			res = 0;
			
			// busca abajo
			for(int i=0;i<C;i++){
				if(mat[0][i]=='0'){
					//System.out.println("Encontrado");
					res+= flood_fill(0,i,'0','1');
				}
			}
			// busca arriba
			for(int i=0;i<C;i++){
				if(mat[R-1][i]=='0'){
					res+= flood_fill(R-1,i,'0','1');
				}
			}
			
			// busca izquierda
			for(int i=0;i<R;i++){
				if(mat[i][0]=='0'){
					res+= flood_fill(i,0,'0','1');
				}
			}
			
			// busca derecha
			for(int i=0;i<R;i++){
				if(mat[i][C-1]=='0'){
					res+= flood_fill(i,C-1,'0','1');
				}
			}
			
			pw.println(res);
		}
		
		br.close();
		pw.close();
	}
	
	public static int maximo(int a, int b){
		return a>b?a:b;
	}
	
	public static int flood_fill(int r, int c, char c1, char c2){
		if(!is_valid(r,c))
			return 0;
		if(mat[r][c]!=c1)
			return 0;
		mat[r][c] = c2;
		int ans = 1;
		for(int i=0;i<4;i++){
			ans+=flood_fill(r+dr[i],c+dc[i],c1,c2);
		}
		return ans;
	}
	
	public static boolean is_valid(int r, int c){
		return (r>=0 && r<R && c>=0 && c<C);
	}
	
}
