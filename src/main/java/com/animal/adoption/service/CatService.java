package com.animal.adoption.service;

import cat.miau.catlovers.exception.UserNotFoundException;

import com.animal.adoption.models.Cat;
import com.animal.adoption.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Service
@Transactional
public class CatService {
    private final CatRepository catRepository;

    @Autowired
    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public Cat addCat(Cat cat){
        return catRepository.save(cat);
    }

    public List<Cat> findAllCats() {
        return catRepository.findAll();
    }

    public Cat updateCat(Cat cat) {
        return catRepository.save(cat);
    }

    public Cat findCatById(Long id) {
        return catRepository.findCatById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteCat(Long id){
        catRepository.deleteCatById(id);
    }
}
