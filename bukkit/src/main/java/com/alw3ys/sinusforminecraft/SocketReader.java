package com.alw3ys.sinusforminecraft;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
class SocketReader implements Runnable {

    private final SinusForMinecraftPlugin plugin;
    private final Socket socket;

    @Override
    public void run() {
        try {
            int read;
            byte[] bytes = new byte[1024];
            byte[] readData;
            while ((read = socket.getInputStream().read(bytes)) > -1) {
                readData = new byte[read];
                System.arraycopy(bytes, 0, readData, 0, read);
                String receivedString = new String(readData, StandardCharsets.UTF_8);
                TrackManager.Track track = plugin.getTrackUtils().getTrackFromJSONString(receivedString);
                plugin.getTrackUtils().updateLastTrack(track);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}