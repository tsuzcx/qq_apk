package com.tencent.mobileqq.observer;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class QZoneObserver
  implements BusinessObserver
{
  public static final int a = 1000;
  public static final int b = 1001;
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1000) {
      a(paramBoolean, paramBundle.getBoolean("new"), paramBundle.getInt("notify_type", 0));
    }
    while (paramInt != 1001) {
      return;
    }
    a(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.observer.QZoneObserver
 * JD-Core Version:    0.7.0.1
 */