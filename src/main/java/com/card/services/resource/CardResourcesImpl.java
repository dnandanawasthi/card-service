package com.card.services.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.card.services.entity.Card;
import com.card.services.exception.ResourceNotAvailable;
import com.card.services.service.CardService;

//for information @CrossOrigin can also managed thru annotation
@RestController
@RequestMapping({"/card"})
public class CardResourcesImpl implements CardResources {

    @Autowired
    private CardService cardService;

    /*@PostMapping(path = "/addcard", produces = { "application/json", "application/xml" })
    public Card addCard(@RequestBody Card card) throws ResourceNotAvailable {
        Card addCard = null;
        try {
            return addCard = cardService.addCard(card);
        } catch(Exception ex) {
            throw new ResourceNotAvailable("Card not provisioned :" + card + ex.getMessage());
        }
    }*/

    /**
     * Method provision new card for already registered user
     * @param card
     * @return ResponseEntity<>
     */
    @PostMapping(path = "/addcard", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> addCard(@Valid @RequestBody Card card){
        HttpHeaders responseHeader = new HttpHeaders();
        Card addCard = cardService.addCard(card);
        return new ResponseEntity<>(addCard, responseHeader, HttpStatus.CREATED);
    }

    /**
     * Method find card by card number
     * @param carNumber
     * @return
     * @throws ResourceNotAvailable
     */
    @GetMapping(path = {"/cardbynumber/{carNumber}"}, produces = { "application/json", "application/xml" })
    public Card findCardByNumber(@PathVariable("carNumber") String carNumber) throws ResourceNotAvailable {
        Card getCard = cardService.findCardByCardNumber(carNumber);
        if(getCard != null) {
            return getCard;
        } else {
            throw new ResourceNotAvailable("Card doesn't exist for "+carNumber);
        }
    }

    /*@PutMapping(path = {"/updatecard"}, produces = { "application/json", "application/xml" })
    public Card updateCard(@RequestBody Card card) throws ResourceNotUpdated {
        Card updatedCard = cardService.updateCard(card);
        if(updatedCard != null) {
            return updatedCard;
        } else {
            throw new ResourceNotUpdated("Card not updated "+card);
        }
    }*/

    /**
     * Method updated provisioned card details
     * @param card
     * @return ResponseEntity<>
     */
    @PutMapping(path = "/updatecard", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> updateCard(@Valid @RequestBody Card card){
        HttpHeaders responseHeader = new HttpHeaders();
        Card updatedCard = cardService.updateCard(card);
        return new ResponseEntity<>(updatedCard, responseHeader, HttpStatus.CREATED);
    }

}
