package com.tencent.token.ui.base;

import android.os.Handler;
import android.os.Message;

class ac
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (paramMessage.obj == null);
    ((Runnable)paramMessage.obj).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ac
 * JD-Core Version:    0.7.0.1
 */