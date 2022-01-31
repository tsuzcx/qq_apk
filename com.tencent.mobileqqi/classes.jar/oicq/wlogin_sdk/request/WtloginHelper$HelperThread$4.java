package oicq.wlogin_sdk.request;

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
    ErrMsg localErrMsg = t.b(this.this$1.mUserSigInfo._seqence)._last_err_msg;
    if (n.D)
    {
      if (this.this$1.mST == null)
      {
        WtloginHelper.access$100(this.this$1.mHelper).OnCheckWebsigAndGetSt(this.this$1.mUserAccount, this.this$1.mUserInput, this.this$1.mUserSigInfo, this.val$ret, localErrMsg);
        return;
      }
      WtloginHelper.access$100(this.this$1.mHelper).OnCheckWebsigAndGetSt(this.this$1.mUserAccount, this.this$1.mUserInput, this.this$1.mUserSigInfo, this.this$1.mST, this.val$ret, localErrMsg);
      return;
    }
    if (this.this$1.mST == null)
    {
      WtloginHelper.access$100(this.this$1.mHelper).OnCheckPictureAndGetSt(this.this$1.mUserAccount, this.this$1.mUserInput, this.this$1.mUserSigInfo, this.val$ret, localErrMsg);
      return;
    }
    WtloginHelper.access$100(this.this$1.mHelper).OnCheckPictureAndGetSt(this.this$1.mUserAccount, this.this$1.mUserInput, this.this$1.mUserSigInfo, this.this$1.mST, this.val$ret, localErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.4
 * JD-Core Version:    0.7.0.1
 */