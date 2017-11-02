package bg.devlabs.fullscreenvideoview;

import android.media.MediaPlayer;

/**
 * Created by Slavi Petrov on 20.10.2017
 * Dev Labs
 * slavi@devlabs.bg
 */
class VideoMediaPlayer extends MediaPlayer {
    private FullscreenVideoView fullscreenVideoView;
    private boolean isAutoStartEnabled;
    private boolean canPause = true;
    private boolean canSeekBackward = true;
    private boolean canSeekForward = true;

    VideoMediaPlayer(FullscreenVideoView fullscreenVideoView) {
        super();
        this.fullscreenVideoView = fullscreenVideoView;
    }

    static int getBufferPercentage() {
        return 0;
    }

    boolean canPause() {
        return canPause;
    }

    boolean canSeekBackward() {
        return canSeekBackward;
    }

    boolean canSeekForward() {
        return canSeekForward;
    }

    void toggleFullScreen() {
        fullscreenVideoView.toggleFullscreen();
    }

    void onPauseResume() {
        if (isPlaying()) {
            pause();
        } else {
            start();
        }
    }

    void onDetach() {
        fullscreenVideoView = null;
        setOnPreparedListener(null);
        stop();
        release();
    }

    public boolean isAutoStartEnabled() {
        return isAutoStartEnabled;
    }

    public void setAutoStartEnabled(boolean autoStartEnabled) {
        isAutoStartEnabled = autoStartEnabled;
    }

    public void setCanPause(boolean canPause) {
        this.canPause = canPause;
    }

    public void setCanSeekBackward(boolean canSeekBackward) {
        this.canSeekBackward = canSeekBackward;
    }

    public void setCanSeekForward(boolean canSeekForward) {
        this.canSeekForward = canSeekForward;
    }
}