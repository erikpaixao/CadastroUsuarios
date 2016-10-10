package paixao.erik.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import paixao.erik.cadastro.entity.StoreEntity;
import paixao.erik.cadastro.entity.UserEntity;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

	public List<StoreEntity> findByUser(UserEntity user);

}
