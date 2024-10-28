package lf.studio.api.domain.model.donos;


public record DonosListagemDTO(
        Long id,

        Especialidade especialidade


){
    public DonosListagemDTO(DonosEntity donoss) {
        this(donoss.getId(), donoss.getEspecialidade());
    }
}
