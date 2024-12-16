package com.planetdata;

import java.util.List;

public class PlanetHtml {
    public static String generatePage(int noStar, PlanetModel hottestPlanet, List<TimelineData> dataList) {
        StringBuilder html = new StringBuilder();

        html.append("<!DOCTYPE html>\n")
                .append("<html lang=\"en\">\n")
                .append("<head>\n")
                .append("    <meta charset=\"UTF-8\">\n")
                .append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n")
                .append("    <meta http-equiv=\"Content-Security-Policy\" content=\"script-src 'self' 'unsafe-inline' 'unsafe-eval' https://cdn.jsdelivr.net;\">\n")
                .append("    <title>Dashboard</title>\n")
                .append("    <!-- Bootstrap CSS -->\n")
                .append("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\n")
                .append("    <style>\n")
                .append("        body {\n")
                .append("            font-family: Arial, sans-serif;\n")
                .append("        }\n")
                .append("        .sidebar {\n")
                .append("            height: 100vh;\n")
                .append("            width: 250px;\n")
                .append("            background-color: #343a40;\n")
                .append("            color: #fff;\n")
                .append("        }\n")
                .append("        .sidebar a {\n")
                .append("            color: #adb5bd;\n")
                .append("            text-decoration: none;\n")
                .append("            padding: 15px;\n")
                .append("            display: block;\n")
                .append("        }\n")
                .append("        .sidebar a:hover {\n")
                .append("            background-color: #495057;\n")
                .append("            color: #fff;\n")
                .append("        }\n")
                .append("        .content {\n")
                .append("            margin-left: 250px;\n")
                .append("            padding: 20px;\n")
                .append("        }\n")
                .append("        .section {\n")
                .append("            display: none;\n")
                .append("        }\n")
                .append("        .section.active {\n")
                .append("            display: block;\n")
                .append("        }\n")
                .append("    </style>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("    <div class=\"d-flex\">\n")
                .append("        <!-- Sidebar -->\n")
                .append("        <nav class=\"sidebar d-flex flex-column\">\n")
                .append("            <h4 class=\"text-center py-3 border-bottom\">Dashboard</h4>\n")
                .append("            <a href=\"javascript:void(0)\" id=\"link-q1\">Orphan Planets</a>\n")
                .append("            <a href=\"javascript:void(0)\" id=\"link-q2\">Hottest Star</a>\n")
                .append("            <a href=\"javascript:void(0)\" id=\"link-q3\">Discovery Timeline</a>\n")
                .append("        </nav>\n")
                .append("        <!-- Main Content -->\n")
                .append("        <div class=\"content\">\n")
                .append("            <div class=\"container-fluid\">\n")
                .append("                <h1 class=\"mb-4\">Exoplanet Questions by Vinson Martin</h1>\n")
                .append("                <!-- Section 1: Question 1 -->\n")
                .append("                <div id=\"q1\" class=\"section active\">\n")
                .append("                    <div class=\"row mb-4\">\n")
                .append("                        <div class=\"col-md-12\">\n")
                .append("                            <div class=\"card\">\n")
                .append("                                <div class=\"card-body\">\n")
                .append("                                    <h5 class=\"card-title\">Question 1: Orphan Planets</h5>\n")
                .append("                                    <p class=\"card-text\">Number of orphan planets discovered: <strong>")
                .append(noStar)
                .append("                                       </strong>.</p>\n")
                .append("                                </div>\n")
                .append("                            </div>\n")
                .append("                        </div>\n")
                .append("                    </div>\n")
                .append("                </div>\n")
                .append("                <!-- Section 2: Question 2 -->\n")
                .append("                <div id=\"q2\" class=\"section\">\n")
                .append("                    <div class=\"row mb-4\">\n")
                .append("                        <div class=\"col-md-12\">\n")
                .append("                            <div class=\"card\">\n")
                .append("                                <div class=\"card-body\">\n")
                .append("                                    <h5 class=\"card-title\">Question 2: Hottest Star</h5>\n")
                .append("                                    <p class=\"card-text\">The name of the planet orbiting the hottest star: <strong>")
                .append(hottestPlanet.getPlanetIdentifier())
                .append("</strong>.</p>\n")
                .append("                                    <p class=\"card-text\">")
                .append(hottestPlanet.getPlanetIdentifier())
                .append(" has a temperature of <strong>")
                .append(hottestPlanet.getHostStarTempK())
                .append(" K</strong>.</p>\n")
                .append("                                </div>\n")
                .append("                            </div>\n")
                .append("                        </div>\n")
                .append("                    </div>\n")
                .append("                </div>\n");

        // Section 3: Timeline Data (using dataList)
        html.append("                <div id=\"q3\" class=\"section\">\n")
                .append("    <div style='max-height: 90vh; overflow-y: auto;'>\n")
                .append("        <table class='table table-bordered table-striped'>\n")
                .append("            <thead>\n")
                .append("                <tr>\n")
                .append("                    <th colspan='4'>A timeline of the number of planets discovered per year grouped by size.</th>\n")
                .append("                 </tr>\n")
                .append("                <tr>\n")
                .append("                    <th>Year</th>\n")
                .append("                    <th>Small<br><span class='small'>(< 1 Jupiter radii)</span></th>\n")
                .append("                    <th>Medium<br><span class='small'>(1-3 Jupiter radii)</span></th>\n")
                .append("                    <th>Large<br><span class='small'>(> 3 Jupiter radii)</span></th>\n")
                .append("                </tr>\n")
                .append("            </thead>\n")
                .append("            <tbody>\n");
        // Loop through dataList and create table rows
        for (TimelineData data : dataList) {
            html.append("                            <tr>\n")
                .append("                                <td>")
                .append(data.getYear() == 0 ? "Unknown" : data.getYear()) // Check if year is 0
                .append("</td>\n")
                .append("                                <td>").append(data.getSmall()).append("</td>\n")
                .append("                                <td>").append(data.getMedium()).append("</td>\n")
                .append("                                <td>").append(data.getLarge()).append("</td>\n")
                .append("                            </tr>\n");
        }
        

        html.append("                        </tbody>\n")
                .append("                    </table>\n")
                .append("                </div>\n")
                .append("    <!-- Bootstrap JS Bundle -->\n")
                .append("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\n")
                .append("    <script>\n")
                .append("        // Function to show and hide sections based on navigation click\n")
                .append("        function showSection(sectionId) {\n")
                .append("            // Hide all sections\n")
                .append("            const sections = document.querySelectorAll('.section');\n")
                .append("            sections.forEach(function (section) {\n")
                .append("                section.classList.remove('active');\n")
                .append("            });\n")
                .append("            // Show the selected section\n")
                .append("            const activeSection = document.getElementById(sectionId);\n")
                .append("            if (activeSection) {\n")
                .append("                activeSection.classList.add('active');\n")
                .append("            }\n")
                .append("        }\n")
                .append("        // Add event listeners for links\n")
                .append("        document.addEventListener('DOMContentLoaded', function() {\n")
                .append("            document.getElementById('link-q1').addEventListener('click', function() {\n")
                .append("                showSection('q1');\n")
                .append("            });\n")
                .append("            document.getElementById('link-q2').addEventListener('click', function() {\n")
                .append("                showSection('q2');\n")
                .append("            });\n")
                .append("            document.getElementById('link-q3').addEventListener('click', function() {\n")
                .append("                showSection('q3');\n")
                .append("            });\n")
                .append("            // Set default section to 'q1' when the page loads\n")
                .append("            showSection('q1');\n")
                .append("        });\n")
                .append("    </script>\n")
                .append("</body>\n")
                .append("</html>\n");

        return html.toString();
    }
}
