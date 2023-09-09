import static org.junit.Assert.*;

import org.junit.Test;

import avion.Helicoptero;
import copControl.Mapa;
import copControl.Posicion;
import pista.Helipuerto;
import pista.Pista;
import pista.PosicionesEntradaVaciaException;

public class HelicopteroTest {

  @Test
  public void testMoverHacia() {
    Helicoptero helicoptero = new Helicoptero(new Posicion(0, 0), new Posicion(0, 0), new Mapa());

    Posicion nuevaPosicion = new Posicion(5, 5);
    helicoptero.moverHacia(nuevaPosicion);

    assertEquals(nuevaPosicion, helicoptero.getPosicionActual());

  }

  @Test
  public void testPuedeAterrizar() throws PosicionesEntradaVaciaException {
    Helicoptero helicoptero = new Helicoptero(new Posicion(0, 0), new Posicion(0, 0), new Mapa());
    Pista helipuerto = new Helipuerto(new Posicion(1, 10));
    assertTrue("El helicoptero debió poder aterrizar", helicoptero.puedeAterrizar(helipuerto));

  }

  @Test
  public void testAvanzarCuandoEstaDetenido() {
    Helicoptero helicoptero = new Helicoptero(new Posicion(0, 0), new Posicion(0, 0), new Mapa());
    helicoptero.detener();

    Posicion posicionDetenido = helicoptero.getPosicionActual();

    helicoptero.avanzar();

    assertEquals(posicionDetenido, helicoptero.getPosicionActual());
  }

}