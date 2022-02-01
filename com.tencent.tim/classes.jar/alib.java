import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class alib
{
  public static boolean br(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (!BaseApplicationImpl.sApplication.getSharedPreferences("LsRecord_" + paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("UserGuide", false)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean bs(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (Math.abs(System.currentTimeMillis() - BaseApplicationImpl.sApplication.getSharedPreferences("LsRecord_" + paramQQAppInterface.getCurrentAccountUin(), 0).getLong("UserTips", 0L)) >= 3600000L) {
      bool = true;
    }
    return bool;
  }
  
  public static void dH(QQAppInterface paramQQAppInterface)
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("LsRecord_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("UserGuide", true).commit();
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "markUserGuideFlag");
    }
  }
  
  public static void dI(QQAppInterface paramQQAppInterface)
  {
    long l = System.currentTimeMillis();
    BaseApplicationImpl.sApplication.getSharedPreferences("LsRecord_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().putLong("UserTips", l);
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "markUserTipsFlag:" + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alib
 * JD-Core Version:    0.7.0.1
 */