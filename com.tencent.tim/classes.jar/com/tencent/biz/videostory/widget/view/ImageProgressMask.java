package com.tencent.biz.videostory.widget.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import aqfi;

public class ImageProgressMask
  extends View
{
  private int mHeight;
  private Paint mPaint;
  private Path mPath;
  private float mProgress;
  private RectF mRectF;
  private int mWidth;
  
  public ImageProgressMask(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ImageProgressMask(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImageProgressMask(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setColor(getResources().getColor(2131165632));
    this.mPaint.setAntiAlias(true);
    this.mPath = new Path();
    this.mRectF = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    if (Build.VERSION.SDK_INT <= 16) {
      setLayerType(1, null);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      paramCanvas.save();
      paramCanvas.clipPath(this.mPath);
      if ((this.mWidth == 0) && (this.mHeight == 0))
      {
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        this.mRectF = new RectF(0.0F, this.mHeight * this.mProgress, this.mWidth, this.mHeight);
      }
      paramCanvas.drawRect(this.mRectF, this.mPaint);
      super.onDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    catch (Exception localException)
    {
      super.onDraw(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != 0) && (paramInt2 != 0) && ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))) {
      this.mPath = aqfi.a(paramInt1, paramInt2);
    }
  }
  
  public void setProgress(float paramFloat)
  {
    this.mProgress = paramFloat;
    this.mWidth = getWidth();
    this.mHeight = getHeight();
    this.mRectF = new RectF(0.0F, this.mHeight * this.mProgress, this.mWidth, this.mHeight);
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.ImageProgressMask
 * JD-Core Version:    0.7.0.1
 */