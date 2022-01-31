package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;

class cx
  extends Handler
{
  cx(CorrectTokenActivity paramCorrectTokenActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing()))) {
      return;
    }
    CorrectTokenActivity.access$000(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cx
 * JD-Core Version:    0.7.0.1
 */