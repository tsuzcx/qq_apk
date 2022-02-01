package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import arhv;
import arhv.a;
import arhv.b;
import arhw;
import com.tencent.qphone.base.util.QLog;

@TargetApi(19)
public class QQBlurView
  extends View
{
  private arhv a = new arhv();
  private ViewTreeObserver.OnPreDrawListener b = new arhw(this);
  private boolean dbj = true;
  private Drawable gm;
  
  public QQBlurView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QQBlurView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public QQBlurView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlurView", 2, "init() called " + Integer.toHexString(System.identityHashCode(this)), new Throwable());
    }
  }
  
  public void YI(int paramInt)
  {
    this.a.YI(paramInt);
  }
  
  public void YJ(int paramInt)
  {
    this.a.YJ(paramInt);
  }
  
  public void YK(int paramInt)
  {
    this.a.YH(paramInt);
  }
  
  public void a(arhv.b paramb)
  {
    this.a.a(paramb);
  }
  
  public boolean aGB()
  {
    return this.a.aGB();
  }
  
  public void ae(Drawable paramDrawable)
  {
    this.a.ae(paramDrawable);
  }
  
  public void bg(float paramFloat)
  {
    this.a.bg(paramFloat);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!aGB()) {
      super.dispatchDraw(paramCanvas);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!aGB())
    {
      super.draw(paramCanvas);
      return;
    }
    this.a.eiE();
  }
  
  public void iD(View paramView)
  {
    this.a.a(paramView);
  }
  
  public void iE(View paramView)
  {
    this.a.b(paramView);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (QLog.isColorLevel()) {
      QLog.d("QQBlurView", 2, "onAttachedToWindow() called " + Integer.toHexString(System.identityHashCode(this)));
    }
    getViewTreeObserver().removeOnPreDrawListener(this.b);
    getViewTreeObserver().addOnPreDrawListener(this.b);
    if (this.a != null) {
      onResume();
    }
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlurView", 2, "onCreate() called " + Integer.toHexString(System.identityHashCode(this)));
    }
    getViewTreeObserver().removeOnPreDrawListener(this.b);
    getViewTreeObserver().addOnPreDrawListener(this.b);
    if (!this.a.isCreated()) {
      this.a.a();
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlurView", 2, "onDestroy() called" + Integer.toHexString(System.identityHashCode(this)));
    }
    getViewTreeObserver().removeOnPreDrawListener(this.b);
    this.a.onDestroy();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (QLog.isColorLevel()) {
      QLog.d("QQBlurView", 2, "onDetachedFromWindow() called " + Integer.toHexString(System.identityHashCode(this)));
    }
    getViewTreeObserver().removeOnPreDrawListener(this.b);
    if (this.a != null) {
      onPause();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!aGB())
    {
      if (this.dbj)
      {
        setBackgroundDrawable(null);
        this.a.a(this, paramCanvas);
        super.onDraw(paramCanvas);
      }
    }
    else {
      return;
    }
    setBackgroundDrawable(this.gm);
    super.onDraw(paramCanvas);
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlurView", 2, "onPause() called" + Integer.toHexString(System.identityHashCode(this)));
    }
    this.a.onPause();
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlurView", 2, "onResume() called " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.a.onResume();
  }
  
  public void setDebugTag(String paramString)
  {
    this.a.setDebugTag(paramString);
  }
  
  public void setDirtyListener(arhv.a parama)
  {
    this.a.setDirtyListener(parama);
  }
  
  public void setDisableBlurDrawableRes(int paramInt)
  {
    this.gm = getResources().getDrawable(paramInt);
  }
  
  public void setEnableBlur(boolean paramBoolean)
  {
    this.dbj = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQBlurView
 * JD-Core Version:    0.7.0.1
 */