package br.com.sicredi.sessao.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Sessao {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private Long pauta_id;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fim;

	@Column(nullable = false)
	private Boolean ativa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPauta_id() {
		return pauta_id;
	}

	public void setPauta_id(Long pauta_id) {
		this.pauta_id = pauta_id;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
	}

}
