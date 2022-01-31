package android.support.v4.view;

import android.content.ClipData;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.Display;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.Collection;

public class ViewCompat
{
  public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
  public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
  public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
  static final ViewCompat.ViewCompatBaseImpl IMPL = new ViewCompat.ViewCompatBaseImpl();
  public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
  @Deprecated
  public static final int LAYER_TYPE_HARDWARE = 2;
  @Deprecated
  public static final int LAYER_TYPE_NONE = 0;
  @Deprecated
  public static final int LAYER_TYPE_SOFTWARE = 1;
  public static final int LAYOUT_DIRECTION_INHERIT = 2;
  public static final int LAYOUT_DIRECTION_LOCALE = 3;
  public static final int LAYOUT_DIRECTION_LTR = 0;
  public static final int LAYOUT_DIRECTION_RTL = 1;
  @Deprecated
  public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
  @Deprecated
  public static final int MEASURED_SIZE_MASK = 16777215;
  @Deprecated
  public static final int MEASURED_STATE_MASK = -16777216;
  @Deprecated
  public static final int MEASURED_STATE_TOO_SMALL = 16777216;
  @Deprecated
  public static final int OVER_SCROLL_ALWAYS = 0;
  @Deprecated
  public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
  @Deprecated
  public static final int OVER_SCROLL_NEVER = 2;
  public static final int SCROLL_AXIS_HORIZONTAL = 1;
  public static final int SCROLL_AXIS_NONE = 0;
  public static final int SCROLL_AXIS_VERTICAL = 2;
  public static final int SCROLL_INDICATOR_BOTTOM = 2;
  public static final int SCROLL_INDICATOR_END = 32;
  public static final int SCROLL_INDICATOR_LEFT = 4;
  public static final int SCROLL_INDICATOR_RIGHT = 8;
  public static final int SCROLL_INDICATOR_START = 16;
  public static final int SCROLL_INDICATOR_TOP = 1;
  private static final String TAG = "ViewCompat";
  public static final int TYPE_NON_TOUCH = 1;
  public static final int TYPE_TOUCH = 0;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      IMPL = new ViewCompat.ViewCompatApi26Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      IMPL = new ViewCompat.ViewCompatApi24Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      IMPL = new ViewCompat.ViewCompatApi23Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      IMPL = new ViewCompat.ViewCompatApi21Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new ViewCompat.ViewCompatApi19Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      IMPL = new ViewCompat.ViewCompatApi18Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      IMPL = new ViewCompat.ViewCompatApi17Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new ViewCompat.ViewCompatApi16Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      IMPL = new ViewCompat.ViewCompatApi15Impl();
      return;
    }
  }
  
  public static void addKeyboardNavigationClusters(@NonNull View paramView, @NonNull Collection paramCollection, int paramInt)
  {
    IMPL.addKeyboardNavigationClusters(paramView, paramCollection, paramInt);
  }
  
  public static ViewPropertyAnimatorCompat animate(View paramView)
  {
    return IMPL.animate(paramView);
  }
  
  @Deprecated
  public static boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return paramView.canScrollHorizontally(paramInt);
  }
  
  @Deprecated
  public static boolean canScrollVertically(View paramView, int paramInt)
  {
    return paramView.canScrollVertically(paramInt);
  }
  
  public static void cancelDragAndDrop(View paramView)
  {
    IMPL.cancelDragAndDrop(paramView);
  }
  
  @Deprecated
  public static int combineMeasuredStates(int paramInt1, int paramInt2)
  {
    return View.combineMeasuredStates(paramInt1, paramInt2);
  }
  
  public static WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return IMPL.dispatchApplyWindowInsets(paramView, paramWindowInsetsCompat);
  }
  
  public static void dispatchFinishTemporaryDetach(View paramView)
  {
    IMPL.dispatchFinishTemporaryDetach(paramView);
  }
  
  public static boolean dispatchNestedFling(@NonNull View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return IMPL.dispatchNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
  }
  
  public static boolean dispatchNestedPreFling(@NonNull View paramView, float paramFloat1, float paramFloat2)
  {
    return IMPL.dispatchNestedPreFling(paramView, paramFloat1, paramFloat2);
  }
  
  public static boolean dispatchNestedPreScroll(@NonNull View paramView, int paramInt1, int paramInt2, @Nullable int[] paramArrayOfInt1, @Nullable int[] paramArrayOfInt2)
  {
    return IMPL.dispatchNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public static boolean dispatchNestedPreScroll(@NonNull View paramView, int paramInt1, int paramInt2, @Nullable int[] paramArrayOfInt1, @Nullable int[] paramArrayOfInt2, int paramInt3)
  {
    if ((paramView instanceof NestedScrollingChild2)) {
      return ((NestedScrollingChild2)paramView).dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
    }
    if (paramInt3 == 0) {
      return IMPL.dispatchNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    }
    return false;
  }
  
  public static boolean dispatchNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable int[] paramArrayOfInt)
  {
    return IMPL.dispatchNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public static boolean dispatchNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable int[] paramArrayOfInt, int paramInt5)
  {
    if ((paramView instanceof NestedScrollingChild2)) {
      return ((NestedScrollingChild2)paramView).dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
    }
    if (paramInt5 == 0) {
      return IMPL.dispatchNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    }
    return false;
  }
  
  public static void dispatchStartTemporaryDetach(View paramView)
  {
    IMPL.dispatchStartTemporaryDetach(paramView);
  }
  
  public static int generateViewId()
  {
    return IMPL.generateViewId();
  }
  
  public static int getAccessibilityLiveRegion(View paramView)
  {
    return IMPL.getAccessibilityLiveRegion(paramView);
  }
  
  public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    return IMPL.getAccessibilityNodeProvider(paramView);
  }
  
  @Deprecated
  public static float getAlpha(View paramView)
  {
    return paramView.getAlpha();
  }
  
  public static ColorStateList getBackgroundTintList(View paramView)
  {
    return IMPL.getBackgroundTintList(paramView);
  }
  
  public static PorterDuff.Mode getBackgroundTintMode(View paramView)
  {
    return IMPL.getBackgroundTintMode(paramView);
  }
  
  public static Rect getClipBounds(View paramView)
  {
    return IMPL.getClipBounds(paramView);
  }
  
  public static Display getDisplay(@NonNull View paramView)
  {
    return IMPL.getDisplay(paramView);
  }
  
  public static float getElevation(View paramView)
  {
    return IMPL.getElevation(paramView);
  }
  
  public static boolean getFitsSystemWindows(View paramView)
  {
    return IMPL.getFitsSystemWindows(paramView);
  }
  
  public static int getImportantForAccessibility(View paramView)
  {
    return IMPL.getImportantForAccessibility(paramView);
  }
  
  public static int getImportantForAutofill(@NonNull View paramView)
  {
    return IMPL.getImportantForAutofill(paramView);
  }
  
  public static int getLabelFor(View paramView)
  {
    return IMPL.getLabelFor(paramView);
  }
  
  @Deprecated
  public static int getLayerType(View paramView)
  {
    return paramView.getLayerType();
  }
  
  public static int getLayoutDirection(View paramView)
  {
    return IMPL.getLayoutDirection(paramView);
  }
  
  @Deprecated
  @Nullable
  public static Matrix getMatrix(View paramView)
  {
    return paramView.getMatrix();
  }
  
  @Deprecated
  public static int getMeasuredHeightAndState(View paramView)
  {
    return paramView.getMeasuredHeightAndState();
  }
  
  @Deprecated
  public static int getMeasuredState(View paramView)
  {
    return paramView.getMeasuredState();
  }
  
  @Deprecated
  public static int getMeasuredWidthAndState(View paramView)
  {
    return paramView.getMeasuredWidthAndState();
  }
  
  public static int getMinimumHeight(View paramView)
  {
    return IMPL.getMinimumHeight(paramView);
  }
  
  public static int getMinimumWidth(View paramView)
  {
    return IMPL.getMinimumWidth(paramView);
  }
  
  public static int getNextClusterForwardId(@NonNull View paramView)
  {
    return IMPL.getNextClusterForwardId(paramView);
  }
  
  @Deprecated
  public static int getOverScrollMode(View paramView)
  {
    return paramView.getOverScrollMode();
  }
  
  public static int getPaddingEnd(View paramView)
  {
    return IMPL.getPaddingEnd(paramView);
  }
  
  public static int getPaddingStart(View paramView)
  {
    return IMPL.getPaddingStart(paramView);
  }
  
  public static ViewParent getParentForAccessibility(View paramView)
  {
    return IMPL.getParentForAccessibility(paramView);
  }
  
  @Deprecated
  public static float getPivotX(View paramView)
  {
    return paramView.getPivotX();
  }
  
  @Deprecated
  public static float getPivotY(View paramView)
  {
    return paramView.getPivotY();
  }
  
  @Deprecated
  public static float getRotation(View paramView)
  {
    return paramView.getRotation();
  }
  
  @Deprecated
  public static float getRotationX(View paramView)
  {
    return paramView.getRotationX();
  }
  
  @Deprecated
  public static float getRotationY(View paramView)
  {
    return paramView.getRotationY();
  }
  
  @Deprecated
  public static float getScaleX(View paramView)
  {
    return paramView.getScaleX();
  }
  
  @Deprecated
  public static float getScaleY(View paramView)
  {
    return paramView.getScaleY();
  }
  
  public static int getScrollIndicators(@NonNull View paramView)
  {
    return IMPL.getScrollIndicators(paramView);
  }
  
  public static String getTransitionName(View paramView)
  {
    return IMPL.getTransitionName(paramView);
  }
  
  @Deprecated
  public static float getTranslationX(View paramView)
  {
    return paramView.getTranslationX();
  }
  
  @Deprecated
  public static float getTranslationY(View paramView)
  {
    return paramView.getTranslationY();
  }
  
  public static float getTranslationZ(View paramView)
  {
    return IMPL.getTranslationZ(paramView);
  }
  
  public static int getWindowSystemUiVisibility(View paramView)
  {
    return IMPL.getWindowSystemUiVisibility(paramView);
  }
  
  @Deprecated
  public static float getX(View paramView)
  {
    return paramView.getX();
  }
  
  @Deprecated
  public static float getY(View paramView)
  {
    return paramView.getY();
  }
  
  public static float getZ(View paramView)
  {
    return IMPL.getZ(paramView);
  }
  
  public static boolean hasAccessibilityDelegate(View paramView)
  {
    return IMPL.hasAccessibilityDelegate(paramView);
  }
  
  public static boolean hasExplicitFocusable(@NonNull View paramView)
  {
    return IMPL.hasExplicitFocusable(paramView);
  }
  
  public static boolean hasNestedScrollingParent(@NonNull View paramView)
  {
    return IMPL.hasNestedScrollingParent(paramView);
  }
  
  public static boolean hasNestedScrollingParent(@NonNull View paramView, int paramInt)
  {
    if ((paramView instanceof NestedScrollingChild2)) {
      ((NestedScrollingChild2)paramView).hasNestedScrollingParent(paramInt);
    }
    while (paramInt != 0) {
      return false;
    }
    return IMPL.hasNestedScrollingParent(paramView);
  }
  
  public static boolean hasOnClickListeners(View paramView)
  {
    return IMPL.hasOnClickListeners(paramView);
  }
  
  public static boolean hasOverlappingRendering(View paramView)
  {
    return IMPL.hasOverlappingRendering(paramView);
  }
  
  public static boolean hasTransientState(View paramView)
  {
    return IMPL.hasTransientState(paramView);
  }
  
  public static boolean isAttachedToWindow(View paramView)
  {
    return IMPL.isAttachedToWindow(paramView);
  }
  
  public static boolean isFocusedByDefault(@NonNull View paramView)
  {
    return IMPL.isFocusedByDefault(paramView);
  }
  
  public static boolean isImportantForAccessibility(View paramView)
  {
    return IMPL.isImportantForAccessibility(paramView);
  }
  
  public static boolean isImportantForAutofill(@NonNull View paramView)
  {
    return IMPL.isImportantForAutofill(paramView);
  }
  
  public static boolean isInLayout(View paramView)
  {
    return IMPL.isInLayout(paramView);
  }
  
  public static boolean isKeyboardNavigationCluster(@NonNull View paramView)
  {
    return IMPL.isKeyboardNavigationCluster(paramView);
  }
  
  public static boolean isLaidOut(View paramView)
  {
    return IMPL.isLaidOut(paramView);
  }
  
  public static boolean isLayoutDirectionResolved(View paramView)
  {
    return IMPL.isLayoutDirectionResolved(paramView);
  }
  
  public static boolean isNestedScrollingEnabled(@NonNull View paramView)
  {
    return IMPL.isNestedScrollingEnabled(paramView);
  }
  
  @Deprecated
  public static boolean isOpaque(View paramView)
  {
    return paramView.isOpaque();
  }
  
  public static boolean isPaddingRelative(View paramView)
  {
    return IMPL.isPaddingRelative(paramView);
  }
  
  @Deprecated
  public static void jumpDrawablesToCurrentState(View paramView)
  {
    paramView.jumpDrawablesToCurrentState();
  }
  
  public static View keyboardNavigationClusterSearch(@NonNull View paramView1, View paramView2, int paramInt)
  {
    return IMPL.keyboardNavigationClusterSearch(paramView1, paramView2, paramInt);
  }
  
  public static void offsetLeftAndRight(View paramView, int paramInt)
  {
    IMPL.offsetLeftAndRight(paramView, paramInt);
  }
  
  public static void offsetTopAndBottom(View paramView, int paramInt)
  {
    IMPL.offsetTopAndBottom(paramView, paramInt);
  }
  
  public static WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return IMPL.onApplyWindowInsets(paramView, paramWindowInsetsCompat);
  }
  
  @Deprecated
  public static void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    paramView.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public static void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    IMPL.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
  }
  
  @Deprecated
  public static void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    paramView.onPopulateAccessibilityEvent(paramAccessibilityEvent);
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
  
  public static void requestApplyInsets(View paramView)
  {
    IMPL.requestApplyInsets(paramView);
  }
  
  @NonNull
  public static View requireViewById(@NonNull View paramView, @IdRes int paramInt)
  {
    paramView = paramView.findViewById(paramInt);
    if (paramView == null) {
      throw new IllegalArgumentException("ID does not reference a View inside this View");
    }
    return paramView;
  }
  
  @Deprecated
  public static int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    return View.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
  }
  
  public static boolean restoreDefaultFocus(@NonNull View paramView)
  {
    return IMPL.restoreDefaultFocus(paramView);
  }
  
  public static void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    IMPL.setAccessibilityDelegate(paramView, paramAccessibilityDelegateCompat);
  }
  
  public static void setAccessibilityLiveRegion(View paramView, int paramInt)
  {
    IMPL.setAccessibilityLiveRegion(paramView, paramInt);
  }
  
  @Deprecated
  public static void setActivated(View paramView, boolean paramBoolean)
  {
    paramView.setActivated(paramBoolean);
  }
  
  @Deprecated
  public static void setAlpha(View paramView, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }
  
  public static void setAutofillHints(@NonNull View paramView, @Nullable String... paramVarArgs)
  {
    IMPL.setAutofillHints(paramView, paramVarArgs);
  }
  
  public static void setBackground(View paramView, Drawable paramDrawable)
  {
    IMPL.setBackground(paramView, paramDrawable);
  }
  
  public static void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
  {
    IMPL.setBackgroundTintList(paramView, paramColorStateList);
  }
  
  public static void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
  {
    IMPL.setBackgroundTintMode(paramView, paramMode);
  }
  
  @Deprecated
  public static void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    IMPL.setChildrenDrawingOrderEnabled(paramViewGroup, paramBoolean);
  }
  
  public static void setClipBounds(View paramView, Rect paramRect)
  {
    IMPL.setClipBounds(paramView, paramRect);
  }
  
  public static void setElevation(View paramView, float paramFloat)
  {
    IMPL.setElevation(paramView, paramFloat);
  }
  
  @Deprecated
  public static void setFitsSystemWindows(View paramView, boolean paramBoolean)
  {
    paramView.setFitsSystemWindows(paramBoolean);
  }
  
  public static void setFocusedByDefault(@NonNull View paramView, boolean paramBoolean)
  {
    IMPL.setFocusedByDefault(paramView, paramBoolean);
  }
  
  public static void setHasTransientState(View paramView, boolean paramBoolean)
  {
    IMPL.setHasTransientState(paramView, paramBoolean);
  }
  
  public static void setImportantForAccessibility(View paramView, int paramInt)
  {
    IMPL.setImportantForAccessibility(paramView, paramInt);
  }
  
  public static void setImportantForAutofill(@NonNull View paramView, int paramInt)
  {
    IMPL.setImportantForAutofill(paramView, paramInt);
  }
  
  public static void setKeyboardNavigationCluster(@NonNull View paramView, boolean paramBoolean)
  {
    IMPL.setKeyboardNavigationCluster(paramView, paramBoolean);
  }
  
  public static void setLabelFor(View paramView, @IdRes int paramInt)
  {
    IMPL.setLabelFor(paramView, paramInt);
  }
  
  public static void setLayerPaint(View paramView, Paint paramPaint)
  {
    IMPL.setLayerPaint(paramView, paramPaint);
  }
  
  @Deprecated
  public static void setLayerType(View paramView, int paramInt, Paint paramPaint)
  {
    paramView.setLayerType(paramInt, paramPaint);
  }
  
  public static void setLayoutDirection(View paramView, int paramInt)
  {
    IMPL.setLayoutDirection(paramView, paramInt);
  }
  
  public static void setNestedScrollingEnabled(@NonNull View paramView, boolean paramBoolean)
  {
    IMPL.setNestedScrollingEnabled(paramView, paramBoolean);
  }
  
  public static void setNextClusterForwardId(@NonNull View paramView, int paramInt)
  {
    IMPL.setNextClusterForwardId(paramView, paramInt);
  }
  
  public static void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    IMPL.setOnApplyWindowInsetsListener(paramView, paramOnApplyWindowInsetsListener);
  }
  
  @Deprecated
  public static void setOverScrollMode(View paramView, int paramInt)
  {
    paramView.setOverScrollMode(paramInt);
  }
  
  public static void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMPL.setPaddingRelative(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @Deprecated
  public static void setPivotX(View paramView, float paramFloat)
  {
    paramView.setPivotX(paramFloat);
  }
  
  @Deprecated
  public static void setPivotY(View paramView, float paramFloat)
  {
    paramView.setPivotY(paramFloat);
  }
  
  public static void setPointerIcon(@NonNull View paramView, PointerIconCompat paramPointerIconCompat)
  {
    IMPL.setPointerIcon(paramView, paramPointerIconCompat);
  }
  
  @Deprecated
  public static void setRotation(View paramView, float paramFloat)
  {
    paramView.setRotation(paramFloat);
  }
  
  @Deprecated
  public static void setRotationX(View paramView, float paramFloat)
  {
    paramView.setRotationX(paramFloat);
  }
  
  @Deprecated
  public static void setRotationY(View paramView, float paramFloat)
  {
    paramView.setRotationY(paramFloat);
  }
  
  @Deprecated
  public static void setSaveFromParentEnabled(View paramView, boolean paramBoolean)
  {
    paramView.setSaveFromParentEnabled(paramBoolean);
  }
  
  @Deprecated
  public static void setScaleX(View paramView, float paramFloat)
  {
    paramView.setScaleX(paramFloat);
  }
  
  @Deprecated
  public static void setScaleY(View paramView, float paramFloat)
  {
    paramView.setScaleY(paramFloat);
  }
  
  public static void setScrollIndicators(@NonNull View paramView, int paramInt)
  {
    IMPL.setScrollIndicators(paramView, paramInt);
  }
  
  public static void setScrollIndicators(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    IMPL.setScrollIndicators(paramView, paramInt1, paramInt2);
  }
  
  public static void setTooltipText(@NonNull View paramView, @Nullable CharSequence paramCharSequence)
  {
    IMPL.setTooltipText(paramView, paramCharSequence);
  }
  
  public static void setTransitionName(View paramView, String paramString)
  {
    IMPL.setTransitionName(paramView, paramString);
  }
  
  @Deprecated
  public static void setTranslationX(View paramView, float paramFloat)
  {
    paramView.setTranslationX(paramFloat);
  }
  
  @Deprecated
  public static void setTranslationY(View paramView, float paramFloat)
  {
    paramView.setTranslationY(paramFloat);
  }
  
  public static void setTranslationZ(View paramView, float paramFloat)
  {
    IMPL.setTranslationZ(paramView, paramFloat);
  }
  
  @Deprecated
  public static void setX(View paramView, float paramFloat)
  {
    paramView.setX(paramFloat);
  }
  
  @Deprecated
  public static void setY(View paramView, float paramFloat)
  {
    paramView.setY(paramFloat);
  }
  
  public static void setZ(View paramView, float paramFloat)
  {
    IMPL.setZ(paramView, paramFloat);
  }
  
  public static boolean startDragAndDrop(View paramView, ClipData paramClipData, View.DragShadowBuilder paramDragShadowBuilder, Object paramObject, int paramInt)
  {
    return IMPL.startDragAndDrop(paramView, paramClipData, paramDragShadowBuilder, paramObject, paramInt);
  }
  
  public static boolean startNestedScroll(@NonNull View paramView, int paramInt)
  {
    return IMPL.startNestedScroll(paramView, paramInt);
  }
  
  public static boolean startNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView instanceof NestedScrollingChild2)) {
      return ((NestedScrollingChild2)paramView).startNestedScroll(paramInt1, paramInt2);
    }
    if (paramInt2 == 0) {
      return IMPL.startNestedScroll(paramView, paramInt1);
    }
    return false;
  }
  
  public static void stopNestedScroll(@NonNull View paramView)
  {
    IMPL.stopNestedScroll(paramView);
  }
  
  public static void stopNestedScroll(@NonNull View paramView, int paramInt)
  {
    if ((paramView instanceof NestedScrollingChild2)) {
      ((NestedScrollingChild2)paramView).stopNestedScroll(paramInt);
    }
    while (paramInt != 0) {
      return;
    }
    IMPL.stopNestedScroll(paramView);
  }
  
  public static void updateDragShadow(View paramView, View.DragShadowBuilder paramDragShadowBuilder)
  {
    IMPL.updateDragShadow(paramView, paramDragShadowBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat
 * JD-Core Version:    0.7.0.1
 */