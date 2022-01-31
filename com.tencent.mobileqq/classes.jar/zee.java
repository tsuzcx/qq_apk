import android.util.Pair;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Calendar;
import java.util.List;
import mqq.os.MqqHandler;

public class zee
  implements Runnable
{
  public zee(MessageRoamManager paramMessageRoamManager, int paramInt) {}
  
  public void run()
  {
    Object localObject = Calendar.getInstance();
    int j = this.jdField_a_of_type_Int;
    int i = 8;
    while (j < this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.jdField_a_of_type_JavaUtilList.size())
    {
      ((Calendar)localObject).setTimeInMillis(((Long)this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.jdField_a_of_type_JavaUtilList.get(j)).longValue());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a((Calendar)localObject);
      Pair localPair = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a((Calendar)((Calendar)localObject).clone());
      int k = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.jdField_a_of_type_JavaLangString, ((Long)localPair.first).longValue(), ((Long)localPair.second).longValue());
      if (i - k <= 0) {
        break;
      }
      j += 1;
      i -= k;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatHistoryForC2C.class);
    ((MqqHandler)localObject).sendMessageDelayed(((MqqHandler)localObject).obtainMessage(0), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zee
 * JD-Core Version:    0.7.0.1
 */