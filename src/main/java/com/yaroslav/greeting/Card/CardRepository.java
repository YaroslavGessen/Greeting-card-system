package com.yaroslav.greeting.Card;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import java.util.List;

public interface CardRepository extends CrudRepository<Card,Long> {
    final String fields = "SELECT c.card_id, c.title , c.text ";

    final String from =" FROM cards c ";

    final String where =
            "where (:title = '' or lower(c.title) like :title) " +
                    " and (:text = '' or lower(c.text) like :text)";

    final String pagination = " limit :limit offset :offset";
    @Query(value = fields + from + where + pagination , nativeQuery = true)
    List<Card> searchCards(
            @Nullable @Param("title") String title,
            @Nullable @Param("text") String text,
            @Param("limit") Integer limit, @Param("offset") Integer offset
    );

    @Query(value = "SELECT count(*)  " + from + where, nativeQuery = true)
    Integer countCards(
            @Nullable @Param("title") String title,
            @Nullable @Param("text") String text);
}
