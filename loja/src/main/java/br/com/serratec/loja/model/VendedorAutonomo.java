package br.com.serratec.loja.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("autonomo")
public class VendedorAutonomo extends Vendedor {

    private Double comissao;

    public VendedorAutonomo() {
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

}
