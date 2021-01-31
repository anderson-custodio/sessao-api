package br.com.sicredi.sessao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sicredi.sessao.domain.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {
  Sessao findOneByPautaId(Long pautaId);
}
