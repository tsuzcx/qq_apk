import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class adoa
  implements WtTicketPromise
{
  adoa(adnq.c paramc, TicketManager paramTicketManager, QQAppInterface paramQQAppInterface, String paramString, long paramLong) {}
  
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp", 2, "--- pskey async done---  ");
    }
    paramTicket = this.b.getPskey(this.val$appInterface.getCurrentAccountUin(), this.val$domain);
    adnq.c.a(this.this$0, this.Vc, true, paramTicket);
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.e("ArkApp", 1, "--- pskey async failed---  " + paramErrMsg.getMessage());
    adnq.c.a(this.this$0, this.Vc, false, null);
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    QLog.e("ArkApp", 1, "--- pskey async timeout---  " + paramErrMsg.getMessage());
    adnq.c.a(this.this$0, this.Vc, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adoa
 * JD-Core Version:    0.7.0.1
 */