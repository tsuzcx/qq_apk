package com.tencent.mobileqq.msf.core.c;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class h
  implements MediaPlayer.OnCompletionListener
{
  h(e parame) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    this.a.H = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.h
 * JD-Core Version:    0.7.0.1
 */