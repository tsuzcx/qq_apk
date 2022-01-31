package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Message;

public class QWalletAuthObserver
  implements BusinessObserver
{
  private Handler a;
  
  public QWalletAuthObserver(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = 1;
    if (this.a == null) {}
    while (paramInt != 1) {
      return;
    }
    Handler localHandler = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      localHandler.obtainMessage(paramInt, i, 0, paramObject).sendToTarget();
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QWalletAuthObserver
 * JD-Core Version:    0.7.0.1
 */