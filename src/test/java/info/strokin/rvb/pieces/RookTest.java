package info.strokin.rvb.pieces;

import info.strokin.rvb.Position;
import org.junit.Assert;
import org.junit.Test;

public class RookTest {

    @Test
    public void testCanCapture(){
        Rook rook = new Rook(new Position("c5"), 8);

        Assert.assertTrue(rook.canCapture(new Position("a5")));
        Assert.assertTrue(rook.canCapture(new Position("c7")));
        Assert.assertTrue(rook.canCapture(new Position("c2")));
        Assert.assertTrue(rook.canCapture(new Position("g5")));
    }

    @Test
    public void testCannotCapture(){
        Rook rook = new Rook(new Position("c5"), 8);

        Assert.assertFalse(rook.canCapture(new Position("b2")));
        Assert.assertFalse(rook.canCapture(new Position("d4")));
        Assert.assertFalse(rook.canCapture(new Position("h2")));
        Assert.assertFalse(rook.canCapture(new Position("d8")));
    }

    @Test
    public void testMoveUp(){
        Rook rook = new Rook(new Position("c5"), 8);
        rook.moveUp(2);
        Assert.assertEquals("c7", rook.getCurrentPosition().toString());

        rook.moveUp(5);
        Assert.assertEquals("c4", rook.getCurrentPosition().toString());

        rook.moveUp(10);
        Assert.assertEquals("c6", rook.getCurrentPosition().toString());
    }

    @Test
    public void testMoveRight(){
        Rook rook = new Rook(new Position("c5"), 8);
        rook.moveRight(2);
        Assert.assertEquals("e5", rook.getCurrentPosition().toString());

        rook.moveRight(5);
        Assert.assertEquals("b5", rook.getCurrentPosition().toString());

        rook.moveRight(10);
        Assert.assertEquals("d5", rook.getCurrentPosition().toString());
    }
}
