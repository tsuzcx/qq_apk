import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aqvl
{
  public static long c(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("qq_vip_configs", 0);
    paramQQAppInterface = paramString + "_" + paramQQAppInterface.getCurrentAccountUin();
    paramLong = localSharedPreferences.getLong(paramQQAppInterface, paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("QVip.ConfigManager", 1, "get sp key:" + paramQQAppInterface + " value=" + paramLong);
    }
    return paramLong;
  }
  
  public static boolean d(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("qq_vip_configs", 0);
    paramQQAppInterface = paramString + "_" + paramQQAppInterface.getCurrentAccountUin();
    boolean bool = localSharedPreferences.edit().putLong(paramQQAppInterface, paramLong).commit();
    if (QLog.isColorLevel()) {
      QLog.d("QVip.ConfigManager", 1, "set sp key:" + paramQQAppInterface + " value=" + bool);
    }
    return bool;
  }
  
  public static int e(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("qq_vip_configs", 0);
    paramQQAppInterface = paramString + "_" + paramQQAppInterface.getCurrentAccountUin();
    paramInt = localSharedPreferences.getInt(paramQQAppInterface, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QVip.ConfigManager", 1, "get sp key:" + paramQQAppInterface + " value=" + paramInt);
    }
    return paramInt;
  }
  
  public static boolean e(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("qq_vip_configs", 0);
    paramQQAppInterface = paramString + "_" + paramQQAppInterface.getCurrentAccountUin();
    paramBoolean = localSharedPreferences.getBoolean(paramQQAppInterface, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("QVip.ConfigManager", 1, "get sp key:" + paramQQAppInterface + " value=" + paramBoolean);
    }
    return paramBoolean;
  }
  
  public static boolean f(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("qq_vip_configs", 0);
    paramQQAppInterface = paramString + "_" + paramQQAppInterface.getCurrentAccountUin();
    paramBoolean = localSharedPreferences.edit().putBoolean(paramQQAppInterface, paramBoolean).commit();
    if (QLog.isColorLevel()) {
      QLog.d("QVip.ConfigManager", 1, "set sp key:" + paramQQAppInterface + " value=" + paramBoolean);
    }
    return paramBoolean;
  }
  
  public static boolean h(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("qq_vip_configs", 0);
    paramQQAppInterface = paramString1 + "_" + paramQQAppInterface.getCurrentAccountUin();
    boolean bool = localSharedPreferences.edit().putString(paramQQAppInterface, paramString2).commit();
    if (QLog.isColorLevel()) {
      QLog.d("QVip.ConfigManager", 1, "set sp key:" + paramQQAppInterface + " value=" + paramString2);
    }
    return bool;
  }
  
  public static String t(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("qq_vip_configs", 0);
    paramQQAppInterface = paramString1 + "_" + paramQQAppInterface.getCurrentAccountUin();
    paramString1 = localSharedPreferences.getString(paramQQAppInterface, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("QVip.ConfigManager", 1, "get sp key:" + paramQQAppInterface + " value=" + paramString1);
    }
    return paramString1;
  }
  
  public static boolean x(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("qq_vip_configs", 0);
    paramQQAppInterface = paramString + "_" + paramQQAppInterface.getCurrentAccountUin();
    boolean bool = localSharedPreferences.edit().putInt(paramQQAppInterface, paramInt).commit();
    if (QLog.isColorLevel()) {
      QLog.d("QVip.ConfigManager", 1, "set sp key:" + paramQQAppInterface + " value=" + bool);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvl
 * JD-Core Version:    0.7.0.1
 */