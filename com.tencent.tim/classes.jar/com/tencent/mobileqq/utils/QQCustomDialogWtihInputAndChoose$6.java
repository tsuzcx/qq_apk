package com.tencent.mobileqq.utils;

import android.view.WindowManager;
import aqla;
import com.tencent.mobileqq.activity.qwallet.widget.MyLinearLayout;

public class QQCustomDialogWtihInputAndChoose$6
  implements Runnable
{
  public QQCustomDialogWtihInputAndChoose$6(aqla paramaqla) {}
  
  public void run()
  {
    if (this.this$0.f == null) {
      return;
    }
    this.this$0.mWindowManager.addView(this.this$0.a, this.this$0.f);
    this.this$0.brS = true;
    this.this$0.a.post(new QQCustomDialogWtihInputAndChoose.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.6
 * JD-Core Version:    0.7.0.1
 */