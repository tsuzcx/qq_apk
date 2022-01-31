package android.support.v4.hardware.display;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

class DisplayManagerCompat$DisplayManagerCompatApi14Impl
  extends DisplayManagerCompat
{
  private final WindowManager mWindowManager;
  
  DisplayManagerCompat$DisplayManagerCompatApi14Impl(Context paramContext)
  {
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  public Display getDisplay(int paramInt)
  {
    Display localDisplay = this.mWindowManager.getDefaultDisplay();
    if (localDisplay.getDisplayId() == paramInt) {
      return localDisplay;
    }
    return null;
  }
  
  public Display[] getDisplays()
  {
    return new Display[] { this.mWindowManager.getDefaultDisplay() };
  }
  
  public Display[] getDisplays(String paramString)
  {
    if (paramString == null) {
      return getDisplays();
    }
    return new Display[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.hardware.display.DisplayManagerCompat.DisplayManagerCompatApi14Impl
 * JD-Core Version:    0.7.0.1
 */