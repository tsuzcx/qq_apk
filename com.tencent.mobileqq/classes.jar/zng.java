import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class zng
  implements Runnable
{
  public zng(MayknowRecommendManager paramMayknowRecommendManager) {}
  
  public void run()
  {
    if (Math.abs(MayknowRecommendManager.a(this.a).getLong("sp_get_mayknow_timestamp", 0L) - System.currentTimeMillis()) >= 86400000L)
    {
      ((FriendListHandler)MayknowRecommendManager.a(this.a).a(1)).a((short)MayknowRecommendManager.b());
      MayknowRecommendManager.a(this.a).edit().putLong("sp_get_mayknow_timestamp", System.currentTimeMillis()).commit();
      QLog.d("MayknowRecommendManager", 1, "getMayKnowRecommendRemote, >24hour, update timestamp");
      return;
    }
    QLog.d("MayknowRecommendManager", 1, "getMayKnowRecommendRemote, <24hour, return");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zng
 * JD-Core Version:    0.7.0.1
 */