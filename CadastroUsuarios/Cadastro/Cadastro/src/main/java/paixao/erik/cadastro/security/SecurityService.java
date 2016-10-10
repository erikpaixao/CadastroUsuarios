package paixao.erik.cadastro.security;


import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import paixao.erik.cadastro.util.ServiceMap;
import paixao.erik.cadastro.util.ServicePath;;

@RestController
@RequestMapping(ServicePath.LOGIN_PATH)
public class SecurityService implements ServiceMap {

	@RequestMapping(method = { RequestMethod.GET })
	public Principal user(Principal user) {
		return user;
	}

}
