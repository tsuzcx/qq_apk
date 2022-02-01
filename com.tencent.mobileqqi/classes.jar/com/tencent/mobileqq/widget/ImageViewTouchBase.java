package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import hgs;
import hgt;

public abstract class ImageViewTouchBase
  extends ImageView
{
  static final float SCALE_RATE = 1.15F;
  private boolean bShadow = false;
  protected Matrix mBaseMatrix = new Matrix();
  protected final RotateBitmap mBitmapDisplayed = new RotateBitmap(null);
  private final Matrix mDisplayMatrix = new Matrix();
  public Handler mHandler = new Handler();
  private final float[] mMatrixValues = new float[9];
  float mMaxZoom = 3.0F;
  float mMinZoom = 0.5F;
  private Runnable mOnLayoutRunnable = null;
  private ImageViewTouchBase.Recycler mRecycler;
  protected Matrix mSuppMatrix = new Matrix();
  int mThisHeight = -1;
  int mThisWidth = -1;
  private RectF tmpRect = new RectF();
  
  public ImageViewTouchBase(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ImageViewTouchBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void getProperBaseMatrix(RotateBitmap paramRotateBitmap, Matrix paramMatrix)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    float f3 = paramRotateBitmap.c();
    float f4 = paramRotateBitmap.b();
    paramMatrix.reset();
    float f5 = Math.min(Math.min(f1 / f3, 3.0F), Math.min(f2 / f4, 3.0F));
    paramMatrix.postConcat(paramRotateBitmap.a());
    paramMatrix.postScale(f5, f5);
    paramMatrix.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
  }
  
  private void init()
  {
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private void setImageBitmap(Bitmap paramBitmap, int paramInt)
  {
    super.setImageBitmap(paramBitmap);
    Object localObject = getDrawable();
    if (localObject != null) {
      ((Drawable)localObject).setDither(true);
    }
    localObject = this.mBitmapDisplayed.a();
    this.mBitmapDisplayed.a(paramBitmap);
    this.mBitmapDisplayed.a(paramInt);
    if ((localObject != null) && (localObject != paramBitmap) && (this.mRecycler != null)) {
      this.mRecycler.a((Bitmap)localObject);
    }
  }
  
  public void SetMinZoom(float paramFloat)
  {
    this.mMinZoom = paramFloat;
  }
  
  protected void center(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f3 = 0.0F;
    if (this.mBitmapDisplayed.a() == null) {
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF = new RectF(0.0F, 0.0F, this.mBitmapDisplayed.a().getWidth(), this.mBitmapDisplayed.a().getHeight());
    localMatrix.mapRect(localRectF);
    float f1 = localRectF.height();
    float f4 = localRectF.width();
    int i;
    if (paramBoolean2)
    {
      i = getHeight();
      if (f1 < i) {
        f1 = (i - f1) / 2.0F - localRectF.top;
      }
    }
    for (;;)
    {
      float f2 = f3;
      if (paramBoolean1)
      {
        i = getWidth();
        if (f4 >= i) {
          break label208;
        }
        f2 = (i - f4) / 2.0F - localRectF.left;
      }
      for (;;)
      {
        postTranslate(f2, f1);
        setImageMatrix(getImageViewMatrix());
        return;
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break;
        }
        if (localRectF.bottom >= i) {
          break label259;
        }
        f1 = getHeight() - localRectF.bottom;
        break;
        label208:
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else
        {
          f2 = f3;
          if (localRectF.right < i) {
            f2 = i - localRectF.right;
          }
        }
      }
      label259:
      f1 = 0.0F;
    }
  }
  
  public void clear()
  {
    setImageBitmapResetBase(null, true);
  }
  
  public RectF getDisplayRect()
  {
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    if (this.mBitmapDisplayed.a() != null) {
      localRectF.set(0.0F, 0.0F, this.mBitmapDisplayed.a().getWidth(), this.mBitmapDisplayed.a().getHeight());
    }
    localMatrix.mapRect(localRectF);
    return localRectF;
  }
  
  public int getImageHeight()
  {
    return this.mBitmapDisplayed.a().getHeight();
  }
  
  protected Matrix getImageViewMatrix()
  {
    this.mDisplayMatrix.set(this.mBaseMatrix);
    this.mDisplayMatrix.postConcat(this.mSuppMatrix);
    return this.mDisplayMatrix;
  }
  
  public int getImageWidth()
  {
    return this.mBitmapDisplayed.a().getWidth();
  }
  
  public float getMaxZoom()
  {
    return this.mMaxZoom;
  }
  
  public RotateBitmap getRotateBitmap()
  {
    return this.mBitmapDisplayed;
  }
  
  public float getScale()
  {
    return getScale(this.mSuppMatrix);
  }
  
  protected float getScale(Matrix paramMatrix)
  {
    return getValue(paramMatrix, 0);
  }
  
  public RectF getShownRect()
  {
    return this.tmpRect;
  }
  
  protected float getValue(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.mMatrixValues);
    return this.mMatrixValues[paramInt];
  }
  
  protected float maxZoom()
  {
    float f1;
    if (this.mBitmapDisplayed.a() == null) {
      f1 = 1.0F;
    }
    float f2;
    do
    {
      return f1;
      f2 = Math.max(this.mBitmapDisplayed.c() / this.mThisWidth, this.mBitmapDisplayed.b() / this.mThisHeight) * 4.0F;
      f1 = f2;
    } while (f2 >= 1.0F);
    return 3.0F;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      if ((this.mBitmapDisplayed != null) && (this.mBitmapDisplayed.a() != null))
      {
        Paint localPaint = new Paint();
        Object localObject = getImageViewMatrix();
        this.tmpRect.set(0.0F, 0.0F, this.mBitmapDisplayed.a().getWidth(), this.mBitmapDisplayed.a().getHeight());
        ((Matrix)localObject).mapRect(this.tmpRect);
        if (this.bShadow)
        {
          localPaint.setStyle(Paint.Style.STROKE);
          localPaint.setStrokeWidth(1.0F);
          int j = -14606047;
          localObject = this.tmpRect;
          ((RectF)localObject).right -= 1.0F;
          int i = 0;
          while (i < 5)
          {
            localObject = this.tmpRect;
            ((RectF)localObject).left -= 1.0F;
            localObject = this.tmpRect;
            ((RectF)localObject).top -= 1.0F;
            localObject = this.tmpRect;
            ((RectF)localObject).right += 1.0F;
            localObject = this.tmpRect;
            ((RectF)localObject).bottom += 1.0F;
            localPaint.setColor(j);
            paramCanvas.drawRoundRect(this.tmpRect, i, i, localPaint);
            j += (5 - i << 16 | 5 - i << 8 | 5 - i);
            i += 1;
          }
        }
      }
      return;
    }
    catch (RuntimeException paramCanvas)
    {
      paramCanvas.printStackTrace();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (getScale() > 1.0F))
    {
      zoomTo(1.0F);
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mThisWidth = (paramInt3 - paramInt1);
    this.mThisHeight = (paramInt4 - paramInt2);
    Runnable localRunnable = this.mOnLayoutRunnable;
    if (localRunnable != null)
    {
      this.mOnLayoutRunnable = null;
      localRunnable.run();
    }
    if (this.mBitmapDisplayed.a() != null)
    {
      getProperBaseMatrix(this.mBitmapDisplayed, this.mBaseMatrix);
      setImageMatrix(getImageViewMatrix());
    }
  }
  
  public void panBy(float paramFloat1, float paramFloat2)
  {
    postTranslate(paramFloat1, paramFloat2);
    setImageMatrix(getImageViewMatrix());
  }
  
  protected void postTranslate(float paramFloat1, float paramFloat2)
  {
    this.mSuppMatrix.postTranslate(paramFloat1, paramFloat2);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    setImageBitmap(paramBitmap, 0);
  }
  
  public void setImageBitmapResetBase(Bitmap paramBitmap, boolean paramBoolean)
  {
    setImageRotateBitmapResetBase(new RotateBitmap(paramBitmap), paramBoolean);
  }
  
  public void setImageRotateBitmapResetBase(RotateBitmap paramRotateBitmap, boolean paramBoolean)
  {
    if (getWidth() <= 0)
    {
      this.mOnLayoutRunnable = new hgs(this, paramRotateBitmap, paramBoolean);
      return;
    }
    if (paramRotateBitmap.a() != null)
    {
      getProperBaseMatrix(paramRotateBitmap, this.mBaseMatrix);
      setImageBitmap(paramRotateBitmap.a(), paramRotateBitmap.a());
    }
    for (;;)
    {
      if (paramBoolean) {
        this.mSuppMatrix.reset();
      }
      setImageMatrix(getImageViewMatrix());
      this.mMaxZoom = maxZoom();
      return;
      this.mBaseMatrix.reset();
      setImageBitmap(null);
    }
  }
  
  public void setRecycler(ImageViewTouchBase.Recycler paramRecycler)
  {
    this.mRecycler = paramRecycler;
  }
  
  public void setShadow(boolean paramBoolean)
  {
    this.bShadow = paramBoolean;
  }
  
  public float zoomBy(float paramFloat)
  {
    float f1 = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    this.mSuppMatrix.postScale(paramFloat, paramFloat, f1, f2);
    setImageMatrix(getImageViewMatrix());
    center(true, true);
    return getScale();
  }
  
  public void zoomIn()
  {
    zoomIn(1.15F);
  }
  
  protected void zoomIn(float paramFloat)
  {
    if (getScale() >= this.mMaxZoom) {}
    while (this.mBitmapDisplayed.a() == null) {
      return;
    }
    float f1 = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    this.mSuppMatrix.postScale(paramFloat, paramFloat, f1, f2);
    setImageMatrix(getImageViewMatrix());
    center(true, true);
  }
  
  public void zoomOut()
  {
    zoomOut(1.15F);
  }
  
  protected void zoomOut(float paramFloat)
  {
    if (this.mBitmapDisplayed.a() == null) {
      return;
    }
    float f1 = paramFloat;
    if (getScale() / paramFloat < this.mMinZoom) {
      f1 = getScale() / this.mMinZoom;
    }
    paramFloat = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    Matrix localMatrix = new Matrix(this.mSuppMatrix);
    localMatrix.postScale(1.0F / f1, 1.0F / f1, paramFloat, f2);
    if (getScale(localMatrix) > 0.5F) {
      this.mSuppMatrix.postScale(1.0F / f1, 1.0F / f1, paramFloat, f2);
    }
    setImageMatrix(getImageViewMatrix());
    center(true, true);
  }
  
  public float zoomTo(float paramFloat)
  {
    return zoomTo(paramFloat, getWidth() / 2.0F, getHeight() / 2.0F);
  }
  
  public float zoomTo(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f;
    if (paramFloat1 > this.mMaxZoom) {
      f = this.mMaxZoom;
    }
    for (;;)
    {
      paramFloat1 = f / getScale();
      this.mSuppMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      setImageMatrix(getImageViewMatrix());
      center(true, true);
      return f;
      f = paramFloat1;
      if (paramFloat1 < this.mMinZoom) {
        f = this.mMinZoom;
      }
    }
  }
  
  protected void zoomTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = (paramFloat1 - getScale()) / paramFloat4;
    float f = getScale();
    long l = System.currentTimeMillis();
    this.mHandler.post(new hgt(this, paramFloat4, l, f, paramFloat1, paramFloat2, paramFloat3));
  }
  
  public void zoomToPoint(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    panBy(f1 - paramFloat2, f2 - paramFloat3);
    zoomTo(paramFloat1, f1, f2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ImageViewTouchBase
 * JD-Core Version:    0.7.0.1
 */