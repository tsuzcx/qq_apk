import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class caw
  extends Handler
{
  public caw() {}
  
  public caw(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject = (Object[])paramMessage.obj;
    if (i == 1)
    {
      if (ChatBackgroundSettingActivity.c < 3)
      {
        paramMessage = (String)localObject[0];
        localObject = (QQAppInterface)localObject[1];
        ChatBackgroundSettingActivity.a((QQAppInterface)localObject, paramMessage, StatisticCollector.a(BaseApplication.getContext()));
        ChatBackgroundSettingActivity.c += 1;
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloadTrace", 2, "reportTimes is:" + ChatBackgroundSettingActivity.c);
        }
        Message localMessage = ChatBackgroundSettingActivity.a.obtainMessage();
        localMessage.what = 1;
        localMessage.obj = new Object[] { paramMessage, localObject };
        ChatBackgroundSettingActivity.a.sendMessageDelayed(localMessage, 120000L);
      }
    }
    else {
      return;
    }
    ChatBackgroundSettingActivity.c = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     caw
 * JD-Core Version:    0.7.0.1
 */