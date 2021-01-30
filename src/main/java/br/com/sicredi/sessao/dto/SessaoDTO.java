package br.com.sicredi.sessao.dto;

public class SessaoDTO {

	private Long pautaId;
	private Integer tempoEmMinutos = 1;

	public Long getPautaId() {
		return pautaId;
	}

	public void setPautaId(Long pautaId) {
		this.pautaId = pautaId;
	}

	public Integer getTempoEmMinutos() {
		return tempoEmMinutos;
	}

	public void setTempoEmMinutos(Integer tempoEmMinutos) {
		this.tempoEmMinutos = tempoEmMinutos;
	}

}
