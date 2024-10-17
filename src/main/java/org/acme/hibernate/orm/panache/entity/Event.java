package org.acme.hibernate.orm.panache.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.Type;

@Entity(name = "Event")
@Table(name = "event")
public class Event extends BaseEntity {

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
