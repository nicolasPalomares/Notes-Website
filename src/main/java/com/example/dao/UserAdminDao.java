package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.domain.UserAdmin;

public interface UserAdminDao extends JpaRepository<UserAdmin, Long> {
	UserAdmin findByUsername(String username);
}
