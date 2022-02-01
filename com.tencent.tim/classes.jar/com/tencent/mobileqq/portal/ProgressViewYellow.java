package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import aqhu;

public class ProgressViewYellow
  extends View
{
  private RectF aK;
  private long afV = 10000L;
  private ShapeDrawable c;
  private Rect cp;
  private int dqR;
  private int dqS;
  private int dqT;
  private int mFrameIndex;
  private Paint mPaint;
  private Path mPath;
  private long mProgress;
  private int[] mt = new int[0];
  private Bitmap[] r;
  
  public ProgressViewYellow(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ProgressViewYellow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ProgressViewYellow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    int i = 0;
    this.dqR = ((int)getResources().getDimension(2131298652));
    this.dqS = ((int)getResources().getDimension(2131298654));
    this.dqT = ((int)getResources().getDimension(2131298653));
    this.c = new ShapeDrawable(new RoundRectShape(new float[] { this.dqS, this.dqS, this.dqS, this.dqS, this.dqS, this.dqS, this.dqS, this.dqS }, null, null));
    this.c.getPaint().setAntiAlias(true);
    this.c.getPaint().setColor(Color.parseColor("#FC9100"));
    this.cp = new Rect();
    this.aK = new RectF();
    this.mFrameIndex = 0;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setFilterBitmap(true);
    if ((Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT < 18)) {}
    try
    {
      for (;;)
      {
        this.r = new Bitmap[this.mt.length];
        while (i < this.mt.length)
        {
          this.r[i] = BitmapFactory.decodeResource(getResources(), this.mt[i]);
          i += 1;
        }
        this.mPath = new Path();
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  public void ax(long paramLong1, long paramLong2)
  {
    this.afV = paramLong2;
    this.mProgress = (paramLong2 - paramLong1);
    postInvalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int k;
    int i;
    int m;
    int n;
    int i1;
    int i2;
    Bitmap localBitmap;
    if (this.mProgress < this.afV)
    {
      k = getWidth();
      int j = getHeight();
      i = this.dqT;
      k -= this.dqT;
      m = (j - this.dqR) / 2;
      n = (this.dqR + j) / 2;
      i1 = (int)((k - i) * this.mProgress / this.afV) + i;
      this.c.setBounds(i1, m, k, n);
      this.c.draw(paramCanvas);
      j = this.mFrameIndex;
      i = j;
      if (j >= this.mt.length) {
        i = j % this.mt.length;
      }
      j = this.r[i].getWidth();
      i2 = this.r[i].getHeight();
      this.cp.set(0, 0, j, i2);
      if (j > k - i1) {
        break label226;
      }
      localBitmap = this.r[i];
      this.aK.set(i1, m, j + i1, n);
      paramCanvas.drawBitmap(localBitmap, this.cp, this.aK, null);
    }
    for (;;)
    {
      this.mFrameIndex += 1;
      return;
      label226:
      localBitmap = Bitmap.createBitmap(this.r[i], 0, 0, k - i1, i2, null, false);
      this.aK.set(i1, m, k, n);
      if ((Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT < 18))
      {
        localBitmap = aqhu.c(localBitmap, this.dqS, k - i1, i2);
        this.aK.set(i1, m, k, n);
        paramCanvas.drawBitmap(localBitmap, this.cp, this.aK, null);
      }
      else
      {
        this.mPath.addRoundRect(this.aK, this.dqS, this.dqS, Path.Direction.CW);
        paramCanvas.clipPath(this.mPath, Region.Op.INTERSECT);
        paramCanvas.drawBitmap(localBitmap, this.cp, this.aK, this.mPaint);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ProgressViewYellow
 * JD-Core Version:    0.7.0.1
 */