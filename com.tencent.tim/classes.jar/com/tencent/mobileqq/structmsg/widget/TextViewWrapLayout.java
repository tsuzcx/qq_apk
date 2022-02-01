package com.tencent.mobileqq.structmsg.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TextViewWrapLayout
  extends RelativeLayout
{
  private boolean cKe;
  
  public TextViewWrapLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TextViewWrapLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TextViewWrapLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void Qw(boolean paramBoolean)
  {
    this.cKe = paramBoolean;
    requestLayout();
    invalidate();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      if (this.cKe)
      {
        TextView localTextView1 = (TextView)findViewById(2131380976);
        TextView localTextView2 = (TextView)findViewById(2131380951);
        if ((localTextView2 != null) && (localTextView1 != null) && (4 - localTextView1.getLineCount() > 0)) {
          localTextView2.setMaxLines(4 - localTextView1.getLineCount());
        }
        this.cKe = false;
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout
 * JD-Core Version:    0.7.0.1
 */