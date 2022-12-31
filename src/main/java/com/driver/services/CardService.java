package com.driver.services;

import com.driver.models.Student;
import com.driver.models.Card;
import com.driver.models.CardStatus;
import com.driver.repositories.CardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CardService {


    @Autowired
    CardRepository cardRepository3;

    public Card createAndReturn(Student student){
        Card card = Card.builder()
                .student(student)
                .cardStatus(CardStatus.ACTIVATED)
                .build();


        cardRepository3.save(card);
        student.setCard(card);

        //link student with a new card
        return card;
    }

    public void deactivateCard(int student_id){
        cardRepository3.deactivateCard(student_id, CardStatus.DEACTIVATED.toString());
    }
}
