package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public class AccessibilityNodeInfoCompat$CollectionItemInfoCompat
{
  final Object mInfo;
  
  AccessibilityNodeInfoCompat$CollectionItemInfoCompat(Object paramObject)
  {
    this.mInfo = paramObject;
  }
  
  public static CollectionItemInfoCompat obtain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean));
    }
    return new CollectionItemInfoCompat(null);
  }
  
  public static CollectionItemInfoCompat obtain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2));
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1));
    }
    return new CollectionItemInfoCompat(null);
  }
  
  public int getColumnIndex()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).getColumnIndex();
    }
    return 0;
  }
  
  public int getColumnSpan()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).getColumnSpan();
    }
    return 0;
  }
  
  public int getRowIndex()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).getRowIndex();
    }
    return 0;
  }
  
  public int getRowSpan()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).getRowSpan();
    }
    return 0;
  }
  
  public boolean isHeading()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).isHeading();
    }
    return false;
  }
  
  public boolean isSelected()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).isSelected();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat
 * JD-Core Version:    0.7.0.1
 */