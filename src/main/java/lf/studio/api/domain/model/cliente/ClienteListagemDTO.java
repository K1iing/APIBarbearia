package lf.studio.api.domain.model.cliente;

import java.time.LocalDate;

public record ClienteListagemDTO(
        Long id,
        String nome,
        LocalDate data,
        ServicosCliente servico,
        String telefone


) {
    public ClienteListagemDTO(ClienteEntity dados) {
        this(dados.getId(),
                dados.getNome(),
                dados.getData(),
                dados.getServicos(),
                dados.getTelefone());
    }


}
