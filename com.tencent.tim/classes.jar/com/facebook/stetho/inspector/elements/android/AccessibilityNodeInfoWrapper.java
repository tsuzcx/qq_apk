package com.facebook.stetho.inspector.elements.android;

import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import com.facebook.stetho.common.android.AccessibilityUtil;
import java.util.Iterator;
import java.util.List;

public final class AccessibilityNodeInfoWrapper
{
  @Nullable
  public static String getActions(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramAccessibilityNodeInfoCompat = paramAccessibilityNodeInfoCompat.getActionList().iterator();
    while (paramAccessibilityNodeInfoCompat.hasNext())
    {
      Object localObject = (AccessibilityNodeInfoCompat.AccessibilityActionCompat)paramAccessibilityNodeInfoCompat.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(", ");
      }
      switch (((AccessibilityNodeInfoCompat.AccessibilityActionCompat)localObject).getId())
      {
      default: 
        localObject = ((AccessibilityNodeInfoCompat.AccessibilityActionCompat)localObject).getLabel();
        if (localObject != null) {
          localStringBuilder.append((CharSequence)localObject);
        }
        break;
      case 1: 
        localStringBuilder.append("focus");
        break;
      case 2: 
        localStringBuilder.append("clear-focus");
        break;
      case 4: 
        localStringBuilder.append("select");
        break;
      case 8: 
        localStringBuilder.append("clear-selection");
        break;
      case 16: 
        localStringBuilder.append("click");
        break;
      case 32: 
        localStringBuilder.append("long-click");
        break;
      case 64: 
        localStringBuilder.append("accessibility-focus");
        break;
      case 128: 
        localStringBuilder.append("clear-accessibility-focus");
        break;
      case 256: 
        localStringBuilder.append("next-at-movement-granularity");
        break;
      case 512: 
        localStringBuilder.append("previous-at-movement-granularity");
        break;
      case 1024: 
        localStringBuilder.append("next-html-element");
        break;
      case 2048: 
        localStringBuilder.append("previous-html-element");
        break;
      case 4096: 
        localStringBuilder.append("scroll-forward");
        break;
      case 8192: 
        localStringBuilder.append("scroll-backward");
        break;
      case 65536: 
        localStringBuilder.append("cut");
        break;
      case 16384: 
        localStringBuilder.append("copy");
        break;
      case 32768: 
        localStringBuilder.append("paste");
        break;
      case 131072: 
        localStringBuilder.append("set-selection");
        continue;
        localStringBuilder.append("unknown");
      }
    }
    if (localStringBuilder.length() > 0) {
      return localStringBuilder.toString();
    }
    return null;
  }
  
  @Nullable
  public static CharSequence getDescription(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, View paramView)
  {
    int j = 0;
    Object localObject1 = null;
    Object localObject2 = paramAccessibilityNodeInfoCompat.getContentDescription();
    paramAccessibilityNodeInfoCompat = paramAccessibilityNodeInfoCompat.getText();
    if (!TextUtils.isEmpty(paramAccessibilityNodeInfoCompat))
    {
      i = 1;
      boolean bool = paramView instanceof EditText;
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || ((bool) && (i != 0))) {
        break label58;
      }
      paramAccessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat)localObject2;
    }
    label58:
    do
    {
      return paramAccessibilityNodeInfoCompat;
      i = 0;
      break;
      if (i != 0) {
        return paramAccessibilityNodeInfoCompat;
      }
      paramAccessibilityNodeInfoCompat = localObject1;
    } while (!(paramView instanceof ViewGroup));
    localObject2 = new StringBuilder();
    paramView = (ViewGroup)paramView;
    int k = paramView.getChildCount();
    int i = j;
    label96:
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat;
    if (i < k)
    {
      paramAccessibilityNodeInfoCompat = paramView.getChildAt(i);
      localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
      ViewCompat.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfoCompat, localAccessibilityNodeInfoCompat);
      if (!AccessibilityUtil.isSpeakingNode(localAccessibilityNodeInfoCompat, paramAccessibilityNodeInfoCompat)) {
        break label194;
      }
    }
    label194:
    for (paramAccessibilityNodeInfoCompat = getDescription(localAccessibilityNodeInfoCompat, paramAccessibilityNodeInfoCompat);; paramAccessibilityNodeInfoCompat = null)
    {
      if (!TextUtils.isEmpty(paramAccessibilityNodeInfoCompat))
      {
        if (((StringBuilder)localObject2).length() > 0) {
          ((StringBuilder)localObject2).append(", ");
        }
        ((StringBuilder)localObject2).append(paramAccessibilityNodeInfoCompat);
      }
      localAccessibilityNodeInfoCompat.recycle();
      i += 1;
      break label96;
      paramAccessibilityNodeInfoCompat = localObject1;
      if (((StringBuilder)localObject2).length() <= 0) {
        break;
      }
      return ((StringBuilder)localObject2).toString();
    }
  }
  
  @Nullable
  public static String getFocusableReasons(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, View paramView)
  {
    boolean bool1 = AccessibilityUtil.hasText(paramAccessibilityNodeInfoCompat);
    boolean bool2 = paramAccessibilityNodeInfoCompat.isCheckable();
    boolean bool3 = AccessibilityUtil.hasNonActionableSpeakingDescendants(paramAccessibilityNodeInfoCompat, paramView);
    if (AccessibilityUtil.isActionableForAccessibility(paramAccessibilityNodeInfoCompat))
    {
      if (paramAccessibilityNodeInfoCompat.getChildCount() <= 0) {
        return "View is actionable and has no children.";
      }
      if (bool1) {
        return "View is actionable and has a description.";
      }
      if (bool2) {
        return "View is actionable and checkable.";
      }
      if (bool3) {
        return "View is actionable and has non-actionable descendants with descriptions.";
      }
    }
    if (AccessibilityUtil.isTopLevelScrollItem(paramAccessibilityNodeInfoCompat, paramView))
    {
      if (bool1) {
        return "View is a direct child of a scrollable container and has a description.";
      }
      if (bool2) {
        return "View is a direct child of a scrollable container and is checkable.";
      }
      if (bool3) {
        return "View is a direct child of a scrollable container and has non-actionable descendants with descriptions.";
      }
    }
    if (bool1) {
      return "View has a description and is not actionable, but has no actionable ancestor.";
    }
    return null;
  }
  
  public static boolean getIgnored(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, View paramView)
  {
    int i = ViewCompat.getImportantForAccessibility(paramView);
    if ((i == 2) || (i == 4)) {
      return true;
    }
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent instanceof View); localViewParent = localViewParent.getParent()) {
      if (ViewCompat.getImportantForAccessibility((View)localViewParent) == 4) {
        return true;
      }
    }
    if (!paramAccessibilityNodeInfoCompat.isVisibleToUser()) {
      return true;
    }
    if (AccessibilityUtil.isAccessibilityFocusable(paramAccessibilityNodeInfoCompat, paramView))
    {
      if (paramAccessibilityNodeInfoCompat.getChildCount() <= 0) {
        return false;
      }
      return !AccessibilityUtil.isSpeakingNode(paramAccessibilityNodeInfoCompat, paramView);
    }
    return (AccessibilityUtil.hasFocusableAncestor(paramAccessibilityNodeInfoCompat, paramView)) || (!AccessibilityUtil.hasText(paramAccessibilityNodeInfoCompat));
  }
  
  public static String getIgnoredReasons(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, View paramView)
  {
    int i = ViewCompat.getImportantForAccessibility(paramView);
    if (i == 2) {
      return "View has importantForAccessibility set to 'NO'.";
    }
    if (i == 4) {
      return "View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'.";
    }
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent instanceof View); localViewParent = localViewParent.getParent()) {
      if (ViewCompat.getImportantForAccessibility((View)localViewParent) == 4) {
        return "An ancestor View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'.";
      }
    }
    if (!paramAccessibilityNodeInfoCompat.isVisibleToUser()) {
      return "View is not visible.";
    }
    if (AccessibilityUtil.isAccessibilityFocusable(paramAccessibilityNodeInfoCompat, paramView)) {
      return "View is actionable, but has no description.";
    }
    if (AccessibilityUtil.hasText(paramAccessibilityNodeInfoCompat)) {
      return "View is not actionable, and an ancestor View has co-opted its description.";
    }
    return "View is not actionable and has no description.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.AccessibilityNodeInfoWrapper
 * JD-Core Version:    0.7.0.1
 */