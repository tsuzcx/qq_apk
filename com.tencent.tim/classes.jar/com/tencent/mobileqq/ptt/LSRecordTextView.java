package com.tencent.mobileqq.ptt;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class LSRecordTextView
  extends TextView
{
  private boolean cxf;
  private boolean cxg;
  
  public LSRecordTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LSRecordTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LSRecordTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void requestLayout()
  {
    if ((this.cxg) && (this.cxf)) {
      return;
    }
    super.requestLayout();
  }
  
  public void setNotLayoutInSettingText(boolean paramBoolean)
  {
    this.cxg = paramBoolean;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (this.cxg) {
      this.cxf = true;
    }
    super.setText(paramCharSequence, paramBufferType);
    this.cxf = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordTextView
 * JD-Core Version:    0.7.0.1
 */