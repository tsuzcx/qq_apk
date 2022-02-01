package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import android.view.accessibility.AccessibilityNodeInfo.RangeInfo;

class AccessibilityNodeInfoCompatKitKat
{
  static Object getCollectionInfo(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getCollectionInfo();
  }
  
  static Object getCollectionItemInfo(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getCollectionItemInfo();
  }
  
  static int getLiveRegion(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getLiveRegion();
  }
  
  static Object getRangeInfo(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getRangeInfo();
  }
  
  public static Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    return AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean);
  }
  
  public static Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    return AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
  }
  
  public static void setCollectionInfo(Object paramObject1, Object paramObject2)
  {
    ((AccessibilityNodeInfo)paramObject1).setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)paramObject2);
  }
  
  public static void setCollectionItemInfo(Object paramObject1, Object paramObject2)
  {
    ((AccessibilityNodeInfo)paramObject1).setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo)paramObject2);
  }
  
  static void setLiveRegion(Object paramObject, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setLiveRegion(paramInt);
  }
  
  static class CollectionInfo
  {
    static int getColumnCount(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionInfo)paramObject).getColumnCount();
    }
    
    static int getRowCount(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionInfo)paramObject).getRowCount();
    }
    
    static boolean isHierarchical(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionInfo)paramObject).isHierarchical();
    }
  }
  
  static class CollectionItemInfo
  {
    static int getColumnIndex(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionItemInfo)paramObject).getColumnIndex();
    }
    
    static int getColumnSpan(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionItemInfo)paramObject).getColumnSpan();
    }
    
    static int getRowIndex(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionItemInfo)paramObject).getRowIndex();
    }
    
    static int getRowSpan(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionItemInfo)paramObject).getRowSpan();
    }
    
    static boolean isHeading(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionItemInfo)paramObject).isHeading();
    }
  }
  
  static class RangeInfo
  {
    static float getCurrent(Object paramObject)
    {
      return ((AccessibilityNodeInfo.RangeInfo)paramObject).getCurrent();
    }
    
    static float getMax(Object paramObject)
    {
      return ((AccessibilityNodeInfo.RangeInfo)paramObject).getMax();
    }
    
    static float getMin(Object paramObject)
    {
      return ((AccessibilityNodeInfo.RangeInfo)paramObject).getMin();
    }
    
    static int getType(Object paramObject)
    {
      return ((AccessibilityNodeInfo.RangeInfo)paramObject).getType();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat
 * JD-Core Version:    0.7.0.1
 */