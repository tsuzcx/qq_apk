import android.app.Activity;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class ull
  implements Runnable
{
  public ull(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, MqqHandler paramMqqHandler) {}
  
  public void run()
  {
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.d);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardUtils", 2, "[@]call instantUpdate start!");
    }
    Message localMessage = new Message();
    localMessage.what = 57;
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardUtils", 2, "[@]call instantUpdate end!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ull
 * JD-Core Version:    0.7.0.1
 */