import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class aoas
  implements WtTicketPromise
{
  aoas(aoar paramaoar, Runnable paramRunnable) {}
  
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TeamWorkFileImportHandler", 2, "--- pskey invalid retry ---  ");
    }
    ThreadManager.executeOnNetWorkThread(this.hF);
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TeamWorkFileImportHandler", 2, "--- get pskey failed ---  " + paramErrMsg.getMessage());
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TeamWorkFileImportHandler", 2, "--- get pskey timeout ---  " + paramErrMsg.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aoas
 * JD-Core Version:    0.7.0.1
 */