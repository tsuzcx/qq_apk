package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.b.bp;
import oicq.wlogin_sdk.tools.ErrMsg;

class WtloginHelper$HelperThread$4
  implements Runnable
{
  WtloginHelper$HelperThread$4(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$500(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    k localk = y.b(this.this$1.mUserSigInfo._seqence);
    ErrMsg localErrMsg = localk.k;
    int i = localk.w.f();
    int j = localk.w.g();
    WtloginHelper.access$100(this.this$1.mHelper).OnRefreshSMSData(this.this$1.mUserAccount, this.this$1.mSmsAppid, this.this$1.mUserSigInfo, i, j, this.val$ret, localErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.4
 * JD-Core Version:    0.7.0.1
 */