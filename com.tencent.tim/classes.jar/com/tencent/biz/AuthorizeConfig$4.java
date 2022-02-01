package com.tencent.biz;

import com.tencent.qphone.base.util.QLog;
import jml;
import mqq.manager.TicketManager;

public class AuthorizeConfig$4
  implements Runnable
{
  public AuthorizeConfig$4(jml paramjml, TicketManager paramTicketManager, String paramString, String[] paramArrayOfString) {}
  
  public void run()
  {
    try
    {
      if (this.a != null) {
        this.a.GetPskey(this.val$account, 16L, this.aX, this.this$0.a);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AuthorizeConfig", 1, new Object[] { "preloadPskey exception ", localException.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.4
 * JD-Core Version:    0.7.0.1
 */