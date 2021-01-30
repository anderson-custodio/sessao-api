package br.com.sicredi.sessao.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.sicredi.sessao.domain.Sessao;
import br.com.sicredi.sessao.dto.SessaoDTO;
import br.com.sicredi.sessao.repository.SessaoRepository;

@ExtendWith(MockitoExtension.class)
public class SessaoServiceTest {

	@InjectMocks
	private SessaoService sessaoService;

	@Mock
	private SessaoRepository sessaoRepository;

	@BeforeEach
	void init() {
		Mockito.lenient().when(sessaoRepository.save(any(Sessao.class))).then(AdditionalAnswers.returnsFirstArg());
	}

	@Test
	public void testNotNull() {
		Assertions.assertNotNull(sessaoService);
	}

	@Test
	public void testCriarSessao() {
		SessaoDTO sessaoDTO = new SessaoDTO();
		sessaoDTO.setPautaId(-1L);
		sessaoDTO.setTempoEmMinutos(5);

		Sessao sessao = sessaoService.criarSessao(sessaoDTO);

		Assertions.assertNotNull(sessao);
		verify(sessaoRepository, times(1)).save(any(Sessao.class));
	}

}
