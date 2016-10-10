package paixao.erik.cadastro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paixao.erik.cadastro.entity.UserEntity;
import paixao.erik.cadastro.util.GenericService;
import paixao.erik.cadastro.util.ServicePath;

@RestController
@RequestMapping(path = ServicePath.USER_PATH)
public class UserService extends GenericService<UserEntity, Long> {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserEntity insert(@RequestBody UserEntity user) {
		user.setSenha(this.passwordEncoder.encode(user.getSenha()));

		return super.insert(user);
	}

	@Override
	public void update(@RequestBody UserEntity user) throws Exception {
		user.setSenha(this.passwordEncoder.encode(user.getSenha()));

		super.update(user);
	}

}
