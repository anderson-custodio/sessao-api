package br.com.sicredi.sessao.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.sessao.domain.Sessao;
import br.com.sicredi.sessao.dto.SessaoDTO;
import br.com.sicredi.sessao.service.SessaoService;

@RestController
public class SessaoController {

	private final SessaoService sessaoService;

	public SessaoController(SessaoService sessaoService) {
		this.sessaoService = sessaoService;
	}

	@PostMapping("/sessoes")
	public Sessao criarSessao(@RequestBody SessaoDTO sessaoDTO) {
		return sessaoService.criarSessao(sessaoDTO);
	}
}
