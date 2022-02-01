package com.tencent.mobileqq.listentogether.lyrics;

import acfp;
import aipa;
import aipb;
import aipc;
import aipn;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint.Align;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import wja;

public class FloatTextLayout
  extends FloatBaseLayout
  implements aipn, View.OnClickListener
{
  public aipc a;
  boolean clf = true;
  View root;
  
  public FloatTextLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  private void init()
  {
    this.root = LayoutInflater.from(getContext()).inflate(2131561194, null);
    this.jdField_a_of_type_Aipc = ((aipc)this.root.findViewById(2131370956));
    this.jdField_a_of_type_Aipc.setStrokeColor(-1);
    this.jdField_a_of_type_Aipc.setStrokeWidth(wja.dp2px(1.5F, getResources()));
    ((TextView)this.jdField_a_of_type_Aipc).setTextColor(-8293377);
    ((TextView)this.jdField_a_of_type_Aipc).getPaint().setFakeBoldText(true);
    ((TextView)this.jdField_a_of_type_Aipc).setTextSize(1, 18.0F);
    ((TextView)this.jdField_a_of_type_Aipc).setOnClickListener(this);
    ((TextView)this.jdField_a_of_type_Aipc).setContentDescription(acfp.m(2131706353));
    this.den = wja.dp2px(40.0F, getResources());
    int i = (int)getResources().getDimension(2131297626);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.dem = ((int)(Math.min(j * 0.85F, j - wja.dp2px(16.0F, getResources())) - i));
    this.jdField_a_of_type_Aipc.setLineMaxWidth(this.dem);
    addView(this.root, new FrameLayout.LayoutParams(-2, this.den));
    this.jdField_a_of_type_Aipc.setOnSizeChangeListener(this);
    this.mLayoutParams.width = this.dem;
    this.mLayoutParams.height = this.den;
  }
  
  public int a(aipb paramaipb)
  {
    if (paramaipb.ckY) {
      return paramaipb.deq + paramaipb.aOw / 2;
    }
    return paramaipb.deq - paramaipb.aOw / 2 - this.dem;
  }
  
  public aipc a()
  {
    return this.jdField_a_of_type_Aipc;
  }
  
  public void a(aipb paramaipb)
  {
    if (paramaipb == null) {}
    label138:
    label143:
    label146:
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if ((paramaipb.isForeground) && (!paramaipb.cld) && (!paramaipb.ckZ))
      {
        if (!paramaipb.cla) {
          this.jdField_a_of_type_Aipc.setAlign(Paint.Align.CENTER);
        }
      }
      else
      {
        this.clf = paramaipb.ckY;
        localObject = (FrameLayout.LayoutParams)this.root.getLayoutParams();
        i = ((FrameLayout.LayoutParams)localObject).gravity;
        if (!paramaipb.cla) {
          break label143;
        }
        if (!this.clf) {
          break label138;
        }
        i = 5;
      }
      for (;;)
      {
        if (((FrameLayout.LayoutParams)localObject).gravity == i) {
          break label146;
        }
        ((FrameLayout.LayoutParams)localObject).gravity = i;
        this.root.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
        if (paramaipb.ckY) {}
        for (localObject = Paint.Align.RIGHT;; localObject = Paint.Align.LEFT)
        {
          this.jdField_a_of_type_Aipc.setAlign((Paint.Align)localObject);
          break;
        }
        i = 3;
        continue;
        i = 1;
      }
    }
  }
  
  public boolean a(aipb paramaipb)
  {
    boolean bool = true;
    if (paramaipb == null) {
      return false;
    }
    if ((paramaipb.isForeground) && (!paramaipb.cld) && (!paramaipb.ckZ)) {
      if (apm()) {}
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      if (apn()) {
        bool = false;
      }
    }
  }
  
  public boolean apn()
  {
    boolean bool = super.apn();
    if (this.jdField_a_of_type_Aipc != null) {
      this.jdField_a_of_type_Aipc.stop();
    }
    return bool;
  }
  
  public int b(aipb paramaipb)
  {
    return paramaipb.der - this.den / 2;
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.jdField_a_of_type_Aipc != null)
    {
      this.jdField_a_of_type_Aipc.setOnSizeChangeListener(null);
      this.jdField_a_of_type_Aipc.stop();
    }
  }
  
  public void dtu()
  {
    int i = (int)getResources().getDimension(2131297626);
    int j = getResources().getDisplayMetrics().widthPixels;
    this.dem = ((int)(Math.min(j * 0.85F, j - wja.dp2px(16.0F, getResources())) - i));
    this.jdField_a_of_type_Aipc.setLineMaxWidth(this.dem);
    this.mLayoutParams.width = this.dem;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aipa != null) {
      this.jdField_a_of_type_Aipa.dtr();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onSizeChange(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.dem) && (this.jdField_a_of_type_Aipa != null)) {
      this.jdField_a_of_type_Aipa.ix(paramInt1, paramInt2);
    }
  }
  
  public void setFloatWidth(int paramInt)
  {
    this.dem = paramInt;
    this.mLayoutParams.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.FloatTextLayout
 * JD-Core Version:    0.7.0.1
 */