package com.example.demo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Apointment {
    @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String date;

  private String examination;

  private String comment;

  private String doctor;

  private String amka;

  

  



  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getExamination() {
    return examination;
  }

  public void setExamination(String examination) {
    this.examination = examination;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getDoctor() {
    return doctor;
  }

  public void setDoctor(String doctor) {
    this.doctor = doctor;
  }
    
  public String getAmka() {
    return amka;
  }

  public void setAmka(String amka) {
    this.amka = amka;
  }
}
