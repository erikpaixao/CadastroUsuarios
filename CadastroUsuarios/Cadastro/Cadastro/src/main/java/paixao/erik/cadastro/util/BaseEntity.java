package paixao.erik.cadastro.util;

import java.io.Serializable;

import org.springframework.data.jpa.domain.AbstractPersistable;


public abstract class BaseEntity<ID extends Serializable> extends AbstractPersistable<ID> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
