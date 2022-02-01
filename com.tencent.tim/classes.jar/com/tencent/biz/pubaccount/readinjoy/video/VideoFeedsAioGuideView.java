package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import aqcx;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kbp;
import mtg.k;
import mts;
import mtt;
import nce;
import nce.a;

public class VideoFeedsAioGuideView
  extends FrameLayout
  implements View.OnClickListener
{
  private Animation V;
  private Animation W;
  private int aUw;
  private boolean aot;
  private FrameLayout.LayoutParams b;
  private VideoInfo jdField_c_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsRecyclerView jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private ImageView jY;
  private ImageView jZ;
  private Activity mActivity;
  private QQAppInterface mApp;
  private boolean mHasInitialized;
  private TextView si;
  
  public VideoFeedsAioGuideView(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    super(paramActivity);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.mActivity = paramActivity;
    this.mApp = paramQQAppInterface;
    this.aUw = aqcx.dip2px(paramActivity, 5.0F);
    setVisibility(8);
  }
  
  private void aSf()
  {
    setBackgroundResource(2130843563);
    int i = aqcx.dip2px(this.mActivity, 6.0F);
    int j = aqcx.dip2px(this.mActivity, 3.0F);
    setPadding(i, j, i, j);
    this.si = new TextView(this.mActivity);
    this.si.setTextSize(2, 12.0F);
    this.si.setText("");
    this.si.setTextColor(-654311425);
    this.jY = new ImageView(this.mActivity);
    this.jZ = new ImageView(this.mActivity);
    this.jY.setImageResource(2130843938);
    this.jZ.setImageResource(2130843938);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 19;
    localLayoutParams.rightMargin = aqcx.dip2px(this.mActivity, 10.0F);
    addView(this.si, localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 21;
    localLayoutParams.topMargin = (-aqcx.dip2px(this.mActivity, 2.0F));
    addView(this.jY, localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 21;
    localLayoutParams.topMargin = aqcx.dip2px(this.mActivity, 3.0F);
    addView(this.jZ, localLayoutParams);
  }
  
  public void a(mtg.k paramk)
  {
    this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo = paramk.a.d;
    if (!this.mHasInitialized)
    {
      this.mHasInitialized = true;
      aSf();
      this.b = new FrameLayout.LayoutParams(-2, -2);
      this.b.gravity = 85;
      this.b.bottomMargin = aqcx.dip2px(this.mActivity, 63.0F);
      this.b.rightMargin = aqcx.dip2px(this.mActivity, 12.0F);
      setOnClickListener(this);
    }
    if (getParent() != paramk.be)
    {
      if (getParent() != null) {
        ((ViewGroup)getParent()).removeView(this);
      }
      paramk.be.addView(this, this.b);
    }
  }
  
  public void aSc()
  {
    setVisibility(0);
    setTranslationY(this.aUw);
    setAlpha(0.0F);
    animate().translationYBy(-this.aUw).alphaBy(1.0F).setDuration(240L);
    if (this.V == null)
    {
      this.V = new AlphaAnimation(1.0F, 0.0F);
      this.V.setDuration(360L);
      this.V.setRepeatMode(2);
      this.V.setRepeatCount(-1);
      this.V.setAnimationListener(new mts(this));
    }
    if (this.W == null)
    {
      this.W = new AlphaAnimation(1.0F, 0.0F);
      this.W.setDuration(360L);
      this.W.setRepeatMode(2);
      this.W.setRepeatCount(-1);
      this.W.setAnimationListener(new mtt(this));
    }
    this.V.setStartOffset(180L);
    this.W.setStartOffset(0L);
    this.jY.startAnimation(this.V);
    this.jZ.startAnimation(this.W);
    if (!this.aot)
    {
      this.aot = true;
      nce.a locala = new nce.a(this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo);
      kbp.a(this.mApp, this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo.hH, "0X8009833", "0X8009833", 0, 0, "", "", "", locala.a().toJsonString(), false);
    }
  }
  
  public void aSd()
  {
    setVisibility(8);
    if (this.jY != null) {
      this.jY.clearAnimation();
    }
    if (this.jZ != null) {
      this.jZ.clearAnimation();
    }
  }
  
  public void aSe()
  {
    if (getParent() != null) {
      ((ViewGroup)getParent()).removeView(this);
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.EK();
    nce.a locala = new nce.a(this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo);
    kbp.a(this.mApp, this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo.hH, "0X8009834", "0X8009834", 0, 0, "", "", "", locala.a().toJsonString(), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAioGuideView
 * JD-Core Version:    0.7.0.1
 */