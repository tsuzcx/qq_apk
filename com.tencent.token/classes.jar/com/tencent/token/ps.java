package com.tencent.token;

import android.os.Handler;
import android.os.Message;

public final class ps
  extends Handler
{
  private final int a;
  private final boolean b;
  private long c;
  private final a d;
  
  public final void a()
  {
    removeMessages(this.a);
  }
  
  protected final void finalize()
  {
    a();
    super.finalize();
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == this.a)
    {
      paramMessage = this.d;
      if (paramMessage == null) {
        return;
      }
      if (!paramMessage.a()) {
        return;
      }
      if (this.b) {
        sendEmptyMessageDelayed(this.a, this.c);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ps
 * JD-Core Version:    0.7.0.1
 */