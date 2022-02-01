package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.ArrayList;
import java.util.Iterator;
import msa;
import mvw;

public class VideoFeedsPlayManager$1$1
  implements Runnable
{
  public VideoFeedsPlayManager$1$1(mvw parammvw) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.b(this.a.this$0) != null) && (VideoFeedsPlayManager.b(this.a.this$0).a != null)) {
      VideoFeedsPlayManager.b(this.a.this$0).a.k(VideoFeedsPlayManager.b(this.a.this$0));
    }
    if (VideoFeedsPlayManager.a(this.a.this$0) != null)
    {
      Iterator localIterator = VideoFeedsPlayManager.a(this.a.this$0).iterator();
      while (localIterator.hasNext()) {
        ((VideoFeedsPlayManager.d)localIterator.next()).r(VideoFeedsPlayManager.b(this.a.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.1.1
 * JD-Core Version:    0.7.0.1
 */