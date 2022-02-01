package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.qphone.base.util.QLog;

public class PatchedTextView
  extends TextView
{
  private static final String TAG = "PatchedTextView";
  private boolean mDiscardNextActionUp;
  private boolean mTmpEnable = true;
  
  public PatchedTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PatchedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PatchedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean isEnabled()
  {
    return (this.mTmpEnable) && (super.isEnabled());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PatchedTextView", 2, "Error : Exception thrown in PatchedTextView.onMeasure", localException);
      }
      setText(getText().toString());
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((this.mDiscardNextActionUp) && ((i & 0xFF) == 1))
    {
      this.mTmpEnable = false;
      boolean bool = super.onTouchEvent(paramMotionEvent);
      this.mTmpEnable = true;
      this.mDiscardNextActionUp = false;
      return bool;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performLongClick()
  {
    boolean bool = super.performLongClick();
    if (bool) {
      this.mDiscardNextActionUp = true;
    }
    return bool;
  }
  
  public void setGravity(int paramInt)
  {
    try
    {
      super.setGravity(paramInt);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PatchedTextView", 2, "Error : Exception thrown in PatchedTextView.setGravity", localException);
      }
      setText(getText().toString());
      super.setGravity(paramInt);
    }
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    try
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
    }
    catch (Exception paramBufferType)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PatchedTextView", 2, "Error : Exception thrown in PatchedTextView.setText", paramBufferType);
      }
      super.setText(paramCharSequence.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PatchedTextView
 * JD-Core Version:    0.7.0.1
 */