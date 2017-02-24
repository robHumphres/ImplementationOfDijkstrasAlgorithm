/*
Created by: Robert Humphres 11/26/16
*/

package Project;

import java.util.*;

import Project.Graph.Edges;
import Project.Graph.VertexWithEdges;

public class DijkAlg {
	
	public DijkAlg(){}//Public DVC
	
	public void findShortestPath(VertexWithEdges head){
   
		PriorityQueue<VertexWithEdges> vertForDijks = new PriorityQueue<VertexWithEdges>();
		head.minimumDist = 0;
		
		vertForDijks.add(head);
		
      //goes till verts are empty
		while(!vertForDijks.isEmpty()){
			VertexWithEdges tempString = vertForDijks.poll();
			
         //Goes through adjcent lists to check for smallest distance.
			for(Edges adjs : tempString.adjcentLists){
				int dist = (int) (tempString.minimumDist + adjs.weight);
				
            //is min distance its larger than the distance
				if(adjs.dest.minimumDist > dist){
					
               //Update the Q
               VertexWithEdges temp = adjs.dest;
					vertForDijks.remove(adjs.dest);
					adjs.dest.minimumDist = dist;
					//Deals with adding temp and temp string to Q
					adjs.dest.shortestPathPossible = new LinkedList<VertexWithEdges>(tempString.shortestPathPossible);
					adjs.dest.shortestPathPossible.add(tempString);
               adjs.dest.shortestPathPossible.add(temp);
					//Need to add the temp back in 
               vertForDijks.add(temp);
					
				}//end if
            
			}//end for
         
		}//end while
      
	}//end findShortestPath

}//end class
