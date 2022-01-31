import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.qphone.base.util.QLog;

public class wvk
  implements Runnable
{
  public wvk(MainAssistObserver paramMainAssistObserver, QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade) {}
  
  public void run()
  {
    int i = QCallFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b();
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "updateTab = " + i);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new wvl(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wvk
 * JD-Core Version:    0.7.0.1
 */