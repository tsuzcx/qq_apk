package com.tencent.qqmail.view.listscroller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;

public class ScrollSendSmsTextView
  extends ScrollContacTextView
{
  public ScrollSendSmsTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mStartDegree = 12;
    this.mEndDegree = -12;
    this.mDrawLeftHalfHeight = this.mDrawLeft.getHeight();
  }
  
  public void doScrollTextView(int paramInt, boolean paramBoolean)
  {
    if (paramInt > this.mCanTranslate)
    {
      this.mScrollX = (this.mCanTranslate - paramInt);
      if (paramBoolean)
      {
        startCarton();
        return;
      }
    }
    stopCarton();
  }
  
  protected void drawComponent(Canvas paramCanvas)
  {
    if (this.mScrollX < 0)
    {
      paramCanvas.translate(this.mScrollLeft - this.mScrollX, 0.0F);
      paramCanvas.translate(0.0F, this.mDrawLeftTop);
      paramCanvas.drawBitmap(this.mDrawLeft, this.mMatrix, this.mPaint);
      paramCanvas.translate(this.mDrawLeftWidth, -this.mDrawLeftTop);
      return;
    }
    paramCanvas.translate(this.mScrollLeft, 0.0F);
    paramCanvas.drawBitmap(this.mDrawLeft, 0.0F, this.mDrawLeftTop, null);
    paramCanvas.translate(this.mDrawLeftWidth, 0.0F);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mCanTranslate = (getWidth() + this.mScrollLeft - (getWidth() - (int)getLayout().getPaint().measureText(getText(), 0, length()) - this.mDrawLeftWidth + DeviceUtil.dip2px(28.0F) >> 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.listscroller.ScrollSendSmsTextView
 * JD-Core Version:    0.7.0.1
 */