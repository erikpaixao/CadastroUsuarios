package paixao.erik.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import paixao.erik.cadastro.entity.CalendarEntity;
import paixao.erik.cadastro.entity.UserEntity;

public interface CalendarRepository extends JpaRepository<CalendarEntity, Long> {

	public List<CalendarEntity> findByUser(UserEntity user);

}
