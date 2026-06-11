import java.util.List;
import java.util.function.Function;

public class ComposicionFunciones {

    public static void main(String[] args) {

        List<String> nombres = List.of(
                "   JUAN perez   ",
                " MARIA lopez ",
                " CARLOS RAMIREZ "
        );

        Function<String,String> trim =
                String::trim;

        Function<String,String> minusculas =
                String::toLowerCase;

        Function<String,String> capitalizar =
                nombre ->
                        Character.toUpperCase(
                                nombre.charAt(0)
                        )
                                +
                                nombre.substring(1);

        Function<String,String> prefijo =
                nombre ->
                        "Sr./Sra. " + nombre;

        Function<String,String> pipeline1 =
                trim
                        .andThen(minusculas)
                        .andThen(capitalizar)
                        .andThen(prefijo);

        System.out.println("PIPELINE 1");

        nombres.forEach(
                n -> System.out.println(
                        pipeline1.apply(n)
                )
        );

        System.out.println();

        Function<String,String> pipeline2 =
                prefijo
                        .compose(capitalizar)
                        .compose(minusculas)
                        .compose(trim);

        System.out.println("PIPELINE 2");

        nombres.forEach(
                n -> System.out.println(
                        pipeline2.apply(n)
                )
        );
    }
}