package com.springapp.repositories;

import com.springapp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface RoleRepository extends JpaRepository<Role, Serializable> {

}
