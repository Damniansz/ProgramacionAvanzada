package com.saulaaldo.task1u1.service.impl;

import com.saulaaldo.task1u1.service.ServicioPago;
import org.springframework.stereotype.Service;

@Service("servicioPaypal")
public class ServicioPaypal implements ServicioPago {
    @Override
    public String pagar(){
        return "Pago realizado con PayPal";
    }
}
