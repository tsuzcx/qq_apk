package com.facebook.stetho.common.android;

import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.Spinner;
import java.util.List;

public final class AccessibilityUtil
{
  public static boolean hasFocusableAncestor(@Nullable AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, @Nullable View paramView)
  {
    if ((paramAccessibilityNodeInfoCompat == null) || (paramView == null)) {
      return false;
    }
    paramView = ViewCompat.getParentForAccessibility(paramView);
    if (!(paramView instanceof View)) {
      return false;
    }
    paramAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
    try
    {
      ViewCompat.onInitializeAccessibilityNodeInfo((View)paramView, paramAccessibilityNodeInfoCompat);
      if (paramAccessibilityNodeInfoCompat == null) {
        return false;
      }
      boolean bool = isAccessibilityFocusable(paramAccessibilityNodeInfoCompat, (View)paramView);
      if (bool) {
        return true;
      }
      bool = hasFocusableAncestor(paramAccessibilityNodeInfoCompat, (View)paramView);
      return bool;
    }
    finally
    {
      paramAccessibilityNodeInfoCompat.recycle();
    }
  }
  
  public static boolean hasNonActionableSpeakingDescendants(@Nullable AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, @Nullable View paramView)
  {
    if ((paramAccessibilityNodeInfoCompat == null) || (paramView == null) || (!(paramView instanceof ViewGroup))) {
      return false;
    }
    paramView = (ViewGroup)paramView;
    int j = paramView.getChildCount();
    int i = 0;
    label29:
    View localView;
    if (i < j)
    {
      localView = paramView.getChildAt(i);
      if (localView != null) {
        break label53;
      }
    }
    for (;;)
    {
      i += 1;
      break label29;
      break;
      label53:
      paramAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
      try
      {
        ViewCompat.onInitializeAccessibilityNodeInfo(localView, paramAccessibilityNodeInfoCompat);
        boolean bool = isAccessibilityFocusable(paramAccessibilityNodeInfoCompat, localView);
        if (bool)
        {
          paramAccessibilityNodeInfoCompat.recycle();
          continue;
        }
        bool = isSpeakingNode(paramAccessibilityNodeInfoCompat, localView);
        if (bool) {
          return true;
        }
        paramAccessibilityNodeInfoCompat.recycle();
      }
      finally
      {
        paramAccessibilityNodeInfoCompat.recycle();
      }
    }
  }
  
  public static boolean hasText(@Nullable AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if (paramAccessibilityNodeInfoCompat == null) {}
    while ((TextUtils.isEmpty(paramAccessibilityNodeInfoCompat.getText())) && (TextUtils.isEmpty(paramAccessibilityNodeInfoCompat.getContentDescription()))) {
      return false;
    }
    return true;
  }
  
  public static boolean isAccessibilityFocusable(@Nullable AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, @Nullable View paramView)
  {
    boolean bool = true;
    if ((paramAccessibilityNodeInfoCompat == null) || (paramView == null)) {}
    while (!paramAccessibilityNodeInfoCompat.isVisibleToUser()) {
      return false;
    }
    if (isActionableForAccessibility(paramAccessibilityNodeInfoCompat)) {
      return true;
    }
    if ((isTopLevelScrollItem(paramAccessibilityNodeInfoCompat, paramView)) && (isSpeakingNode(paramAccessibilityNodeInfoCompat, paramView))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean isActionableForAccessibility(@Nullable AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if (paramAccessibilityNodeInfoCompat == null) {}
    do
    {
      return false;
      if ((paramAccessibilityNodeInfoCompat.isClickable()) || (paramAccessibilityNodeInfoCompat.isLongClickable()) || (paramAccessibilityNodeInfoCompat.isFocusable())) {
        return true;
      }
      paramAccessibilityNodeInfoCompat = paramAccessibilityNodeInfoCompat.getActionList();
    } while ((!paramAccessibilityNodeInfoCompat.contains(Integer.valueOf(16))) && (!paramAccessibilityNodeInfoCompat.contains(Integer.valueOf(32))) && (!paramAccessibilityNodeInfoCompat.contains(Integer.valueOf(1))));
    return true;
  }
  
  public static boolean isSpeakingNode(@Nullable AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, @Nullable View paramView)
  {
    if ((paramAccessibilityNodeInfoCompat == null) || (paramView == null)) {}
    int i;
    do
    {
      do
      {
        return false;
      } while (!paramAccessibilityNodeInfoCompat.isVisibleToUser());
      i = ViewCompat.getImportantForAccessibility(paramView);
    } while ((i == 4) || ((i == 2) && (paramAccessibilityNodeInfoCompat.getChildCount() <= 0)) || ((!paramAccessibilityNodeInfoCompat.isCheckable()) && (!hasText(paramAccessibilityNodeInfoCompat)) && (!hasNonActionableSpeakingDescendants(paramAccessibilityNodeInfoCompat, paramView))));
    return true;
  }
  
  public static boolean isTopLevelScrollItem(@Nullable AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, @Nullable View paramView)
  {
    if ((paramAccessibilityNodeInfoCompat == null) || (paramView == null)) {}
    do
    {
      do
      {
        return false;
        paramView = (View)ViewCompat.getParentForAccessibility(paramView);
      } while (paramView == null);
      if (paramAccessibilityNodeInfoCompat.isScrollable()) {
        return true;
      }
      paramAccessibilityNodeInfoCompat = paramAccessibilityNodeInfoCompat.getActionList();
      if ((paramAccessibilityNodeInfoCompat.contains(Integer.valueOf(4096))) || (paramAccessibilityNodeInfoCompat.contains(Integer.valueOf(8192)))) {
        return true;
      }
    } while ((paramView instanceof Spinner));
    if (((paramView instanceof AdapterView)) || ((paramView instanceof ScrollView)) || ((paramView instanceof HorizontalScrollView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.android.AccessibilityUtil
 * JD-Core Version:    0.7.0.1
 */