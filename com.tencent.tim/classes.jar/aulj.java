import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamwork.ReSendCmd;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class aulj
  implements WtTicketPromise
{
  aulj(aulh paramaulh, TicketManager paramTicketManager, ReSendCmd paramReSendCmd) {}
  
  public void Done(Ticket paramTicket)
  {
    int i;
    if (paramTicket == null) {
      i = 1;
    }
    for (;;)
    {
      QLog.i("TeamWorkHandler", 1, "getSkeyFromServerAndRetry get skey from server : Done,result: " + i);
      paramTicket = this.jdField_a_of_type_MqqManagerTicketManager.getSkey(this.this$0.mApp.getCurrentAccountUin());
      if ((!TextUtils.isEmpty(paramTicket)) && (paramTicket.length() > 0))
      {
        aulh.b(this.this$0, 0);
        QLog.i("TeamWorkHandler", 1, "getSkeyFromServerAndRetry get skey from server success!");
      }
      aulh.a(this.this$0, this.jdField_a_of_type_ComTencentTimTeamworkReSendCmd);
      return;
      if ((paramTicket != null) && (paramTicket._sig == null)) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.i("TeamWorkHandler", 1, "getSkeyFromServerAndRetry get skey from server : Failed, " + paramErrMsg);
    aulh.a(this.this$0, this.jdField_a_of_type_ComTencentTimTeamworkReSendCmd);
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    QLog.i("TeamWorkHandler", 1, "getSkeyFromServerAndRetry get skey from server : Timeout, " + paramErrMsg);
    aulh.a(this.this$0, this.jdField_a_of_type_ComTencentTimTeamworkReSendCmd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aulj
 * JD-Core Version:    0.7.0.1
 */