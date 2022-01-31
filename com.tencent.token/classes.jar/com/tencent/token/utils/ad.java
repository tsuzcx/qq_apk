package com.tencent.token.utils;

import android.os.Handler;
import android.os.Message;

class ad
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    ae localae = (ae)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      UserTask.a(localae.a, localae.b[0]);
      return;
    case 2: 
      localae.a.b(localae.b);
      return;
    }
    localae.a.a();
    UserTask.a(localae.a, UserTask.Status.FINISHED);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.ad
 * JD-Core Version:    0.7.0.1
 */