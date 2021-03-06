import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

final class avos
  implements WtTicketPromise
{
  avos(avor.a parama, String paramString) {}
  
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletUtils", 2, "get pskey async success!");
    }
    if (this.a != null) {
      this.a.ansyBack(0, new String[] { avor.a(paramTicket, this.val$domain) });
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletUtils", 2, "preGetKey. PSk Failed!!!");
    }
    if (this.a != null) {
      this.a.ansyBack(-1, new String[] { paramErrMsg.getMessage() });
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletUtils", 2, "preGetKey. PSk Timeout!");
    }
    if (this.a != null) {
      this.a.ansyBack(-1, new String[] { paramErrMsg.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avos
 * JD-Core Version:    0.7.0.1
 */