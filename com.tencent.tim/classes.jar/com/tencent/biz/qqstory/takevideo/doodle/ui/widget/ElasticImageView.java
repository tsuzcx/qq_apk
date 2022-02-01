package com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import ram;
import rhj;
import riu;

@TargetApi(14)
public class ElasticImageView
  extends ImageView
{
  private Matrix B;
  public final long DURATION = 200L;
  public ValueAnimator L;
  public ValueAnimator M;
  public boolean aIh;
  public boolean aIi;
  public boolean aIj = true;
  public int bse;
  public int bsf;
  public int bsg;
  public int bsh;
  public int bsi;
  public int mCenterX;
  public int mCenterY;
  public int mHeight;
  private Matrix mMatrix;
  public int mWidth;
  public float ns = 1.0F;
  public float nt = 1.0F;
  public float nu = 1.0F;
  public float nv = this.nt;
  public float nw = 1.0F;
  public float nz = 1.0F;
  
  public ElasticImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ElasticImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void YY()
  {
    float f1 = 1.0F;
    if (getDrawable() != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.aIh = bool;
      if (bool) {
        break;
      }
      return;
    }
    int i = getDrawable().getIntrinsicWidth();
    int j = getDrawable().getIntrinsicHeight();
    int k;
    int m;
    float f2;
    if (this.aIi) {
      if (i < j)
      {
        this.nz = (i / j);
        this.nw = 1.0F;
        j = i;
        if ((j <= this.bse) && (i <= this.bsf)) {
          break label388;
        }
        k = j - this.bse;
        m = i - this.bsf;
        if ((k <= 0) || (m <= 0)) {
          break label352;
        }
        f1 = this.bse / j;
        f2 = this.bsf / i;
        if (f1 >= f2) {
          break label347;
        }
      }
    }
    label388:
    for (;;)
    {
      ram.d("ElasticImageView", "drawableWidth:" + j + ",drawableHeight:" + i + ",AvaliableWidth:" + this.bse + ",AvaliableHeight:" + this.bsf + ",scaleValue:" + f1);
      this.ns = f1;
      this.nt = (this.ns * 1.1F);
      this.nu = (this.ns * 1.5F);
      this.bsg = ((int)(this.mCenterX - j / this.nw / 2.0F));
      this.bsh = ((int)(this.mCenterY - i / this.nz / 2.0F));
      return;
      if (i > j)
      {
        this.nw = (j / i);
        this.nz = 1.0F;
        i = j;
        break;
      }
      this.nw = 1.0F;
      this.nz = 1.0F;
      k = i;
      i = j;
      j = k;
      break;
      label347:
      f1 = f2;
      continue;
      label352:
      if (k > 0)
      {
        f1 = this.bse / j;
      }
      else if (m > 0)
      {
        f1 = this.bsf / i;
        continue;
        f2 = this.bse / j;
        float f3 = this.bsf / i;
        f1 = f2;
        if (f2 >= f3) {
          f1 = f3;
        }
      }
    }
  }
  
  private ValueAnimator a(float paramFloat1, float paramFloat2, long paramLong)
  {
    return rhj.a(paramLong, paramFloat1, paramFloat2, new riu(this));
  }
  
  private void af(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return;
    }
    ram.d("ElasticImageView", "updateMatrix:" + paramFloat);
    this.mMatrix.set(this.B);
    this.mMatrix.postTranslate(this.bsg, this.bsh);
    this.mMatrix.postScale(this.nw, this.nz, this.mCenterX, this.mCenterY);
    this.mMatrix.postScale(paramFloat, paramFloat, this.mCenterX, this.mCenterY);
    super.setImageMatrix(this.mMatrix);
  }
  
  private void buR()
  {
    if ((this.M != null) && (this.M.isRunning())) {
      this.M.cancel();
    }
    if ((this.L == null) || (!this.L.isRunning()))
    {
      this.L = a(this.nv, this.nu, 200L);
      this.L.start();
    }
  }
  
  private void buS()
  {
    if ((this.L != null) && (this.L.isRunning())) {
      this.L.cancel();
    }
    if ((this.M == null) || (!this.M.isRunning()))
    {
      this.M = a(this.nv, this.ns, 200L);
      this.M.start();
    }
  }
  
  private void init()
  {
    setScaleType(ImageView.ScaleType.MATRIX);
    this.B = new Matrix(getImageMatrix());
    this.mMatrix = new Matrix();
  }
  
  public void ag(float paramFloat)
  {
    if (this.nv != paramFloat)
    {
      this.nv = paramFloat;
      af(this.nv);
      super.invalidate();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mCenterX = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 2);
    this.mCenterY = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 2);
    this.bsi = (this.mCenterY * 2);
    this.bse = (this.mCenterX * 2);
    this.bsf = (this.mCenterY * 2);
    ram.d("ElasticImageView", "ImageViewWidth:" + this.mWidth + ",ImageViewHeight:" + this.mHeight + ",centerX:" + this.mCenterX + ",centerY:" + this.mCenterY + ",AvaliableWidth:" + this.bse + ",AvaliableHeight:" + this.bsf);
    YY();
    this.nv = this.ns;
    af(this.nv);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1;
    float f2;
    if ((this.aIh) && (this.aIj))
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      super.onTouchEvent(paramMotionEvent);
      return true;
      YY();
      this.nv = this.nt;
      buR();
      continue;
      if ((f1 < 0.0F) || (f1 > getWidth()) || (f2 < 0.0F) || (f2 > getHeight()))
      {
        buS();
      }
      else
      {
        buR();
        continue;
        buS();
      }
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    YY();
    this.nv = this.ns;
    af(this.nv);
  }
  
  public void setIsNeedAdjustDrawableToSquare(boolean paramBoolean)
  {
    this.aIi = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView
 * JD-Core Version:    0.7.0.1
 */