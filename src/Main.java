import java.util.Arrays;

public class Main {
	
	//ar[] sotto-vettore da ordinare
	//n lunghezza sottovettore
	//i Indice root
	public void heapify(int ar[], int n, int i) {
		//1° step identificare attori processo algoritmo
		int largest = i;
		int left = i*2 + 1;
		int right = i*2 + 2;
		
		//2° step verificare che left e right siano effettivamente minori di root (minori perchè stiamo realizzando un Max-Heap)
		//Verifichiamo prima che il figlio sinistro sia effettivamente più piccolo del suo parent
		//altrimenti modifichiamo l'indice
		if(left < n && ar[left] > ar[largest])
			largest = left;
		//Effettuiamo la stessa operazione sul figlio destro
		if(right < n && ar[right] > ar[largest])
			largest = right;
		
		//Se alla fine dell'algoritmo l'indice del valore maggiore non corrisponde con l'indice della root
		//Si aggiorna l'heap e ricorsivamente lo si rimanda al processo di heapify
		if(largest != i) {
			int app = ar[i];
			ar[i] = ar[largest];
			ar[largest] = app;
			
			heapify(ar, n, largest);
		}
	}
	
	public void sort(int ar[]) {
		int n = ar.length;
		
		//Costruisco l'albero o heap
		for(int i = n /2 - 1; i >= 0; i--)
			heapify(ar, n, i);
		
		//Uno a uno esco gli elementi dall'heap e li ordino partendo dall radice
		for(int i = n - 1; i >= 0; i--) {
			int app = ar[0];
			ar[i] = ar[0];
			ar[i] = app;
			
			heapify(ar, i, 0);
		}
		
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		int ar[] = {3,6,19,4,5,0,8,2};
		main.sort(ar);
		System.out.print(Arrays.toString(ar));
	}

}
