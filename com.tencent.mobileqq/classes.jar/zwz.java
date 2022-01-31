import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import mqq.os.MqqHandler;

class zwz
  implements Runnable
{
  zwz(zwy paramzwy, long paramLong, int paramInt, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(this.jdField_a_of_type_Long * 1000L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg", 2, "fetchMoreRoamMessage begin fetchNum: " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Zwy.a.a(this.jdField_a_of_type_JavaLangString, (Calendar)localObject, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int)) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_Zwy.a.b.getHandler(ChatHistoryForC2C.class);
    } while (localObject == null);
    Message localMessage = ((MqqHandler)localObject).obtainMessage(0);
    localMessage.obj = Long.valueOf(this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Boolean) {
      i = 1;
    }
    localMessage.arg1 = i;
    ((MqqHandler)localObject).sendMessageDelayed(localMessage, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zwz
 * JD-Core Version:    0.7.0.1
 */