package oicq.wlogin_sdk.request;

import android.os.Bundle;
import oicq.wlogin_sdk.tools.ErrMsg;

class WtloginHelper$1
  implements WtTicketPromise
{
  WtloginHelper$1(WtloginHelper paramWtloginHelper, WtTicketPromise paramWtTicketPromise, String paramString, long paramLong, int paramInt, Bundle paramBundle) {}
  
  public void Done(Ticket paramTicket)
  {
    if (this.val$promise != null) {
      this.val$promise.Done(this.this$0.GetTicket(this.val$userAccount, this.val$appid, this.val$sigType, null, this.val$params));
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (this.val$promise != null) {
      this.val$promise.Failed(paramErrMsg);
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (this.val$promise != null) {
      this.val$promise.Timeout(paramErrMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.1
 * JD-Core Version:    0.7.0.1
 */