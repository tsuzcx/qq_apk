import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class ahmv
  implements WtTicketPromise
{
  ahmv(ahmu paramahmu, String paramString) {}
  
  public void Done(Ticket paramTicket)
  {
    if (DeleteFaceFragment.a(this.a.a))
    {
      QLog.d("DeleteFaceFragment", 1, "GetSkey Done, activity is empty");
      return;
    }
    QLog.d("DeleteFaceFragment", 1, "GetSkey done");
    if ((paramTicket == null) || (paramTicket._sig == null))
    {
      QLog.e("DeleteFaceFragment", 1, "ticket is error");
      DeleteFaceFragment.a(this.a.a, this.a.a.getString(2131696286));
      return;
    }
    paramTicket = new String(paramTicket._sig);
    DeleteFaceFragment.a(this.a.a, this.val$account, paramTicket);
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.e("DeleteFaceFragment", 1, new Object[] { "getSkey Failed, ", paramErrMsg.getMessage() });
    DeleteFaceFragment.a(this.a.a, paramErrMsg.getMessage());
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    QLog.e("DeleteFaceFragment", 1, new Object[] { "getSkey timeout, ", paramErrMsg.getMessage() });
    DeleteFaceFragment.a(this.a.a, paramErrMsg.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmv
 * JD-Core Version:    0.7.0.1
 */