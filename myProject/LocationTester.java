package myProject;

public class LocationTester 
{
	public static void main(String []args) 
	{
		System.out.println("Hello World!"); 
		
		SimpleLocation champoluc = new SimpleLocation(45.8316 , 7.7263);
		SimpleLocation cervinia = new SimpleLocation(45.937, 7.6297);
		System.out.println("Distance between champoluc and cervinia " + champoluc.distance(cervinia) + "Km"); 
		
		double[] coords = {50.0, 0.0};
		ArrayLocation accra = new ArrayLocation(coords);
		
		coords[0] = 25;	// you are allowed to change the value of accra obj outside the obj!
		System.out.println(accra.GetCoord().clone()[0]);
		
		System.out.println("End of the program"); 
	}
}
