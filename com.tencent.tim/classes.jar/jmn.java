import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class jmn
  implements WtTicketPromise
{
  jmn(jml paramjml) {}
  
  public void Done(Ticket paramTicket)
  {
    jml.a(this.this$0, false);
    this.this$0.ayg();
  }
  
  public void Failed(ErrMsg paramErrMsg) {}
  
  public void Timeout(ErrMsg paramErrMsg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jmn
 * JD-Core Version:    0.7.0.1
 */