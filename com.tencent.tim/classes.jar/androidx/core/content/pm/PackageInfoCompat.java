package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;

public final class PackageInfoCompat
{
  public static long getLongVersionCode(@NonNull PackageInfo paramPackageInfo)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramPackageInfo.getLongVersionCode();
    }
    return paramPackageInfo.versionCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.content.pm.PackageInfoCompat
 * JD-Core Version:    0.7.0.1
 */