package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo.a;

class VideoFeedsUGView$9
  implements Runnable
{
  VideoFeedsUGView$9(VideoFeedsUGView paramVideoFeedsUGView, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.c == null) || (TextUtils.isEmpty(this.this$0.c.XI)) || (!this.this$0.c.XI.equals(this.val$packageName))) {
      return;
    }
    this.this$0.sn.setVisibility(8);
    this.this$0.kf.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView.9
 * JD-Core Version:    0.7.0.1
 */