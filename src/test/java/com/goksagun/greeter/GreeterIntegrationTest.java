package com.goksagun.greeter;

import static com.goksagun.greeter.GreeterConfigParams.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.goksagun.greeter.config.GreetingConfig;
import com.goksagun.greeter.service.Greeter;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GreeterIntegrationTest {

    private static GreetingConfig greetingConfig;

    @BeforeAll
    public static void initializeGreetingConfig() {
        greetingConfig = new GreetingConfig();
        greetingConfig.put(USER_NAME, "World");
        greetingConfig.put(MORNING_MESSAGE, "Good Morning");
        greetingConfig.put(AFTERNOON_MESSAGE, "Good Afternoon");
        greetingConfig.put(EVENING_MESSAGE, "Good Evening");
        greetingConfig.put(NIGHT_MESSAGE, "Good Night");
    }

    @Test
    public void givenMorningTime_ifMorningMessage_thenSuccess() {
        String expected = "Hello World, Good Morning";
        Greeter greeter = new Greeter(greetingConfig);
        String actual = greeter.greet(LocalDateTime.of(2022, 3, 1, 6, 0));
        assertEquals(expected, actual);
    }

    @Test
    public void givenAfternoonTime_ifAfternoonMessage_thenSuccess() {
        String expected = "Hello World, Good Afternoon";
        Greeter greeter = new Greeter(greetingConfig);
        String actual = greeter.greet(LocalDateTime.of(2022, 3, 1, 13, 0));
        assertEquals(expected, actual);
    }

    @Test
    public void givenEveningTime_ifEveningMessage_thenSuccess() {
        String expected = "Hello World, Good Evening";
        Greeter greeter = new Greeter(greetingConfig);
        String actual = greeter.greet(LocalDateTime.of(2022, 3, 1, 19, 0));
        assertEquals(expected, actual);
    }

    @Test
    public void givenNightTime_ifNightMessage_thenSuccess() {
        String expected = "Hello World, Good Night";
        Greeter greeter = new Greeter(greetingConfig);
        String actual = greeter.greet(LocalDateTime.of(2022, 3, 1, 21, 0));
        assertEquals(expected, actual);
    }
}
