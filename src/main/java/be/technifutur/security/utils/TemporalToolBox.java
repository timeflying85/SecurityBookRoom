package be.technifutur.security.utils;

import java.time.LocalTime;

public class TemporalToolBox {

    public record TimePeriod(LocalTime start, LocalTime end){
        public TimePeriod {
            if( !start.isBefore(end) )
                throw new IllegalArgumentException("start should be before end");
        }
    }

    public static boolean checkNoConflict(TimePeriod tp1, TimePeriod tp2){
        return tp1.start.isAfter( tp2.end ) || tp2.start.isAfter( tp1.end );
    }

}
