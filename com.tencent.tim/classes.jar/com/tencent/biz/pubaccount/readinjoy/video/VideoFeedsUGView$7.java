package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo.a;
import com.tencent.open.downloadnew.DownloadInfo;

class VideoFeedsUGView$7
  implements Runnable
{
  VideoFeedsUGView$7(VideoFeedsUGView paramVideoFeedsUGView, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if ((this.this$0.c != null) && (!TextUtils.isEmpty(this.this$0.c.XE)) && (this.this$0.c.XE.equals(this.a.urlStr)))
    {
      this.this$0.sn.setVisibility(0);
      this.this$0.kf.setVisibility(8);
      this.this$0.sn.setText(this.this$0.c.XK);
      this.this$0.mProgress = this.a.progress;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView.7
 * JD-Core Version:    0.7.0.1
 */