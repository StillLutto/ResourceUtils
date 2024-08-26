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

    public static void load() {
        if (!Files.exists(PATH)) save();

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(PATH);
            JsonObject json = JsonParser.parseReader(bufferedReader).getAsJsonObject();

            if (json.get("enabled") != null) enabled = json.get("enabled").getAsBoolean();
            if (json.get("low_fire") != null) low_fire = json.get("low_fire").getAsInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void save() {
        JsonObject jsonConfig = new JsonObject();

        jsonConfig.addProperty("enabled", enabled);
        jsonConfig.addProperty("low_fire", low_fire);
        try (BufferedWriter fileWriter = Files.newBufferedWriter(PATH)) {
            fileWriter.write(GSON.toJson(jsonConfig));
        } catch (IOException e) {
            ResourceUtils.LOGGER.error("Couldn't save Resource Utils configuration file");
            e.printStackTrace();
        }
    }
}
