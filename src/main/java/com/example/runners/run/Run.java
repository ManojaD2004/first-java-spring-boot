package com.example.runners.run;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.lang.NonNull;


public record Run(
        Integer id,
        @NonNull
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @NonNull
        Integer miles,
        Location location
) {
        public Run {
                if (!completedOn.isAfter(startedOn)) {
                        throw new IllegalArgumentException("Completed On must be after Started On");
                }
        }

        public Duration getDuration() {
                return Duration.between(startedOn, completedOn);
        }

        public Integer getAvgPace() {
                return Math.toIntExact(getDuration().toMinutes() / miles);
        }
}
