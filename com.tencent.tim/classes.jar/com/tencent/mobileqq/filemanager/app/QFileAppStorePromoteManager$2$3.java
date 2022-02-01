package com.tencent.mobileqq.filemanager.app;

import agil;
import agil.c;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QFileAppStorePromoteManager$2$3
  implements Runnable
{
  QFileAppStorePromoteManager$2$3(QFileAppStorePromoteManager.2 param2, int paramInt) {}
  
  public void run()
  {
    this.a.a.dgp();
    agil.c localc = (agil.c)agil.a(this.a.this$0).remove(Integer.valueOf(this.cXi));
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("request appInfo time limit. remove reqId[").append(this.cXi).append("] result[");
      if (localc == null) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, bool + "]");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.2.3
 * JD-Core Version:    0.7.0.1
 */