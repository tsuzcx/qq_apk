import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgDBHelper;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public final class xlb
  implements Runnable
{
  public xlb(boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    do
    {
      synchronized (NotifyMsgManager.jdField_a_of_type_JavaLangObject)
      {
        if (NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper == null) {
          NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper = new NotifyMsgDBHelper(BaseApplicationImpl.getContext());
        }
        ??? = QWalletTools.a();
        if (??? == null) {
          return;
        }
      }
    } while (NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper == null);
    if (this.jdField_a_of_type_Boolean)
    {
      NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper.b(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper.c(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xlb
 * JD-Core Version:    0.7.0.1
 */