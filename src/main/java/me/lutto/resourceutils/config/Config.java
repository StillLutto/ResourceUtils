package me.lutto.resourceutils.config;

import com.google.gson.*;
import me.lutto.resourceutils.ResourceUtils;
import net.fabricmc.loader.api.FabricLoader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Config {

    private static final Path PATH = FabricLoader.getInstance().getConfigDir().resolve(ResourceUtils.MOD_ID + ".json");
    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static boolean enabled = true;

    public static int low_fire = 20;
    public static boolean small_flame = true;
    public static int low_held_up_shield = 25;
    public static int low_side_shield = 25;
    public static int shield_size = 0;
    public static boolean side_shield = false;
    public static int small_totem = 40;

    public static void load() {
        if (!Files.exists(PATH)) save();

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(PATH);
            JsonObject json = JsonParser.parseReader(bufferedReader).getAsJsonObject();

            if (json.get("enabled") != null) enabled = json.get("enabled").getAsBoolean();
            if (json.get("low_fire") != null) low_fire = json.get("low_fire").getAsInt();
            if (json.get("low_held_up_shield") != null) low_held_up_shield = json.get("low_held_up_shield").getAsInt();
            if (json.get("low_side_shield") != null) low_side_shield = json.get("low_side_shield").getAsInt();
            if (json.get("shield_size") != null) shield_size = json.get("shield_size").getAsInt();
            if (json.get("small_totem") != null) small_totem = json.get("small_totem").getAsInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void save() {
        JsonObject jsonConfig = new JsonObject();

        jsonConfig.addProperty("enabled", enabled);
        jsonConfig.addProperty("low_fire", low_fire);
        jsonConfig.addProperty("low_held_up_shield", low_held_up_shield);
        jsonConfig.addProperty("low_side_shield", low_side_shield);
        jsonConfig.addProperty("shield_size", shield_size);
        jsonConfig.addProperty("small_totem", small_totem);
        try (BufferedWriter fileWriter = Files.newBufferedWriter(PATH)) {
            fileWriter.write(GSON.toJson(jsonConfig));
        } catch (IOException e) {
            ResourceUtils.LOGGER.error("Couldn't save Resource Utils configuration file.");
            e.printStackTrace();
        }
    }
}
