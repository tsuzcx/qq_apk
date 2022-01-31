package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;

class WtloginHelper$HelperThread$14
  implements Runnable
{
  WtloginHelper$HelperThread$14(WtloginHelper.HelperThread paramHelperThread, int paramInt) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$500(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    WtloginHelper.access$100(this.this$1.mHelper).OnException(new ErrMsg(), this.this$1.mReqType, this.this$1.mUserSigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.14
 * JD-Core Version:    0.7.0.1
 */