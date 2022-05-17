package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.Patient;



public interface PatientRepository extends CrudRepository<Patient, Integer> {


    @Query("SELECT u FROM Patient u WHERE u.lastName = :lastName OR u.phone=:phone OR u.amka=:amka")
    public Iterable<Patient> getPatients(
        @Param("lastName") String lastName,
        @Param("phone") String phone,
        @Param("amka") String amka
    );
}
