package android.support.v4.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.support.annotation.RequiresApi;
import android.view.Display;

@RequiresApi(17)
class DisplayManagerCompat$DisplayManagerCompatApi17Impl
  extends DisplayManagerCompat
{
  private final DisplayManager mDisplayManager;
  
  DisplayManagerCompat$DisplayManagerCompatApi17Impl(Context paramContext)
  {
    this.mDisplayManager = ((DisplayManager)paramContext.getSystemService("display"));
  }
  
  public Display getDisplay(int paramInt)
  {
    return this.mDisplayManager.getDisplay(paramInt);
  }
  
  public Display[] getDisplays()
  {
    return this.mDisplayManager.getDisplays();
  }
  
  public Display[] getDisplays(String paramString)
  {
    return this.mDisplayManager.getDisplays(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.hardware.display.DisplayManagerCompat.DisplayManagerCompatApi17Impl
 * JD-Core Version:    0.7.0.1
 */