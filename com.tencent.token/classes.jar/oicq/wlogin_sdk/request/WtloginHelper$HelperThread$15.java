package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

class WtloginHelper$HelperThread$15
  implements Runnable
{
  WtloginHelper$HelperThread$15(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$500(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    if (WtloginHelper.access$100(this.this$1.mHelper) == null)
    {
      util.LOGW("login helper listener is null", this.this$1.mUserAccount);
      return;
    }
    ErrMsg localErrMsg = t.b(this.this$1.mUserSigInfo._seqence)._last_err_msg;
    WtloginHelper.access$100(this.this$1.mHelper).onQuickLogin(this.this$1.mUserAccount, this.this$1.quickLoginParam, this.val$ret, localErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.15
 * JD-Core Version:    0.7.0.1
 */