package com.card.services.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.services.dao.CardRepository;
import com.card.services.entity.Card;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    public Card addCard(final Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card findCardByEmail(final String email) {
        return cardRepository.findOneByEmail(email);
    }

    @Override
    public Card findCardByCardNumber(final String cardNumber) {
        return cardRepository.findOneByCardNumber(cardNumber);
    }

    @Override
    public Card updateCard(final Card card) {
        return cardRepository.save(card);
    }
}
