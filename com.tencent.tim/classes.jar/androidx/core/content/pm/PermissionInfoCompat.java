package androidx.core.content.pm;

import android.annotation.SuppressLint;
import android.content.pm.PermissionInfo;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PermissionInfoCompat
{
  @SuppressLint({"WrongConstant"})
  public static int getProtection(@NonNull PermissionInfo paramPermissionInfo)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramPermissionInfo.getProtection();
    }
    return paramPermissionInfo.protectionLevel & 0xF;
  }
  
  @SuppressLint({"WrongConstant"})
  public static int getProtectionFlags(@NonNull PermissionInfo paramPermissionInfo)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramPermissionInfo.getProtectionFlags();
    }
    return paramPermissionInfo.protectionLevel & 0xFFFFFFF0;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static @interface Protection {}
  
  @Retention(RetentionPolicy.SOURCE)
  @SuppressLint({"UniqueConstants"})
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static @interface ProtectionFlags {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.content.pm.PermissionInfoCompat
 * JD-Core Version:    0.7.0.1
 */