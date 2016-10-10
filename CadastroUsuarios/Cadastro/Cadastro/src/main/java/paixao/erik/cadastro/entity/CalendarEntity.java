package paixao.erik.cadastro.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToOne;

import paixao.erik.cadastro.util.BaseEntity;

@Entity
@Table(name = "tbl_agendamento")
@AttributeOverride(name = "id", column = @Column(name = "agendamento_id"))
public class CalendarEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	private String nomeAgendamento;
	private String descAgendamento;
	private LocalDate dataAgendamento;
	private Date dataRegistro;
	private boolean isAgendado;
	@JsonIgnore
	@ManyToOne(targetEntity = StoreEntity.class, fetch=FetchType.LAZY)
	private StoreEntity loja;
	private String statusAgendamento;
	@JsonIgnore
	@ManyToOne(targetEntity = UserEntity.class, fetch=FetchType.LAZY)
	private UserEntity user;
	private String tipoProduto;

	public CalendarEntity(String nomeAgendamento, String descAgendamento, LocalDate dataAgendamento, Date dataRegistro,
			boolean isAgendado, StoreEntity loja, String statusAgendamento, UserEntity user, String tipoProduto) {
		super();
		this.nomeAgendamento = nomeAgendamento;
		this.descAgendamento = descAgendamento;
		this.dataAgendamento = dataAgendamento;
		this.dataRegistro = dataRegistro;
		this.isAgendado = isAgendado;
		this.loja = loja;
		this.statusAgendamento = statusAgendamento;
		this.user = user;
		this.tipoProduto = tipoProduto;
	}

	public CalendarEntity() {
		super();
	}

	public String getNomeAgendamento() {
		return nomeAgendamento;
	}

	public void setNomeAgendamento(String nomeAgendamento) {
		this.nomeAgendamento = nomeAgendamento;
	}

	public String getDescAgendamento() {
		return descAgendamento;
	}

	public void setDescAgendamento(String descAgendamento) {
		this.descAgendamento = descAgendamento;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public boolean isAgendado() {
		return isAgendado;
	}

	public void setAgendado(boolean isAgendado) {
		this.isAgendado = isAgendado;
	}

	public StoreEntity getLoja() {
		return loja;
	}

	public void setLoja(StoreEntity loja) {
		this.loja = loja;
	}

	public String getStatusAgendamento() {
		return statusAgendamento;
	}

	public void setStatusAgendamento(String statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

}
