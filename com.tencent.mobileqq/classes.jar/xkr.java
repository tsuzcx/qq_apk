import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgPayManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.app.AppRuntime;

public class xkr
  implements Runnable
{
  public xkr(GoldMsgPayManager paramGoldMsgPayManager, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)localAppRuntime).a().a(8022, true, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xkr
 * JD-Core Version:    0.7.0.1
 */