package ru.netology.authservice;

import org.springframework.context.annotation.Bean;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.netology.authservice.annotation.UserConvertion;
import ru.netology.authservice.domain.User;

//https://codeboje.de/spring-mvc-argument-mapping-basics/
//https://www.programmersought.com/article/28945902381/

@Component
public class UserHandlerMethodArgumentResolverImpl implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameter().getType().equals(String.class)
                && parameter.hasParameterAnnotation(UserConvertion.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String user = webRequest.getParameter("user");
        String password = webRequest.getParameter("password");
        return new User(user, password);
    }
}
