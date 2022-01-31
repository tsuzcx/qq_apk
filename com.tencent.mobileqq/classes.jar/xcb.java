import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;

public final class xcb
  implements Runnable
{
  public xcb(MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = QWalletTools.a();
    if ((localQQAppInterface != null) && (this.a != null)) {
      localQQAppInterface.a().a(this.a.frienduin, this.a.istroop, this.a.uniseq, "extStr", this.a.extStr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcb
 * JD-Core Version:    0.7.0.1
 */