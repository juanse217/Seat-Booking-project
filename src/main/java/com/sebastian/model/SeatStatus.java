package com.sebastian.model;

public enum SeatStatus {
    TAKEN("T"), FREE("F");
    private String statusString;

    private SeatStatus(String statusString){
        this.statusString = statusString;
    }

    public String getStatusString() {
        return statusString;
    }

    @Override
    public String toString() {
        return statusString; 
    }
}
