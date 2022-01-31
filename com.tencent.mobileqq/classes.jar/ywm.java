import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class ywm
  implements BusinessObserver
{
  public ywm(SharedPreferences paramSharedPreferences, AppInterface paramAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, "checkApolloGameRedDot onReceive isSuccess:" + paramBoolean + ",ret:" + paramInt);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("apollo_game_reddot_checkTime", System.currentTimeMillis()).commit();
      ThreadManager.post(new ywn(this, paramBundle), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ywm
 * JD-Core Version:    0.7.0.1
 */