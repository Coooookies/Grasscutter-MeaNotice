package io.github.gmw;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.plugin.Plugin;
import emu.grasscutter.command.CommandMap;
import io.github.gmw.utils.MeaConfigParser;
import io.github.gmw.utils.MeaNotice;
import io.github.gmw.utils.MeaCommand;

public class MeaNoticeCore extends Plugin {

    private static MeaNoticeCore instance;
    private MeaConfigParser config;
    private MeaNotice notice;

    @Override
    public void onLoad() {
        Grasscutter.getLogger().info("[MeaNoticeCore] Loading...");
        instance = this;
        this.config = new MeaConfigParser();
        this.notice = new MeaNotice();

        notice.setNotice(config.getConfig().notices);
        notice.enable(config.getConfig().interval);

        Grasscutter.getLogger().info("[MeaNoticeCore] Loaded!");
    }

    @Override
    public void onEnable() {
        CommandMap.getInstance().registerCommand("meanotice", new MeaCommand());
    }

    @Override
    public void onDisable() {
        CommandMap.getInstance().unregisterCommand("meanotice");
    }

    public static MeaNoticeCore getInstance() {
        return instance;
    }

    public void reloadConfig() {
        notice.disable();
        config.loadConfig();
        notice.setNotice(config.getConfig().notices);
        notice.enable(config.getConfig().interval);
    }
}
