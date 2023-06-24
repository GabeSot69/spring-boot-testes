package tads.aranoua.testes.springboottestes.model;

import javax.persistence.*;

@Entity
public class Voluntario {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String passaporte;
    private String nomeCompleto;
    private int idade;
    private String telefone;
    @Column(nullable = false, unique = true)
    private String email;
    private String tipoSanguineo;
    private Cidade cidade;
    private SituacaoDeSaude situacaoDeSaude;

    public int
    public Long getId() {
        return id;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public SituacaoDeSaude getSituacaoDeSaude() {
        return situacaoDeSaude;
    }

    public void setSituacaoDeSaude(SituacaoDeSaude situacaoDeSaude) {
        this.situacaoDeSaude = situacaoDeSaude;
    }



    @Override
    public String toString() {
        return "Voluntario{" +
                "id=" + id +
                ", passaporte='" + passaporte + '\'' +
                ", nome='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
