package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import ram;
import rom;

public class BaseScaleAndMoveBitmapView
  extends View
{
  private ScaleGestureDetector a = new ScaleGestureDetector(paramContext, new b(null));
  private boolean isClick;
  protected Bitmap mBitmap;
  private GestureDetector mGestureDetector = new GestureDetector(paramContext, new a(null));
  protected float mScaleFactor = 1.0F;
  private float maxScale = 5.0F;
  private float minScale = 0.1F;
  private boolean needResize;
  protected float pd;
  protected float pe;
  
  public BaseScaleAndMoveBitmapView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseScaleAndMoveBitmapView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseScaleAndMoveBitmapView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void dZu()
  {
    if ((this.mBitmap == null) || (this.mBitmap.isRecycled()))
    {
      rom.fail("call resize when bitmap is invalid", new Object[0]);
      return;
    }
    this.needResize = false;
    this.mScaleFactor = Math.min(getWidth() * 0.1F / (this.mBitmap.getWidth() * 0.1F), getHeight() * 0.1F / (this.mBitmap.getHeight() * 0.1F));
    float f1 = getHeight() * 0.1F / (getWidth() * 0.1F);
    float f2 = this.mBitmap.getHeight() * 0.1F / (this.mBitmap.getWidth() * 0.1F);
    if (f1 > f2)
    {
      this.pd = 0.0F;
      this.pe = ((int)((getHeight() - f2 * getWidth()) / 2.0F / this.mScaleFactor));
    }
    for (;;)
    {
      setScaleRange(1.0F, 4.0F);
      ram.w("QQ.Troop.homework.BaseScaleAndMoveBitmapView", "setImageBitmap mScaleFactor=" + this.mScaleFactor + ",mPosX=" + this.pd + ",mPosY=" + this.pe);
      return;
      this.pe = 0.0F;
      this.pd = ((int)((getWidth() - getHeight() / f2) / 2.0F / this.mScaleFactor));
    }
  }
  
  protected float H(float paramFloat)
  {
    return (this.pd + paramFloat) * this.mScaleFactor;
  }
  
  protected float I(float paramFloat)
  {
    return (this.pe + paramFloat) * this.mScaleFactor;
  }
  
  protected void ad(MotionEvent paramMotionEvent) {}
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.needResize) {
      dZu();
    }
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()))
    {
      paramCanvas.scale(this.mScaleFactor, this.mScaleFactor, 0.0F, 0.0F);
      paramCanvas.drawBitmap(this.mBitmap, this.pd, this.pe, null);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mBitmap == null)
    {
      if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 1)) {
        ram.w("QQ.Troop.homework.BaseScaleAndMoveBitmapView", "when on touch the mBitmap is null");
      }
      return false;
    }
    this.a.onTouchEvent(paramMotionEvent);
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.isClick = true;
      continue;
      if (this.isClick)
      {
        ad(paramMotionEvent);
        continue;
        this.isClick = false;
      }
    }
  }
  
  public void setImageBitmap(@NonNull Bitmap paramBitmap)
  {
    ram.w("QQ.Troop.homework.BaseScaleAndMoveBitmapView", "setImageBitmap bitmap w=" + paramBitmap.getWidth() + ",h=" + paramBitmap.getHeight());
    this.mBitmap = paramBitmap.copy(paramBitmap.getConfig(), false);
    if ((getWidth() <= 0) || (getHeight() <= 0))
    {
      this.needResize = true;
      return;
    }
    dZu();
    invalidate();
  }
  
  public void setScaleRange(float paramFloat1, float paramFloat2)
  {
    this.minScale = (this.mScaleFactor * paramFloat1);
    this.maxScale = (this.mScaleFactor * paramFloat2);
  }
  
  class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      float f2 = 0.0F;
      BaseScaleAndMoveBitmapView.a(BaseScaleAndMoveBitmapView.this, false);
      float f3 = BaseScaleAndMoveBitmapView.this.pd - paramFloat1 / BaseScaleAndMoveBitmapView.this.mScaleFactor;
      float f4 = BaseScaleAndMoveBitmapView.this.pe;
      float f5 = paramFloat2 / BaseScaleAndMoveBitmapView.this.mScaleFactor;
      float f1;
      if ((paramFloat1 < 0.0F) && (BaseScaleAndMoveBitmapView.this.H(0.0F) >= 0.0F))
      {
        f1 = 0.0F;
        if (BaseScaleAndMoveBitmapView.this.mBitmap.getHeight() * BaseScaleAndMoveBitmapView.this.mScaleFactor > BaseScaleAndMoveBitmapView.this.getHeight()) {
          break label247;
        }
        paramFloat1 = (BaseScaleAndMoveBitmapView.this.getHeight() - BaseScaleAndMoveBitmapView.this.mBitmap.getHeight() * BaseScaleAndMoveBitmapView.this.mScaleFactor) / 2.0F / BaseScaleAndMoveBitmapView.this.mScaleFactor;
      }
      for (;;)
      {
        BaseScaleAndMoveBitmapView.this.pd = f1;
        BaseScaleAndMoveBitmapView.this.pe = paramFloat1;
        BaseScaleAndMoveBitmapView.this.invalidate();
        return true;
        f1 = f3;
        if (paramFloat1 <= 0.0F) {
          break;
        }
        f1 = f3;
        if (BaseScaleAndMoveBitmapView.this.H(BaseScaleAndMoveBitmapView.this.mBitmap.getWidth()) > BaseScaleAndMoveBitmapView.this.getWidth()) {
          break;
        }
        f1 = BaseScaleAndMoveBitmapView.this.getWidth() / BaseScaleAndMoveBitmapView.this.mScaleFactor - BaseScaleAndMoveBitmapView.this.mBitmap.getWidth();
        break;
        label247:
        if (paramFloat2 < 0.0F)
        {
          paramFloat1 = f2;
          if (BaseScaleAndMoveBitmapView.this.I(0.0F) >= 0.0F) {}
        }
        else if ((paramFloat2 > 0.0F) && (BaseScaleAndMoveBitmapView.this.I(BaseScaleAndMoveBitmapView.this.mBitmap.getHeight()) <= BaseScaleAndMoveBitmapView.this.getHeight()))
        {
          paramFloat1 = BaseScaleAndMoveBitmapView.this.getHeight() / BaseScaleAndMoveBitmapView.this.mScaleFactor - BaseScaleAndMoveBitmapView.this.mBitmap.getHeight();
        }
        else
        {
          paramFloat1 = f4 - f5;
        }
      }
    }
  }
  
  class b
    extends ScaleGestureDetector.SimpleOnScaleGestureListener
  {
    private b() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      BaseScaleAndMoveBitmapView.a(BaseScaleAndMoveBitmapView.this, false);
      BaseScaleAndMoveBitmapView localBaseScaleAndMoveBitmapView = BaseScaleAndMoveBitmapView.this;
      localBaseScaleAndMoveBitmapView.mScaleFactor *= paramScaleGestureDetector.getScaleFactor();
      BaseScaleAndMoveBitmapView.this.mScaleFactor = Math.max(BaseScaleAndMoveBitmapView.a(BaseScaleAndMoveBitmapView.this), Math.min(BaseScaleAndMoveBitmapView.this.mScaleFactor, BaseScaleAndMoveBitmapView.b(BaseScaleAndMoveBitmapView.this)));
      if (BaseScaleAndMoveBitmapView.this.mBitmap.getHeight() * BaseScaleAndMoveBitmapView.this.mScaleFactor <= BaseScaleAndMoveBitmapView.this.getHeight())
      {
        BaseScaleAndMoveBitmapView.this.pe = ((BaseScaleAndMoveBitmapView.this.getHeight() - BaseScaleAndMoveBitmapView.this.mBitmap.getHeight() * BaseScaleAndMoveBitmapView.this.mScaleFactor) / 2.0F / BaseScaleAndMoveBitmapView.this.mScaleFactor);
        if (BaseScaleAndMoveBitmapView.this.mBitmap.getWidth() * BaseScaleAndMoveBitmapView.this.mScaleFactor > BaseScaleAndMoveBitmapView.this.getWidth()) {
          break label323;
        }
        BaseScaleAndMoveBitmapView.this.pd = ((BaseScaleAndMoveBitmapView.this.getWidth() - BaseScaleAndMoveBitmapView.this.mBitmap.getWidth() * BaseScaleAndMoveBitmapView.this.mScaleFactor) / 2.0F);
      }
      for (;;)
      {
        ram.b("QQ.Troop.homework.BaseScaleAndMoveBitmapView", "onScale %f", Float.valueOf(BaseScaleAndMoveBitmapView.this.mScaleFactor));
        BaseScaleAndMoveBitmapView.this.invalidate();
        return true;
        if (BaseScaleAndMoveBitmapView.this.I(0.0F) >= 0.0F)
        {
          BaseScaleAndMoveBitmapView.this.pe = 0.0F;
          break;
        }
        if (BaseScaleAndMoveBitmapView.this.I(BaseScaleAndMoveBitmapView.this.mBitmap.getHeight()) > BaseScaleAndMoveBitmapView.this.getHeight()) {
          break;
        }
        BaseScaleAndMoveBitmapView.this.pe = (BaseScaleAndMoveBitmapView.this.getHeight() / BaseScaleAndMoveBitmapView.this.mScaleFactor - BaseScaleAndMoveBitmapView.this.mBitmap.getHeight());
        break;
        label323:
        if (BaseScaleAndMoveBitmapView.this.H(0.0F) >= 0.0F) {
          BaseScaleAndMoveBitmapView.this.pd = 0.0F;
        } else if (BaseScaleAndMoveBitmapView.this.H(BaseScaleAndMoveBitmapView.this.mBitmap.getWidth()) <= BaseScaleAndMoveBitmapView.this.getWidth()) {
          BaseScaleAndMoveBitmapView.this.pd = (BaseScaleAndMoveBitmapView.this.getWidth() / BaseScaleAndMoveBitmapView.this.mScaleFactor - BaseScaleAndMoveBitmapView.this.mBitmap.getWidth());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.BaseScaleAndMoveBitmapView
 * JD-Core Version:    0.7.0.1
 */