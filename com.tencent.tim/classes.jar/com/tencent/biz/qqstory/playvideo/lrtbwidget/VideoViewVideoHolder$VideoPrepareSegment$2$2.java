package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import com.tencent.biz.qqstory.base.ErrorMessage;
import qkp;
import ram;

public class VideoViewVideoHolder$VideoPrepareSegment$2$2
  implements Runnable
{
  public void run()
  {
    ram.e(this.a.a.this$0.TAG, "onError, setOnDownloadListener [vid, url, errorCode=%d]", new Object[] { Integer.valueOf(this.val$errorCode) });
    VideoViewVideoHolder.c(this.a.a.this$0, 10);
    VideoViewVideoHolder.a(this.a.a.this$0, false);
    VideoViewVideoHolder.b(this.a.a.this$0, this.val$errorCode);
    this.a.a.this$0.aK(8, "download error");
    VideoViewVideoHolder.i.a(this.a.a, new ErrorMessage(this.val$errorCode, "download error"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.2
 * JD-Core Version:    0.7.0.1
 */