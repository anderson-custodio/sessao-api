package br.com.sicredi.sessao.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.sicredi.sessao.domain.Sessao;
import br.com.sicredi.sessao.dto.PautaAtivaDTO;
import br.com.sicredi.sessao.dto.SessaoDTO;
import br.com.sicredi.sessao.repository.SessaoRepository;

@Service
public class SessaoService {

  private final SessaoRepository sessaoRepository;

  @Value("${assembleia.api.url}")
  private String assembleiaApiUrl;

  private final RestTemplate restTemplate;

  public SessaoService(SessaoRepository sessaoRepository, RestTemplate restTemplate) {
    this.sessaoRepository = sessaoRepository;
    this.restTemplate = restTemplate;
  }

  public Sessao criarSessao(SessaoDTO sessaoDTO) {
    Sessao sessao = new Sessao();
    sessao.setPautaId(sessaoDTO.getPautaId());
    sessao.setInicio(LocalDateTime.now());
    sessao.setAtiva(true);

    controlarTempoSessao(sessao, sessaoDTO.getTempoEmMinutos());

    return sessaoRepository.save(sessao);
  }

  public Sessao buscarSessaoPorPauta(Long pautaId) {
    return sessaoRepository.findOneByPautaId(pautaId);
  }

  private void controlarTempoSessao(Sessao sessao, Integer tempoSessaoMinutos) {
    new Thread(
            () -> {
              try {
                Thread.sleep(tempoSessaoMinutos * 60 * 1000);

                sessao.setFim(LocalDateTime.now());
                sessao.setAtiva(false);
                sessaoRepository.save(sessao);

                atualizarStatusDaPauta(sessao.getPautaId(), false);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            })
        .start();
  }

  private void atualizarStatusDaPauta(Long id, Boolean ativa) {
    String url = assembleiaApiUrl + "/pautas/" + id;
    restTemplate.patchForObject(url, PautaAtivaDTO.of(ativa), PautaAtivaDTO.class);
  }
}
