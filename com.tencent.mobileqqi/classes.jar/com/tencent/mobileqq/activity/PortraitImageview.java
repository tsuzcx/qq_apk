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
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.tencent.mobileqq.activity.photo.RegionView;
import czo;
import czp;
import czq;
import czr;
import czs;
import czt;

@SuppressLint({"NewApi"})
public class PortraitImageview
  extends View
{
  static final float jdField_a_of_type_Float = 7.0F;
  static final int jdField_a_of_type_Int = 250;
  static final float jdField_b_of_type_Float = 1.25F;
  static final int jdField_b_of_type_Int = 500;
  private static int k = 20;
  private static final int l = 0;
  private static final int m = 1;
  private static final int n = 2;
  private static final int o = 4;
  private static final int p = 8;
  private static final int q = -1;
  private double jdField_a_of_type_Double = 0.0D;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public ScaleGestureDetector a;
  public PortraitImageview.OnImageTouchedListener a;
  RegionView jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView;
  public Runnable a;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private Runnable jdField_b_of_type_JavaLangRunnable = null;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  private Matrix jdField_c_of_type_AndroidGraphicsMatrix = new Matrix();
  RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private Runnable jdField_c_of_type_JavaLangRunnable = null;
  float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  private Matrix jdField_d_of_type_AndroidGraphicsMatrix = new Matrix();
  private float jdField_e_of_type_Float;
  int jdField_e_of_type_Int;
  private Matrix jdField_e_of_type_AndroidGraphicsMatrix = new Matrix();
  private float jdField_f_of_type_Float;
  int jdField_f_of_type_Int;
  private float jdField_g_of_type_Float;
  int jdField_g_of_type_Int;
  private float jdField_h_of_type_Float;
  int jdField_h_of_type_Int;
  private float jdField_i_of_type_Float;
  private int jdField_i_of_type_Int = -1;
  private int j = -1;
  private int r = -1;
  
  public PortraitImageview(Context paramContext)
  {
    this(paramContext, null);
    this.jdField_c_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public PortraitImageview(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PortraitImageview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangRunnable = null;
    a(paramContext);
  }
  
  private int a(RectF paramRectF1, RectF paramRectF2)
  {
    int i2 = 0;
    if (paramRectF1.left > paramRectF2.left) {
      i2 = 1;
    }
    int i1 = i2;
    if (paramRectF1.right < paramRectF2.right) {
      i1 = i2 | 0x2;
    }
    i2 = i1;
    if (paramRectF1.top > paramRectF2.top) {
      i2 = i1 | 0x4;
    }
    i1 = i2;
    if (paramRectF1.bottom < paramRectF2.bottom) {
      i1 = i2 | 0x8;
    }
    return i1;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_JavaLangRunnable = new czo(this);
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, new czt(this));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new czs(this, null));
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(2, null);
    }
  }
  
  private void a(Bitmap paramBitmap, Matrix paramMatrix)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    paramMatrix.reset();
    float f3 = this.jdField_e_of_type_Int / paramBitmap.getWidth();
    float f4 = this.jdField_f_of_type_Int / paramBitmap.getHeight();
    if ((f3 >= 1.0F) || (f4 >= 1.0F)) {
      this.jdField_d_of_type_Float = Math.max(f3, f4);
    }
    for (;;)
    {
      paramMatrix.setScale(this.jdField_d_of_type_Float, this.jdField_d_of_type_Float);
      paramMatrix.postTranslate((f1 - paramBitmap.getWidth() * this.jdField_d_of_type_Float) / 2.0F, (f2 - paramBitmap.getHeight() * this.jdField_d_of_type_Float) / 2.0F);
      this.jdField_b_of_type_AndroidGraphicsRectF.left = 0.0F;
      this.jdField_b_of_type_AndroidGraphicsRectF.right = (this.jdField_b_of_type_AndroidGraphicsRectF.left + paramBitmap.getWidth());
      this.jdField_b_of_type_AndroidGraphicsRectF.top = 0.0F;
      this.jdField_b_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_AndroidGraphicsRectF.top + paramBitmap.getHeight());
      paramMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF);
      return;
      float f5 = f1 / paramBitmap.getWidth();
      float f6 = f2 / paramBitmap.getHeight();
      this.jdField_d_of_type_Float = Math.min(f5, f5);
      if (this.jdField_d_of_type_Float >= 1.0F) {
        this.jdField_d_of_type_Float = 1.0F;
      } else if ((this.jdField_d_of_type_Float < f3) || (this.jdField_d_of_type_Float < f4)) {
        this.jdField_d_of_type_Float = Math.max(f5, f6);
      }
    }
  }
  
  public float a()
  {
    return a(this.jdField_b_of_type_AndroidGraphicsMatrix);
  }
  
  public float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat1 / paramFloat4 - 1.0F;
    return (paramFloat1 * (paramFloat1 * paramFloat1) + 1.0F) * paramFloat3 + paramFloat2;
  }
  
  protected float a(Matrix paramMatrix)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return a(paramMatrix, 0);
    }
    return 1.0F;
  }
  
  protected float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    return this.jdField_a_of_type_ArrayOfFloat[paramInt];
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public Matrix a()
  {
    this.jdField_c_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_c_of_type_AndroidGraphicsMatrix.postConcat(this.jdField_b_of_type_AndroidGraphicsMatrix);
    return this.jdField_c_of_type_AndroidGraphicsMatrix;
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(float paramFloat)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    a(paramFloat, f1 / 2.0F, f2 / 2.0F);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_e_of_type_AndroidGraphicsMatrix.set(this.jdField_b_of_type_AndroidGraphicsMatrix);
    this.jdField_e_of_type_AndroidGraphicsMatrix.postTranslate(paramFloat1, paramFloat2);
    this.jdField_e_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
    int i1 = a(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsRectF);
    if (((i1 & 0x1) == 0) && ((i1 & 0x2) == 0)) {
      this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(paramFloat1, 0.0F);
    }
    if (((i1 & 0x4) == 0) && ((i1 & 0x8) == 0)) {
      this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(0.0F, paramFloat2);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = paramFloat1;
    if (paramFloat1 > this.jdField_e_of_type_Float) {
      f1 = this.jdField_e_of_type_Float;
    }
    b(f1 / a(), paramFloat2, paramFloat3);
    setImageMatrix(a());
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = (paramFloat1 - a()) / paramFloat4;
    float f1 = a();
    post(new czq(this, paramFloat4, System.currentTimeMillis(), f1, paramFloat1, paramFloat2, paramFloat3));
  }
  
  public float b()
  {
    return a(a());
  }
  
  public int b()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public Matrix b()
  {
    this.jdField_c_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_c_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_c_of_type_AndroidGraphicsMatrix.postConcat(this.jdField_b_of_type_AndroidGraphicsMatrix);
    return this.jdField_c_of_type_AndroidGraphicsMatrix;
  }
  
  protected void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_e_of_type_AndroidGraphicsMatrix.set(this.jdField_b_of_type_AndroidGraphicsMatrix);
    this.jdField_e_of_type_AndroidGraphicsMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    this.jdField_e_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
    if (a(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsRectF) == 0) {
      this.jdField_b_of_type_AndroidGraphicsMatrix.set(this.jdField_e_of_type_AndroidGraphicsMatrix);
    }
    while ((this.jdField_c_of_type_AndroidGraphicsRectF.width() / this.jdField_a_of_type_AndroidGraphicsRectF.width() < 1.0F) || (this.jdField_c_of_type_AndroidGraphicsRectF.height() / this.jdField_a_of_type_AndroidGraphicsRectF.height() < 1.0F)) {
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
    paramFloat2 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_c_of_type_AndroidGraphicsRectF.width();
    paramFloat3 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_c_of_type_AndroidGraphicsRectF.height();
    if (paramFloat2 >= paramFloat3) {}
    for (;;)
    {
      paramFloat3 = (this.jdField_a_of_type_AndroidGraphicsRectF.centerX() - this.jdField_c_of_type_AndroidGraphicsRectF.centerX() * paramFloat2) / (1.0F - paramFloat2);
      paramFloat2 = (this.jdField_a_of_type_AndroidGraphicsRectF.centerY() - this.jdField_c_of_type_AndroidGraphicsRectF.centerY() * paramFloat2) / (1.0F - paramFloat2);
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(paramFloat1, paramFloat1, paramFloat3, paramFloat2);
      return;
      paramFloat2 = paramFloat3;
    }
  }
  
  public float c()
  {
    return a(a(), 2);
  }
  
  protected void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_JavaLangRunnable = new czr(this, paramFloat3, System.currentTimeMillis(), paramFloat1, paramFloat2);
    post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public float d()
  {
    return a(a(), 5);
  }
  
  public float e()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return 1.0F;
    }
    return Math.max(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / this.jdField_i_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / this.j) * 16.0F;
  }
  
  public float f()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return 1.0F;
    }
    return Math.max(Math.min(this.jdField_i_of_type_Int / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.j / this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()), 1.0F);
  }
  
  public float g()
  {
    return this.jdField_f_of_type_Float;
  }
  
  public float h()
  {
    return this.jdField_g_of_type_Float;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = paramCanvas.save();
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      if ((Build.VERSION.SDK_INT < 11) || (getLayerType() != 2)) {
        break label57;
      }
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_d_of_type_AndroidGraphicsMatrix, null);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i1);
      return;
      label57:
      if (System.currentTimeMillis() - this.jdField_a_of_type_Double > 250.0D)
      {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_d_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_Double = System.currentTimeMillis();
      }
      else
      {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_d_of_type_AndroidGraphicsMatrix, null);
        removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        postDelayed(this.jdField_c_of_type_JavaLangRunnable, 250L);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_i_of_type_Int = (paramInt3 - paramInt1);
    this.j = (paramInt4 - paramInt2);
    Runnable localRunnable = this.jdField_b_of_type_JavaLangRunnable;
    if (localRunnable != null)
    {
      this.jdField_b_of_type_JavaLangRunnable = null;
      localRunnable.run();
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix);
      setImageMatrix(a());
    }
    this.jdField_c_of_type_Int = (getWidth() / 2);
    this.jdField_d_of_type_Int = (getHeight() / 2);
    setRestrict(this.jdField_g_of_type_Int, this.jdField_h_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.jdField_c_of_type_Int - this.jdField_e_of_type_Int / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_c_of_type_Int + this.jdField_e_of_type_Int / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.jdField_d_of_type_Int - this.jdField_f_of_type_Int / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_d_of_type_Int + this.jdField_f_of_type_Int / 2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
      if (!this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress()) {
        this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      }
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
    }
    label231:
    int i2;
    do
    {
      do
      {
        return true;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.jdField_h_of_type_Float = f1;
        this.jdField_i_of_type_Float = f2;
        this.r = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        return true;
        i1 = paramMotionEvent.findPointerIndex(this.r);
      } while ((i1 == -1) || (i1 >= paramMotionEvent.getPointerCount()));
      float f1 = paramMotionEvent.getX(i1);
      float f2 = paramMotionEvent.getY(i1);
      float f3;
      float f4;
      if (!this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress())
      {
        f3 = f1 - this.jdField_h_of_type_Float;
        f4 = f2 - this.jdField_i_of_type_Float;
        if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
          break label231;
        }
        this.jdField_f_of_type_Float = (f3 + this.jdField_f_of_type_Float);
      }
      for (this.jdField_g_of_type_Float += f4;; this.jdField_g_of_type_Float += f4)
      {
        invalidate();
        this.jdField_h_of_type_Float = f1;
        this.jdField_i_of_type_Float = f2;
        return true;
        this.jdField_f_of_type_Float = (f3 + this.jdField_f_of_type_Float);
      }
      this.r = -1;
      return true;
      this.r = -1;
      return true;
      i2 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    } while (paramMotionEvent.getPointerId(i2) != this.r);
    if (i2 == 0) {
      i1 = 1;
    }
    this.jdField_h_of_type_Float = paramMotionEvent.getX(i1);
    this.jdField_i_of_type_Float = paramMotionEvent.getY(i1);
    this.r = paramMotionEvent.getPointerId(i1);
    return true;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    if (getWidth() <= 0)
    {
      this.jdField_b_of_type_JavaLangRunnable = new czp(this, paramBitmap);
      return;
    }
    if (paramBitmap != null) {
      a(paramBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix);
    }
    for (this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;; this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap)
    {
      this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
      setImageMatrix(a());
      this.jdField_e_of_type_Float = e();
      return;
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
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
    if (((localMatrix == null) && (!this.jdField_d_of_type_AndroidGraphicsMatrix.isIdentity())) || ((localMatrix != null) && (!this.jdField_d_of_type_AndroidGraphicsMatrix.equals(localMatrix))))
    {
      this.jdField_d_of_type_AndroidGraphicsMatrix.set(localMatrix);
      invalidate();
    }
  }
  
  public void setOnImageTouchedListener(PortraitImageview.OnImageTouchedListener paramOnImageTouchedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview$OnImageTouchedListener = paramOnImageTouchedListener;
  }
  
  public void setRegionView(RegionView paramRegionView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView = paramRegionView;
  }
  
  public void setRestrict(int paramInt1, int paramInt2)
  {
    this.jdField_g_of_type_Int = paramInt1;
    this.jdField_h_of_type_Int = paramInt2;
    if ((this.jdField_i_of_type_Int > 0) && ((this.jdField_g_of_type_Int > this.jdField_i_of_type_Int) || (this.jdField_h_of_type_Int > this.j)))
    {
      float f1 = (this.jdField_i_of_type_Int - k * this.jdField_c_of_type_Float) / this.jdField_g_of_type_Int;
      float f2 = (this.j - k * this.jdField_c_of_type_Float) / this.jdField_h_of_type_Int;
      if (f1 <= f2)
      {
        this.jdField_e_of_type_Int = ((int)(this.jdField_g_of_type_Int * f1));
        this.jdField_f_of_type_Int = ((int)(f1 * this.jdField_h_of_type_Int));
        return;
      }
      this.jdField_e_of_type_Int = ((int)(this.jdField_g_of_type_Int * f2));
      this.jdField_f_of_type_Int = ((int)(this.jdField_h_of_type_Int * f2));
      return;
    }
    this.jdField_e_of_type_Int = this.jdField_g_of_type_Int;
    this.jdField_f_of_type_Int = this.jdField_h_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PortraitImageview
 * JD-Core Version:    0.7.0.1
 */