package com.card.services.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.card.services.entity.Card;
import com.card.services.exception.ResourceNotAvailable;
import com.card.services.exception.ResourceNotUpdated;

public interface CardResources {

    ResponseEntity<?> addCard(@RequestBody Card card);

    Card findCardByNumber(@PathVariable("cardNumber") String cardNumber) throws ResourceNotAvailable;

    ResponseEntity<?> updateCard(@RequestBody Card card) throws ResourceNotUpdated;
}
