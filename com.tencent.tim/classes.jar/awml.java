import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class awml
{
  private static awml a;
  private boolean dqV = BaseApplicationImpl.getApplication().getSharedPreferences("PackageUpdateManager", 4).getBoolean("HAS_PULL", false);
  private boolean dqW;
  private int mLaunchMode;
  
  private int Qp()
  {
    if (this.dqW) {
      return this.mLaunchMode;
    }
    this.dqW = true;
    long l = getPackageFirstInstallTime(BaseApplicationImpl.getApplication());
    if (getPackageLastUpdateTime(BaseApplicationImpl.getApplication()) > l) {}
    for (this.mLaunchMode = 1;; this.mLaunchMode = 0) {
      return this.mLaunchMode;
    }
  }
  
  public static awml a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new awml();
      }
      return a;
    }
    finally {}
  }
  
  private void eEu()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("PackageUpdateManager", 4).edit();
    localEditor.putBoolean("HAS_PULL", this.dqV);
    localEditor.apply();
  }
  
  public static long getPackageFirstInstallTime(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      long l = paramContext.getPackageManager().getPackageInfo(str, 0).firstInstallTime;
      return l;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0L;
  }
  
  public static long getPackageLastUpdateTime(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      long l = paramContext.getPackageManager().getPackageInfo(str, 0).lastUpdateTime;
      return l;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0L;
  }
  
  public void eY(QQAppInterface paramQQAppInterface)
  {
    if (this.dqV) {
      QLog.d("PackageUpdateManager", 1, "checkUpgrade has pulll");
    }
    while (Qp() != 1) {
      return;
    }
    this.dqV = true;
    QLog.d("PackageUpdateManager", 1, "checkUpgrade need pull friendlist ");
    ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1)).EQ(true);
    eEu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awml
 * JD-Core Version:    0.7.0.1
 */