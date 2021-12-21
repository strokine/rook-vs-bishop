package info.strokin.rvb.randomizers;

import java.util.Random;

public class Coin {
    private Random random = new Random();

    public boolean isHeads(){
        return random.nextBoolean();
    }
}
