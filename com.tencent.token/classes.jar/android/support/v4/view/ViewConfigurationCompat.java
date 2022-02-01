package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public final class ViewConfigurationCompat
{
  private static final String TAG = "ViewConfigCompat";
  private static Method sGetScaledScrollFactorMethod;
  
  static
  {
    if (Build.VERSION.SDK_INT == 25) {}
    try
    {
      sGetScaledScrollFactorMethod = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
      return;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
  }
  
  private static float getLegacyScrollFactor(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    Method localMethod;
    if (Build.VERSION.SDK_INT >= 25)
    {
      localMethod = sGetScaledScrollFactorMethod;
      if (localMethod == null) {}
    }
    try
    {
      int i = ((Integer)localMethod.invoke(paramViewConfiguration, new Object[0])).intValue();
      return i;
    }
    catch (Exception paramViewConfiguration)
    {
      label35:
      break label35;
    }
    Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
    paramViewConfiguration = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(16842829, paramViewConfiguration, true)) {
      return paramViewConfiguration.getDimension(paramContext.getResources().getDisplayMetrics());
    }
    return 0.0F;
  }
  
  public static float getScaledHorizontalScrollFactor(@NonNull ViewConfiguration paramViewConfiguration, @NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramViewConfiguration.getScaledHorizontalScrollFactor();
    }
    return getLegacyScrollFactor(paramViewConfiguration, paramContext);
  }
  
  @Deprecated
  public static int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration)
  {
    return paramViewConfiguration.getScaledPagingTouchSlop();
  }
  
  public static float getScaledVerticalScrollFactor(@NonNull ViewConfiguration paramViewConfiguration, @NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramViewConfiguration.getScaledVerticalScrollFactor();
    }
    return getLegacyScrollFactor(paramViewConfiguration, paramContext);
  }
  
  @Deprecated
  public static boolean hasPermanentMenuKey(ViewConfiguration paramViewConfiguration)
  {
    return paramViewConfiguration.hasPermanentMenuKey();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewConfigurationCompat
 * JD-Core Version:    0.7.0.1
 */