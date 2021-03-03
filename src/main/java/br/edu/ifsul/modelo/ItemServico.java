/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author eliel
 */
@Entity
@Table(name = "item_servico")
public class ItemServico implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_item_servico", sequenceName = "seq_item_servico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_item_servico", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "A quantidade deve ser informada.")
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    
    @NotNull(message = "O valor deve ser informado.")
    @Column(name = "valor_unitario", nullable = false, columnDefinition = "numeric(10,2)")
    private Double valorUnitario;
   
    @NotNull(message = "O valor total deve ser informado.")
    @Column(name = "valor_total", nullable = false, columnDefinition = "numeric(10,2)")
    private Double valorTotal;
    
    @ManyToOne
    @JoinColumn(name = "servico", referencedColumnName = "id", nullable = false)
    private Servico servico;
    
    @NotNull(message = "A ordem de serviço deve ser informada deve ser informado.")
    @ManyToOne
    @JoinColumn(name = "ordem_servico", referencedColumnName = "id", nullable = false)
    private OrdemServico ordemServico;

    public ItemServico() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.getId());
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
        final ItemServico other = (ItemServico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
