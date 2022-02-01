import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public final class arbe
  implements WtTicketPromise
{
  public arbe(String paramString, long paramLong) {}
  
  public void Done(Ticket paramTicket)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("pt4_token response received for ").append(this.val$domain).append(", cost=").append(System.currentTimeMillis() - this.val$begin);
      if (paramTicket == null) {
        break label64;
      }
    }
    label64:
    for (paramTicket = "";; paramTicket = ". But result was null!")
    {
      QLog.d("SwiftBrowserCookieMonster", 2, paramTicket);
      return;
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SwiftBrowserCookieMonster", 2, "Get pt4_token failed for " + this.val$domain + " because " + paramErrMsg + ", cost=" + (System.currentTimeMillis() - this.val$begin));
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SwiftBrowserCookieMonster", 2, "Get pt4_token timeout for " + this.val$domain + " because " + paramErrMsg + ", cost=" + (System.currentTimeMillis() - this.val$begin));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arbe
 * JD-Core Version:    0.7.0.1
 */