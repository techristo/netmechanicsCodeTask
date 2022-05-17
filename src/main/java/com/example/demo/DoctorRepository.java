package com.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.Doctor;



public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

    @Modifying
    @Query("UPDATE Doctor d SET d.username=:username, d.password=:password, d.firstName= :firstName, d.lastName= :lastName, d.phone = :phone, d.discipline=:discipline, d.comment=:comment, d.role=:role, d.active=:active WHERE d.phone = :oldPhone")
    public void updateDoctor(
        @Param(value = "oldPhone") String oldPhone,
        @Param(value = "username") String username,
        @Param(value = "password") String password, 
        @Param(value = "firstName") String firstName,
        @Param(value = "lastName") String lastName, 
        @Param(value = "phone") String phone,
        @Param(value = "discipline") String discipline, 
        @Param(value = "comment") String comment,
        @Param(value = "role") String role,
        @Param(value = "active") Boolean active
        );

        @Query("SELECT u FROM Doctor u WHERE u.username = :username")
        public Doctor getDoctorByUsername(@Param("username") String username);
     
        @Query("SELECT u FROM Doctor u WHERE u.username = :username AND u.password=:password")
        public Doctor login(
            @Param("username") String username,
            @Param("password") String password
            );
}
