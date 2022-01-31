import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.WaitRecord;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Iterator;

public final class xkz
  implements Runnable
{
  public xkz(ArrayList paramArrayList) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = QWalletTools.a();
    if (localQQAppInterface != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        NotifyMsgManager.WaitRecord localWaitRecord = (NotifyMsgManager.WaitRecord)localIterator.next();
        if ((localWaitRecord != null) && (localWaitRecord.a != null)) {
          localQQAppInterface.a().a(localWaitRecord.a.frienduin, localWaitRecord.a.istroop, localWaitRecord.a.uniseq, "extStr", localWaitRecord.a.extStr);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xkz
 * JD-Core Version:    0.7.0.1
 */