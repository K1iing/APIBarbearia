package lf.studio.api.domain.model.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClienteDTO(
        @NotBlank
        String nome,

        LocalDate data,
        @NotNull
        ServicosCliente servicos,
        @NotBlank
        String telefone


) {

}
