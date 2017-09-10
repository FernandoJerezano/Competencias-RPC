// Problema:	Hulam Suquence
// Autor:	FernandoJerezano
// Fecha:	02-Septiembre-2017
#include <iostream>
#include <bits/stdc++.h>

using namespace std;
vector<bool>hulam;
vector<int>vec;
	
bool is_hulam(int n){
	
	int t = n/2;
	for(int i=1;i<t;i++){
		if(hulam[i] && hulam[n-i])
			return 0;
	}
	return 1;
}

void prec(){
	vec.clear();
	
	hulam.push_back(0);
	hulam.push_back(1);
	hulam.push_back(1);
	hulam.push_back(0);
	
	vec.push_back(0);
	vec.push_back(1);
	vec.push_back(2);

	for(int i=4;vec.size()<=10001;i++){
		if(is_hulam(i)){
			vec.push_back(i);
			hulam.push_back(1);
		}else{
			hulam.push_back(0);
		}
	}
}

int main(){
	
	prec();
	
	//freopen("entrada.txt","r",stdin);
	//freopen("salida.txt","w",stdout);
	
	int t;
	int n;
	
	scanf("%d",&t);
	
	while(t--){
		scanf("%d",&n);
		printf("%d\n",vec[n]);
	}
	
	
	return 0;
}
