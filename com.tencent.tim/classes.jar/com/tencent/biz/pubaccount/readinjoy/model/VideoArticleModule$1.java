package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import java.util.List;
import ljd;

public class VideoArticleModule$1
  implements Runnable
{
  public void run()
  {
    if (this.hA == null) {}
    for (List localList = ljd.a(this.this$0, this.aHH, this.val$count, this.val$time, this.akd); this.this$0.mMainThreadHandler == null; localList = this.hA) {
      return;
    }
    this.this$0.mMainThreadHandler.post(new VideoArticleModule.1.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.VideoArticleModule.1
 * JD-Core Version:    0.7.0.1
 */