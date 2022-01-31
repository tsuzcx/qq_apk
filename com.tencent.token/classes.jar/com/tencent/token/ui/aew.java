package com.tencent.token.ui;

import android.os.Message;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class aew
  extends bo
{
  aew(UtilsMbInfoActivity paramUtilsMbInfoActivity)
  {
    super(paramUtilsMbInfoActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.dismissDialog();
    e.c("utils mbinfo: " + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.mIsIniting = false;
    if (paramMessage.arg1 == 0)
    {
      this.a.hideTip();
      return;
    }
    paramMessage = (d)paramMessage.obj;
    if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
      d.a(this.a.getResources(), paramMessage);
    }
    this.a.showTip(paramMessage.a, paramMessage.c, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aew
 * JD-Core Version:    0.7.0.1
 */