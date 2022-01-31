package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;

class WtloginHelper$HelperThread$12
  implements Runnable
{
  WtloginHelper$HelperThread$12(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$500(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    k localk = y.b(this.this$1.mUserSigInfo._seqence);
    ErrMsg localErrMsg = localk.k;
    WtloginHelper.access$100(this.this$1.mHelper).OnRefreshSMSVerifyLoginCode(this.this$1.mUserAccount, localk.y, localk.z, localk.A, this.this$1.mUserSigInfo, this.val$ret, localErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.12
 * JD-Core Version:    0.7.0.1
 */