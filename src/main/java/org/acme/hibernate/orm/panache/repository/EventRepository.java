package org.acme.hibernate.orm.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.hibernate.orm.panache.entity.Event;

import java.util.List;

@ApplicationScoped
public class EventRepository implements PanacheRepository<Event> {
    @Transactional
    public void saveAll(List<Event> events) {
        this.persist(events);
    }
    // You can add custom methods here if needed
}
