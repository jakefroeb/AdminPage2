package com.theironyard;

/**
 * Created by jakefroeb on 11/16/16.
 */
public class Reviews {
    private Review[] reviews;

    public Reviews() {
    }

    public Reviews(Review[] reviews) {
        this.reviews = reviews;
    }

    public Review[] getReviews() {
        return reviews;
    }

    public void setReviews(Review[] reviews) {
        this.reviews = reviews;
    }
}
