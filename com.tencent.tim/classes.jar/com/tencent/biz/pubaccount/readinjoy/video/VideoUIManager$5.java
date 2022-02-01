package com.tencent.biz.pubaccount.readinjoy.video;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import mye.b;
import mza;
import nca;
import ncb;

public class VideoUIManager$5
  implements Runnable
{
  public void run()
  {
    mza.a(this.this$0).setVisibility(8);
    mza.h(this.this$0);
    mza.a(this.this$0).setVisibility(8);
    mza.a(this.this$0).setVisibility(8);
    mza.b(this.this$0).setVisibility(8);
    if (this.aBm == 1) {
      mza.i(this.this$0);
    }
    mza.a(this.this$0).l(this.aBm, this.val$msg, this.akR);
    if (this.aBm == 1) {
      ncb.aP(mza.a(this.this$0).getInnerUniqueID(), 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.5
 * JD-Core Version:    0.7.0.1
 */