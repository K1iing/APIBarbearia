package lf.studio.api.domain.model.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClienteDTO(
        @NotBlank(message = "O nome não pode ser vazio")
        String nome,

        LocalDate data,
        @NotNull(message = "O serviço, não pode ser nulo")
        ServicosCliente servicos,
        @NotBlank(message = "O telefone não pode ser vazio")
        String telefone


) {

}
