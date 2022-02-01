import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqmz
{
  public static void h(Activity paramActivity, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("troopbar_share", 2, "notifySDKCanceled:" + paramLong);
    }
    ahkr.a(paramActivity, false, "shareToTroopBar", paramLong);
  }
  
  public static void j(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    anot.a(paramQQAppInterface, "P_CliOper", "Grp_share", "", "to_tribe", paramString1, 0, 0, paramString2, "1", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqmz
 * JD-Core Version:    0.7.0.1
 */