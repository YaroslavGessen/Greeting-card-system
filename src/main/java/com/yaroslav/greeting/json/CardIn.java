package com.yaroslav.greeting.json;

import com.yaroslav.greeting.Card.Card;

import java.util.Objects;

public class CardIn {
    String title;
    String text;

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Card createCard() {
        Card res = new Card();
        res.setTitle(this.title);
        res.setText(text);
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardIn cardIn = (CardIn) o;
        return Objects.equals(title, cardIn.title) &&
                Objects.equals(text, cardIn.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text);
    }
}
