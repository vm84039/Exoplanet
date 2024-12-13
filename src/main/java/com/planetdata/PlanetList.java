package com.planetdata;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PlanetList {

    public static List<PlanetModel> createList() {
        List<PlanetModel> planets = new ArrayList<>();

        try {
            String filePath = "exoplanet-catalogue.json";
            File file = new File(filePath);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(file);
            for (JsonNode planetNode : rootNode) {
                PlanetModel planet = new PlanetModel();
                planet.setPlanetIdentifier(planetNode.get("PlanetIdentifier").asText());
                planet.setTypeFlag(planetNode.get("TypeFlag").asInt());
                planet.setPlanetaryMassJpt(planetNode.get("PlanetaryMassJpt").asDouble());
                planet.setRadiusJpt(planetNode.get("RadiusJpt").asDouble());
                planet.setPeriodDays(planetNode.get("PeriodDays").asDouble());
                planet.setSemiMajorAxisAU(planetNode.get("SemiMajorAxisAU").asDouble());
                planet.setEccentricity(planetNode.get("Eccentricity").asText());
                planet.setPeriastronDeg(planetNode.get("PeriastronDeg").asText());
                planet.setLongitudeDeg(planetNode.get("LongitudeDeg").asText());
                planet.setAscendingNodeDeg(planetNode.get("AscendingNodeDeg").asText());
                planet.setInclinationDeg(planetNode.get("InclinationDeg").asInt());
                planet.setSurfaceTempK(planetNode.get("SurfaceTempK").asText());
                planet.setAgeGyr(planetNode.get("AgeGyr").asText());
                planet.setDiscoveryMethod(planetNode.get("DiscoveryMethod").asText());
                planet.setDiscoveryYear(planetNode.get("DiscoveryYear").asInt());
                planet.setLastUpdated(planetNode.get("LastUpdated").asText());
                planet.setRightAscension(planetNode.get("RightAscension").asText());
                planet.setDeclination(planetNode.get("Declination").asText());
                planet.setDistFromSunParsec(planetNode.get("DistFromSunParsec").asText());
                planet.setHostStarMassSlrMass(planetNode.get("HostStarMassSlrMass").asDouble());
                planet.setHostStarRadiusSlrRad(planetNode.get("HostStarRadiusSlrRad").asDouble());
                planet.setHostStarMetallicity(planetNode.get("HostStarMetallicity").asInt());
                planet.setHostStarTempK(planetNode.get("HostStarTempK").asInt());
                planet.setHostStarAgeGyr(planetNode.get("HostStarAgeGyr").asText());
                planets.add(planet);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return planets;
    }
}
