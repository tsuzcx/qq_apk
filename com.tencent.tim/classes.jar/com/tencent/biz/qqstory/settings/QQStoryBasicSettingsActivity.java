package com.tencent.biz.qqstory.settings;

import acfp;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqiw;
import arib;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import plr;
import pma;
import pmb;
import pmd;
import qon;
import wja;

public class QQStoryBasicSettingsActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public arib a;
  public pma b;
  ViewGroup bD;
  public int bno = 0;
  public int bnp = this.bno;
  public pmb c;
  pmd e = new qon(this);
  View[] o = new View[3];
  View oo;
  
  protected View a(int paramInt, String paramString)
  {
    View localView = View.inflate(this, 2131561760, null);
    ((TextView)localView.findViewById(2131379769)).setText(paramString);
    ((TextView)localView.findViewById(2131369154)).setText("");
    paramString = (ImageView)localView.findViewById(2131362978);
    paramString.setVisibility(4);
    paramString.setBackgroundResource(2130839521);
    localView.setTag(Integer.valueOf(paramInt));
    localView.setOnClickListener(this);
    return localView;
  }
  
  public void bV(int paramInt)
  {
    int i = 0;
    if (i < this.o.length)
    {
      View localView = this.o[i];
      ImageView localImageView = (ImageView)localView.findViewById(2131362978);
      TextView localTextView = (TextView)localView.findViewById(2131379769);
      if (i != paramInt)
      {
        localImageView.setVisibility(4);
        localView.setContentDescription(localTextView.getText() + acfp.m(2131712203));
      }
      for (;;)
      {
        i += 1;
        break;
        localImageView.setVisibility(0);
        localView.setContentDescription(localTextView.getText() + acfp.m(2131712208));
      }
    }
    this.bno = paramInt;
  }
  
  int dV(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 1001: 
    default: 
      return 0;
    case 3: 
      return 2;
    }
    return 1;
  }
  
  public int dW(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1001;
    case 2: 
      return 3;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.c = ((pmb)this.app.getManager(181));
    this.b = ((pma)this.app.getBusinessHandler(98));
    initView();
    int i = dV(this.c.sl());
    this.bnp = i;
    this.bno = i;
    bV(this.bno);
    super.setTitle(plr.asY + acfp.m(2131712212));
    this.app.addObserver(this.e);
    if (!aqiw.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, 2131693404, 0).show(getTitleBarHeight());
      super.startTitleProgress();
      return true;
    }
    this.b.blO();
    super.startTitleProgress();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.e);
    super.doOnDestroy();
  }
  
  void initView()
  {
    Object localObject = new LinearLayout(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout)localObject).setBackgroundResource(2130838900);
    ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).setPadding(0, wja.dp2px(20.0F, getResources()), 0, 0);
    this.bD = ((ViewGroup)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setText(plr.asY + acfp.m(2131712207));
    ((TextView)localObject).setPadding(getResources().getDimensionPixelSize(2131298887), 0, getResources().getDimensionPixelSize(2131298887), getResources().getDimensionPixelSize(2131298884));
    ((TextView)localObject).setTextSize(14.0F);
    ((TextView)localObject).setTextColor(getResources().getColor(2131165692));
    this.bD.addView((View)localObject);
    localObject = a(0, "移动流量和WiFi");
    this.bD.addView((View)localObject);
    this.o[0] = localObject;
    ((View)localObject).setBackgroundResource(2130839701);
    this.oo = ((View)localObject);
    localObject = a(1, "仅WiFi");
    this.o[1] = localObject;
    this.bD.addView((View)localObject);
    ((View)localObject).setBackgroundResource(2130839695);
    this.oo = ((View)localObject);
    localObject = a(2, acfp.m(2131712205));
    this.o[2] = localObject;
    this.bD.addView((View)localObject);
    ((View)localObject).setBackgroundResource(2130839689);
    this.oo = ((View)localObject);
    super.setContentView(this.bD);
    this.a = new arib(this, 2131561628);
  }
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, 2131693404, 0).show(getTitleBarHeight());
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    this.bnp = this.bno;
    switch (i)
    {
    }
    for (;;)
    {
      this.a.aq(0, 2131718674, 0);
      bV(i);
      break;
      this.b.vJ(3);
      continue;
      this.b.vJ(1);
      continue;
      this.b.vJ(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryBasicSettingsActivity
 * JD-Core Version:    0.7.0.1
 */