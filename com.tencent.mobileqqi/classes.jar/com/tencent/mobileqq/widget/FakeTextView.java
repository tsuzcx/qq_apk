package com.tencent.mobileqq.widget;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class FakeTextView
  extends TextView
{
  private ActionBarActivity a;
  
  public FakeTextView(Context paramContext)
  {
    super(paramContext);
    if ((paramContext instanceof ActionBarActivity)) {
      this.a = ((ActionBarActivity)paramContext);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (this.a != null) {
      this.a.supportInvalidateOptionsMenu();
    }
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(paramCharSequence, paramBufferType);
    if (this.a != null) {
      this.a.supportInvalidateOptionsMenu();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (this.a != null) {
      this.a.supportInvalidateOptionsMenu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FakeTextView
 * JD-Core Version:    0.7.0.1
 */