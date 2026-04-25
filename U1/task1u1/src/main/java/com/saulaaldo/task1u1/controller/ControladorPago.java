package com.saulaaldo.task1u1.controller;

import com.saulaaldo.task1u1.exception.RecursoNoEncontradoException;
import com.saulaaldo.task1u1.service.ServicioPago;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pago")
public class ControladorPago {
    private final ServicioPago servicioPaypal;
    private final ServicioPago servicioStripe;

    public ControladorPago(
            @Qualifier("servicioPaypal")ServicioPago servicioPaypal,
            @Qualifier("servicioStripe")ServicioPago servicioStripe){
        this.servicioPaypal = servicioPaypal;
        this.servicioStripe = servicioStripe;
    }

    @GetMapping
    public String pagar(@RequestParam(defaultValue = "paypal")String tipo){
        if (tipo.equalsIgnoreCase("stripe")){
            return servicioStripe.pagar();
        }
        return servicioPaypal.pagar();
    }

    @GetMapping("/error")
    public String generarError(){
        throw new RecursoNoEncontradoException("Recurso no encontrado");
    }

    @GetMapping("/error500")
    public String error500() throws Exception {
        throw new Exception("Error grave");
    }
}
