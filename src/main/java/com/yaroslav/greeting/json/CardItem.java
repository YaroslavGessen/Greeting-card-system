package com.yaroslav.greeting.json;

import com.yaroslav.greeting.Card.Card;

import java.util.Objects;

public class CardItem {
    private String title;
    private String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                ", text='" + text + '\'' ;
    }


    public static CardItem fromCard(Card card){
        CardItem res = new CardItem();
        res.text = card.getText();
        res.title = card.getTitle();
        return res;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardItem that = (CardItem) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text);
    }

}
