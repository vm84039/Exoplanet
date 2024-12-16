package com.planetdata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test.
 */
public class AppTest {

        /**
         * Rigorous Test :-)
         */
        @Test
        public void testNoStar() {
                // TypeFlag: [0=no known stellar binary companion; 1=P-type binary
                // (circumbinary); 2=S-type binary; 3=orphan planet (no star)]
                List<PlanetModel> mockPlanets = List.of(
                                new PlanetModel("Orphan1", 3, 0, 0, 0, 0, "", "", "", "", 0, "", "", "", 0, "", "", "",
                                                "", 0, 0, 0, 0,
                                                ""),
                                new PlanetModel("Orphan2", 3, 0, 0, 0, 0, "", "", "", "", 0, "", "", "", 0, "", "", "",
                                                "", 0, 0, 0, 0,
                                                ""),
                                new PlanetModel("Orphan3", 3, 0, 0, 0, 0, "", "", "", "", 0, "", "", "", 0, "", "", "",
                                                "", 0, 0, 0, 0,
                                                ""),
                                new PlanetModel("Orphan4", 3, 0, 0, 0, 0, "", "", "", "", 0, "", "", "", 0, "", "", "",
                                                "", 0, 0, 0, 0,
                                                ""),
                                new PlanetModel("No known stellar binary companion1", 0, 0, 0, 0, 0, "", "", "", "", 0,
                                                "", "", "", 0,
                                                "", "", "", "", 0, 0, 0, 0, ""),
                                new PlanetModel("No known stellar binary companion2", 0, 0, 0, 0, 0, "", "", "", "", 0,
                                                "", "", "", 0,
                                                "", "", "", "", 0, 0, 0, 0, ""),
                                new PlanetModel("P-type binary1", 1, 0, 0, 0, 0, "", "", "", "", 0, "", "", "", 0, "",
                                                "", "", "", 0, 0,
                                                0, 0, ""),
                                new PlanetModel("P-type binary2", 1, 0, 0, 0, 0, "", "", "", "", 0, "", "", "", 0, "",
                                                "", "", "", 0, 0,
                                                0, 0, ""),
                                new PlanetModel("S-type binary1", 2, 0, 0, 0, 0, "", "", "", "", 0, "", "", "", 0, "",
                                                "", "", "", 0, 0,
                                                0, 0, ""),
                                new PlanetModel("S-type binary2", 2, 0, 0, 0, 0, "", "", "", "", 0, "", "", "", 0, "",
                                                "", "", "", 0, 0,
                                                0, 0, ""));
                int orphanPlanets = App.noStar(mockPlanets);
                    // Print both the expected and actual outcomes
                int expectedOutcome = 4;

                System.out.println("\t\t\t**Test 1**\n\t\t\tExpected Outcome: " + expectedOutcome);
                System.out.println("\t\t\tActual Outcome: " + orphanPlanets);
                if (expectedOutcome == orphanPlanets){
                         System.out.println("\t\t\t**Test 1 passed**\n");
                }
                else {
                        System.out.println("\t\t\t**Test 1 failed**\n");

                }
                assertEquals(4, orphanPlanets, "There should be 4 orphan planet.");

        }

        @Test
        public void testHottestStar() {
                // Example of mock data
                List<PlanetModel> mockPlanets = List.of(
                                new PlanetModel("Cold", 0, 0, 0, 0, 0, "", "", "", "", 0, "", "", "", 0, "", "", "", "",
                                                0, 0, 0, 100,
                                                ""),
                                new PlanetModel("Medium", 0, 0, 0, 0, 0, "", "", "", "", 0, "", "", "", 0, "", "", "",
                                                "", 0, 0, 0,
                                                1000, ""),
                                new PlanetModel("Hot", 0, 0, 0, 0, 0, "", "", "", "", 0, "", "", "", 0, "", "", "", "",
                                                0, 0, 0, 5000,
                                                ""));

                PlanetModel hottestPlanet = App.hottestStar(mockPlanets);

                String expectedPlanetIdentifier = "Hot";


                    // Print both the expected and actual outcomes
                System.out.println("\t\t\t**Test2**\n\t\t\tExpected Planet Identifier: " + expectedPlanetIdentifier);
                System.out.println("\t\t\tActual Planet Identifier: " + hottestPlanet.getPlanetIdentifier());

                if (expectedPlanetIdentifier.equals(hottestPlanet.getPlanetIdentifier())){
                        System.out.println("\t\t\t**Test 2 passed**\n");
               }
               else {
                       System.out.println("\t\t\t**Test 2 failed**\n");

               }

                assertNotNull(hottestPlanet, "The hottest planet should not be null.");
                assertEquals("Hot", hottestPlanet.getPlanetIdentifier(), "The hottest planet should be Hot.");
        }

        // Test for planetTimeline method
        @Test
        void testPlanetTimeline() {
                // Arrange
                PlanetModel planet1 = new PlanetModel("PlanetA", 0.5, 2024); // Small planet
                PlanetModel planet2 = new PlanetModel("PlanetB", 1.2, 2024); // Medium planet
                PlanetModel planet3 = new PlanetModel("PlanetC", 2.5, 2024); // Large planet
                PlanetModel planet4 = new PlanetModel("PlanetD", 0.7, 2023); // Small planet
                PlanetModel planet5 = new PlanetModel("PlanetE", 1.7, 2023); // Medium planet
                PlanetModel planet6 = new PlanetModel("PlanetF", 0.8, 2022); // Small planet
                PlanetModel planet7 = new PlanetModel("PlanetG", 1.5, 2023); // Medium planet
                PlanetModel planet8 = new PlanetModel("PlanetH", 2.8, 2023); // Large planet
                PlanetModel planet9 = new PlanetModel("PlanetI", 2.0, 2024); // Large planet
                PlanetModel planet10 = new PlanetModel("PlanetJ", 0.3, 2022); // Small planet

                List<PlanetModel> planets = Arrays.asList(
                                planet1, planet2, planet3, planet4, planet5,
                                planet6, planet7, planet8, planet9, planet10);

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                PrintStream originalOut = System.out; // Backup original System.out
                System.setOut(new PrintStream(outputStream));

                try {
                        // Act
                        App.planetTimeline(planets); // Replace `App` with your class name

                        // Assert
                        StringBuilder expectedOutput = new StringBuilder();
                        expectedOutput.append(
                                        "A timeline of the number of planets discovered per year grouped by size\n");
                        expectedOutput.append(
                                        "In 2024, we discovered 1 small planet, 1 medium planet, and 2 large planets.\n");
                        expectedOutput.append(
                                        "In 2023, we discovered 1 small planet, 2 medium planets, and 1 large planet.\n");
                        expectedOutput.append(
                                        "In 2022, we discovered 2 small planets, 0 medium planets, and 0 large planets.\n");

                        assertEquals(expectedOutput.toString(), outputStream.toString());
                        System.setOut(originalOut);

                                // Print expected and actual results after assertion
                        System.out.println("\t\t\t**Test 3**\nExpected Output: ");
                        System.out.println(expectedOutput.toString());
                        
                        System.out.print("Actual Output: ");
                        System.out.print(outputStream.toString());

                        if (expectedOutput.toString().equals(outputStream.toString())){
                                System.out.println("\t\t\t**Test 3 passed**\n");
                       }
                       else {
                               System.out.println("\t\t\t**Test 3 failed**\n");
        
                       }
        
                                } finally {
                        System.setOut(originalOut); // Always restore the original System.out
                }
        }
}