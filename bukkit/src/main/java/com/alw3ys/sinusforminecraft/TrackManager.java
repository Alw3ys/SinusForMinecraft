package com.alw3ys.sinusforminecraft;

import lombok.Getter;
import lombok.Setter;

public class TrackManager {

    @Setter @Getter
    private static Track currentTrack;

    @Getter
    public static class Track {
        private final String artist;
        private final String title;
        private final Long duration;

        public Track(String artist, String title, long duration) {
            this.artist = artist;
            this.title = title;
            this.duration = duration;
        }
    }
}