import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class abyi
  implements BusinessObserver
{
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, "checkApolloGameRedDot onReceive isSuccess:" + paramBoolean + ",ret:" + paramInt);
    }
    if (paramBoolean)
    {
      this.val$sp.edit().putLong("apollo_game_reddot_checkTime", System.currentTimeMillis()).commit();
      ThreadManager.post(new ApolloGameUtil.2.1(this, paramBundle), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abyi
 * JD-Core Version:    0.7.0.1
 */