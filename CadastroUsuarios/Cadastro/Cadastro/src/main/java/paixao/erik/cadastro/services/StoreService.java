package paixao.erik.cadastro.services;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paixao.erik.cadastro.entity.StoreEntity;
import paixao.erik.cadastro.entity.UserEntity;
import paixao.erik.cadastro.repository.UserRepository;
import paixao.erik.cadastro.security.CurrentUser;
import paixao.erik.cadastro.util.GenericService;
import paixao.erik.cadastro.util.ServicePath;


@RestController
@RequestMapping(path = ServicePath.STORE_PATH)
public class StoreService extends GenericService<StoreEntity, Long> {

	@Autowired
	private CurrentUser currentUser;

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public StoreEntity insert(@RequestBody StoreEntity store) {
		store.setUser(this.userRepository.findByEmail(currentUser.getActiveUser().getEmail()));
		store.setDataCadastro(LocalDate.now());

		return super.insert(store);
	}

	@Override
	public void update(@RequestBody StoreEntity store) {
		validateUserRequest(store);

		store.setDataCadastro(LocalDate.now());

		try {
			super.update(store);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(@RequestBody StoreEntity store) {
		validateUserRequest(store);

		super.delete(store);
	}

	private UserEntity validateUserRequest(StoreEntity store) {
		UserEntity user = this.userRepository.findByEmail(currentUser.getActiveUser().getEmail());

		if (store.getUser().getEmail().compareToIgnoreCase(user.getEmail()) != 0) {
			throw new SecurityException();
		}

		return user;
	}

}
