package com.tencent.mobileqq.richmedia.capture.view;

import acfp;
import alwh;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BeautyProviderView
  extends ProviderView
  implements View.OnClickListener
{
  private int dyM = 6;
  private int dyN;
  private LinearLayout kf;
  private RelativeLayout lJ;
  
  public BeautyProviderView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  private void L(TextView paramTextView)
  {
    paramTextView.setBackgroundResource(2130846827);
    paramTextView.setTextColor(Color.parseColor("#12B7F5"));
  }
  
  private void M(TextView paramTextView)
  {
    paramTextView.setBackgroundResource(2130846826);
    paramTextView.setTextColor(Color.parseColor("#FFFFFF"));
  }
  
  public void dKI()
  {
    super.dKI();
    alwh.a().dA(getContext());
  }
  
  public void onClick(View paramView)
  {
    setBeautyLevel(((Integer)paramView.getTag()).intValue());
    this.c.TJ(((Integer)paramView.getTag()).intValue());
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    setNeedTabBar(false);
    super.onCreate(paramBundle);
    this.lJ = ((RelativeLayout)this.mContentView);
    if (this.lJ == null) {
      this.lJ = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561632, this, false));
    }
    addContentView(this.lJ);
    this.kf = ((LinearLayout)this.lJ.findViewById(2131363360));
    int i = 0;
    while (i < this.dyM)
    {
      paramBundle = new RelativeLayout(getContext());
      Object localObject = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramBundle.setGravity(17);
      paramBundle.setOnClickListener(this);
      paramBundle.setTag(Integer.valueOf(i));
      localObject = new TextView(getContext());
      ((TextView)localObject).setBackgroundResource(2130846826);
      ((TextView)localObject).setText(i + "");
      ((TextView)localObject).setTextSize(18.0F);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      paramBundle.addView((View)localObject);
      paramBundle.setContentDescription(acfp.m(2131703176) + i);
      this.kf.addView(paramBundle);
      i += 1;
    }
    setBeautyLevel(this.dyN);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setBeautyLevel(float paramFloat)
  {
    int j = (int)paramFloat;
    if ((j < 0) || (j >= this.dyM)) {}
    do
    {
      return;
      this.dyN = j;
    } while (this.kf == null);
    int i = 0;
    while (i < this.kf.getChildCount())
    {
      M((TextView)((ViewGroup)this.kf.getChildAt(i)).getChildAt(0));
      i += 1;
    }
    L((TextView)((ViewGroup)this.kf.getChildAt(j)).getChildAt(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.BeautyProviderView
 * JD-Core Version:    0.7.0.1
 */