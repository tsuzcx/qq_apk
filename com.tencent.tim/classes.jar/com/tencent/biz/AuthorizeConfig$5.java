package com.tencent.biz;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import jml;
import mqq.manager.TicketManager;

public class AuthorizeConfig$5
  implements Runnable
{
  public AuthorizeConfig$5(jml paramjml, TicketManager paramTicketManager, String paramString, String[] paramArrayOfString) {}
  
  public void run()
  {
    try
    {
      if (this.a != null) {
        if ((this.a.GetPskey(this.val$account, 16L, this.aX, this.this$0.a) == null) || (TextUtils.isEmpty(this.a.getSkey(this.val$account)))) {
          break label84;
        }
      }
      label84:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("AuthorizeConfig", 1, "pre hits result : " + bool);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AuthorizeConfig", 1, "preload k exception ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.5
 * JD-Core Version:    0.7.0.1
 */