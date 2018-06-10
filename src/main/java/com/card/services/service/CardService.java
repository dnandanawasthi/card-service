package com.card.services.service;

import com.card.services.entity.Card;

public interface CardService {

    Card addCard(Card card);

    Card findCardByEmail(String email);

    Card findCardByCardNumber(String cardNumber);

    Card updateCard(Card card);
}
