package lf.studio.api.domain;

import jakarta.validation.constraints.NotBlank;

public record DadosEnderecoDTO(
        @NotBlank
        String rua,
        @NotBlank
        String cep
) {
}
