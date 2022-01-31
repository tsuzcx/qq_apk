package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityNodeInfoCompatKitKat
{
  public static int getLiveRegion(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getLiveRegion();
  }
  
  public static void setLiveRegion(Object paramObject, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setLiveRegion(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat
 * JD-Core Version:    0.7.0.1
 */