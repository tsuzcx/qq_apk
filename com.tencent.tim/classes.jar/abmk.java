import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class abmk
{
  private static final SharedPreferences E = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_robot", 4);
  
  public static void Ci(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      E.edit().putLong(paramString, System.currentTimeMillis()).commit();
    }
  }
  
  public static boolean gM(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      long l = E.getLong(paramString, 0L);
      if (System.currentTimeMillis() - l < 86400000L)
      {
        QLog.i("CmGameTemp_RobotDataUtil", 1, "isRobotUin:" + paramString);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmk
 * JD-Core Version:    0.7.0.1
 */