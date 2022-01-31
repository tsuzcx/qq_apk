package com.tencent.token.utils;

import android.os.Handler;
import android.os.Message;

class q
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    p localp = (p)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      MyAsyncTask.a(localp.a, localp.b[0]);
      return;
    }
    localp.a.a(localp.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.q
 * JD-Core Version:    0.7.0.1
 */