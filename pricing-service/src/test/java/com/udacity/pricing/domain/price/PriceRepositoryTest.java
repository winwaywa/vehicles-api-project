package com.udacity.pricing.domain.price;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PriceRepositoryTest {

    @Autowired
    private PriceRepository priceRepository;

    @Test
    void testSaveAndFindPrice() {
        Price price = new Price();
        price.setCurrency("USD");
        price.setPrice(new BigDecimal("15000.00"));
        price.setVehicleId(1L);
        Price savedPrice = priceRepository.save(price);

        // Assert: Verify the Price was saved and can be retrieved by ID
        Optional<Price> retrievedPrice = priceRepository.findById(savedPrice.getId());
        assertTrue(retrievedPrice.isPresent());
        assertEquals("USD", retrievedPrice.get().getCurrency());
        assertEquals(new BigDecimal("15000.00"), retrievedPrice.get().getPrice());
        assertEquals(1L, retrievedPrice.get().getVehicleId());
    }
}