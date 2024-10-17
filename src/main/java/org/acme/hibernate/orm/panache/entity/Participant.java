package org.acme.hibernate.orm.panache.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.Type;

@Entity(name = "Participant")
@Table(name = "participant")
public class Participant extends BaseEntity {

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private Ticket ticket;

    @ManyToOne
    private Event event;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
