package com.card.services.dao;

import org.springframework.data.repository.Repository;

import com.card.services.entity.Card;

public interface CardRepository extends Repository<Card, Integer> {

    Card findOneByEmail(String name);

    Card findOneByCardNumber(String cardNumber);

    Card save(Card card);
}
