package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.db;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class agv
  extends Handler
{
  agv(VryMobileForStrategyActivity paramVryMobileForStrategyActivity) {}
  
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
      VryMobileForStrategyActivity.access$100(this.a);
      return;
    case 100: 
      this.a.showProDialog(this.a, 2131361808, 2131361817, null);
      return;
    case 3065: 
      if (paramMessage.arg1 != 0)
      {
        VryMobileForStrategyActivity.access$502(this.a, 0);
        paramMessage = (d)paramMessage.obj;
        e.c("err " + paramMessage.a);
        d.a(this.a.getResources(), paramMessage);
        e.c("get mobile code failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.mHandler.removeMessages(-100);
        if (124 == paramMessage.a)
        {
          VryMobileForStrategyActivity.access$1100(this.a).mSmsPrefix = db.e;
          VryMobileForStrategyActivity.access$1200(this.a, paramMessage.c);
          return;
        }
        this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
        return;
      }
      VryMobileForStrategyActivity.access$1100(this.a).mSmsPrefix = db.e;
      VryMobileForStrategyActivity.access$1302(this.a, true);
      this.a.setContentView(2130903148);
      this.a.setTitle(2131362004);
      VryMobileForStrategyActivity.access$1400(this.a);
      return;
    }
    if (paramMessage.arg1 == 0)
    {
      this.a.dismissDialog();
      this.a.finish();
      return;
    }
    paramMessage = (d)paramMessage.obj;
    e.c("err " + paramMessage.a);
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    VryMobileForStrategyActivity.access$1500(this.a, paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.agv
 * JD-Core Version:    0.7.0.1
 */