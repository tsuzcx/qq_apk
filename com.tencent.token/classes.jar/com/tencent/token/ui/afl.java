package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.protocolcenter.protocol.ProtoGeneralGetMobileCode;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class afl
  extends Handler
{
  afl(VryMobileForStrategyActivity paramVryMobileForStrategyActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing()))) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      h.c("unknown msg: " + paramMessage.what);
      return;
    case -100: 
      VryMobileForStrategyActivity.access$000(this.a);
      return;
    case 100: 
      this.a.showProDialog(this.a, 2131230843, 2131231298, null);
      return;
    case 3065: 
      if (paramMessage.arg1 != 0)
      {
        VryMobileForStrategyActivity.access$202(this.a, 0);
        paramMessage = (f)paramMessage.obj;
        h.c("err " + paramMessage.a);
        f.a(this.a.getResources(), paramMessage);
        h.c("get mobile code failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.mHandler.removeMessages(-100);
        if (124 == paramMessage.a)
        {
          VryMobileForStrategyActivity.access$700(this.a).mSmsPrefix = ProtoGeneralGetMobileCode.f;
          VryMobileForStrategyActivity.access$800(this.a, paramMessage.c);
          return;
        }
        this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
        return;
      }
      VryMobileForStrategyActivity.access$700(this.a).mSmsPrefix = ProtoGeneralGetMobileCode.f;
      VryMobileForStrategyActivity.access$902(this.a, true);
      this.a.setContentView(2130968704);
      this.a.setTitle(2131231620);
      VryMobileForStrategyActivity.access$1000(this.a);
      return;
    }
    if (paramMessage.arg1 == 0)
    {
      this.a.dismissDialog();
      com.tencent.token.global.RqdApplication.b = false;
      this.a.finish();
      return;
    }
    paramMessage = (f)paramMessage.obj;
    h.c("err " + paramMessage.a);
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    VryMobileForStrategyActivity.access$1100(this.a, paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afl
 * JD-Core Version:    0.7.0.1
 */