package com.tencent.moai.nativepages.view;

import android.media.MediaPlayer;
import com.tencent.moai.nativepages.util.Threads;
import java.util.TimerTask;

class VideoPlayer$1
  extends TimerTask
{
  VideoPlayer$1(VideoPlayer paramVideoPlayer) {}
  
  public void run()
  {
    if ((VideoPlayer.access$000(this.this$0)) || (VideoPlayer.access$100(this.this$0) == null)) {}
    for (;;)
    {
      return;
      try
      {
        long l = VideoPlayer.access$100(this.this$0).getCurrentPosition();
        if (VideoPlayer.access$200(this.this$0) != null)
        {
          Threads.runOnMainThread(new VideoPlayer.1.1(this, l));
          return;
        }
      }
      catch (IllegalStateException localIllegalStateException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.view.VideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */