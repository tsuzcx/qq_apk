package com.tencent.token.ui;

import android.os.Message;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class sf
  extends bo
{
  sf(NoCheckWithAuthActivity paramNoCheckWithAuthActivity)
  {
    super(paramNoCheckWithAuthActivity);
  }
  
  public final void handleMessage(Message paramMessage)
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
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131361831, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.sf
 * JD-Core Version:    0.7.0.1
 */