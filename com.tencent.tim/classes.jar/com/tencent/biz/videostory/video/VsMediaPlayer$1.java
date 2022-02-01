package com.tencent.biz.videostory.video;

import android.media.MediaPlayer;
import java.util.TimerTask;
import sqx;
import srl;

public class VsMediaPlayer$1
  extends TimerTask
{
  public VsMediaPlayer$1(sqx paramsqx) {}
  
  public void run()
  {
    sqx.a(this.this$0, sqx.a(this.this$0) + 1000);
    if (sqx.a(this.this$0) != null) {
      srl.a().fx(sqx.a(this.this$0).getCurrentPosition());
    }
    if ((sqx.a(this.this$0) != null) && (sqx.b(this.this$0) != -1) && (sqx.a(this.this$0) >= sqx.b(this.this$0))) {
      sqx.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.VsMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */