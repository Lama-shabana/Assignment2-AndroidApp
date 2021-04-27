package com.example.assignment2.Modols;

public class CV {
     String fullName;
    private String email;
    private String address;
    private String dateOfBirth;
    private String age;
    private String phone;
    private String gender;
    private String hobbies;
    private String educationLevel;
    private String experienceWork;

    public CV(){}
    public CV(String fullName, String email, String address, String dateOfBirth,String age, String phone, String gender, String hobbies,
              String educationLevel ,String experienceWork){
        this.fullName = fullName;
         this.age=age;
      this.email=email;
      this.dateOfBirth=dateOfBirth;
      this.gender=gender;
      this.phone=phone;
      this.hobbies=hobbies;
      this.experienceWork=experienceWork;
      this.educationLevel=educationLevel;
      this.address=address;


    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String  dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getExperienceWork() {
        return experienceWork;
    }

    public void setExperienceWork(String experienceWork) {
        this.experienceWork = experienceWork;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
}

