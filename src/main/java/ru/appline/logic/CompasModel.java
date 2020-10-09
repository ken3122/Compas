package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CompasModel implements Serializable {
    private static final CompasModel instance = new CompasModel();

    private final Map<String, Boundaries> model;

    public CompasModel() {
        model = new HashMap<String, Boundaries>();

        model.put("North", new Boundaries(338, 22));
        model.put("North-East",  new Boundaries(23, 67));
        model.put("East",  new Boundaries(68, 112));
        model.put("South-East",  new Boundaries(113, 157));
        model.put("South",  new Boundaries(158, 202));
        model.put("South-West",  new Boundaries(203, 247));
        model.put("West",  new Boundaries(248, 292));
        model.put("North-West",  new Boundaries(293, 337));
    }

    /*
        {
            "North": "338-22",
            "North-East": "23-67",
            "East": "68-112",
            "South-East": "113-157",
            "South": "158-202",
            "South-West": "203-247",
            "West": "248-292",
            "North-West": "293-337"
        }
    * */

    public static CompasModel getInstance() {
        return instance;
    }

    public void add(String direction, Boundaries boundaries) {
        model.put(direction, boundaries);
    }

    public Map<String, Boundaries> getModel() {
        return model;
    }

    public boolean containsKey(String direction) {
        return model.containsKey(direction);
    }

    public Side getSide(int degree) {
        for(Map.Entry<String, Boundaries> entry: model.entrySet()) {
            int leftB = entry.getValue().getLeftBoundary();
            int rightB = entry.getValue().getRightBoundary();
            if(leftB <= rightB) {
                if ((degree >= leftB) && (degree <= rightB)) {
                    return new Side(entry.getKey());
                }
            } else {
                if ((degree > leftB) || (degree < rightB)) {
                    return new Side(entry.getKey());
                }
            }
        }
        return new Side("Undefined");
    }

}
