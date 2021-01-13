/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gobierno;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author cristian
 */
public class TDD {

    public TDD() {
    }

    @Test
    public void testAutorizacionSalidaCalle() {

        
        Assert.assertFalse(puedeSalir("16014113-1",isFinDeSemana("Lunes") , 0, "Peñaflor"));
        Assert.assertTrue(puedeSalir("16014113-1", isFinDeSemana("Lunes"), 10, "Peñaflor"));
        Assert.assertFalse(puedeSalir("16014113-1", isFinDeSemana("Jueves"), 10, "Concepcion"));
        Assert.assertFalse(puedeSalir("16014113-1", isFinDeSemana("Domingo"), 10, "Puente Alto"));
        Assert.assertTrue(puedeSalir("16014113-1", isFinDeSemana("Miercoles"), 13, "Puente Alto"));
        Assert.assertFalse(puedeSalir("16014113-1", isFinDeSemana("Miercoles"), 23, "Puente Alto"));
        Assert.assertFalse(puedeSalir("100-9", isFinDeSemana("Martes"), 13, "Santiago"));
    }

    private boolean puedeSalir(String rutPersona, boolean isFinDeSemana, int hora, String comuna) {

        if (isTieneCovidOSospechoso(rutPersona)) {
            //si tiene codiv, se queda en casa
            return false;
        } else if (hora >= 22 || hora < 5) {
            //si es toque de queda, se queda en casa
            return false;
        } else if (isComunaCuarentena(comuna)) {
            //si la comuna esta en cuarentena, se queda en casa
            return false;
        } else if (isComunaFase2(comuna) && isFinDeSemana) {
            //si esta en fase2 y es fin de semana, se queda en casa
            return false;
        } else {
            //libre
            return true;
        }
    }

    private boolean isTieneCovidOSospechoso(String rutPersona) {
        return rutPersona.equalsIgnoreCase("100-9");
    }

    private boolean isComunaCuarentena(String comuna) {
        if (comuna.equalsIgnoreCase("Concepcion")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isComunaFase2(String comuna) {
        if (comuna.equalsIgnoreCase("Puente Alto")) {
            return true;
        }
        return false;
    }

    private static boolean isFinDeSemana(String diaSemana) {
        return diaSemana.equalsIgnoreCase("Sabado") || diaSemana.equalsIgnoreCase("Domingo");
    }

}
