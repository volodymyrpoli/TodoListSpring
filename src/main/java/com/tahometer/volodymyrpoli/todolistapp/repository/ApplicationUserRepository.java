package com.tahometer.volodymyrpoli.todolistapp.repository;

import com.tahometer.volodymyrpoli.todolistapp.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {

}
