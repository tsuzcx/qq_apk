package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;

public class ProgressViewRed
  extends TimeDownTextView
{
  private RectF aK;
  private long afV = 10000L;
  private Rect cp;
  private Drawable dx;
  private int mAlpha;
  private int mFrameIndex;
  private long mProgress;
  private Drawable mProgressDrawable;
  private int[] mt = new int[0];
  private Bitmap[] r;
  
  public ProgressViewRed(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ProgressViewRed(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.mTextPaint.setColor(-1);
    this.mProgressDrawable = new ColorDrawable(Color.parseColor("#FF9F89"));
    this.dx = new ColorDrawable(Color.parseColor("#F34112"));
    try
    {
      this.r = new Bitmap[this.mt.length];
      int i = 0;
      while (i < this.mt.length)
      {
        this.r[i] = BitmapFactory.decodeResource(getResources(), this.mt[i]);
        i += 1;
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      this.cp = new Rect();
      this.aK = new RectF();
    }
  }
  
  public void a(long paramLong1, long paramLong2, CharSequence paramCharSequence)
  {
    this.afV = paramLong2;
    this.mProgress = (paramLong2 - paramLong1);
    setText(paramCharSequence);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mAlpha == 0) {
      return;
    }
    int k = getWidth();
    int m = getHeight();
    int n = (int)(k * this.mProgress / this.afV);
    if (this.mProgress > 0L)
    {
      this.mProgressDrawable.setBounds(0, 0, n, m);
      this.mProgressDrawable.draw(paramCanvas);
    }
    int i;
    int i1;
    Bitmap localBitmap;
    if (this.mProgress < this.afV)
    {
      this.dx.setBounds(n, 0, k, m);
      this.dx.draw(paramCanvas);
      int j = this.mFrameIndex;
      i = j;
      if (j >= this.mt.length) {
        i = j % this.mt.length;
      }
      j = this.r[i].getWidth();
      i1 = this.r[i].getHeight();
      this.cp.set(0, 0, j, i1);
      if (j > k - n) {
        break label224;
      }
      localBitmap = this.r[i];
      this.aK.set(n, 0.0F, j + n, m);
    }
    for (;;)
    {
      paramCanvas.drawBitmap(localBitmap, this.cp, this.aK, null);
      this.mFrameIndex += 1;
      super.draw(paramCanvas);
      return;
      label224:
      localBitmap = Bitmap.createBitmap(this.r[i], 0, 0, k - n, i1, null, false);
      this.aK.set(n, 0.0F, k, m);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.dx.setAlpha(paramInt);
    this.mProgressDrawable.setAlpha(paramInt);
    setTextColor(Color.argb(paramInt, 255, 255, 255));
    this.mAlpha = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ProgressViewRed
 * JD-Core Version:    0.7.0.1
 */