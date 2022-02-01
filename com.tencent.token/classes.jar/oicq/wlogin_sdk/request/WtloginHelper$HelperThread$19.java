package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

class WtloginHelper$HelperThread$19
  implements Runnable
{
  WtloginHelper$HelperThread$19(WtloginHelper.HelperThread paramHelperThread, int paramInt) {}
  
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
    WtloginHelper.access$200(this.this$1.mHelper).OnException(new ErrMsg(), this.this$1.mReqType, this.this$1.mUserSigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.19
 * JD-Core Version:    0.7.0.1
 */