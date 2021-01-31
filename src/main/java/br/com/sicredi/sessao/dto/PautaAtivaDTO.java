package br.com.sicredi.sessao.dto;

public class PautaAtivaDTO {
  private Boolean ativa;

  public Boolean getAtiva() {
    return ativa;
  }

  public void setAtiva(Boolean ativa) {
    this.ativa = ativa;
  }

  public static PautaAtivaDTO of(Boolean ativa) {
    PautaAtivaDTO dto = new PautaAtivaDTO();
    dto.setAtiva(ativa);
    return dto;
  }
}
