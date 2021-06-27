package dev.strace.twings.utils;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import dev.strace.twings.Main;

public class Animation {

	private HashMap<Player, Integer> animated;
	private HashMap<Player, Boolean> plus;
//	private double rotation;

	public Animation() {
		animated = new HashMap<Player, Integer>();
		plus = new HashMap<Player, Boolean>();

//		rotation = 0;

		new BukkitRunnable() {
			public void run() {
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
			}
		}.runTaskTimerAsynchronously(Main.instance, 20, 3);
	}

	public HashMap<Player, Integer> getAnimated() {
		return animated;
	}

	public void setAnimated(HashMap<Player, Integer> animated) {
		this.animated = animated;
	}

	public HashMap<Player, Boolean> getPlus() {
		return plus;
	}

	public void setPlus(HashMap<Player, Boolean> plus) {
		this.plus = plus;
	}

}
