package br.com.sicredi.sessao.dto;

public class EncerraSessaoDTO {

  private Long sessaoId;
  private Long pautaId;

  public Long getSessaoId() {
    return sessaoId;
  }

  public void setSessaoId(Long sessaoId) {
    this.sessaoId = sessaoId;
  }

  public Long getPautaId() {
    return pautaId;
  }

  public void setPautaId(Long pautaId) {
    this.pautaId = pautaId;
  }

  public static EncerraSessaoDTO of(Long pautaId, Long sessaoId) {
    EncerraSessaoDTO dto = new EncerraSessaoDTO();
    dto.setPautaId(pautaId);
    dto.setSessaoId(sessaoId);
    return dto;
  }
}
