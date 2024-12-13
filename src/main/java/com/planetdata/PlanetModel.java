package com.planetdata;

public class PlanetModel {

    // Primary identifier of planet
    private String planetIdentifier;
    // TypeFlag: [0=no known stellar binary companion; 1=P-type binary
    // (circumbinary); 2=S-type binary; 3=orphan planet (no star)]
    private int typeFlag;
    private double planetaryMassJpt;
    private double radiusJpt;
    private double periodDays;
    private double semiMajorAxisAU;
    private String eccentricity;
    private String periastronDeg;
    private String longitudeDeg;
    private String ascendingNodeDeg;
    private int inclinationDeg;
    private String surfaceTempK;
    private String ageGyr;
    private String discoveryMethod;
    private int discoveryYear;
    private String lastUpdated;
    private String rightAscension;
    private String declination;
    private String distFromSunParsec;
    private double hostStarMassSlrMass;
    private double hostStarRadiusSlrRad;
    private int hostStarMetallicity;
    private int hostStarTempK;
    private String hostStarAgeGyr;

    // Constructor
    public PlanetModel() {

    }

    public PlanetModel(String planetIdentifier, double radiusJpt, int discoveryYear) {
        this.planetIdentifier = planetIdentifier;
        this.radiusJpt = radiusJpt;
        this.discoveryYear = discoveryYear;
    }

    public PlanetModel(String planetIdentifier, int typeFlag, double planetaryMassJpt, double radiusJpt,
            double periodDays,
            double semiMajorAxisAU, String eccentricity, String periastronDeg, String longitudeDeg,
            String ascendingNodeDeg, int inclinationDeg, String surfaceTempK, String ageGyr,
            String discoveryMethod, int discoveryYear, String lastUpdated, String rightAscension,
            String declination, String distFromSunParsec, double hostStarMassSlrMass,
            double hostStarRadiusSlrRad, int hostStarMetallicity, int hostStarTempK,
            String hostStarAgeGyr) {

        this.planetIdentifier = planetIdentifier;
        this.typeFlag = typeFlag;
        this.planetaryMassJpt = planetaryMassJpt;
        this.radiusJpt = radiusJpt;
        this.periodDays = periodDays;
        this.semiMajorAxisAU = semiMajorAxisAU;
        this.eccentricity = eccentricity;
        this.periastronDeg = periastronDeg;
        this.longitudeDeg = longitudeDeg;
        this.ascendingNodeDeg = ascendingNodeDeg;
        this.inclinationDeg = inclinationDeg;
        this.surfaceTempK = surfaceTempK;
        this.ageGyr = ageGyr;
        this.discoveryMethod = discoveryMethod;
        this.discoveryYear = discoveryYear;
        this.lastUpdated = lastUpdated;
        this.rightAscension = rightAscension;
        this.declination = declination;
        this.distFromSunParsec = distFromSunParsec;
        this.hostStarMassSlrMass = hostStarMassSlrMass;
        this.hostStarRadiusSlrRad = hostStarRadiusSlrRad;
        this.hostStarMetallicity = hostStarMetallicity;
        this.hostStarTempK = hostStarTempK;
        this.hostStarAgeGyr = hostStarAgeGyr;
    }

    // Getters and Setters
    public String getPlanetIdentifier() {
        return planetIdentifier;
    }

    public void setPlanetIdentifier(String planetIdentifier) {
        this.planetIdentifier = planetIdentifier;
    }

    public int getTypeFlag() {
        return typeFlag;
    }

    public void setTypeFlag(int typeFlag) {
        this.typeFlag = typeFlag;
    }

    public double getPlanetaryMassJpt() {
        return planetaryMassJpt;
    }

    public void setPlanetaryMassJpt(double planetaryMassJpt) {
        this.planetaryMassJpt = planetaryMassJpt;
    }

    public double getRadiusJpt() {
        return radiusJpt;
    }

    public void setRadiusJpt(double radiusJpt) {
        this.radiusJpt = radiusJpt;
    }

    public double getPeriodDays() {
        return periodDays;
    }

    public void setPeriodDays(double periodDays) {
        this.periodDays = periodDays;
    }

    public double getSemiMajorAxisAU() {
        return semiMajorAxisAU;
    }

    public void setSemiMajorAxisAU(double semiMajorAxisAU) {
        this.semiMajorAxisAU = semiMajorAxisAU;
    }

    public String getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(String eccentricity) {
        this.eccentricity = eccentricity;
    }

    public String getPeriastronDeg() {
        return periastronDeg;
    }

    public void setPeriastronDeg(String periastronDeg) {
        this.periastronDeg = periastronDeg;
    }

    public String getLongitudeDeg() {
        return longitudeDeg;
    }

    public void setLongitudeDeg(String longitudeDeg) {
        this.longitudeDeg = longitudeDeg;
    }

    public String getAscendingNodeDeg() {
        return ascendingNodeDeg;
    }

    public void setAscendingNodeDeg(String ascendingNodeDeg) {
        this.ascendingNodeDeg = ascendingNodeDeg;
    }

    public int getInclinationDeg() {
        return inclinationDeg;
    }

    public void setInclinationDeg(int inclinationDeg) {
        this.inclinationDeg = inclinationDeg;
    }

    public String getSurfaceTempK() {
        return surfaceTempK;
    }

    public void setSurfaceTempK(String surfaceTempK) {
        this.surfaceTempK = surfaceTempK;
    }

    public String getAgeGyr() {
        return ageGyr;
    }

    public void setAgeGyr(String ageGyr) {
        this.ageGyr = ageGyr;
    }

    public String getDiscoveryMethod() {
        return discoveryMethod;
    }

    public void setDiscoveryMethod(String discoveryMethod) {
        this.discoveryMethod = discoveryMethod;
    }

    public int getDiscoveryYear() {
        return discoveryYear;
    }

    public void setDiscoveryYear(int discoveryYear) {
        this.discoveryYear = discoveryYear;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getRightAscension() {
        return rightAscension;
    }

    public void setRightAscension(String rightAscension) {
        this.rightAscension = rightAscension;
    }

    public String getDeclination() {
        return declination;
    }

    public void setDeclination(String declination) {
        this.declination = declination;
    }

    public String getDistFromSunParsec() {
        return distFromSunParsec;
    }

    public void setDistFromSunParsec(String distFromSunParsec) {
        this.distFromSunParsec = distFromSunParsec;
    }

    public double getHostStarMassSlrMass() {
        return hostStarMassSlrMass;
    }

    public void setHostStarMassSlrMass(double hostStarMassSlrMass) {
        this.hostStarMassSlrMass = hostStarMassSlrMass;
    }

    public double getHostStarRadiusSlrRad() {
        return hostStarRadiusSlrRad;
    }

    public void setHostStarRadiusSlrRad(double hostStarRadiusSlrRad) {
        this.hostStarRadiusSlrRad = hostStarRadiusSlrRad;
    }

    public int getHostStarMetallicity() {
        return hostStarMetallicity;
    }

    public void setHostStarMetallicity(int hostStarMetallicity) {
        this.hostStarMetallicity = hostStarMetallicity;
    }

    public int getHostStarTempK() {
        return hostStarTempK;
    }

    public void setHostStarTempK(int hostStarTempK) {
        this.hostStarTempK = hostStarTempK;
    }

    public String getHostStarAgeGyr() {
        return hostStarAgeGyr;
    }

    public void setHostStarAgeGyr(String hostStarAgeGyr) {
        this.hostStarAgeGyr = hostStarAgeGyr;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "planetIdentifier='" + planetIdentifier + '\'' +
                ", typeFlag=" + typeFlag +
                ", planetaryMassJpt=" + planetaryMassJpt +
                ", radiusJpt=" + radiusJpt +
                ", periodDays=" + periodDays +
                ", semiMajorAxisAU=" + semiMajorAxisAU +
                ", eccentricity='" + eccentricity + '\'' +
                ", periastronDeg='" + periastronDeg + '\'' +
                ", longitudeDeg='" + longitudeDeg + '\'' +
                ", ascendingNodeDeg='" + ascendingNodeDeg + '\'' +
                ", inclinationDeg=" + inclinationDeg +
                ", surfaceTempK='" + surfaceTempK + '\'' +
                ", ageGyr='" + ageGyr + '\'' +
                ", discoveryMethod='" + discoveryMethod + '\'' +
                ", discoveryYear=" + discoveryYear +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", rightAscension='" + rightAscension + '\'' +
                ", declination='" + declination + '\'' +
                ", distFromSunParsec='" + distFromSunParsec + '\'' +
                ", hostStarMassSlrMass=" + hostStarMassSlrMass +
                ", hostStarRadiusSlrRad=" + hostStarRadiusSlrRad +
                ", hostStarMetallicity=" + hostStarMetallicity +
                ", hostStarTempK=" + hostStarTempK +
                ", hostStarAgeGyr='" + hostStarAgeGyr + '\'' +
                '}';
    }
}
