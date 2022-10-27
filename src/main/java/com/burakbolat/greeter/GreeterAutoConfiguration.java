package com.burakbolat.greeter;

import com.burakbolat.greeter.config.GreetingConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Greeter.class)
@EnableConfigurationProperties(GreeterProperties.class)
public class GreeterAutoConfiguration {

    @Autowired
    private GreeterProperties greeterProperties;

    @Bean
    @ConditionalOnMissingBean
    public GreetingConfig greetingConfig() {
        String userName = greeterProperties.getUserName() == null
            ? System.getProperty(GreeterConfigParams.USER_NAME)
            : greeterProperties.getUserName();
        String morningMessage = greeterProperties.getMorningMessage() == null
            ? System.getProperty(GreeterConfigParams.MORNING_MESSAGE)
            : greeterProperties.getMorningMessage();
        String afternoonMessage = greeterProperties.getAfternoonMessage() == null
            ? System.getProperty(GreeterConfigParams.AFTERNOON_MESSAGE)
            : greeterProperties.getAfternoonMessage();
        String eveningMessage = greeterProperties.getEveningMessage() == null
            ? System.getProperty(GreeterConfigParams.EVENING_MESSAGE)
            : greeterProperties.getEveningMessage();
        String nightMessage = greeterProperties.getNightMessage() == null
            ? System.getProperty(GreeterConfigParams.NIGHT_MESSAGE)
            : greeterProperties.getNightMessage();

        GreetingConfig greetingConfig = new GreetingConfig();
        greetingConfig.put(GreeterConfigParams.USER_NAME, userName);
        greetingConfig.put(GreeterConfigParams.MORNING_MESSAGE, morningMessage);
        greetingConfig.put(GreeterConfigParams.AFTERNOON_MESSAGE, afternoonMessage);
        greetingConfig.put(GreeterConfigParams.EVENING_MESSAGE, eveningMessage);
        greetingConfig.put(GreeterConfigParams.NIGHT_MESSAGE, nightMessage);

        return greetingConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public Greeter greeter(GreetingConfig greetingConfig) {
        return new Greeter(greetingConfig);
    }
}
