package com.tencent.biz.pubaccount.readinjoy.view.widget.banner;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager.PageTransformer;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import aqnm;
import axyb;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo.c;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import laq;
import ndi;
import nsl;
import nsm;
import odv;
import rpq;

public class ChannelTopBanner
  extends RelativeLayout
{
  private static final Set<String> aq = new HashSet();
  protected ViewPager.SimpleOnPageChangeListener a;
  private a a;
  public RollViewPager a;
  protected boolean auq = true;
  public BannerAdapter b;
  public int baC;
  protected Drawable cP;
  protected Drawable cQ;
  protected LinearLayout.LayoutParams d;
  protected LinearLayout eq;
  private LinearLayout er;
  private boolean mAttached;
  protected Context mContext;
  public Handler mHandler = new nsl(this, Looper.getMainLooper());
  private boolean mIsStop = true;
  protected View[] n;
  
  public ChannelTopBanner(Activity paramActivity)
  {
    super(paramActivity);
    this.mContext = paramActivity;
    p(paramActivity);
  }
  
  private String a(TopBannerInfo paramTopBannerInfo)
  {
    if (paramTopBannerInfo == null) {
      return null;
    }
    return paramTopBannerInfo.mChannelId + "_" + paramTopBannerInfo.mCookie;
  }
  
  private void a(TemplateBean paramTemplateBean)
  {
    odv.a(paramTemplateBean, null, "expose_T");
  }
  
  private void co(View paramView)
  {
    this.er.addView(paramView);
  }
  
  private void uf(int paramInt)
  {
    View localView1 = this.b.getChildAt(paramInt);
    View localView2 = this.b.getChildAt(paramInt - 1);
    View localView3 = this.b.getChildAt(paramInt + 1);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner$a != null) && (this.b.getCount() > 1))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner$a.transformPage(localView1, 0.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner$a.transformPage(localView2, -1.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner$a.transformPage(localView3, 1.0F);
    }
  }
  
  public void a(ndi paramndi, TopBannerInfo paramTopBannerInfo)
  {
    int i;
    label73:
    int j;
    if (this.b != null)
    {
      if (paramTopBannerInfo.items.size() > 0)
      {
        this.b.d(paramTopBannerInfo);
        baF();
        lE(true);
      }
    }
    else
    {
      this.er.removeAllViews();
      if (paramTopBannerInfo.dynamicItems.size() <= 0) {
        break label262;
      }
      if (aq.contains(a(paramTopBannerInfo))) {
        break label235;
      }
      i = 1;
      aq.add(a(paramTopBannerInfo));
      j = 0;
      label90:
      if (j >= paramTopBannerInfo.dynamicItems.size()) {
        return;
      }
      TopBannerInfo.c localc = (TopBannerInfo.c)paramTopBannerInfo.dynamicItems.get(j);
      if ((localc == null) || (TextUtils.isEmpty(localc.aiA))) {
        break label251;
      }
      QLog.d("ChannelTopBanner", 2, new Object[] { "json = ", localc.aiA });
      ProteusItemView localProteusItemView = laq.a(paramndi.getVafContext(), "default_feeds", laq.d(localc.aiA));
      if (localProteusItemView == null) {
        break label240;
      }
      laq.a(localProteusItemView, paramndi.getVafContext(), "default_feeds", localc.aiA);
      co(localProteusItemView);
      if (i != 0) {
        a(localProteusItemView.getTemplateBean());
      }
    }
    for (;;)
    {
      j += 1;
      break label90;
      lE(false);
      break;
      label235:
      i = 0;
      break label73;
      label240:
      QLog.d("ChannelTopBanner", 2, "refreshBanner, header is null.");
      continue;
      label251:
      QLog.d("ChannelTopBanner", 2, "refreshBanner, dynamicJSON is null.");
    }
    label262:
    QLog.d("ChannelTopBanner", 2, "refreshBanner, dynamicItems is null.");
  }
  
  protected View aq()
  {
    View localView = new View(this.mContext);
    if (this.d == null)
    {
      this.d = new LinearLayout.LayoutParams(rpq.dip2px(this.mContext, 11.0F), rpq.dip2px(this.mContext, 2.0F));
      this.d.leftMargin = rpq.dip2px(this.mContext, 6.0F);
      this.cP = getResources().getDrawable(2130850199);
      this.cQ = getResources().getDrawable(2130850200);
    }
    localView.setLayoutParams(this.d);
    localView.setBackgroundDrawable(this.cP);
    return localView;
  }
  
  public void baF()
  {
    int j = this.b.ju();
    if (j == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelTopBanner", 2, "startRoll error, the count of avatars is 0...");
      }
    }
    for (;;)
    {
      return;
      this.eq.removeAllViews();
      if (j > 1)
      {
        this.n = new View[j];
        int i = 0;
        while (i < j)
        {
          this.n[i] = aq();
          this.eq.addView(this.n[i]);
          i += 1;
        }
        this.n[0].setBackgroundDrawable(this.cQ);
        this.baC = 1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setCurrentItem(this.baC, false);
        start();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ChannelTopBanner", 2, "startRoll is called successfully");
        return;
        stop();
      }
    }
  }
  
  protected void lE(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setVisibility(0);
      this.eq.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setVisibility(8);
    this.eq.setVisibility(8);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mAttached = true;
    if (!this.mIsStop)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(), 4000L);
    }
    if (this.b != null) {
      this.b.baD();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mAttached = false;
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public void onPause()
  {
    stop();
  }
  
  public void onResume()
  {
    start();
  }
  
  protected void p(Activity paramActivity)
  {
    LayoutInflater.from(paramActivity).inflate(2131560173, this, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager = ((RollViewPager)findViewById(2131381985));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setOffscreenPageLimit(5);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setPageMargin(aqnm.dip2px(-10.0F));
    this.eq = ((LinearLayout)findViewById(2131370621));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setOnPageChangeListener(new RollerChangeListener());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setOnTouchStateChangeListener(new nsm(this));
    this.b = new BannerAdapter(paramActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager, BannerAdapter.bcg);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner$a = new a(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setPageTransformer(true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner$a);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setAdapter(this.b);
    paramActivity = new axyb(this.mContext, new LinearInterpolator());
    paramActivity.setScrollDuration(400);
    paramActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager);
    setClipChildren(false);
    this.er = ((LinearLayout)findViewById(2131370617));
  }
  
  public void setOnPageChangeListener(ViewPager.SimpleOnPageChangeListener paramSimpleOnPageChangeListener)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener = paramSimpleOnPageChangeListener;
  }
  
  public void start()
  {
    this.mIsStop = false;
    if (this.mAttached)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(), 4000L);
    }
  }
  
  public void stop()
  {
    this.mIsStop = true;
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public class RollerChangeListener
    extends ViewPager.SimpleOnPageChangeListener
  {
    int baD = 0;
    
    protected RollerChangeListener() {}
    
    public void onPageScrollStateChanged(int paramInt)
    {
      int j = 1;
      if (ChannelTopBanner.this.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener != null) {
        ChannelTopBanner.this.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener.onPageScrollStateChanged(paramInt);
      }
      ChannelTopBanner localChannelTopBanner = ChannelTopBanner.this;
      boolean bool;
      if (paramInt == 0)
      {
        bool = true;
        localChannelTopBanner.auq = bool;
        if (ChannelTopBanner.this.auq) {
          break label60;
        }
      }
      label60:
      label198:
      for (;;)
      {
        return;
        bool = false;
        break;
        int i = ChannelTopBanner.this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.getCurrentItem();
        ChannelTopBanner.this.baC = i;
        int k = ChannelTopBanner.this.b.getCount();
        if (k > 1)
        {
          if (i == 1)
          {
            ChannelTopBanner.this.b.instantiateItem(null, k - 2);
            if (i != 0) {
              break label185;
            }
            paramInt = k - 2;
          }
          for (;;)
          {
            if (i == paramInt) {
              break label198;
            }
            ChannelTopBanner.this.baC = paramInt;
            ChannelTopBanner.this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setCurrentItem(paramInt, false);
            ChannelTopBanner.a(ChannelTopBanner.this, paramInt);
            return;
            if (i != k - 2) {
              break;
            }
            ChannelTopBanner.this.b.instantiateItem(null, 1);
            break;
            paramInt = j;
            if (i != k - 1) {
              paramInt = i;
            }
          }
        }
      }
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      super.onPageScrolled(paramInt1, paramFloat, paramInt2);
      if (ChannelTopBanner.this.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener != null) {
        ChannelTopBanner.this.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      int i = ChannelTopBanner.this.b.getRealPosition(paramInt);
      if ((i >= 0) && (this.baD >= 0) && (ChannelTopBanner.this.n != null) && (ChannelTopBanner.this.n.length > i) && (ChannelTopBanner.this.n.length > this.baD))
      {
        ChannelTopBanner.this.n[this.baD].setBackgroundDrawable(ChannelTopBanner.this.cP);
        ChannelTopBanner.this.n[i].setBackgroundDrawable(ChannelTopBanner.this.cQ);
        this.baD = i;
      }
      if (ChannelTopBanner.this.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener != null) {
        ChannelTopBanner.this.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener.onPageSelected(paramInt);
      }
      ChannelTopBanner.this.b.ue(i);
    }
  }
  
  class a
    implements ViewPager.PageTransformer
  {
    private a() {}
    
    public void transformPage(View paramView, float paramFloat)
    {
      if (paramView == null) {}
      while ((ChannelTopBanner.this.b != null) && (ChannelTopBanner.this.b.getCount() == 1)) {
        return;
      }
      if ((paramFloat <= -1.1F) || (paramFloat >= 1.1F))
      {
        paramView.setScaleX(0.9F);
        paramView.setScaleY(0.9F);
        return;
      }
      paramFloat = Math.max(0.9F, 1.0F - Math.abs(0.2000001F * paramFloat));
      paramView.setScaleX(paramFloat);
      paramView.setScaleY(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.banner.ChannelTopBanner
 * JD-Core Version:    0.7.0.1
 */