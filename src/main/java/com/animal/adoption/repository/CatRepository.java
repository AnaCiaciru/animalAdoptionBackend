package com.animal.adoption.repository;


import com.animal.adoption.models.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    void deleteCatById(Long id);

    Optional<Cat> findCatById(Long id);
}
