package android.support.v4.content.res;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

public final class ConfigurationHelper
{
  public static int getDensityDpi(@NonNull Resources paramResources)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramResources.getConfiguration().densityDpi;
    }
    return paramResources.getDisplayMetrics().densityDpi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.content.res.ConfigurationHelper
 * JD-Core Version:    0.7.0.1
 */