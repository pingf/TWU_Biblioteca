package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fcmeng on 2/21/15.
 */
public class FakeStore {
    private List<BookTag> book_tags = new ArrayList<BookTag>();
    private List<MovieTag> movie_tags = new ArrayList<MovieTag>();
    private List<CheckoutTag> checkout_tags = new ArrayList<CheckoutTag>();
    private Account current_user=new Account("Ingress","bluegreen","hello@world.com","11122223333");
    BookTag[] fake_book_tags ={
            new BookTag("Learning Python, 4th Edition","Mark Lutz","January 1, 2009",3),
            new BookTag("Python for Unix and Linux System Administration","Noah Gift, Jeremy M. Jones","January 1, 2008",2)
    };
    MovieTag[] fake_movie_tags ={
            new MovieTag("Big Hero 6", "2014", "Don Hall","8.7", 4),
            new MovieTag("Paddington", "2014", "Paul Thomas King","8.2", 7),
    };

    public FakeStore() {
        for(BookTag bookTag : fake_book_tags){
            book_tags.add(bookTag);
        }
        for(MovieTag movieTag : fake_movie_tags){
            movie_tags.add(movieTag);
        }
    }

    public String[] current_user_info(){
        return this.current_user.getInfo();
    }

    public boolean checkoutBook(String name){
        BookTag bookTag = findBook(name);
        if(bookTag==null) return false;
        checkout_tags.add(new CheckoutTag(current_user.getId(),bookTag.getName()));
        return bookTag.checkoutBook();
    }

    public boolean returnBook(String name){
        BookTag bookTag = findBook(name);
        if(bookTag==null) return false;
        bookTag.returnBook();
        return true;
    }

    public BookTag findBook(String name){
        for(BookTag bookTag : book_tags){
            if(bookTag.getName().equals(name)){
                return bookTag;
            }
        }
        return null;
    }

    public List<String[]> listBooks() {
        List<String[]> books_info = new ArrayList<String[]>();
        for(BookTag bookTag : book_tags){
            if(bookTag.getCount()>0) books_info.add(bookTag.getInfo());
        }
        return books_info;
    }

    public boolean checkoutMovie(String name){
        MovieTag movieTag = findMovie(name);
        if(movieTag==null) return false;
        checkout_tags.add(new CheckoutTag(current_user.getId(),movieTag.getName()));
        return movieTag.checkoutMovie();
    }

    public boolean returnMovie(String name){
        MovieTag movieTag = findMovie(name);
        if(movieTag==null) return false;
        movieTag.returnMovie();
        return true;
    }

    public MovieTag findMovie(String name){
        for(MovieTag movieTag : movie_tags){
            if(movieTag.getName().equals(name)){
                return movieTag;
            }
        }
        return null;
    }

    public List<String[]> listMovies() {
        List<String[]> movies_info = new ArrayList<String[]>();
        for(MovieTag movieTag : movie_tags){
            if(movieTag.getCount()>0) movies_info.add(movieTag.getInfo());
        }
        return movies_info;
    }




    public List<String[]> checkoutStatus() {
        List<String[]> checkouts_info = new ArrayList<String[]>();
        for(CheckoutTag checkoutTag : checkout_tags){
            checkouts_info.add(checkoutTag.getInfo());
        }
        return checkouts_info;
    }
}
