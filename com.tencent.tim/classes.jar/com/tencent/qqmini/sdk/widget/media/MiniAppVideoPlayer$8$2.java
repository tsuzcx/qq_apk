package com.tencent.qqmini.sdk.widget.media;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

class MiniAppVideoPlayer$8$2
  implements Runnable
{
  MiniAppVideoPlayer$8$2(MiniAppVideoPlayer.8 param8) {}
  
  public void run()
  {
    if (this.this$1.this$0.showCenterPlayBtn) {
      MiniAppVideoPlayer.access$3800(this.this$1.this$0).setVisibility(0);
    }
    for (;;)
    {
      MiniAppVideoPlayer.access$1100(this.this$1.this$0).setVisibility(8);
      MiniAppVideoPlayer.access$3900(this.this$1.this$0).removeMessages(2002);
      return;
      MiniAppVideoPlayer.access$3800(this.this$1.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.8.2
 * JD-Core Version:    0.7.0.1
 */