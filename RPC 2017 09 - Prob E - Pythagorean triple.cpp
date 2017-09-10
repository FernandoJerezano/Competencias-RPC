// Problema:	Pythagorean triple
// Autor:     	FernandoJerezano
// Fecha:	09-Septiembre-2017
#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main(){
	
	int N,cont;
	
	while(scanf("%d",&N)){
		if(!N)
			break;
		cont = 0;
		for(int i=1;i<=N;i++){
			for(int j=i;j<=N;j++){
				for(int k=j;k<=N;k++){
					//printf("%d %d = %d\n",i,j,k);
					
					if((i*i+j*j)==k*k){
						cont++;
					}
				}
			}
		}
		printf("%d\n",cont);
	}
	return 0;
}
