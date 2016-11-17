package com.theironyard;

/**
 * Created by jakefroeb on 11/16/16.
 */
public class Review {
    private String text;
    private int rating;
    private User user;
    private String venueId;
    private boolean approved;
    private int id;

    public Review(int id, String text, int rating, User user, String venueId) {
        this.id = id;
        this.text = text;
        this.rating = rating;
        this.approved = false;
        this.user = user;
        this.venueId = venueId;
    }

    public Review() {
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }
}
