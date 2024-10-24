package lf.studio.api.domain.model.donos;

import jakarta.persistence.*;
import lf.studio.api.domain.Endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "Donos")
@Entity(name = "Dono")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DonosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String senha;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Embedded
    private Endereco endereco;

    private String lote;

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public long getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }



    public Endereco getEndereco() {
        return endereco;
    }

    public String getLote() {
        return lote;
    }

    public DonosEntity(DonosDTO donos) {
        this.nome = donos.nome();
        this.senha = donos.senha();
        this.lote = donos.lote();
        this.especialidade = donos.especialidade();
        this.endereco = new Endereco(donos.endereco());


    }
}
