package com.mongoCrud.mongoCrud.controller;

import com.mongoCrud.mongoCrud.model.Meme;
import com.mongoCrud.mongoCrud.repository.MemeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/meme")

public class MemeController {

    @Autowired
    MemeRepository memeRepository;

    @GetMapping("/memes")
    public List<Meme> getAllMemes() {
        return memeRepository.findAll();
    }

    @PostMapping("/memes/create")
    public Meme createMeme(@Valid @RequestBody Meme meme) {
        return memeRepository.save(meme);
    }

    @PutMapping("/memes/{id}")
    public ResponseEntity<Meme> updateMeme(@PathVariable("id") String id, @RequestBody Meme meme) {
        Meme memeData = memeRepository.findById(id).isPresent() ? memeRepository.findById(id).get() : new Meme();
        if (meme == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        memeData.setName(meme.getName());
        Meme updatedcustomer = memeRepository.save(memeData);
        return new ResponseEntity<>(updatedcustomer, HttpStatus.OK);
    }

    @DeleteMapping("/memes/{id}")
    public ResponseEntity<String> deleteMeme(@PathVariable("id") String id) {
        if(memeRepository.findById(id).isPresent()){
            memeRepository.delete(memeRepository.findById(id).get());
            return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
    }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/memes/delete")
    public ResponseEntity<String> deleteAllMemes() {
        memeRepository.deleteAll();
        return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
    }
}
