package lf.studio.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosLogin(
        @NotBlank
        String login,
        @NotBlank
        String password
) {
}
