package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;

class WtloginHelper$1
  implements WtTicketPromise
{
  WtloginHelper$1(WtloginHelper paramWtloginHelper, String paramString, long paramLong, int paramInt, WtTicketPromise paramWtTicketPromise) {}
  
  public void Done(Ticket paramTicket)
  {
    paramTicket = this.this$0.GetLocalTicket(this.val$userAccount, this.val$appid, this.val$sigType);
    if (this.val$promise != null) {
      this.val$promise.Done(paramTicket);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.1
 * JD-Core Version:    0.7.0.1
 */