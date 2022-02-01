package com.tencent.mobileqq.confess;

import aeha;
import aeha.a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.util.VersionUtils;

public class ConfessNewsBgView
  extends View
{
  aeha.a[] a = null;
  RectF aD = new RectF();
  private boolean bTN;
  private int cMP;
  int mBgColor = -6807359;
  int mBgType = 0;
  Paint mPaint = new Paint(1);
  private Path mPath;
  private float[] mRadiusArray = { 16.0F, 16.0F, 16.0F, 16.0F, 16.0F, 16.0F, 16.0F, 16.0F };
  
  public ConfessNewsBgView(Context paramContext)
  {
    super(paramContext);
    update();
  }
  
  public ConfessNewsBgView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    update();
  }
  
  public ConfessNewsBgView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    update();
  }
  
  private void update()
  {
    Object localObject1;
    if (this.cMP == 2)
    {
      this.a = aeha.a(this.cMP, this.mBgType);
      localObject1 = getResources();
      int k = ((Resources)localObject1).getDisplayMetrics().widthPixels;
      int j = ((Resources)localObject1).getDisplayMetrics().heightPixels;
      int i;
      Object localObject2;
      if ((k != 0) && (Math.abs(k - 1080) > 200))
      {
        localObject1 = this.a;
        int m = localObject1.length;
        i = 0;
        while (i < m)
        {
          localObject2 = localObject1[i];
          if (k - (int)(localObject2.cx * (k / 1080)) > 100) {
            localObject2.cx = ((int)(localObject2.cx * (k / 1080)));
          }
          i += 1;
        }
      }
      if ((j != 0) && (Math.abs(j * 0.8D - 1800) > 200.0D))
      {
        localObject1 = this.a;
        k = localObject1.length;
        i = 0;
        while (i < k)
        {
          localObject2 = localObject1[i];
          localObject2.cy = ((int)(localObject2.cy * (j * 0.8D / 1800)));
          i += 1;
        }
      }
    }
    else
    {
      localObject1 = aeha.eD[0];
      if ((this.mBgType < 0) || (this.mBgType >= aeha.eD.length)) {
        break label309;
      }
      localObject1 = aeha.eD[this.mBgType];
      this.a = aeha.a(0, this.mBgType);
    }
    try
    {
      for (;;)
      {
        this.mBgColor = Color.parseColor((String)localObject1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mBgColor);
        if (!VersionUtils.isJellyBeanMA2()) {
          setLayerType(1, null);
        }
        return;
        label309:
        this.a = aeha.a(0, 0);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.mBgColor = -6807359;
      }
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.bTN) {
      if (!isPressed()) {
        break label53;
      }
    }
    label53:
    for (this.mBgColor = Color.argb(100, Color.red(this.mBgColor), Color.green(this.mBgColor), Color.blue(this.mBgColor));; this.mBgColor = Color.argb(255, Color.red(this.mBgColor), Color.green(this.mBgColor), Color.blue(this.mBgColor)))
    {
      postInvalidate();
      return;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    this.aD.set(0.0F, 0.0F, i, j);
    if (this.mPath == null) {
      this.mPath = new Path();
    }
    int k = paramCanvas.save();
    try
    {
      Object localObject1 = this.mPath;
      ((Path)localObject1).reset();
      ((Path)localObject1).addRoundRect(this.aD, this.mRadiusArray, Path.Direction.CW);
      paramCanvas.clipPath((Path)localObject1);
      paramCanvas.drawRect(this.aD, this.mPaint);
      if ((this.a != null) && (this.a.length > 0))
      {
        localObject1 = this.a;
        int m = localObject1.length;
        i = 0;
        if (i < m)
        {
          Object localObject2 = localObject1[i];
          for (;;)
          {
            try
            {
              Drawable localDrawable = getResources().getDrawable(localObject2.resId);
              if (localObject2.resId == 2130845894) {
                break;
              }
              int i2 = localDrawable.getIntrinsicWidth();
              j = localDrawable.getIntrinsicHeight();
              int n = (int)(localObject2.cx * 1.8F - i2 * localObject2.scale * 1.0F / 2.0F);
              int i1 = (int)(localObject2.cy * 1.6F - j * localObject2.scale * 1.0F / 2.0F);
              float f = localObject2.cx;
              i2 = (int)(i2 * localObject2.scale * 1.0F / 2.0F + f * 1.8F);
              f = localObject2.cy;
              localDrawable.setBounds(n, i1, i2, (int)(j * localObject2.scale * 1.0F / 2.0F + f * 1.6F));
              if (localObject2.bTP)
              {
                if (this.cMP == 2)
                {
                  j = 128;
                  localDrawable.setAlpha(j);
                  localDrawable.setColorFilter(this.mBgColor, PorterDuff.Mode.MULTIPLY);
                }
              }
              else {
                localDrawable.draw(paramCanvas);
              }
            }
            catch (Exception localException) {}
            j = 77;
          }
        }
      }
      paramCanvas.restoreToCount(k);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        continue;
        i += 1;
      }
    }
  }
  
  public void setBgColor(int paramInt)
  {
    if (this.mBgColor != paramInt) {
      this.mBgColor = paramInt;
    }
  }
  
  public void setBgType(int paramInt)
  {
    if (this.mBgType != paramInt)
    {
      this.mBgType = paramInt;
      update();
      postInvalidate();
    }
  }
  
  public void setPressMask(boolean paramBoolean)
  {
    this.bTN = paramBoolean;
  }
  
  public void setSize(int paramInt)
  {
    if (this.cMP != paramInt)
    {
      this.cMP = paramInt;
      update();
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessNewsBgView
 * JD-Core Version:    0.7.0.1
 */