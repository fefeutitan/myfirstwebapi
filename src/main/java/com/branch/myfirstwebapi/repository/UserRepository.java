package com.branch.myfirstwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.branch.myfirstwebapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	void deleteById(Integer id);

	User findById(Integer id);

	User findByNome(String nome);

	User getReferenceById(Integer id);


}
