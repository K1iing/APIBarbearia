package lf.studio.api.domain.model.cliente;

import jakarta.validation.constraints.NotNull;

public record ClienteAtualizarDTO(
        @NotNull
        Long id,
        String nome,
        ServicosCliente servicos,
        String telefone
) {
}
