package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

class DrawerLayout$AccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  private final Rect mTmpRect = new Rect();
  
  DrawerLayout$AccessibilityDelegate(DrawerLayout paramDrawerLayout) {}
  
  private void addChildrenForAccessibility(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if (DrawerLayout.includeChildForAccessibility(localView)) {
        paramAccessibilityNodeInfoCompat.addChild(localView);
      }
      i += 1;
    }
  }
  
  private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat2)
  {
    Rect localRect = this.mTmpRect;
    paramAccessibilityNodeInfoCompat2.getBoundsInParent(localRect);
    paramAccessibilityNodeInfoCompat1.setBoundsInParent(localRect);
    paramAccessibilityNodeInfoCompat2.getBoundsInScreen(localRect);
    paramAccessibilityNodeInfoCompat1.setBoundsInScreen(localRect);
    paramAccessibilityNodeInfoCompat1.setVisibleToUser(paramAccessibilityNodeInfoCompat2.isVisibleToUser());
    paramAccessibilityNodeInfoCompat1.setPackageName(paramAccessibilityNodeInfoCompat2.getPackageName());
    paramAccessibilityNodeInfoCompat1.setClassName(paramAccessibilityNodeInfoCompat2.getClassName());
    paramAccessibilityNodeInfoCompat1.setContentDescription(paramAccessibilityNodeInfoCompat2.getContentDescription());
    paramAccessibilityNodeInfoCompat1.setEnabled(paramAccessibilityNodeInfoCompat2.isEnabled());
    paramAccessibilityNodeInfoCompat1.setClickable(paramAccessibilityNodeInfoCompat2.isClickable());
    paramAccessibilityNodeInfoCompat1.setFocusable(paramAccessibilityNodeInfoCompat2.isFocusable());
    paramAccessibilityNodeInfoCompat1.setFocused(paramAccessibilityNodeInfoCompat2.isFocused());
    paramAccessibilityNodeInfoCompat1.setAccessibilityFocused(paramAccessibilityNodeInfoCompat2.isAccessibilityFocused());
    paramAccessibilityNodeInfoCompat1.setSelected(paramAccessibilityNodeInfoCompat2.isSelected());
    paramAccessibilityNodeInfoCompat1.setLongClickable(paramAccessibilityNodeInfoCompat2.isLongClickable());
    paramAccessibilityNodeInfoCompat1.addAction(paramAccessibilityNodeInfoCompat2.getActions());
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramView = paramAccessibilityEvent.getText();
      paramAccessibilityEvent = this.this$0.findVisibleDrawer();
      if (paramAccessibilityEvent != null)
      {
        int i = this.this$0.getDrawerViewAbsoluteGravity(paramAccessibilityEvent);
        paramAccessibilityEvent = this.this$0.getDrawerTitle(i);
        if (paramAccessibilityEvent != null) {
          paramView.add(paramAccessibilityEvent);
        }
      }
      return true;
    }
    return super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(DrawerLayout.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if (DrawerLayout.CAN_HIDE_DESCENDANTS) {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    }
    for (;;)
    {
      paramAccessibilityNodeInfoCompat.setClassName(DrawerLayout.class.getName());
      paramAccessibilityNodeInfoCompat.setFocusable(false);
      paramAccessibilityNodeInfoCompat.setFocused(false);
      paramAccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
      paramAccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
      return;
      AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
      super.onInitializeAccessibilityNodeInfo(paramView, localAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setSource(paramView);
      ViewParent localViewParent = ViewCompat.getParentForAccessibility(paramView);
      if ((localViewParent instanceof View)) {
        paramAccessibilityNodeInfoCompat.setParent((View)localViewParent);
      }
      copyNodeInfoNoChildren(paramAccessibilityNodeInfoCompat, localAccessibilityNodeInfoCompat);
      localAccessibilityNodeInfoCompat.recycle();
      addChildrenForAccessibility(paramAccessibilityNodeInfoCompat, (ViewGroup)paramView);
    }
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if ((DrawerLayout.CAN_HIDE_DESCENDANTS) || (DrawerLayout.includeChildForAccessibility(paramView))) {
      return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayout.AccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */