package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.d;

final class abr
  extends Handler
{
  abr(StartPwdGestureIndexActivity paramStartPwdGestureIndexActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (paramMessage.arg1 == 0)
    {
      StartPwdGestureIndexActivity.access$000(this.a);
      return;
    }
    this.a.dismissDialog();
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    this.a.showUserDialog(2131362290, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abr
 * JD-Core Version:    0.7.0.1
 */