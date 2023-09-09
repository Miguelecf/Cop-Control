import static org.junit.Assert.*;
import org.junit.Test;
import avion.AvionPesado;
import avion.AvionSimple;
import copControl.Mapa;
import copControl.Posicion;
import pista.PistaSimple;
import pista.PosicionesEntradaVaciaException;

public class PistaSimpleTest {

  @Test
  public void testPuedeAterrizarAvionSimple() throws Exception {
    Posicion posicionEntrada = new Posicion(1, 10);
    PistaSimple pista = new PistaSimple(new Posicion(1, 20));
    pista = new PistaSimple(posicionEntrada);
    AvionSimple avion = new AvionSimple(new Posicion(3, 3), new Posicion(6, 6), new Mapa());
    boolean puedeAterrizar = pista.puedeAterrizar(avion);

    assertTrue("El Avión debería poder aterrizar en la PistaSimple si aterrizó.", puedeAterrizar);
  }

  @Test
  public void testNoPuedeAterrizarAvionPesado() throws PosicionesEntradaVaciaException {
    Posicion posicionEntrada = new Posicion(5, 5);
    PistaSimple pista = null;
    pista = new PistaSimple(posicionEntrada);
    AvionPesado avion = new AvionPesado(new Posicion(1, 1), new Posicion(8, 8), new Mapa());
    boolean puedeAterrizar = pista.puedeAterrizar(avion);

    assertFalse("El Avión no debería poder aterrizar en la PistaSimple si no aterrizó.", puedeAterrizar);
  }
}
