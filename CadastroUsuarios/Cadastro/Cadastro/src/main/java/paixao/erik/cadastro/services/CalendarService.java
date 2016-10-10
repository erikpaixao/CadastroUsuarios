package paixao.erik.cadastro.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paixao.erik.cadastro.entity.CalendarEntity;
import paixao.erik.cadastro.entity.UserEntity;
import paixao.erik.cadastro.repository.UserRepository;
import paixao.erik.cadastro.security.CurrentUser;
import paixao.erik.cadastro.util.GenericService;
import paixao.erik.cadastro.util.ServicePath;


@RestController
@RequestMapping(path = ServicePath.CALENDAR_PATH)
public class CalendarService extends GenericService<CalendarEntity, Long> {

	@Autowired
	private CurrentUser currentUser;

	@Autowired
	private UserRepository userRepository;

	//@Autowired
	//private CalendarRepository calendarRepository;

	@Override
	public CalendarEntity insert(@RequestBody CalendarEntity calendar) {
		calendar.setUser(this.userRepository.findByEmail(currentUser.getActiveUser().getEmail()));
		calendar.setDataRegistro(new Date());

		return super.insert(calendar);
	}

	@Override
	public void update(@RequestBody CalendarEntity calendar) {
		validateUserRequest(calendar);

		calendar.setDataRegistro(new Date());

		try {
			super.update(calendar);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(@RequestBody CalendarEntity calendar) {
		validateUserRequest(calendar);

		super.delete(calendar);
	}

	private UserEntity validateUserRequest(CalendarEntity calendar) {
		UserEntity user = this.userRepository.findByEmail(currentUser.getActiveUser().getEmail());

		if (calendar.getUser().getEmail().compareToIgnoreCase(user.getEmail()) != 0) {
			throw new SecurityException();
		}

		return user;
	}

}
