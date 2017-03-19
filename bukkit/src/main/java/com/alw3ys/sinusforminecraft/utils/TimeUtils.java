package com.alw3ys.sinusforminecraft.utils;

import java.util.concurrent.TimeUnit;

public class TimeUtils {

    public static String getTimeFormat(final long time) {
        final String format = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(time),
                TimeUnit.MILLISECONDS.toMinutes(time) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(time) % TimeUnit.MINUTES.toSeconds(1));
        return time < 3600000 ? format.substring(3) : format;
    }
}