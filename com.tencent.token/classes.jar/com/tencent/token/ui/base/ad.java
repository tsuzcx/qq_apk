package com.tencent.token.ui.base;

import android.os.Handler;
import android.os.Message;

public final class ad
{
  private static final Handler a = new ae();
  
  private ad()
  {
    throw new UnsupportedOperationException();
  }
  
  public static void a(Runnable paramRunnable)
  {
    Message localMessage = new Message();
    localMessage.what = 1000;
    localMessage.obj = paramRunnable;
    a.sendMessageDelayed(localMessage, 16L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ad
 * JD-Core Version:    0.7.0.1
 */