package com.sophiafiama.apifilmesdesafio.repository;

import com.sophiafiama.apifilmesdesafio.model.Movie;
import com.sophiafiama.apifilmesdesafio.model.Role;
import com.sophiafiama.apifilmesdesafio.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
