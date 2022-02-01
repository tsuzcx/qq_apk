package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;
import pmq;
import pnh;
import psx;
import qkp;
import ram;
import rar;

public class VideoViewVideoHolder$VideoPrepareSegment$2$1
  implements Runnable
{
  public void run()
  {
    ram.d(this.a.a.this$0.TAG, "onSuccess, [vid, url, fileCache] = ");
    pmq localpmq = (pmq)psx.a(28);
    String str = pnh.h(new File(this.a.axJ));
    if (!TextUtils.isEmpty(str)) {
      pnh.a(this.a.val$storyVideoItem, str, 0, rar.getNetworkType(BaseApplicationImpl.getContext()));
    }
    localpmq.bg(this.val$vid, 0);
    localpmq.bf(this.val$vid, 0);
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoPrepareSegment.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.1
 * JD-Core Version:    0.7.0.1
 */