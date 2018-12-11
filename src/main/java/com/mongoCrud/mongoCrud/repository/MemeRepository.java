package com.mongoCrud.mongoCrud.repository;

import com.mongoCrud.mongoCrud.model.Meme;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MemeRepository extends MongoRepository<Meme, String> {}
