package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView.BufferType;
import com.tencent.qphone.base.util.QLog;
import java.util.EmptyStackException;

public class PatchedButton
  extends Button
{
  public PatchedButton(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public PatchedButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PatchedButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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
  
  public void setBackgroundResource(int paramInt)
  {
    try
    {
      super.setBackgroundResource(paramInt);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PatchedTextView", 2, localNullPointerException.toString());
      return;
    }
    catch (EmptyStackException localEmptyStackException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PatchedTextView", 2, localEmptyStackException.toString());
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.PatchedButton
 * JD-Core Version:    0.7.0.1
 */