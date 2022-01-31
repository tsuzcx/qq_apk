package com.tencent.token.ui;

import android.os.Message;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class adl
  extends cb
{
  adl(UtilsMbInfoActivity paramUtilsMbInfoActivity)
  {
    super(paramUtilsMbInfoActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.dismissDialog();
    h.c("utils mbinfo: " + paramMessage.what);
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
    paramMessage = (f)paramMessage.obj;
    if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
      f.a(this.a.getResources(), paramMessage);
    }
    this.a.showTip(paramMessage.a, paramMessage.c, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adl
 * JD-Core Version:    0.7.0.1
 */