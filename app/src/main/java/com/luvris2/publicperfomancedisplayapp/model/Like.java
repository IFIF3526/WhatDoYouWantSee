package com.luvris2.publicperfomancedisplayapp.model;

public class Like {

    private String mt20id;
    private String id;

    private String prfName; // 공연 이름
    private String prfodDate; // 공연 기간
    private String prfPlace; // 공연 장소

    public Like(String mt20id, String id, String prfName, String prfodDate, String prfPlace) {
        this.mt20id = mt20id;
        this.id = id;
        this.prfName = prfName;
        this.prfodDate = prfodDate;
        this.prfPlace = prfPlace;
    }

    public String getMt20id() {
        return mt20id;
    }

    public void setMt20id(String mt20id) {
        this.mt20id = mt20id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrfName() {
        return prfName;
    }

    public void setPrfName(String prfName) {
        this.prfName = prfName;
    }

    public String getPrfodDate() {
        return prfodDate;
    }

    public void setPrfodDate(String prfodDate) {
        this.prfodDate = prfodDate;
    }

    public String getPrfPlace() {
        return prfPlace;
    }

    public void setPrfPlace(String prfPlace) {
        this.prfPlace = prfPlace;
    }

}
