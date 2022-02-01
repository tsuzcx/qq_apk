package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class aps
  extends Handler
{
  WeakReference a = null;
  
  public aps(aqs paramaqs, Context paramContext)
  {
    super(paramContext.getMainLooper());
    this.a = new WeakReference(paramaqs);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    aqs localaqs = (aqs)this.a.get();
    if (localaqs == null) {
      return;
    }
    if (paramMessage.what != 0) {
      return;
    }
    int i = localaqs.c + 1;
    localaqs.c = i;
    if (i < 20)
    {
      if (localaqs.d()) {
        localaqs.c = 0;
      }
    }
    else {
      localaqs.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aps
 * JD-Core Version:    0.7.0.1
 */