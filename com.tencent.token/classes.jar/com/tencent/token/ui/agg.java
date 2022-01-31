package com.tencent.token.ui;

import android.os.Message;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class agg
  extends bo
{
  agg(VerifyMobilePhoneActivity paramVerifyMobilePhoneActivity)
  {
    super(paramVerifyMobilePhoneActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    if (this.a.isFinishing()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      if (paramMessage.arg2 == 1) {}
      for (;;)
      {
        VerifyMobilePhoneActivity.access$200(this.a, bool);
        return;
        bool = false;
      }
    }
    if (paramMessage.arg1 == 160)
    {
      paramMessage = (d)paramMessage.obj;
      d.a(this.a.getResources(), paramMessage);
      this.a.showUserDialog(2131361808, paramMessage.c, 2131361866, 2131361868, new agh(this), new agi(this));
      return;
    }
    if (paramMessage.arg1 == 161)
    {
      paramMessage = (d)paramMessage.obj;
      d.a(this.a.getResources(), paramMessage);
      this.a.showUserDialog(2131361808, paramMessage.c, 2131361802, 2131361866, new agj(this), new agk(this));
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.agg
 * JD-Core Version:    0.7.0.1
 */