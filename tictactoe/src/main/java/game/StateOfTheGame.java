package game;

import java.util.HashMap;
import java.util.Map;

public class StateOfTheGame {

    Map<String, StateOfField> map = new HashMap<>();

    public StateOfTheGame() {
        map.put("0-0", StateOfField.FREE);
        map.put("0-1", StateOfField.FREE);
        map.put("0-2", StateOfField.FREE);

        map.put("1-0", StateOfField.FREE);
        map.put("1-1", StateOfField.FREE);
        map.put("1-2", StateOfField.FREE);

        map.put("2-0", StateOfField.FREE);
        map.put("2-1", StateOfField.FREE);
        map.put("2-2", StateOfField.FREE);

    }

    boolean isAvailable(int x, int y){

        return map.get(x+"-"+y).equals(StateOfField.FREE);
    }

}
