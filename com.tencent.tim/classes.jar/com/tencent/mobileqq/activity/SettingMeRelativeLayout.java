package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.ApolloTextureView;

public class SettingMeRelativeLayout
  extends RelativeLayout
{
  private ApolloTextureView a;
  private float ki;
  private float pm = 1.0F;
  private ImageView rh;
  
  public SettingMeRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SettingMeRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(14)
  public void bVt()
  {
    if ((Build.VERSION.SDK_INT >= 11) && (this.a != null))
    {
      this.a.setTranslationX(super.getTranslationX() * this.pm + this.ki);
      if (this.rh != null) {
        this.rh.setTranslationX(super.getTranslationX() * this.pm);
      }
    }
  }
  
  public void setSurfaceView(ApolloTextureView paramApolloTextureView, ImageView paramImageView, float paramFloat1, float paramFloat2)
  {
    this.a = paramApolloTextureView;
    this.rh = paramImageView;
    this.pm = paramFloat1;
    this.ki = paramFloat2;
  }
  
  @TargetApi(14)
  public void setTranslationX(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setTranslationX(paramFloat);
      if (this.a != null) {
        this.a.setTranslationX(this.pm * paramFloat + this.ki);
      }
      if (this.rh != null) {
        this.rh.setTranslationX(this.pm * paramFloat);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SettingMeRelativeLayout
 * JD-Core Version:    0.7.0.1
 */