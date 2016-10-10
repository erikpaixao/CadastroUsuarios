package paixao.erik.cadastro.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import paixao.erik.cadastro.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	public UserEntity findOne(Long id);
	public List<UserEntity> findByNome(String nome);
	public UserEntity findByEmail(String email);
}

