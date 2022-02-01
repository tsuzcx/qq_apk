package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class VideoFeedsAlphaMaskView
  extends View
{
  private final int aUx = -635823590;
  private final int aUy = 218;
  private float mAlpha = 1.0F;
  private Paint mPaint = new Paint();
  
  public VideoFeedsAlphaMaskView(Context paramContext)
  {
    super(paramContext);
    this.mPaint.setColor(-635823590);
  }
  
  public VideoFeedsAlphaMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mPaint.setColor(-635823590);
  }
  
  public VideoFeedsAlphaMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint.setColor(-635823590);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mPaint.setAlpha((int)(this.mAlpha * 218.0F));
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.mPaint);
  }
  
  public void setAlpha(float paramFloat)
  {
    if (this.mAlpha != paramFloat)
    {
      this.mAlpha = paramFloat;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView
 * JD-Core Version:    0.7.0.1
 */