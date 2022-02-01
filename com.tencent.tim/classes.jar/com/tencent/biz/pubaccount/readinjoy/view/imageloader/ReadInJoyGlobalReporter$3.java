package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import npa;

public class ReadInJoyGlobalReporter$3
  implements Runnable
{
  public ReadInJoyGlobalReporter$3(npa paramnpa) {}
  
  public void run()
  {
    try
    {
      if (npa.b(this.this$0) == 1)
      {
        BaseApplicationImpl.getContext().unregisterReceiver(this.this$0.a);
        npa.a(this.this$0, 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyGlobalReporter", 2, "unRegisterScreenListener");
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("ReadInJoyGlobalReporter", 2, "unRegisterScreenListener:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter.3
 * JD-Core Version:    0.7.0.1
 */