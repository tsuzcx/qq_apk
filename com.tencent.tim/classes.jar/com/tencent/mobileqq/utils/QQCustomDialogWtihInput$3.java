package com.tencent.mobileqq.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import aqky;
import java.lang.ref.SoftReference;
import java.util.TimerTask;

public class QQCustomDialogWtihInput$3
  extends TimerTask
{
  public QQCustomDialogWtihInput$3(aqky paramaqky) {}
  
  public void run()
  {
    Context localContext = (Context)aqky.a(this.this$0).get();
    if (localContext != null) {
      ((InputMethodManager)localContext.getSystemService("input_method")).toggleSoftInput(0, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInput.3
 * JD-Core Version:    0.7.0.1
 */