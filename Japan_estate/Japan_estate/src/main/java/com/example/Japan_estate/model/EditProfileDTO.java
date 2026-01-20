package com.example.Japan_estate.model;

public class EditProfileDTO {
    private String name;
    private String surname;
    private Integer bDayDay;
    private Integer bDayMonth;
    private Integer bDayYear;
    private String gender;
    private String email;
    private String oldPassword;
    private String newPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getbDayDay() {
        return bDayDay;
    }

    public void setbDayDay(Integer bDayDay) {
        this.bDayDay = bDayDay;
    }

    public Integer getbDayMonth() {
        return bDayMonth;
    }

    public void setbDayMonth(Integer bDayMonth) {
        this.bDayMonth = bDayMonth;
    }

    public Integer getbDayYear() {
        return bDayYear;
    }

    public void setbDayYear(Integer bDayYear) {
        this.bDayYear = bDayYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public EditProfileDTO(){}

    public EditProfileDTO(String name, String surname, String gender){
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }
}
