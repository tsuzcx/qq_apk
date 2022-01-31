package com.tencent.service.update;

import android.os.Handler;
import android.os.Message;

class f
  extends Handler
{
  f(UpdateDownloadDialog paramUpdateDownloadDialog) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 99) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.f
 * JD-Core Version:    0.7.0.1
 */