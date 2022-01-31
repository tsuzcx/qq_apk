import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.qphone.base.util.QLog;

public class znr
  implements Runnable
{
  public znr(MessageHandler paramMessageHandler, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      ConfessMsgUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, false);
      ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.e(this.jdField_a_of_type_Boolean);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.msg.MessageHandler", 1, "sendMsgReadedReportInAll error :", localRuntimeException);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     znr
 * JD-Core Version:    0.7.0.1
 */