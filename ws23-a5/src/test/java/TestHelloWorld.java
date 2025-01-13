// TestHelloWorld.java

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class TestHelloWorld {

    private static int testZaehler;

    @BeforeAll
    public static void setUp() {
        testZaehler = 0;
        System.out.println("TESTVORBEREITUNG");
    }

    @BeforeEach
    public void incrementCounter() {
        testZaehler++;
    }

    @Test
    public void testTrueVariable() {
        assertTrue(true);
    }

    @Test
    public void testErrorThrown() {
        assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException("Beispiel-Fehler");
        });
    }

    @Test
    public void testResultEquals42() {
        assertEquals(42, 42);
    }

    @AfterEach
    public void printTestCounter() {
        System.out.println(testZaehler + " Tests wurden ausgeführt");
    }

    @AfterAll
    public static void printTotalTests() {
        System.out.println("Die Ausführung der Tests in TestHelloWorld ist beendet.");
    }
}
