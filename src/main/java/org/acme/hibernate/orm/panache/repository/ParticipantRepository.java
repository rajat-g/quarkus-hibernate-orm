package org.acme.hibernate.orm.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.acme.hibernate.orm.panache.entity.Event;
import org.acme.hibernate.orm.panache.entity.Participant;

import java.util.List;

@ApplicationScoped
public class ParticipantRepository implements PanacheRepository<Participant> {

    // Custom method for complex queries using Criteria API
    public List<Participant> getParticipantByEventLocation(String country) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Participant> cq = cb.createQuery(Participant.class);
        Root<Participant> participantRoot = cq.from(Participant.class);

        // Join with Event
        Join<Participant, Event> eventJoin = participantRoot.join("event");

        // Create the predicate for the WHERE clause using JSON extraction
        cq.select(participantRoot).where(
                cb.equal(
                        cb.function("json_extract_path_text", String.class, eventJoin.get("location"), cb.literal("country")),
                        country
                )
        );


        return getEntityManager().createQuery(cq).getResultList();
    }

    @Transactional
    public void saveAll(List<Participant> participants) {
        this.persist(participants);
    }
}
