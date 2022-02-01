package com.tencent.mobileqq.structmsg.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import anvn;
import zxc;
import zxc.a;

public class CountdownTextView
  extends TextView
{
  private zxc.a jdField_a_of_type_Zxc$a;
  private zxc jdField_a_of_type_Zxc = new zxc();
  
  public CountdownTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CountdownTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CountdownTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(long paramLong, a parama)
  {
    zxc localzxc = this.jdField_a_of_type_Zxc;
    if (localzxc != null)
    {
      this.jdField_a_of_type_Zxc$a = new anvn(this, paramLong, parama);
      localzxc.a(this.jdField_a_of_type_Zxc$a);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    stopTimer();
  }
  
  public void stopTimer()
  {
    zxc localzxc = this.jdField_a_of_type_Zxc;
    if (localzxc != null) {
      localzxc.b(this.jdField_a_of_type_Zxc$a);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onFinish();
    
    public abstract void onTick(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.widget.CountdownTextView
 * JD-Core Version:    0.7.0.1
 */