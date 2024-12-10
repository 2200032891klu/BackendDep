package com.klu.Backend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterface extends JpaRepository<User, String> {
  public User findByEmail(String email);
}