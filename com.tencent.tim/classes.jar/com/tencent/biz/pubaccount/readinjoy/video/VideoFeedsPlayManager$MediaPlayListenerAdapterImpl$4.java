package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.ArrayList;
import java.util.Iterator;
import msa;

class VideoFeedsPlayManager$MediaPlayListenerAdapterImpl$4
  implements Runnable
{
  VideoFeedsPlayManager$MediaPlayListenerAdapterImpl$4(VideoFeedsPlayManager.a parama) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.b(this.b.this$0) != null) && (VideoFeedsPlayManager.b(this.b.this$0).a != null)) {
      VideoFeedsPlayManager.b(this.b.this$0).a.k(VideoFeedsPlayManager.b(this.b.this$0));
    }
    if (VideoFeedsPlayManager.a(this.b.this$0) != null)
    {
      Iterator localIterator = VideoFeedsPlayManager.a(this.b.this$0).iterator();
      while (localIterator.hasNext()) {
        ((VideoFeedsPlayManager.d)localIterator.next()).r(VideoFeedsPlayManager.b(this.b.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.4
 * JD-Core Version:    0.7.0.1
 */