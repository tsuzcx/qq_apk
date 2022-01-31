import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public final class abz
  implements Runnable
{
  public abz(String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ChatBackgroundSettingActivity.j = ChatBackgroundSettingActivity.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString);
    Message localMessage = ChatBackgroundSettingActivity.a.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface };
    if (QLog.isColorLevel())
    {
      QLog.d("ThemeDownloadTrace", 2, "bgin to report chat bg info");
      QLog.d("ThemeDownloadTrace", 2, "initCurrChatBgNameForReport is:" + ChatBackgroundSettingActivity.j);
    }
    ChatBackgroundSettingActivity.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     abz
 * JD-Core Version:    0.7.0.1
 */