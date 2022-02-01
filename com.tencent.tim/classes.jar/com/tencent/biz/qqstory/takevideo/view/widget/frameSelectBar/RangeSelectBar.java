package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import aqcx;
import ram;
import rpq;

public class RangeSelectBar
  extends View
{
  public static int btx = 4;
  private Paint Q;
  private a a;
  private boolean aIY;
  private boolean aIZ;
  private int btA;
  private int btB = Color.rgb(32, 170, 239);
  private int bty;
  private int btz;
  private Bitmap cO;
  private Bitmap cP;
  private int frameHeight;
  private int frameWidth;
  private int mEndIndex;
  private int mHeight;
  private float mLastX;
  private int mPadding;
  private Paint mPaint;
  private int mScreenWidth;
  private int mStartIndex;
  private int mWidth;
  private float nL;
  
  public RangeSelectBar(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public RangeSelectBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public RangeSelectBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mPadding = aqcx.dip2px(getContext(), ScrollFrameSelectBar.PADDING_LEFT_DP);
    this.mScreenWidth = rpq.getWindowScreenWidth(getContext());
    this.mPaint = new Paint(1);
    this.mPaint.setColor(this.btB);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.Q = new Paint();
    this.Q.setColor(-16777216);
    this.Q.setAlpha(80);
    this.Q.setStyle(Paint.Style.FILL);
  }
  
  public int getEndIndex()
  {
    return this.mEndIndex;
  }
  
  public int getStartIndex()
  {
    return this.mStartIndex;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mStartIndex > this.mPadding * 2) {
      paramCanvas.drawRect(this.mPadding, 0.0F, this.mStartIndex, this.frameHeight, this.Q);
    }
    if (this.mEndIndex < this.btA - this.mPadding) {
      paramCanvas.drawRect(this.mEndIndex, 0.0F, this.btA, this.frameHeight, this.Q);
    }
    paramCanvas.drawBitmap(this.cO, this.mStartIndex - this.mPadding, 0.0F, this.mPaint);
    paramCanvas.drawBitmap(this.cP, this.mEndIndex, 0.0F, this.mPaint);
    paramCanvas.drawRect(this.mStartIndex, 0.0F, this.mEndIndex, btx, this.mPaint);
    paramCanvas.drawRect(this.mStartIndex, this.frameHeight - btx, this.mEndIndex, this.frameHeight, this.mPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.mWidth = View.MeasureSpec.getSize(paramInt1);
    this.mHeight = View.MeasureSpec.getSize(paramInt2);
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.mLastX = f1;
      ram.a("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_DOWN x=%s,y=%s,mstart=%s,end=%s", Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.mStartIndex), Integer.valueOf(this.mEndIndex));
      if ((f1 > this.mStartIndex - this.mPadding / 2 - 40) && (f1 < this.mStartIndex - this.mPadding / 2 + 40))
      {
        this.aIY = true;
        return true;
      }
      if ((f1 > this.mEndIndex + this.mPadding / 2 - 40) && (f1 < this.mEndIndex + this.mPadding / 2 + 40))
      {
        this.aIZ = true;
        return true;
      }
      ram.d("Q.qqstory.frameWidget.RangeSelectBar", "没有触摸到");
      continue;
      paramMotionEvent.getX();
      f1 = this.mLastX;
      if (this.aIY) {
        if (this.mEndIndex - (int)paramMotionEvent.getX() < this.bty)
        {
          ram.d("Q.qqstory.frameWidget.RangeSelectBar", "mStartIndex不能再截取小于1s的视频");
          this.mStartIndex = (this.mEndIndex - this.bty);
          invalidate();
        }
      }
      for (;;)
      {
        if (this.a != null) {
          this.a.bvC();
        }
        return true;
        if (paramMotionEvent.getX() <= this.btz)
        {
          ram.d("Q.qqstory.frameWidget.RangeSelectBar", "向左边边滑动");
          this.mStartIndex = this.btz;
          invalidate();
        }
        else
        {
          this.mStartIndex = ((int)paramMotionEvent.getX());
          invalidate();
          continue;
          if (this.aIZ) {
            if ((int)paramMotionEvent.getX() - this.mStartIndex < this.bty)
            {
              ram.d("Q.qqstory.frameWidget.RangeSelectBar", "mEndIndex不能再截取小于1s的视频");
              this.mEndIndex = (this.mStartIndex + this.bty);
              invalidate();
            }
            else if (paramMotionEvent.getX() >= this.btA)
            {
              this.mEndIndex = this.btA;
              ram.d("Q.qqstory.frameWidget.RangeSelectBar", "向右边边滑动");
              invalidate();
            }
            else
            {
              this.mEndIndex = ((int)paramMotionEvent.getX());
              invalidate();
            }
          }
        }
      }
      ram.d("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_UP");
      if ((this.aIY) || (this.aIZ))
      {
        this.aIY = false;
        this.aIZ = false;
        if (this.a != null) {
          this.a.es(this.mStartIndex - 20, this.mEndIndex - 20);
        }
        return true;
      }
      this.aIY = false;
      this.aIZ = false;
      continue;
      ram.d("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_CANCEL");
      if ((this.aIY) || (this.aIZ))
      {
        this.aIY = false;
        this.aIZ = false;
        return true;
      }
      this.aIY = false;
      this.aIZ = false;
    }
  }
  
  public void setEndIndex(int paramInt)
  {
    if (paramInt - this.mStartIndex < this.bty)
    {
      ram.d("Q.qqstory.frameWidget.RangeSelectBar", "mEndIndex不能再截取小于1s的视频");
      this.mEndIndex = (this.mStartIndex + this.bty);
      return;
    }
    if (paramInt >= this.btA)
    {
      this.mEndIndex = this.btA;
      ram.d("Q.qqstory.frameWidget.RangeSelectBar", "向右边边滑动");
      return;
    }
    this.mEndIndex = paramInt;
  }
  
  public void setFrameSize(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2)
  {
    if (this.mPadding <= 0) {}
    for (int i = 100;; i = this.mPadding)
    {
      this.mPadding = i;
      this.frameHeight = paramInt1;
      this.frameWidth = paramInt2;
      this.bty = ((int)(paramInt2 / (paramInt3 / paramFloat2)));
      Bitmap localBitmap1 = rpq.b(getContext().getResources(), 2130850017, this.mPadding / 2, paramInt1 / 2);
      Bitmap localBitmap2 = rpq.b(getContext().getResources(), 2130850019, this.mPadding / 2, paramInt1 / 2);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(this.btB);
      localGradientDrawable.setCornerRadii(new float[] { 5.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 5.0F });
      localGradientDrawable.setStroke(aqcx.dip2px(getContext(), 3.0F), this.btB);
      localGradientDrawable.setBounds(0, 0, this.mPadding, paramInt1);
      this.cO = Bitmap.createBitmap(this.mPadding, paramInt1, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(this.cO);
      localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localGradientDrawable.draw(localCanvas);
      if (localBitmap1 != null) {
        localCanvas.drawBitmap(localBitmap1, (this.mPadding - localBitmap1.getWidth()) / 2, (paramInt1 - localBitmap1.getHeight()) / 2, this.mPaint);
      }
      this.cP = Bitmap.createBitmap(this.mPadding, paramInt1, Bitmap.Config.ARGB_8888);
      localCanvas.setBitmap(this.cP);
      localGradientDrawable.setCornerRadii(new float[] { 0.0F, 0.0F, 5.0F, 5.0F, 5.0F, 5.0F, 0.0F, 0.0F });
      localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localGradientDrawable.draw(localCanvas);
      if (localBitmap2 != null) {
        localCanvas.drawBitmap(localBitmap2, (this.mPadding - localBitmap2.getWidth()) / 2, (paramInt1 - localBitmap2.getHeight()) / 2, this.mPaint);
      }
      this.mStartIndex = this.mPadding;
      this.mEndIndex = ((int)(this.mPadding + Math.ceil(paramFloat1) * paramInt2));
      this.nL = (this.mPadding + paramInt2 * paramFloat1);
      this.btz = this.mStartIndex;
      this.btA = this.mEndIndex;
      return;
    }
  }
  
  public void setRangeChangeListener(a parama)
  {
    this.a = parama;
  }
  
  public void setStartIndex(int paramInt)
  {
    if (this.mEndIndex - paramInt < this.bty)
    {
      ram.d("Q.qqstory.frameWidget.RangeSelectBar", "mStartIndex不能再截取小于1s的视频");
      this.mStartIndex = (this.mEndIndex - this.bty);
      return;
    }
    if (paramInt <= this.btz)
    {
      ram.d("Q.qqstory.frameWidget.RangeSelectBar", "向左边边滑动");
      this.mStartIndex = this.btz;
      return;
    }
    this.mStartIndex = paramInt;
  }
  
  public int tH()
  {
    return this.mPadding;
  }
  
  public static abstract interface a
  {
    public abstract void bvC();
    
    public abstract void es(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.RangeSelectBar
 * JD-Core Version:    0.7.0.1
 */