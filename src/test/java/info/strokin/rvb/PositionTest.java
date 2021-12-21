package info.strokin.rvb;

import org.junit.Assert;
import org.junit.Test;

public class PositionTest {

    @Test
    public void testPositionCode() {
        Position position = new Position("c4");

        Assert.assertEquals(2, position.getFile());
        Assert.assertEquals(3, position.getRank());
    }

    @Test
    public void testPrint() {
        Position position = new Position("c4");

        Assert.assertEquals("c4", position.toString());

        position = new Position("A24");

        Assert.assertEquals("a24", position.toString());
    }

    @Test
    public void testEquals() {
        Position position1 = new Position("c4");
        Position position2 = new Position("c4");

        Assert.assertEquals(position1, position2);
    }
}
