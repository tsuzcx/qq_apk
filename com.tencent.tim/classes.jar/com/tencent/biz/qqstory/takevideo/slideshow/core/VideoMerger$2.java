package com.tencent.biz.qqstory.takevideo.slideshow.core;

import acfp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import rar;
import rmn;
import rmn.a;

public class VideoMerger$2
  implements Runnable
{
  public VideoMerger$2(rmn paramrmn, rmn.a parama) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMerger", 2, "merge video failed");
    }
    rar.g("actAlbumResult", new String[] { "99" });
    QQToast.a(this.a.mContext, acfp.m(2131716422), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.2
 * JD-Core Version:    0.7.0.1
 */