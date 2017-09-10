// Problema:	Sub Sum
// Autor:	FernandoJerezano
// Fecha:	02-Septiembre-2017
#include <iostream>
#include <bits/stdc++.h>
#define MAX_N 100005

using namespace std;

typedef long long int ll;

ll arr[MAX_N];
ll n;
ll S;
ll ini;
ll fin;

bool sum(){
	ini = 1;
	fin = 1;
	ll sum = 0;
	ll i = 1;
	
	sum = arr[i];
	
	for(i = 2;i<=n+1;i++){
		while(sum>S && ini<i){
			sum-=arr[ini];
			ini++;
		}
		if(sum==S){
			fin = i-1;
			return true;
		}
		if(i<=n)
			sum+=arr[i];
	}
	
	if(sum==S){
		ini = fin = n;
	}
	return false;
}

int main(){

	//freopen("entrada.txt","r",stdin);
	//freopen("salida.txt","w",stdout);
	
	ll i;
	bool found;
	
	while(scanf("%lld%lld",&n,&S)!=EOF){
		
		for(i = 1;i<=n;i++){
			scanf("%lld",&arr[i]);
		}
		
		found = sum();
		
		if(found)
			printf("%lld %lld\n",ini,fin);
		else
			printf("-1\n");
	}
	return 0;
}
