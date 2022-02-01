package com.tencent.tim.activity.profile.host;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.DynamicDrawableSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import atau.a;

public class EllipsizeWithImageSpanTextView
  extends TextView
{
  private int mMaxLines = 1;
  
  public EllipsizeWithImageSpanTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d(paramContext, paramAttributeSet);
  }
  
  public EllipsizeWithImageSpanTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d(paramContext, paramAttributeSet);
  }
  
  private int a(String paramString, float paramFloat)
  {
    int i = 0;
    TextPaint localTextPaint = getPaint();
    int j = 0;
    String str;
    if (i < this.mMaxLines - 1)
    {
      str = paramString.substring(j);
      if (localTextPaint.measureText(str) > paramFloat) {}
    }
    else
    {
      return j;
    }
    int m = TextUtils.ellipsize(str, localTextPaint, paramFloat, TextUtils.TruncateAt.END).length() + j;
    for (;;)
    {
      int k = j;
      if (m < paramString.length())
      {
        if (localTextPaint.measureText(paramString.substring(j, m)) > paramFloat) {
          k = m - 1;
        }
      }
      else
      {
        i += 1;
        j = k;
        break;
      }
      m += 1;
    }
  }
  
  private void a(String paramString, DynamicDrawableSpan paramDynamicDrawableSpan)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      SpannableString localSpannableString = new SpannableString(paramString + "[edit]");
      localSpannableString.setSpan(paramDynamicDrawableSpan, paramString.length(), paramString.length() + "[edit]".length(), 33);
      setText(localSpannableString);
    }
  }
  
  private void d(Context paramContext, AttributeSet paramAttributeSet)
  {
    setEllipsize(TextUtils.TruncateAt.END);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qj);
    this.mMaxLines = paramContext.getInteger(0, 1);
    paramContext.recycle();
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    this.mMaxLines = paramInt;
  }
  
  public void setTextIncludingSpan(CharSequence paramCharSequence, DynamicDrawableSpan paramDynamicDrawableSpan, float paramFloat)
  {
    if (this.mMaxLines <= 0)
    {
      setText(paramCharSequence);
      return;
    }
    paramCharSequence = String.valueOf(paramCharSequence);
    int i = a(paramCharSequence, paramFloat);
    CharSequence localCharSequence = TextUtils.ellipsize(paramCharSequence.substring(i), getPaint(), paramFloat, TextUtils.TruncateAt.END);
    StringBuilder localStringBuilder = new StringBuilder();
    if (i > 0) {}
    for (paramCharSequence = paramCharSequence.substring(0, i);; paramCharSequence = "")
    {
      a(paramCharSequence + localCharSequence, paramDynamicDrawableSpan);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.activity.profile.host.EllipsizeWithImageSpanTextView
 * JD-Core Version:    0.7.0.1
 */