package me.efraimgentil.jpamappings.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by efra on 17/06/17.
 */
@Entity
public class UserProfile implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  private String surName;

  private String email;

  public UserProfile() {
  }

  public UserProfile(String name, String surName) {
    this.name = name;
    this.surName = surName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurName() {
    return surName;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
