package paixao.erik.cadastro.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import paixao.erik.cadastro.entity.PermissionEntity;
import paixao.erik.cadastro.entity.UserEntity;
import paixao.erik.cadastro.repository.UserRepository;

@Component
public class UserDetail implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity user = this.userRepository.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("User with email \"" + email + "\" was not found");
		}

		LoginDetailBean login = new LoginDetailBean(user.getNome(), user.getEmail(), user.getSenha());

		for (PermissionEntity permission : user.getPermissions()) {
			login.addRole(permission.getRole());
		}

		return login;
	}

}
