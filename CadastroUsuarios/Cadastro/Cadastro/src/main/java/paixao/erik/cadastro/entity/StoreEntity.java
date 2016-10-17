package paixao.erik.cadastro.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import paixao.erik.cadastro.util.BaseEntity;

@Entity
@Table(name = "tbl_loja")
@AttributeOverride(name = "id", column = @Column(name = "loja_id"))
public class StoreEntity extends BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeLoja;
	private String enderecoLoja;
	private String telefoneLoja;
	@OneToOne
	private UserEntity user;
	@OneToMany(targetEntity = CalendarEntity.class)
	private List<CalendarEntity> agendamentos;
	private LocalDate dataCadastro;

	public StoreEntity(String nomeLoja, String enderecoLoja, String telefoneLoja, UserEntity responsavelLoja,
			List<CalendarEntity> agendamentos, LocalDate dataCadastro) {
		super();
		this.nomeLoja = nomeLoja;
		this.enderecoLoja = enderecoLoja;
		this.telefoneLoja = telefoneLoja;
		this.user = responsavelLoja;
		this.agendamentos = agendamentos;
		this.dataCadastro = dataCadastro;
	}

	public StoreEntity() {
		super();
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getEnderecoLoja() {
		return enderecoLoja;
	}

	public String getTelefoneLoja() {
		return telefoneLoja;
	}

	public void setTelefoneLoja(String telefoneLoja) {
		this.telefoneLoja = telefoneLoja;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity responsavelLoja) {
		this.user = responsavelLoja;
	}

	public List<CalendarEntity> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<CalendarEntity> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public void setEnderecoLoja(String enderecoLoja) {
		this.enderecoLoja = enderecoLoja;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate date) {
		this.dataCadastro = date;
	}

}
