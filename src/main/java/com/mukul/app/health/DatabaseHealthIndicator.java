package com.mukul.app.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DatabaseHealthIndicator implements HealthIndicator {


    @Override
    public Health health() {
        // Example: check DB connection
        boolean dbUp = true; // replace with actual check
        if (dbUp) {
            return Health.up().withDetail("Database", "Available").build();
        } else {
            return Health.down().withDetail("Database", "Not reachable").build();
        }
    }
}
