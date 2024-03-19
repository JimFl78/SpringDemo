package com.jnholfert.jhdemo.model;

import java.util.Date;




public class Student {

//  enum Gender {
//  male, female, transgender, genderneutral, nonbinary, agender, pangender, genderqueer, twospirit, thirdgender
//  }
  private long id = 0;

  private String firstname;
  private String surname;

  //had some issues with parsing date formats so left this out for now - would have liked to get this in but wanted it to be a stable release
  private String dateofbirth;

  private String sex;
  private String gender;

  //would build in a formating function to parse valid phone number formats if had time
  private String phonenumber;


  public Student(String firstname, String surname, String dob, String sex, String gender, String phoneno) {
    this.firstname = firstname;
    this.surname = surname;
    this.dateofbirth = dob;
    this.sex = sex;
    this.gender = gender;
    this.phonenumber =  phoneno;
  }

  public void setId(long id) {
    this.id = id;
  }
  
  public long getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getDateOfBirth() {
    return dateofbirth;
  }

  public void setDateOfBirth(String dob) {
    this.dateofbirth = dob;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }


}
