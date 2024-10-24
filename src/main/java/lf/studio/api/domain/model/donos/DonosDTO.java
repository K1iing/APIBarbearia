package lf.studio.api.domain.model.donos;



import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lf.studio.api.domain.DadosEnderecoDTO;

public record DonosDTO(


        @NotBlank
        String nome,
        @NotBlank
        String senha,
        @NotBlank
        String lote,
        @NotNull
        Especialidade especialidade,
        @NotNull @Valid
        DadosEnderecoDTO endereco


){

}



