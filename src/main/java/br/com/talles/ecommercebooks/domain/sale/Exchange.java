package br.com.talles.ecommercebooks.domain.sale;

import br.com.talles.ecommercebooks.domain.Entity;

public class Exchange extends Entity {

    private Boolean accepted;
    private String justification;
    private Order order;

    public Exchange() {
        super(true);
    }

    public Exchange(boolean accepted) {
        this.accepted = accepted;
    }

    public Exchange(String justification) {
        super(true);
        this.justification = justification;
        this.accepted = false;
    }

    public Exchange(boolean accepted, String justification) {
        this.accepted = accepted;
        this.justification = justification;
    }

    public Exchange(long id, boolean accepted, String justification, Order order) {
        super(id, true);
        this.justification = justification;
        this.accepted = accepted;
        this.order = order;
    }

    // Getters
    public Boolean isAccepted() {
        return accepted;
    }

    public String getJustification() {
        return justification;
    }

    public Order getOrder() {
        return order;
    }

    // Setters
    public void setJustification(String justification) {
        this.justification = justification;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
