package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;

public class EllipsisTextView
  extends TextView
{
  public EllipsisTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public EllipsisTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public EllipsisTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setMaxLines(1);
    setEllipsize(TextUtils.TruncateAt.END);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Layout localLayout = getLayout();
    if (localLayout.getEllipsisCount(0) > 0)
    {
      paramInt1 = (int)(localLayout.getLineRight(0) + 0.5F);
      paramInt2 = getMeasuredHeight();
      setMeasuredDimension(paramInt1 + getCompoundPaddingLeft() + getCompoundPaddingRight(), paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.EllipsisTextView
 * JD-Core Version:    0.7.0.1
 */