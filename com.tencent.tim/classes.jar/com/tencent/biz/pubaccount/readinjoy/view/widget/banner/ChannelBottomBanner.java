package com.tencent.biz.pubaccount.readinjoy.view.widget.banner;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import axyb;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import java.util.List;
import ndi;
import nsk;
import rpq;

public class ChannelBottomBanner
  extends ChannelTopBanner
{
  public ChannelBottomBanner(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a(ndi paramndi, TopBannerInfo paramTopBannerInfo)
  {
    if (this.b != null)
    {
      if (paramTopBannerInfo.items.size() > 0)
      {
        this.b.d(paramTopBannerInfo);
        baF();
        lE(true);
      }
    }
    else {
      return;
    }
    lE(false);
  }
  
  protected View aq()
  {
    View localView = new View(this.mContext);
    if (this.d == null)
    {
      this.d = new LinearLayout.LayoutParams(rpq.dip2px(this.mContext, 6.0F), rpq.dip2px(this.mContext, 6.0F));
      this.d.leftMargin = rpq.dip2px(this.mContext, 4.0F);
      this.cP = getResources().getDrawable(2130840136);
      this.cQ = getResources().getDrawable(2130840135);
    }
    localView.setLayoutParams(this.d);
    localView.setBackgroundDrawable(this.cP);
    return localView;
  }
  
  protected void p(Activity paramActivity)
  {
    LayoutInflater.from(paramActivity).inflate(2131560168, this, true);
    this.a = ((RollViewPager)findViewById(2131381929));
    this.a.setOffscreenPageLimit(5);
    this.eq = ((LinearLayout)findViewById(2131370621));
    this.a.setOnPageChangeListener(new ChannelTopBanner.RollerChangeListener(this));
    this.a.setOnTouchStateChangeListener(new nsk(this));
    this.b = new BannerAdapter(paramActivity, this.a, BannerAdapter.bch);
    this.a.setAdapter(this.b);
    paramActivity = new axyb(this.mContext, new LinearInterpolator());
    paramActivity.setScrollDuration(400);
    paramActivity.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.banner.ChannelBottomBanner
 * JD-Core Version:    0.7.0.1
 */