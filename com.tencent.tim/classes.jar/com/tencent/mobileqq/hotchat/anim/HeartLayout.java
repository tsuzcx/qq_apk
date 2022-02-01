package com.tencent.mobileqq.hotchat.anim;

import ahym;
import ahym.a;
import ahym.c;
import ahyo;
import alen;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqqx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder.AnimationView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class HeartLayout
  extends RelativeLayout
  implements ahym.c
{
  public static final int[] colors = { Color.parseColor("#c797ff"), Color.parseColor("#80b9f4"), Color.parseColor("#67d0d7"), Color.parseColor("#67d78e"), Color.parseColor("#b5e255"), Color.parseColor("#f2c64f"), Color.parseColor("#f6a455"), Color.parseColor("#ff96b9"), Color.parseColor("#ff6a6a") };
  public static int dcs;
  public static Bitmap[] o;
  public a a;
  public boolean abs = true;
  public ahym b;
  public AtomicInteger br = new AtomicInteger(0);
  public Rect ce;
  public boolean cjb;
  public boolean cjc;
  public int height;
  public Random mRandom;
  public float wK;
  public float wL;
  public float wM;
  public int width;
  
  public HeartLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public HeartLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public HeartLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void S(float paramFloat1, float paramFloat2)
  {
    if (this.ce == null) {
      if (this.a != null) {
        this.a.a(this, paramFloat1, paramFloat2);
      }
    }
    while ((paramFloat1 < this.ce.left) || (paramFloat1 > this.ce.right) || (paramFloat2 < this.ce.top) || (paramFloat2 > this.ce.bottom) || (this.a == null)) {
      return;
    }
    this.a.a(this, paramFloat1, paramFloat2);
  }
  
  public void a(alen paramalen, Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    a(paramalen, paramBitmap, paramFloat1, paramFloat2, -1L, 0);
  }
  
  public void a(alen paramalen, Bitmap paramBitmap, float paramFloat1, float paramFloat2, long paramLong, int paramInt)
  {
    if (!this.abs) {}
    while ((this.b == null) || (paramBitmap == null)) {
      return;
    }
    String str = null;
    Bundle localBundle = null;
    Object localObject2 = localBundle;
    Object localObject1 = str;
    if (paramalen != null)
    {
      if (paramBitmap == paramalen.fS)
      {
        localObject1 = paramalen.bWe;
        localObject2 = paramalen.fS;
      }
    }
    else
    {
      paramalen = new URLImageView(getContext());
      if (localObject1 == null) {
        break label255;
      }
      str = "praise?seed=" + this.br.getAndIncrement();
      localObject2 = new BitmapDrawable(getResources(), (Bitmap)localObject2);
      localBundle = new Bundle();
      localBundle.getBoolean("key_use_cache", false);
      localObject1 = aqqx.a(BaseApplicationImpl.sApplication.getRuntime(), (String)localObject1, str, (Drawable)localObject2, new int[] { 14, 9, 15 }, "-praise-", localBundle);
      if (localObject1 == null) {
        break label239;
      }
      paramalen.setImageDrawable((Drawable)localObject1);
    }
    for (;;)
    {
      paramalen.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.b.a(paramalen, paramFloat1, paramFloat2, this, paramLong, paramInt);
      return;
      localObject2 = localBundle;
      localObject1 = str;
      if (paramBitmap != paramalen.fR) {
        break;
      }
      localObject1 = paramalen.bWd;
      localObject2 = paramalen.fR;
      break;
      label239:
      QLog.e("HeartLayout", 1, "addHeartWithDrawable apng.so load fail.");
      paramalen.setImageBitmap(paramBitmap);
      continue;
      label255:
      paramalen.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(alen paramalen, Bitmap paramBitmap, QQAppInterface paramQQAppInterface, ahyo paramahyo, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((!this.abs) || (this.b == null)) {
      return;
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    paramQQAppInterface = new PayLikeFloatViewBuilder.AnimationView(getContext(), paramQQAppInterface, paramahyo);
    URLImageView localURLImageView = new URLImageView(getContext());
    paramahyo = new RelativeLayout.LayoutParams(-2, -2);
    paramahyo.addRule(13);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    localRelativeLayout.addView(localURLImageView, paramahyo);
    localRelativeLayout.addView(paramQQAppInterface, (ViewGroup.LayoutParams)localObject1);
    localObject1 = null;
    Object localObject2 = null;
    paramahyo = localObject2;
    paramQQAppInterface = (QQAppInterface)localObject1;
    if (paramalen != null)
    {
      if (paramBitmap == paramalen.fS)
      {
        paramQQAppInterface = paramalen.bWe;
        paramahyo = paramalen.fS;
      }
    }
    else
    {
      if (paramQQAppInterface == null) {
        break label333;
      }
      paramalen = "praise?seed=" + this.br.getAndIncrement();
      paramahyo = new BitmapDrawable(getResources(), paramahyo);
      localObject1 = new Bundle();
      ((Bundle)localObject1).getBoolean("key_use_cache", false);
      paramalen = aqqx.a(BaseApplicationImpl.sApplication.getRuntime(), paramQQAppInterface, paramalen, paramahyo, new int[] { 14, 9, 15 }, "-praise-", (Bundle)localObject1);
      if (paramalen == null) {
        break label316;
      }
      localURLImageView.setImageDrawable(paramalen);
    }
    for (;;)
    {
      localURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.b.a(localRelativeLayout, paramFloat1, paramFloat2, paramInt1, paramInt2, this, -1L, 0);
      return;
      paramahyo = localObject2;
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (paramBitmap != paramalen.fR) {
        break;
      }
      paramQQAppInterface = paramalen.bWd;
      paramahyo = paramalen.fR;
      break;
      label316:
      QLog.e("HeartLayout", 1, "addHeartWithDrawable apng.so load fail.");
      localURLImageView.setImageBitmap(paramBitmap);
      continue;
      label333:
      localURLImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    a(null, paramBitmap, paramFloat1, paramFloat2, -1L, 0);
  }
  
  public void a(Bitmap paramBitmap, QQAppInterface paramQQAppInterface, ahyo paramahyo, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    a(null, paramBitmap, paramQQAppInterface, paramahyo, paramFloat1, paramFloat2, paramInt1, paramInt2);
  }
  
  public ahym.a b()
  {
    if (this.b != null) {
      return this.b.a();
    }
    return null;
  }
  
  public void clearAnimation()
  {
    super.clearAnimation();
    if (!this.abs) {
      return;
    }
    int i = 0;
    while (i < super.getChildCount())
    {
      super.getChildAt(i).clearAnimation();
      i += 1;
    }
    super.removeAllViews();
  }
  
  public void g(Animation paramAnimation)
  {
    if (this.a != null) {
      this.a.g(paramAnimation);
    }
  }
  
  public void h(Animation paramAnimation)
  {
    if (this.a != null) {
      this.a.h(paramAnimation);
    }
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
    this.b = new ahym(this);
    this.b.a(this);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.width = super.getMeasuredWidth();
    this.height = super.getMeasuredHeight();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!this.cjc) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!this.abs);
      bool1 = bool2;
    } while (!super.isEnabled());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.wK = paramMotionEvent.getX();
      this.wL = paramMotionEvent.getY();
      this.cjb = true;
      continue;
      if (this.cjb)
      {
        this.cjb = false;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        double d = Math.pow(f1 - this.wK, 2.0D);
        if ((float)Math.sqrt(Math.pow(f2 - this.wL, 2.0D) + d) <= this.wM) {
          S(paramMotionEvent.getX(), paramMotionEvent.getY());
        }
      }
    }
  }
  
  public void setCanDoAnim(boolean paramBoolean)
  {
    this.abs = paramBoolean;
    if (Build.VERSION.SDK_INT < 11) {
      this.abs = false;
    }
    if (!this.abs)
    {
      int i = super.getChildCount() - 1;
      if (i >= 0)
      {
        View localView = getChildAt(i);
        if (localView == null) {}
        for (;;)
        {
          i -= 1;
          break;
          Boolean localBoolean = (Boolean)localView.getTag(2131374881);
          if ((localBoolean != null) && (localBoolean.booleanValue()))
          {
            localView.clearAnimation();
            super.removeView(localView);
          }
        }
      }
    }
  }
  
  public void setHeartListener(a parama)
  {
    this.a = parama;
  }
  
  public void setListenTouchEvent(boolean paramBoolean)
  {
    this.cjc = paramBoolean;
  }
  
  public void setSpecialHeart(int paramInt, Set<String> paramSet)
  {
    if (!this.abs) {}
    do
    {
      return;
      if (paramInt >= 0) {
        dcs = paramInt;
      }
    } while ((paramSet == null) || (paramSet.size() <= 0));
    o = new Bitmap[paramSet.size()];
    paramSet = paramSet.iterator();
    paramInt = 0;
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (!TextUtils.isEmpty(str)) {}
      try
      {
        o[paramInt] = BitmapFactory.decodeFile(str);
        label85:
        paramInt += 1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        break label85;
      }
    }
  }
  
  public void setValidRect(Rect paramRect)
  {
    this.ce = paramRect;
  }
  
  public static abstract interface a
  {
    public abstract void a(HeartLayout paramHeartLayout, float paramFloat1, float paramFloat2);
    
    public abstract void g(Animation paramAnimation);
    
    public abstract void h(Animation paramAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.anim.HeartLayout
 * JD-Core Version:    0.7.0.1
 */