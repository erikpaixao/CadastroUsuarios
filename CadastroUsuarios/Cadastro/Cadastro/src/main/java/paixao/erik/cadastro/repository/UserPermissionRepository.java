package paixao.erik.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import paixao.erik.cadastro.entity.UserPermissionEntity;
import paixao.erik.cadastro.util.UserPermissionKey;

public interface UserPermissionRepository extends JpaRepository<UserPermissionEntity, UserPermissionKey> {

}
