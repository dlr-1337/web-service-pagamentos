package com.otavio.webservices.controller;

import com.otavio.webservices.dados.BancoDeDados;
import com.otavio.webservices.dominio.Pagamento;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @GetMapping
    public List<Pagamento> listarPagamentos() {
        return BancoDeDados.listarTodos();
    }

    @GetMapping("/hoje")
    public List<Pagamento> pagamentosDeHoje() {
        return BancoDeDados.vencendoHoje();
    }

    @GetMapping("/{id}")
    public Pagamento buscarPorCodigo(@PathVariable Integer id) {
        Pagamento pagamento = BancoDeDados.buscarPorCodigo(id);
        if (pagamento == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento nao encontrado");
        }
        return pagamento;
    }
}
