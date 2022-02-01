package com.tencent.token.ui.base;

import android.os.Handler;
import android.os.Message;

public class c
{
  private static final Handler a = new a(null);
  
  public static void a(Runnable paramRunnable)
  {
    Message localMessage = new Message();
    localMessage.what = 1000;
    localMessage.obj = paramRunnable;
    a.sendMessageDelayed(localMessage, 16L);
  }
  
  private static class a
    extends Handler
  {
    public void handleMessage(Message paramMessage)
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
 * Qualified Name:     com.tencent.token.ui.base.c
 * JD-Core Version:    0.7.0.1
 */