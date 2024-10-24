package lf.studio.api.domain.enderecos;

import jakarta.persistence.Embeddable;


@Embeddable

public class Endereco {

    public Endereco() {
    }


    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    private String rua;
    private String cep;

    public Endereco(DadosEnderecoDTO endereco) {
        this.rua = endereco.rua();
        this.cep = endereco.cep();
    }
}
