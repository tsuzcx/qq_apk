package com.tencent.biz.webviewplugin;

import arhz;
import com.tencent.qphone.base.util.QLog;

class NewReportPlugin$2$2
  implements Runnable
{
  NewReportPlugin$2$2(NewReportPlugin.2 param2, Exception paramException) {}
  
  public void run()
  {
    this.this$0.p.dismiss();
    if (QLog.isColorLevel()) {
      QLog.d("NewReportPlugin", 2, "nearbySafetyRealReport exception1" + this.b.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.2.2
 * JD-Core Version:    0.7.0.1
 */