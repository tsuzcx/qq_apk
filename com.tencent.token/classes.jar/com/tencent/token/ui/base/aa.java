package com.tencent.token.ui.base;

import android.os.Handler;
import android.os.Message;

public class aa
{
  private static final Handler a = new ac(null);
  
  public static void a(Runnable paramRunnable)
  {
    Message localMessage = new Message();
    localMessage.what = 1000;
    localMessage.obj = paramRunnable;
    a.sendMessageDelayed(localMessage, 16L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.aa
 * JD-Core Version:    0.7.0.1
 */