package com.kristina.jsonparsing;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;
import static com.kristina.jsonparsing.ResourceUtil.getResourceFileAsString;

class JsonParsingTest {

    private final String fileContent = getResourceFileAsString("example-response-from-weatherbit.io.json");

    @Test
    void deserializeJsonStringUsingGson() throws IOException {
        WeatherObject todayWeather = new Gson().fromJson(fileContent, WeatherObject.class);
        System.out.println(todayWeather.toString());
        WeatherObject.WeatherData weatherData = todayWeather.getData().get(0);
        //System.out.println("The temperature is: " + weatherData.getTemp());
        //System.out.println("Weather description is: " + weatherData.getWeather().getDescription());
        assertThat(weatherData.getTemp()).isEqualTo(20.0);
        assertThat(weatherData.getWeather().getDescription()).isEqualTo("Overcast clouds");
        //WeatherObject todayWeather = new Gson().fromJson()

        /*
        String data = null;
        try {
            data = readFileAsString("/Users/Kristina/Development/java-json-parsing/src/test/resources/example-response-from-weatherbit.io.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(data);

         */


    }

    @Test
    void deserializeJsonStringUsingJackson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        WeatherObject todayWeatherSameFieldName = objectMapper.readValue(fileContent, WeatherObject.class);
        WeatherObject.WeatherData weatherData = todayWeatherSameFieldName.getData().get(0);
        assertThat(weatherData.getTemp()).isEqualTo(20.0);
        assertThat(weatherData.getWeather().getDescription()).isEqualTo("Overcast clouds");

        WeatherObject todayWeatherDifferentFieldName = objectMapper.readValue(fileContent, WeatherObject.class);
        WeatherObject.WeatherData weatherDataCustomFieldName = todayWeatherDifferentFieldName.getData().get(0);
        assertThat(weatherDataCustomFieldName.getTemp()).isEqualTo(20.0);
        assertThat(weatherDataCustomFieldName.getWeather().getDescription()).isEqualTo("Overcast clouds");
    }

    @Test
    void deserializeJsonStringUsingJsonObject() throws IOException {
        JSONObject jsonObject = new JSONObject(fileContent);
        JSONObject data = jsonObject.getJSONArray("data").getJSONObject(0);
        System.out.println("THe temperature is: " + data.getDouble("temp"));
        System.out.println("Description: " + data.getJSONObject("weather").getString("description"));
        assertThat(data.getDouble("temp")).isEqualTo(20.0);
        assertThat(data.getJSONObject("weather").getString("description")).isEqualTo("Overcast clouds");
    }
}