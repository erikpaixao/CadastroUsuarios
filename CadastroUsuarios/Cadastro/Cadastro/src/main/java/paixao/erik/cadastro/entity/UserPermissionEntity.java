package paixao.erik.cadastro.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import paixao.erik.cadastro.util.BaseEntity;
import paixao.erik.cadastro.util.UserPermissionKey;

@Entity
@Table(name = "tb_user_permission")
public class UserPermissionEntity extends BaseEntity<UserPermissionKey> {

	private static final long serialVersionUID = 201602010251L;

}