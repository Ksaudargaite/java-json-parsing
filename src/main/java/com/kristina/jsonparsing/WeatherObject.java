package com.kristina.jsonparsing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public @Data
class WeatherObject {
    private List<WeatherData> data;

    //@JsonIgnoreProperties(ignoreUnknown = true)
    public static @Data class WeatherData {
        private double temp;

        private Weather weather;

        //@JsonIgnoreProperties(ignoreUnknown = true)
        public static @Data class Weather {
            private String description;

        }
    }
}
