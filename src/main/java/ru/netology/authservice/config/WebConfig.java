package ru.netology.authservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.netology.authservice.UserHandlerMethodArgumentResolverImpl;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private UserHandlerMethodArgumentResolverImpl userHandlerMethodArgumentResolverImpl;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userHandlerMethodArgumentResolverImpl);
    }
}
