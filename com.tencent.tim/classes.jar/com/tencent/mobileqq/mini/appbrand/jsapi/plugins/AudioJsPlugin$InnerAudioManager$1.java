package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.widget.media.MiniAppAudioPlayer;
import com.tencent.mobileqq.mini.widget.media.MiniAppAudioPlayer.OnPreparedListener;

class AudioJsPlugin$InnerAudioManager$1
  implements MiniAppAudioPlayer.OnPreparedListener
{
  AudioJsPlugin$InnerAudioManager$1(AudioJsPlugin.InnerAudioManager paramInnerAudioManager, boolean paramBoolean1, boolean paramBoolean2, double paramDouble) {}
  
  public void onPrepared()
  {
    MiniAppAudioPlayer localMiniAppAudioPlayer;
    if ((this.val$autoPlay) && (AudioJsPlugin.InnerAudioManager.access$1600(this.this$1) != null))
    {
      AudioJsPlugin.InnerAudioManager.access$1600(this.this$1).setLooping(this.val$loop);
      AudioJsPlugin.InnerAudioManager.access$1600(this.this$1).setVolume((float)this.val$volume);
      localMiniAppAudioPlayer = AudioJsPlugin.InnerAudioManager.access$1600(this.this$1);
      if (AudioJsPlugin.access$1700()) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      localMiniAppAudioPlayer.setAudioFocus(bool);
      AudioJsPlugin.InnerAudioManager.access$1600(this.this$1).start();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AudioJsPlugin.InnerAudioManager.1
 * JD-Core Version:    0.7.0.1
 */