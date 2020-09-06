package com.yaroslav.greeting.Card;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
// Card query
@Entity
@Table(name="cards")
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="card_id")
    private Long card_id;
    @Column(name="title")
    private String title;
    @Column(name="text")
    private String text;


    @Override
    public String toString() {
        return "Card{" +
                "card_id=" + card_id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(card_id, card.card_id) &&
                Objects.equals(title, card.title) &&
                Objects.equals(text, card.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(card_id, title, text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getCard_id() { return card_id; }

    public void setCard_id(Long card_id) {
        this.card_id = card_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}