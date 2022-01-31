package com.tencent.mobileqq.structmsg.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer.CountDownTimerListener;
import gpm;

public class CountdownTextView
  extends TextView
{
  private CountDownTimer.CountDownTimerListener a;
  
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
  
  public String a(long paramLong)
  {
    long l2 = paramLong / 1000L;
    long l1 = l2 / 60L;
    paramLong = l1 / 60L;
    l2 %= 60L;
    l1 %= 60L;
    String str1 = String.valueOf(l2);
    String str2 = String.valueOf(l1);
    String str3 = String.valueOf(paramLong);
    if (l2 < 10L) {
      str1 = "0" + l2;
    }
    if (l1 < 10L) {
      str2 = "0" + l1;
    }
    if (paramLong < 10L) {
      str3 = "0" + paramLong;
    }
    if (str3.equals("00")) {
      return str2 + ":" + str1;
    }
    return str3 + ":" + str2 + ":" + str1;
  }
  
  public void a()
  {
    CountDownTimer localCountDownTimer = ChatActivity.a;
    if (localCountDownTimer != null) {
      localCountDownTimer.b(this.a);
    }
  }
  
  public void a(long paramLong, CountdownTextView.TimerCallback paramTimerCallback)
  {
    CountDownTimer localCountDownTimer = ChatActivity.a;
    if (localCountDownTimer != null)
    {
      this.a = new gpm(this, paramLong, paramTimerCallback);
      localCountDownTimer.a(this.a);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.widget.CountdownTextView
 * JD-Core Version:    0.7.0.1
 */