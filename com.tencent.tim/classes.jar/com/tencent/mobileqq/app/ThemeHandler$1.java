package com.tencent.mobileqq.app;

import acfp;
import acmi;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ThemeHandler$1
  implements Runnable
{
  public ThemeHandler$1(acmi paramacmi) {}
  
  public void run()
  {
    QQToast.a(this.this$0.mApp.getApplication(), acfp.m(2131715308), 4000).show();
    QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Error, QQToast.makeText: set default theme");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThemeHandler.1
 * JD-Core Version:    0.7.0.1
 */