package lf.studio.api.domain.model.cliente;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Clientes")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;


    @Column(name = "data_cadastro")
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private ServicosCliente servicos;  // Lista de serviços

    private String telefone;
    private Boolean ativo = true;


    public ClienteEntity(ClienteDTO clienteDados) {
        this.nome = clienteDados.nome();
        this.data = clienteDados.data() != null ? clienteDados.data() : LocalDate.now();
        this.servicos = clienteDados.servicos();
        this.telefone = clienteDados.telefone();
        this.ativo = true;
    }

    public ClienteEntity() {
    }

    public  void atualizarDados(ClienteAtualizarDTO dadoss) {
        if (dadoss.nome() != null) {
            this.nome = dadoss.nome();
        }
        if (dadoss.servicos() != null) {
            this.servicos = dadoss.servicos();
        }
        if (dadoss.telefone() != null) {
            this.telefone = dadoss.telefone();
        }
    }

        // Getters e Setters
        public Long getId () {
            return id;
        }

        public void setId (Long id){
            this.id = id;
        }

        public String getNome () {
            return nome;
        }

        public void setNome (String nome){
            this.nome = nome;
        }

        public LocalDate getData () {
            return data;
        }

        public void setData (LocalDate data){
            this.data = data;
        }

        public ServicosCliente getServicos () {
            return servicos;
        }

        public void setServicos (ServicosCliente servicos){
            this.servicos = servicos;
        }

        public String getTelefone () {
            return telefone;
        }

        public void setTelefone (String telefone){
            this.telefone = telefone;
        }
    public void inativar() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }


    public ClienteListagemDTO listar() {
        return new ClienteListagemDTO(this.id, this.nome, this.data, this.servicos, this.telefone);
    }
}
