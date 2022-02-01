package oicq.wlogin_sdk.request;

import java.util.HashMap;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

class WtloginHelper$HelperThread$2
  implements Runnable
{
  WtloginHelper$HelperThread$2(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$500(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    async_context localasync_context = t.b(this.this$1.mUserSigInfo._seqence);
    ErrMsg localErrMsg = localasync_context._last_err_msg;
    if (WtloginHelper.access$100(this.this$1.mHelper) == null)
    {
      util.LOGW("login helper listener is null", this.this$1.mUserAccount);
      return;
    }
    if ((this.val$ret == 0) && (localasync_context.tlv528 != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("context from seq ");
      localStringBuilder.append(this.this$1.mUserSigInfo._seqence);
      localStringBuilder.append(" tlv528 length ");
      localStringBuilder.append(localasync_context.tlv528.get_data_len());
      util.LOGI(localStringBuilder.toString(), this.this$1.mUserAccount);
      this.this$1.mUserSigInfo.loginResultTLVMap.put(new Integer(1320), localasync_context.tlv528);
    }
    if (this.this$1.mDwSubAppidList == null)
    {
      if (this.this$1.mIsSmslogin)
      {
        WtloginHelper.access$100(this.this$1.mHelper).OnGetStViaSMSVerifyLogin(this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mDwMainSigMap, this.this$1.mDwSubDstAppid, this.this$1.mUserSigInfo, this.val$ret, localErrMsg);
        return;
      }
      WtloginHelper.access$100(this.this$1.mHelper).OnGetStWithPasswd(this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mDwMainSigMap, this.this$1.mDwSubDstAppid, this.this$1.mUserPasswd, this.this$1.mUserSigInfo, this.val$ret, localErrMsg);
      return;
    }
    if (this.this$1.mIsSmslogin)
    {
      WtloginHelper.access$100(this.this$1.mHelper).OnGetStViaSMSVerifyLogin(this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mDwMainSigMap, this.this$1.mDwSubDstAppid, this.this$1.mDwSubAppidList, this.this$1.mUserSigInfo, this.this$1.mST, this.val$ret, localErrMsg);
      return;
    }
    WtloginHelper.access$100(this.this$1.mHelper).OnGetStWithPasswd(this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mDwMainSigMap, this.this$1.mDwSubDstAppid, this.this$1.mDwSubAppidList, this.this$1.mUserPasswd, this.this$1.mUserSigInfo, this.this$1.mST, this.val$ret, localErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.2
 * JD-Core Version:    0.7.0.1
 */