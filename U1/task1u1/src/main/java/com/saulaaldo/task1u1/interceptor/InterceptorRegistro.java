package com.saulaaldo.task1u1.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class InterceptorRegistro implements HandlerInterceptor {
    @Override
    public boolean preHandle (HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler){
        long tiempoInicio = System.currentTimeMillis();
        request.setAttribute("tiempoInicio", tiempoInicio);

        System.out.println("Antes del controlador: " + request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView){
        System.out.println("Despues del controlador");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex){
        long tiempoInicio = (long) request.getAttribute("tiempoInicio");
        long tiempoFinal = System.currentTimeMillis();
        long duracion = tiempoFinal - tiempoInicio;
        System.out.println("Peticion Completada");
        System.out.println("Tiempo de respuesta: " + duracion + "ms");
    }
}
