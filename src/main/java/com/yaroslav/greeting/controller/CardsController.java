package com.yaroslav.greeting.controller;

import com.yaroslav.greeting.Card.Card;
import com.yaroslav.greeting.Card.CardService;
import com.yaroslav.greeting.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/greetingCard")
public class CardsController {

    @Autowired
    CardService cardService;

//    Create new tamplate
    @RequestMapping(path = "/catalog", method = RequestMethod.PUT)
    public ResponseEntity<Void> addNewCard(@RequestBody CardIn card) {
        cardService.save(card.createCard());
        return new ResponseEntity<Void>(new HttpHeaders(), HttpStatus.CREATED);
    }

//    Post operation on specific template
    @RequestMapping(value = "/catalog/{cardId}", method = RequestMethod.POST)
    public ResponseEntity<CardItem> fillTemplate(@PathVariable Long cardId,
                                                 @RequestParam(required = false) String param1,
                                                 @RequestParam(required = false) String param2,
                                                 @RequestParam(required = false) String param3) {
        Optional<Card> card = cardService.findById(cardId);

        if(card.isPresent()){
            Card res = cardService.replacePlaceholders(card.get(), param1, param2, param3);
            return new ResponseEntity(CardItem.fromCard(res), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

//   Search
    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public ResponseEntity<PaginationAndList> searchFormatted(String title, String text,
                                                    @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "50")  Integer count)
    {
        List<Card> cards = cardService.searchCards(title, text,
                count, (page - 1) * count);
        Integer total = cardService.countCards(title, text);
        return ResponseEntity.ok(
                PaginationAndList.of(Pagination.of(page, (total / count) + 1, total), cards));
    }
}
