package my.home.entity;

import java.util.Date;

public class Ad {
    private String id;
    private String title;
    private String context;
    private Date date;
    private String phoneNumber;
    private Company company;

    public Ad() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", date=" + date +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
