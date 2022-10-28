package com.burakbolat.greeter.service;

import com.burakbolat.greeter.GreeterConfigParams;
import com.burakbolat.greeter.config.GreetingConfig;
import java.time.LocalDateTime;

public class Greeter {

    private GreetingConfig greetingConfig;

    public Greeter(GreetingConfig greetingConfig) {
        this.greetingConfig = greetingConfig;
    }

    public String greet(LocalDateTime localDateTime) {
        String name = greetingConfig.getProperty(GreeterConfigParams.USER_NAME);
        int hourOfDay = localDateTime.getHour();

        if (hourOfDay >= 5 && hourOfDay < 12) {
            return String.format("Hello %s, %s", name, greetingConfig.get(
                GreeterConfigParams.MORNING_MESSAGE));
        } else if (hourOfDay >= 12 && hourOfDay < 17) {
            return String.format("Hello %s, %s", name, greetingConfig.get(
                GreeterConfigParams.AFTERNOON_MESSAGE));
        } else if (hourOfDay >= 17 && hourOfDay < 20) {
            return String.format("Hello %s, %s", name, greetingConfig.get(
                GreeterConfigParams.EVENING_MESSAGE));
        } else {
            return String.format("Hello %s, %s", name, greetingConfig.get(
                GreeterConfigParams.NIGHT_MESSAGE));
        }
    }
}
