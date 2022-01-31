package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.f;

class zx
  extends Handler
{
  zx(StartPwdGestureIndexActivity paramStartPwdGestureIndexActivity) {}
  
  public void handleMessage(Message paramMessage)
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
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    this.a.showUserDialog(2131230767, paramMessage.c, 2131230897, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zx
 * JD-Core Version:    0.7.0.1
 */