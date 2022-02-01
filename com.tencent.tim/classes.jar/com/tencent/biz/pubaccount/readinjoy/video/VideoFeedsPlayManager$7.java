package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.common.app.BaseApplicationImpl;
import kbx;
import kxm;
import mhu;

class VideoFeedsPlayManager$7
  implements Runnable
{
  VideoFeedsPlayManager$7(VideoFeedsPlayManager paramVideoFeedsPlayManager, mhu parammhu) {}
  
  public void run()
  {
    kxm.a(BaseApplicationImpl.getContext(), kxm.getAccount(), true, this.b.u());
    kbx.a(this.b);
    kxm.a(this.b.success, this.b.aiJ, this.b.videoFormat, this.b.busiType, this.b.vt, 409409, this.b.errCode, this.b.rowkey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.7
 * JD-Core Version:    0.7.0.1
 */