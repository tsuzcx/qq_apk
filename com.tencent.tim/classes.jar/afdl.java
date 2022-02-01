import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class afdl
{
  public static boolean aq(QQAppInterface paramQQAppInterface)
  {
    boolean bool = afdk.Q(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    if (!bool) {
      ((CardHandler)paramQQAppInterface.getBusinessHandler(2)).cHL();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocUtils", 1, "WL_DEBUG updateTencentDocUser isUser = " + bool);
    }
    return bool;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    paramBoolean = localBaseApplication.getSharedPreferences("call_tim_config_pre" + paramQQAppInterface, 0).getBoolean("call_tim_config_switch", false);
    paramQQAppInterface = aeuw.a().uh();
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocUtils", 2, "WL_DEBUG showInQQSettingMe enable = " + paramBoolean + ", isUser = " + false + ", userConfigMeURL = " + paramQQAppInterface);
    }
    return (!paramBoolean) && (paramBoolean);
  }
  
  public static void iF(String paramString)
  {
    QLog.d("TencentDocUtils", 1, "WL_DEBUG reportClickEvent actionName = " + paramString);
    anot.a(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afdl
 * JD-Core Version:    0.7.0.1
 */