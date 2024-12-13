package com.planetdata;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            // Download JSON file
            DownloadPlanetData.downloadPlanetJsonFile();

            // Create Json List
            List<PlanetModel> planetList = PlanetList.createList();

            // The number of orphan planets (no star) is where TypeFlag = 3.
            System.out.println("There are " + noStar(planetList) + " orphan planets. ");

            // The name (planet identifier) of the planet orbiting the hottest star.
            PlanetModel hottestStarPlanet = hottestStar(planetList);
            System.out.println(
                    "The name of the planet orbiting the hottest star is " + hottestStarPlanet.getPlanetIdentifier() +
                            " which has a temparature of " + hottestStarPlanet.getHostStarTempK() + "K.");

            /*
             * A timeline of the number of planets discovered per year grouped by size. Use
             * the following groups:
             * “small” is less than 1 Jupiter radii, “medium” is less than 2 Jupiter radii,
             * and anything bigger is considered “large”.
             * For example, in 2004 we discovered 2 small planets, 5 medium planets, and 0
             * large planets.
             */
            planetTimeline(planetList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int noStar(List<PlanetModel> planets) {
        int count = 0;
        for (PlanetModel planet : planets) {
            if (planet.getTypeFlag() == 3) {
                count++;
            }
        }
        return count;
    }

    public static PlanetModel hottestStar(List<PlanetModel> planets) {
        PlanetModel tempPlanet = new PlanetModel();
        int hottestStar = 0;

        for (PlanetModel planet : planets) {
            if (planet.getHostStarTempK() > hottestStar) {
                hottestStar = planet.getHostStarTempK();
                tempPlanet = planet;
            }
        }

        return tempPlanet;
    }

    public static void planetTimeline(List<PlanetModel> planets) {
        System.out.printf("A timeline of the number of planets discovered per year grouped by size\n");

        if (planets == null || planets.isEmpty()) {
            System.out.println("No planet data available.");
            return;
        }

        // Sort the planets first by year (descending) and then by size (radius)
        planets.sort(Comparator
                .comparingInt(PlanetModel::getDiscoveryYear)
                .reversed() // Sort by year in descending order
                .thenComparingDouble(PlanetModel::getRadiusJpt));

        int i = 0;
        int last = planets.size() - 1;
        int year = planets.get(i).getDiscoveryYear();

        // Iterate through the planets list and count planets by size
        while (i <= last) {
            int small = 0;
            int medium = 0;
            int large = 0;

            // Process all planets of the same discovery year
            while (i <= last && planets.get(i).getDiscoveryYear() == year) {
                PlanetModel tempPlanet = planets.get(i);
                double radius = tempPlanet.getRadiusJpt();

                if (radius < 1) {
                    small++;
                } else if (radius < 2) {
                    medium++;
                } else {
                    large++;
                }
                i++; // Move to the next planet
            }

            // Handle the output for the current year
            if (year == 0) {
                System.out.println(small + " small " + singular(small) + ", " + medium + " medium " + singular(medium) + ", " +   large
                        + " large " + singular(large) +"  were discovered in years that are not listed.");
            } else {
                System.out.printf("In " + year + ", we discovered " + small + " small " + singular(small) + ", " + medium + " medium " + singular(medium) + ", and " +   large
                        + " large " + singular(large) + ".\n");
            }

            // If there are more planets, update the year to the next group
            if (i <= last) {
                year = planets.get(i).getDiscoveryYear();
            }
        }
    }

    public static String singular(int num) {

        if (num == 1) {
            return "planet";
        } else {
            return "planets";
        }
    }

}
