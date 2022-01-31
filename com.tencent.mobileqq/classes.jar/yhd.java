import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.game.ApolloGameConfig;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class yhd
  implements Runnable
{
  public yhd(ApolloManager paramApolloManager) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      long l = 0L;
      if (QLog.isColorLevel()) {
        l = System.currentTimeMillis();
      }
      ApolloManager.a(this.a.a.getApplication());
      ApolloManager.a(this.a);
      ApolloManager.b(this.a);
      FileUtils.c(ApolloConstant.a + "/.nomedia");
      ApolloActionManager.a();
      this.a.a(BaseApplicationImpl.getContext());
      this.a.h();
      if (ApolloManager.a(this.a) != null) {
        this.a.d(ApolloManager.a(this.a).apolloAISwitch);
      }
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_pet_sp", 0);
      this.a.k = localSharedPreferences.getString("pet_config", null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "init apollo data from db done cost: " + (System.currentTimeMillis() - l) + ", mApp: " + this.a.a);
      }
      ApolloManager.b = true;
      ApolloGameConfig.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yhd
 * JD-Core Version:    0.7.0.1
 */