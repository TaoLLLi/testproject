package suanfaTest;

public class Sortornetwork {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] A=new int[9];
		A[1]=1;A[2]=2;A[3]=3;A[4]=4;A[5]=5;A[6]=6;A[7]=7;A[8]=8;
		Sorter(A,1,4);

		Print(A,4);
		
	}
	
	public static void Sorter(int[] A,int p,int q){
		
		if(p<q){
			int n=(p+q)/2;
			Sorter(A,p,n);
			Sorter(A,n+1,q);
			Merging(A,p,q);
			int k=(p+q)/2;
		    Brronic_sorter(A,p,k);
		    Brronic_sorter(A,k+1,q);
		}
		

	}
	
	public static void Brronic_sorter(int[] A,int i,int j){
		//n=A.length;
		int n=j-i;
		if(n!=0){
		for(int k=0;k<=n/2;k++){
			comparer(A,i+k,n/2+k+1+i);
		}
		for(int k=0;k<=n/2;k++){
			comparer(A,2*k+i,2*k+1+i);
		}
		}

	}

	public static void Merging(int[] A,int i,int j){
		for(int k=0;k<=(j-i)/2;k++){
			comparer(A,i+k,j-k);
		}
			
	}
	
	public static void comparer(int[] A,int a,int b){
		int temp;
		//Print(A,4);
		if(A[a]>A[b]){
		temp=A[a];
		A[a]=A[b];
		A[b]=temp;
		//Print(A,4);
	}
	}
	
	public static void Print(int[] A,int length){
		for(int i=1;i<=length;i++){
			System.out.print(A[i]+" ");
		}
		System.out.print('\n');
	}
}
