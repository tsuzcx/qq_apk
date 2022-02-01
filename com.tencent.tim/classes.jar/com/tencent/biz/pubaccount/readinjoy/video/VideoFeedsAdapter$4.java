package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import kbp;
import kzc;
import mst;
import mtg;
import mtg.g;
import nce;
import nce.a;

public class VideoFeedsAdapter$4
  implements Runnable
{
  public VideoFeedsAdapter$4(mtg parammtg, VideoInfo paramVideoInfo, Activity paramActivity, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3, mtg.g paramg1, mtg.g paramg2) {}
  
  public void run()
  {
    if ((this.a == null) || (this.val$activity == null)) {
      return;
    }
    String str3 = this.a.hH;
    String str2 = this.a.vid;
    String str1 = this.a.Wz;
    Object localObject1;
    int i;
    label156:
    label312:
    nce.a locala;
    if ((this.a.busiType == 0) && (this.a.a != null))
    {
      localObject2 = this.a.a.getMd5();
      localObject1 = this.val$activity.getIntent();
      int j = ((Intent)localObject1).getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      i = ((Intent)localObject1).getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      int k = ((Intent)localObject1).getIntExtra("RETURN_SCENE", 0);
      if ((j == 4) || (j == 5) || (j == 2) || (j == 1)) {
        mtg.a(this.this$0, 5);
      }
      if (!mtg.a(this.this$0).Eg()) {
        break label987;
      }
      localObject1 = "1";
      localObject2 = new nce.a((String)localObject2, str3, str2, str1).e(this.a.algorithmID).c(this.a.strategyID).b(mtg.b(this.this$0)).c(mtg.a(this.this$0)).g(j).a(409409).l(this.aUt).a(Boolean.valueOf(this.a.adB)).a(this.a.videoReportInfo).e(this.a.isAD).p(mtg.b(this.this$0)).q(mtg.a(this.this$0)).K(this.a.aHe).L(i);
      if ((this.aop) || (this.val$position <= 0)) {
        break label995;
      }
      i = 1;
      locala = ((nce.a)localObject2).n(i).k(this.a.adH).m(this.a.WD).b(mtg.g(this.this$0)).ad(k).N(0);
      if (!this.aop) {
        locala.m(this.val$position);
      }
      if (this.aoq)
      {
        if (TextUtils.isEmpty(str1)) {
          break label1000;
        }
        localObject2 = str1;
        label394:
        kbp.b(null, str3, "0X8007412", "0X8007412", 0, 0, String.valueOf(j), (String)localObject1, (String)localObject2, locala.a().toJsonString(), false);
      }
      if (mtg.a(this.this$0).getIntent() != null)
      {
        localObject1 = mtg.a(this.this$0);
        i = mtg.a(this.this$0).getIntent().getIntExtra("VIDEO_FROM_TYPE", -1);
        if (localObject1 == null) {
          break label1008;
        }
        localObject1 = ((VideoInfo)localObject1).Wz;
        label474:
        j = mtg.a(this.this$0).getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        locala.v(i).g((String)localObject1).F(j).N(0).M(kzc.h(mtg.a(this.this$0).width, mtg.a(this.this$0).height, mtg.a(this.this$0).duration));
        locala.w(mtg.a(this.this$0).getIntent().getIntExtra("key_source", -1));
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "exposed video [video_from_type : " + i + ", first_video_row_key : " + (String)localObject1 + ", first_video_type : " + j + "]");
        }
      }
      if ((this.a.busiType == 0) && (this.a.a != null)) {
        locala.I(mtg.a(this.this$0).getIntent().getIntExtra("VIDEO_CHAT_TYPE", 0)).J(mtg.a(this.this$0).getIntent().getIntExtra("VIDEO_KANDIAN_TYPE", 0)).j(mtg.a(this.this$0).getIntent().getStringExtra("VIDEO_CHAT_UIN"));
      }
      if (!mtg.b(this.this$0).contains(str2))
      {
        mtg.b(this.this$0).add(str2);
        if ((this.val$position != 0) || (this.aUt != 0) || (this.a.videoReportInfo != null)) {
          break label1016;
        }
        mtg.a(this.this$0, locala);
        label778:
        if ((this.aUu == 2) && (this.a.yR()))
        {
          if (!mtg.e(this.this$0)) {
            break label1032;
          }
          localObject1 = "0X8009489";
          label811:
          str1 = new nce.a(null, this.a.hH, this.a.vid, this.a.Wz).a(409409).a(this.a.videoReportInfo).v(mtg.a(this.this$0).getIntent().getIntExtra("VIDEO_FROM_TYPE", -1)).a().toJsonString();
          str2 = this.a.hH;
          if (TextUtils.isEmpty(this.a.Wz)) {
            break label1040;
          }
        }
      }
    }
    label1032:
    label1040:
    for (Object localObject2 = this.a.Wz;; localObject2 = "0")
    {
      kbp.a(null, str2, (String)localObject1, (String)localObject1, 0, 0, "", "", (String)localObject2, str1, false);
      if (!this.aop) {
        mtg.a(this.this$0, this.c, this.d);
      }
      mtg.a(this.this$0, this.a);
      mtg.b(this.this$0, this.a);
      return;
      localObject2 = null;
      break;
      label987:
      localObject1 = "0";
      break label156;
      label995:
      i = 0;
      break label312;
      label1000:
      localObject2 = "0";
      break label394;
      label1008:
      localObject1 = "";
      break label474;
      label1016:
      mtg.a(this.this$0, this.a, locala);
      break label778;
      localObject1 = "0X8009484";
      break label811;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.4
 * JD-Core Version:    0.7.0.1
 */