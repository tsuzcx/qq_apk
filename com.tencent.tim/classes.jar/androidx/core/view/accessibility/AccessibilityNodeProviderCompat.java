package androidx.core.view.accessibility;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat
{
  public static final int HOST_VIEW_ID = -1;
  private final Object mProvider;
  
  public AccessibilityNodeProviderCompat()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.mProvider = new AccessibilityNodeProviderApi19(this);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.mProvider = new AccessibilityNodeProviderApi16(this);
      return;
    }
    this.mProvider = null;
  }
  
  public AccessibilityNodeProviderCompat(Object paramObject)
  {
    this.mProvider = paramObject;
  }
  
  @Nullable
  public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int paramInt)
  {
    return null;
  }
  
  @Nullable
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    return null;
  }
  
  @Nullable
  public AccessibilityNodeInfoCompat findFocus(int paramInt)
  {
    return null;
  }
  
  public Object getProvider()
  {
    return this.mProvider;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
  
  @RequiresApi(16)
  static class AccessibilityNodeProviderApi16
    extends AccessibilityNodeProvider
  {
    final AccessibilityNodeProviderCompat mCompat;
    
    AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat)
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
    
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramString, int paramInt)
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
  
  @RequiresApi(19)
  static class AccessibilityNodeProviderApi19
    extends AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi16
  {
    AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat)
    {
      super();
    }
    
    public AccessibilityNodeInfo findFocus(int paramInt)
    {
      AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = this.mCompat.findFocus(paramInt);
      if (localAccessibilityNodeInfoCompat == null) {
        return null;
      }
      return localAccessibilityNodeInfoCompat.unwrap();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityNodeProviderCompat
 * JD-Core Version:    0.7.0.1
 */