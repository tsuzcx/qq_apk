package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(16)
class AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi16
  extends AccessibilityNodeProvider
{
  final AccessibilityNodeProviderCompat mCompat;
  
  AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat)
  {
    this.mCompat = paramAccessibilityNodeProviderCompat;
  }
  
  public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = this.mCompat.createAccessibilityNodeInfo(paramInt);
    if (localAccessibilityNodeInfoCompat == null) {
      return null;
    }
    return localAccessibilityNodeInfoCompat.unwrap();
  }
  
  public List findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    paramString = this.mCompat.findAccessibilityNodeInfosByText(paramString, paramInt);
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramString.size();
    paramInt = 0;
    while (paramInt < i)
    {
      localArrayList.add(((AccessibilityNodeInfoCompat)paramString.get(paramInt)).unwrap());
      paramInt += 1;
    }
    return localArrayList;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return this.mCompat.performAction(paramInt1, paramInt2, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi16
 * JD-Core Version:    0.7.0.1
 */