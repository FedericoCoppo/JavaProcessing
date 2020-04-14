# JavaProcessing 
Tutorial for using processing lib and Unfolding map lib.
Hint from UC San Diego Intermediate Software Development team course.
 
## Life expectation PApplet 
The app parse from a CSV file the country expectation of life data to fill an Hash Map (country ID, value).
Create a markers and a features list in order to draw a map (unfolding map lib) shaded with expectation. 

![world map life expectation example](https://github.com/FedericoCoppo/JavaProcessing/blob/master/map.PNG)

## Earthquake city map
The app display a simple map with earthquake data markers.

![world map life expectation example](https://github.com/FedericoCoppo/JavaProcessing/blob/master/earthQuakeMap1.PNG)

## Earthquake city map with info
The app display the word earthquake/city map with interactive info (inheritance/polymorphism)
A comparable is implemented to allow using built-in sorting algo.
Event driven programming is used: 
- mouse moving and clicking allow focus on specific earhquake,
- key pressed from keyboard allow to filter map:
 '1' to '6' allow map filter for earthquakes magnitude grater than the ke y value 
 'l' allow dispaly only "on land" eartquakes
 'g'/'m' allow to switch from Microsoft to Google map provider and viceversa
 'b' allow to remove last map filter

![world map life expectation example](https://github.com/FedericoCoppo/JavaProcessing/blob/master/earthQuakeMap2.PNG)
