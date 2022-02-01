package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.graphics.Paint.FontMetrics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class NoExtraPaddingTextView
  extends TextView
{
  public NoExtraPaddingTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public NoExtraPaddingTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public NoExtraPaddingTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    float f1 = localFontMetrics.descent;
    float f2 = localFontMetrics.ascent;
    f1 = (getLineHeight() - (f1 - f2)) / 2.0F;
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), (int)(getPaddingBottom() - f1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.NoExtraPaddingTextView
 * JD-Core Version:    0.7.0.1
 */