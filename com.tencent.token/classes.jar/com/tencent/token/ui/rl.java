package com.tencent.token.ui;

import android.os.Message;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class rl
  extends cb
{
  rl(NoCheckWithAuthActivity paramNoCheckWithAuthActivity)
  {
    super(paramNoCheckWithAuthActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (paramMessage.arg1 == 0)
    {
      if (paramMessage.arg2 == 1) {}
      for (;;)
      {
        NoCheckWithAuthActivity.access$000(this.a, bool);
        return;
        bool = false;
      }
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131230779, paramMessage.c, 2131230897, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rl
 * JD-Core Version:    0.7.0.1
 */