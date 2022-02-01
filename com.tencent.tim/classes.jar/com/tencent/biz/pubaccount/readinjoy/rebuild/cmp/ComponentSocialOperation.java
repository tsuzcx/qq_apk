package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kbp;
import kxm;
import lbz;
import lie;
import lwl;
import lwm.a;
import mas;
import mcx;
import mcy;
import mcz;
import ndi;
import odv;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentSocialOperation
  extends FrameLayout
  implements View.OnClickListener, lwl
{
  public final String TAG = "ComponentSocialOperation";
  SocializeFeedsInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo;
  mas jdField_a_of_type_Mas;
  int aQw = 0;
  int aQx = 0;
  boolean ama = false;
  int commentNum = 0;
  ScaleAnimation e;
  ScaleAnimation f;
  public ScaleAnimation g;
  ArticleInfo h;
  public ImageView jt;
  View kT;
  TextView qH;
  TextView qI;
  TextView qJ;
  
  public ComponentSocialOperation(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentSocialOperation(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public ComponentSocialOperation(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bY(paramContext);
  }
  
  private void bY(Context paramContext)
  {
    this.jdField_a_of_type_Mas = new mas();
    init(paramContext);
    aHq();
  }
  
  public static String bp(int paramInt)
  {
    if (paramInt < 10000) {
      return String.valueOf(paramInt);
    }
    if (paramInt < 100000000) {
      int i = paramInt / 10000;
    }
    paramInt /= 100000000;
    return String.valueOf(paramInt) + "";
  }
  
  public void P(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof lie))
    {
      paramObject = (lie)paramObject;
      this.jdField_a_of_type_Mas.setModel(paramObject);
      this.h = paramObject.a();
      if (this.h != null) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo = this.h.mSocialFeedInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo != null)
    {
      this.aQw = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.mLikeCount;
      this.commentNum = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.mCommentCount;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.aSH != 1) {
        break label113;
      }
    }
    for (;;)
    {
      this.ama = bool;
      this.aQx = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.aSI;
      nK(false);
      return;
      label113:
      bool = false;
    }
  }
  
  public void a(lwm.a parama)
  {
    this.jdField_a_of_type_Mas.b(parama);
  }
  
  public void aHq()
  {
    this.qH.setOnClickListener(this);
    this.kT.setOnClickListener(this);
    this.qJ.setOnClickListener(this);
  }
  
  public void init(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560325, this, true);
    this.qH = ((TextView)paramContext.findViewById(2131365047));
    this.qI = ((TextView)paramContext.findViewById(2131381363));
    this.jt = ((ImageView)paramContext.findViewById(2131381362));
    this.kT = paramContext.findViewById(2131381361);
    this.qJ = ((TextView)paramContext.findViewById(2131363552));
    this.e = new ScaleAnimation(1.0F, 1.8F, 1.0F, 1.8F, 1, 0.5F, 1, 0.5F);
    this.f = new ScaleAnimation(1.8F, 0.85F, 1.8F, 0.85F, 1, 0.5F, 1, 0.5F);
    this.g = new ScaleAnimation(0.85F, 1.0F, 0.85F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.e.setDuration(300L);
    this.f.setDuration(200L);
    this.g.setDuration(100L);
    this.e.setAnimationListener(new mcx(this));
    this.f.setAnimationListener(new mcy(this));
    this.g.setAnimationListener(new mcz(this));
  }
  
  public void nK(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jt.startAnimation(this.e);
      if (this.commentNum <= 0) {
        break label195;
      }
      this.qH.setText(bp(this.commentNum));
    }
    for (;;)
    {
      if (this.aQx <= 0) {
        break label208;
      }
      this.qJ.setText(bp(this.aQx));
      return;
      if (this.ama)
      {
        this.jt.setImageResource(2130847236);
        this.qI.setTextColor(Color.parseColor("#07D0B0"));
        label86:
        if (this.aQw <= 0) {
          break label182;
        }
        this.qI.setText(bp(this.aQw));
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label193;
        }
        QLog.d("ComponentSocialOperation", 2, "set upvote to " + this.ama + ", set num:" + this.aQw);
        break;
        this.jt.setImageResource(2130847239);
        this.qI.setTextColor(Color.parseColor("#777777"));
        break label86;
        label182:
        this.qI.setText(2131718546);
      }
      label193:
      break;
      label195:
      this.qH.setText(2131718377);
    }
    label208:
    this.qJ.setText("Biu");
  }
  
  public void onClick(View paramView)
  {
    if (this.h == null) {}
    Object localObject3;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject3 = "";
      for (;;)
      {
        try
        {
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("folder_status", kxm.aMw);
          if (!ndi.K(this.h)) {
            continue;
          }
          ((JSONObject)localObject4).put("feeds_source", this.h.mSubscribeID);
          ((JSONObject)localObject4).put("rowkey", this.h.innerUniqueID);
          ((JSONObject)localObject4).put("feeds_type", "" + kxm.a(this.h));
          ((JSONObject)localObject4).put("kandian_mode", "" + kxm.nR());
          ((JSONObject)localObject4).put("tab_source", "" + kxm.nQ());
          ((JSONObject)localObject4).put("channel_id", "" + this.h.mChannelID);
          ((JSONObject)localObject4).put("algorithm_id", "" + this.h.mAlgorithmID);
          if (!this.h.isPGCShortContent()) {
            continue;
          }
          localObject1 = "1";
        }
        catch (JSONException localJSONException)
        {
          Object localObject1;
          ReportInfo localReportInfo;
          localJSONException.printStackTrace();
          Object localObject2 = localObject3;
          continue;
          localObject2 = "0";
          continue;
          localObject3 = "0X8007B65";
          continue;
          Object localObject4 = "0X8007B66";
          continue;
          String str2 = "0X8007B67";
          continue;
          String str1 = "0X8007EE4";
          continue;
          kbp.a(null, this.h.mSubscribeID, str2, str2, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.mFeedId), String.valueOf(this.h.mArticleID), "" + this.h.mStrategyId, (String)localObject2, false);
          continue;
          kxm.a(getContext(), this.h, true);
          continue;
          if (paramView.getId() != 2131381361) {
            continue;
          }
          if (this.ama) {
            continue;
          }
          boolean bool = true;
          this.ama = bool;
          if (!this.ama) {
            continue;
          }
          if ((!ndi.S(this.h)) && (!ndi.ak(this.h)) && (!ndi.T(this.h)) && (!ndi.U(this.h))) {
            continue;
          }
          if (ndi.Y(this.h)) {
            continue;
          }
          kbp.a(null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin), (String)localObject3, (String)localObject3, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.mFeedId), "0", "" + this.h.mStrategyId, (String)localObject2, false);
          ndi.g(this.h, this.jdField_a_of_type_Mas.a.nh());
          localReportInfo.mOperation = 2;
          if (!this.ama) {
            continue;
          }
          int i = this.aQw + 1;
          this.aQw = i;
          nK(true);
          localObject2 = this.h.mSocialFeedInfo;
          if (!this.ama) {
            continue;
          }
          i = 1;
          ((SocializeFeedsInfo)localObject2).aSH = i;
          this.h.mSocialFeedInfo.mLikeCount = this.aQw;
          localObject2 = this.h.clone();
          lbz.a().a(kxm.getLongAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.mFeedId, this.ama, (ArticleInfo)localObject2);
          continue;
          bool = false;
          continue;
          kbp.a(null, this.h.mSubscribeID, (String)localObject3, (String)localObject3, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.mFeedId), String.valueOf(this.h.mArticleID), "" + this.h.mStrategyId, (String)localObject2, false);
          continue;
          if ((!ndi.S(this.h)) && (!ndi.ak(this.h)) && (!ndi.T(this.h)) && (!ndi.U(this.h))) {
            continue;
          }
          if (ndi.Y(this.h)) {
            continue;
          }
          kbp.a(null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin), (String)localObject4, (String)localObject4, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.mFeedId), "0", "" + this.h.mStrategyId, (String)localObject2, false);
          ndi.g(this.h, this.jdField_a_of_type_Mas.a.nh());
          localReportInfo.mOperation = 13;
          continue;
          kbp.a(null, this.h.mSubscribeID, (String)localObject4, (String)localObject4, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.mFeedId), String.valueOf(this.h.mArticleID), "" + this.h.mStrategyId, (String)localObject2, false);
          continue;
          i = this.aQw - 1;
          continue;
          i = 0;
          continue;
          if (paramView.getId() != 2131363552) {
            continue;
          }
          localObject3 = getContext();
          if (!(localObject3 instanceof Activity)) {
            continue;
          }
          localObject3 = (Activity)localObject3;
          localObject4 = new Intent((Context)localObject3, ReadInJoyDeliverBiuActivity.class);
          ((Intent)localObject4).putExtra("arg_article_info", this.h);
          ((Intent)localObject4).putExtra("feedsType", this.h.mFeedType);
          if (this.jdField_a_of_type_Mas.a.nh() != 70) {
            continue;
          }
          ((Intent)localObject4).putExtra("biu_src", 9);
          ((Intent)localObject4).putExtra("arg_from_type", 14);
          ((Activity)localObject3).startActivity((Intent)localObject4);
          ((Activity)localObject3).overridePendingTransition(0, 0);
          if ((!ndi.S(this.h)) && (!ndi.ak(this.h)) && (!ndi.T(this.h)) && (!ndi.U(this.h))) {
            continue;
          }
          if (ndi.Y(this.h)) {
            continue;
          }
          kbp.a(null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin), str1, str1, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.mFeedId), "0", "" + this.h.mStrategyId, (String)localObject2, false);
          ndi.g(this.h, this.jdField_a_of_type_Mas.a.nh());
          localReportInfo.mOperation = 25;
          continue;
          ((Intent)localObject4).putExtra("biu_src", 1);
          ((Intent)localObject4).putExtra("arg_from_type", 1);
          continue;
          kbp.a(null, this.h.mSubscribeID, str1, str1, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.mFeedId), String.valueOf(this.h.mArticleID), "" + this.h.mStrategyId, (String)localObject2, false);
          continue;
          localReportInfo.mFeedsReportData = ((ReportInfo.a)localObject2);
          localObject2 = new ArrayList();
          ((List)localObject2).add(localReportInfo);
          lbz.a().cb((List)localObject2);
        }
        ((JSONObject)localObject4).put("content_source", localObject1);
        localObject1 = ((JSONObject)localObject4).toString();
        if (QLog.isColorLevel()) {
          QLog.d("ComponentSocialOperation", 2, "onclick v:" + paramView.getId());
        }
        kxm.c = this.h;
        localReportInfo = new ReportInfo();
        bool = odv.aT(this.h.mChannelID);
        if (!bool) {
          continue;
        }
        localObject3 = "0X800935E";
        if (!bool) {
          continue;
        }
        localObject4 = "0X800935F";
        if (!bool) {
          continue;
        }
        str2 = "0X8009360";
        if (!bool) {
          continue;
        }
        str1 = "0X8009361";
        if (paramView.getId() != 2131365047) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo != null)
        {
          if ((!ndi.S(this.h)) && (!ndi.ak(this.h)) && (!ndi.T(this.h)) && (!ndi.U(this.h))) {
            continue;
          }
          if (!ndi.Y(this.h)) {
            kbp.a(null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin), str2, str2, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.mFeedId), "0", "" + this.h.mStrategyId, (String)localObject1, false);
          }
          ndi.g(this.h, this.jdField_a_of_type_Mas.a.nh());
        }
        localReportInfo.mOperation = 3;
        if (!ndi.K(this.jdField_a_of_type_Mas.a.a())) {
          continue;
        }
        kxm.a(getContext(), this.h, 1, true, 0, true);
        if (this.h == null) {
          continue;
        }
        localObject1 = new ReportInfo.a();
        localReportInfo.mUin = kxm.getLongAccountUin();
        localReportInfo.mSource = 0;
        localReportInfo.mSourceArticleId = this.h.mArticleID;
        localReportInfo.mChannelId = ((int)this.h.mChannelID);
        localReportInfo.mAlgorithmId = ((int)this.h.mAlgorithmID);
        localReportInfo.mStrategyId = this.h.mStrategyId;
        localReportInfo.mServerContext = this.h.mServerContext;
        localReportInfo.mReadTimeLength = -1;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo == null) {
          continue;
        }
        ((ReportInfo.a)localObject1).vd = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.mFeedId;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) {
          ((ReportInfo.a)localObject1).vg = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
        }
        ((ReportInfo.a)localObject1).aSx = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.mLikeCount;
        ((ReportInfo.a)localObject1).aSy = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.mCommentCount;
        localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.iS;
        if ((localObject3 == null) || (((List)localObject3).isEmpty())) {
          continue;
        }
        ((ReportInfo.a)localObject1).iR = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          continue;
        }
        localObject4 = (SocializeFeedsInfo.e)((Iterator)localObject3).next();
        if (localObject4 != null)
        {
          ((ReportInfo.a)localObject1).iR.add(Long.valueOf(((SocializeFeedsInfo.e)localObject4).uin));
          continue;
          ((JSONObject)localObject4).put("feeds_source", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation
 * JD-Core Version:    0.7.0.1
 */