package com.example.leaderboard;

public class Project {
    private String firstname;
    private String lastname;
    private String email;
    private String linkToProject;

    public Project(){

    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLinkToProject(String linkToProject) {
        this.linkToProject = linkToProject;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getLinkToProject() {
        return linkToProject;
    }
}
