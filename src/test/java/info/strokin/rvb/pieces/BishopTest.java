package info.strokin.rvb.pieces;

import info.strokin.rvb.Position;
import org.junit.Assert;
import org.junit.Test;

public class BishopTest {

    @Test
    public void testCanCapture() {
        Bishop bishop = new Bishop(new Position("c4"), 8);

        Assert.assertTrue(bishop.canCapture(new Position("a6")));
        Assert.assertTrue(bishop.canCapture(new Position("f7")));
        Assert.assertTrue(bishop.canCapture(new Position("e2")));
        Assert.assertTrue(bishop.canCapture(new Position("b3")));
    }

    @Test
    public void testCannotCapture() {
        Bishop bishop = new Bishop(new Position("c4"), 8);

        Assert.assertFalse(bishop.canCapture(new Position("b2")));
        Assert.assertFalse(bishop.canCapture(new Position("e5")));
        Assert.assertFalse(bishop.canCapture(new Position("h2")));
        Assert.assertFalse(bishop.canCapture(new Position("c8")));
    }
}
