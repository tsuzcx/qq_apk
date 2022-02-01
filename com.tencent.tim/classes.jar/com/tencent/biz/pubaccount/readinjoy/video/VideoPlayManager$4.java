package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.b;
import jzk;
import kbp;
import kct;
import kku.a;
import knd;
import kxm;
import mhu;
import mst;
import muj;
import mye;
import mye.b;
import myp;
import nce;
import nce.a;
import ndi;

public class VideoPlayManager$4
  implements Runnable
{
  public VideoPlayManager$4(mye parammye, mye.b paramb, myp parammyp) {}
  
  public void run()
  {
    if (this.h == null) {
      return;
    }
    Activity localActivity = mye.a(this.this$0);
    int j = 0;
    int i = j;
    if (localActivity != null)
    {
      i = j;
      if (localActivity.getIntent() != null) {
        i = localActivity.getIntent().getIntExtra("channel_from", -1);
      }
    }
    Object localObject = new nce.a(null, this.h.puin, this.h.videoVid, this.h.akK).c(this.h.videoDuration * 1000).d(this.h.c.playDuration).a((int)this.h.channelId).e(this.h.algorithmID).c(this.h.strategyId).a(this.c, this.h.articleID).a(this.c).d(kxm.dE(this.h.puin)).g(kct.aHF).e(mye.a(this.this$0)).c(mye.a(this.this$0)).a(this.h.xb).a(Boolean.valueOf(kxm.F(this.h.d))).a(this.h.d.videoReportInfo).A(this.h.c.aSq).B(this.h.c.aSr).C(this.h.c.videoWidth).D(this.h.c.videoHeight).O(i).b(this.h.d).d(this.h.d).a(this.h.d, false).h(this.h.d.innerUniqueID).W(kxm.a(this.h.d));
    i = ndi.k((ArticleInfo)this.h.d);
    label382:
    String str2;
    if (6 == i)
    {
      ((nce.a)localObject).ac(muj.pQ());
      str2 = ((nce.a)localObject).a().toJsonString();
      if ((localActivity == null) || (localActivity.getIntent() == null)) {
        break label999;
      }
    }
    label463:
    label977:
    label983:
    label991:
    label999:
    for (long l = localActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);; l = 0L)
    {
      localObject = new ReportInfo.b();
      ((ReportInfo.b)localObject).aSC = ((int)this.h.xb);
      ((ReportInfo.b)localObject).videoDuration = (this.h.videoDuration * 1000);
      boolean bool;
      label501:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((ReportInfo.b)localObject).aSB = i;
        if (mye.a(this.this$0) != null)
        {
          ((ReportInfo.b)localObject).amK = true;
          if (mye.a(this.this$0).nW()) {
            break label977;
          }
          bool = true;
          ((ReportInfo.b)localObject).amJ = bool;
        }
        kct.a(this.h.d, (int)this.h.channelId, 12, this.h.c.playDuration, (ReportInfo.b)localObject);
        str3 = this.h.puin;
        if (this.h.articleID != l) {
          break label983;
        }
        localObject = "1";
        if (TextUtils.isEmpty(this.h.akK)) {
          break label991;
        }
      }
      for (String str1 = this.h.akK;; str1 = "0")
      {
        kbp.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        kbp.d("0X8007408", this.h.puin, "", "", "", str2);
        this.h.c.playDuration = 0L;
        localObject = this.h.d;
        if ((localObject != null) && (((BaseArticleInfo)localObject).mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject))) {
          jzk.a(new kku.a().a(localActivity).a(jzk.aEO).b(jzk.aFx).a((AdvertisementInfo)localObject).a(jzk.a(((AdvertisementInfo)localObject).adbt, (int)this.h.xb, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, jzk.aGs, 0)).a());
        }
        if ((localObject == null) || (!knd.dh((int)((BaseArticleInfo)localObject).mChannelID)) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) || (!this.h.aqp)) {
          break;
        }
        jzk.a(new kku.a().a(localActivity).a(jzk.aEO).b(jzk.aFB).a((AdvertisementInfo)localObject).a(jzk.a(((AdvertisementInfo)localObject).adbt, (int)this.h.xb, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, 1, 0)).a());
        return;
        if (118 == i)
        {
          ((nce.a)localObject).ac(muj.pO());
          ((nce.a)localObject).b(this.h.d.mVideoColumnInfo);
          break label382;
        }
        if (128 != i) {
          break label382;
        }
        ((nce.a)localObject).ac(muj.pS());
        ((nce.a)localObject).b(this.h.d.mSimpleVideoColumnInfo);
        break label382;
        i = 2;
        break label463;
        bool = false;
        break label501;
        localObject = "2";
        break label566;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.4
 * JD-Core Version:    0.7.0.1
 */