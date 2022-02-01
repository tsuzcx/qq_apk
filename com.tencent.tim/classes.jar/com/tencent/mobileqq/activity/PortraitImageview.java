package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import com.tencent.mobileqq.activity.photo.RegionView;

@SuppressLint({"NewApi"})
public class PortraitImageview
  extends View
{
  private static int padding = 20;
  ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  b jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview$b;
  RegionView jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView;
  RectF ac = new RectF();
  RectF ad = new RectF();
  RectF ae = new RectF();
  int bIU;
  int bIV;
  private double bv;
  int centerX;
  int centerY;
  int clipHeight;
  int clipWidth;
  private Runnable dX;
  Runnable dY = null;
  float defaultScale;
  float density;
  private int mActivePointerId = -1;
  private Matrix mBaseMatrix = new Matrix();
  private Bitmap mBitmap;
  private Matrix mDisplayMatrix = new Matrix();
  private GestureDetector mGestureDetector;
  private float mLastTouchX;
  private float mLastTouchY;
  private Matrix mMatrix = new Matrix();
  private float[] mMatrixValues = new float[9];
  private float mMaxZoom;
  private Runnable mOnLayoutRunnable;
  private Paint mPaint;
  private Matrix mSuppMatrix = new Matrix();
  private Matrix mTempMatrix = new Matrix();
  private int mThisHeight = -1;
  private int mThisWidth = -1;
  private float pd;
  private float pe;
  
  public PortraitImageview(Context paramContext)
  {
    this(paramContext, null);
    this.density = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public PortraitImageview(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PortraitImageview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private int a(RectF paramRectF1, RectF paramRectF2)
  {
    int j = 0;
    if (paramRectF1.left > paramRectF2.left) {
      j = 1;
    }
    int i = j;
    if (paramRectF1.right < paramRectF2.right) {
      i = j | 0x2;
    }
    j = i;
    if (paramRectF1.top > paramRectF2.top) {
      j = i | 0x4;
    }
    i = j;
    if (paramRectF1.bottom < paramRectF2.bottom) {
      i = j | 0x8;
    }
    return i;
  }
  
  private void a(Bitmap paramBitmap, Matrix paramMatrix)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    paramMatrix.reset();
    float f3 = this.clipWidth / paramBitmap.getWidth();
    float f4 = this.clipHeight / paramBitmap.getHeight();
    if ((f3 >= 1.0F) || (f4 >= 1.0F)) {
      this.defaultScale = Math.max(f3, f4);
    }
    for (;;)
    {
      paramMatrix.setScale(this.defaultScale, this.defaultScale);
      paramMatrix.postTranslate((f1 - paramBitmap.getWidth() * this.defaultScale) / 2.0F, (f2 - paramBitmap.getHeight() * this.defaultScale) / 2.0F);
      this.ad.left = 0.0F;
      this.ad.right = (this.ad.left + paramBitmap.getWidth());
      this.ad.top = 0.0F;
      this.ad.bottom = (this.ad.top + paramBitmap.getHeight());
      paramMatrix.mapRect(this.ad);
      return;
      float f5 = f1 / paramBitmap.getWidth();
      float f6 = f2 / paramBitmap.getHeight();
      this.defaultScale = Math.min(f5, f5);
      if (this.defaultScale >= 1.0F) {
        this.defaultScale = 1.0F;
      } else if ((this.defaultScale < f3) || (this.defaultScale < f4)) {
        this.defaultScale = Math.max(f5, f6);
      }
    }
  }
  
  private void init(Context paramContext)
  {
    this.mPaint = new Paint();
    this.mPaint.setDither(true);
    this.mPaint.setFilterBitmap(true);
    this.mPaint.setAntiAlias(true);
    this.dX = new PortraitImageview.1(this);
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, new c());
    this.mGestureDetector = new GestureDetector(paramContext, new a(null));
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(2, null);
    }
  }
  
  public float aH()
  {
    if (this.mBitmap == null) {
      return 1.0F;
    }
    return Math.max(Math.min(this.mThisWidth / this.mBitmap.getWidth(), this.mThisHeight / this.mBitmap.getHeight()), 1.0F);
  }
  
  public Bitmap ac()
  {
    return this.mBitmap;
  }
  
  public void am(float paramFloat)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    d(paramFloat, f1 / 2.0F, f2 / 2.0F);
  }
  
  float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat1 / paramFloat4 - 1.0F;
    return (paramFloat1 * (paramFloat1 * paramFloat1) + 1.0F) * paramFloat3 + paramFloat2;
  }
  
  protected void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = paramFloat3;
    if (paramFloat3 > this.ac.bottom) {
      f1 = this.ac.bottom;
    }
    float f2 = f1;
    if (f1 < this.ac.top) {
      f2 = this.ac.top;
    }
    paramFloat3 = paramFloat2;
    if (paramFloat2 > this.ac.right) {
      paramFloat3 = this.ac.right;
    }
    paramFloat2 = paramFloat3;
    if (paramFloat3 < this.ac.left) {
      paramFloat2 = this.ac.left;
    }
    this.mTempMatrix.set(this.mSuppMatrix);
    this.mTempMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, f2);
    this.mTempMatrix.mapRect(this.ae, this.ad);
    if (a(this.ae, this.ac) == 0) {
      this.mSuppMatrix.set(this.mTempMatrix);
    }
    while ((this.ae.width() / this.ac.width() < 1.0F) || (this.ae.height() / this.ac.height() < 1.0F)) {
      return;
    }
    this.mSuppMatrix.mapRect(this.ae, this.ad);
    paramFloat2 = this.ac.width() / this.ae.width();
    paramFloat3 = this.ac.height() / this.ae.height();
    if (paramFloat2 >= paramFloat3) {}
    for (;;)
    {
      paramFloat3 = (this.ac.centerX() - this.ae.centerX() * paramFloat2) / (1.0F - paramFloat2);
      paramFloat2 = (this.ac.centerY() - this.ae.centerY() * paramFloat2) / (1.0F - paramFloat2);
      this.mSuppMatrix.postScale(paramFloat1, paramFloat1, paramFloat3, paramFloat2);
      return;
      paramFloat2 = paramFloat3;
    }
  }
  
  public void d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = paramFloat1;
    if (paramFloat1 > this.mMaxZoom) {
      f = this.mMaxZoom;
    }
    c(f / getScale(), paramFloat2, paramFloat3);
    setImageMatrix(getImageViewMatrix());
  }
  
  public RectF f()
  {
    return this.ac;
  }
  
  public int getClipHeight()
  {
    return this.clipHeight;
  }
  
  public int getClipWidth()
  {
    return this.clipWidth;
  }
  
  public Matrix getImageViewMatrix()
  {
    this.mDisplayMatrix.set(this.mBaseMatrix);
    this.mDisplayMatrix.postConcat(this.mSuppMatrix);
    return this.mDisplayMatrix;
  }
  
  public float getScale()
  {
    return getScale(this.mSuppMatrix);
  }
  
  protected float getScale(Matrix paramMatrix)
  {
    if (this.mBitmap != null) {
      return getValue(paramMatrix, 0);
    }
    return 1.0F;
  }
  
  protected float getValue(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.mMatrixValues);
    return this.mMatrixValues[paramInt];
  }
  
  protected float maxZoom()
  {
    if (this.mBitmap == null) {
      return 1.0F;
    }
    return Math.max(this.mBitmap.getWidth() / this.mThisWidth, this.mBitmap.getHeight() / this.mThisHeight) * 16.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()))
    {
      if ((Build.VERSION.SDK_INT < 11) || (getLayerType() != 2)) {
        break label57;
      }
      paramCanvas.drawBitmap(this.mBitmap, this.mMatrix, null);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i);
      return;
      label57:
      if (System.currentTimeMillis() - this.bv > 250.0D)
      {
        paramCanvas.drawBitmap(this.mBitmap, this.mMatrix, this.mPaint);
        this.bv = System.currentTimeMillis();
      }
      else
      {
        paramCanvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        removeCallbacks(this.dX);
        postDelayed(this.dX, 250L);
      }
    }
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
    if (this.mBitmap != null)
    {
      a(this.mBitmap, this.mBaseMatrix);
      setImageMatrix(getImageViewMatrix());
    }
    this.centerX = (getWidth() / 2);
    this.centerY = (getHeight() / 2);
    setRestrict(this.bIU, this.bIV);
    this.ac.left = (this.centerX - this.clipWidth / 2);
    this.ac.right = (this.centerX + this.clipWidth / 2);
    this.ac.top = (this.centerY - this.clipHeight / 2);
    this.ac.bottom = (this.centerY + this.clipHeight / 2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if (this.mBitmap != null)
    {
      this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
      if (!this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress()) {
        this.mGestureDetector.onTouchEvent(paramMotionEvent);
      }
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
    }
    label231:
    int j;
    do
    {
      do
      {
        return true;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.mLastTouchX = f1;
        this.mLastTouchY = f2;
        this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        return true;
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      } while ((i == -1) || (i >= paramMotionEvent.getPointerCount()));
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      float f3;
      float f4;
      if (!this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress())
      {
        f3 = f1 - this.mLastTouchX;
        f4 = f2 - this.mLastTouchY;
        if (this.ac == null) {
          break label231;
        }
        this.pd = (f3 + this.pd);
      }
      for (this.pe += f4;; this.pe += f4)
      {
        invalidate();
        this.mLastTouchX = f1;
        this.mLastTouchY = f2;
        return true;
        this.pd = (f3 + this.pd);
      }
      this.mActivePointerId = -1;
      return true;
      this.mActivePointerId = -1;
      return true;
      j = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    } while (paramMotionEvent.getPointerId(j) != this.mActivePointerId);
    if (j == 0) {
      i = 1;
    }
    this.mLastTouchX = paramMotionEvent.getX(i);
    this.mLastTouchY = paramMotionEvent.getY(i);
    this.mActivePointerId = paramMotionEvent.getPointerId(i);
    return true;
  }
  
  protected void postTranslate(float paramFloat1, float paramFloat2)
  {
    this.mTempMatrix.set(this.mSuppMatrix);
    this.mTempMatrix.postTranslate(paramFloat1, paramFloat2);
    this.mTempMatrix.mapRect(this.ae, this.ad);
    int i = a(this.ae, this.ac);
    if (((i & 0x1) == 0) && ((i & 0x2) == 0)) {
      this.mSuppMatrix.postTranslate(paramFloat1, 0.0F);
    }
    if (((i & 0x4) == 0) && ((i & 0x8) == 0)) {
      this.mSuppMatrix.postTranslate(0.0F, paramFloat2);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    if (getWidth() <= 0)
    {
      this.mOnLayoutRunnable = new PortraitImageview.2(this, paramBitmap);
      return;
    }
    if (paramBitmap != null) {
      a(paramBitmap, this.mBaseMatrix);
    }
    for (this.mBitmap = paramBitmap;; this.mBitmap = paramBitmap)
    {
      this.mSuppMatrix.reset();
      setImageMatrix(getImageViewMatrix());
      this.mMaxZoom = maxZoom();
      return;
      this.mBaseMatrix.reset();
    }
  }
  
  public void setImageMatrix(Matrix paramMatrix)
  {
    Matrix localMatrix = paramMatrix;
    if (paramMatrix != null)
    {
      localMatrix = paramMatrix;
      if (paramMatrix.isIdentity()) {
        localMatrix = null;
      }
    }
    if (((localMatrix == null) && (!this.mMatrix.isIdentity())) || ((localMatrix != null) && (!this.mMatrix.equals(localMatrix))))
    {
      this.mMatrix.set(localMatrix);
      invalidate();
    }
  }
  
  public void setOnImageTouchedListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview$b = paramb;
  }
  
  public void setRegionView(RegionView paramRegionView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView = paramRegionView;
  }
  
  public void setRestrict(int paramInt1, int paramInt2)
  {
    this.bIU = paramInt1;
    this.bIV = paramInt2;
    if ((this.mThisWidth > 0) && ((this.bIU > this.mThisWidth) || (this.bIV > this.mThisHeight)))
    {
      float f1 = (this.mThisWidth - padding * this.density) / this.bIU;
      float f2 = (this.mThisHeight - padding * this.density) / this.bIV;
      if (f1 <= f2)
      {
        this.clipWidth = ((int)(this.bIU * f1));
        this.clipHeight = ((int)(f1 * this.bIV));
        return;
      }
      this.clipWidth = ((int)(this.bIU * f2));
      this.clipHeight = ((int)(this.bIV * f2));
      return;
    }
    this.clipWidth = this.bIU;
    this.clipHeight = this.bIV;
  }
  
  public void zoomTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = (paramFloat1 - getScale()) / paramFloat4;
    float f = getScale();
    post(new PortraitImageview.3(this, paramFloat4, System.currentTimeMillis(), f, paramFloat1, paramFloat2, paramFloat3));
  }
  
  class a
    extends PortraitImageview.d
  {
    private a() {}
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      if (PortraitImageview.this.getScale() > PortraitImageview.this.aH()) {
        PortraitImageview.this.am(PortraitImageview.this.aH());
      }
      for (;;)
      {
        return true;
        PortraitImageview.this.zoomTo(PortraitImageview.this.aH() * 3.0F, paramMotionEvent.getX(), paramMotionEvent.getY(), 350.0F);
      }
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (((paramMotionEvent1 != null) && (paramMotionEvent1.getPointerCount() > 1)) || ((paramMotionEvent2 != null) && (paramMotionEvent2.getPointerCount() > 1)) || ((PortraitImageview.this.jdField_a_of_type_AndroidViewScaleGestureDetector != null) && (PortraitImageview.this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress()))) {
        return false;
      }
      PortraitImageview.this.removeCallbacks(PortraitImageview.this.dY);
      PortraitImageview.this.postTranslate(-paramFloat1, -paramFloat2);
      PortraitImageview.this.setImageMatrix(PortraitImageview.this.getImageViewMatrix());
      return true;
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      if (PortraitImageview.this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview$b != null)
      {
        PortraitImageview.this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview$b.bSw();
        return false;
      }
      return super.onSingleTapConfirmed(paramMotionEvent);
    }
  }
  
  public static abstract interface b
  {
    public abstract void bSw();
  }
  
  class c
    extends PortraitImageview.e
  {
    c() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.isInProgress())) {
        try
        {
          float f1 = PortraitImageview.this.getScale();
          float f2 = paramScaleGestureDetector.getScaleFactor();
          f1 = Math.min(PortraitImageview.this.maxZoom(), Math.max(f1 * f2, 0.1F));
          PortraitImageview.this.d(f1, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
          PortraitImageview.this.invalidate();
          return true;
        }
        catch (IllegalArgumentException paramScaleGestureDetector)
        {
          paramScaleGestureDetector.printStackTrace();
        }
      }
      return false;
    }
  }
  
  public static class d
    implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
  {
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent) {}
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public void onShowPress(MotionEvent paramMotionEvent) {}
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  public static class e
    implements ScaleGestureDetector.OnScaleGestureListener
  {
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      return false;
    }
    
    public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      return true;
    }
    
    public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PortraitImageview
 * JD-Core Version:    0.7.0.1
 */