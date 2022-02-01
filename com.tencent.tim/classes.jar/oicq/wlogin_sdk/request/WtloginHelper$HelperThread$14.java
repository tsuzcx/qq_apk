package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

class WtloginHelper$HelperThread$14
  implements Runnable
{
  WtloginHelper$HelperThread$14(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$600(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    if (WtloginHelper.access$200(this.this$1.mHelper) == null)
    {
      util.LOGW("login helper listener is null", this.this$1.mUserAccount);
      return;
    }
    async_context localasync_context = u.b(this.this$1.mUserSigInfo._seqence);
    ErrMsg localErrMsg = localasync_context._last_err_msg;
    WtloginHelper.HelperThread.access$700(this.this$1, localasync_context);
    WtloginHelper.HelperThread.access$800(this.this$1, localasync_context, this.val$ret);
    util.LOGI("onQuickLogin ret=" + this.val$ret, this.this$1.mUserAccount);
    WtloginHelper.access$200(this.this$1.mHelper).onQuickLogin(this.this$1.mUserAccount, this.this$1.quickLoginParam, this.val$ret, localErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.14
 * JD-Core Version:    0.7.0.1
 */