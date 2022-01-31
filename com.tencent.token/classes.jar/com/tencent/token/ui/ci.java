package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;

final class ci
  extends Handler
{
  ci(CorrectTokenActivity paramCorrectTokenActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing()))) {
      return;
    }
    CorrectTokenActivity.access$000(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ci
 * JD-Core Version:    0.7.0.1
 */