package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import aqgo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.DecimalFormat;
import java.util.List;
import kbp;
import kwt;
import kxl;
import kxm;
import lbz;
import lie;
import ljc;
import mas;
import mcg;
import mch;
import ndi;
import org.json.JSONException;
import org.json.JSONObject;
import wja;

public class ComponentHeaderRecommend
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private Button bS;
  private TextView bd;
  public ReadInJoyYAFolderTextView e;
  private ReadInJoyHeadImageView j;
  public ReadInJoyNickNameTextView k;
  
  public ComponentHeaderRecommend(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderRecommend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderRecommend(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean Dl()
  {
    try
    {
      boolean bool = lbz.a().c(Long.valueOf(getUin()));
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private void aNl()
  {
    ArticleInfo localArticleInfo;
    if ((this.a.a != null) && (this.a.a.a() != null))
    {
      localArticleInfo = this.a.a.a();
      this.e.setMaxLines(7);
      this.e.setMoreSpan(new mcg(this));
      if (!kxm.A(localArticleInfo)) {
        break label91;
      }
      this.e.setVisibility(8);
    }
    for (;;)
    {
      aOh();
      this.bd.setOnClickListener(this);
      return;
      label91:
      this.e.setText(localArticleInfo.mSummary);
    }
  }
  
  private void aOf()
  {
    if ((this.a.a != null) && (this.a.a.a() != null))
    {
      Object localObject = this.a.a.a();
      this.k.setText(kxm.ew(((ArticleInfo)localObject).mSubscribeName));
      this.k.setOnClickListener(this);
      if ((((ArticleInfo)localObject).mSocialFeedInfo != null) && (ndi.R((ArticleInfo)localObject)) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.type == 1))
      {
        localObject = getResources().getDrawable(2130845914);
        ((Drawable)localObject).setBounds(0, 0, wja.dp2px(16.0F, getResources()), wja.dp2px(16.0F, getResources()));
        this.k.setCompoundDrawables(null, null, (Drawable)localObject, null);
        this.k.setCompoundDrawablePadding(wja.dp2px(4.0F, getResources()));
      }
    }
  }
  
  private void aOg()
  {
    ArticleInfo localArticleInfo;
    String str;
    Object localObject1;
    if ((this.a.a != null) && (this.a.a.a() != null))
    {
      localArticleInfo = this.a.a.a();
      str = "" + getUin();
      localObject1 = kwt.acJ + aqgo.encodeToString(String.valueOf(getUin()).getBytes(), 2);
      kxm.aJ(getContext(), (String)localObject1);
      localObject1 = "";
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", kxm.aMw);
      ((JSONObject)localObject2).put("rowkey", localArticleInfo.innerUniqueID);
      ((JSONObject)localObject2).put("kandian_mode", "" + kxm.nR());
      ((JSONObject)localObject2).put("tab_source", "" + kxm.nQ());
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    kbp.a(null, str, "0X80080ED", "0X80080ED", 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), "", (String)localObject1, false);
  }
  
  private void aOh()
  {
    ArticleInfo localArticleInfo = this.a.a.a();
    if (kxm.A(localArticleInfo)) {
      if (localArticleInfo.mTime > 0L) {
        this.bd.setText(kxl.c(localArticleInfo.mSocialFeedInfo.aRW, true));
      }
    }
    do
    {
      do
      {
        return;
      } while (localArticleInfo.mSocialFeedInfo == null);
      if (!TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.ahO))
      {
        this.bd.setText(localArticleInfo.mSocialFeedInfo.ahO);
        return;
      }
    } while (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m == null);
    int i = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aSU;
    if (i >= 10000)
    {
      new DecimalFormat("####.0");
      return;
    }
    new StringBuilder().append("").append(i).toString();
  }
  
  private void aOi()
  {
    QQAppInterface localQQAppInterface;
    if (!Dl())
    {
      this.bS.setTextColor(Color.parseColor("#BBBBBB"));
      this.bS.setEnabled(false);
      this.bS.getPaint().setFakeBoldText(false);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((this.a.a == null) || (this.a.a.a() == null)) {
        break label171;
      }
      Object localObject = this.a.a.a();
      if ((((ArticleInfo)localObject).mGroupSubArticleList == null) || (((ArticleInfo)localObject).mGroupSubArticleList.size() <= 0)) {
        break label171;
      }
      localObject = (BaseArticleInfo)((ArticleInfo)localObject).mGroupSubArticleList.get(0);
      if (((localObject instanceof ArticleInfo)) && (!ndi.Y((ArticleInfo)localObject))) {
        break label171;
      }
    }
    label171:
    for (int i = 2;; i = 1)
    {
      lbz.a().a().a(localQQAppInterface.getAccount(), getUin(), true, new mch(this), i);
      aNa();
      return;
    }
  }
  
  private long getUin()
  {
    try
    {
      long l = Long.parseLong(this.a.a.a().mSubscribeID);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      return 0L;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void setFollow()
  {
    this.bS.setOnClickListener(this);
    if (Dl())
    {
      this.bS.setTextColor(Color.parseColor("#BBBBBB"));
      this.bS.setEnabled(false);
      this.bS.getPaint().setFakeBoldText(false);
      return;
    }
    this.bS.setTextColor(Color.parseColor("#07D0B0"));
    this.bS.setEnabled(true);
    this.bS.getPaint().setFakeBoldText(true);
  }
  
  public void P(Object paramObject)
  {
    super.P(paramObject);
    if ((paramObject instanceof lie)) {
      d((lie)paramObject);
    }
  }
  
  public void cG(View paramView)
  {
    super.cG(paramView);
    this.j = ((ReadInJoyHeadImageView)findViewById(2131363175));
    this.k = ((ReadInJoyNickNameTextView)findViewById(2131372384));
    this.bd = ((TextView)findViewById(2131365468));
    this.e = ((ReadInJoyYAFolderTextView)findViewById(2131365748));
    this.bS = ((Button)findViewById(2131363870));
    this.bS.getPaint().setFakeBoldText(true);
  }
  
  public void d(lie paramlie)
  {
    long l = getUin();
    this.j.setHeadImgByUin(l);
    this.j.setOnClickListener(this);
    aOf();
    aNl();
    setFollow();
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560317, this, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aOg();
      continue;
      aOi();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderRecommend
 * JD-Core Version:    0.7.0.1
 */