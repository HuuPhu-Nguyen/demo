package com.zoo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zoo.entity.Bird;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Integer> {

}
