package br.com.fiap.domain.equipamento.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "TP_EQUIPAMENTO")
public class TipoEquipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TP_EQUIPAMENTO")
    @SequenceGenerator(name = "SQ_TP_EQUIPAMENTO", sequenceName = "SQ_TP_EQUIPAMENTO")
    @Column(name = "id_tp_equipamento")
    private Long id;

    @Column(name = "NM_TP_EQUIPAMENTO")
    private String nome;

    public TipoEquipamento(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TipoEquipamento() {
    }

    public Long getId() {
        return id;
    }

    public TipoEquipamento setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoEquipamento setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoEquipamento)) return false;
        TipoEquipamento that = (TipoEquipamento) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNome(), that.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TipoEquipamento{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
