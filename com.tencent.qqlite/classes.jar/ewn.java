import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.pathtracker.VipPathTracker;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager.ConfigType;

public class ewn
  implements Runnable
{
  public ewn(VipPathTracker paramVipPathTracker, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    String str = ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).a(ServerConfigManager.ConfigType.common, "PathTrack");
    VipPathTracker localVipPathTracker = this.jdField_a_of_type_ComTencentMobileqqUtilsPathtrackerVipPathTracker;
    if ((!TextUtils.isEmpty(str)) && (str.equals("0"))) {}
    for (boolean bool = true;; bool = false)
    {
      VipPathTracker.a(localVipPathTracker, Boolean.valueOf(bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ewn
 * JD-Core Version:    0.7.0.1
 */