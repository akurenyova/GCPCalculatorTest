package com.epam.ta.testdata;

public class TestDataGCP {

    private String instances;
    private String software;
    private String mashineClass;
    private String series;
    private String machineType;
    private boolean addGPUs;
    private String numberOfGPUs;
    private String gpuType;
    private String localSSd;
    private String dataCenterLocation;
    private String commitedUsage;

    public TestDataGCP(String instances, String software, String mashineClass, String series,
                       String machineType, boolean addGPUs, String numberOfGPUs, String gpuType, String localSSd,
                       String dataCenterLocation, String commitedUsage) {
        this.instances = instances;
        this.software = software;
        this.mashineClass = mashineClass;
        this.series = series;
        this.machineType = machineType;
        this.addGPUs = addGPUs;
        this.numberOfGPUs = numberOfGPUs;
        this.gpuType = gpuType;
        this.localSSd = localSSd;
        this.dataCenterLocation = dataCenterLocation;
        this.commitedUsage = commitedUsage;
    }

    public String getInstances() {
        return instances;
    }

    public void setInstances(String instances) {
        this.instances = instances;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getMashineClass() {
        return mashineClass;
    }

    public void setMashineClass(String mashineClass) {
        this.mashineClass = mashineClass;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public boolean getAddGPUs() {
        return addGPUs;
    }

    public void setAddGPUs(boolean addGPUs) {
        this.addGPUs = addGPUs;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getLocalSSd() {
        return localSSd;
    }

    public void setLocalSSd(String localSSd) {
        this.localSSd = localSSd;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public void setDataCenterLocation(String dataCenterLocation) {
        this.dataCenterLocation = dataCenterLocation;
    }

    public String getCommitedUsage() {
        return commitedUsage;
    }

    public void setCommitedUsage(String commitedUsage) {
        this.commitedUsage = commitedUsage;
    }
}
