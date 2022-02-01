package com.tencent.biz.webviewplugin;

import acfp;
import arhz;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import stk;

public class NewReportPlugin$1$1
  implements Runnable
{
  public NewReportPlugin$1$1(stk paramstk) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.p.isShowing()) {
        this.this$0.p.dismiss();
      }
      QQToast.a(this.this$0.val$activity, 2, acfp.m(2131709108), 0).show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NewReportPlugin", 2, "handleGetTinyId, exp=" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */