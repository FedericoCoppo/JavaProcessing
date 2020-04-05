package lifeExpectancy;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.providers.*;
import de.fhpotsdam.unfolding.providers.Google.*;

import java.util.List;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;

import java.util.HashMap;
import java.util.Map;


import de.fhpotsdam.unfolding.marker.Marker;

/**
 * Visualizes life expectancy in different countries:
 * 
 * It loads the country shapes from a GeoJSON file via a data reader, and loads the population density values from
 * another CSV file (provided by the World Bank). The data value is encoded to transparency via a simplistic linear
 * mapping.
 */

public class LifeExpectancy extends PApplet {

	UnfoldingMap map;							// display map
	Map<String, Float> lifeExpByCountry;		// map key-value
	
	List<Feature> countries;                    // Country list
	List<Marker> countryMarkers;				// country marker

	public void setup() {
		size(800, 600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Microsoft.AerialProvider());
		MapUtils.createDefaultEventDispatcher(this, map);

		// Load lifeExpectancy data into a map
		lifeExpByCountry = loadLifeExpectancyFromCSV("../data/LifeExpectancyWorldBankModule3.csv");
		println("Loaded " + lifeExpByCountry.size() + " data entries");
		
		// Load country polygons and adds them as markers
		countries = GeoJSONReader.loadData(this, "../data/countries.geo.json"); // helper method 1 : 1 feature and 1 marker per country
		countryMarkers = MapUtils.createSimpleMarkers(countries);				// helper method 2
		map.addMarkers(countryMarkers);											// add the maker to the map 	
		
		// Country markers are shaded according to life expectancy (only once)
		shadeCountries();													    // manipulate the marker
	}

	public void draw() {
		// Draw map tiles and country markers
		map.draw();
	}

	//Helper method to color each country based on life expectancy
	//Red-orange indicates low (near 40)
	//Blue indicates high (near 100)
	private void shadeCountries() {
		for (Marker marker : countryMarkers) {							// for each market 
			String countryId = marker.getId();							// Find data for country of the current marker 					
			if (lifeExpByCountry.containsKey(countryId)) {              // if the country ID is contained into hash map (maybe word bank does not have all data in the CSV)
				float lifeExp = lifeExpByCountry.get(countryId);        // keep the expectancy value
				int colorLevel = (int) map(lifeExp, 40, 90, 10, 255);   // "map" built in method of Unfolding Encode value as brightness (values range: 40-90)     
				marker.setColor(color(255-colorLevel, 100, colorLevel));// Change the color of the marker
			}
			else {
				marker.setColor(color(150,150,150));					// default color is GRAY	
			}
		}
	}

	// load life expectancy data from file and return a map
	private Map<String, Float> loadLifeExpectancyFromCSV(String fileName) {
		Map<String, Float> lifeExpMap = new HashMap<String, Float>();     // Map is abstract, you create an hashMap obj

		String[] rows =  loadStrings(fileName);
		if (rows != null)
		{
			for (String row : rows) // file iteration 
			{   
				String[] columns = row.split(","); // split on a comma
				if (columns.length == 6 && !columns[5].equals("..")) 
				{
					lifeExpMap.put(columns[4], Float.parseFloat(columns[5])); // key is country ID, value is life expectancy (float) 
				}
			}	
		}
		
		return lifeExpMap;
	}

}
