package com.tencent.biz.pubaccount.readinjoy.video;

import android.graphics.Color;
import android.widget.TextView;
import knc;
import mtg.l;
import mud;

public class VideoFeedsGameAdComManager$1
  implements Runnable
{
  public VideoFeedsGameAdComManager$1(mud parammud) {}
  
  public void run()
  {
    if ((mud.a(this.this$0) != null) && (mud.a(this.this$0).rW != null))
    {
      mud.a(this.this$0).rW.setTextColor(Color.parseColor("#262626"));
      if (knc.zR()) {
        mud.a(this.this$0).rW.setTextColor(Color.parseColor("#80000000"));
      }
      mud.a(this.this$0).rW.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      mud.a(this.this$0).rW.setClickable(false);
      mud.a(this.this$0).rW.setClickable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.1
 * JD-Core Version:    0.7.0.1
 */