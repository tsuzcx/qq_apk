package com.tencent.qqmini.minigame.webaudio;

import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;

class WebAudioManager$4
  implements Runnable
{
  WebAudioManager$4(WebAudioManager paramWebAudioManager, int paramInt) {}
  
  public void run()
  {
    if (WebAudioManager.access$000(this.this$0) != null) {
      WebAudioManager.access$000(this.this$0).stopSource(this.val$sourceId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.webaudio.WebAudioManager.4
 * JD-Core Version:    0.7.0.1
 */