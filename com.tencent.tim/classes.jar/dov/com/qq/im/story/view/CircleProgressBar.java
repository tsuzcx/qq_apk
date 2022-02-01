package dov.com.qq.im.story.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CircleProgressBar
  extends View
{
  private int bvd = -1;
  private int eJS = -16777216;
  private int eJT = 0;
  private int mCircleWidth = 10;
  private int mCurrentProgress;
  private int mMaxProgress = 100;
  private Paint mPaint;
  private int mWidth;
  
  public CircleProgressBar(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public CircleProgressBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public CircleProgressBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = this.mWidth / 2;
    float f2 = this.mWidth / 2;
    float f3 = this.mWidth / 2 - this.mCircleWidth / 2;
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(this.mCircleWidth);
    this.mPaint.setColor(this.bvd);
    paramCanvas.drawCircle(f1, f2, f3, this.mPaint);
    RectF localRectF = new RectF(this.mCircleWidth / 2, this.mCircleWidth / 2, this.mWidth - this.mCircleWidth / 2, this.mWidth - this.mCircleWidth / 2);
    this.mPaint.setColor(this.eJS);
    paramCanvas.drawArc(localRectF, -90.0F, this.mCurrentProgress * 360 / this.mMaxProgress, false, this.mPaint);
    this.mPaint.setColor(this.eJT);
    this.mPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(f1, f2, this.mWidth / 2 - this.mCircleWidth, this.mPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mWidth = getMeasuredWidth();
  }
  
  public void setCircleBackgroundColor(int paramInt)
  {
    this.bvd = paramInt;
  }
  
  public void setCircleCenterColor(int paramInt)
  {
    this.eJT = paramInt;
  }
  
  public void setCircleProgressColor(int paramInt)
  {
    this.eJS = paramInt;
  }
  
  public void setCircleWidth(int paramInt)
  {
    this.mCircleWidth = paramInt;
  }
  
  public void setCurrentProgress(int paramInt)
  {
    if (paramInt == this.mCurrentProgress) {
      return;
    }
    this.mCurrentProgress = paramInt;
    invalidate();
  }
  
  public void setMaxProgress(int paramInt)
  {
    this.mMaxProgress = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.story.view.CircleProgressBar
 * JD-Core Version:    0.7.0.1
 */