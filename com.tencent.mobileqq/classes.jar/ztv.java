import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class ztv
  implements Runnable
{
  public ztv(QQMessageFacade paramQQMessageFacade, MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, this.jdField_a_of_type_Boolean);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.msg.QQMessageFacade", 1, "smr error :", localRuntimeException);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ztv
 * JD-Core Version:    0.7.0.1
 */