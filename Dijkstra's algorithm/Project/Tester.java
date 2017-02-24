/*
Created by: Robert Humphres 11/27/16
*/
package Project;

import Project.Graph.VertexWithEdges;

import java.util.*;
import java.io.*;

public class Tester 
{

	public static void main(String[] args)throws FileNotFoundException
    {
		DijkAlg dij = new DijkAlg();
      Scanner scan = new Scanner(System.in);
      scan = new Scanner(new File("tester.txt"));
      
      //Gets the graph weight
      String s = scan.nextLine();
      Graph graph = new Graph(Integer.parseInt(s));
      
      while(scan.hasNextLine()){
      s = scan.nextLine();
      String [] temp = s.split(",");
      //first number, second, weight
      graph.addEdge(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]),Integer.parseInt(temp[2]));
      }//end scan
      
        
        
        
		dij.findShortestPath(graph.getVertex(1));
		
		int j = 0;
		for(VertexWithEdges V : graph.getVertices()){
			//don't want to get zero
         if(j == 0){
				j++;
				continue;
			}//end of if
         
			System.out.print("Vertex 1 to Vertex " + V + "\t");
			
			int counter = 0;
		   for(int x = 0; x < V.shortestPathPossible.size(); x++,counter++){
         //This is used to check for duplicates.
         if(x != 0)
         {
            if(V.shortestPathPossible.get(x).equals(V.shortestPathPossible.get(x-1))){
               x++;
            }//checks mids for duplicates
         }//end of j != 0 
				System.out.print("" + V.shortestPathPossible.get(x).toString() + ">");
			}//end for
			//if(counter!=V.shortestPathPossible.size())
         if(counter == 0)
         System.out.println("\t\tLength: " + V.minimumDist);
         else{
         if(counter!=V.shortestPathPossible.size())
			System.out.println(",\t\tlength " + V.minimumDist);
         else
         System.out.println("\t\t Length: " + V.minimumDist);
         counter = 0;
         }
			
			j++;
		}//end for
		
	}//end of main

}//end of class
