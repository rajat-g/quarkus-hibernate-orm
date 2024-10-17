package org.acme.hibernate.orm.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.hibernate.orm.panache.entity.Restriction;

@ApplicationScoped
public class RestrictionRepository implements PanacheRepository<Restriction> {
}