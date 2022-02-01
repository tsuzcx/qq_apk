package com.tencent.mobileqq.apollo;

import abhh;
import com.tencent.mobileqq.data.ApolloPandora;
import com.tencent.qphone.base.util.QLog;

public class ApolloManager$18
  implements Runnable
{
  public ApolloManager$18(abhh paramabhh, String paramString) {}
  
  public void run()
  {
    ApolloPandora localApolloPandora = this.this$0.a(this.val$uin, true);
    if (localApolloPandora != null)
    {
      localApolloPandora.hadStolen = 1;
      this.this$0.a(localApolloPandora);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "setCapsuleHadStolenAsync uin had Stolen");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloManager", 2, "setCapsuleHadStolenAsync local not save apolloPandora");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.18
 * JD-Core Version:    0.7.0.1
 */