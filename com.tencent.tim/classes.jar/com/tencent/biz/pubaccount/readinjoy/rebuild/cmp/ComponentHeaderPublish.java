package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import amxk;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import aqgo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FixSizeImageView;
import kbp;
import kwt;
import kxl;
import kxm;
import lie;
import mas;
import mcf;
import mde;
import ndi;
import odv;

public class ComponentHeaderPublish
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  public boolean akQ;
  public boolean alU;
  public boolean alV;
  RingAvatarView b;
  private FixSizeImageView d;
  public ReadInJoyYAFolderTextView e;
  ImageView jp;
  private View kL;
  public TextView nickname;
  private TextView time;
  
  public ComponentHeaderPublish(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderPublish(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderPublish(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void aNl()
  {
    if ((this.jdField_a_of_type_Mas.a != null) && (this.jdField_a_of_type_Mas.a.a() != null))
    {
      ArticleInfo localArticleInfo = this.jdField_a_of_type_Mas.a.a();
      if (ComponentPolymericView.n(this.jdField_a_of_type_Mas.a)) {
        this.e.setVisibility(8);
      }
      for (;;)
      {
        if (localArticleInfo.mTime > 0L) {
          this.time.setText(kxl.c(localArticleInfo.mTime, true));
        }
        this.time.setOnClickListener(this);
        return;
        if ((!TextUtils.isEmpty(localArticleInfo.mSummary)) || (this.alU) || (this.akQ))
        {
          this.e.setVisibility(0);
          this.e.setMaxLines(7);
          this.e.setMoreSpan(new mcf(this));
          Object localObject;
          if (this.alU)
          {
            localObject = new SpannableStringBuilder();
            if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih != null))
            {
              ((SpannableStringBuilder)localObject).append(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih);
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.ui", 2, "Comment String: " + localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih);
              }
            }
            for (;;)
            {
              ((SpannableStringBuilder)localObject).append(" ");
              new ComponentAccountSummary.b(localArticleInfo, -3355444, getContext(), getResources(), this.jdField_a_of_type_Mas).textSize = 17;
              ((SpannableStringBuilder)localObject).append(" ");
              this.e.ask = true;
              this.e.setText((CharSequence)localObject);
              break;
              if (localArticleInfo.mTitle != null) {
                ((SpannableStringBuilder)localObject).append(localArticleInfo.mTitle);
              }
            }
          }
          if (this.akQ)
          {
            this.e.setHeight(0);
          }
          else
          {
            if (this.alV)
            {
              ReadInJoyYAFolderTextView localReadInJoyYAFolderTextView = this.e;
              if (!TextUtils.isEmpty(localArticleInfo.mTitle)) {}
              for (localObject = localArticleInfo.mTitle;; localObject = localArticleInfo.mSummary)
              {
                localReadInJoyYAFolderTextView.setText((CharSequence)localObject);
                break;
              }
            }
            this.e.setText(localArticleInfo.mSummary);
          }
        }
        else
        {
          this.e.setVisibility(8);
        }
      }
    }
    this.e.setVisibility(8);
  }
  
  private void aOe()
  {
    long l = getUin();
    if (l != 0L)
    {
      if (!kxm.AI()) {
        break label45;
      }
      this.d.setImageDrawable(amxk.b(this.jdField_a_of_type_Aqdf, String.valueOf(l), 1));
    }
    for (;;)
    {
      this.d.setOnClickListener(this);
      return;
      label45:
      this.d.setImageBitmap(this.jdField_b_of_type_Ndi.c(l));
    }
  }
  
  private void aOf()
  {
    if ((this.jdField_a_of_type_Mas.a != null) && (this.jdField_a_of_type_Mas.a.a() != null))
    {
      ArticleInfo localArticleInfo = this.jdField_a_of_type_Mas.a.a();
      this.nickname.setText(kxm.ew(localArticleInfo.mSubscribeName));
      this.nickname.setOnClickListener(this);
      if ((localArticleInfo.mSocialFeedInfo != null) && (ndi.K(localArticleInfo)) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.type == 1)) {
        this.kL.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.kL.setVisibility(8);
  }
  
  private void aOg()
  {
    ArticleInfo localArticleInfo;
    String str2;
    String str3;
    if ((this.jdField_a_of_type_Mas.a != null) && (this.jdField_a_of_type_Mas.a.a() != null))
    {
      localArticleInfo = this.jdField_a_of_type_Mas.a.a();
      kxm.c = localArticleInfo;
      str2 = "" + getUin();
      str1 = kwt.acJ + aqgo.encodeToString(String.valueOf(str2).getBytes(), 2);
      kxm.aJ(getContext(), str1);
      str3 = kxm.a("4", localArticleInfo, getUin());
      if (!odv.aT(this.jdField_a_of_type_Mas.a.nh())) {
        break label191;
      }
    }
    label191:
    for (String str1 = "0X800935C";; str1 = "0X8007BA3")
    {
      kbp.a(null, str2, str1, str1, 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), "" + localArticleInfo.mStrategyId, str3, false);
      return;
    }
  }
  
  private long getUin()
  {
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_Mas.a.a().mSubscribeID);
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
  
  public void P(Object paramObject)
  {
    super.P(paramObject);
    if ((paramObject instanceof lie)) {
      d((lie)paramObject);
    }
  }
  
  public void c(long paramLong, Bitmap paramBitmap)
  {
    if ((kxm.AI()) && (getUin() == paramLong)) {
      this.d.setImageBitmap(paramBitmap);
    }
  }
  
  public void cG(View paramView)
  {
    super.cG(paramView);
    this.d = ((FixSizeImageView)findViewById(2131363175));
    this.nickname = ((TextView)findViewById(2131372384));
    this.nickname.getPaint().setFakeBoldText(true);
    this.time = ((TextView)findViewById(2131379661));
    this.e = ((ReadInJoyYAFolderTextView)findViewById(2131365748));
    this.kL = findViewById(2131376683);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView = ((RingAvatarView)findViewById(2131376630));
    this.jp = ((ImageView)findViewById(2131369908));
  }
  
  public void d(lie paramlie)
  {
    aOe();
    mde.a(this.jdField_a_of_type_Mas.a, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView, this.jp);
    aOf();
    aNl();
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560319, this, true);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPublish
 * JD-Core Version:    0.7.0.1
 */