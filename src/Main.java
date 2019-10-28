import java.util.Arrays;

public class Main {
	
	public void sort(int ar[]) {
		int n = ar.length;
		
        // Build heap (rearrange array) 
		for(int i = n/2 - 1; i >= 0; i--)
			heapify(ar, n, i);

		// One by one extract an element from heap 
		for(int i = n - 1; i >= 0; i--) {
            // Move current root to end 
			int temp = ar[0];
			ar[0] = ar[i];
			ar[i] = temp;
			
			// call max heapify on the reduced heap
			heapify(ar, i, 0);
		}
	}
	
	// To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
	public void heapify(int ar[], int n, int i) {
		int largest = i; 		//Initialize largest as root
		int left = 2*i + 1;		//left = 2*i + 1
		int rigth = 2*i + 2;	//rigth = 2*i + 1
		
		//If left child is greater then largest swap
		if(left < n && ar[left] > ar[largest])
			largest = left;
		
		//If rigth child is greater then largest swap
		if(rigth < n && ar[rigth] > ar[largest])
			largest = rigth;
		
		//If largest is not root
		if(largest != i) {
			int swap = ar[i];
			ar[i] = ar[largest];
			ar[largest] = swap;
			
			// Recursively heapify the affected sub-tree 
            heapify(ar, n, largest); 
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		int ar[] = {3,6,19,4,5,0,8,2};
		main.sort(ar);
		System.out.print(Arrays.toString(ar));
	}

}
