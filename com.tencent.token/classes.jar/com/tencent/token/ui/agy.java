package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.ag;
import com.tencent.token.core.bean.QueryCaptchaResult;

final class agy
  extends Handler
{
  agy(WelcomeActivity paramWelcomeActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing()))) {}
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        }
      } while (paramMessage.arg1 != 0);
      paramMessage = ag.c();
      paramMessage.i();
      paramMessage.n();
      return;
    } while ((paramMessage.arg1 != 0) || (((QueryCaptchaResult)paramMessage.obj).mNeedCaptcha));
    WelcomeActivity.access$000(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.agy
 * JD-Core Version:    0.7.0.1
 */