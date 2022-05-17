package com.example.demo;
//import java.security.SecureRandom;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path="/doctors")
public class DoctorController {
        @Autowired 
        private DoctorRepository doctorRepository;

      
        @PostMapping(path="/add") 
        public @ResponseBody String addNewDoctor (
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String phone,
            @RequestParam String discipline,
            @RequestParam String comment,
            @RequestParam String role,
            @RequestParam Boolean active
            ) {

              
              /**int strength = 10; 
              BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
              String encodedPassword = bCryptPasswordEncoder.encode(password);**/
              
      
          Doctor n = new Doctor();
          n.setUsername(username);
          n.setPassword(password);
          n.setFirstName(firstName);
          n.setLastName(lastName);
          n.setPhone(phone);
          n.setDiscipline(discipline);
          n.setComment(comment);
          n.setRole(role);
          n.setActive(active);
          doctorRepository.save(n);
          return "Saved";
        }
      
        @GetMapping(path="/all")
        public @ResponseBody Iterable<Doctor> getAllUsers() {
          return doctorRepository.findAll();
        }
        @Transactional
        @PostMapping(path="/update")
        public @ResponseBody void UpdateDoctor (
            @RequestParam String oldPhone,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String phone,
            @RequestParam String discipline,
            @RequestParam String comment,
            @RequestParam String role,
            @RequestParam Boolean active
            ) {


              /**int strength = 10; 
              BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
              String encodedPassword = bCryptPasswordEncoder.encode(password);**/

              doctorRepository.updateDoctor(oldPhone,username,password,firstName,lastName,phone,discipline,comment,role,active);
            }

         
}
