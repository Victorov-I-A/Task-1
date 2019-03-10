import com.viktorov.*;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TestsForTask1 {
    private PriceList testList;
    private Product potato;
    private Product tomato;

    @Before
    public void setup() {
        testList = new PriceList();
        potato = new Product("картошка", 12, 50);
        tomato = new Product("помидор", 100, 50);
    }

    @After
    public void reset() {
        testList = null;
        potato = null;
        tomato = null;
    }

    @Test
    public void testAdd() {
        testList.add(potato, 1);
        testList.add(tomato, 1);
        testList.add(tomato, 2);
        assertEquals(tomato, testList.getProduct(2));
        assertEquals(potato, testList.getProduct(1));
    }

    @Test
    public void testPriceName() {
        testList.add(potato, 1);
        testList.add(tomato, 2);
        testList.getProduct(1).setPrice(0, 666);
        testList.getProduct(1).setPrice(0, 333);
        testList.getProduct(2).setPrice(0, 0);
        assertEquals(0.0, testList.getProduct(2).getPrice(), 0.0);
        assertEquals(3.33, testList.getProduct(1).getPrice(), 0.0);
    }

    @Test
    public void testSetName() {
        testList.add(potato, 1);
        assertEquals("картошка", testList.getProduct(1).getName());
        testList.getProduct(1).setName("картофель");
        assertEquals("картофель", testList.getProduct(1).getName());
    }

    @Test(expected = NullPointerException.class)
    public  void testDel() {
        testList.add(potato, 1);
        testList.del(1);
        testList.getProduct(1);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testGetPrice() {
        testList.add(potato, 1);
        assertEquals(25.0, testList.getPrice(1, 2), 0.0);
        thrown.expect(NullPointerException.class);
        testList.getPrice(666, 999);
    }

}
