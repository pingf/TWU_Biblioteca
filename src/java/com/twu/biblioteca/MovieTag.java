package com.twu.biblioteca;

/**
 * Created by fcmeng on 3/3/15.
 */
public class MovieTag {
    private String name, year, director, rating;
    private Integer count;

    public MovieTag(String name, String year, String director, String rating, Integer count) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.count = count;
    }

    public boolean checkoutMovie() {
        if (this.count > 0) {
            this.count--;
            return true;
        }
        return false;
    }

    public void returnMovie() {
        this.count++;
    }

    public String getName() {
        return this.name;
    }

    public Integer getCount() {
        return this.count;
    }

    public String[] getInfo() {
        return new String[]{this.name, this.year, this.director, this.rating, this.count.toString()};
    }
}
