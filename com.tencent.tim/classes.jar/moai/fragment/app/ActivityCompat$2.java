package moai.fragment.app;

import android.app.Activity;
import android.content.pm.PackageManager;

final class ActivityCompat$2
  implements Runnable
{
  ActivityCompat$2(String[] paramArrayOfString, Activity paramActivity, int paramInt) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[this.val$permissions.length];
    PackageManager localPackageManager = this.val$activity.getPackageManager();
    String str = this.val$activity.getPackageName();
    int j = this.val$permissions.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = localPackageManager.checkPermission(this.val$permissions[i], str);
      i += 1;
    }
    ((ActivityCompat.OnRequestPermissionsResultCallback)this.val$activity).onRequestPermissionsResult(this.val$requestCode, this.val$permissions, arrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.ActivityCompat.2
 * JD-Core Version:    0.7.0.1
 */