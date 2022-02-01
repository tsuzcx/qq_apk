package com.tencent.mobileqq.nearby.anim;

import ahym;
import ajrq;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import java.util.Random;

public class NearbyZanAnimLayout
  extends HeartLayout
{
  public NearbyZanAnimLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public NearbyZanAnimLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NearbyZanAnimLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    if (!this.abs) {}
    while ((this.b == null) || (paramBitmap == null)) {
      return;
    }
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageBitmap(paramBitmap);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.b.a(localImageView, paramFloat1, paramFloat2, this);
  }
  
  public void init()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.abs = false;
      return;
    }
    this.wM = (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 5);
    this.mRandom = new Random(System.currentTimeMillis());
    this.b = new ajrq(this);
    this.b.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout
 * JD-Core Version:    0.7.0.1
 */