package dov.com.tencent.mobileqq.richmedia.mediacodec;

import android.media.MediaPlayer;
import java.util.TimerTask;

class AudioDecoder$BgmAudioPlayRunnable$2
  extends TimerTask
{
  AudioDecoder$BgmAudioPlayRunnable$2(AudioDecoder.BgmAudioPlayRunnable paramBgmAudioPlayRunnable) {}
  
  public void run()
  {
    if ((this.b.mediaPlayer != null) && (this.b.mediaPlayer.isPlaying())) {
      this.b.mediaPlayer.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.BgmAudioPlayRunnable.2
 * JD-Core Version:    0.7.0.1
 */