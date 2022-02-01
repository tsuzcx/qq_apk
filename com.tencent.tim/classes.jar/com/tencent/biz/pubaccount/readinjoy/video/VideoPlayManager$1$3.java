package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.b;
import kbp;
import kct;
import kxm;
import mhu;
import mst;
import muj;
import mye;
import mye.b;
import myf;
import myp;
import nce;
import nce.a;

public class VideoPlayManager$1$3
  implements Runnable
{
  public VideoPlayManager$1$3(myf parammyf, mye.b paramb, myp parammyp) {}
  
  public void run()
  {
    if (this.h == null) {
      return;
    }
    int j = 0;
    int i = j;
    if (mye.a(this.a.this$0) != null)
    {
      i = j;
      if (mye.a(this.a.this$0).getIntent() != null) {
        i = mye.a(this.a.this$0).getIntent().getIntExtra("channel_from", -1);
      }
    }
    String str2 = new nce.a(null, this.h.puin, this.h.videoVid, this.h.akK).c(this.h.videoDuration * 1000).d(this.h.c.playDuration).a((int)this.h.channelId).e(this.h.algorithmID).c(this.h.strategyId).a(this.c, this.h.articleID).a(this.c).d(kxm.dE(this.h.puin)).e(mye.a(this.a.this$0)).g(kct.aHF).c(mye.a(this.a.this$0)).a(this.h.videoDuration * 1000).a(Boolean.valueOf(kxm.F(this.h.d))).a(this.h.d.videoReportInfo).A(this.h.c.aSq).B(this.h.c.aSr).C(this.h.c.videoWidth).D(this.h.c.videoHeight).O(i).b(this.h.d).c(this.h.d).d(this.h.d).a(this.h.d, true).ac(muj.pQ()).W(kxm.a(this.h.d)).a().toJsonString();
    if ((mye.a(this.a.this$0) != null) && (mye.a(this.a.this$0).getIntent() != null)) {}
    for (long l = mye.a(this.a.this$0).getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);; l = 0L)
    {
      Object localObject = new ReportInfo.b();
      ((ReportInfo.b)localObject).aSC = (this.h.videoDuration * 1000);
      ((ReportInfo.b)localObject).videoDuration = (this.h.videoDuration * 1000);
      boolean bool;
      label527:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((ReportInfo.b)localObject).aSB = i;
        if (mye.a(this.a.this$0) != null)
        {
          ((ReportInfo.b)localObject).amK = true;
          if (mye.a(this.a.this$0).nW()) {
            break label655;
          }
          bool = true;
          ((ReportInfo.b)localObject).amJ = bool;
        }
        kct.a(this.h.d, (int)this.h.channelId, 12, this.h.c.playDuration, (ReportInfo.b)localObject);
        str3 = this.h.puin;
        if (this.h.articleID != l) {
          break label661;
        }
        localObject = "1";
        label592:
        if (TextUtils.isEmpty(this.h.akK)) {
          break label669;
        }
      }
      label655:
      label661:
      label669:
      for (String str1 = this.h.akK;; str1 = "0")
      {
        kbp.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        this.h.c.playDuration = 0L;
        return;
        i = 2;
        break;
        bool = false;
        break label527;
        localObject = "2";
        break label592;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.3
 * JD-Core Version:    0.7.0.1
 */