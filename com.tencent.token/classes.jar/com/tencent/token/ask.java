package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ask
  extends Handler
{
  ask(asj paramasj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    al localal = new al();
    localal.d = -50004;
    localal.c = paramMessage.what;
    StringBuilder localStringBuilder = new StringBuilder("seq : ");
    localStringBuilder.append(paramMessage.what);
    localStringBuilder.append("超时");
    asj.a(this.a, localal);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ask
 * JD-Core Version:    0.7.0.1
 */