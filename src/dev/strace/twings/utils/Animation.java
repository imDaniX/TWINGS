package dev.strace.twings.utils;

import dev.strace.twings.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Animation {

    private HashMap<Player, Integer> animated;
    private HashMap<Player, Boolean> plus;
//	private double rotation;

    public Animation() {
        animated = new HashMap<>();
        plus = new HashMap<>();

//		rotation = 0;

        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getInstance(), () -> {

            for (Player p : animated.keySet()) {
                if (animated.get(p) <= 30 && plus.get(p))
                    animated.put(p, animated.get(p) + 2);
                else
                    plus.put(p, false);
                if (animated.get(p) > 0 && !plus.get(p))
                    animated.put(p, animated.get(p) - 2);
                else
                    plus.put(p, true);
            }
//				if (rotation >= 360)
//					rotation = 0;
//				rotation++;
        }, 20, 3);
    }

    public HashMap<Player, Integer> getAnimated() {
        return animated;
    }

    public HashMap<Player, Boolean> getPlus() {
        return plus;
    }

}
