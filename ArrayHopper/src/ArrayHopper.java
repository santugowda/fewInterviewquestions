import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.MinimalHTMLWriter;


public class ArrayHopper {
	
	final static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		int input[] = {5,6,0,4,2,4,1,0,0,4};
		int n = input.length;
		int hops = minJumps(input, n);
		System.out.println("Minimun jumps to reach the end " + hops);
		 System.out.println(list);
		
	}
	
	public static int minJumps(int arr[], int n){
		
		int jumps = 0;
	    if(n < 2){
	        return jumps;
	    }
	    int current = 0; // current index,
	    int cur_step;// number of step you can jump in current index 
	    int last;    // last index
	    int temp_max = current; // temporary max jump distance 
	    int temp_index = current;// temporary index.

	    while(current < n){
	        last = current;
	        cur_step = arr[current];
	        if((current + cur_step) >= n-1){ // if reached end of the array, return.
	            jumps++;
	            list.add(last);
	            return jumps;
	        }
	        for(int i = current + 1; i <= current + cur_step; i++){//go thru all the possible next position, and find the one that could jump most steps.
	            if(arr[i] == 0){
	                continue;
	            }
	            if(arr[i] + i > temp_max){ // find the one that could jump most steps.
	                temp_index = i;
	                temp_max = arr[i] + i;
	            }
	        }
	        current = temp_index; // jump to this position, temp index holds index that jump most steps in next jump.
	        if(current != last){
	            jumps++;
	            list.add(last);
	        }else{
	            break;
	        }
	        list.add(temp_index);
	        
	    }
	    return -1;


	}

}
