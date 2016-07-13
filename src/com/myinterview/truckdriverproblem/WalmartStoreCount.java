package com.myinterview.truckdriverproblem;

import java.util.HashSet;
import java.util.Set;

public class WalmartStoreCount {
		//	Variables holding the Direction Symbols
		private final static String north = "\u25B2";
		private final static String south = "\u25BC";
		private final static String right = "\u25B6";
		private final static String left =  "\u25C0";
		
		// Main Method from where Program Execution starts		
		public static void main(String[] args) {
			// Variable holding the Input Direction Pattern for the Truck Driver.			
			String directionPattern =north+right+south+left+left+south+right+north;
			//	Variable holding the number of stores.		
			int noOfStores;
			System.out.println("The Input Direction Pattern is :"+directionPattern);
			WalmartStoreCount walmartStoreCount = new WalmartStoreCount();
			// Method call to find the number of unique stores traversed			
			noOfStores=walmartStoreCount.findStoresCount(directionPattern);
			System.out.println("Total number of Unique Stores freight delivered was:"+String.valueOf(noOfStores));
		
		}
		
		// Method which takes input direction pattern string and returns number of unique stores traversed.	
		public int findStoresCount(String directionPattern){
			
			Pair currentPoint=new Pair(0,0); //Current Point initialized to Origin 
			Set<Pair> storeCoordinateSet= new HashSet<Pair>(); // Set to hold the unique store co-ordinates
			storeCoordinateSet.add(currentPoint);
			//Loop to find co-ordinates for each direction received 
			for (int i=0; i<directionPattern.length(); i++)   
			{
				Pair nextPoint=new Pair();
				//Obtain each single direction from the input pattern 
				String direction=String.valueOf(directionPattern.charAt(i));
				//Check if input direction matches with any of the direction and set the co-ordinate and add to the Set.
				if (direction.equals(north)){
					nextPoint.xCoordinate=currentPoint.getxCoordinate();
					nextPoint.yCoordinate=currentPoint.getyCoordinate()+1;
					storeCoordinateSet.add(nextPoint);
					currentPoint=nextPoint;
							
				}else if(direction.equals(south)){
					nextPoint.xCoordinate=currentPoint.getxCoordinate();
					nextPoint.yCoordinate=currentPoint.getyCoordinate()-1;
					storeCoordinateSet.add(nextPoint);
					currentPoint=nextPoint;
				}else if(direction.equals(right)){
					nextPoint.xCoordinate=currentPoint.getxCoordinate()+1;
					nextPoint.yCoordinate=currentPoint.getyCoordinate();
					storeCoordinateSet.add(nextPoint);
					currentPoint=nextPoint;
				}else if(direction.equals(left)){
					nextPoint.xCoordinate=currentPoint.getxCoordinate()-1;
					nextPoint.yCoordinate=currentPoint.getyCoordinate();
					storeCoordinateSet.add(nextPoint);
					currentPoint=nextPoint;
				}else{
					System.out.println("Direction symbol invalid");
				}
			}
				// Printing all the unique co-ordinates the truck driver has traversed.
				for (Pair p : storeCoordinateSet) {
				    System.out.println("The co-ordinate values of the traversed store is:("+p.xCoordinate+" , "+p.yCoordinate +" )");
				 }
			
			// Returning the final number of unique stores visited 
			return storeCoordinateSet.size() ;
		}
	
		// Class whose fields holds the store co-ordinates
		class Pair{
		    
			private int xCoordinate;
		    private int yCoordinate;
		    Pair(){
		    	
		    }
		    Pair(int x,int y){
		    	xCoordinate=x;
		    	yCoordinate=y;
		    }
		    public int getxCoordinate() {
				return xCoordinate;
			}
			public void setxCoordinate(int xCoordinate) {
				this.xCoordinate = xCoordinate;
			}
			public int getyCoordinate() {
				return yCoordinate;
			}
			public void setyCoordinate(int yCoordinate) {
				this.yCoordinate = yCoordinate;
			}
			// Overriding Equals and Hashcode so that objects are compared by their co-ordinate values.
			@Override
		    public boolean equals(Object o) {
		        if (o instanceof Pair) {
		            Pair p = (Pair)o;
		            return p.xCoordinate == xCoordinate && p.yCoordinate == yCoordinate;
		        }
		        return false;
		    }
			@Override
		    public int hashCode() {
		        return new Integer(xCoordinate).hashCode() * 31 + new Integer(yCoordinate).hashCode();
		    }
		}

}
