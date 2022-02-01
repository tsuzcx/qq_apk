package com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import ram;
import wja;

@SuppressLint({"AppCompatCustomView"})
public class RoundBorderImageView
  extends ImageView
{
  public static final String[] bS = { "HUAWEI ALE-CL00" };
  public static final int bkO = 0;
  public boolean DEBUG;
  public float[] E;
  private boolean WE = true;
  private DashPathEffect a;
  private boolean aCh = true;
  public boolean aCi = true;
  public boolean aCj = true;
  private boolean aCk;
  public Rect aD;
  public float[] aD;
  public Paint aR;
  public Paint aS;
  private DashPathEffect jdField_b_of_type_AndroidGraphicsDashPathEffect;
  private ShapeDrawable jdField_b_of_type_AndroidGraphicsDrawableShapeDrawable;
  private double bk;
  public int bkH = wja.dp2px(8.0F, getResources());
  private int bkI = wja.dp2px(8.0F, getResources());
  private int bkJ = 5;
  private int bkK = -16776961;
  private int bkL = -7829368;
  private int bkM = wja.dp2px(3.0F, getResources());
  public int bkN = 25;
  public int bkP = 2;
  public Drawable da;
  private float lX;
  private float lY;
  private float lZ;
  private int mSegmentCount = 9;
  private int mStrokeWidth = wja.dp2px(1.5F, getResources());
  private Path v;
  
  static
  {
    if (Arrays.asList(bS).contains(Build.MODEL))
    {
      bkO = 1;
      return;
    }
  }
  
  public RoundBorderImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundBorderImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void bmZ()
  {
    int j = 0;
    if (this.da == null) {
      return;
    }
    int i;
    switch (this.bkP)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      this.da.setBounds(i, j, this.da.getIntrinsicWidth() + i, this.da.getIntrinsicHeight() + j);
      return;
      i = getWidth() - getPaddingRight() - this.da.getIntrinsicWidth();
      continue;
      i = getWidth() - getPaddingRight() - this.da.getIntrinsicWidth();
      j = getHeight() - this.da.getIntrinsicHeight();
      continue;
      i = getWidth() - getPaddingRight() - this.da.getIntrinsicWidth();
      j = getHeight() - -getPaddingBottom() - this.da.getIntrinsicHeight();
    }
  }
  
  private void bna()
  {
    this.bkI = (this.bkH + getPaddingTop() - this.mStrokeWidth / 2);
    Arrays.fill(this.E, this.bkH);
    Arrays.fill(this.jdField_aD_of_type_ArrayOfFloat, this.bkI);
    this.jdField_b_of_type_AndroidGraphicsDrawableShapeDrawable = new ShapeDrawable(new RoundRectShape(this.jdField_aD_of_type_ArrayOfFloat, null, this.jdField_aD_of_type_ArrayOfFloat));
    this.jdField_b_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setColor(-65536);
    this.jdField_b_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStrokeWidth(this.mStrokeWidth);
    this.jdField_b_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStrokeCap(Paint.Cap.ROUND);
    this.jdField_b_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setAntiAlias(true);
  }
  
  private void bnc()
  {
    int i = getWidth();
    int j = getHeight();
    this.lX = (i - (this.bkI + this.mStrokeWidth / 2.0F) * 2.0F);
    this.lY = (j - (this.bkI + this.mStrokeWidth / 2.0F) * 2.0F);
    this.bk = (this.bkI * 3.141592653589793D / 2.0D);
    RectF localRectF = new RectF(this.mStrokeWidth / 2.0F, this.mStrokeWidth / 2.0F, i - this.mStrokeWidth / 2.0F, j - this.mStrokeWidth / 2.0F);
    Path localPath = new Path();
    localPath.addRoundRect(localRectF, this.jdField_aD_of_type_ArrayOfFloat, Path.Direction.CW);
    this.lZ = new PathMeasure(localPath, true).getLength();
    ram.d("RoundBorderImageView", "width=%d, height=%d, hLength=%f, vLength=%f, roundLength=%f, mStrokeWidth=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(this.lX), Float.valueOf(this.lY), Double.valueOf(this.bk), Integer.valueOf(this.mStrokeWidth) });
    localRectF = new RectF(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom());
    this.v = new Path();
    this.v.addRoundRect(localRectF, this.E, Path.Direction.CW);
    this.jdField_aD_of_type_AndroidGraphicsRect = new Rect(this.mStrokeWidth / 2, this.mStrokeWidth / 2, i - this.mStrokeWidth / 2, j - this.mStrokeWidth / 2);
    if (this.lZ > 0.0F)
    {
      this.bkN = ((int)Math.floor(this.lZ * 1.0F / (this.bkM * 2)));
      ram.a("RoundBorderImageView", "mBoarderLength = %f, gapLength = %d, max segment count = %d", Float.valueOf(this.lZ), Integer.valueOf(this.bkM), Integer.valueOf(this.bkN));
      return;
    }
    this.bkN = 1;
    ram.a("RoundBorderImageView", "mBoarderLength = %f, gapLength = %d, max segment count fallback to %d", Float.valueOf(this.lZ), Integer.valueOf(this.bkM), Integer.valueOf(this.bkN));
  }
  
  private void init()
  {
    this.aR = new Paint();
    this.aR.setColor(Color.rgb(200, 200, 200));
    this.aR.setStrokeWidth(1.0F);
    this.aS = new Paint();
    this.aS.setColor(Color.rgb(128, 128, 128));
    this.aS.setStrokeWidth(1.0F);
    this.E = new float[8];
    this.jdField_aD_of_type_ArrayOfFloat = new float[8];
    this.bkH = (this.bkI - getPaddingTop() + this.mStrokeWidth / 2);
    Arrays.fill(this.E, this.bkH);
    Arrays.fill(this.jdField_aD_of_type_ArrayOfFloat, this.bkI);
    this.jdField_b_of_type_AndroidGraphicsDrawableShapeDrawable = new ShapeDrawable(new RoundRectShape(this.jdField_aD_of_type_ArrayOfFloat, null, this.jdField_aD_of_type_ArrayOfFloat));
    this.jdField_b_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setColor(-65536);
    this.jdField_b_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStrokeWidth(this.mStrokeWidth);
    this.jdField_b_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStrokeCap(Paint.Cap.ROUND);
    this.jdField_b_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setAntiAlias(true);
  }
  
  public void Y(float paramFloat)
  {
    int i = wja.dp2px(paramFloat, getResources());
    if (i != this.mStrokeWidth)
    {
      this.mStrokeWidth = i;
      bna();
      bnc();
      bnd();
      invalidate();
    }
  }
  
  float ay()
  {
    if (bkO == 0) {
      return (float)-(this.lY + this.bk + this.lX / 2.0F + this.bkM / 2);
    }
    return this.lX / 2.0F - this.bkM;
  }
  
  public void bmY()
  {
    this.da = null;
    invalidate();
  }
  
  protected void bnb()
  {
    bmZ();
    bnc();
    bnd();
    invalidate();
  }
  
  public void bnd()
  {
    int k = 0;
    int j = 0;
    int i = Math.min(this.bkN, this.mSegmentCount);
    Math.min(this.bkN, this.bkJ);
    if (this.mSegmentCount > this.bkN)
    {
      float f2 = (float)Math.floor(this.lZ * 0.5D / this.mSegmentCount);
      f1 = f2;
      if (f2 < this.mStrokeWidth + wja.dp2px(1.0F, getResources())) {
        f1 = this.mStrokeWidth + wja.dp2px(1.0F, getResources());
      }
      f2 = ay();
      d = this.lZ / this.mSegmentCount - f1;
      if ((d <= 0.0D) || (Double.isNaN(d)) || (i <= 1))
      {
        this.a = null;
        this.jdField_b_of_type_AndroidGraphicsDashPathEffect = null;
        return;
      }
      arrayOfFloat = new float[this.mSegmentCount * 2];
      i = 0;
      while (i < this.mSegmentCount * 2)
      {
        arrayOfFloat[i] = ((float)d);
        arrayOfFloat[(i + 1)] = f1;
        i += 2;
      }
      this.a = new DashPathEffect(arrayOfFloat, f2);
      arrayOfFloat = new float[this.mSegmentCount * 2];
      i = j;
      if (i < this.mSegmentCount * 2)
      {
        if (i < this.bkJ * 2)
        {
          arrayOfFloat[i] = ((float)d);
          arrayOfFloat[(i + 1)] = f1;
        }
        for (;;)
        {
          i += 2;
          break;
          arrayOfFloat[i] = 0.0F;
          arrayOfFloat[(i + 1)] = ((float)d + f1);
        }
      }
      this.jdField_b_of_type_AndroidGraphicsDashPathEffect = new DashPathEffect(arrayOfFloat, f2);
      return;
    }
    float f1 = ay();
    double d = this.lZ / this.mSegmentCount - this.bkM;
    if ((d <= 0.0D) || (Double.isNaN(d)) || (this.mSegmentCount <= 1))
    {
      this.a = null;
      this.jdField_b_of_type_AndroidGraphicsDashPathEffect = null;
      return;
    }
    float[] arrayOfFloat = new float[this.mSegmentCount * 2];
    i = 0;
    while (i < this.mSegmentCount * 2)
    {
      arrayOfFloat[i] = ((float)d);
      arrayOfFloat[(i + 1)] = this.bkM;
      i += 2;
    }
    this.a = new DashPathEffect(arrayOfFloat, f1);
    arrayOfFloat = new float[this.mSegmentCount * 2];
    i = k;
    if (i < this.mSegmentCount * 2)
    {
      if (i < this.bkJ * 2)
      {
        arrayOfFloat[i] = ((float)d);
        arrayOfFloat[(i + 1)] = this.bkM;
      }
      for (;;)
      {
        i += 2;
        break;
        arrayOfFloat[i] = 0.0F;
        arrayOfFloat[(i + 1)] = ((float)d + this.bkM);
      }
    }
    this.jdField_b_of_type_AndroidGraphicsDashPathEffect = new DashPathEffect(arrayOfFloat, f1);
    ram.a("RoundBorderImageView", "buildDashes length (%d), %s, %s, hash:%d", Integer.valueOf(arrayOfFloat.length), this.a, this.jdField_b_of_type_AndroidGraphicsDashPathEffect, Integer.valueOf(hashCode()));
  }
  
  public boolean g(Drawable paramDrawable)
  {
    if ((!Build.MODEL.equalsIgnoreCase("vivo X7Plus")) && (!Build.MODEL.equalsIgnoreCase("vivo X6S A"))) {
      return false;
    }
    try
    {
      if (paramDrawable == getDrawable())
      {
        if (paramDrawable != null)
        {
          int i = paramDrawable.getIntrinsicWidth();
          int j = paramDrawable.getIntrinsicHeight();
          paramDrawable = ImageView.class.getDeclaredField("mDrawableWidth");
          Field localField = ImageView.class.getDeclaredField("mDrawableHeight");
          paramDrawable.setAccessible(true);
          localField.setAccessible(true);
          int k = ((Integer)paramDrawable.get(this)).intValue();
          int m = ((Integer)localField.get(this)).intValue();
          if ((k != i) || (m != j))
          {
            paramDrawable.setInt(this, i);
            localField.setInt(this, j);
            paramDrawable = ImageView.class.getDeclaredMethod("configureBounds", new Class[0]);
            paramDrawable.setAccessible(true);
            paramDrawable.invoke(this, new Object[0]);
          }
        }
        invalidate();
        return true;
      }
    }
    catch (InvocationTargetException paramDrawable)
    {
      return false;
    }
    catch (NoSuchMethodException paramDrawable)
    {
      break label165;
    }
    catch (NoSuchFieldException paramDrawable)
    {
      break label165;
    }
    catch (IllegalAccessException paramDrawable)
    {
      label165:
      break label165;
    }
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    if (this.DEBUG) {
      ram.a("RoundBorderImageView", "[DEBUG] before invalidateDrawable %d %d type %s, matrix:%s", Integer.valueOf(getDrawable().getIntrinsicWidth()), Integer.valueOf(getDrawable().getIntrinsicHeight()), getScaleType(), getImageMatrix().toShortString());
    }
    if (g(paramDrawable)) {
      ram.d("RoundBorderImageView", "[PATCH] PATCH for vivo");
    }
    for (;;)
    {
      if (this.DEBUG) {
        ram.a("RoundBorderImageView", "[DEBUG] after invalidateDrawable %d %d type %s, matrix:%s", Integer.valueOf(getDrawable().getIntrinsicWidth()), Integer.valueOf(getDrawable().getIntrinsicHeight()), getScaleType(), getImageMatrix().toShortString());
      }
      paramDrawable = getDrawable();
      if (((paramDrawable instanceof URLDrawable)) && ((((URLDrawable)paramDrawable).getCurrDrawable() instanceof GifDrawable)) && ((Build.MODEL.equalsIgnoreCase("MI 8")) || (Build.MODEL.equalsIgnoreCase("VIVO NEX A")) || (Build.MODEL.equalsIgnoreCase("PACM00")) || (Build.MODEL.equalsIgnoreCase("PAFM00")))) {
        requestLayout();
      }
      return;
      super.invalidateDrawable(paramDrawable);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.clipPath(this.v);
    super.onDraw(paramCanvas);
    paramCanvas.restoreToCount(i);
    if (this.aCk) {
      paramCanvas.drawColor(Color.parseColor("#7fffffff"));
    }
    if (this.da != null) {
      this.da.draw(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    bnb();
  }
  
  public void requestLayout()
  {
    if (this.DEBUG) {
      ram.a("RoundBorderImageView", "[DEBUG] requestLayout %d %d type %s, matrix:%s", Integer.valueOf(getDrawable().getIntrinsicWidth()), Integer.valueOf(getDrawable().getIntrinsicHeight()), getScaleType(), getImageMatrix().toShortString());
    }
    super.requestLayout();
  }
  
  public void setBadgeIcon(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {}
    for (this.da = null;; this.da = getResources().getDrawable(paramInt1))
    {
      this.bkP = paramInt2;
      bmZ();
      invalidate();
      return;
    }
  }
  
  public void setBadgeIcon(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 3)
    {
      setBadgeIcon(paramInt, i);
      return;
    }
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    if ((this.DEBUG) && (paramDrawable != null)) {
      ram.a("RoundBorderImageView", "[DEBUG] before set %d %d type %s matrix:%s", Integer.valueOf(paramDrawable.getIntrinsicWidth()), Integer.valueOf(paramDrawable.getIntrinsicHeight()), getScaleType(), getImageMatrix().toShortString());
    }
    super.setImageDrawable(paramDrawable);
    if ((this.DEBUG) && (paramDrawable != null)) {
      ram.a("RoundBorderImageView", "[DEBUG] after set %d %d type %s, matrix:%s", Integer.valueOf(paramDrawable.getIntrinsicWidth()), Integer.valueOf(paramDrawable.getIntrinsicHeight()), getScaleType(), getImageMatrix().toShortString());
    }
  }
  
  public void setSegmentAttrs(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mSegmentCount = paramInt1;
    this.bkJ = paramInt2;
    this.bkK = paramInt3;
    this.bkL = paramInt4;
    bnd();
    invalidate();
  }
  
  public void setSegmentColor(int paramInt1, int paramInt2)
  {
    this.bkK = paramInt1;
    this.bkL = paramInt2;
    invalidate();
  }
  
  public void setSegmentCount(int paramInt1, int paramInt2)
  {
    this.mSegmentCount = paramInt1;
    this.bkJ = paramInt2;
    bna();
    bnd();
    invalidate();
  }
  
  public void su(boolean paramBoolean)
  {
    this.aCk = paramBoolean;
    invalidate();
  }
  
  public void sv(boolean paramBoolean)
  {
    this.WE = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView
 * JD-Core Version:    0.7.0.1
 */