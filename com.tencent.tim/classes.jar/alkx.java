import android.annotation.SuppressLint;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class alkx
{
  @SuppressLint({"NewApi"})
  public static List<PackageInfo> a(PackageManager paramPackageManager, int paramInt)
  {
    Throwable localThrowable = new Throwable();
    QLog.e("InstallAppListMonitor", 1, "[getInstalledPackages] invoke, ", localThrowable);
    allb.h("installed_app_package", "getInstalledPackages", localThrowable);
    return paramPackageManager.getInstalledPackages(paramInt);
  }
  
  @SuppressLint({"NewApi"})
  public static List<ApplicationInfo> b(PackageManager paramPackageManager, int paramInt)
  {
    Throwable localThrowable = new Throwable();
    QLog.e("InstallAppListMonitor", 1, "[getInstalledApplications] invoke, ", localThrowable);
    allb.h("installed_app_package", "getInstalledApplications", localThrowable);
    return paramPackageManager.getInstalledApplications(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alkx
 * JD-Core Version:    0.7.0.1
 */