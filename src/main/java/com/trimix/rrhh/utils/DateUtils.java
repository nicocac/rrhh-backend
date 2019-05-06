package com.trimix.rrhh.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateUtils {

    public static java.sql.Date convertUtilToSql(java.util.Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.of ( "America/Buenos_Aires" );
        ZonedDateTime zdt = ZonedDateTime.ofInstant ( instant , zoneId );
        LocalDate localDate = zdt.toLocalDate();
        return java.sql.Date.valueOf( localDate );
    }
}
