package com.tencent.qbardemo;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;

class MainActivity$4
  extends TimerTask
{
  MainActivity$4(MainActivity paramMainActivity) {}
  
  public void run()
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    this.this$0.uiHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qbardemo.MainActivity.4
 * JD-Core Version:    0.7.0.1
 */