package br.com.sicredi.sessao.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.com.sicredi.sessao.domain.Sessao;
import br.com.sicredi.sessao.dto.SessaoDTO;
import br.com.sicredi.sessao.repository.SessaoRepository;

@Service
public class SessaoService {

	private final SessaoRepository sessaoRepository;

	public SessaoService(SessaoRepository sessaoRepository) {
		this.sessaoRepository = sessaoRepository;
	}

	public Sessao criarSessao(SessaoDTO sessaoDTO) {
		Sessao sessao = new Sessao();
		sessao.setPautaId(sessaoDTO.getPautaId());
		sessao.setInicio(LocalDateTime.now());
		sessao.setAtiva(true);

		controlarTempoSessao(sessao, sessaoDTO.getTempoEmMinutos());

		return sessaoRepository.save(sessao);
	}

	private void controlarTempoSessao(Sessao sessao, Integer tempoSessaoMinutos) {
		new Thread(() -> {
			try {
				Thread.sleep(tempoSessaoMinutos * 60 * 1000);

				sessao.setFim(LocalDateTime.now());
				sessao.setAtiva(false);
				sessaoRepository.save(sessao);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}
