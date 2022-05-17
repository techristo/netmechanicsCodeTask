package com.example.demo;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



import com.example.demo.Apointment;



public interface ApointmentRepository extends CrudRepository<Apointment, Integer> {

    
    @Query("SELECT u FROM Apointment u WHERE u.amka = :amka")
    public Iterable<Object> getApointmentByAmka(@Param("amka") String amka);

    @Query("SELECT u FROM Apointment u WHERE u.doctor = :doctor")
    public Iterable<Object> getApointmentByDoctor(@Param("doctor") String doctor);

}