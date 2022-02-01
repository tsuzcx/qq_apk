package android.support.v4.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
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
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.util.Log;
import android.view.Display;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ViewCompat
{
  public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
  public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
  public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
  static final ViewCompatBaseImpl IMPL = new ViewCompatBaseImpl();
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
      IMPL = new ViewCompatApi26Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      IMPL = new ViewCompatApi24Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      IMPL = new ViewCompatApi23Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      IMPL = new ViewCompatApi21Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new ViewCompatApi19Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      IMPL = new ViewCompatApi18Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      IMPL = new ViewCompatApi17Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new ViewCompatApi16Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      IMPL = new ViewCompatApi15Impl();
      return;
    }
  }
  
  public static void addKeyboardNavigationClusters(@NonNull View paramView, @NonNull Collection<View> paramCollection, int paramInt)
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
    } else if (paramInt == 0) {
      return IMPL.hasNestedScrollingParent(paramView);
    }
    return false;
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
  public static <T extends View> T requireViewById(@NonNull View paramView, @IdRes int paramInt)
  {
    paramView = paramView.findViewById(paramInt);
    if (paramView != null) {
      return paramView;
    }
    throw new IllegalArgumentException("ID does not reference a View inside this View");
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
    if ((paramView instanceof NestedScrollingChild2))
    {
      ((NestedScrollingChild2)paramView).stopNestedScroll(paramInt);
      return;
    }
    if (paramInt == 0) {
      IMPL.stopNestedScroll(paramView);
    }
  }
  
  public static void updateDragShadow(View paramView, View.DragShadowBuilder paramDragShadowBuilder)
  {
    IMPL.updateDragShadow(paramView, paramDragShadowBuilder);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  private static @interface AccessibilityLiveRegion {}
  
  @Retention(RetentionPolicy.SOURCE)
  @TargetApi(26)
  private static @interface AutofillImportance {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface FocusDirection {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface FocusRealDirection {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface FocusRelativeDirection {}
  
  @Retention(RetentionPolicy.SOURCE)
  private static @interface ImportantForAccessibility {}
  
  @Retention(RetentionPolicy.SOURCE)
  private static @interface LayerType {}
  
  @Retention(RetentionPolicy.SOURCE)
  private static @interface LayoutDirectionMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface NestedScrollType {}
  
  @Retention(RetentionPolicy.SOURCE)
  private static @interface OverScroll {}
  
  @Retention(RetentionPolicy.SOURCE)
  private static @interface ResolvedLayoutDirectionMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface ScrollAxis {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface ScrollIndicators {}
  
  @RequiresApi(15)
  static class ViewCompatApi15Impl
    extends ViewCompat.ViewCompatBaseImpl
  {
    public boolean hasOnClickListeners(View paramView)
    {
      return paramView.hasOnClickListeners();
    }
  }
  
  @RequiresApi(16)
  static class ViewCompatApi16Impl
    extends ViewCompat.ViewCompatApi15Impl
  {
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
    {
      paramView = paramView.getAccessibilityNodeProvider();
      if (paramView != null) {
        return new AccessibilityNodeProviderCompat(paramView);
      }
      return null;
    }
    
    public boolean getFitsSystemWindows(View paramView)
    {
      return paramView.getFitsSystemWindows();
    }
    
    public int getImportantForAccessibility(View paramView)
    {
      return paramView.getImportantForAccessibility();
    }
    
    public int getMinimumHeight(View paramView)
    {
      return paramView.getMinimumHeight();
    }
    
    public int getMinimumWidth(View paramView)
    {
      return paramView.getMinimumWidth();
    }
    
    public ViewParent getParentForAccessibility(View paramView)
    {
      return paramView.getParentForAccessibility();
    }
    
    public boolean hasOverlappingRendering(View paramView)
    {
      return paramView.hasOverlappingRendering();
    }
    
    public boolean hasTransientState(View paramView)
    {
      return paramView.hasTransientState();
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      return paramView.performAccessibilityAction(paramInt, paramBundle);
    }
    
    public void postInvalidateOnAnimation(View paramView)
    {
      paramView.postInvalidateOnAnimation();
    }
    
    public void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.postInvalidateOnAnimation(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void postOnAnimation(View paramView, Runnable paramRunnable)
    {
      paramView.postOnAnimation(paramRunnable);
    }
    
    public void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
    {
      paramView.postOnAnimationDelayed(paramRunnable, paramLong);
    }
    
    public void requestApplyInsets(View paramView)
    {
      paramView.requestFitSystemWindows();
    }
    
    public void setBackground(View paramView, Drawable paramDrawable)
    {
      paramView.setBackground(paramDrawable);
    }
    
    public void setHasTransientState(View paramView, boolean paramBoolean)
    {
      paramView.setHasTransientState(paramBoolean);
    }
    
    public void setImportantForAccessibility(View paramView, int paramInt)
    {
      int i = paramInt;
      if (paramInt == 4) {
        i = 2;
      }
      paramView.setImportantForAccessibility(i);
    }
  }
  
  @RequiresApi(17)
  static class ViewCompatApi17Impl
    extends ViewCompat.ViewCompatApi16Impl
  {
    public int generateViewId()
    {
      return View.generateViewId();
    }
    
    public Display getDisplay(View paramView)
    {
      return paramView.getDisplay();
    }
    
    public int getLabelFor(View paramView)
    {
      return paramView.getLabelFor();
    }
    
    public int getLayoutDirection(View paramView)
    {
      return paramView.getLayoutDirection();
    }
    
    public int getPaddingEnd(View paramView)
    {
      return paramView.getPaddingEnd();
    }
    
    public int getPaddingStart(View paramView)
    {
      return paramView.getPaddingStart();
    }
    
    public int getWindowSystemUiVisibility(View paramView)
    {
      return paramView.getWindowSystemUiVisibility();
    }
    
    public boolean isPaddingRelative(View paramView)
    {
      return paramView.isPaddingRelative();
    }
    
    public void setLabelFor(View paramView, int paramInt)
    {
      paramView.setLabelFor(paramInt);
    }
    
    public void setLayerPaint(View paramView, Paint paramPaint)
    {
      paramView.setLayerPaint(paramPaint);
    }
    
    public void setLayoutDirection(View paramView, int paramInt)
    {
      paramView.setLayoutDirection(paramInt);
    }
    
    public void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  @RequiresApi(18)
  static class ViewCompatApi18Impl
    extends ViewCompat.ViewCompatApi17Impl
  {
    public Rect getClipBounds(View paramView)
    {
      return paramView.getClipBounds();
    }
    
    public boolean isInLayout(View paramView)
    {
      return paramView.isInLayout();
    }
    
    public void setClipBounds(View paramView, Rect paramRect)
    {
      paramView.setClipBounds(paramRect);
    }
  }
  
  @RequiresApi(19)
  static class ViewCompatApi19Impl
    extends ViewCompat.ViewCompatApi18Impl
  {
    public int getAccessibilityLiveRegion(View paramView)
    {
      return paramView.getAccessibilityLiveRegion();
    }
    
    public boolean isAttachedToWindow(View paramView)
    {
      return paramView.isAttachedToWindow();
    }
    
    public boolean isLaidOut(View paramView)
    {
      return paramView.isLaidOut();
    }
    
    public boolean isLayoutDirectionResolved(View paramView)
    {
      return paramView.isLayoutDirectionResolved();
    }
    
    public void setAccessibilityLiveRegion(View paramView, int paramInt)
    {
      paramView.setAccessibilityLiveRegion(paramInt);
    }
    
    public void setImportantForAccessibility(View paramView, int paramInt)
    {
      paramView.setImportantForAccessibility(paramInt);
    }
  }
  
  @RequiresApi(21)
  static class ViewCompatApi21Impl
    extends ViewCompat.ViewCompatApi19Impl
  {
    private static ThreadLocal<Rect> sThreadLocalRect;
    
    private static Rect getEmptyTempRect()
    {
      if (sThreadLocalRect == null) {
        sThreadLocalRect = new ThreadLocal();
      }
      Rect localRect2 = (Rect)sThreadLocalRect.get();
      Rect localRect1 = localRect2;
      if (localRect2 == null)
      {
        localRect1 = new Rect();
        sThreadLocalRect.set(localRect1);
      }
      localRect1.setEmpty();
      return localRect1;
    }
    
    public WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
    {
      paramWindowInsetsCompat = (WindowInsets)WindowInsetsCompat.unwrap(paramWindowInsetsCompat);
      WindowInsets localWindowInsets = paramView.dispatchApplyWindowInsets(paramWindowInsetsCompat);
      paramView = paramWindowInsetsCompat;
      if (localWindowInsets != paramWindowInsetsCompat) {
        paramView = new WindowInsets(localWindowInsets);
      }
      return WindowInsetsCompat.wrap(paramView);
    }
    
    public boolean dispatchNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      return paramView.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    }
    
    public boolean dispatchNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
    {
      return paramView.dispatchNestedPreFling(paramFloat1, paramFloat2);
    }
    
    public boolean dispatchNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      return paramView.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    }
    
    public boolean dispatchNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
    {
      return paramView.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    }
    
    public ColorStateList getBackgroundTintList(View paramView)
    {
      return paramView.getBackgroundTintList();
    }
    
    public PorterDuff.Mode getBackgroundTintMode(View paramView)
    {
      return paramView.getBackgroundTintMode();
    }
    
    public float getElevation(View paramView)
    {
      return paramView.getElevation();
    }
    
    public String getTransitionName(View paramView)
    {
      return paramView.getTransitionName();
    }
    
    public float getTranslationZ(View paramView)
    {
      return paramView.getTranslationZ();
    }
    
    public float getZ(View paramView)
    {
      return paramView.getZ();
    }
    
    public boolean hasNestedScrollingParent(View paramView)
    {
      return paramView.hasNestedScrollingParent();
    }
    
    public boolean isImportantForAccessibility(View paramView)
    {
      return paramView.isImportantForAccessibility();
    }
    
    public boolean isNestedScrollingEnabled(View paramView)
    {
      return paramView.isNestedScrollingEnabled();
    }
    
    public void offsetLeftAndRight(View paramView, int paramInt)
    {
      Rect localRect = getEmptyTempRect();
      ViewParent localViewParent = paramView.getParent();
      boolean bool;
      if ((localViewParent instanceof View))
      {
        View localView = (View)localViewParent;
        localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        bool = localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()) ^ true;
      }
      else
      {
        bool = false;
      }
      super.offsetLeftAndRight(paramView, paramInt);
      if ((bool) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        ((View)localViewParent).invalidate(localRect);
      }
    }
    
    public void offsetTopAndBottom(View paramView, int paramInt)
    {
      Rect localRect = getEmptyTempRect();
      ViewParent localViewParent = paramView.getParent();
      boolean bool;
      if ((localViewParent instanceof View))
      {
        View localView = (View)localViewParent;
        localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        bool = localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()) ^ true;
      }
      else
      {
        bool = false;
      }
      super.offsetTopAndBottom(paramView, paramInt);
      if ((bool) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        ((View)localViewParent).invalidate(localRect);
      }
    }
    
    public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
    {
      paramWindowInsetsCompat = (WindowInsets)WindowInsetsCompat.unwrap(paramWindowInsetsCompat);
      WindowInsets localWindowInsets = paramView.onApplyWindowInsets(paramWindowInsetsCompat);
      paramView = paramWindowInsetsCompat;
      if (localWindowInsets != paramWindowInsetsCompat) {
        paramView = new WindowInsets(localWindowInsets);
      }
      return WindowInsetsCompat.wrap(paramView);
    }
    
    public void requestApplyInsets(View paramView)
    {
      paramView.requestApplyInsets();
    }
    
    public void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
    {
      paramView.setBackgroundTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramColorStateList = paramView.getBackground();
        int i;
        if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null)) {
          i = 0;
        } else {
          i = 1;
        }
        if ((paramColorStateList != null) && (i != 0))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramView.getDrawableState());
          }
          paramView.setBackground(paramColorStateList);
        }
      }
    }
    
    public void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
    {
      paramView.setBackgroundTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramMode = paramView.getBackground();
        int i;
        if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null)) {
          i = 0;
        } else {
          i = 1;
        }
        if ((paramMode != null) && (i != 0))
        {
          if (paramMode.isStateful()) {
            paramMode.setState(paramView.getDrawableState());
          }
          paramView.setBackground(paramMode);
        }
      }
    }
    
    public void setElevation(View paramView, float paramFloat)
    {
      paramView.setElevation(paramFloat);
    }
    
    public void setNestedScrollingEnabled(View paramView, boolean paramBoolean)
    {
      paramView.setNestedScrollingEnabled(paramBoolean);
    }
    
    public void setOnApplyWindowInsetsListener(View paramView, final OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
    {
      if (paramOnApplyWindowInsetsListener == null)
      {
        paramView.setOnApplyWindowInsetsListener(null);
        return;
      }
      paramView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
      {
        public WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
        {
          paramAnonymousWindowInsets = WindowInsetsCompat.wrap(paramAnonymousWindowInsets);
          return (WindowInsets)WindowInsetsCompat.unwrap(paramOnApplyWindowInsetsListener.onApplyWindowInsets(paramAnonymousView, paramAnonymousWindowInsets));
        }
      });
    }
    
    public void setTransitionName(View paramView, String paramString)
    {
      paramView.setTransitionName(paramString);
    }
    
    public void setTranslationZ(View paramView, float paramFloat)
    {
      paramView.setTranslationZ(paramFloat);
    }
    
    public void setZ(View paramView, float paramFloat)
    {
      paramView.setZ(paramFloat);
    }
    
    public boolean startNestedScroll(View paramView, int paramInt)
    {
      return paramView.startNestedScroll(paramInt);
    }
    
    public void stopNestedScroll(View paramView)
    {
      paramView.stopNestedScroll();
    }
  }
  
  @RequiresApi(23)
  static class ViewCompatApi23Impl
    extends ViewCompat.ViewCompatApi21Impl
  {
    public int getScrollIndicators(View paramView)
    {
      return paramView.getScrollIndicators();
    }
    
    public void offsetLeftAndRight(View paramView, int paramInt)
    {
      paramView.offsetLeftAndRight(paramInt);
    }
    
    public void offsetTopAndBottom(View paramView, int paramInt)
    {
      paramView.offsetTopAndBottom(paramInt);
    }
    
    public void setScrollIndicators(View paramView, int paramInt)
    {
      paramView.setScrollIndicators(paramInt);
    }
    
    public void setScrollIndicators(View paramView, int paramInt1, int paramInt2)
    {
      paramView.setScrollIndicators(paramInt1, paramInt2);
    }
  }
  
  @RequiresApi(24)
  static class ViewCompatApi24Impl
    extends ViewCompat.ViewCompatApi23Impl
  {
    public void cancelDragAndDrop(View paramView)
    {
      paramView.cancelDragAndDrop();
    }
    
    public void dispatchFinishTemporaryDetach(View paramView)
    {
      paramView.dispatchFinishTemporaryDetach();
    }
    
    public void dispatchStartTemporaryDetach(View paramView)
    {
      paramView.dispatchStartTemporaryDetach();
    }
    
    public void setPointerIcon(View paramView, PointerIconCompat paramPointerIconCompat)
    {
      if (paramPointerIconCompat != null) {
        paramPointerIconCompat = paramPointerIconCompat.getPointerIcon();
      } else {
        paramPointerIconCompat = null;
      }
      paramView.setPointerIcon((PointerIcon)paramPointerIconCompat);
    }
    
    public boolean startDragAndDrop(View paramView, ClipData paramClipData, View.DragShadowBuilder paramDragShadowBuilder, Object paramObject, int paramInt)
    {
      return paramView.startDragAndDrop(paramClipData, paramDragShadowBuilder, paramObject, paramInt);
    }
    
    public void updateDragShadow(View paramView, View.DragShadowBuilder paramDragShadowBuilder)
    {
      paramView.updateDragShadow(paramDragShadowBuilder);
    }
  }
  
  @RequiresApi(26)
  static class ViewCompatApi26Impl
    extends ViewCompat.ViewCompatApi24Impl
  {
    public void addKeyboardNavigationClusters(@NonNull View paramView, @NonNull Collection<View> paramCollection, int paramInt)
    {
      paramView.addKeyboardNavigationClusters(paramCollection, paramInt);
    }
    
    public int getImportantForAutofill(@NonNull View paramView)
    {
      return paramView.getImportantForAutofill();
    }
    
    public int getNextClusterForwardId(@NonNull View paramView)
    {
      return paramView.getNextClusterForwardId();
    }
    
    public boolean hasExplicitFocusable(@NonNull View paramView)
    {
      return paramView.hasExplicitFocusable();
    }
    
    public boolean isFocusedByDefault(@NonNull View paramView)
    {
      return paramView.isFocusedByDefault();
    }
    
    public boolean isImportantForAutofill(@NonNull View paramView)
    {
      return paramView.isImportantForAutofill();
    }
    
    public boolean isKeyboardNavigationCluster(@NonNull View paramView)
    {
      return paramView.isKeyboardNavigationCluster();
    }
    
    public View keyboardNavigationClusterSearch(@NonNull View paramView1, View paramView2, int paramInt)
    {
      return paramView1.keyboardNavigationClusterSearch(paramView2, paramInt);
    }
    
    public boolean restoreDefaultFocus(@NonNull View paramView)
    {
      return paramView.restoreDefaultFocus();
    }
    
    public void setAutofillHints(@NonNull View paramView, @Nullable String... paramVarArgs)
    {
      paramView.setAutofillHints(paramVarArgs);
    }
    
    public void setFocusedByDefault(@NonNull View paramView, boolean paramBoolean)
    {
      paramView.setFocusedByDefault(paramBoolean);
    }
    
    public void setImportantForAutofill(@NonNull View paramView, int paramInt)
    {
      paramView.setImportantForAutofill(paramInt);
    }
    
    public void setKeyboardNavigationCluster(@NonNull View paramView, boolean paramBoolean)
    {
      paramView.setKeyboardNavigationCluster(paramBoolean);
    }
    
    public void setNextClusterForwardId(@NonNull View paramView, int paramInt)
    {
      paramView.setNextClusterForwardId(paramInt);
    }
    
    public void setTooltipText(View paramView, CharSequence paramCharSequence)
    {
      paramView.setTooltipText(paramCharSequence);
    }
  }
  
  static class ViewCompatBaseImpl
  {
    static boolean sAccessibilityDelegateCheckFailed = false;
    static Field sAccessibilityDelegateField;
    private static Method sChildrenDrawingOrderMethod;
    private static Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    private static WeakHashMap<View, String> sTransitionNameMap;
    private Method mDispatchFinishTemporaryDetach;
    private Method mDispatchStartTemporaryDetach;
    private boolean mTempDetachBound;
    WeakHashMap<View, ViewPropertyAnimatorCompat> mViewPropertyAnimatorCompatMap = null;
    
    private void bindTempDetach()
    {
      try
      {
        this.mDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
        this.mDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.e("ViewCompat", "Couldn't find method", localNoSuchMethodException);
      }
      this.mTempDetachBound = true;
    }
    
    private static void tickleInvalidationFlag(View paramView)
    {
      float f = paramView.getTranslationY();
      paramView.setTranslationY(1.0F + f);
      paramView.setTranslationY(f);
    }
    
    public void addKeyboardNavigationClusters(@NonNull View paramView, @NonNull Collection<View> paramCollection, int paramInt) {}
    
    public ViewPropertyAnimatorCompat animate(View paramView)
    {
      if (this.mViewPropertyAnimatorCompatMap == null) {
        this.mViewPropertyAnimatorCompatMap = new WeakHashMap();
      }
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2 = (ViewPropertyAnimatorCompat)this.mViewPropertyAnimatorCompatMap.get(paramView);
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1 = localViewPropertyAnimatorCompat2;
      if (localViewPropertyAnimatorCompat2 == null)
      {
        localViewPropertyAnimatorCompat1 = new ViewPropertyAnimatorCompat(paramView);
        this.mViewPropertyAnimatorCompatMap.put(paramView, localViewPropertyAnimatorCompat1);
      }
      return localViewPropertyAnimatorCompat1;
    }
    
    public void cancelDragAndDrop(View paramView) {}
    
    public WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
    {
      return paramWindowInsetsCompat;
    }
    
    public void dispatchFinishTemporaryDetach(View paramView)
    {
      if (!this.mTempDetachBound) {
        bindTempDetach();
      }
      Method localMethod = this.mDispatchFinishTemporaryDetach;
      if (localMethod != null) {
        try
        {
          localMethod.invoke(paramView, new Object[0]);
          return;
        }
        catch (Exception paramView)
        {
          Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", paramView);
          return;
        }
      }
      paramView.onFinishTemporaryDetach();
    }
    
    public boolean dispatchNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        return ((NestedScrollingChild)paramView).dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
      }
      return false;
    }
    
    public boolean dispatchNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        return ((NestedScrollingChild)paramView).dispatchNestedPreFling(paramFloat1, paramFloat2);
      }
      return false;
    }
    
    public boolean dispatchNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        return ((NestedScrollingChild)paramView).dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
      }
      return false;
    }
    
    public boolean dispatchNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        return ((NestedScrollingChild)paramView).dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
      }
      return false;
    }
    
    public void dispatchStartTemporaryDetach(View paramView)
    {
      if (!this.mTempDetachBound) {
        bindTempDetach();
      }
      Method localMethod = this.mDispatchStartTemporaryDetach;
      if (localMethod != null) {
        try
        {
          localMethod.invoke(paramView, new Object[0]);
          return;
        }
        catch (Exception paramView)
        {
          Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", paramView);
          return;
        }
      }
      paramView.onStartTemporaryDetach();
    }
    
    public int generateViewId()
    {
      int k;
      int i;
      do
      {
        k = sNextGeneratedId.get();
        int j = k + 1;
        i = j;
        if (j > 16777215) {
          i = 1;
        }
      } while (!sNextGeneratedId.compareAndSet(k, i));
      return k;
    }
    
    public int getAccessibilityLiveRegion(View paramView)
    {
      return 0;
    }
    
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
    {
      return null;
    }
    
    public ColorStateList getBackgroundTintList(View paramView)
    {
      if ((paramView instanceof TintableBackgroundView)) {
        return ((TintableBackgroundView)paramView).getSupportBackgroundTintList();
      }
      return null;
    }
    
    public PorterDuff.Mode getBackgroundTintMode(View paramView)
    {
      if ((paramView instanceof TintableBackgroundView)) {
        return ((TintableBackgroundView)paramView).getSupportBackgroundTintMode();
      }
      return null;
    }
    
    public Rect getClipBounds(View paramView)
    {
      return null;
    }
    
    public Display getDisplay(View paramView)
    {
      if (isAttachedToWindow(paramView)) {
        return ((WindowManager)paramView.getContext().getSystemService("window")).getDefaultDisplay();
      }
      return null;
    }
    
    public float getElevation(View paramView)
    {
      return 0.0F;
    }
    
    public boolean getFitsSystemWindows(View paramView)
    {
      return false;
    }
    
    long getFrameTime()
    {
      return ValueAnimator.getFrameDelay();
    }
    
    public int getImportantForAccessibility(View paramView)
    {
      return 0;
    }
    
    @TargetApi(26)
    public int getImportantForAutofill(@NonNull View paramView)
    {
      return 0;
    }
    
    public int getLabelFor(View paramView)
    {
      return 0;
    }
    
    public int getLayoutDirection(View paramView)
    {
      return 0;
    }
    
    public int getMinimumHeight(View paramView)
    {
      if (!sMinHeightFieldFetched) {}
      try
      {
        sMinHeightField = View.class.getDeclaredField("mMinHeight");
        sMinHeightField.setAccessible(true);
        label23:
        sMinHeightFieldFetched = true;
        Field localField = sMinHeightField;
        if (localField != null) {}
        try
        {
          int i = ((Integer)localField.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView)
        {
          label49:
          break label49;
        }
        return 0;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label23;
      }
    }
    
    public int getMinimumWidth(View paramView)
    {
      if (!sMinWidthFieldFetched) {}
      try
      {
        sMinWidthField = View.class.getDeclaredField("mMinWidth");
        sMinWidthField.setAccessible(true);
        label24:
        sMinWidthFieldFetched = true;
        Field localField = sMinWidthField;
        if (localField != null) {}
        try
        {
          int i = ((Integer)localField.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView)
        {
          label50:
          break label50;
        }
        return 0;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label24;
      }
    }
    
    public int getNextClusterForwardId(@NonNull View paramView)
    {
      return -1;
    }
    
    public int getPaddingEnd(View paramView)
    {
      return paramView.getPaddingRight();
    }
    
    public int getPaddingStart(View paramView)
    {
      return paramView.getPaddingLeft();
    }
    
    public ViewParent getParentForAccessibility(View paramView)
    {
      return paramView.getParent();
    }
    
    public int getScrollIndicators(View paramView)
    {
      return 0;
    }
    
    public String getTransitionName(View paramView)
    {
      WeakHashMap localWeakHashMap = sTransitionNameMap;
      if (localWeakHashMap == null) {
        return null;
      }
      return (String)localWeakHashMap.get(paramView);
    }
    
    public float getTranslationZ(View paramView)
    {
      return 0.0F;
    }
    
    public int getWindowSystemUiVisibility(View paramView)
    {
      return 0;
    }
    
    public float getZ(View paramView)
    {
      return getTranslationZ(paramView) + getElevation(paramView);
    }
    
    public boolean hasAccessibilityDelegate(View paramView)
    {
      boolean bool2 = sAccessibilityDelegateCheckFailed;
      boolean bool1 = false;
      if (bool2) {
        return false;
      }
      if (sAccessibilityDelegateField == null) {}
      try
      {
        sAccessibilityDelegateField = View.class.getDeclaredField("mAccessibilityDelegate");
        sAccessibilityDelegateField.setAccessible(true);
      }
      catch (Throwable paramView)
      {
        label39:
        label61:
        break label39;
      }
      sAccessibilityDelegateCheckFailed = true;
      return false;
      try
      {
        paramView = sAccessibilityDelegateField.get(paramView);
        if (paramView != null) {
          bool1 = true;
        }
        return bool1;
      }
      catch (Throwable paramView)
      {
        break label61;
      }
      sAccessibilityDelegateCheckFailed = true;
      return false;
    }
    
    public boolean hasExplicitFocusable(@NonNull View paramView)
    {
      return paramView.hasFocusable();
    }
    
    public boolean hasNestedScrollingParent(View paramView)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        return ((NestedScrollingChild)paramView).hasNestedScrollingParent();
      }
      return false;
    }
    
    public boolean hasOnClickListeners(View paramView)
    {
      return false;
    }
    
    public boolean hasOverlappingRendering(View paramView)
    {
      return true;
    }
    
    public boolean hasTransientState(View paramView)
    {
      return false;
    }
    
    public boolean isAttachedToWindow(View paramView)
    {
      return paramView.getWindowToken() != null;
    }
    
    public boolean isFocusedByDefault(@NonNull View paramView)
    {
      return false;
    }
    
    public boolean isImportantForAccessibility(View paramView)
    {
      return true;
    }
    
    public boolean isImportantForAutofill(@NonNull View paramView)
    {
      return true;
    }
    
    public boolean isInLayout(View paramView)
    {
      return false;
    }
    
    public boolean isKeyboardNavigationCluster(@NonNull View paramView)
    {
      return false;
    }
    
    public boolean isLaidOut(View paramView)
    {
      return (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
    }
    
    public boolean isLayoutDirectionResolved(View paramView)
    {
      return false;
    }
    
    public boolean isNestedScrollingEnabled(View paramView)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        return ((NestedScrollingChild)paramView).isNestedScrollingEnabled();
      }
      return false;
    }
    
    public boolean isPaddingRelative(View paramView)
    {
      return false;
    }
    
    public View keyboardNavigationClusterSearch(@NonNull View paramView1, View paramView2, int paramInt)
    {
      return null;
    }
    
    public void offsetLeftAndRight(View paramView, int paramInt)
    {
      paramView.offsetLeftAndRight(paramInt);
      if (paramView.getVisibility() == 0)
      {
        tickleInvalidationFlag(paramView);
        paramView = paramView.getParent();
        if ((paramView instanceof View)) {
          tickleInvalidationFlag((View)paramView);
        }
      }
    }
    
    public void offsetTopAndBottom(View paramView, int paramInt)
    {
      paramView.offsetTopAndBottom(paramInt);
      if (paramView.getVisibility() == 0)
      {
        tickleInvalidationFlag(paramView);
        paramView = paramView.getParent();
        if ((paramView instanceof View)) {
          tickleInvalidationFlag((View)paramView);
        }
      }
    }
    
    public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
    {
      return paramWindowInsetsCompat;
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      paramView.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfoCompat.unwrap());
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    public void postInvalidateOnAnimation(View paramView)
    {
      paramView.postInvalidate();
    }
    
    public void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.postInvalidate(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void postOnAnimation(View paramView, Runnable paramRunnable)
    {
      paramView.postDelayed(paramRunnable, getFrameTime());
    }
    
    public void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
    {
      paramView.postDelayed(paramRunnable, getFrameTime() + paramLong);
    }
    
    public void requestApplyInsets(View paramView) {}
    
    public boolean restoreDefaultFocus(@NonNull View paramView)
    {
      return paramView.requestFocus();
    }
    
    public void setAccessibilityDelegate(View paramView, @Nullable AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
    {
      if (paramAccessibilityDelegateCompat == null) {
        paramAccessibilityDelegateCompat = null;
      } else {
        paramAccessibilityDelegateCompat = paramAccessibilityDelegateCompat.getBridge();
      }
      paramView.setAccessibilityDelegate(paramAccessibilityDelegateCompat);
    }
    
    public void setAccessibilityLiveRegion(View paramView, int paramInt) {}
    
    public void setAutofillHints(@NonNull View paramView, @Nullable String... paramVarArgs) {}
    
    public void setBackground(View paramView, Drawable paramDrawable)
    {
      paramView.setBackgroundDrawable(paramDrawable);
    }
    
    public void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
    {
      if ((paramView instanceof TintableBackgroundView)) {
        ((TintableBackgroundView)paramView).setSupportBackgroundTintList(paramColorStateList);
      }
    }
    
    public void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
    {
      if ((paramView instanceof TintableBackgroundView)) {
        ((TintableBackgroundView)paramView).setSupportBackgroundTintMode(paramMode);
      }
    }
    
    public void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      if (sChildrenDrawingOrderMethod == null)
      {
        try
        {
          sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", localNoSuchMethodException);
        }
        sChildrenDrawingOrderMethod.setAccessible(true);
      }
      try
      {
        sChildrenDrawingOrderMethod.invoke(paramViewGroup, new Object[] { Boolean.valueOf(paramBoolean) });
        return;
      }
      catch (InvocationTargetException paramViewGroup)
      {
        Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", paramViewGroup);
        return;
      }
      catch (IllegalArgumentException paramViewGroup)
      {
        Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", paramViewGroup);
        return;
      }
      catch (IllegalAccessException paramViewGroup)
      {
        Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", paramViewGroup);
      }
    }
    
    public void setClipBounds(View paramView, Rect paramRect) {}
    
    public void setElevation(View paramView, float paramFloat) {}
    
    public void setFocusedByDefault(@NonNull View paramView, boolean paramBoolean) {}
    
    public void setHasTransientState(View paramView, boolean paramBoolean) {}
    
    public void setImportantForAccessibility(View paramView, int paramInt) {}
    
    public void setImportantForAutofill(@NonNull View paramView, int paramInt) {}
    
    public void setKeyboardNavigationCluster(@NonNull View paramView, boolean paramBoolean) {}
    
    public void setLabelFor(View paramView, int paramInt) {}
    
    public void setLayerPaint(View paramView, Paint paramPaint)
    {
      paramView.setLayerType(paramView.getLayerType(), paramPaint);
      paramView.invalidate();
    }
    
    public void setLayoutDirection(View paramView, int paramInt) {}
    
    public void setNestedScrollingEnabled(View paramView, boolean paramBoolean)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        ((NestedScrollingChild)paramView).setNestedScrollingEnabled(paramBoolean);
      }
    }
    
    public void setNextClusterForwardId(@NonNull View paramView, int paramInt) {}
    
    public void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener) {}
    
    public void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void setPointerIcon(View paramView, PointerIconCompat paramPointerIconCompat) {}
    
    public void setScrollIndicators(View paramView, int paramInt) {}
    
    public void setScrollIndicators(View paramView, int paramInt1, int paramInt2) {}
    
    public void setTooltipText(View paramView, CharSequence paramCharSequence) {}
    
    public void setTransitionName(View paramView, String paramString)
    {
      if (sTransitionNameMap == null) {
        sTransitionNameMap = new WeakHashMap();
      }
      sTransitionNameMap.put(paramView, paramString);
    }
    
    public void setTranslationZ(View paramView, float paramFloat) {}
    
    public void setZ(View paramView, float paramFloat) {}
    
    public boolean startDragAndDrop(View paramView, ClipData paramClipData, View.DragShadowBuilder paramDragShadowBuilder, Object paramObject, int paramInt)
    {
      return paramView.startDrag(paramClipData, paramDragShadowBuilder, paramObject, paramInt);
    }
    
    public boolean startNestedScroll(View paramView, int paramInt)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        return ((NestedScrollingChild)paramView).startNestedScroll(paramInt);
      }
      return false;
    }
    
    public void stopNestedScroll(View paramView)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        ((NestedScrollingChild)paramView).stopNestedScroll();
      }
    }
    
    public void updateDragShadow(View paramView, View.DragShadowBuilder paramDragShadowBuilder) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat
 * JD-Core Version:    0.7.0.1
 */