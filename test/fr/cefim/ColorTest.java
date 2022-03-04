package fr.cefim;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    private Color colorRGB;
    private Color colorHEXA;

    private final int LIMIT_MINI = 0;
    private final int LIMIT_MAXI = 255;

    private final String ERROR_CONST_RGB = "Constructeur RGB non conforme !!!";
    private final String ERROR_CONST_HEXA = "Constructeur HEXA non conforme !!!";
    private final String ERROR_GETTER_RED = "Getter RED non conforme !!!";
    private final String ERROR_GETTER_GREEN = "Getter GREEN non conforme !!!";
    private final String ERROR_GETTER_BLUE = "Getter BLUE non conforme !!!";
    private final String ERROR_GETTER_HEXA = "Getter HEXA non conforme !!!";
    private final String ERROR_SETTER_RED = "Setter RED non conforme !!!";
    private final String ERROR_SETTER_GREEN = "Setter GREEN non conforme !!!";
    private final String ERROR_SETTER_BLUE = "Setter BLUE non conforme !!!";
    private final String ERROR_SETTER_HEXA = "Setter HEXA non conforme !!!";
    private final String ERROR_TO_STRING = "Affichage toString non conforme !!!";

    @BeforeEach
    public void setUp() {
        colorRGB = new Color(50, 150, 255); // #3296FF
        colorHEXA = new Color("#14283C"); // r=20 - g=40 - b=60
    }

    @AfterEach
    public void tearDown() {
        colorRGB = null;
    }

    // TESTS CONSTRUCTEUR RGB <<< START >>>
    @Test
    @DisplayName("Test du constructeur avec trois paramètres valides")
    public void testConstructorWithThreeParams() {
        assertAll(ERROR_CONST_RGB,
                () -> assertEquals(50, colorRGB.getRed(), ERROR_GETTER_RED),
                () -> assertEquals(150, colorRGB.getGreen(), ERROR_GETTER_GREEN),
                () -> assertEquals(255, colorRGB.getBlue(), ERROR_GETTER_BLUE),
                () -> assertEquals("#3296FF", colorRGB.getHexValue(), ERROR_GETTER_HEXA)
        );
    };

    @Test
    @DisplayName("Test du constructeur RGB avec le paramètre red en-dessous de la limite mini")
    public void testConstructorRedBelowTheMinimumLimit() {
        assertThrows(IllegalArgumentException.class, () -> new Color(LIMIT_MINI - 1, 255, 255),
                ERROR_CONST_RGB + " - " + ERROR_GETTER_RED);
    }

    @Test
    @DisplayName("Test du constructeur RGB avec le paramètre green en-dessous de la limite mini")
    public void testConstructorGreenBelowTheMinimumLimit() {
        assertThrows(IllegalArgumentException.class, () -> new Color(255, LIMIT_MINI - 1, 255),
                ERROR_CONST_RGB + " - " + ERROR_GETTER_GREEN);
    }

    @Test
    @DisplayName("Test du constructeur RGB avec le paramètre blue en-dessous de la limite mini")
    public void testConstructorBlueBelowTheMinimumLimit() {
        assertThrows(IllegalArgumentException.class, () -> new Color(255, 255, LIMIT_MINI - 1),
                ERROR_CONST_RGB + " - " + ERROR_GETTER_BLUE);
    }

    @Test
    @DisplayName("Test du constructeur RGB avec le paramètre red au-dessus de la limite maxi")
    public void testConstructorRedAboveTheMaximumLimit() {
        assertThrows(IllegalArgumentException.class, () -> new Color(LIMIT_MAXI + 1, 0, 0),
                ERROR_CONST_RGB + " - " + ERROR_GETTER_RED);
    }

    @Test
    @DisplayName("Test du constructeur RGB avec le paramètre green au-dessus de la limite maxi")
    public void testConstructorGreenAboveTheMaximumLimit() {
        assertThrows(IllegalArgumentException.class, () -> new Color(0, LIMIT_MAXI + 1, 0),
                ERROR_CONST_RGB + " - " + ERROR_GETTER_GREEN);
    }

    @Test
    @DisplayName("Test du constructeur RGB avec le paramètre blue au-dessus de la limite maxi")
    public void testConstructorBlueAboveTheMaximumLimit() {
        assertThrows(IllegalArgumentException.class, () -> new Color(0, 0, LIMIT_MAXI + 1),
                ERROR_CONST_RGB + " - " + ERROR_GETTER_BLUE);
    }
    // TESTS CONSTRUCTEUR RGB <<< END >>>

    // TESTS GETTERS RGB <<< START >>>
    @Test
    @DisplayName("Test du getter red avec la valeur passée au constructeur")
    public void testGetRed() {
        assertEquals(50, colorRGB.getRed(), ERROR_GETTER_RED);
        assertAll(ERROR_GETTER_RED,
                () -> assertEquals(150, colorRGB.getGreen(), ERROR_GETTER_GREEN),
                () -> assertEquals(255, colorRGB.getBlue(), ERROR_GETTER_BLUE),
                () -> assertEquals("#3296FF", colorRGB.getHexValue(), ERROR_GETTER_HEXA)
        );
    }

    @Test
    @DisplayName("Test du getter green avec la valeur passée au constructeur")
    public void testGetGreen() {
        assertEquals(150, colorRGB.getGreen(), ERROR_GETTER_GREEN);
        assertAll(ERROR_GETTER_GREEN,
                () -> assertEquals(50, colorRGB.getRed(), ERROR_GETTER_RED),
                () -> assertEquals(255, colorRGB.getBlue(), ERROR_GETTER_BLUE),
                () -> assertEquals("#3296FF", colorRGB.getHexValue(), ERROR_GETTER_HEXA)
        );
    }

    @Test
    @DisplayName("Test du getter blue avec la valeur passée au constructeur")
    public void testGetBlue() {
        assertEquals(255, colorRGB.getBlue(), ERROR_GETTER_BLUE);
        assertAll(ERROR_GETTER_BLUE,
                () -> assertEquals(50, colorRGB.getRed(), ERROR_GETTER_RED),
                () -> assertEquals(150, colorRGB.getGreen(), ERROR_GETTER_GREEN),
                () -> assertEquals("#3296FF", colorRGB.getHexValue(), ERROR_GETTER_HEXA)
        );
    }
    // TESTS GETTERS RGB <<< END >>>

    // TESTS SETTERS RGB - valeurs valides <<< START >>>
    @Test
    @DisplayName("Test du setter red avec une valeur valide, comprise entre le mini et le maxi")
    public void testSetRedWithGoodValue() {
        colorRGB.setRed(255);
        assertAll(ERROR_SETTER_RED,
                () -> assertEquals(255, colorRGB.getRed(), ERROR_GETTER_RED),
                () -> assertEquals(150, colorRGB.getGreen(), ERROR_GETTER_GREEN),
                () -> assertEquals(255, colorRGB.getBlue(), ERROR_GETTER_BLUE),
                () -> assertEquals("#FF96FF", colorRGB.getHexValue(), ERROR_GETTER_HEXA)
        );
    }

    @Test
    @DisplayName("Test du setter green avec une valeur valide, comprise entre le mini et le maxi")
    public void testSetGreenWithGoodValue() {
        colorRGB.setGreen(255);
        assertAll(ERROR_SETTER_GREEN,
                () -> assertEquals(50, colorRGB.getRed(), ERROR_GETTER_RED),
                () -> assertEquals(255, colorRGB.getGreen(), ERROR_GETTER_GREEN),
                () -> assertEquals(255, colorRGB.getBlue(), ERROR_GETTER_BLUE),
                () -> assertEquals("#32FFFF", colorRGB.getHexValue(), ERROR_GETTER_HEXA)
        );
    }

    @Test
    @DisplayName("Test du setter blue avec une valeur valide, comprise entre le mini et le maxi")
    public void testSetBlueWithGoodValue() {
        colorRGB.setBlue(50);
        assertAll(ERROR_SETTER_BLUE,
                () -> assertEquals(50, colorRGB.getRed(), ERROR_GETTER_RED),
                () -> assertEquals(150, colorRGB.getGreen(), ERROR_GETTER_GREEN),
                () -> assertEquals(50, colorRGB.getBlue(), ERROR_GETTER_BLUE),
                () -> assertEquals("#329632", colorRGB.getHexValue(), ERROR_GETTER_HEXA)
        );
    }
    // TESTS SETTERS RGB - valeurs valides <<< END >>>

    // TESTS SETTERS RGB - levée de l'exception <<< START >>>
    @Test
    @DisplayName("Test du setter red avec une valeur en-dessous du mini pour vérifier la levée de l'exception")
    public void testSetRedBelowTheMinimumLimit() {
        assertThrows(IllegalArgumentException.class, () -> colorRGB.setRed(LIMIT_MINI - 1), ERROR_SETTER_RED);
    }

    @Test
    @DisplayName("Test du setter green avec une valeur en-dessous du mini pour vérifier la levée de l'exception")
    public void testSetGreenBelowTheMinimumLimit() {
        assertThrows(IllegalArgumentException.class, () -> colorRGB.setGreen(LIMIT_MINI - 1), ERROR_SETTER_GREEN);
    }

    @Test
    @DisplayName("Test du setter blue avec une valeur en-dessous du mini pour vérifier la levée de l'exception")
    public void testSetBlueBelowTheMinimumLimit() {
        assertThrows(IllegalArgumentException.class, () -> colorRGB.setBlue(LIMIT_MINI - 1), ERROR_SETTER_BLUE);
    }

    @Test
    @DisplayName("Test du setter red avec une valeur au-dessus du maxi pour vérifier la levée de l'exception")
    public void testSetRedAboveTheMaximumLimit() {
        assertThrows(IllegalArgumentException.class, () -> colorRGB.setRed(LIMIT_MAXI + 1), ERROR_SETTER_RED);
    }

    @Test
    @DisplayName("Test du setter green avec une valeur au-dessus du maxi pour vérifier la levée de l'exception")
    public void testSetGreenAboveTheMaximumLimit() {
        assertThrows(IllegalArgumentException.class, () -> colorRGB.setGreen(LIMIT_MAXI + 1), ERROR_SETTER_GREEN);
    }

    @Test
    @DisplayName("Test du setter blue avec une valeur au-dessus du maxi pour vérifier la levée de l'exception")
    public void testSetBlueAboveTheMaximumLimit() {
        assertThrows(IllegalArgumentException.class, () -> colorRGB.setBlue(LIMIT_MAXI + 1), ERROR_SETTER_BLUE);
    }
    // TESTS SETTERS RGB - levée de l'exception <<< END >>>

    // TESTS SETTERS RGB - non levée de l'exception <<< START >>>
    @Test
    @DisplayName("Test du setter red avec la valeur mini pour vérifier la non levée de l'exception")
    public void testSetRedWithTheMinimumLimit() {
        assertDoesNotThrow(() -> colorRGB.setRed(LIMIT_MINI), ERROR_SETTER_RED);
    }

    @Test
    @DisplayName("Test du setter green avec la valeur mini pour vérifier la non levée de l'exception")
    public void testSetGreenWithTheMinimumLimit() {
        assertDoesNotThrow(() -> colorRGB.setGreen(LIMIT_MINI), ERROR_SETTER_GREEN);
    }

    @Test
    @DisplayName("Test du setter blue avec la valeur mini pour vérifier la non levée de l'exception")
    public void testSetBlueWithTheMinimumLimit() {
        assertDoesNotThrow(() -> colorRGB.setBlue(LIMIT_MINI), ERROR_SETTER_BLUE);
    }

    @Test
    @DisplayName("Test du setter red avec la valeur maxi pour vérifier la non levée de l'exception")
    public void testSetRedWithTheMaximumLimit() {
        assertDoesNotThrow(() -> colorRGB.setRed(LIMIT_MAXI), ERROR_SETTER_RED);
    }

    @Test
    @DisplayName("Test du setter green avec la valeur maxi pour vérifier la non levée de l'exception")
    public void testSetGreenWithTheMaximumLimit() {
        assertDoesNotThrow(() -> colorRGB.setGreen(LIMIT_MAXI), ERROR_SETTER_GREEN);
    }

    @Test
    @DisplayName("Test du setter blue avec la valeur maxi pour vérifier la non levée de l'exception")
    public void testSetBlueWithTheMaximumLimit() {
        assertDoesNotThrow(() -> colorRGB.setBlue(LIMIT_MAXI), ERROR_SETTER_BLUE);
    }
    // TESTS SETTERS RGB - non levée de l'exception <<< END >>>

    // TESTS CONSTRUCTEUR HEXA <<< START >>>
    @Test
    @DisplayName("Test du constructeur avec un paramètre au format hexadecimal")
    public void testConstructorHexadecimal() {
        assertAll(ERROR_CONST_HEXA,
                () -> assertEquals("#14283C", colorHEXA.getHexValue(), ERROR_GETTER_HEXA),
                () -> assertEquals(20, colorHEXA.getRed(), ERROR_GETTER_RED),
                () -> assertEquals(40, colorHEXA.getGreen(), ERROR_GETTER_GREEN),
                () -> assertEquals(60, colorHEXA.getBlue(), ERROR_GETTER_BLUE)
        );

    }

    @Test
    @DisplayName("Test du constructeur hexadecimal avec une valeur null")
    public void testConstructorHexaWithNullValue() {
        assertThrows(IllegalArgumentException.class, () -> new Color(null), ERROR_CONST_HEXA);
    }
    // TESTS CONSTRUCTEUR HEXA <<< END >>>

    // TESTS GETTER HEXA <<< START >>>
    @Test
    @DisplayName("Test du getter hexadecimal avec une valeur au bon format")
    public void testGetHexadecimalWithGoodValue() {
        assertEquals("#14283C", colorHEXA.getHexValue(), ERROR_GETTER_HEXA);
        assertAll(ERROR_GETTER_HEXA,
                () -> assertEquals(20, colorHEXA.getRed(), ERROR_GETTER_RED),
                () -> assertEquals(40, colorHEXA.getGreen(), ERROR_GETTER_GREEN),
                () -> assertEquals(60, colorHEXA.getBlue(), ERROR_GETTER_BLUE)
        );
    }
    // TESTS GETTER HEXA <<< END >>>

    // TESTS SETTER HEXA <<< START >>>
    @Test
    @DisplayName("Test du setter hexadecimal avec une valeur au bon format")
    public void testSetHexadecimalWithGoodValue() {
        colorHEXA.setHexValue("#EFEFEF");
        assertAll(ERROR_SETTER_HEXA,
                () -> assertEquals("#EFEFEF", colorHEXA.getHexValue(), ERROR_GETTER_HEXA),
                () -> assertEquals(239, colorHEXA.getRed(), ERROR_GETTER_RED),
                () -> assertEquals(239, colorHEXA.getGreen(), ERROR_GETTER_GREEN),
                () -> assertEquals(239, colorHEXA.getBlue(), ERROR_GETTER_BLUE)
        );
    }

    @Test
    @DisplayName("Test du setter hexadecimal avec une valeur null")
    public void testSetHexValueWithNullValue() {
        assertThrows(IllegalArgumentException.class, () -> colorHEXA.setHexValue(null), ERROR_SETTER_HEXA);
    }

    @Test
    @DisplayName("Test du setter hexadecimal sans le dièse au début")
    public void testSetHexValueWithoutSharp() {
        assertThrows(IllegalArgumentException.class, () -> colorHEXA.setHexValue("A1B2C3"), ERROR_SETTER_HEXA);
    }

    @Test
    @DisplayName("Test du setter hexadecimal avec le dièse à la fin")
    public void testSetHexValueWithSharpAtEnd() {
        assertThrows(IllegalArgumentException.class, () -> colorHEXA.setHexValue("A1B2C3#"), ERROR_SETTER_HEXA);
    }

    @Test
    @DisplayName("Test du setter hexadecimal avec des lettres en minuscules")
    public void testSetHexValueWithLowercaseLetter() {
        assertThrows(IllegalArgumentException.class, () -> colorHEXA.setHexValue("a1b2c3"), ERROR_SETTER_HEXA);
    }

    @Test
    @DisplayName("Test du setter hexadecimal avec une valeur trop courte")
    public void testSetHexValueWithTooShortValue() {
        assertThrows(IllegalArgumentException.class, () -> colorHEXA.setHexValue("#ABC"), ERROR_SETTER_HEXA);
    }

    @Test
    @DisplayName("Test du setter hexadecimal avec une valeur trop longue")
    public void testSetHexValueWithTooLongValue() {
        assertThrows(IllegalArgumentException.class, () -> colorHEXA.setHexValue("#A1B2C3D4"), ERROR_SETTER_HEXA);
    }

    @Test
    @DisplayName("Test du setter hexadecimal pour vérifier la non levée de l'exception")
    public void testSetWithValueHexFormat() {
        assertDoesNotThrow(() -> colorHEXA.setHexValue("#A1B2C3"), ERROR_SETTER_HEXA);
    }
    // TESTS SETTER HEXA <<< END >>>

    // TESTS TO STRING <<< START >>>
    @Test
    @DisplayName("Test de l'affichage de la méthode toString colorRGB qui ne peut être null")
    public void testToStringNotNullConstructorRGB() {
        assertNotNull(colorRGB.toString(), ERROR_TO_STRING);
    }

    @Test
    @DisplayName("Test de l'affichage de la méthode toString colorHEXA qui ne peut être null")
    public void testToStringNotNullConstructorHexa() {
        assertNotNull(colorHEXA.toString(), ERROR_TO_STRING);
    }

    @Test
    @DisplayName("Test de l'affichage de toString avec le constructeur RGB")
    public void testToSTringConstructorRGB() {
        assertEquals("[value=#3296FF, r=50, g=150, b=255]", colorRGB.toString(), ERROR_TO_STRING);
    }

    @Test
    @DisplayName("Test de l'affichage de toString avec le constructeur HEXA")
    public void testToSTringConstructorHEXA() {
        assertEquals("[value=#14283C, r=20, g=40, b=60]", colorHEXA.toString(), ERROR_TO_STRING);
    }
    // TESTS TO STRING <<< END >>>

}
