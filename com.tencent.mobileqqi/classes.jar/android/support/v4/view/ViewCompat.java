package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public class ViewCompat
{
  public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
  public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
  public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
  private static final long FAKE_FRAME_TIME = 10L;
  static final ViewCompatImpl IMPL = new BaseViewCompatImpl();
  public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
  public static final int LAYER_TYPE_HARDWARE = 2;
  public static final int LAYER_TYPE_NONE = 0;
  public static final int LAYER_TYPE_SOFTWARE = 1;
  public static final int LAYOUT_DIRECTION_INHERIT = 2;
  public static final int LAYOUT_DIRECTION_LOCALE = 3;
  public static final int LAYOUT_DIRECTION_LTR = 0;
  public static final int LAYOUT_DIRECTION_RTL = 1;
  public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
  public static final int MEASURED_SIZE_MASK = 16777215;
  public static final int MEASURED_STATE_MASK = -16777216;
  public static final int MEASURED_STATE_TOO_SMALL = 16777216;
  public static final int OVER_SCROLL_ALWAYS = 0;
  public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
  public static final int OVER_SCROLL_NEVER = 2;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
    {
      IMPL = new KitKatViewCompatImpl();
      return;
    }
    if (i >= 17)
    {
      IMPL = new JbMr1ViewCompatImpl();
      return;
    }
    if (i >= 16)
    {
      IMPL = new JBViewCompatImpl();
      return;
    }
    if (i >= 14)
    {
      IMPL = new ICSViewCompatImpl();
      return;
    }
    if (i >= 11)
    {
      IMPL = new HCViewCompatImpl();
      return;
    }
    if (i >= 9)
    {
      IMPL = new GBViewCompatImpl();
      return;
    }
  }
  
  public static boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return IMPL.canScrollHorizontally(paramView, paramInt);
  }
  
  public static boolean canScrollVertically(View paramView, int paramInt)
  {
    return IMPL.canScrollVertically(paramView, paramInt);
  }
  
  public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    return IMPL.getAccessibilityNodeProvider(paramView);
  }
  
  public static float getAlpha(View paramView)
  {
    return IMPL.getAlpha(paramView);
  }
  
  public static int getImportantForAccessibility(View paramView)
  {
    return IMPL.getImportantForAccessibility(paramView);
  }
  
  public static int getLabelFor(View paramView)
  {
    return IMPL.getLabelFor(paramView);
  }
  
  public static int getLayerType(View paramView)
  {
    return IMPL.getLayerType(paramView);
  }
  
  public static int getLayoutDirection(View paramView)
  {
    return IMPL.getLayoutDirection(paramView);
  }
  
  public static int getMeasuredHeightAndState(View paramView)
  {
    return IMPL.getMeasuredHeightAndState(paramView);
  }
  
  public static int getMeasuredState(View paramView)
  {
    return IMPL.getMeasuredState(paramView);
  }
  
  public static int getMeasuredWidthAndState(View paramView)
  {
    return IMPL.getMeasuredWidthAndState(paramView);
  }
  
  public static int getOverScrollMode(View paramView)
  {
    return IMPL.getOverScrollMode(paramView);
  }
  
  public static ViewParent getParentForAccessibility(View paramView)
  {
    return IMPL.getParentForAccessibility(paramView);
  }
  
  public static boolean hasTransientState(View paramView)
  {
    return IMPL.hasTransientState(paramView);
  }
  
  public static boolean isOpaque(View paramView)
  {
    return IMPL.isOpaque(paramView);
  }
  
  public static void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    IMPL.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    IMPL.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
  }
  
  public static void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    IMPL.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return IMPL.performAccessibilityAction(paramView, paramInt, paramBundle);
  }
  
  public static void postInvalidateOnAnimation(View paramView)
  {
    IMPL.postInvalidateOnAnimation(paramView);
  }
  
  public static void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMPL.postInvalidateOnAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    IMPL.postOnAnimation(paramView, paramRunnable);
  }
  
  public static void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
  {
    IMPL.postOnAnimationDelayed(paramView, paramRunnable, paramLong);
  }
  
  public static int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    return IMPL.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
  }
  
  public static void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    IMPL.setAccessibilityDelegate(paramView, paramAccessibilityDelegateCompat);
  }
  
  public static void setHasTransientState(View paramView, boolean paramBoolean)
  {
    IMPL.setHasTransientState(paramView, paramBoolean);
  }
  
  public static void setImportantForAccessibility(View paramView, int paramInt)
  {
    IMPL.setImportantForAccessibility(paramView, paramInt);
  }
  
  public static void setLabelFor(View paramView, int paramInt)
  {
    IMPL.setLabelFor(paramView, paramInt);
  }
  
  public static void setLayerPaint(View paramView, Paint paramPaint)
  {
    IMPL.setLayerPaint(paramView, paramPaint);
  }
  
  public static void setLayerType(View paramView, int paramInt, Paint paramPaint)
  {
    IMPL.setLayerType(paramView, paramInt, paramPaint);
  }
  
  public static void setLayoutDirection(View paramView, int paramInt)
  {
    IMPL.setLayoutDirection(paramView, paramInt);
  }
  
  public static void setOverScrollMode(View paramView, int paramInt)
  {
    IMPL.setOverScrollMode(paramView, paramInt);
  }
  
  public int getAccessibilityLiveRegion(View paramView)
  {
    return IMPL.getAccessibilityLiveRegion(paramView);
  }
  
  public void setAccessibilityLiveRegion(View paramView, int paramInt)
  {
    IMPL.setAccessibilityLiveRegion(paramView, paramInt);
  }
  
  static class BaseViewCompatImpl
    implements ViewCompat.ViewCompatImpl
  {
    public boolean canScrollHorizontally(View paramView, int paramInt)
    {
      return false;
    }
    
    public boolean canScrollVertically(View paramView, int paramInt)
    {
      return false;
    }
    
    public int getAccessibilityLiveRegion(View paramView)
    {
      return 0;
    }
    
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
    {
      return null;
    }
    
    public float getAlpha(View paramView)
    {
      return 1.0F;
    }
    
    long getFrameTime()
    {
      return 10L;
    }
    
    public int getImportantForAccessibility(View paramView)
    {
      return 0;
    }
    
    public int getLabelFor(View paramView)
    {
      return 0;
    }
    
    public int getLayerType(View paramView)
    {
      return 0;
    }
    
    public int getLayoutDirection(View paramView)
    {
      return 0;
    }
    
    public int getMeasuredHeightAndState(View paramView)
    {
      return paramView.getMeasuredHeight();
    }
    
    public int getMeasuredState(View paramView)
    {
      return 0;
    }
    
    public int getMeasuredWidthAndState(View paramView)
    {
      return paramView.getMeasuredWidth();
    }
    
    public int getOverScrollMode(View paramView)
    {
      return 2;
    }
    
    public ViewParent getParentForAccessibility(View paramView)
    {
      return paramView.getParent();
    }
    
    public boolean hasTransientState(View paramView)
    {
      return false;
    }
    
    public boolean isOpaque(View paramView)
    {
      boolean bool2 = false;
      paramView = paramView.getBackground();
      boolean bool1 = bool2;
      if (paramView != null)
      {
        bool1 = bool2;
        if (paramView.getOpacity() == -1) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {}
    
    public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    public void postInvalidateOnAnimation(View paramView)
    {
      paramView.postInvalidateDelayed(getFrameTime());
    }
    
    public void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.postInvalidateDelayed(getFrameTime(), paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void postOnAnimation(View paramView, Runnable paramRunnable)
    {
      paramView.postDelayed(paramRunnable, getFrameTime());
    }
    
    public void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
    {
      paramView.postDelayed(paramRunnable, getFrameTime() + paramLong);
    }
    
    public int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
    {
      return View.resolveSize(paramInt1, paramInt2);
    }
    
    public void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat) {}
    
    public void setAccessibilityLiveRegion(View paramView, int paramInt) {}
    
    public void setHasTransientState(View paramView, boolean paramBoolean) {}
    
    public void setImportantForAccessibility(View paramView, int paramInt) {}
    
    public void setLabelFor(View paramView, int paramInt) {}
    
    public void setLayerPaint(View paramView, Paint paramPaint) {}
    
    public void setLayerType(View paramView, int paramInt, Paint paramPaint) {}
    
    public void setLayoutDirection(View paramView, int paramInt) {}
    
    public void setOverScrollMode(View paramView, int paramInt) {}
  }
  
  static class EclairMr1ViewCompatImpl
    extends ViewCompat.BaseViewCompatImpl
  {
    public boolean isOpaque(View paramView)
    {
      return ViewCompatEclairMr1.isOpaque(paramView);
    }
  }
  
  static class GBViewCompatImpl
    extends ViewCompat.EclairMr1ViewCompatImpl
  {
    public int getOverScrollMode(View paramView)
    {
      return ViewCompatGingerbread.getOverScrollMode(paramView);
    }
    
    public void setOverScrollMode(View paramView, int paramInt)
    {
      ViewCompatGingerbread.setOverScrollMode(paramView, paramInt);
    }
  }
  
  static class HCViewCompatImpl
    extends ViewCompat.GBViewCompatImpl
  {
    public float getAlpha(View paramView)
    {
      return ViewCompatHC.getAlpha(paramView);
    }
    
    long getFrameTime()
    {
      return ViewCompatHC.getFrameTime();
    }
    
    public int getLayerType(View paramView)
    {
      return ViewCompatHC.getLayerType(paramView);
    }
    
    public int getMeasuredHeightAndState(View paramView)
    {
      return ViewCompatHC.getMeasuredHeightAndState(paramView);
    }
    
    public int getMeasuredState(View paramView)
    {
      return ViewCompatHC.getMeasuredState(paramView);
    }
    
    public int getMeasuredWidthAndState(View paramView)
    {
      return ViewCompatHC.getMeasuredWidthAndState(paramView);
    }
    
    public int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
    {
      return ViewCompatHC.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
    }
    
    public void setLayerPaint(View paramView, Paint paramPaint)
    {
      setLayerType(paramView, getLayerType(paramView), paramPaint);
      paramView.invalidate();
    }
    
    public void setLayerType(View paramView, int paramInt, Paint paramPaint)
    {
      ViewCompatHC.setLayerType(paramView, paramInt, paramPaint);
    }
  }
  
  static class ICSViewCompatImpl
    extends ViewCompat.HCViewCompatImpl
  {
    public boolean canScrollHorizontally(View paramView, int paramInt)
    {
      return ViewCompatICS.canScrollHorizontally(paramView, paramInt);
    }
    
    public boolean canScrollVertically(View paramView, int paramInt)
    {
      return ViewCompatICS.canScrollVertically(paramView, paramInt);
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      ViewCompatICS.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      ViewCompatICS.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat.getInfo());
    }
    
    public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      ViewCompatICS.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
    {
      ViewCompatICS.setAccessibilityDelegate(paramView, paramAccessibilityDelegateCompat.getBridge());
    }
  }
  
  static class JBViewCompatImpl
    extends ViewCompat.ICSViewCompatImpl
  {
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
    {
      paramView = ViewCompatJB.getAccessibilityNodeProvider(paramView);
      if (paramView != null) {
        return new AccessibilityNodeProviderCompat(paramView);
      }
      return null;
    }
    
    public int getImportantForAccessibility(View paramView)
    {
      return ViewCompatJB.getImportantForAccessibility(paramView);
    }
    
    public ViewParent getParentForAccessibility(View paramView)
    {
      return ViewCompatJB.getParentForAccessibility(paramView);
    }
    
    public boolean hasTransientState(View paramView)
    {
      return ViewCompatJB.hasTransientState(paramView);
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      return ViewCompatJB.performAccessibilityAction(paramView, paramInt, paramBundle);
    }
    
    public void postInvalidateOnAnimation(View paramView)
    {
      ViewCompatJB.postInvalidateOnAnimation(paramView);
    }
    
    public void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      ViewCompatJB.postInvalidateOnAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void postOnAnimation(View paramView, Runnable paramRunnable)
    {
      ViewCompatJB.postOnAnimation(paramView, paramRunnable);
    }
    
    public void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
    {
      ViewCompatJB.postOnAnimationDelayed(paramView, paramRunnable, paramLong);
    }
    
    public void setHasTransientState(View paramView, boolean paramBoolean)
    {
      ViewCompatJB.setHasTransientState(paramView, paramBoolean);
    }
    
    public void setImportantForAccessibility(View paramView, int paramInt)
    {
      ViewCompatJB.setImportantForAccessibility(paramView, paramInt);
    }
  }
  
  static class JbMr1ViewCompatImpl
    extends ViewCompat.JBViewCompatImpl
  {
    public int getLabelFor(View paramView)
    {
      return ViewCompatJellybeanMr1.getLabelFor(paramView);
    }
    
    public int getLayoutDirection(View paramView)
    {
      return ViewCompatJellybeanMr1.getLayoutDirection(paramView);
    }
    
    public void setLabelFor(View paramView, int paramInt)
    {
      ViewCompatJellybeanMr1.setLabelFor(paramView, paramInt);
    }
    
    public void setLayerPaint(View paramView, Paint paramPaint)
    {
      ViewCompatJellybeanMr1.setLayerPaint(paramView, paramPaint);
    }
    
    public void setLayoutDirection(View paramView, int paramInt)
    {
      ViewCompatJellybeanMr1.setLayoutDirection(paramView, paramInt);
    }
  }
  
  static class KitKatViewCompatImpl
    extends ViewCompat.JbMr1ViewCompatImpl
  {
    public int getAccessibilityLiveRegion(View paramView)
    {
      return ViewCompatKitKat.getAccessibilityLiveRegion(paramView);
    }
    
    public void setAccessibilityLiveRegion(View paramView, int paramInt)
    {
      ViewCompatKitKat.setAccessibilityLiveRegion(paramView, paramInt);
    }
  }
  
  static abstract interface ViewCompatImpl
  {
    public abstract boolean canScrollHorizontally(View paramView, int paramInt);
    
    public abstract boolean canScrollVertically(View paramView, int paramInt);
    
    public abstract int getAccessibilityLiveRegion(View paramView);
    
    public abstract AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView);
    
    public abstract float getAlpha(View paramView);
    
    public abstract int getImportantForAccessibility(View paramView);
    
    public abstract int getLabelFor(View paramView);
    
    public abstract int getLayerType(View paramView);
    
    public abstract int getLayoutDirection(View paramView);
    
    public abstract int getMeasuredHeightAndState(View paramView);
    
    public abstract int getMeasuredState(View paramView);
    
    public abstract int getMeasuredWidthAndState(View paramView);
    
    public abstract int getOverScrollMode(View paramView);
    
    public abstract ViewParent getParentForAccessibility(View paramView);
    
    public abstract boolean hasTransientState(View paramView);
    
    public abstract boolean isOpaque(View paramView);
    
    public abstract void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat);
    
    public abstract void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle);
    
    public abstract void postInvalidateOnAnimation(View paramView);
    
    public abstract void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void postOnAnimation(View paramView, Runnable paramRunnable);
    
    public abstract void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong);
    
    public abstract int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat);
    
    public abstract void setAccessibilityLiveRegion(View paramView, int paramInt);
    
    public abstract void setHasTransientState(View paramView, boolean paramBoolean);
    
    public abstract void setImportantForAccessibility(View paramView, int paramInt);
    
    public abstract void setLabelFor(View paramView, int paramInt);
    
    public abstract void setLayerPaint(View paramView, Paint paramPaint);
    
    public abstract void setLayerType(View paramView, int paramInt, Paint paramPaint);
    
    public abstract void setLayoutDirection(View paramView, int paramInt);
    
    public abstract void setOverScrollMode(View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat
 * JD-Core Version:    0.7.0.1
 */