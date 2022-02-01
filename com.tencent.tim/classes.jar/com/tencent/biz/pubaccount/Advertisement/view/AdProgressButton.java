package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.ProgressButton;

public class AdProgressButton
  extends ProgressButton
{
  public AdProgressButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdProgressButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    getPaddingLeft();
    getPaddingRight();
    int i = getPaddingTop();
    int j = getPaddingBottom();
    int k = getHeight();
    getWidth();
    if (this.mUnitlength == 0.0F) {
      this.mUnitlength = (getWidth() / this.mMaxProgress);
    }
    paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, this.mUnitlength * this.mProgress, k - i - j), 5.0F, 5.0F, this.mPaint);
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton
 * JD-Core Version:    0.7.0.1
 */