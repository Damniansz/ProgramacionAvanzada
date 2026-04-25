package com.saulaaldo.task1u1.service.impl;

import com.saulaaldo.task1u1.service.ServicioPago;
import org.springframework.stereotype.Service;

@Service("servicioStripe")
public class ServicioStripe implements ServicioPago {
    @Override
    public String pagar(){
        return "Pago realizado con Stripe";
    }
}
