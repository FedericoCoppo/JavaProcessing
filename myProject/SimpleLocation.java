package myProject;
// author: Coppo Federico  

public class SimpleLocation
{

	// PUBLIC

	// default ctor
	public SimpleLocation()
	{
		this.latitude = 32.9;
		this.longitude = -117.2;
	}

	// ctor (overload)
	public SimpleLocation(double lat, double lon)
	{
		if (lat < -180 && lat > 180)
		{	
			System.out.println("Illegal value for latitude"); 
			this.latitude = 32.9;
		}
		else
		{
			this.latitude = lat;
		}	
		
		if (lon < -180 && lon > 180)
		{
			System.out.println("Illegal value for latitude"); 
			this.longitude = -117.2;
		}
		else
		{
			this.longitude = lon;
		}	
	}

	// getter
	public double getLatitude ()
	{
		return this.latitude;
	}

	public double getLongitude ()
	{
		return this.longitude;
	}
	
	// setter
	public void setLatitude (double lat)
	{
		if (lat < -180 && lat > 180)
		{
			System.out.println("Illegal value for latitude"); 
		}
		else
		{
			this.latitude = lat;	
		}
	}

	public void setLongitude (double lon)
	{
		if (lon < -180 && lon > 180)
		{
			System.out.println("Illegal value for longitude"); 
		}
		else
		{
			this.longitude = lon;	
		}
	}

	public double distance (SimpleLocation other)
	{
		return getDist(this.latitude,this.longitude, other.latitude, other.longitude);
	}

	public double distance (double lat, double lon)
	{
		return getDist(this.latitude,this.longitude, lat, lon);
	}
	
	// PRIVATE
	private double latitude;
	private double longitude;

	private double getDist(double lat1, double lon1, double lat2, double lon2) 
	{
		int R = 6373; // radius of the earth in kilometres
		double lat1rad = Math.toRadians(lat1);
		double lat2rad = Math.toRadians(lat2);
		double deltaLat = Math.toRadians(lat2 - lat1);
		double deltaLon = Math.toRadians(lon2 - lon1);

		double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
				+ Math.cos(lat1rad) * Math.cos(lat2rad) * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		double d = R * c;
		return d;
	}
}
