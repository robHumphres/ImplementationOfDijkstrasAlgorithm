/*
Created by: Robert Humphres 11/27/16
*/

package Project;

import java.util.*;

public class Graph {
	
		
	public class Edges{
		public VertexWithEdges dest;
		public final double weight;
		
		public Edges(VertexWithEdges dest, double weight){
			this.dest = dest;
			this.weight = weight;
		}//end Edge ctor
		
	}//end inner class Edge
	
	private List<VertexWithEdges> verts;
	
		
	public void addEdge(int curr, int dest, int weight){
		VertexWithEdges src = verts.get(curr);
		Edges temp = new Edges(verts.get(dest), weight);
		src.adjcentLists.add(temp);
	}//end addEdge
	
	public VertexWithEdges getVertex(int vertex){
		return verts.get(vertex);
	}//end getVertex
	
	public ArrayList<VertexWithEdges> getVertices(){
		return (ArrayList<VertexWithEdges>) verts;
	}//end getVertices
   
   public Graph(int V){
		verts = new ArrayList<VertexWithEdges>(V);
		for(int v = 0; v < V; v++){
			verts.add(new VertexWithEdges(v));
		}//end for
      
	}//end weightedGraph ctor

   
   public class VertexWithEdges implements Comparable<VertexWithEdges>{
		
		public LinkedList<VertexWithEdges> shortestPathPossible;
		public double minimumDist = Double.POSITIVE_INFINITY;//tony's code
      public int value;
 		public ArrayList<Edges> adjcentLists;

		
		public VertexWithEdges(int value){
			this.value = value;
			adjcentLists = new ArrayList<Edges>();
			shortestPathPossible = new LinkedList<VertexWithEdges>();
		}//end Vertex
		
		@Override
		public int compareTo(VertexWithEdges that) {
			int res;
			res = (int) (this.minimumDist - that.minimumDist);
			return 0;
		}//end compareTo
		
		public String toString(){
			return Integer.toString(value);
		}//end toString

	}//end innerVertex class


}//end WeightedGraph class
