package com.vitalususPlus.VitalususPlus.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Admin{

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String CodAcesso;

    @OneToOne
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodAcesso() {
        return CodAcesso;
    }

    public void setCodAcesso(String codAcesso) {
        CodAcesso = codAcesso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
