package io.github.gmw.utils;

import emu.grasscutter.Grasscutter;

import java.util.Timer;
import java.util.TimerTask;

public final class MeaNotice {
    private String[] notices = {};
    private int currentNoticeIndex = 0;
    private Timer noticeTimer;
    private class noticeTimerTask extends TimerTask {
        @Override
        public void run() {
            if (currentNoticeIndex >= notices.length - 1) {
                currentNoticeIndex = 0;
            } else {
                currentNoticeIndex++;
            }

            String notice = notices[currentNoticeIndex];


            try {
                Grasscutter.getGameServer().getPlayers().forEach((index, player) -> {
                    player.dropMessage(notice);
                });
                Grasscutter.getLogger().info("[MeaNoticeCore] Send notice: " + notice);
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
    };

    public void setNotice(String[] notices) {
        this.notices = notices;
    }

    public void enable(int interval) {
        this.noticeTimer = new Timer();
        this.noticeTimer.schedule(new noticeTimerTask(),0, interval);
    }

    public void disable() {
        this.noticeTimer.cancel();
    }
}
