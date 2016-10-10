package paixao.erik.cadastro.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import paixao.erik.cadastro.util.BaseEntity;

@Entity
@Table(name = "tbl_user")
@AttributeOverride(name = "id", column = @Column(name = "cliente_id"))
public class UserEntity extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 60)
	private String nome;
	@Column(nullable = false, length = 14)
	private String telefone;
	@Column(nullable = false, length = 30)
	private String email;
	private Date dataCadastro;
	private String senha;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_user_permission", joinColumns = @JoinColumn(name = "cliente_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
	private List<PermissionEntity> permissions;
	@OneToMany(targetEntity = CalendarEntity.class)
	private List<CalendarEntity> agendamentos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<CalendarEntity> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<CalendarEntity> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@JsonIgnore
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<PermissionEntity> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionEntity> permissions) {
		this.permissions = permissions;
	}

}
