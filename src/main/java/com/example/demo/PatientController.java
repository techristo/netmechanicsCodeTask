package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/patients")
public class PatientController {
        @Autowired 
        private PatientRepository patientRepository;
      
        @PostMapping(path="/add") 
        public @ResponseBody String addNewPatient (
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String phone,
            @RequestParam String amka,
            @RequestParam String address,
            @RequestParam String comment
            ) {
          
      
          Patient n = new Patient();
          n.setFirstName(firstName);
          n.setLastName(lastName);
          n.setPhone(phone);
          n.setAmka(amka);
          n.setAddress(address);
          n.setComment(comment);
          patientRepository.save(n);
          return "Saved";
        }
      
        @GetMapping(path="/all")
        public @ResponseBody Iterable<Patient> getAllUsers() {
          return patientRepository.findAll();
        }

        @PostMapping(path="/get-patients")
        public @ResponseBody Iterable<Patient> getpatients(
          @RequestParam String lastName,
            @RequestParam String phone,
            @RequestParam String amka
        ) {
        return patientRepository.getPatients(lastName,phone,amka);
      }
}

