package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class LetterSpacingTextView
  extends TextView
{
  private CharSequence G = "";
  private float spacing = 0.0F;
  
  public LetterSpacingTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LetterSpacingTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public LetterSpacingTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void bYf()
  {
    if ((this == null) || (this.G == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.G.length())
    {
      localStringBuilder.append(this.G.charAt(i));
      if (i + 1 < this.G.length()) {
        localStringBuilder.append(" ");
      }
      i += 1;
    }
    SpannableString localSpannableString = new SpannableString(localStringBuilder.toString());
    if (localStringBuilder.toString().length() > 1)
    {
      i = 1;
      while (i < localStringBuilder.toString().length())
      {
        localSpannableString.setSpan(new ScaleXSpan(this.spacing), i, i + 1, 33);
        i += 2;
      }
    }
    super.setText(localSpannableString, TextView.BufferType.SPANNABLE);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet) {}
  
  public CharSequence getText()
  {
    return this.G;
  }
  
  public void setSpacing(float paramFloat)
  {
    this.spacing = paramFloat;
    bYf();
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    this.G = paramCharSequence;
    bYf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.LetterSpacingTextView
 * JD-Core Version:    0.7.0.1
 */