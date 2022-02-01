package com.tencent.tav.player;

import android.media.AudioManager.OnAudioFocusChangeListener;

class AudioFocusHelper$1
  implements AudioManager.OnAudioFocusChangeListener
{
  AudioFocusHelper$1(AudioFocusHelper paramAudioFocusHelper) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (AudioFocusHelper.access$000(this.this$0) == null) {
      return;
    }
    switch (paramInt)
    {
    case -3: 
    case 0: 
    default: 
      return;
    }
    try
    {
      AudioFocusHelper.access$200(this.this$0, true);
      return;
    }
    catch (Exception localException) {}
    AudioFocusHelper.access$102(this.this$0, true);
    return;
    AudioFocusHelper.access$200(this.this$0, false);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tav.player.AudioFocusHelper.1
 * JD-Core Version:    0.7.0.1
 */