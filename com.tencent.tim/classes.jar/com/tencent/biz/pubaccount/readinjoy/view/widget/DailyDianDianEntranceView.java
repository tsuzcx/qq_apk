package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import awit;
import com.tencent.biz.pubaccount.readinjoy.view.ClipDianDianTouchAreaLayout;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager.a;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ReadInJoyColorBandEntranceButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kbp;
import mua;
import ncs;
import nss;

public class DailyDianDianEntranceView
  extends FrameLayout
  implements View.OnClickListener, RecommendFeedsDiandianEntranceManager.a
{
  private ReadInJoyColorBandEntranceButton a;
  private ClipDianDianTouchAreaLayout b;
  private mua c;
  private View.OnClickListener cA;
  private Context mContext;
  
  public DailyDianDianEntranceView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public DailyDianDianEntranceView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2131562914, this, true);
    this.a = ((ReadInJoyColorBandEntranceButton)localView.findViewById(2131366485));
    this.b = ((ClipDianDianTouchAreaLayout)localView.findViewById(2131366488));
    this.b.setTouchWidget(this.a, 0);
    this.a.setOnVideoCoverClickListener(this);
    int j = ncs.a().qw();
    RecommendFeedsDiandianEntranceManager.a().tI(j);
    QLog.d("DailyDianDianEntranceView", 1, "init | DailyFeedsDiandianEntranceManager daily feeds entryMode : " + j);
    int i = 2130850235;
    if (j == 1) {
      switch (awit.Qi())
      {
      default: 
        this.c = new mua(this.a, getContext());
        this.c.sA(1);
        i = 2130843931;
        switch (j)
        {
        }
        break;
      }
    }
    do
    {
      return;
      i = 2130850265;
      break;
      i = 2130850236;
      break;
      if (j != 3) {
        break;
      }
      i = 2130850234;
      break;
    } while (!awit.aMG());
    this.a.setClickAnimMode(1);
    this.a.setDefaultIconBigMode(80, 80);
    this.b.setVisibility(0);
    this.a.setVisibility(0);
    this.a.setDefaultDrawable(getResources().getDrawable(i));
    return;
    this.a.setClickAnimMode(2);
    this.b.setVisibility(0);
    this.a.setVisibility(0);
    this.a.i().setVisibility(0);
    this.a.setDefaultIconBigMode(70, 70);
    this.a.setDefaultDrawable(getResources().getDrawable(i));
  }
  
  public DailyDianDianEntranceView a(View.OnClickListener paramOnClickListener)
  {
    this.cA = paramOnClickListener;
    return this;
  }
  
  public void g(nss paramnss)
  {
    if ((paramnss == null) || (this.a == null)) {}
    int i;
    do
    {
      return;
      i = ncs.a().qw();
      QLog.d("DailyDianDianEntranceView", 1, "onEntryIconRefresh | entryMode " + i);
    } while ((i == 0) || (i == 2));
    this.a.setDataSource(paramnss);
    if ((this.a != null) && (this.a.getVisibility() == 0))
    {
      if (paramnss == null) {
        break label146;
      }
      this.a.i(paramnss);
      QLog.d("DailyDianDianEntranceView", 1, "onEntryIconRefresh | addRedDot entryMode " + i);
    }
    for (;;)
    {
      kbp.a(null, "CliOper", "", "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", RecommendFeedsDiandianEntranceManager.a().bD(1), false);
      return;
      label146:
      this.a.setNotMsg();
      QLog.d("DailyDianDianEntranceView", 1, "onEntryIconRefresh | setNotMsg entryMode " + i);
    }
  }
  
  public void h(nss paramnss)
  {
    if ((paramnss == null) || (this.a == null)) {}
    do
    {
      return;
      QLog.d("DailyDianDianEntranceView", 1, "onAccountChange");
      this.a.baG();
    } while ((this.a == null) || (this.a.getVisibility() != 0));
    if (paramnss != null)
    {
      this.a.i(paramnss);
      return;
    }
    this.a.setNotMsg();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.a, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setStartDelay(500L);
    localObjectAnimator.setDuration(400L);
    localObjectAnimator.start();
  }
  
  public void onClick(View paramView)
  {
    if (this.cA != null) {
      this.cA.onClick(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    if (this.c != null) {
      this.c.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.DailyDianDianEntranceView
 * JD-Core Version:    0.7.0.1
 */