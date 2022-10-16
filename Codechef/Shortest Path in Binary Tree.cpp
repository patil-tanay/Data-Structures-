#include <iostream>
using namespace std;

int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--){
	    int i,j;
	    cin>>i>>j;
	    int count_a=0,count_b=0;
	    while(i!=j){
	        if(i/2<j){
	            j/=2;
	            count_b++;
	        }
	        else if(j/2<i){
	            i/=2;
	            count_a++;
	        }
	    }
	    cout<<count_a+count_b<<endl;
	}
	return 0;
}
