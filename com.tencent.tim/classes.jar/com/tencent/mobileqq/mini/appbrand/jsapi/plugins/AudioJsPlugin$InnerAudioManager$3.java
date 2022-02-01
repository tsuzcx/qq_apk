package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.widget.media.MiniAppAudioPlayer;

class AudioJsPlugin$InnerAudioManager$3
  implements Runnable
{
  AudioJsPlugin$InnerAudioManager$3(AudioJsPlugin.InnerAudioManager paramInnerAudioManager, int paramInt) {}
  
  public void run()
  {
    if (AudioJsPlugin.InnerAudioManager.access$1600(this.this$1) != null) {
      AudioJsPlugin.InnerAudioManager.access$1600(this.this$1).seekTo(this.val$mSec);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AudioJsPlugin.InnerAudioManager.3
 * JD-Core Version:    0.7.0.1
 */