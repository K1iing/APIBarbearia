package lf.studio.api.domain.model.donos;


public record DonosListagemDTO(
        Long id,
        String nome,
        String senha,
        Especialidade especialidade


){
    public DonosListagemDTO(DonosEntity donoss) {
        this(donoss.getId(), donoss.getNome(), donoss.getSenha(), donoss.getEspecialidade());
    }
}
