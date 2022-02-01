package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import psx;
import qrz;
import qrz.b;
import qvi;
import ram;

public class VideoListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((qvi)psx.a(12)).a(qrz.a(this.this$0), qrz.a(this.this$0));
    qrz.b localb = new qrz.b(new ErrorMessage(), qrz.a(this.this$0));
    localb.aCv = false;
    localb.aCu = true;
    localb.isFirstPage = true;
    localb.isEnd = true;
    if (??? != null) {
      localb.oj = ((FeedVideoInfo)???).mVideoItemList;
    }
    synchronized (this.this$0)
    {
      if (!this.this$0.aCy)
      {
        qrz.a(this.this$0, localb);
        ram.b("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from cache: %s", localb);
        return;
      }
      ram.w("Q.qqstory.home.data:VideoListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */