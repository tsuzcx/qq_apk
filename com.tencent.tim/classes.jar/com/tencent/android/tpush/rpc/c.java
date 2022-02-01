package com.tencent.android.tpush.rpc;

import android.content.Context;
import android.content.ServiceConnection;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;

public class c
  extends b.a
{
  private ServiceConnection a;
  
  public void a()
  {
    try
    {
      if (b.e() != null)
      {
        b.e().unbindService(this.a);
        this.a = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("ITaskCallbackImpl", "unBind", localThrowable);
    }
  }
  
  public void a(ServiceConnection paramServiceConnection)
  {
    this.a = paramServiceConnection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.rpc.c
 * JD-Core Version:    0.7.0.1
 */