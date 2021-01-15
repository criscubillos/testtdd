package ejemplo2;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author cristian
 */
public class ConversorRomanoTest {

    /*
      0  -> 0
      1  -> I
      2  -> II
      3  -> III
      4  -> IV
      5  -> V
      6  -> VI
      7  -> VII
      8  -> VIII
      9  -> IX
      10 -> X
      11 -> XI
      12 -> XII
      13 -> XIII
      14 -> XIV
      15 -> XV
      16 -> XVI
      17 -> XVII
      18 -> XVIII
      19 -> XIX
      20 -> XX
      21 -> XXI
      22 -> XXII
      23 -> XXIII
    
      30 -> XXX
      40 -> XL
      50 -> L
      60 -> LX
      70 -> LXX
      80 -> LXXX
      90 -> XC
    
      50   -> L
      100  -> C
      500  -> D
      1000 -> M
    
     */
    @Test
    public void testIntToRoman() {

        Assert.assertNull(conversor(-1));
        Assert.assertEquals("0", conversor(0));
        Assert.assertEquals("I", conversor(1));
        Assert.assertEquals("II", conversor(2));
        Assert.assertEquals("III", conversor(3));
        Assert.assertEquals("IV", conversor(4));
        Assert.assertEquals("V", conversor(5));
        Assert.assertEquals("VI", conversor(6));
        Assert.assertEquals("VII", conversor(7));
        Assert.assertEquals("VIII", conversor(8));
        Assert.assertEquals("IX", conversor(9));
        Assert.assertEquals("X", conversor(10));
        Assert.assertEquals("XI", conversor(11));
        Assert.assertEquals("XII", conversor(12));
        Assert.assertEquals("XIV", conversor(14));
        Assert.assertEquals("XV", conversor(15));
        Assert.assertEquals("XVI", conversor(16));
        Assert.assertEquals("XIX", conversor(19));
        Assert.assertEquals("XX", conversor(20));
        Assert.assertEquals("XXI", conversor(21));
        Assert.assertEquals("XXIII", conversor(23));
        Assert.assertEquals("XXIV", conversor(24));
        Assert.assertEquals("XXV", conversor(25));
        Assert.assertEquals("XXVI", conversor(26));
        Assert.assertEquals("XXXIV", conversor(34));
        Assert.assertEquals("XXXIX", conversor(39));
        Assert.assertEquals("XL", conversor(40));
        Assert.assertEquals("XLVIII", conversor(48));
        Assert.assertEquals("XLIX", conversor(49));
        Assert.assertEquals("L", conversor(50));
        Assert.assertEquals("LI", conversor(51));
        Assert.assertEquals("LVIII", conversor(58));
        Assert.assertEquals("LIX", conversor(59));
        Assert.assertEquals("LX", conversor(60));
        Assert.assertEquals("LXIII", conversor(63));
        Assert.assertEquals("LXVIII", conversor(68));
        Assert.assertEquals("LXXXIX", conversor(89));
        Assert.assertEquals("XC", conversor(90));
        Assert.assertEquals("XCI", conversor(91));
        Assert.assertEquals("XCV", conversor(95));
        Assert.assertEquals("C", conversor(100));
        Assert.assertEquals("CIII", conversor(103));
        Assert.assertEquals("CXVII", conversor(117));
        Assert.assertEquals("CLXX", conversor(170));
        Assert.assertEquals("CCL", conversor(250));
        Assert.assertEquals("CCCXCIX", conversor(399));
        Assert.assertEquals("CD", conversor(400));
        Assert.assertEquals("CDX", conversor(410));
        Assert.assertEquals("CDL", conversor(450));
        Assert.assertEquals("CDLXXX", conversor(480));
        Assert.assertEquals("CDXCIX", conversor(499));
        Assert.assertEquals("D", conversor(500));
        Assert.assertEquals("DX", conversor(510));
        Assert.assertEquals("DLXXX", conversor(580));
        Assert.assertEquals("DXCIX", conversor(599));
        Assert.assertEquals("DC", conversor(600));
        Assert.assertEquals("DCX", conversor(610));
        Assert.assertEquals("DCL", conversor(650));
        Assert.assertEquals("DCXCV", conversor(695));
        Assert.assertEquals("DCC", conversor(700));
        Assert.assertEquals("DCCC", conversor(800));
        Assert.assertEquals("DCCCXL", conversor(840));
        Assert.assertEquals("CM", conversor(900));
        Assert.assertEquals("CML", conversor(950));
        Assert.assertEquals("CMXCIX", conversor(999));
        Assert.assertEquals("M", conversor(1000));
        Assert.assertEquals("MD", conversor(1500));
        Assert.assertEquals("MCMXCIX", conversor(1999));
        Assert.assertEquals("MM", conversor(2000));
        Assert.assertEquals("MMDLX", conversor(2560));
        Assert.assertEquals("MMM", conversor(3000));
        Assert.assertEquals("MMMD", conversor(3500));
        Assert.assertEquals("MMMCM", conversor(3900));
        Assert.assertEquals("MMMCMXCIX", conversor(3999));

    }

    private String token(String old, int n) {

        if (n >= 1000) {
            return duplicar("M", n / 1000) + token(old, n % 1000);
        }
        if (n == 0) {
            return old;
        } else if (n == 1) {
            return old + "I";
        } else if (n == 2) {
            return old + "II";
        } else if (n == 3) {
            return old + "III";
        } else if (n == 4) {
            return old + "IV";
        } else if (n == 5) {
            return old + "V";
        } else if (n == 6) {
            return old + "VI";
        } else if (n == 7) {
            return old + "VII";
        } else if (n == 8) {
            return old + "VIII";
        } else if (n == 9) {
            return old + "IX";
        } else if (n == 10) {
            return old + "X";
        } else if (n > 10) {

            String letra = "";
            String comodin = "";
            boolean aproximarUp = false;

            int divisor = 0;
            if (n >= 10 && n < 50) {
                letra = "X";
                divisor = 10;
            } else if (n >= 50 && n < 90) {
                letra = "L";
                divisor = 50;
            } else if (n >= 90 && n <= 400) {
                letra = "C";
                divisor = 100;
            } else if (n < 500) {
                letra = "C";
                divisor = 500;
                aproximarUp = true;
            } else {
                letra = "D";
                divisor = 1000;
                aproximarUp = true;
            }

            int div = 0;

            if (aproximarUp) {
                double preDiv = (double) ((double) n / (double) divisor);
                if (preDiv > 0.0 && preDiv < 1.0 && (divisor >= 500)) {
                    preDiv = 1.0;
                }
                //System.out.println("n: " + n + " dividido en : " + divisor + " = " + preDiv);
                div = (int) preDiv;
            } else {
                div = (int) n / divisor;
            }

            if (div > 3) {
                //cuando llega a 40 debe aparecer el XL
                div = 1;
            }

            if (n >= 40 && n < 50) {
                comodin = "L";
            } else if (n >= 90 && n < 100) {
                comodin = "XC";
            } else if (n >= 400 && n < 500) {
                comodin = "D";
            } else if (n >= 600 && n < 900) {
                int mod2 = ((n - 500) / 100);
                comodin = duplicar("C", mod2);
            } else if (n >= 900 && n < 1000) {
                div = 0;
                comodin = "CM";
            }
            /*else if (n >= 1000) {
                div = 0;
                comodin = "M";                
            }*/

            int mod = 0;

            if (n > 50 && n < 90) {
                mod = 50;
            } else if (n >= 100) {
                mod = 100;
            } else if (n >= 400 && n < 500) {
                mod = 500;
            } else if (n >= 500 && n < 1000) {
                mod = 1000;
            } else {
                mod = 10;
            }

            //  System.out.println("N: " + n + " --- letra(" + div + "): " + letra + ", comodin: " + comodin + ", mod: " + mod);
            //System.out.println(n + " mod " + mod + " dup: " + div);
            return duplicar(letra, div) + comodin + token(old, n % mod);

            /*String letraDuplicar = null;
            int divisor = 0;

            double detectorL = n / 50;
            double detectorC = n / 100;
            double detectorM = n / 1000;

            int numeroBase = 0;

            if (detectorL >= 1 && detectorL < 2.0) {
                numeroBase = 50;
            }

            if (detectorL < 1.0) {
                letraDuplicar = "X";
                divisor = 10;
            } else if (detectorL >= 1.0 && detectorC < 1.0) {
                letraDuplicar = "L";
                divisor = 50;
            } else if (detectorC >= 1.0 && detectorM < 1.0) {
                letraDuplicar = "C";
                divisor = 100;
            } else {
                letraDuplicar = "M";
                divisor = 100;
            }

            int cantidadDup = (int) n / divisor;
            System.out.println("n:" + n + " / " + divisor + ", cantidadDup: " + cantidadDup + ", letra Duplicar: " + letraDuplicar);

            if (cantidadDup > 3) {
                letraDuplicar += "L";
                cantidadDup = 1;
            }

            return token("", numeroBase) + token(duplicar(letraDuplicar, cantidadDup), n % 10);*/
        } else {
            return "-";
        }
    }

    private String duplicar(String letra, int cantidad) {
        String s = "";
        for (int i = 0; i < cantidad; i++) {
            s += letra;
        }
        return s;
    }

    public String conversor(int n) {
        if (n < 0) {
            return null;
        }
        if (n == 0) {
            return "0";
        }
        String ret = token("", n);
        System.out.println("N " + n + " --> " + ret);
        return ret;
    }

}
