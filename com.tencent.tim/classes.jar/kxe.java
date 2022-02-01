import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

final class kxe
  implements WtTicketPromise
{
  kxe(TicketManager paramTicketManager, QQAppInterface paramQQAppInterface) {}
  
  public void Done(Ticket paramTicket)
  {
    int j = 0;
    int i;
    if (paramTicket == null) {
      i = 1;
    }
    for (;;)
    {
      QLog.i(kxb.access$000(), 1, "getPskeyFromServerAndRetry get pskey from server : Done, result: " + i);
      kxb.access$102(this.a.getPskey(this.c.getCurrentAccountUin(), "m.tencent.com"));
      if ((!TextUtils.isEmpty(kxb.access$100())) && (kxb.access$100().length() > 0)) {
        QLog.i(kxb.access$000(), 1, "getPskeyFromServerAndRetry get pskey from server success!");
      }
      return;
      if ((paramTicket != null) && (paramTicket._pskey_map == null))
      {
        i = 2;
      }
      else
      {
        i = j;
        if (paramTicket != null)
        {
          i = j;
          if (paramTicket._pskey_map != null)
          {
            i = j;
            if (paramTicket._pskey_map.get("m.tencent.com") == null) {
              i = 3;
            }
          }
        }
      }
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.i(kxb.access$000(), 1, "getPskeyFromServerAndRetry get pskey from server : Failed, " + paramErrMsg);
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    QLog.i(kxb.access$000(), 1, "getPskeyFromServerAndRetry get pskey from server : Timeout, " + paramErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kxe
 * JD-Core Version:    0.7.0.1
 */