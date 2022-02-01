package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ati
  extends Handler
{
  ati(ath paramath, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    az localaz = new az();
    localaz.d = -50004;
    localaz.c = paramMessage.what;
    StringBuilder localStringBuilder = new StringBuilder("seq : ");
    localStringBuilder.append(paramMessage.what);
    localStringBuilder.append("超时");
    ath.a(this.a, localaz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ati
 * JD-Core Version:    0.7.0.1
 */