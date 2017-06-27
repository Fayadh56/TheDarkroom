package com.darkroom.fayadhahmad.thedarkroom.Data;



public class Film {

    private String name;
    private int index;

    private String developers[];
    private double developTimes[];

    private double temperature;

    private double agitationTimes;
    private int noOfInversions;

    private boolean pushed;

    public Film(String name, int index, String developers[], double developTimes[], double agitationTimes,
         int noOfInversions, double temperature) {
        this.name = name;
        this.index = index;
        this.developers = developers;
        this.developTimes = developTimes;
        this.agitationTimes = agitationTimes;
        this.noOfInversions = noOfInversions;
        this.temperature = temperature;
        this.pushed = false;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public String[] getDevelopers() {
        return developers;
    }

    public double[] getDevelopTimes() {
        return developTimes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setDevelopers(String[] developers) {
        this.developers = developers;
    }

    public void setDevelopTimes(double[] developTimes) {
        this.developTimes = developTimes;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getAgitationTimes() {
        return agitationTimes;
    }

    public void setAgitationTimes(double agitationTimes) {
        this.agitationTimes = agitationTimes;
    }

    public int getNoOfInversions() {
        return noOfInversions;
    }

    public void setNoOfInversions(int noOfInversions) {
        this.noOfInversions = noOfInversions;
    }

    public boolean isPushed() {
        return pushed;
    }

    public void setPushed(boolean pushed) {
        this.pushed = pushed;
    }

    public void isPushed(int stops, double stopOne, double stopTwo) {
        if (stops == 1) {
            developTimes[0] = developTimes[0] * stopOne;
        } else if (stops == 2) {
            developTimes[0] = developTimes[0] * stopTwo;
        }
    }


}
