package me.limeglass.time;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;

public class Time extends JavaPlugin {

	private static SkriptAddon addon;
	private static Time instance;

	public void onEnable() {
		try {
			addon = Skript.registerAddon(this)
					.loadClasses("me.limeglass.time", "elements")
					.setLanguageFileDirectory("lang");
		} catch (IOException e) {
			e.printStackTrace();
		}
		instance = this;
	}

	public SkriptAddon getAddonInstance() {
		return addon;
	}

	public static Time getInstance() {
		return instance;
	}

}
