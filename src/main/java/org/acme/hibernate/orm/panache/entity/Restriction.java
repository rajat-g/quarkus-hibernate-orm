package org.acme.hibernate.orm.panache.entity;

import io.hypersistence.utils.hibernate.type.range.PostgreSQLRangeType;
import io.hypersistence.utils.hibernate.type.range.Range;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity(name = "AgeRestriction")
@Table(name = "age_restriction")
public class Restriction {

    @Id
    @GeneratedValue
    private Long id;

    @Type(PostgreSQLRangeType.class)
    @Column(name = "r_int", columnDefinition = "int4Range")
    private Range<Integer> rangeInt;

    @Type(PostgreSQLRangeType.class)
    @Column(name = "r_int_empty", columnDefinition = "int4Range")
    private Range<Integer> rangeIntEmpty;

    @Type(PostgreSQLRangeType.class)
    @Column(name = "r_int_infinity", columnDefinition = "int4Range")
    private Range<Integer> rangeIntInfinity;

    @Type(PostgreSQLRangeType.class)
    @Column(name = "r_long", columnDefinition = "int8range")
    private Range<Long> rangeLong;

    @Type(PostgreSQLRangeType.class)
    @Column(name = "r_numeric", columnDefinition = "numrange")
    private Range<BigDecimal> rangeBigDecimal;

    @Type(PostgreSQLRangeType.class)
    @Column(name = "r_ts", columnDefinition = "tsrange")
    private Range<LocalDateTime> rangeLocalDateTime;

    @Type(PostgreSQLRangeType.class)
    @Column(name = "r_ts_tz", columnDefinition = "tstzrange")
    private Range<ZonedDateTime> rangeZonedDateTime;

    @Type(PostgreSQLRangeType.class)
    @Column(name = "r_ts_tz_infinity", columnDefinition = "tstzrange")
    private Range<ZonedDateTime> rangeZonedDateTimeInfinity;

    @Type(PostgreSQLRangeType.class)
    @Column(name = "r_ts_tz_empty", columnDefinition = "tstzrange")
    private Range<ZonedDateTime> rangeZonedDateTimeEmpty;

    @Type(PostgreSQLRangeType.class)
    @Column(name = "r_date", columnDefinition = "daterange")
    private Range<LocalDate> rangeLocalDate;

    public Long getId() {
        return id;
    }

    public Range<Integer> getRangeInt() {
        return rangeInt;
    }

    public void setRangeInt(Range<Integer> rangeInt) {
        this.rangeInt = rangeInt;
    }

    public Range<Integer> getRangeIntEmpty() {
        return rangeIntEmpty;
    }

    public void setRangeIntEmpty(Range<Integer> rangeIntEmpty) {
        this.rangeIntEmpty = rangeIntEmpty;
    }

    public Range<Integer> getRangeIntInfinity() {
        return rangeIntInfinity;
    }

    public void setRangeIntInfinity(Range<Integer> rangeIntInfinity) {
        this.rangeIntInfinity = rangeIntInfinity;
    }

    public Range<Long> getRangeLong() {
        return rangeLong;
    }

    public void setRangeLong(Range<Long> rangeLong) {
        this.rangeLong = rangeLong;
    }

    public Range<BigDecimal> getRangeBigDecimal() {
        return rangeBigDecimal;
    }

    public void setRangeBigDecimal(Range<BigDecimal> rangeBigDecimal) {
        this.rangeBigDecimal = rangeBigDecimal;
    }

    public Range<LocalDateTime> getLocalDateTimeRange() {
        return rangeLocalDateTime;
    }

    public void setRangeLocalDateTime(Range<LocalDateTime> rangeLocalDateTime) {
        this.rangeLocalDateTime = rangeLocalDateTime;
    }

    public Range<ZonedDateTime> getRangeZonedDateTime() {
        return rangeZonedDateTime;
    }

    public void setRangeZonedDateTime(Range<ZonedDateTime> rangeZonedDateTime) {
        this.rangeZonedDateTime = rangeZonedDateTime;
    }

    public Range<ZonedDateTime> getRangeZonedDateTimeInfinity() {
        return rangeZonedDateTimeInfinity;
    }

    public Range<ZonedDateTime> getRangeZonedDateTimeEmpty() {
        return rangeZonedDateTimeEmpty;
    }

    public void setRangeZonedDateTimeEmpty(Range<ZonedDateTime> rangeZonedDateTimeEmpty) {
        this.rangeZonedDateTimeEmpty = rangeZonedDateTimeEmpty;
    }

    public void setRangeZonedDateTimeInfinity(Range<ZonedDateTime> rangeZonedDateTimeInfinity) {
        this.rangeZonedDateTimeInfinity = rangeZonedDateTimeInfinity;
    }

    public Range<LocalDate> getRangeLocalDate() {
        return rangeLocalDate;
    }

    public void setRangeLocalDate(Range<LocalDate> rangeLocalDate) {
        this.rangeLocalDate = rangeLocalDate;
    }
}
