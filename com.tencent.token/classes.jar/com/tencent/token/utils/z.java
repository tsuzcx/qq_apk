package com.tencent.token.utils;

import android.os.Handler;
import android.os.Message;

final class z
  extends Handler
{
  private z(byte paramByte) {}
  
  public final void handleMessage(Message paramMessage)
  {
    aa localaa = (aa)paramMessage.obj;
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return;
    case 1: 
      UserTask.a(localaa.a, localaa.b[0]);
      return;
    }
    localaa.a.a();
    UserTask.a(localaa.a, UserTask.Status.FINISHED);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.z
 * JD-Core Version:    0.7.0.1
 */