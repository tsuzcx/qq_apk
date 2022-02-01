package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class SingleLineTextView
  extends TextView
{
  private static final String UU = new String(i);
  private static final char[] i = { '…' };
  private StringBuilder mStringBuilder = new StringBuilder();
  
  public SingleLineTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SingleLineTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SingleLineTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    TextPaint localTextPaint = getPaint();
    CharSequence localCharSequence = getText();
    if (localTextPaint.measureText(localCharSequence.toString()) > paramInt1)
    {
      paramInt1 = localTextPaint.breakText(localCharSequence, 0, localCharSequence.length(), true, paramInt1 - localTextPaint.measureText(UU), null);
      this.mStringBuilder.delete(0, this.mStringBuilder.length()).append(localCharSequence.subSequence(0, paramInt1)).append(UU);
      setText(this.mStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.SingleLineTextView
 * JD-Core Version:    0.7.0.1
 */