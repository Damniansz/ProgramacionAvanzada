import java.util.List;

public class PrincipalTributos {

    public static void main(String[] args) {

        List<Factura> facturas = List.of(
                new Factura("F001",100),
                new Factura("F002",250),
                new Factura("F003",500),
                new Factura("F004",750),
                new Factura("F005",1000)
        );

        CalculadoraTributo iva =
                (monto,tasa) -> monto * 0.15;

        CalculadoraTributo retencion =
                (monto,tasa) -> monto * 0.02;

        CalculadoraTributo variable =
                (monto,tasa) -> monto * tasa;

        System.out.println("===== IVA 15% =====");

        facturas.forEach(f ->
                System.out.println(
                        f.numero()
                                + " -> "
                                + iva.calcular(
                                f.monto(),
                                0.15
                        )
                )
        );

        System.out.println();

        System.out.println("===== RETENCION 2% =====");

        facturas.forEach(f ->
                System.out.println(
                        f.numero()
                                + " -> "
                                + retencion.calcular(
                                f.monto(),
                                0.02
                        )
                )
        );

        System.out.println();

        System.out.println("===== IMPUESTO VARIABLE 8% =====");

        facturas.forEach(f ->
                System.out.println(
                        f.numero()
                                + " -> "
                                + variable.calcular(
                                f.monto(),
                                0.08
                        )
                )
        );

    }
}