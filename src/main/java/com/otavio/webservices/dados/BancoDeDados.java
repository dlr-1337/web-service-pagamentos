package com.otavio.webservices.dados;

import com.otavio.webservices.dominio.Pagamento;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BancoDeDados {

    private static final List<Pagamento> PAGAMENTOS = new ArrayList<>();

    static {
        LocalDate hoje = LocalDate.now();
        PAGAMENTOS.add(new Pagamento(1, "Energia eletrica", 230.50, hoje, Boolean.FALSE));
        PAGAMENTOS.add(new Pagamento(2, "Agua", 120.10, hoje.plusDays(1), Boolean.FALSE));
        PAGAMENTOS.add(new Pagamento(3, "Internet", 99.90, hoje.minusDays(1), Boolean.TRUE));
        PAGAMENTOS.add(new Pagamento(4, "Cartao de credito", 1570.00, hoje, Boolean.FALSE));
        PAGAMENTOS.add(new Pagamento(5, "Aluguel", 2200.00, hoje.plusDays(5), Boolean.FALSE));
    }

    private BancoDeDados() {
    }

    public static List<Pagamento> listarTodos() {
        return Collections.unmodifiableList(PAGAMENTOS);
    }

    public static Pagamento buscarPorCodigo(Integer codigo) {
        return PAGAMENTOS.stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public static List<Pagamento> vencendoHoje() {
        LocalDate hoje = LocalDate.now();
        return PAGAMENTOS.stream()
                .filter(p -> hoje.equals(p.getDataVencimento()))
                .toList();
    }
}
