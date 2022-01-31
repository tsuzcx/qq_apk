package android.support.v4.hardware.display;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import java.util.WeakHashMap;

public abstract class DisplayManagerCompat
{
  public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
  private static final WeakHashMap sInstances = new WeakHashMap();
  
  @NonNull
  public static DisplayManagerCompat getInstance(@NonNull Context paramContext)
  {
    synchronized (sInstances)
    {
      DisplayManagerCompat localDisplayManagerCompat = (DisplayManagerCompat)sInstances.get(paramContext);
      Object localObject = localDisplayManagerCompat;
      if (localDisplayManagerCompat == null)
      {
        if (Build.VERSION.SDK_INT >= 17)
        {
          localObject = new DisplayManagerCompat.DisplayManagerCompatApi17Impl(paramContext);
          sInstances.put(paramContext, localObject);
        }
      }
      else {
        return localObject;
      }
      localObject = new DisplayManagerCompat.DisplayManagerCompatApi14Impl(paramContext);
    }
  }
  
  @Nullable
  public abstract Display getDisplay(int paramInt);
  
  @NonNull
  public abstract Display[] getDisplays();
  
  @NonNull
  public abstract Display[] getDisplays(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.hardware.display.DisplayManagerCompat
 * JD-Core Version:    0.7.0.1
 */