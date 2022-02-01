import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class anof
{
  public static String TAG = "GeneralConfigUtils";
  static boolean cIS;
  private static int dKF = -1;
  
  public static boolean ayA()
  {
    if (dKF == -1) {
      if (BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("pic_thumb_400Enable", 0) == 1)
      {
        cIS = true;
        dKF = 1;
      }
    }
    for (;;)
    {
      return cIS;
      cIS = false;
      dKF = 0;
      continue;
      if (dKF == 1) {
        cIS = true;
      } else {
        cIS = false;
      }
    }
  }
  
  public static void hw(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      dKF = -1;
    }
    try
    {
      paramString2 = Integer.valueOf(paramString2);
      BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putInt(paramString1, paramString2.intValue()).commit();
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(TAG, 2, "parseConfig(): e = " + paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anof
 * JD-Core Version:    0.7.0.1
 */