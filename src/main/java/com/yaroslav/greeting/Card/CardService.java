package com.yaroslav.greeting.Card;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    ObjectMapper om;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CardService.class);

    @Autowired
    private CardRepository cardRepository;

    public List<Card> searchCards(String title, String text,
                                  Integer limit, Integer offset) {
        List<Card> queryRes = cardRepository.searchCards(likeLowerOrEmptyString(title),
                    likeLowerOrEmptyString(text), limit, offset);
        return queryRes;
    }

    public Optional<Card> findById(Long cardId){
        return cardRepository.findById(cardId);
    }

    public Integer countCards(String title, String text) {
        return cardRepository.countCards(likeLowerOrEmptyString(title), likeLowerOrEmptyString(text));
    }

    public void save(Card card) {
        cardRepository.save(card);
    }

    public static String likeLowerOrEmptyString(String str) {
        return str != null ? "%" + str.toLowerCase() + "%" : "";
    }

    public Card replacePlaceholders(Card card, String param1, String param2, String param3) {
        if (param1 == null) param1 = "";
        if (param2 == null) param2 = "";
        if (param3 == null) param3 = "";
        card.setText(
                card.getText().replace("$1",param1).replace("$2", param2).replace("$3", param3)
        );
        return card;
    }
}