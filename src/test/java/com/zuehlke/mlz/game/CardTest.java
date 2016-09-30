package com.zuehlke.mlz.game;

import com.zuehlke.mlz.game.Card;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by magdalena on 17.09.16.
 */
public class CardTest {

    public static final String KING= "King";
    public static final String SPADE = "Spade";
    private Card card;

    @Test
    public void cardHasANumberAndAColor(){
        card = new Card(KING, SPADE);
        assertEquals(KING, card.getNumber());
        assertEquals(SPADE, card.getColor());
    }


}
