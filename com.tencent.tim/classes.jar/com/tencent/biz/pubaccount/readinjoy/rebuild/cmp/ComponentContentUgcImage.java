package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import apmj;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.h;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.s;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.u;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kwz;
import kxm;
import lie;
import lwk;
import lwm.a;
import mas;
import ndi;
import wja;

public class ComponentContentUgcImage
  extends RelativeLayout
  implements View.OnClickListener, lwk
{
  KanDianRoundCornerTextView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
  mas jdField_b_of_type_Mas;
  ImageView jm;
  private View.OnClickListener mOnClickListener;
  KandianUrlImageView t;
  
  public ComponentContentUgcImage(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentContentUgcImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  private boolean Di()
  {
    return (this.jdField_b_of_type_Mas.a.getCellType() == 80) || (this.jdField_b_of_type_Mas.a.getCellType() == 81);
  }
  
  private void aOa()
  {
    if ((this.jdField_b_of_type_Mas.a.a() == null) || (this.jdField_b_of_type_Mas.a.a().mSocialFeedInfo == null) || (this.jdField_b_of_type_Mas.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentUgcImage", 2, "info is null");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    String str1 = ((SocializeFeedsInfo.s)this.jdField_b_of_type_Mas.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.get(0)).pic_url;
    Object localObject = str1;
    if (!TextUtils.isEmpty(str1))
    {
      localObject = str1;
      if (str1.contains("https")) {
        localObject = str1.replaceFirst("https", "http");
      }
    }
    localArrayList.add(localObject);
    localObject = this.jdField_b_of_type_Mas.a.a();
    if (kxm.s((ArticleInfo)localObject))
    {
      str1 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aiq;
      String str2 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.ain;
      apmj.a((Activity)getContext(), 0, localArrayList, null, null, false, false, "4", 100, null, str1, str2, (ArticleInfo)localObject, "");
      return;
    }
    apmj.a((Activity)getContext(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
  }
  
  private void aOb()
  {
    Object localObject = this.jdField_b_of_type_Mas.a.a();
    if ((localObject == null) || (((ArticleInfo)localObject).mSocialFeedInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null)) {
      return;
    }
    localObject = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.jumpUrl;
    if (localObject != null)
    {
      kxm.aJ(getContext(), (String)localObject);
      ndi.g(this.jdField_b_of_type_Mas.a.a(), this.jdField_b_of_type_Mas.a.nh());
    }
    QLog.d("ComponentContentUgcImage", 2, "jumpUrl is " + (String)localObject);
  }
  
  private void bY(Context paramContext)
  {
    this.jdField_b_of_type_Mas = new mas();
    init(paramContext);
    aHq();
  }
  
  private String l(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {
      return "";
    }
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u;
    if ((paramArticleInfo != null) && (paramArticleInfo.wendaUrl != null) && (paramArticleInfo.wendaUrl.trim().length() > 0)) {
      return paramArticleInfo.wendaUrl;
    }
    return "";
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof lie))
    {
      paramObject = (lie)paramObject;
      this.jdField_b_of_type_Mas.setModel(paramObject);
      aNf();
      paramObject = paramObject.a();
      if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (paramObject.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null) && (paramObject.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.size() != 0)) {}
    }
    else
    {
      return;
    }
    String str = ((SocializeFeedsInfo.s)paramObject.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.get(0)).aii;
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentUgcImage", 2, "thumb url is " + str);
    }
    paramObject = str;
    if (!TextUtils.isEmpty(str))
    {
      paramObject = str;
      if (str.contains("https")) {
        paramObject = str.replaceFirst("https", "http");
      }
    }
    kwz.a(this.t, kxm.b(paramObject), getContext());
  }
  
  public void a(lwm.a parama)
  {
    this.jdField_b_of_type_Mas.b(parama);
  }
  
  public void aHq()
  {
    this.t.setOnClickListener(this);
  }
  
  public void aNf()
  {
    if ((this.jdField_b_of_type_Mas.a.a() == null) || (this.jdField_b_of_type_Mas.a.a().mSocialFeedInfo == null) || (this.jdField_b_of_type_Mas.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentUgcImage", 2, "info is null");
      }
      return;
    }
    Object localObject = getResources().getDisplayMetrics();
    int k = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    int i = wja.dp2px(12.0F, getResources());
    int j = wja.dp2px(4.5F, getResources());
    int m = (k - (i * 2 + j * 2)) / 3 * 2 + j;
    int n = (k - (i * 2 + j)) / 2;
    float f3 = m;
    float f4 = m;
    j = 0;
    localObject = this.jdField_b_of_type_Mas.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la;
    float f2;
    float f1;
    if (((List)localObject).size() > 0)
    {
      f2 = ((SocializeFeedsInfo.s)((List)localObject).get(0)).pic_width;
      f1 = ((SocializeFeedsInfo.s)((List)localObject).get(0)).pic_height;
      if (((SocializeFeedsInfo.s)((List)localObject).get(0)).aSX == 1)
      {
        i = 1;
        localObject = this.t.getLayoutParams();
        f1 = f2 / f1;
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null)
        {
          if (f1 >= 0.455D) {
            break label573;
          }
          ((ViewGroup.LayoutParams)localObject).width = n;
          ((ViewGroup.LayoutParams)localObject).height = m;
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(getResources().getText(2131718543));
          label318:
          if (i != 0)
          {
            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131718542);
          }
          if (!kxm.r(this.jdField_b_of_type_Mas.a.a())) {
            break label783;
          }
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Mas.a.a().mChannelID == 0L)
      {
        i = kwz.a(k, getResources());
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = i;
        QLog.d("ComponentContentUgcImage", 2, "main feeds | ivWidth is " + ((ViewGroup.LayoutParams)localObject).width + "; ivHeight is " + ((ViewGroup.LayoutParams)localObject).height);
      }
      QLog.d("ComponentContentUgcImage", 2, "imageParams.width is " + ((ViewGroup.LayoutParams)localObject).width + "; imageParams.height is " + ((ViewGroup.LayoutParams)localObject).height);
      this.t.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.t.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.t.setPadding(0, 0, 0, 0);
      return;
      i = 0;
      break;
      i = j;
      f1 = f4;
      f2 = f3;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ComponentContentUgcImage", 2, "ugc pic info is null");
      i = j;
      f1 = f4;
      f2 = f3;
      break;
      label573:
      if ((0.455D <= f1) && (f1 <= 0.7441D))
      {
        ((ViewGroup.LayoutParams)localObject).width = n;
        ((ViewGroup.LayoutParams)localObject).height = m;
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
        break label318;
      }
      if ((0.7441D <= f1) && (f1 <= 1.3439D))
      {
        ((ViewGroup.LayoutParams)localObject).width = m;
        ((ViewGroup.LayoutParams)localObject).height = m;
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
        break label318;
      }
      if (Di())
      {
        ((ViewGroup.LayoutParams)localObject).width = -1;
        ((ViewGroup.LayoutParams)localObject).height = wja.dp2px(190.0F, getResources());
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
        break label318;
      }
      if ((1.3439D <= f1) && (f1 <= 2.2D))
      {
        ((ViewGroup.LayoutParams)localObject).width = m;
        ((ViewGroup.LayoutParams)localObject).height = n;
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
        break label318;
      }
      ((ViewGroup.LayoutParams)localObject).width = m;
      ((ViewGroup.LayoutParams)localObject).height = n;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(getResources().getText(2131718543));
      break label318;
      label783:
      if (Di())
      {
        SocializeFeedsInfo.h localh = this.jdField_b_of_type_Mas.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$h;
        if (localh != null)
        {
          if ((!TextUtils.isEmpty(localh.aib)) && (!TextUtils.isEmpty(localh.aia)))
          {
            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(localh.aib);
            Drawable localDrawable = DrawableUtil.getDrawable(getContext(), localh.aia, null, null);
            if (localDrawable != null)
            {
              localDrawable.setBounds(0, 0, wja.dp2px(12.0F, getResources()), wja.dp2px(12.0F, getResources()));
              this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawables(localDrawable, null, null, null);
            }
          }
          if (localh.aSR == 1)
          {
            this.jm.setImageResource(2130844049);
            this.jm.setVisibility(0);
          }
          else
          {
            this.jm.setVisibility(8);
          }
        }
      }
      else
      {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  public void cG(View paramView)
  {
    this.t = ((KandianUrlImageView)paramView.findViewById(2131381187));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131381188));
    this.jm = ((ImageView)paramView.findViewById(2131364389));
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560586, this, true);
  }
  
  public void init(Context paramContext)
  {
    cG(f(paramContext));
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
      if (Di())
      {
        aOb();
      }
      else
      {
        ndi.g(this.jdField_b_of_type_Mas.a.a(), this.jdField_b_of_type_Mas.a.nh());
        if (kxm.r(this.jdField_b_of_type_Mas.a.a()))
        {
          String str = l(this.jdField_b_of_type_Mas.a.a());
          if (!TextUtils.isEmpty(str))
          {
            kxm.aL(getContext(), str);
            continue;
          }
        }
        aOa();
        if (this.mOnClickListener != null) {
          this.mOnClickListener.onClick(paramView);
        }
      }
    }
  }
  
  public void setPicClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcImage
 * JD-Core Version:    0.7.0.1
 */