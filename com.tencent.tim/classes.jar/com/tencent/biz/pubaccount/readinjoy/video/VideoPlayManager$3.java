package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import kxv;
import msc;
import mst;
import msv;
import mye;
import mye.b;
import myg;
import myi;
import ocp;

public class VideoPlayManager$3
  implements Runnable
{
  public VideoPlayManager$3(mye parammye, mye.b paramb, myi parammyi) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "executed On SubThread, busitype:" + this.i.aDs + " vid:" + this.i.videoVid);
    }
    if ((mye.a(this.this$0) == null) || (mye.a(this.this$0) != this.c)) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(this.i.videoVid)) {
        break;
      }
    } while (mye.a(this.this$0) == null);
    mye.a(this.this$0).a(this.c, 101, 61, 0, "vid null", null);
    return;
    if ((this.i.aDs == 2) || (this.i.aDs == 6))
    {
      kxv localkxv = kxv.a();
      localkxv.a(this.i.videoVid, "PubAccountArticleCenter.GetUrlByVid", new myg(this, localkxv));
    }
    for (;;)
    {
      if (mye.a(this.this$0) != null)
      {
        this.c.aqr = mye.a(this.this$0).I(this.i.ahw, this.i.videoVid);
        mye.a(this.this$0).ak(this.i.videoVid, this.c.aqr);
      }
      ocp.e(this.i.akK, this.i.videoVid, 0, 0);
      if (mye.a(this.this$0) != null) {
        msv.a().setAutoPlay(mye.a(this.this$0).nW());
      }
      msv.a().su(this.i.position);
      return;
      if ((AdvertisementInfo.isAdvertisementInfo(this.i.d)) && (this.i.d != null) && (!TextUtils.isEmpty(this.i.d.mVideoVid)) && ((this.i.d.mVideoVid.startsWith("http://")) || (this.i.d.mVideoVid.startsWith("https://"))))
      {
        ((AdvertisementInfo)this.i.d).adbt = ((int)this.i.xb);
        if (this.i.xb == 0L)
        {
          ((AdvertisementInfo)this.i.d).adpa = 1;
          ((AdvertisementInfo)this.i.d).adpb = 1;
        }
        this.c.a("", this.i.d.mVideoVid, 101, this.i.xb, this.i.fileSize, this.i.videoDuration);
      }
      else
      {
        this.c.e(this.i.videoVid, 1, this.i.xb);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.3
 * JD-Core Version:    0.7.0.1
 */