import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("calculadora")
public class CalculadoraRest {

    @Path("/somarInt/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Calculadora somarInt(@PathParam("a")  int operando1, @PathParam("b")  int operando2){
        return new Calculadora(operando1, operando2, "+");
    }

    @Path("/multiplicarInt/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Calculadora multiplicarInt(@PathParam("a") int operando1, @PathParam("b") int operando2){
        return new Calculadora(operando1, operando2, "*");
    }
}
