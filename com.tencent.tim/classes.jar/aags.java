import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class aags
  implements WtTicketPromise
{
  aags(aagm paramaagm, aagm.a parama) {}
  
  public void Done(Ticket paramTicket)
  {
    if ((paramTicket != null) && (paramTicket._sig != null) && (paramTicket._sig.length != 0))
    {
      paramTicket = new String(paramTicket._sig);
      this.a.zP(paramTicket);
      return;
    }
    this.this$0.onError("get skey is null");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    this.this$0.onError("get skey failed");
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    this.this$0.onError("get skey time out");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aags
 * JD-Core Version:    0.7.0.1
 */