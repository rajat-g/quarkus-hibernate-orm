package org.acme.hibernate.orm.panache.controller;


import io.hypersistence.utils.hibernate.type.range.Range;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.acme.hibernate.orm.panache.entity.Location;
import org.acme.hibernate.orm.panache.entity.Restriction;
import org.acme.hibernate.orm.panache.entity.Ticket;
import org.acme.hibernate.orm.panache.entity.Event;
import org.acme.hibernate.orm.panache.entity.Participant;
import org.acme.hibernate.orm.panache.repository.EventRepository;
import org.acme.hibernate.orm.panache.repository.ParticipantRepository;
import org.acme.hibernate.orm.panache.repository.RestrictionRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static io.hypersistence.utils.hibernate.type.range.Range.infinite;
import static io.hypersistence.utils.hibernate.type.range.Range.zonedDateTimeRange;

@Path("/api")
public class EventController {

    @Inject
    EventRepository eventRepository;

    @Inject
    ParticipantRepository participantRepository;

    @Inject
    RestrictionRepository restrictionRepository;

    @POST
    @Path("/participant")
    public void create() {
        long j = 1;
        List<Event> events = new ArrayList<>();
        List<Participant> participants = new ArrayList<>();
        for (int i = 0; i <= 100000; i++) {
            Location location = new Location();
            location.setCountry("country"+i);
            location.setCity("city"+i);

            Event event = new Event();
            event.setId(j);
            event.setLocation(location);
            events.add(event);

            Ticket ticket = new Ticket();
            ticket.setPrice(123);
            ticket.setRegistrationCode("reg"+i);

            Participant participant = new Participant();
            participant.setId(j);
            participant.setTicket(ticket);
            participant.setEvent(event);
            participants.add(participant);
            j++;
        }
        eventRepository.saveAll(events);
        participantRepository.saveAll(participants);
    }

    @GET
    @Path("/participant")
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll().stream().toList();
    }

    @GET
    @Path("/participant-by-event-country")
    public List<Participant> getParticipantByEventLocation(@QueryParam("country") String country) {
        return participantRepository.getParticipantByEventLocation(country);
//		return participantRepository.getParticipantByEventLocation(country);
    }

    @GET
    @Path("/restrictions")
    @Transactional
    public void persistRestrictions() {
        Restriction restriction = new Restriction();
        Range<BigDecimal> numeric = Range.bigDecimalRange("[0.5,0.89]");

        Range<Long> int8Range = Range.longRange("[0,18)");

        Range<Integer> int4Range = infinite(Integer.class);

        Range<Integer> int4RangeEmpty = Range.integerRange("[123,123)");

        Range<Integer> int4RangeInfinity = Range.integerRange("[123,infinity)");

        Range<LocalDateTime> localDateTimeRange = Range.localDateTimeRange("[2014-04-28 16:00:49,2015-04-28 16:00:49]");

        Range<ZonedDateTime> tsTz = zonedDateTimeRange("[\"2007-12-03T10:15:30+01:00\",\"2008-12-03T10:15:30+01:00\"]");

        Range<ZonedDateTime> tsTzEmpty = zonedDateTimeRange("empty");

        Range<ZonedDateTime> infinityTsTz = zonedDateTimeRange("[\"2007-12-03T10:15:30+01:00\",infinity)");

        Range<LocalDate> dateRange = Range.localDateRange("[1992-01-13,1995-01-13)");
        restriction.setRangeInt(int4Range);
        restriction.setRangeIntEmpty(int4RangeEmpty);
        restriction.setRangeIntInfinity(int4RangeInfinity);
        restriction.setRangeLong(int8Range);
        restriction.setRangeBigDecimal(numeric);
        restriction.setRangeLocalDateTime(localDateTimeRange);
        restriction.setRangeZonedDateTime(tsTz);
        restriction.setRangeZonedDateTimeInfinity(infinityTsTz);
        restriction.setRangeZonedDateTimeEmpty(tsTzEmpty);
        restriction.setRangeLocalDate(dateRange);
        restrictionRepository.persist(restriction);
    }

}
