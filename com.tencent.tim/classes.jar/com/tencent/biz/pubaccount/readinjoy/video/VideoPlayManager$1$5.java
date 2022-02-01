package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import jzk;
import kbx;
import kku.a;
import knd;
import kxm;
import mhu;
import mye;
import mye.b;
import myf;
import myi;

public class VideoPlayManager$1$5
  implements Runnable
{
  public VideoPlayManager$1$5(myf parammyf, int paramInt1, int paramInt2, String paramString, myi parammyi) {}
  
  public void run()
  {
    if (mye.a(this.a.this$0) != null)
    {
      int i = this.val$model;
      int j = this.val$what;
      mye.a(this.a.this$0, mye.a(this.a.this$0), mye.a(this.a.this$0), 6, new int[] { i, j });
      mye.a(this.a.this$0).c.errCode = (this.val$model + ":" + this.val$what);
      mye.a(this.a.this$0).c.errDetailInfo = this.akJ;
      mye.a(this.a.this$0).c.playDuration = 0L;
      mye.a(this.a.this$0).c.success = false;
      mye.a(this.a.this$0).c.vD = this.c.dd();
      mye.a(this.a.this$0).c.secondBufferCount = this.c.qf();
      mye.a(this.a.this$0).c.videoFormat = this.c.qg();
      mye.a(this.a.this$0).c.amD = this.c.aqr;
      mye.a(this.a.this$0).c.mFileSize = this.c.mFileSize;
      mye.a(this.a.this$0).c.vF = this.c.vF;
      mye.a(this.a.this$0).c.vG = this.c.df();
      mye.a(this.a.this$0).c.vH = this.c.qh();
      mye.a(this.a.this$0).c.ahx = this.c.ky();
      mye.a(this.a.this$0).c.vJ = this.c.dh();
      mye.a(this.a.this$0).c.vK = this.c.dg();
      mye.a(this.a.this$0, mye.a(this.a.this$0));
      kxm.a(mye.a(this.a.this$0).getApplicationContext(), kxm.getAccount(), false, mye.a(this.a.this$0).c.u());
      kbx.a(mye.a(this.a.this$0).c);
      kxm.a(false, mye.a(this.a.this$0).c.aiJ, mye.a(this.a.this$0).c.videoFormat, mye.a(this.a.this$0).c.busiType, mye.a(this.a.this$0).c.vt, 56, mye.a(this.a.this$0).c.errCode, mye.a(this.a.this$0).c.rowkey);
      BaseArticleInfo localBaseArticleInfo = mye.a(this.a.this$0).d;
      if ((localBaseArticleInfo != null) && (knd.dh((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && (mye.a(this.a.this$0).aqp))
      {
        i = (int)mye.a(this.a.this$0).c(true);
        jzk.a(new kku.a().a(mye.a(this.a.this$0)).a(jzk.aEO).b(jzk.aFB).a((AdvertisementInfo)localBaseArticleInfo).a(jzk.a(0, i, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration, 1, 2)).a());
      }
      localBaseArticleInfo = mye.a(this.a.this$0).d;
      if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))) {
        jzk.a(new kku.a().a(mye.a(this.a.this$0)).a(jzk.aEO).b(jzk.aFx).a((AdvertisementInfo)localBaseArticleInfo).a(jzk.a(0, 0, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration, jzk.aGs, 2)).a());
      }
    }
    mye.c(this.a.this$0, null);
    mye.a(this.a.this$0, null);
    this.c.destory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.5
 * JD-Core Version:    0.7.0.1
 */