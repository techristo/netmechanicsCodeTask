package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/apointments")
public class ApointmentController {
        @Autowired 
        private ApointmentRepository apointmentRepository;
      
        @PostMapping(path="/add") 
        public @ResponseBody String addNewApointment (
            @RequestParam String date,
            @RequestParam String examination,
            @RequestParam String comment,
            @RequestParam String doctor,
            @RequestParam String amka
            ) {
          
      
          Apointment n = new Apointment();
          n.setDate(date);
          n.setExamination(examination);
          n.setComment(comment);
          n.setDoctor(doctor);
          n.setAmka(amka);
          apointmentRepository.save(n);
          return "Saved";
        }
      
        @PostMapping(path="/get-by-amka")
        public @ResponseBody Iterable<Object> takeAppointmentsByAmka (@RequestParam String amka)
         {
          return apointmentRepository.getApointmentByAmka(amka);
        }

        @PostMapping(path="/get-by-doctor")
        public @ResponseBody Iterable<Object> takeAppointmentsByDoctor (@RequestParam String doctor)
         {
          return apointmentRepository.getApointmentByDoctor(doctor);
        }
}
