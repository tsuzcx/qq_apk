import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.activity.specialcare.SpecialCareUtils.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class abby
{
  public static void bP(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new SpecialCareUtils.1(paramQQAppInterface), 1000L);
  }
  
  public static void m(Activity paramActivity, String paramString, int paramInt)
  {
    if ((paramInt == 3) && (ahfg.a().ane())) {}
    Intent localIntent = new Intent(paramActivity, QQSpecialCareSettingActivity.class);
    localIntent.putExtra("key_friend_uin", paramString);
    localIntent.putExtra("key_start_from", 3);
    paramActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abby
 * JD-Core Version:    0.7.0.1
 */