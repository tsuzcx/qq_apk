package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ProgressView
  extends View
{
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private int progress;
  
  public ProgressView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setDither(true);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStrokeWidth(10.0F);
    this.mPaint.setColor(-65536);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawRect(0.0F, 0.0F, this.mWidth * this.progress / 100, this.mHeight, this.mPaint);
    super.onDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColor(int paramInt)
  {
    this.mPaint.setColor(paramInt);
  }
  
  public void setProgress(int paramInt)
  {
    this.progress = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.ProgressView
 * JD-Core Version:    0.7.0.1
 */