/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author eliel
 */
@Entity
@Table(name = "ordem_servico")
public class OrdemServico implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_ordem_servico", sequenceName = "seq_ordem_servico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_ordem_servico", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "A descrição não pode ser em branco.")
    @Length(max = 50, message = "A descrição não pode ter mais que {max} caracteres.")
    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informada.")
    @Column(name = "data", nullable = false)
    private Calendar data;
    
    @NotNull(message = "O valor total deve ser informado.")
    @Column(name = "valor_total", nullable = false, columnDefinition = "numeric(10,2)")
    private Double valorTotal;
    
    @NotNull(message = "O pet deve ser informado.")
    @ManyToOne
    @JoinColumn(name = "pet", referencedColumnName = "id", nullable = false)
    private Pet pet;
    
    @NotNull(message = "O funcionário deve ser informado.")
    @ManyToOne
    @JoinColumn(name = "funcionario", referencedColumnName = "id", nullable = false)
    private Funcionario funcionario;
    
    @NotNull(message = "A pessoa deve ser informada.")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;
    
    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ItemServico> itensServico = new ArrayList<>();
    
    public OrdemServico() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<ItemServico> getItensServico() {
        return itensServico;
    }

    public void setItensServico(List<ItemServico> itensServico) {
        this.itensServico = itensServico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrdemServico other = (OrdemServico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
