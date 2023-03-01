package br.com.fiap.domain.equipamento.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EQUIPAMENTO")
    @SequenceGenerator(name = "SQ_EQUIPAMENTO",
    sequenceName = "SQ_EQUIPAMENTO",
    allocationSize = 20,
    initialValue = 1
    )
    @Column(name = "id_equipamento")
    private Long id;

    @Column(name = "NM_EQUIPAMENTO")
    private String nome;

    @Column(name = "NR_SERIE_EQUIPAMENTO")
    private String numeroDeSerie;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_tp_equipamento",

    referencedColumnName = "id_tp_equipamento",
            foreignKey = @ForeignKey(name = "fk_tb_tp_equipamento",
            value = ConstraintMode.CONSTRAINT
            )
    )
    private TipoEquipamento tipo;



    public Equipamento() {
    }

    public Equipamento(Long id, String nome, String numeroDeSerie) {
        this.id = id;
        this.nome = nome;
        this.numeroDeSerie = numeroDeSerie;
    }

    public Long getId() {
        return id;
    }

    public Equipamento setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Equipamento setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public Equipamento setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipamento)) return false;
        Equipamento that = (Equipamento) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getNumeroDeSerie(), that.getNumeroDeSerie());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getNumeroDeSerie());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Equipamento{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", numeroDeSerie='").append(numeroDeSerie).append('\'');
        sb.append('}');
        return sb.toString();
    }
}




