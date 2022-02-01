package androidx.core.app;

import android.app.Service;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ServiceCompat
{
  public static final int START_STICKY = 1;
  public static final int STOP_FOREGROUND_DETACH = 2;
  public static final int STOP_FOREGROUND_REMOVE = 1;
  
  public static void stopForeground(@NonNull Service paramService, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramService.stopForeground(paramInt);
      return;
    }
    if ((paramInt & 0x1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramService.stopForeground(bool);
      return;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface StopForegroundFlags {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.app.ServiceCompat
 * JD-Core Version:    0.7.0.1
 */