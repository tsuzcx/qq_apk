package com.tencent.av;

import android.content.Context;
import android.media.AudioManager;
import iiv;

class VideoController$20
  implements Runnable
{
  VideoController$20(VideoController paramVideoController) {}
  
  public void run()
  {
    if (this.this$0.b().QB) {
      ((AudioManager)this.this$0.appContext.getSystemService("audio")).setSpeakerphoneOn(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.20
 * JD-Core Version:    0.7.0.1
 */