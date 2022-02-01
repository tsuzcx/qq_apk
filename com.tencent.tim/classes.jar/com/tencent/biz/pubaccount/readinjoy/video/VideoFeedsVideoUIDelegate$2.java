package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import mtg.g;
import mxy;
import nca;
import ncb;

public class VideoFeedsVideoUIDelegate$2
  implements Runnable
{
  public VideoFeedsVideoUIDelegate$2(mxy parammxy, String paramString, VideoFeedsPlayManager.b paramb) {}
  
  public void run()
  {
    QLog.d("VideoFeedsVideoUIDelegate", 2, "onVideoError playButton setVisibility GONE");
    mxy.a(this.this$0, false);
    this.this$0.h.jO.clearAnimation();
    this.this$0.h.jO.setVisibility(8);
    this.this$0.h.bg.setVisibility(0);
    this.this$0.h.a.l(1, this.val$msg, "点击重试");
    ncb.aP(this.g.d.Wz, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate.2
 * JD-Core Version:    0.7.0.1
 */