package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.SystemClock;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import psu;
import psx;
import qjq;

class VideoViewVideoHolder$VideoInfoSegment$1
  implements Runnable
{
  VideoViewVideoHolder$VideoInfoSegment$1(VideoViewVideoHolder.h paramh) {}
  
  public void run()
  {
    if (this.a.isCanceled()) {
      return;
    }
    VideoViewVideoHolder.a(this.a.this$0, "VI", SystemClock.uptimeMillis());
    if (!this.a.this$0.JN())
    {
      VideoViewVideoHolder.h.a(this.a, new ErrorMessage(-1, "already unBind"));
      return;
    }
    StoryVideoItem localStoryVideoItem = ((psu)psx.a(5)).b(this.a.this$0.a.vid);
    VideoViewVideoHolder.h.a(this.a, localStoryVideoItem, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoInfoSegment.1
 * JD-Core Version:    0.7.0.1
 */