/*
 *This is a naive implementation of GS Algorithm of stable matching in a bipartite graph
 * Author: Sahil Badyal <sbadyal@asu.edu> <sbadyals@gmail.com> <https://sahilbadyal.com>
 * Date:  30 Aug 2019
 */

import java.util.Scanner;
import java.util.Queue;
import java.util.PriorityQueue;

public class StableMatching {

	private final int[][] menPreferences;
	private int[] numberOfProposals;
	private int[][] womenPriorityLookup;
	private int cardinality;
	
	//Class instantiation
	public StableMatching(int[][] menPreferences,int[][] womenPreferences){
		this.menPreferences = menPreferences;
		this.cardinality = menPreferences.length;
		this.numberOfProposals = new int[this.cardinality];
		this.womenPriorityLookup = new int[this.cardinality][this.cardinality];
		initialize(womenPreferences);
	}

	//This will initialize the women priority lookup table from their preferences
	private void initialize(int[][] womenPreferences){
		for(int i = 0; i < this.cardinality; i++){
			for(int j= 0; j < this.cardinality; j++){
				womenPriorityLookup[i][womenPreferences[i][j]] = j;
			}
		}
	}
	
	//Runs the algorithm and returns the final engagements
	public int[] run(boolean debug){
		int engage[] = new int[this.cardinality];
		Queue<Integer> men = new PriorityQueue<>();
		
		//lets initialize engagement (women as indices and men as values) to -1 meaning all women are free
		//Add men a queue (I have used a priority queue which not required though)
		for(int i = 0; i < this.cardinality; i++) {
			engage[i] = -1;
			men.add(i);
		}

		// the Gale-Shapley Algorithm runs most [n(n-1) + 1] loops i.e O(n^2)
		while(men.size() != 0){
			Integer man = men.peek();

			//Checking if the man has proposed all. In that case you do not belong here
			if(numberOfProposals[man] >= this.cardinality) {
				men.remove(man);
				continue;
			}

			int nextWomanInPriority = menPreferences[man][numberOfProposals[man]++];

			Integer otherMan = engage[nextWomanInPriority];

			if (debug) System.out.printf("Debug:: man %d proposes women %d while otherMan is %d ",man,nextWomanInPriority,otherMan);
			if (otherMan == -1){
				engage[nextWomanInPriority] = man;
				men.remove(man);
				if (debug) System.out.printf("--> Engaged\n");
			}else if(womenPriorityLookup[nextWomanInPriority][man] < womenPriorityLookup[nextWomanInPriority][otherMan]){
				engage[nextWomanInPriority] = man;
				men.remove(man);
				men.add(otherMan);
				if (debug) System.out.printf("--> Swapped\n");
			}else{
				if (debug) System.out.printf("--> Not Engaged\n");
			}
		}
		return engage;
	}
	/*
	 *
	 *Sample input 
	 * 3       -> Cardinality
	 * 0 1 2   -> Man 1
	 * 0 1 2   -> Man 2 
	 * 0 1 2   -> M 3
	 * 2 1 0   -> W 1
	 * 1 2 0   -> W 2 
	 * 0 1 2   -> W 3
	 *
	 */
	public static void main(String[] args){
		boolean debugFlag = false;
		if (args.length == 1){
		   if(args[0].equals("-d")){
		   	debugFlag = true;
		   }
		}
		//Accept some input here
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[][] menPreferences,womenPreferences;
		menPreferences = new int[n][n];
		womenPreferences = new int[n][n];

		for(int i = 0; i < n; i++){
			for(int j= 0; j < n; j++){
				int pref = in.nextInt();
				menPreferences[i][j] = pref;
			}	
		}
		
		for(int i = 0; i < n; i++){
			for(int j= 0; j < n; j++){
				int pref = in.nextInt();
				womenPreferences[i][j] = pref;
			}	
		}

		StableMatching algo = new StableMatching(menPreferences,womenPreferences);
		System.out.println("--------------------------------\nRunning GS Algorithm\n");
	        int[] stableMatchingSolution = algo.run(debugFlag);
		System.out.println("---------------------------------\nFinal matching\n---------------------------------\n");
		for(int i = 0; i < n; i++) System.out.printf("M%d <-marries-> W%d\n",stableMatchingSolution[i],i);
	}
}
