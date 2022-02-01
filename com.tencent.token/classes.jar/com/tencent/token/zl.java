package com.tencent.token;

import android.os.Handler;
import android.os.Message;

public final class zl
{
  private static final Handler a = new a((byte)0);
  
  public static void a(Runnable paramRunnable)
  {
    Message localMessage = new Message();
    localMessage.what = 1000;
    localMessage.obj = paramRunnable;
    a.sendMessageDelayed(localMessage, 16L);
  }
  
  static final class a
    extends Handler
  {
    public final void handleMessage(Message paramMessage)
    {
      if (paramMessage.what != 1000) {
        return;
      }
      if (paramMessage.obj != null) {
        ((Runnable)paramMessage.obj).run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zl
 * JD-Core Version:    0.7.0.1
 */