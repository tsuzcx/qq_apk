package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.util;

class WtloginHelper$HelperThread$9
  implements Runnable
{
  WtloginHelper$HelperThread$9(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$600(this.this$1);
    StringBuilder localStringBuilder = new StringBuilder("RequestTransport handler:ret=");
    localStringBuilder.append(this.val$ret);
    localStringBuilder.append("subCmd=");
    localStringBuilder.append(this.this$1.mReqContext._subcmd);
    localStringBuilder.append("cancel=");
    localStringBuilder.append(this.val$cancel);
    util.LOGI(localStringBuilder.toString(), this.this$1.mUserAccount);
    if (this.val$cancel != 0) {
      return;
    }
    if (this.this$1.mReqContext.is_register_req())
    {
      WtloginHelper.access$1800(this.this$1.mHelper, this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mRole, this.this$1.mReqContext, this.this$1.mUserSigInfo, this.val$ret);
      return;
    }
    if (this.this$1.mReqContext.is_code2d_func_req())
    {
      WtloginHelper.access$1900(this.this$1.mHelper, this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mRole, this.this$1.mReqContext, this.this$1.mUserSigInfo, this.val$ret);
      return;
    }
    if (this.this$1.mReqContext.is_devlock_req())
    {
      WtloginHelper.access$2000(this.this$1.mHelper, this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mRole, this.this$1.mReqContext, this.this$1.mUserSigInfo, this.val$ret);
      return;
    }
    WtloginHelper.access$200(this.this$1.mHelper).OnRequestTransport(this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mRole, this.this$1.mReqContext, this.this$1.mUserSigInfo, this.val$ret);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.9
 * JD-Core Version:    0.7.0.1
 */