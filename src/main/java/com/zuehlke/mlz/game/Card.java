package com.zuehlke.mlz.game;

/**
 * Created by magdalena on 17.09.16.
 */
public class Card {
    private final String number;
    private final String color;

    public Card(String name, String color){
        this.number = name;
        this.color = color;
    }
    public String getNumber(){
        return number;
    }

    public String getColor() {
        return color;
    }
}
