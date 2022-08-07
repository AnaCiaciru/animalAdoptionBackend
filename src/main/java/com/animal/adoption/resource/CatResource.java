package com.animal.adoption.resource;


import com.animal.adoption.models.Cat;
import com.animal.adoption.service.CatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cat")
public class CatResource {
    private final CatService catService;

    public CatResource(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cat>> getAllCats(){
        List<Cat> cats = catService.findAllCats();
        return new ResponseEntity<>(cats, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Cat> getCatById(@PathVariable("id") Long id){
        Cat cat = catService.findCatById(id);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Cat> addCat(@RequestBody Cat cat){
        Cat newCat = catService.addCat(cat);
        return new ResponseEntity<>(newCat, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Cat> updateCat(@RequestBody Cat cat){
        Cat updateCat = catService.updateCat(cat);
        return new ResponseEntity<>(updateCat, HttpStatus.CREATED);
    }

//    @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
//    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody JsonPatch patch) {
//        try {
//            Customer customer = customerService.findCustomer(id).orElseThrow(CustomerNotFoundException::new);
//            Customer customerPatched = applyPatchToCustomer(patch, customer);
//            customerService.updateCustomer(customerPatched);
//            return ResponseEntity.ok(customerPatched);
//        } catch (JsonPatchException | JsonProcessingException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        } catch (CustomerNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCat(@PathVariable("id") Long id){
        catService.deleteCat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
