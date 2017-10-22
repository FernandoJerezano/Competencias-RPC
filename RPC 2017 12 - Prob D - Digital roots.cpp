// Problema: Digital roots
// Autor:    FernandoJerezano
// Fecha:    21-Octubre-2017
#include <stdio.h>
#include <iostream>

using namespace std;

int main(){
	
	unsigned long long int n,sum;
	
	//freopen("salida.txt","w",stdout);
	
	while(cin>>n){
		
		if(n==0)
			break;
		
		while(n>=10){
			sum = 0;
			
			while(n>0){
				sum+=n%10;
				n/=10;
			}
			n = sum;
		}

		printf("%d\n",(int)n);
	}
	
	return 0;
}
