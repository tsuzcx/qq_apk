package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aczc;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.o;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import jzk;
import kwz;
import kxm;
import lbz;
import lie;
import lwk;
import lwm.a;
import mas;
import mde;
import mhr;
import mhr.a;
import mih;
import mih.b;
import ndi;
import org.json.JSONObject;
import wja;

public class ComponentContentBig
  extends RelativeLayout
  implements lwk
{
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
  mas jdField_a_of_type_Mas;
  TextView qg;
  KandianUrlImageView v;
  
  public ComponentContentBig(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentContentBig(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public ComponentContentBig(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  private void z(ArticleInfo paramArticleInfo)
  {
    if (this.qg != null)
    {
      this.qg.setVisibility(8);
      if ((lbz.a().ap(null)) && ((paramArticleInfo instanceof AdvertisementInfo)))
      {
        paramArticleInfo = (AdvertisementInfo)paramArticleInfo;
        if (!TextUtils.isEmpty(paramArticleInfo.mAdExtInfo)) {
          break label49;
        }
      }
    }
    for (;;)
    {
      return;
      try
      {
        label49:
        paramArticleInfo = new JSONObject(paramArticleInfo.mAdExtInfo);
        double d1 = paramArticleInfo.getDouble("latitude");
        double d2 = paramArticleInfo.getDouble("longitude");
        paramArticleInfo = aczc.a("readinjoy_feed_ad_distance");
        if ((paramArticleInfo != null) && (paramArticleInfo.a != null))
        {
          double d3 = paramArticleInfo.a.cd;
          double d4 = paramArticleInfo.a.ce;
          if ((d3 >= 0.0D) && (d4 >= 0.0D) && (d1 >= 0.0D) && (d2 >= 0.0D))
          {
            paramArticleInfo = jzk.b(TencentLocationUtils.distanceBetween(d3, d4, d1, d2));
            if (!TextUtils.isEmpty(paramArticleInfo))
            {
              this.qg.setVisibility(0);
              this.qg.setText(paramArticleInfo);
              return;
            }
          }
        }
      }
      catch (Exception paramArticleInfo) {}
    }
  }
  
  public void P(Object paramObject)
  {
    ArticleInfo localArticleInfo;
    if ((paramObject instanceof lie))
    {
      paramObject = (lie)paramObject;
      this.jdField_a_of_type_Mas.setModel(paramObject);
      aNf();
      localArticleInfo = paramObject.a();
      if (localArticleInfo != null) {}
    }
    else
    {
      return;
    }
    c(paramObject);
    z(localArticleInfo);
    a(paramObject, localArticleInfo);
  }
  
  protected URL a(lie paramlie)
  {
    if (ComponentPolymericView.n(paramlie)) {
      return kxm.a(((mhr.a)paramlie.a().mNewPolymericInfo.iP.get(0)).ahr, true, true);
    }
    paramlie = paramlie.a();
    if ((paramlie.mSocialFeedInfo != null) && (paramlie.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null) && (paramlie.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.size() > 0)) {
      return kxm.a(((SocializeFeedsInfo.t)paramlie.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).pic_url, true, true);
    }
    if ((paramlie.mSocialFeedInfo != null) && (paramlie.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null) && (paramlie.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kZ.size() > 0)) {
      try
      {
        paramlie = new URL(kxm.c(((SocializeFeedsInfo.o)paramlie.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kZ.get(0)).pic_url, this.v.getWidth(), this.v.getHeight()));
        return paramlie;
      }
      catch (MalformedURLException paramlie)
      {
        QLog.d("ComponentContentBig", 2, paramlie, new Object[0]);
        return null;
      }
    }
    if ((ndi.am(paramlie)) || (ndi.al(paramlie)))
    {
      if ((paramlie.mSocialFeedInfo != null) && (paramlie.mSocialFeedInfo.mTopicRecommendFeedsInfo != null) && (paramlie.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld != null) && (paramlie.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld.size() > 0)) {
        try
        {
          URL localURL = new URL(((mih.b)paramlie.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld.get(0)).picUrl);
          return localURL;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          QLog.d("ComponentContentBig", 2, localMalformedURLException, new Object[0]);
          return paramlie.mSinglePicture;
        }
      }
      return paramlie.mSinglePicture;
    }
    return paramlie.mSinglePicture;
  }
  
  protected void a(lie paramlie, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null)
    {
      if ((!ndi.am(paramArticleInfo)) && (!ndi.al(paramArticleInfo))) {
        break label53;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131718538);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130843848, 0, 0, 0);
    }
    label53:
    do
    {
      return;
      if ((paramlie.getCellType() == 27) || ((paramlie.getCellType() == 18) && (!paramArticleInfo.isPGCShortContent())) || (paramlie.getCellType() == 31) || ((kxm.B(paramArticleInfo)) && (!kxm.n(paramArticleInfo))))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131718332);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130843561, 0, 0, 0);
        return;
      }
      if (paramlie.getCellType() == 52)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130846807, 0, 0, 0);
        return;
      }
      if ((paramlie.getCellType() != 48) && (paramlie.getCellType() != 49)) {
        break;
      }
    } while ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a == null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130846807, 0, 0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablePadding(wja.dp2px(2.0F, getContext().getResources()));
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
  }
  
  public void a(lwm.a parama)
  {
    this.jdField_a_of_type_Mas.b(parama);
  }
  
  public void aHq() {}
  
  public void aNf()
  {
    ViewGroup.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_Mas.CZ()) || (this.jdField_a_of_type_Mas.Db()))
    {
      localLayoutParams = this.v.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = wja.dp2px(190.0F, getResources());
      this.v.setLayoutParams(localLayoutParams);
      this.v.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    if (this.jdField_a_of_type_Mas.Da())
    {
      localLayoutParams = this.v.getLayoutParams();
      localLayoutParams.width = wja.dp2px(250.0F, getResources());
      localLayoutParams.height = wja.dp2px(141.0F, getResources());
      this.v.setLayoutParams(localLayoutParams);
      this.v.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    mde.a(getContext(), this.v);
  }
  
  protected void c(lie paramlie)
  {
    kwz.a(this.v, a(paramlie), getContext());
    this.v.setClickable(false);
  }
  
  public void cG(View paramView)
  {
    this.v = ((KandianUrlImageView)paramView.findViewById(2131368896));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131365461));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
    this.qg = ((TextView)paramView.findViewById(2131362136));
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(getLayoutId(), this, true);
  }
  
  protected int getLayoutId()
  {
    return 2131560294;
  }
  
  public void init(Context paramContext)
  {
    cG(f(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig
 * JD-Core Version:    0.7.0.1
 */