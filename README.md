# java-json-parsing_
## Project structure
This is a Maven project. It follows the default Maven structure.
## Project description
The goal of this project is to compare different techniques to parse JSON strings. 
A JSON string containing weather information (from www.weatherbit.io) is used as an example.
JUnit tests deserialize the temperature and weather description fields from the JSON string using three libraries: Gson, JsonSimple and Jackson. 
The differences are summarized below:  

### JsonSimple
JsonSimple is a simplest way to parse JSON for ad hoc purposes, 
i.e. when the data does not need to be mapped to a class. Instead, a Map is returned.

### Gson
Since Gson ignores unknown fields by default it is a good choice when not all values in JSON string need to be deserialized 
to a JAVA object. However, a limitation is that the Json keys must match the Java class field names. 

### Jackson
Jackson provides many opportunities to change the default behaviour via annotations or .configure 
and thus it is a good option for more complex deserialization projects. Since Jackson does not ignore
fields by default annotations or .configure must be used if not all values are relevant. 
Annotations provide also possibility to map differently named field names to JSON keys.

