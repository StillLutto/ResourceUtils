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

    public static boolean no_explosion_sounds = false;
    public static boolean no_lava_fog = false;
    public static boolean no_underwater_fog = false;
    public static boolean no_powder_snow_fog = false;
    public static boolean no_nether_fog = false;
    public static boolean no_overworld_fog = false;
    public static boolean no_sky_fog = false;
    public static boolean no_darkness_fog = false;
    public static boolean no_blindness_fog = false;

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

            if (json.get("no_explosion_sounds") != null) no_explosion_sounds = json.get("no_explosion_sounds").getAsBoolean();

            if (json.get("no_lava_fog") != null) no_lava_fog = json.get("no_lava_fog").getAsBoolean();
            if (json.get("no_water_fog") != null) no_underwater_fog = json.get("no_water_fog").getAsBoolean();
            if (json.get("no_powder_snow_fog") != null) no_powder_snow_fog = json.get("no_powder_snow_fog").getAsBoolean();
            if (json.get("no_nether_fog") != null) no_nether_fog = json.get("no_nether_fog").getAsBoolean();
            if (json.get("no_underwater_fog") != null) no_overworld_fog = json.get("no_overworld_fog").getAsBoolean();
            if (json.get("no_sky_fog") != null) no_sky_fog = json.get("no_sky_fog").getAsBoolean();
            if (json.get("no_darkness_fog") != null) no_darkness_fog = json.get("no_darkness_fog").getAsBoolean();
            if (json.get("no_blindness_fog") != null) no_blindness_fog = json.get("no_blindness_fog").getAsBoolean();
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

        jsonConfig.addProperty("no_explosion_sounds", no_explosion_sounds);

        jsonConfig.addProperty("no_lava_fog", no_lava_fog);
        jsonConfig.addProperty("no_water_fog", no_underwater_fog);
        jsonConfig.addProperty("no_powder_snow_fog", no_powder_snow_fog);
        jsonConfig.addProperty("no_nether_fog", no_nether_fog);
        jsonConfig.addProperty("no_underwater_fog", no_overworld_fog);
        jsonConfig.addProperty("no_sky_fog", no_sky_fog);
        jsonConfig.addProperty("no_darkness_fog", no_darkness_fog);
        jsonConfig.addProperty("no_blindness_fog", no_blindness_fog);

        try (BufferedWriter fileWriter = Files.newBufferedWriter(PATH)) {
            fileWriter.write(GSON.toJson(jsonConfig));
        } catch (IOException e) {
            ResourceUtils.LOGGER.error("Couldn't save Resource Utils configuration file.");
            e.printStackTrace();
        }
    }
}
