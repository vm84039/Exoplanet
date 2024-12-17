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
                .append("            <a href=\"javascript:void(0)\" id=\"link-q4\">Discovery Timeline Table</a>\n")
                .append("        </nav>\n")
                .append("        <!-- Main Content -->\n")
                .append("        <div class=\"content\">\n")
                .append("            <h1 class=\"mb-4\">Exoplanet Questions by Vinson Martin</h1>\n")

                // Section 1: Orphan Planets
                .append("            <div id=\"q1\" class=\"section active\">\n")
                .append("                <div class=\"card\">\n")
                .append("                    <div class=\"card-body\">\n")
                .append("                        <h5 class=\"card-title\">Question 1: Orphan Planets</h5>\n")
                .append("                        <p class=\"card-text\">Number of orphan planets discovered: <strong>")
                .append(noStar).append("</strong>.</p>\n")
                .append("                    </div>\n")
                .append("                </div>\n")
                .append("            </div>\n")

                // Section 2: Hottest Star
                .append("            <div id=\"q2\" class=\"section\">\n")
                .append("                <div class=\"card\">\n")
                .append("                    <div class=\"card-body\">\n")
                .append("                        <h5 class=\"card-title\">Question 2: Hottest Star</h5>\n")
                .append("                        <p class=\"card-text\">The name of the planet orbiting the hottest star: <strong>")
                .append(hottestPlanet.getPlanetIdentifier()).append("</strong>.</p>\n")
                .append("                        <p class=\"card-text\">Temperature: <strong>")
                .append(hottestPlanet.getHostStarTempK()).append(" K</strong>.</p>\n")
                .append("                    </div>\n")
                .append("                </div>\n")
                .append("            </div>\n")

                // Section 3: Timeline Text
                .append("            <div id=\"q3\" class=\"section\">\n")
                .append("                <div class=\"card\">\n")
                .append("                    <div class=\"card-body\">\n")
                .append("                        <h5 class=\"card-title\">Question 3: Discovery Timeline</h5>\n");
        for (TimelineData data : dataList) {
            html.append("                        <p>In <strong>")
                .append(data.getYear() == 0 ? "Unknown" : data.getYear())
                .append("</strong>, we discovered <strong>")
                .append(data.getSmall()).append(" ").append(data.singular(data.getSmall()))
                .append(", ").append(data.getMedium()).append(" ").append(data.singular(data.getMedium()))
                .append(", and ").append(data.getLarge()).append(" ").append(data.singular(data.getLarge()))
                .append(".</strong></p>\n");
        }
        html.append("                    </div>\n")
                .append("                </div>\n")
                .append("            </div>\n")

                // Section 4: Timeline Table
                .append("            <div id=\"q4\" class=\"section\">\n")
                .append("                <table class='table table-bordered table-striped'>\n")
                .append("                    <thead>\n")
                .append("                        <tr><th>Year</th><th>Small</th><th>Medium</th><th>Large</th></tr>\n")
                .append("                    </thead>\n")
                .append("                    <tbody>\n");
        for (TimelineData data : dataList) {
            html.append("                        <tr>\n")
                .append("                            <td>").append(data.getYear() == 0 ? "Unknown" : data.getYear()).append("</td>\n")
                .append("                            <td>").append(data.getSmall()).append("</td>\n")
                .append("                            <td>").append(data.getMedium()).append("</td>\n")
                .append("                            <td>").append(data.getLarge()).append("</td>\n")
                .append("                        </tr>\n");
        }
        html.append("                    </tbody>\n")
                .append("                </table>\n")
                .append("            </div>\n")
                .append("        </div>\n") // Content div end
                .append("    </div>\n") // Flex container end

                // JavaScript for Section Navigation
                .append("    <script>\n")
                .append("        function showSection(id) {\n")
                .append("            document.querySelectorAll('.section').forEach(sec => sec.classList.remove('active'));\n")
                .append("            document.getElementById(id).classList.add('active');\n")
                .append("        }\n")
                .append("        document.getElementById('link-q1').onclick = () => showSection('q1');\n")
                .append("        document.getElementById('link-q2').onclick = () => showSection('q2');\n")
                .append("        document.getElementById('link-q3').onclick = () => showSection('q3');\n")
                .append("        document.getElementById('link-q4').onclick = () => showSection('q4');\n")
                .append("    </script>\n")
                .append("</body>\n")
                .append("</html>");

        return html.toString();
    }
}
