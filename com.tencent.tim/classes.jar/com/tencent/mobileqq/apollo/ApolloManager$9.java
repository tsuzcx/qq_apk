package com.tencent.mobileqq.apollo;

import abhh;
import abvl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ApolloManager$9
  implements Runnable
{
  public ApolloManager$9(abhh paramabhh, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    try
    {
      if ((this.f.cZ == 0) && (this.this$0.mApp != null)) {
        abhh.g(this.this$0.mApp, this.f.aTl, "C2CAIO");
      }
      for (;;)
      {
        abvl.a().l(this.this$0.mApp, this.f);
        return;
        if ((this.f.cZ == 1) && (this.this$0.mApp != null)) {
          ((abhh)this.this$0.mApp.getManager(153)).cBN();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ApolloManager", 2, "doAfterOpenAIO error", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.9
 * JD-Core Version:    0.7.0.1
 */