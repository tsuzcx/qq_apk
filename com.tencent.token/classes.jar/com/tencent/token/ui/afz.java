package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import oicq.wlogin_sdk.tools.util;

class afz
  implements Runnable
{
  afz(WtLoginAccountInput paramWtLoginAccountInput) {}
  
  public void run()
  {
    h.a("mQuickLoginIntenData" + WtLoginAccountInput.access$1300(this.a));
    if (WtLoginAccountInput.access$1300(this.a) == null)
    {
      util.LOGI("用户异常返回");
      h.a("mQuickLoginIntenData_null");
      localMessage = WtLoginAccountInput.access$500(this.a).obtainMessage(4108);
      localMessage.arg1 = 5001;
      localMessage.obj = "";
      localMessage.sendToTarget();
    }
    while ((RqdApplication.b) || (!WtLoginAccountInput.access$300(this.a)))
    {
      Message localMessage;
      return;
    }
    WtLoginAccountInput.access$400(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afz
 * JD-Core Version:    0.7.0.1
 */