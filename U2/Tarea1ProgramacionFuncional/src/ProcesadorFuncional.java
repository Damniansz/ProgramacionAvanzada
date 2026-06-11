import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProcesadorFuncional {

    public List<String> procesar(
            List<Producto> productos,
            Predicate<Producto> filtro,
            Function<Producto,String> transformador) {

        List<String> resultado = new ArrayList<>();

        for (Producto producto : productos) {

            if (filtro.test(producto)) {

                resultado.add(
                        transformador.apply(producto)
                );

            }

        }

        return resultado;
    }

    public static void main(String[] args) {

        ProcesadorFuncional proc =
                new ProcesadorFuncional();

        List<Producto> lista = List.of(
                new Producto("Laptop",1200),
                new Producto("Mouse",25),
                new Producto("Monitor",350)
        );

        /*
         Predicate se utiliza porque
         recibe un Producto y devuelve
         true o false para filtrar elementos.
         Firma:
         boolean test(T t)
        */
        Predicate<Producto> filtroCaros =
                p -> p.precio() > 100;

        /*
         Function se utiliza porque
         transforma un Producto en String.
         Firma:
         R apply(T t)
        */
        Function<Producto,String> nombreMayuscula =
                p -> p.nombre().toUpperCase();

        List<String> resultado =
                proc.procesar(
                        lista,
                        filtroCaros,
                        nombreMayuscula
                );

        System.out.println("Productos caros:");
        System.out.println(resultado);

        System.out.println();

        System.out.println("Method Reference");

        lista.stream()
                .map(Producto::nombre)
                .forEach(System.out::println);

    }
}