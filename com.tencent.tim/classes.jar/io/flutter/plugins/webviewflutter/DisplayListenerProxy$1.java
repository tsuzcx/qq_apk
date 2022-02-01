package io.flutter.plugins.webviewflutter;

import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;
import java.util.ArrayList;
import java.util.Iterator;

class DisplayListenerProxy$1
  implements DisplayManager.DisplayListener
{
  DisplayListenerProxy$1(DisplayListenerProxy paramDisplayListenerProxy, ArrayList paramArrayList, DisplayManager paramDisplayManager) {}
  
  public void onDisplayAdded(int paramInt)
  {
    Iterator localIterator = this.val$webViewListeners.iterator();
    while (localIterator.hasNext()) {
      ((DisplayManager.DisplayListener)localIterator.next()).onDisplayAdded(paramInt);
    }
  }
  
  public void onDisplayChanged(int paramInt)
  {
    if (this.val$displayManager.getDisplay(paramInt) == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.val$webViewListeners.iterator();
      while (localIterator.hasNext()) {
        ((DisplayManager.DisplayListener)localIterator.next()).onDisplayChanged(paramInt);
      }
    }
  }
  
  public void onDisplayRemoved(int paramInt)
  {
    Iterator localIterator = this.val$webViewListeners.iterator();
    while (localIterator.hasNext()) {
      ((DisplayManager.DisplayListener)localIterator.next()).onDisplayRemoved(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.DisplayListenerProxy.1
 * JD-Core Version:    0.7.0.1
 */