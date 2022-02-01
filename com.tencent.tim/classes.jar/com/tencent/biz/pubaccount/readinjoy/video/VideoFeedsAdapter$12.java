package com.tencent.biz.pubaccount.readinjoy.video;

import mrx;
import mtg;
import mtg.g;
import mwe;

public class VideoFeedsAdapter$12
  implements Runnable
{
  public VideoFeedsAdapter$12(mtg parammtg, boolean paramBoolean) {}
  
  public void run()
  {
    if ((mtg.a(this.this$0) != null) && (mtg.a(this.this$0).a != null)) {
      mtg.a(this.this$0).a.oa(this.tq);
    }
    if (!this.tq)
    {
      mtg.a(this.this$0).pause();
      this.this$0.aRZ();
    }
    while ((mtg.a(this.this$0).isPlaying()) || (mtg.a(this.this$0) == null)) {
      return;
    }
    mtg.a(this.this$0).aTi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.12
 * JD-Core Version:    0.7.0.1
 */