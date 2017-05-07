package com.alw3ys.sinusforminecraft;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class TrackManager {

    @Setter @Getter
    private static Track currentTrack;

    @RequiredArgsConstructor @Getter
    public static class Track {
        private final String artist;
        private final String title;
        private final Long duration;
    }
}