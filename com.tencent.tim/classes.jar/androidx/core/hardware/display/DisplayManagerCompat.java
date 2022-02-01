package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

public final class DisplayManagerCompat
{
  public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
  private static final WeakHashMap<Context, DisplayManagerCompat> sInstances = new WeakHashMap();
  private final Context mContext;
  
  private DisplayManagerCompat(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  @NonNull
  public static DisplayManagerCompat getInstance(@NonNull Context paramContext)
  {
    synchronized (sInstances)
    {
      DisplayManagerCompat localDisplayManagerCompat2 = (DisplayManagerCompat)sInstances.get(paramContext);
      DisplayManagerCompat localDisplayManagerCompat1 = localDisplayManagerCompat2;
      if (localDisplayManagerCompat2 == null)
      {
        localDisplayManagerCompat1 = new DisplayManagerCompat(paramContext);
        sInstances.put(paramContext, localDisplayManagerCompat1);
      }
      return localDisplayManagerCompat1;
    }
  }
  
  @Nullable
  public Display getDisplay(int paramInt)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 17) {
      localObject = ((DisplayManager)this.mContext.getSystemService("display")).getDisplay(paramInt);
    }
    Display localDisplay;
    do
    {
      return localObject;
      localDisplay = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
      localObject = localDisplay;
    } while (localDisplay.getDisplayId() == paramInt);
    return null;
  }
  
  @NonNull
  public Display[] getDisplays()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return ((DisplayManager)this.mContext.getSystemService("display")).getDisplays();
    }
    return new Display[] { ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay() };
  }
  
  @NonNull
  public Display[] getDisplays(@Nullable String paramString)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return ((DisplayManager)this.mContext.getSystemService("display")).getDisplays(paramString);
    }
    if (paramString == null) {
      return new Display[0];
    }
    return new Display[] { ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay() };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.hardware.display.DisplayManagerCompat
 * JD-Core Version:    0.7.0.1
 */