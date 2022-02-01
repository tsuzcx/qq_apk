package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.b;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.Set;
import kbp;
import kct;
import kxm;
import kzc;
import muj;
import naq.d;
import naz;
import nce;
import nce.a;

public class MultiVideoReportManager$2
  implements Runnable
{
  public MultiVideoReportManager$2(naz paramnaz, VideoInfo paramVideoInfo, Activity paramActivity, int paramInt) {}
  
  public void run()
  {
    boolean bool = true;
    if ((this.a == null) || (this.val$activity == null)) {
      return;
    }
    Object localObject2 = this.a.hH;
    Object localObject3 = this.a.vid;
    Object localObject4 = this.a.Wz;
    Object localObject1;
    if ((this.a.busiType == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      if (this.val$activity.getIntent() == null) {
        break label1026;
      }
    }
    label1026:
    for (int i = this.val$activity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);; i = 0)
    {
      int j = this.val$activity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      localObject2 = new nce.a((String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4).e(this.a.algorithmID).c(this.a.strategyID).b(naz.b(this.this$0)).c(naz.a(this.this$0)).g(i).a(409409).l(this.val$position).a(Boolean.valueOf(this.a.adB)).a(this.a.videoReportInfo).e(this.a.isAD).p(kct.nd()).q(kxm.nR()).K(this.a.aHe).L(j).n(0).k(this.a.adH).m(this.a.WD).N(1);
      localObject4 = naz.a(this.this$0).f();
      i = naz.a(this.this$0).getIntent().getIntExtra("VIDEO_FROM_TYPE", -1);
      if (localObject4 != null)
      {
        localObject1 = ((VideoInfo)localObject4).Wz;
        label318:
        int k = naz.a(this.this$0).getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        ((nce.a)localObject2).v(i).g((String)localObject1).F(k).M(kzc.h(((VideoInfo)localObject4).width, ((VideoInfo)localObject4).height, ((VideoInfo)localObject4).duration));
        ((nce.a)localObject2).w(naz.a(this.this$0).getIntent().getIntExtra("key_source", -1));
        if ((this.a.busiType == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
          ((nce.a)localObject2).I(naz.a(this.this$0).getIntent().getIntExtra("VIDEO_CHAT_TYPE", 0)).J(naz.a(this.this$0).getIntent().getIntExtra("VIDEO_KANDIAN_TYPE", 0)).j(naz.a(this.this$0).getIntent().getStringExtra("VIDEO_CHAT_UIN"));
        }
        if (naz.a(this.this$0).contains(localObject3)) {
          break;
        }
        naz.a(this.this$0).add(localObject3);
        if ((TextUtils.isEmpty(this.a.WE)) || (!muj.Es())) {
          break label962;
        }
        i = 1;
        label526:
        localObject1 = ((nce.a)localObject2).S(i);
        if (!this.a.yV()) {
          break label967;
        }
        i = 2;
        label546:
        localObject1 = ((nce.a)localObject1).Y(i);
        if (!this.a.yV()) {
          break label972;
        }
        i = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.aHc;
        label575:
        localObject1 = ((nce.a)localObject1).t(i);
        if ((!this.a.yV()) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.appIconUrl)) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.appName))) {
          break label977;
        }
        i = 1;
        label627:
        localObject3 = ((nce.a)localObject1).Z(i);
        if ((!this.a.yV()) || (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h == null)) {
          break label982;
        }
        localObject1 = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h.WT;
        label673:
        localObject3 = ((nce.a)localObject3).o((String)localObject1);
        if ((!this.a.yV()) || (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.k == null)) {
          break label990;
        }
        localObject1 = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.k.WT;
        label720:
        localObject1 = ((nce.a)localObject3).p((String)localObject1);
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) {
          break label998;
        }
        label739:
        localObject3 = ((nce.a)localObject1).l(bool);
        if ((this.a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) || (this.a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.c == null)) {
          break label1004;
        }
        localObject1 = this.a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.c.WT;
        label786:
        ((nce.a)localObject3).q((String)localObject1);
        localObject3 = this.a.hH;
        if (TextUtils.isEmpty(this.a.Wz)) {
          break label1012;
        }
        localObject1 = this.a.Wz;
        label825:
        kbp.b(null, (String)localObject3, "0X8007801", "0X8007801", 0, 0, "0", "", (String)localObject1, ((nce.a)localObject2).a().toJsonString(), false);
        localObject2 = new ReportInfo.b();
        if (naz.a(this.this$0) != null) {
          ((ReportInfo.b)localObject2).aSA = naz.a(this.this$0).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        }
        localObject3 = this.a;
        if (naz.a(this.this$0).f() == null) {
          break label1020;
        }
      }
      label962:
      label967:
      label972:
      label977:
      label982:
      label990:
      label998:
      label1004:
      label1012:
      label1020:
      for (localObject1 = naz.a(this.this$0).f().Wz;; localObject1 = null)
      {
        kct.a((VideoInfo)localObject3, j, 7, -1, (ReportInfo.b)localObject2, (String)localObject1);
        return;
        localObject1 = null;
        break;
        localObject1 = "";
        break label318;
        i = 0;
        break label526;
        i = 1;
        break label546;
        i = 0;
        break label575;
        i = 0;
        break label627;
        localObject1 = "";
        break label673;
        localObject1 = "";
        break label720;
        bool = false;
        break label739;
        localObject1 = "";
        break label786;
        localObject1 = "0";
        break label825;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoReportManager.2
 * JD-Core Version:    0.7.0.1
 */