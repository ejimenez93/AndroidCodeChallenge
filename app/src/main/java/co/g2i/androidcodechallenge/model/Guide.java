package co.g2i.androidcodechallenge.model;

public class Guide {

    private String name;
    private String startDate;
    private String endDate;
    private String url;
    private boolean loginRequired;
    private Venue venue;
    private String icon;

    public Guide(String name, String startDate, String endDate, String url, boolean loginRequired, Venue venue, String icon) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.url = url;
        this.loginRequired = loginRequired;
        this.venue = venue;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isLoginRequired() {
        return loginRequired;
    }

    public void setLoginRequired(boolean loginRequired) {
        this.loginRequired = loginRequired;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
