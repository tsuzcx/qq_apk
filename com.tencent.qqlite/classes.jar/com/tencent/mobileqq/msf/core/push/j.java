package com.tencent.mobileqq.msf.core.push;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class j
  implements MediaPlayer.OnCompletionListener
{
  j(f paramf) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    this.a.J = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.j
 * JD-Core Version:    0.7.0.1
 */