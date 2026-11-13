import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
/*
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
*/

public class Teste {
    MathUtils mu = new MathUtils();
    Main m = new Main();

    @BeforeAll
    static void st() {
        System.out.println("=== Bat dau chay MathUtilsTest ===");
    }

    @AfterAll
    static void ed() {
        System.out.println("=== Ket thuc ===");
    }

    @Test
    public void idk() {
        assertNotNull(m);
        assertNotNull(mu);
    }

    @Test
    public void epmax() {
        int ret = MathUtils.max(0, 1);
        assertEquals(ret, 1);
        ret = MathUtils.max(1, 1);
        assertEquals(ret, 1);
        ret = MathUtils.max(2, 1);
        assertEquals(ret, 2);
    }

    @Test
    public void epbva() {
        int ret = MathUtils.max(Integer.MIN_VALUE, Integer.MIN_VALUE + 1);
        assertEquals(Integer.MIN_VALUE + 1, ret);
        ret = MathUtils.max(Integer.MAX_VALUE-1, Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, ret);
    }

    @Test
    public void epdivide() {
        assertThrows(IllegalArgumentException.class,
            () -> MathUtils.divide(1, 0));
        int ret = MathUtils.divide(3, 2);
        assertEquals(ret, 1, 0.001);
        ret = MathUtils.divide(3, -2);
        assertEquals(ret, -1, 0.001);
    }
}
