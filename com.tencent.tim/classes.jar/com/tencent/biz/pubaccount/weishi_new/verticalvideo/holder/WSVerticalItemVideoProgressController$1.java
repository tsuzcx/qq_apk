package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.res.Resources;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import ooz;
import ory;

public class WSVerticalItemVideoProgressController$1
  implements Runnable
{
  public WSVerticalItemVideoProgressController$1(ory paramory) {}
  
  public void run()
  {
    try
    {
      if (ory.a(this.this$0) != null) {
        ory.a(this.this$0).setThumb(ory.a(this.this$0).getDrawable(2130842637));
      }
      return;
    }
    catch (Exception localException)
    {
      ooz.e("WS_VIDEO_seekBar", "seekBar un active runnable error:" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController.1
 * JD-Core Version:    0.7.0.1
 */