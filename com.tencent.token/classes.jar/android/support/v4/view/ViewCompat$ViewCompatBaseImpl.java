package android.support.v4.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class ViewCompat$ViewCompatBaseImpl
{
  static boolean sAccessibilityDelegateCheckFailed = false;
  static Field sAccessibilityDelegateField;
  private static Method sChildrenDrawingOrderMethod;
  private static Field sMinHeightField;
  private static boolean sMinHeightFieldFetched;
  private static Field sMinWidthField;
  private static boolean sMinWidthFieldFetched;
  private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
  private static WeakHashMap sTransitionNameMap;
  private Method mDispatchFinishTemporaryDetach;
  private Method mDispatchStartTemporaryDetach;
  private boolean mTempDetachBound;
  WeakHashMap mViewPropertyAnimatorCompatMap = null;
  
  private void bindTempDetach()
  {
    try
    {
      this.mDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
      this.mDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
      this.mTempDetachBound = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.e("ViewCompat", "Couldn't find method", localNoSuchMethodException);
      }
    }
  }
  
  private static void tickleInvalidationFlag(View paramView)
  {
    float f = paramView.getTranslationY();
    paramView.setTranslationY(1.0F + f);
    paramView.setTranslationY(f);
  }
  
  public void addKeyboardNavigationClusters(@NonNull View paramView, @NonNull Collection paramCollection, int paramInt) {}
  
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
    if (this.mDispatchFinishTemporaryDetach != null) {
      try
      {
        this.mDispatchFinishTemporaryDetach.invoke(paramView, new Object[0]);
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
    if (this.mDispatchStartTemporaryDetach != null) {
      try
      {
        this.mDispatchStartTemporaryDetach.invoke(paramView, new Object[0]);
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
      if (sMinHeightField != null) {
        try
        {
          int i = ((Integer)sMinHeightField.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView) {}
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
      label23:
      sMinWidthFieldFetched = true;
      if (sMinWidthField != null) {
        try
        {
          int i = ((Integer)sMinWidthField.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView) {}
      }
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
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
    if (sTransitionNameMap == null) {
      return null;
    }
    return (String)sTransitionNameMap.get(paramView);
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
  
  /* Error */
  public boolean hasAccessibilityDelegate(View paramView)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: getstatic 34	android/support/v4/view/ViewCompat$ViewCompatBaseImpl:sAccessibilityDelegateCheckFailed	Z
    //   5: ifeq +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: getstatic 286	android/support/v4/view/ViewCompat$ViewCompatBaseImpl:sAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   13: ifnonnull +21 -> 34
    //   16: ldc 44
    //   18: ldc_w 288
    //   21: invokevirtual 231	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   24: putstatic 286	android/support/v4/view/ViewCompat$ViewCompatBaseImpl:sAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   27: getstatic 286	android/support/v4/view/ViewCompat$ViewCompatBaseImpl:sAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   30: iconst_1
    //   31: invokevirtual 239	java/lang/reflect/Field:setAccessible	(Z)V
    //   34: getstatic 286	android/support/v4/view/ViewCompat$ViewCompatBaseImpl:sAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   37: aload_1
    //   38: invokevirtual 240	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull +12 -> 55
    //   46: iload_2
    //   47: ireturn
    //   48: astore_1
    //   49: iconst_1
    //   50: putstatic 34	android/support/v4/view/ViewCompat$ViewCompatBaseImpl:sAccessibilityDelegateCheckFailed	Z
    //   53: iconst_0
    //   54: ireturn
    //   55: iconst_0
    //   56: istore_2
    //   57: goto -11 -> 46
    //   60: astore_1
    //   61: iconst_1
    //   62: putstatic 34	android/support/v4/view/ViewCompat$ViewCompatBaseImpl:sAccessibilityDelegateCheckFailed	Z
    //   65: iconst_0
    //   66: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	ViewCompatBaseImpl
    //   0	67	1	paramView	View
    //   1	56	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   16	34	48	java/lang/Throwable
    //   34	42	60	java/lang/Throwable
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
    if (paramAccessibilityDelegateCompat == null) {}
    for (paramAccessibilityDelegateCompat = null;; paramAccessibilityDelegateCompat = paramAccessibilityDelegateCompat.getBridge())
    {
      paramView.setAccessibilityDelegate(paramAccessibilityDelegateCompat);
      return;
    }
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
    if (sChildrenDrawingOrderMethod == null) {}
    try
    {
      sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
      sChildrenDrawingOrderMethod.setAccessible(true);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          sChildrenDrawingOrderMethod.invoke(paramViewGroup, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
        }
        catch (IllegalAccessException paramViewGroup)
        {
          Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", paramViewGroup);
          return;
        }
        catch (IllegalArgumentException paramViewGroup)
        {
          Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", paramViewGroup);
          return;
        }
        catch (InvocationTargetException paramViewGroup)
        {
          Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", paramViewGroup);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", localNoSuchMethodException);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.ViewCompatBaseImpl
 * JD-Core Version:    0.7.0.1
 */