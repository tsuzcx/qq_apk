package com.tencent.qqmail.register.view;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class TouchableSpan
  extends ClickableSpan
{
  private boolean mIsPressed;
  private int mNormalBackgroundColor;
  private int mNormalTextColor;
  private int mPressedBackgroundColor;
  private int mPressedTextColor;
  
  public TouchableSpan(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mNormalTextColor = paramInt1;
    this.mPressedTextColor = paramInt2;
    this.mNormalBackgroundColor = paramInt3;
    this.mPressedBackgroundColor = paramInt4;
  }
  
  public boolean isPressed()
  {
    return this.mIsPressed;
  }
  
  public void setPressed(boolean paramBoolean)
  {
    this.mIsPressed = paramBoolean;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    if (this.mIsPressed)
    {
      i = this.mPressedTextColor;
      paramTextPaint.setColor(i);
      if (!this.mIsPressed) {
        break label53;
      }
    }
    label53:
    for (int i = this.mPressedBackgroundColor;; i = this.mNormalBackgroundColor)
    {
      paramTextPaint.bgColor = i;
      paramTextPaint.setUnderlineText(false);
      return;
      i = this.mNormalTextColor;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.view.TouchableSpan
 * JD-Core Version:    0.7.0.1
 */