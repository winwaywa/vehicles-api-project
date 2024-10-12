package com.udacity.pricing.domain.price;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PriceRepository extends CrudRepository<Price, Long> {
    Price findByVehicleId(Long vehicleId);
}
