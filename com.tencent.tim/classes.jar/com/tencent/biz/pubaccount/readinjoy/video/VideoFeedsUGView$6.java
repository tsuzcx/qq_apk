package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo.a;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

class VideoFeedsUGView$6
  implements Runnable
{
  VideoFeedsUGView$6(VideoFeedsUGView paramVideoFeedsUGView, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.bD.iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
      if ((this.this$0.c != null) && (!TextUtils.isEmpty(this.this$0.c.XE)) && (this.this$0.c.XE.equals(localDownloadInfo.urlStr)))
      {
        this.this$0.sn.setVisibility(0);
        this.this$0.kf.setVisibility(8);
        if ((localDownloadInfo.progress >= 0) && (localDownloadInfo.progress <= 100))
        {
          this.this$0.sn.setText(this.this$0.c.XJ + localDownloadInfo.progress + "%");
          this.this$0.mProgress = localDownloadInfo.progress;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView.6
 * JD-Core Version:    0.7.0.1
 */