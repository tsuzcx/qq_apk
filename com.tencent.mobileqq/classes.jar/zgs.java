import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.qphone.base.util.QLog;

public class zgs
  implements Runnable
{
  public zgs(MessageHandler paramMessageHandler, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      ConfessMsgUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, false);
      ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.f(this.jdField_a_of_type_Boolean);
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
 * Qualified Name:     zgs
 * JD-Core Version:    0.7.0.1
 */