import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class vvv
{
  public static int a()
  {
    int i = -1;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt("qcircle_show_message_enter_guide_tips", -1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleHostConfig", 1, "isNeedShowMessageEntranceTips: " + i);
    }
    return i;
  }
  
  public static long a()
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("sp_last_getfollowuser_time", 0L);
    }
    return l;
  }
  
  public static SharedPreferences a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "sp_qqcirlce_business" + str;
    return BaseApplicationImpl.getApplication().getSharedPreferences(str, 0);
  }
  
  public static void a(long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("sp_last_getfollowuser_time", paramLong).apply();
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (!paramBoolean) {
        break label67;
      }
    }
    label67:
    for (int i = 1;; i = 0)
    {
      ((SharedPreferences.Editor)localObject).putInt("qcircle_show_message_enter_guide_tips", i).apply();
      if (QLog.isColorLevel()) {
        QLog.d("QCircleHostConfig", 1, "setShowMessageEntranceTips: " + paramBoolean);
      }
      return;
    }
  }
  
  public static long b()
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("qcircle_fule_count_push_time", 0L);
    }
    return l;
  }
  
  public static void b(long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("qcircle_fule_count_push_time", paramLong).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvv
 * JD-Core Version:    0.7.0.1
 */