import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public final class cat
  implements Runnable
{
  public cat(String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = ChatBackgroundSettingActivity.a();
    ChatBackgroundSettingActivity.c = ChatBackgroundSettingActivity.a(BaseApplication.getContext(), (List)localObject, this.jdField_a_of_type_JavaLangString);
    localObject = ChatBackgroundSettingActivity.a.obtainMessage();
    ((Message)localObject).what = 1;
    ((Message)localObject).obj = new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface };
    if (QLog.isColorLevel())
    {
      QLog.d("ThemeDownloadTrace", 2, "bgin to report chat bg info");
      QLog.d("ThemeDownloadTrace", 2, "initCurrChatBgNameForReport is:" + ChatBackgroundSettingActivity.c);
    }
    ChatBackgroundSettingActivity.a.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cat
 * JD-Core Version:    0.7.0.1
 */