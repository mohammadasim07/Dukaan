package com.example.Dukaan.shop.Repository;

import com.example.Dukaan.shop.Entity.ShopEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<ShopEntity, Long> {
    boolean existsByGstNumber(String gstNumber);
    Optional<ShopEntity> findByIdAndSoftDeleteFalse(Long id);
    List<ShopEntity> findAllBySoftDeleteFalse();
}
