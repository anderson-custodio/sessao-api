package br.com.sicredi.sessao.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
  @Bean
  public RestTemplate restTemplate() {
    HttpClient client = HttpClients.createDefault();
    return new RestTemplate(new HttpComponentsClientHttpRequestFactory(client));
  }
}
