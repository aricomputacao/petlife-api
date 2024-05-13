package com.petlife.api.autenticacao;

import com.petlife.dominio.autenticacao.dto.DadosParaAutenticacao;
import com.petlife.dominio.autenticacao.entity.Usuario;
import com.petlife.infra.security.DadosTokenJWT;
import com.petlife.infra.security.TokenService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AutenticacaoController {

    //classe q dispara o processo de autenticação
    private final AuthenticationManager manager;
    private final TokenService tokenService;

    @PostMapping
    public  ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosParaAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT("Bearer", tokenJWT));
    }
}
