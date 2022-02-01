import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class rpk
{
  public static void aC(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
    } while (paramQQAppInterface == null);
    if (QLog.isColorLevel()) {
      QLog.d("StoryAIOUtils", 2, "refreshAIOStoryMessages");
    }
    paramQQAppInterface.removeMessages(267387141);
    paramQQAppInterface.sendMessageDelayed(paramQQAppInterface.obtainMessage(267387141), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rpk
 * JD-Core Version:    0.7.0.1
 */