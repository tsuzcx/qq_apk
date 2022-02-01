package com.tencent.biz.pubaccount.readinjoy.view.ucrop;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import nqw;
import nra;

public class OverlayView
  extends View
{
  private final RectF L = new RectF();
  private final RectF M = new RectF();
  private nqw a;
  private Paint aL = new Paint(1);
  private Paint aM = new Paint(1);
  private Paint aN = new Paint(1);
  private Paint aO = new Paint(1);
  private int aql;
  protected float[] at;
  protected float[] au;
  private boolean aue;
  private boolean auf;
  private boolean aug;
  private boolean auh;
  private float[] av;
  private int bbj;
  private int bbk;
  private int bbl = 0;
  private int bbm = -1;
  private int bbn = getResources().getDimensionPixelSize(2131299716);
  private int bbo = getResources().getDimensionPixelSize(2131299717);
  private int bbp = getResources().getDimensionPixelSize(2131299715);
  private float kF;
  private float kQ = -1.0F;
  private float kR = -1.0F;
  protected int mThisHeight;
  protected int mThisWidth;
  private Path t = new Path();
  
  public OverlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OverlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OverlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void B(float paramFloat1, float paramFloat2)
  {
    int j = 1;
    this.M.set(this.L);
    int i;
    label71:
    label87:
    RectF localRectF;
    label106:
    label119:
    float f1;
    switch (this.bbm)
    {
    default: 
      if (this.M.height() >= this.bbo)
      {
        i = 1;
        if (this.M.width() < this.bbo) {
          break label388;
        }
        localRectF = this.L;
        if (j == 0) {
          break label394;
        }
        paramFloat1 = this.M.left;
        if (i == 0) {
          break label405;
        }
        paramFloat2 = this.M.top;
        if (j == 0) {
          break label416;
        }
        f1 = this.M.right;
        label132:
        if (i == 0) {
          break label427;
        }
      }
      break;
    }
    label388:
    label394:
    label405:
    label416:
    label427:
    for (float f2 = this.M.bottom;; f2 = this.L.bottom)
    {
      localRectF.set(paramFloat1, paramFloat2, f1, f2);
      if ((i != 0) || (j != 0))
      {
        bak();
        postInvalidate();
      }
      do
      {
        return;
        this.M.set(paramFloat1, paramFloat2, this.L.right, this.L.bottom);
        break;
        this.M.set(this.L.left, paramFloat2, paramFloat1, this.L.bottom);
        break;
        this.M.set(this.L.left, this.L.top, paramFloat1, paramFloat2);
        break;
        this.M.set(paramFloat1, this.L.top, this.L.right, paramFloat2);
        break;
        this.M.offset(paramFloat1 - this.kQ, paramFloat2 - this.kR);
      } while ((this.M.left <= getLeft()) || (this.M.top <= getTop()) || (this.M.right >= getRight()) || (this.M.bottom >= getBottom()));
      this.L.set(this.M);
      bak();
      postInvalidate();
      return;
      i = 0;
      break label71;
      j = 0;
      break label87;
      paramFloat1 = this.L.left;
      break label106;
      paramFloat2 = this.L.top;
      break label119;
      f1 = this.L.right;
      break label132;
    }
  }
  
  private void bak()
  {
    this.at = nra.a(this.L);
    this.au = nra.b(this.L);
    this.av = null;
    this.t.reset();
    this.t.addCircle(this.L.centerX(), this.L.centerY(), Math.min(this.L.width(), this.L.height()) / 2.0F, Path.Direction.CW);
  }
  
  private int c(float paramFloat1, float paramFloat2)
  {
    int i = -1;
    double d1 = this.bbn;
    int j = 0;
    if (j < 8)
    {
      double d2 = Math.sqrt(Math.pow(paramFloat1 - this.at[j], 2.0D) + Math.pow(paramFloat2 - this.at[(j + 1)], 2.0D));
      if (d2 >= d1) {
        break label127;
      }
      i = j / 2;
      d1 = d2;
    }
    label127:
    for (;;)
    {
      j += 2;
      break;
      j = i;
      if (this.bbl == 1)
      {
        j = i;
        if (i < 0)
        {
          j = i;
          if (this.L.contains(paramFloat1, paramFloat2)) {
            j = 4;
          }
        }
      }
      return j;
    }
  }
  
  private void c(@NonNull TypedArray paramTypedArray)
  {
    int i = paramTypedArray.getDimensionPixelSize(5, getResources().getDimensionPixelSize(2131299712));
    int j = paramTypedArray.getColor(4, getResources().getColor(2131167615));
    this.aN.setStrokeWidth(i);
    this.aN.setColor(j);
    this.aN.setStyle(Paint.Style.STROKE);
    this.aO.setStrokeWidth(i * 3);
    this.aO.setColor(j);
    this.aO.setStyle(Paint.Style.STROKE);
  }
  
  private void d(@NonNull TypedArray paramTypedArray)
  {
    int i = paramTypedArray.getDimensionPixelSize(9, getResources().getDimensionPixelSize(2131299713));
    int j = paramTypedArray.getColor(6, getResources().getColor(2131167616));
    this.aM.setStrokeWidth(i);
    this.aM.setColor(j);
    this.bbj = paramTypedArray.getInt(8, 2);
    this.bbk = paramTypedArray.getInt(7, 2);
  }
  
  protected void ah(@NonNull Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.aug) {
      paramCanvas.clipPath(this.t, Region.Op.DIFFERENCE);
    }
    for (;;)
    {
      paramCanvas.drawColor(this.aql);
      paramCanvas.restore();
      if (this.aug) {
        paramCanvas.drawCircle(this.L.centerX(), this.L.centerY(), Math.min(this.L.width(), this.L.height()) / 2.0F, this.aL);
      }
      return;
      paramCanvas.clipRect(this.L, Region.Op.DIFFERENCE);
    }
  }
  
  protected void ai(@NonNull Canvas paramCanvas)
  {
    int n = 0;
    if (this.auf)
    {
      if ((this.av == null) && (!this.L.isEmpty()))
      {
        this.av = new float[this.bbj * 4 + this.bbk * 4];
        int j = 0;
        int i = 0;
        int k;
        int m;
        float[] arrayOfFloat;
        for (;;)
        {
          k = n;
          m = i;
          if (j >= this.bbj) {
            break;
          }
          arrayOfFloat = this.av;
          k = i + 1;
          arrayOfFloat[i] = this.L.left;
          arrayOfFloat = this.av;
          i = k + 1;
          arrayOfFloat[k] = (this.L.height() * ((j + 1.0F) / (this.bbj + 1)) + this.L.top);
          arrayOfFloat = this.av;
          k = i + 1;
          arrayOfFloat[i] = this.L.right;
          arrayOfFloat = this.av;
          i = k + 1;
          arrayOfFloat[k] = (this.L.height() * ((j + 1.0F) / (this.bbj + 1)) + this.L.top);
          j += 1;
        }
        while (k < this.bbk)
        {
          arrayOfFloat = this.av;
          i = m + 1;
          arrayOfFloat[m] = (this.L.width() * ((k + 1.0F) / (this.bbk + 1)) + this.L.left);
          arrayOfFloat = this.av;
          j = i + 1;
          arrayOfFloat[i] = this.L.top;
          arrayOfFloat = this.av;
          i = j + 1;
          arrayOfFloat[j] = (this.L.width() * ((k + 1.0F) / (this.bbk + 1)) + this.L.left);
          arrayOfFloat = this.av;
          m = i + 1;
          arrayOfFloat[i] = this.L.bottom;
          k += 1;
        }
      }
      if (this.av != null) {
        paramCanvas.drawLines(this.av, this.aM);
      }
    }
    if (this.aue) {
      paramCanvas.drawRect(this.L, this.aN);
    }
    if (this.bbl != 0)
    {
      paramCanvas.save();
      this.M.set(this.L);
      this.M.inset(this.bbp, -this.bbp);
      paramCanvas.clipRect(this.M, Region.Op.DIFFERENCE);
      this.M.set(this.L);
      this.M.inset(-this.bbp, this.bbp);
      paramCanvas.clipRect(this.M, Region.Op.DIFFERENCE);
      paramCanvas.drawRect(this.L, this.aO);
      paramCanvas.restore();
    }
  }
  
  protected void b(@NonNull TypedArray paramTypedArray)
  {
    this.aug = paramTypedArray.getBoolean(2, false);
    this.aql = paramTypedArray.getColor(3, getResources().getColor(2131167617));
    this.aL.setColor(this.aql);
    this.aL.setStyle(Paint.Style.STROKE);
    this.aL.setStrokeWidth(1.0F);
    c(paramTypedArray);
    this.aue = paramTypedArray.getBoolean(10, true);
    d(paramTypedArray);
    this.auf = paramTypedArray.getBoolean(11, true);
  }
  
  @NonNull
  public RectF c()
  {
    return this.L;
  }
  
  protected void init()
  {
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    ah(paramCanvas);
    ai(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      paramInt1 = getPaddingLeft();
      paramInt2 = getPaddingTop();
      paramInt3 = getWidth();
      paramInt4 = getPaddingRight();
      int i = getHeight();
      int j = getPaddingBottom();
      this.mThisWidth = (paramInt3 - paramInt4 - paramInt1);
      this.mThisHeight = (i - j - paramInt2);
      if (this.auh)
      {
        this.auh = false;
        setTargetAspectRatio(this.kF);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((this.L.isEmpty()) || (this.bbl == 0)) {
      bool2 = false;
    }
    float f2;
    float f1;
    do
    {
      return bool2;
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      if ((paramMotionEvent.getAction() & 0xFF) != 0) {
        break;
      }
      this.bbm = c(f2, f1);
      if (this.bbm != -1) {}
      while (!bool1)
      {
        this.kQ = -1.0F;
        this.kR = -1.0F;
        return bool1;
        bool1 = false;
      }
      bool2 = bool1;
    } while (this.kQ >= 0.0F);
    this.kQ = f2;
    this.kR = f1;
    return bool1;
    if (((paramMotionEvent.getAction() & 0xFF) == 2) && (paramMotionEvent.getPointerCount() == 1) && (this.bbm != -1))
    {
      f2 = Math.min(Math.max(f2, getPaddingLeft()), getWidth() - getPaddingRight());
      f1 = Math.min(Math.max(f1, getPaddingTop()), getHeight() - getPaddingBottom());
      B(f2, f1);
      this.kQ = f2;
      this.kR = f1;
      return true;
    }
    if ((paramMotionEvent.getAction() & 0xFF) == 1)
    {
      this.kQ = -1.0F;
      this.kR = -1.0F;
      this.bbm = -1;
      if (this.a != null) {
        this.a.b(this.L);
      }
    }
    return false;
  }
  
  public void setCircleDimmedLayer(boolean paramBoolean)
  {
    this.aug = paramBoolean;
  }
  
  public void setCropFrameColor(@ColorInt int paramInt)
  {
    this.aN.setColor(paramInt);
  }
  
  public void setCropFrameStrokeWidth(@IntRange(from=0L) int paramInt)
  {
    this.aN.setStrokeWidth(paramInt);
  }
  
  public void setCropGridColor(@ColorInt int paramInt)
  {
    this.aM.setColor(paramInt);
  }
  
  public void setCropGridColumnCount(@IntRange(from=0L) int paramInt)
  {
    this.bbk = paramInt;
    this.av = null;
  }
  
  public void setCropGridRowCount(@IntRange(from=0L) int paramInt)
  {
    this.bbj = paramInt;
    this.av = null;
  }
  
  public void setCropGridStrokeWidth(@IntRange(from=0L) int paramInt)
  {
    this.aM.setStrokeWidth(paramInt);
  }
  
  public void setDimmedColor(@ColorInt int paramInt)
  {
    this.aql = paramInt;
  }
  
  @Deprecated
  public void setFreestyleCropEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.bbl = i;
      return;
    }
  }
  
  public void setFreestyleCropMode(int paramInt)
  {
    this.bbl = paramInt;
    postInvalidate();
  }
  
  public void setOverlayViewChangeListener(nqw paramnqw)
  {
    this.a = paramnqw;
  }
  
  public void setShowCropFrame(boolean paramBoolean)
  {
    this.aue = paramBoolean;
  }
  
  public void setShowCropGrid(boolean paramBoolean)
  {
    this.auf = paramBoolean;
  }
  
  public void setTargetAspectRatio(float paramFloat)
  {
    this.kF = paramFloat;
    if (this.mThisWidth > 0)
    {
      setupCropBounds();
      postInvalidate();
      return;
    }
    this.auh = true;
  }
  
  public void setupCropBounds()
  {
    int i = (int)(this.mThisWidth / this.kF);
    int j;
    if (i > this.mThisHeight)
    {
      i = (int)(this.mThisHeight * this.kF);
      j = (this.mThisWidth - i) / 2;
      this.L.set(getPaddingLeft() + j, getPaddingTop(), i + getPaddingLeft() + j, getPaddingTop() + this.mThisHeight);
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.b(this.L);
      }
      bak();
      return;
      j = (this.mThisHeight - i) / 2;
      this.L.set(getPaddingLeft(), getPaddingTop() + j, getPaddingLeft() + this.mThisWidth, i + getPaddingTop() + j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.OverlayView
 * JD-Core Version:    0.7.0.1
 */