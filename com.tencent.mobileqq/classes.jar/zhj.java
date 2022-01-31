import android.util.Pair;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import java.util.Calendar;
import mqq.os.MqqHandler;

public class zhj
  implements Runnable
{
  public zhj(MessageRoamManager paramMessageRoamManager, Calendar paramCalendar) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a((Calendar)this.jdField_a_of_type_JavaUtilCalendar.clone());
    int i = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.jdField_a_of_type_JavaLangString, ((Long)((Pair)localObject).first).longValue(), ((Long)((Pair)localObject).second).longValue());
    if (i >= 8)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatHistoryForC2C.class);
      ((MqqHandler)localObject).sendMessageDelayed(((MqqHandler)localObject).obtainMessage(0), 0L);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.jdField_a_of_type_JavaLangString, (Calendar)this.jdField_a_of_type_JavaUtilCalendar.clone(), true, 8 - i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhj
 * JD-Core Version:    0.7.0.1
 */