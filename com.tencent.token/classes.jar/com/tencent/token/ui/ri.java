package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class ri
  extends bo
{
  ri(NetActiveVryMobileNoSmsActivity paramNetActiveVryMobileNoSmsActivity)
  {
    super(paramNetActiveVryMobileNoSmsActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing()))) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      e.c("unknown msg: " + paramMessage.what);
      return;
    case -100: 
      NetActiveVryMobileNoSmsActivity.access$100(this.a);
      return;
    case 100: 
      this.a.showProDialog(this.a, 2131361808, 2131361817, null);
      return;
    case 3031: 
      if (paramMessage.arg1 != 0)
      {
        paramMessage = (d)paramMessage.obj;
        e.c("err " + paramMessage.a);
        d.a(this.a.getResources(), paramMessage);
        e.c("get mobile code failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.mHandler.removeMessages(-100);
        if (124 == paramMessage.a)
        {
          NetActiveVryMobileNoSmsActivity.access$1400(this.a, paramMessage.c);
          return;
        }
        this.a.showUserDialog(2131361831, paramMessage.c, 2131361800, null);
        return;
      }
      this.a.setContentView(2130903148);
      NetActiveVryMobileNoSmsActivity.access$1500(this.a);
      return;
    case 3029: 
      if (paramMessage.arg1 == 0)
      {
        NetActiveVryMobileNoSmsActivity.access$1600(this.a);
        return;
      }
      paramMessage = (d)paramMessage.obj;
      e.c("err " + paramMessage.a);
      d.a(this.a.getResources(), paramMessage);
      e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      NetActiveVryMobileNoSmsActivity.access$1700(this.a, paramMessage.c);
      return;
    }
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      NetActiveVryMobileNoSmsActivity.access$1800(this.a);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    NetActiveVryMobileNoSmsActivity.access$1700(this.a, paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ri
 * JD-Core Version:    0.7.0.1
 */