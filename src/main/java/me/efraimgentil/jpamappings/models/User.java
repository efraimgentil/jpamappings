package me.efraimgentil.jpamappings.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by efra on 17/06/17.
 */
@Entity
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 20, nullable = false)
  private String username;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_profile_id")
  private UserProfile userProfile;

  public User() {
  }

  public User(String username, UserProfile userProfile) {
    this.username = username;
    this.userProfile = userProfile;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserProfile getUserProfile() {
    return userProfile;
  }

  public void setUserProfile(UserProfile userProfile) {
    this.userProfile = userProfile;
  }
}
