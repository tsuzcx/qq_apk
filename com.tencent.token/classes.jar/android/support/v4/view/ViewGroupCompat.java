package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public final class ViewGroupCompat
{
  static final ViewGroupCompat.ViewGroupCompatBaseImpl IMPL = new ViewGroupCompat.ViewGroupCompatBaseImpl();
  public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
  public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      IMPL = new ViewGroupCompat.ViewGroupCompatApi21Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      IMPL = new ViewGroupCompat.ViewGroupCompatApi18Impl();
      return;
    }
  }
  
  public static int getLayoutMode(ViewGroup paramViewGroup)
  {
    return IMPL.getLayoutMode(paramViewGroup);
  }
  
  public static int getNestedScrollAxes(@NonNull ViewGroup paramViewGroup)
  {
    return IMPL.getNestedScrollAxes(paramViewGroup);
  }
  
  public static boolean isTransitionGroup(ViewGroup paramViewGroup)
  {
    return IMPL.isTransitionGroup(paramViewGroup);
  }
  
  @Deprecated
  public static boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return paramViewGroup.onRequestSendAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static void setLayoutMode(ViewGroup paramViewGroup, int paramInt)
  {
    IMPL.setLayoutMode(paramViewGroup, paramInt);
  }
  
  @Deprecated
  public static void setMotionEventSplittingEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramViewGroup.setMotionEventSplittingEnabled(paramBoolean);
  }
  
  public static void setTransitionGroup(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    IMPL.setTransitionGroup(paramViewGroup, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewGroupCompat
 * JD-Core Version:    0.7.0.1
 */