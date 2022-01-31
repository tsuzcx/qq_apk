package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;

class du
  extends Handler
{
  du(DownloadAppActivity paramDownloadAppActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 99) {
      this.a.refreshUIByState();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.du
 * JD-Core Version:    0.7.0.1
 */