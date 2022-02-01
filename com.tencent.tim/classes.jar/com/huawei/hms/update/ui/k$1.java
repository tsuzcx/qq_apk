package com.huawei.hms.update.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

class k$1
  extends Handler
{
  k$1(k paramk) {}
  
  public void handleMessage(Message paramMessage)
  {
    Bundle localBundle = (Bundle)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 101: 
      k.a(this.a, localBundle);
      return;
    case 102: 
      k.b(this.a, localBundle);
      return;
    }
    k.c(this.a, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.ui.k.1
 * JD-Core Version:    0.7.0.1
 */