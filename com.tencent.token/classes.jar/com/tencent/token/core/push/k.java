package com.tencent.token.core.push;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.dm;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.base.DualMsgShowDialog;

class k
  extends Handler
{
  k(PushService paramPushService) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 3069: 
      do
      {
        do
        {
          return;
        } while ((paramMessage.arg1 != 0) || (dm.a().b() <= 0));
        h.b("push:getIsAppForeground" + BaseActivity.getIsAppForeground());
        if (!BaseActivity.getIsAppForeground()) {
          break;
        }
        h.c("isshowingverify" + RqdApplication.b);
      } while (RqdApplication.b);
      try
      {
        new DualMsgShowDialog(BaseActivity.sTopActivity, 2131362156, 0, false, 0L).show();
        return;
      }
      catch (Exception paramMessage)
      {
        return;
      }
      IndexActivity.setFromWhere(19);
      return;
    }
    paramMessage = (m)paramMessage.obj;
    PushService.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.k
 * JD-Core Version:    0.7.0.1
 */