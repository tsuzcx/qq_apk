package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqnm;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import ltj;

public class NativeMiddleBodyView
  extends RelativeLayout
  implements IView
{
  private static String TAG = "NativeMiddleBodyView";
  RadiusView a = null;
  String afA;
  String afB;
  String afy;
  String afz;
  boolean akR = false;
  View kE = null;
  
  public NativeMiddleBodyView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.kE = paramView;
    if (paramLayoutParams != null) {
      super.addView(paramView, paramLayoutParams);
    }
    for (;;)
    {
      if (this.akR)
      {
        if (this.a == null)
        {
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          if (paramLayoutParams != null) {
            localLayoutParams.setMargins(paramLayoutParams.leftMargin, paramLayoutParams.topMargin, paramLayoutParams.rightMargin, paramLayoutParams.bottomMargin);
          }
          this.a = new RadiusView(getContext());
          this.a.setLeftTopRadius(this.afy);
          this.a.setRightTopRadius(this.afz);
          this.a.setBottomRightRadius(this.afA);
          this.a.setBottomLeftRadius(this.afB);
          addView(this.a, localLayoutParams);
        }
        paramView.addOnLayoutChangeListener(this.a.a());
      }
      return;
      super.addView(paramView);
    }
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public View getContent()
  {
    return this.kE;
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void setRadius(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.akR = true;
    this.afy = paramString1;
    this.afz = paramString2;
    this.afA = paramString3;
    this.afB = paramString4;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
  
  public static class RadiusView
    extends RelativeLayout
  {
    String afC = null;
    String afD = null;
    String afE = null;
    String afF = null;
    final int width = aqnm.dip2px(8.0F);
    
    public RadiusView(Context paramContext)
    {
      super();
    }
    
    public View.OnLayoutChangeListener a()
    {
      return new ltj(this);
    }
    
    public void setBottomLeftRadius(String paramString)
    {
      this.afD = paramString;
      NativeReadInjoyImageView localNativeReadInjoyImageView = new NativeReadInjoyImageView(getContext());
      localNativeReadInjoyImageView.setIsCacheIcon(true);
      localNativeReadInjoyImageView.setIsClosedoAlphaAniamation(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.width, this.width);
      localLayoutParams.addRule(12);
      addView(localNativeReadInjoyImageView, localLayoutParams);
      localNativeReadInjoyImageView.setImageSrc(paramString);
    }
    
    public void setBottomRightRadius(String paramString)
    {
      this.afF = paramString;
      NativeReadInjoyImageView localNativeReadInjoyImageView = new NativeReadInjoyImageView(getContext());
      localNativeReadInjoyImageView.setIsCacheIcon(true);
      localNativeReadInjoyImageView.setIsClosedoAlphaAniamation(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.width, this.width);
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(11);
      addView(localNativeReadInjoyImageView, localLayoutParams);
      localNativeReadInjoyImageView.setImageSrc(paramString);
    }
    
    public void setLeftTopRadius(String paramString)
    {
      this.afC = paramString;
      NativeReadInjoyImageView localNativeReadInjoyImageView = new NativeReadInjoyImageView(getContext());
      localNativeReadInjoyImageView.setIsCacheIcon(true);
      localNativeReadInjoyImageView.setIsClosedoAlphaAniamation(true);
      addView(localNativeReadInjoyImageView, new RelativeLayout.LayoutParams(this.width, this.width));
      localNativeReadInjoyImageView.setImageSrc(paramString);
    }
    
    public void setRightTopRadius(String paramString)
    {
      this.afE = paramString;
      NativeReadInjoyImageView localNativeReadInjoyImageView = new NativeReadInjoyImageView(getContext());
      localNativeReadInjoyImageView.setIsCacheIcon(true);
      localNativeReadInjoyImageView.setIsClosedoAlphaAniamation(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.width, this.width);
      localLayoutParams.addRule(11);
      addView(localNativeReadInjoyImageView, localLayoutParams);
      localNativeReadInjoyImageView.setImageSrc(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView
 * JD-Core Version:    0.7.0.1
 */