package io.github.gmw.utils;

import com.google.gson.GsonBuilder;
import emu.grasscutter.Grasscutter;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Objects;

public final class MeaConfigParser {
    private MeaConfig config;
    private final String configPath = Grasscutter.getConfig().folderStructure.plugins + "MeaNotice";
    private final File configFile = new File( this.configPath + "/config.json");
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public MeaConfigParser() {

        this.loadConfig();
        // 输出config
    }

    public MeaConfig getConfig() {
        return this.config;
    }

    public void loadConfig() {
        try (FileReader file = new FileReader(this.configFile)) {
            this.config = gson.fromJson(file, MeaConfig.class);
            Grasscutter.getLogger().info("[MeaNoticeCore] Config Loaded!");
        } catch (Exception e) {
            this.config = new MeaConfig();
            Grasscutter.getLogger().info("[MeaNoticeCore] Basic config creating...");
        }

        if (!saveConfig()) {
            Grasscutter.getLogger().error("[MeaNoticeCore] Unable to save config file.");
        }

        Grasscutter.getLogger().info("[MeaNoticeCore] NoticesLength: " + this.config.notices.length + "; Interval: " + this.config.interval);
    }

    public boolean saveConfig() {
        // 如果文件夹不存在或者文件夹为空又或者不是文件夹 ，则创建文件夹;
        File dir = new File(this.configPath);

        if (!dir.exists() || !dir.isDirectory()) {
            if (!new java.io.File(String.valueOf(dir)).mkdirs()) return false;
        }

        try (FileWriter file = new FileWriter(this.configFile)) {
            file.write(gson.toJson(this.config));
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
