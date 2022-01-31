package com.tencent.av.widget;

import android.content.Context;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.widget.TextView;

public class EllipseTextView
  extends TextView
{
  private float a = 1.0F;
  private float b = 0.0F;
  
  public EllipseTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public EllipseTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EllipseTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public String a(int paramInt, String paramString)
  {
    StaticLayout localStaticLayout = new StaticLayout(paramString, super.getPaint(), super.getWidth() - super.getPaddingLeft() - super.getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.a, this.b, false);
    String str = paramString;
    if (localStaticLayout.getLineCount() > paramInt) {
      str = paramString.substring(0, localStaticLayout.getLineEnd(paramInt - 1)).trim();
    }
    return str;
  }
  
  public void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    this.b = paramFloat1;
    this.a = paramFloat2;
    super.setLineSpacing(paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.widget.EllipseTextView
 * JD-Core Version:    0.7.0.1
 */