import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.QQConfMeetingLogReportHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class zxc
  implements Runnable
{
  public zxc(QQConfMeetingLogReportHelper paramQQConfMeetingLogReportHelper, String paramString) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    Object localObject = ((QQAppInterface)QQConfMeetingLogReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsQQConfMeetingLogReportHelper).get()).getCurrentAccountUin();
    String str1 = "MSFSDK_LogReport" + (String)localObject;
    localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null)
    {
      TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject).getManager(2);
      String str2 = ((AppRuntime)localObject).getAccount();
      localObject = "";
      if (localTicketManager != null) {
        localObject = localTicketManager.getSkey(str2);
      }
      QLog.syncReportLogSelf(AppSetting.a, this.jdField_a_of_type_JavaLangString, str1, "", str2, (String)localObject);
    }
    long l2 = System.currentTimeMillis();
    QLog.w("QQConfMeetingLogReportHelper", 1, "sendFile, Runnable, path[" + this.jdField_a_of_type_JavaLangString + "], Thread[" + Thread.currentThread().getId() + "], cost[" + (l2 - l1) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zxc
 * JD-Core Version:    0.7.0.1
 */