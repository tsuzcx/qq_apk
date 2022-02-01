package com.tencent.mobileqq.activity.qwallet.red;

import aaai;
import aadk;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QWalletRedManager$1
  implements Runnable
{
  public QWalletRedManager$1(aadk paramaadk) {}
  
  public void run()
  {
    Object localObject = (aaai)aadk.a(this.this$0).getManager(245);
    if (localObject != null)
    {
      ((aaai)localObject).a("redPoint", this.this$0);
      localObject = ((aaai)localObject).getConfigInfo("redPoint");
      aadk.a(this.this$0).parseConfig((QWalletConfig.a)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "synDataFromMoggy" + aadk.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.1
 * JD-Core Version:    0.7.0.1
 */