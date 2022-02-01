package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnUnhandledKeyEventListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.collection.ArrayMap;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ViewCompat
{
  private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = { 2131361841, 2131361842, 2131361853, 2131361864, 2131361867, 2131361868, 2131361869, 2131361870, 2131361871, 2131361872, 2131361843, 2131361844, 2131361845, 2131361846, 2131361847, 2131361848, 2131361849, 2131361850, 2131361851, 2131361852, 2131361854, 2131361855, 2131361856, 2131361857, 2131361858, 2131361859, 2131361860, 2131361861, 2131361862, 2131361863, 2131361865, 2131361866 };
  public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
  public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
  public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
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
  private static boolean sAccessibilityDelegateCheckFailed;
  private static Field sAccessibilityDelegateField;
  private static AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();
  private static Method sChildrenDrawingOrderMethod;
  private static Method sDispatchFinishTemporaryDetach;
  private static Method sDispatchStartTemporaryDetach;
  private static Field sMinHeightField;
  private static boolean sMinHeightFieldFetched;
  private static Field sMinWidthField;
  private static boolean sMinWidthFieldFetched;
  private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
  private static boolean sTempDetachBound;
  private static ThreadLocal<Rect> sThreadLocalRect;
  private static WeakHashMap<View, String> sTransitionNameMap;
  private static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap = null;
  
  static
  {
    sAccessibilityDelegateCheckFailed = false;
  }
  
  private static AccessibilityViewProperty<Boolean> accessibilityHeadingProperty()
  {
    return new ViewCompat.5(2131379191, Boolean.class, 28);
  }
  
  public static int addAccessibilityAction(@NonNull View paramView, @NonNull CharSequence paramCharSequence, @NonNull AccessibilityViewCommand paramAccessibilityViewCommand)
  {
    int i = getAvailableActionIdFromResources(paramView);
    if (i != -1) {
      addAccessibilityAction(paramView, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i, paramCharSequence, paramAccessibilityViewCommand));
    }
    return i;
  }
  
  private static void addAccessibilityAction(@NonNull View paramView, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat paramAccessibilityActionCompat)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      getOrCreateAccessibilityDelegateCompat(paramView);
      removeActionWithId(paramAccessibilityActionCompat.getId(), paramView);
      getActionList(paramView).add(paramAccessibilityActionCompat);
      notifyViewAccessibilityStateChangedIfNeeded(paramView, 0);
    }
  }
  
  public static void addKeyboardNavigationClusters(@NonNull View paramView, @NonNull Collection<View> paramCollection, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.addKeyboardNavigationClusters(paramCollection, paramInt);
    }
  }
  
  public static void addOnUnhandledKeyEventListener(@NonNull View paramView, @NonNull OnUnhandledKeyEventListenerCompat paramOnUnhandledKeyEventListenerCompat)
  {
    Object localObject2;
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject2 = (Map)paramView.getTag(2131379237);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayMap();
        paramView.setTag(2131379237, localObject1);
      }
      localObject2 = new ViewCompat.2(paramOnUnhandledKeyEventListenerCompat);
      ((Map)localObject1).put(paramOnUnhandledKeyEventListenerCompat, localObject2);
      paramView.addOnUnhandledKeyEventListener((View.OnUnhandledKeyEventListener)localObject2);
    }
    do
    {
      return;
      localObject2 = (ArrayList)paramView.getTag(2131379237);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        paramView.setTag(2131379237, localObject1);
      }
      ((ArrayList)localObject1).add(paramOnUnhandledKeyEventListenerCompat);
    } while (((ArrayList)localObject1).size() != 1);
    UnhandledKeyEventManager.registerListeningView(paramView);
  }
  
  @NonNull
  public static ViewPropertyAnimatorCompat animate(@NonNull View paramView)
  {
    if (sViewPropertyAnimatorMap == null) {
      sViewPropertyAnimatorMap = new WeakHashMap();
    }
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2 = (ViewPropertyAnimatorCompat)sViewPropertyAnimatorMap.get(paramView);
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1 = localViewPropertyAnimatorCompat2;
    if (localViewPropertyAnimatorCompat2 == null)
    {
      localViewPropertyAnimatorCompat1 = new ViewPropertyAnimatorCompat(paramView);
      sViewPropertyAnimatorMap.put(paramView, localViewPropertyAnimatorCompat1);
    }
    return localViewPropertyAnimatorCompat1;
  }
  
  private static void bindTempDetach()
  {
    try
    {
      sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
      sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
      sTempDetachBound = true;
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
  
  public static void cancelDragAndDrop(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      paramView.cancelDragAndDrop();
    }
  }
  
  @Deprecated
  public static int combineMeasuredStates(int paramInt1, int paramInt2)
  {
    return View.combineMeasuredStates(paramInt1, paramInt2);
  }
  
  private static void compatOffsetLeftAndRight(View paramView, int paramInt)
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
  
  private static void compatOffsetTopAndBottom(View paramView, int paramInt)
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
  
  public static WindowInsetsCompat dispatchApplyWindowInsets(@NonNull View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    Object localObject = paramWindowInsetsCompat;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindowInsetsCompat = (WindowInsets)WindowInsetsCompat.unwrap(paramWindowInsetsCompat);
      localObject = paramView.dispatchApplyWindowInsets(paramWindowInsetsCompat);
      paramView = paramWindowInsetsCompat;
      if (!((WindowInsets)localObject).equals(paramWindowInsetsCompat)) {
        paramView = new WindowInsets((WindowInsets)localObject);
      }
      localObject = WindowInsetsCompat.wrap(paramView);
    }
    return localObject;
  }
  
  public static void dispatchFinishTemporaryDetach(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramView.dispatchFinishTemporaryDetach();
      return;
    }
    if (!sTempDetachBound) {
      bindTempDetach();
    }
    if (sDispatchFinishTemporaryDetach != null) {
      try
      {
        sDispatchFinishTemporaryDetach.invoke(paramView, new Object[0]);
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
  
  public static boolean dispatchNestedFling(@NonNull View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    }
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    }
    return false;
  }
  
  public static boolean dispatchNestedPreFling(@NonNull View paramView, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.dispatchNestedPreFling(paramFloat1, paramFloat2);
    }
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).dispatchNestedPreFling(paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public static boolean dispatchNestedPreScroll(@NonNull View paramView, int paramInt1, int paramInt2, @Nullable int[] paramArrayOfInt1, @Nullable int[] paramArrayOfInt2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    }
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    }
    return false;
  }
  
  public static boolean dispatchNestedPreScroll(@NonNull View paramView, int paramInt1, int paramInt2, @Nullable int[] paramArrayOfInt1, @Nullable int[] paramArrayOfInt2, int paramInt3)
  {
    if ((paramView instanceof NestedScrollingChild2)) {
      return ((NestedScrollingChild2)paramView).dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
    }
    if (paramInt3 == 0) {
      return dispatchNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    }
    return false;
  }
  
  public static void dispatchNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable int[] paramArrayOfInt1, int paramInt5, @NonNull int[] paramArrayOfInt2)
  {
    if ((paramView instanceof NestedScrollingChild3))
    {
      ((NestedScrollingChild3)paramView).dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt1, paramInt5, paramArrayOfInt2);
      return;
    }
    dispatchNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt1, paramInt5);
  }
  
  public static boolean dispatchNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable int[] paramArrayOfInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    }
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    }
    return false;
  }
  
  public static boolean dispatchNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable int[] paramArrayOfInt, int paramInt5)
  {
    if ((paramView instanceof NestedScrollingChild2)) {
      return ((NestedScrollingChild2)paramView).dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
    }
    if (paramInt5 == 0) {
      return dispatchNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    }
    return false;
  }
  
  public static void dispatchStartTemporaryDetach(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramView.dispatchStartTemporaryDetach();
      return;
    }
    if (!sTempDetachBound) {
      bindTempDetach();
    }
    if (sDispatchStartTemporaryDetach != null) {
      try
      {
        sDispatchStartTemporaryDetach.invoke(paramView, new Object[0]);
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
  
  @UiThread
  static boolean dispatchUnhandledKeyEventBeforeCallback(View paramView, KeyEvent paramKeyEvent)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return false;
    }
    return UnhandledKeyEventManager.at(paramView).dispatch(paramView, paramKeyEvent);
  }
  
  @UiThread
  static boolean dispatchUnhandledKeyEventBeforeHierarchy(View paramView, KeyEvent paramKeyEvent)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return false;
    }
    return UnhandledKeyEventManager.at(paramView).preDispatch(paramKeyEvent);
  }
  
  public static void enableAccessibleClickableSpanSupport(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      getOrCreateAccessibilityDelegateCompat(paramView);
    }
  }
  
  public static int generateViewId()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return View.generateViewId();
    }
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
  
  @Nullable
  public static AccessibilityDelegateCompat getAccessibilityDelegate(@NonNull View paramView)
  {
    paramView = getAccessibilityDelegateInternal(paramView);
    if (paramView == null) {
      return null;
    }
    if ((paramView instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
      return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter)paramView).mCompat;
    }
    return new AccessibilityDelegateCompat(paramView);
  }
  
  /* Error */
  @Nullable
  private static android.view.View.AccessibilityDelegate getAccessibilityDelegateInternal(@NonNull View paramView)
  {
    // Byte code:
    //   0: getstatic 124	androidx/core/view/ViewCompat:sAccessibilityDelegateCheckFailed	Z
    //   3: ifeq +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: getstatic 490	androidx/core/view/ViewCompat:sAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   11: ifnonnull +21 -> 32
    //   14: ldc 227
    //   16: ldc_w 492
    //   19: invokevirtual 496	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   22: putstatic 490	androidx/core/view/ViewCompat:sAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   25: getstatic 490	androidx/core/view/ViewCompat:sAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   28: iconst_1
    //   29: invokevirtual 502	java/lang/reflect/Field:setAccessible	(Z)V
    //   32: getstatic 490	androidx/core/view/ViewCompat:sAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   35: aload_0
    //   36: invokevirtual 503	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: astore_0
    //   40: aload_0
    //   41: instanceof 505
    //   44: ifeq +17 -> 61
    //   47: aload_0
    //   48: checkcast 505	android/view/View$AccessibilityDelegate
    //   51: astore_0
    //   52: aload_0
    //   53: areturn
    //   54: astore_0
    //   55: iconst_1
    //   56: putstatic 124	androidx/core/view/ViewCompat:sAccessibilityDelegateCheckFailed	Z
    //   59: aconst_null
    //   60: areturn
    //   61: aconst_null
    //   62: areturn
    //   63: astore_0
    //   64: iconst_1
    //   65: putstatic 124	androidx/core/view/ViewCompat:sAccessibilityDelegateCheckFailed	Z
    //   68: aconst_null
    //   69: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramView	View
    // Exception table:
    //   from	to	target	type
    //   14	32	54	java/lang/Throwable
    //   32	52	63	java/lang/Throwable
  }
  
  public static int getAccessibilityLiveRegion(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramView.getAccessibilityLiveRegion();
    }
    return 0;
  }
  
  public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView = paramView.getAccessibilityNodeProvider();
      if (paramView != null) {
        return new AccessibilityNodeProviderCompat(paramView);
      }
    }
    return null;
  }
  
  @UiThread
  public static CharSequence getAccessibilityPaneTitle(View paramView)
  {
    return (CharSequence)paneTitleProperty().get(paramView);
  }
  
  private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View paramView)
  {
    ArrayList localArrayList2 = (ArrayList)paramView.getTag(2131379189);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      paramView.setTag(2131379189, localArrayList1);
    }
    return localArrayList1;
  }
  
  @Deprecated
  public static float getAlpha(View paramView)
  {
    return paramView.getAlpha();
  }
  
  private static int getAvailableActionIdFromResources(View paramView)
  {
    paramView = getActionList(paramView);
    int i = 0;
    int j = -1;
    while ((i < ACCESSIBILITY_ACTIONS_RESOURCE_IDS.length) && (j == -1))
    {
      int i1 = ACCESSIBILITY_ACTIONS_RESOURCE_IDS[i];
      int m = 0;
      int k = 1;
      if (m < paramView.size())
      {
        if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat)paramView.get(m)).getId() != i1) {}
        for (int n = 1;; n = 0)
        {
          k &= n;
          m += 1;
          break;
        }
      }
      if (k != 0) {
        j = i1;
      }
      i += 1;
    }
    return j;
  }
  
  public static ColorStateList getBackgroundTintList(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getBackgroundTintList();
    }
    if ((paramView instanceof TintableBackgroundView)) {
      return ((TintableBackgroundView)paramView).getSupportBackgroundTintList();
    }
    return null;
  }
  
  public static PorterDuff.Mode getBackgroundTintMode(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getBackgroundTintMode();
    }
    if ((paramView instanceof TintableBackgroundView)) {
      return ((TintableBackgroundView)paramView).getSupportBackgroundTintMode();
    }
    return null;
  }
  
  @Nullable
  public static Rect getClipBounds(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramView.getClipBounds();
    }
    return null;
  }
  
  @Nullable
  public static Display getDisplay(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getDisplay();
    }
    if (isAttachedToWindow(paramView)) {
      return ((WindowManager)paramView.getContext().getSystemService("window")).getDefaultDisplay();
    }
    return null;
  }
  
  public static float getElevation(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getElevation();
    }
    return 0.0F;
  }
  
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
  
  public static boolean getFitsSystemWindows(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getFitsSystemWindows();
    }
    return false;
  }
  
  public static int getImportantForAccessibility(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getImportantForAccessibility();
    }
    return 0;
  }
  
  @SuppressLint({"InlinedApi"})
  public static int getImportantForAutofill(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.getImportantForAutofill();
    }
    return 0;
  }
  
  public static int getLabelFor(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getLabelFor();
    }
    return 0;
  }
  
  @Deprecated
  public static int getLayerType(View paramView)
  {
    return paramView.getLayerType();
  }
  
  public static int getLayoutDirection(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getLayoutDirection();
    }
    return 0;
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
  
  public static int getMinimumHeight(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getMinimumHeight();
    }
    if (!sMinHeightFieldFetched) {}
    try
    {
      sMinHeightField = View.class.getDeclaredField("mMinHeight");
      sMinHeightField.setAccessible(true);
      label37:
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
      break label37;
    }
  }
  
  public static int getMinimumWidth(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getMinimumWidth();
    }
    if (!sMinWidthFieldFetched) {}
    try
    {
      sMinWidthField = View.class.getDeclaredField("mMinWidth");
      sMinWidthField.setAccessible(true);
      label37:
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
      break label37;
    }
  }
  
  public static int getNextClusterForwardId(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.getNextClusterForwardId();
    }
    return -1;
  }
  
  static AccessibilityDelegateCompat getOrCreateAccessibilityDelegateCompat(@NonNull View paramView)
  {
    AccessibilityDelegateCompat localAccessibilityDelegateCompat2 = getAccessibilityDelegate(paramView);
    AccessibilityDelegateCompat localAccessibilityDelegateCompat1 = localAccessibilityDelegateCompat2;
    if (localAccessibilityDelegateCompat2 == null) {
      localAccessibilityDelegateCompat1 = new AccessibilityDelegateCompat();
    }
    setAccessibilityDelegate(paramView, localAccessibilityDelegateCompat1);
    return localAccessibilityDelegateCompat1;
  }
  
  @Deprecated
  public static int getOverScrollMode(View paramView)
  {
    return paramView.getOverScrollMode();
  }
  
  @Px
  public static int getPaddingEnd(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getPaddingEnd();
    }
    return paramView.getPaddingRight();
  }
  
  @Px
  public static int getPaddingStart(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getPaddingStart();
    }
    return paramView.getPaddingLeft();
  }
  
  public static ViewParent getParentForAccessibility(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getParentForAccessibility();
    }
    return paramView.getParent();
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
    if (Build.VERSION.SDK_INT >= 23) {
      return paramView.getScrollIndicators();
    }
    return 0;
  }
  
  @Nullable
  public static String getTransitionName(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getTransitionName();
    }
    if (sTransitionNameMap == null) {
      return null;
    }
    return (String)sTransitionNameMap.get(paramView);
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
  
  public static float getTranslationZ(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getTranslationZ();
    }
    return 0.0F;
  }
  
  public static int getWindowSystemUiVisibility(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.getWindowSystemUiVisibility();
    }
    return 0;
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
  
  public static float getZ(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getZ();
    }
    return 0.0F;
  }
  
  public static boolean hasAccessibilityDelegate(@NonNull View paramView)
  {
    return getAccessibilityDelegateInternal(paramView) != null;
  }
  
  public static boolean hasExplicitFocusable(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.hasExplicitFocusable();
    }
    return paramView.hasFocusable();
  }
  
  public static boolean hasNestedScrollingParent(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.hasNestedScrollingParent();
    }
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).hasNestedScrollingParent();
    }
    return false;
  }
  
  public static boolean hasNestedScrollingParent(@NonNull View paramView, int paramInt)
  {
    if ((paramView instanceof NestedScrollingChild2)) {
      ((NestedScrollingChild2)paramView).hasNestedScrollingParent(paramInt);
    }
    while (paramInt != 0) {
      return false;
    }
    return hasNestedScrollingParent(paramView);
  }
  
  public static boolean hasOnClickListeners(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 15) {
      return paramView.hasOnClickListeners();
    }
    return false;
  }
  
  public static boolean hasOverlappingRendering(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.hasOverlappingRendering();
    }
    return true;
  }
  
  public static boolean hasTransientState(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.hasTransientState();
    }
    return false;
  }
  
  @UiThread
  public static boolean isAccessibilityHeading(View paramView)
  {
    paramView = (Boolean)accessibilityHeadingProperty().get(paramView);
    if (paramView == null) {
      return false;
    }
    return paramView.booleanValue();
  }
  
  public static boolean isAttachedToWindow(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramView.isAttachedToWindow();
    }
    return paramView.getWindowToken() != null;
  }
  
  public static boolean isFocusedByDefault(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.isFocusedByDefault();
    }
    return false;
  }
  
  public static boolean isImportantForAccessibility(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.isImportantForAccessibility();
    }
    return true;
  }
  
  public static boolean isImportantForAutofill(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.isImportantForAutofill();
    }
    return true;
  }
  
  public static boolean isInLayout(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramView.isInLayout();
    }
    return false;
  }
  
  public static boolean isKeyboardNavigationCluster(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.isKeyboardNavigationCluster();
    }
    return false;
  }
  
  public static boolean isLaidOut(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramView.isLaidOut();
    }
    return (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
  }
  
  public static boolean isLayoutDirectionResolved(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramView.isLayoutDirectionResolved();
    }
    return false;
  }
  
  public static boolean isNestedScrollingEnabled(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.isNestedScrollingEnabled();
    }
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).isNestedScrollingEnabled();
    }
    return false;
  }
  
  @Deprecated
  public static boolean isOpaque(View paramView)
  {
    return paramView.isOpaque();
  }
  
  public static boolean isPaddingRelative(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.isPaddingRelative();
    }
    return false;
  }
  
  @UiThread
  public static boolean isScreenReaderFocusable(View paramView)
  {
    paramView = (Boolean)screenReaderFocusableProperty().get(paramView);
    if (paramView == null) {
      return false;
    }
    return paramView.booleanValue();
  }
  
  @Deprecated
  public static void jumpDrawablesToCurrentState(View paramView)
  {
    paramView.jumpDrawablesToCurrentState();
  }
  
  public static View keyboardNavigationClusterSearch(@NonNull View paramView1, View paramView2, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView1.keyboardNavigationClusterSearch(paramView2, paramInt);
    }
    return null;
  }
  
  @RequiresApi(19)
  static void notifyViewAccessibilityStateChangedIfNeeded(View paramView, int paramInt)
  {
    if (!((AccessibilityManager)paramView.getContext().getSystemService("accessibility")).isEnabled()) {}
    label79:
    do
    {
      return;
      AccessibilityEvent localAccessibilityEvent;
      if (getAccessibilityPaneTitle(paramView) != null)
      {
        i = 1;
        if ((getAccessibilityLiveRegion(paramView) == 0) && ((i == 0) || (paramView.getVisibility() != 0))) {
          continue;
        }
        localAccessibilityEvent = AccessibilityEvent.obtain();
        if (i == 0) {
          break label79;
        }
      }
      for (int i = 32;; i = 2048)
      {
        localAccessibilityEvent.setEventType(i);
        localAccessibilityEvent.setContentChangeTypes(paramInt);
        paramView.sendAccessibilityEventUnchecked(localAccessibilityEvent);
        return;
        i = 0;
        break;
      }
    } while (paramView.getParent() == null);
    try
    {
      paramView.getParent().notifySubtreeAccessibilityStateChanged(paramView, paramView, paramInt);
      return;
    }
    catch (AbstractMethodError localAbstractMethodError)
    {
      Log.e("ViewCompat", paramView.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", localAbstractMethodError);
    }
  }
  
  public static void offsetLeftAndRight(@NonNull View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView.offsetLeftAndRight(paramInt);
      return;
    }
    Rect localRect;
    ViewParent localViewParent;
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localRect = getEmptyTempRect();
      localViewParent = paramView.getParent();
      if (!(localViewParent instanceof View)) {
        break label149;
      }
      View localView = (View)localViewParent;
      localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
        i = 1;
      }
    }
    for (;;)
    {
      compatOffsetLeftAndRight(paramView, paramInt);
      if ((i == 0) || (!localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        break;
      }
      ((View)localViewParent).invalidate(localRect);
      return;
      i = 0;
      continue;
      compatOffsetLeftAndRight(paramView, paramInt);
      return;
      label149:
      i = 0;
    }
  }
  
  public static void offsetTopAndBottom(@NonNull View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView.offsetTopAndBottom(paramInt);
      return;
    }
    Rect localRect;
    ViewParent localViewParent;
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localRect = getEmptyTempRect();
      localViewParent = paramView.getParent();
      if (!(localViewParent instanceof View)) {
        break label149;
      }
      View localView = (View)localViewParent;
      localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
        i = 1;
      }
    }
    for (;;)
    {
      compatOffsetTopAndBottom(paramView, paramInt);
      if ((i == 0) || (!localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        break;
      }
      ((View)localViewParent).invalidate(localRect);
      return;
      i = 0;
      continue;
      compatOffsetTopAndBottom(paramView, paramInt);
      return;
      label149:
      i = 0;
    }
  }
  
  public static WindowInsetsCompat onApplyWindowInsets(@NonNull View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    Object localObject = paramWindowInsetsCompat;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindowInsetsCompat = (WindowInsets)WindowInsetsCompat.unwrap(paramWindowInsetsCompat);
      localObject = paramView.onApplyWindowInsets(paramWindowInsetsCompat);
      paramView = paramWindowInsetsCompat;
      if (!((WindowInsets)localObject).equals(paramWindowInsetsCompat)) {
        paramView = new WindowInsets((WindowInsets)localObject);
      }
      localObject = WindowInsetsCompat.wrap(paramView);
    }
    return localObject;
  }
  
  @Deprecated
  public static void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    paramView.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public static void onInitializeAccessibilityNodeInfo(@NonNull View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    paramView.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfoCompat.unwrap());
  }
  
  @Deprecated
  public static void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    paramView.onPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  private static AccessibilityViewProperty<CharSequence> paneTitleProperty()
  {
    return new ViewCompat.4(2131379192, CharSequence.class, 8, 28);
  }
  
  public static boolean performAccessibilityAction(@NonNull View paramView, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramView.performAccessibilityAction(paramInt, paramBundle);
    }
    return false;
  }
  
  public static void postInvalidateOnAnimation(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postInvalidateOnAnimation();
      return;
    }
    paramView.postInvalidate();
  }
  
  public static void postInvalidateOnAnimation(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postInvalidateOnAnimation(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    paramView.postInvalidate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void postOnAnimation(@NonNull View paramView, Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postOnAnimation(paramRunnable);
      return;
    }
    paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay());
  }
  
  public static void postOnAnimationDelayed(@NonNull View paramView, Runnable paramRunnable, long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postOnAnimationDelayed(paramRunnable, paramLong);
      return;
    }
    paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay() + paramLong);
  }
  
  public static void removeAccessibilityAction(@NonNull View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      removeActionWithId(paramInt, paramView);
      notifyViewAccessibilityStateChangedIfNeeded(paramView, 0);
    }
  }
  
  private static void removeActionWithId(int paramInt, View paramView)
  {
    paramView = getActionList(paramView);
    int i = 0;
    for (;;)
    {
      if (i < paramView.size())
      {
        if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat)paramView.get(i)).getId() == paramInt) {
          paramView.remove(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public static void removeOnUnhandledKeyEventListener(@NonNull View paramView, @NonNull OnUnhandledKeyEventListenerCompat paramOnUnhandledKeyEventListenerCompat)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject = (Map)paramView.getTag(2131379237);
      if (localObject != null) {}
    }
    do
    {
      do
      {
        do
        {
          return;
          paramOnUnhandledKeyEventListenerCompat = (View.OnUnhandledKeyEventListener)((Map)localObject).get(paramOnUnhandledKeyEventListenerCompat);
        } while (paramOnUnhandledKeyEventListenerCompat == null);
        paramView.removeOnUnhandledKeyEventListener(paramOnUnhandledKeyEventListenerCompat);
        return;
        localObject = (ArrayList)paramView.getTag(2131379237);
      } while (localObject == null);
      ((ArrayList)localObject).remove(paramOnUnhandledKeyEventListenerCompat);
    } while (((ArrayList)localObject).size() != 0);
    UnhandledKeyEventManager.unregisterListeningView(paramView);
  }
  
  public static void replaceAccessibilityAction(@NonNull View paramView, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat paramAccessibilityActionCompat, @Nullable CharSequence paramCharSequence, @Nullable AccessibilityViewCommand paramAccessibilityViewCommand)
  {
    addAccessibilityAction(paramView, paramAccessibilityActionCompat.createReplacementAction(paramCharSequence, paramAccessibilityViewCommand));
  }
  
  public static void requestApplyInsets(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      paramView.requestApplyInsets();
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    paramView.requestFitSystemWindows();
  }
  
  @NonNull
  public static <T extends View> T requireViewById(@NonNull View paramView, @IdRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      paramView = paramView.requireViewById(paramInt);
    }
    View localView;
    do
    {
      return paramView;
      localView = paramView.findViewById(paramInt);
      paramView = localView;
    } while (localView != null);
    throw new IllegalArgumentException("ID does not reference a View inside this View");
  }
  
  @Deprecated
  public static int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    return View.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
  }
  
  public static boolean restoreDefaultFocus(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.restoreDefaultFocus();
    }
    return paramView.requestFocus();
  }
  
  private static AccessibilityViewProperty<Boolean> screenReaderFocusableProperty()
  {
    return new ViewCompat.3(2131379227, Boolean.class, 28);
  }
  
  public static void setAccessibilityDelegate(@NonNull View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    AccessibilityDelegateCompat localAccessibilityDelegateCompat = paramAccessibilityDelegateCompat;
    if (paramAccessibilityDelegateCompat == null)
    {
      localAccessibilityDelegateCompat = paramAccessibilityDelegateCompat;
      if ((getAccessibilityDelegateInternal(paramView) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
        localAccessibilityDelegateCompat = new AccessibilityDelegateCompat();
      }
    }
    if (localAccessibilityDelegateCompat == null) {}
    for (paramAccessibilityDelegateCompat = null;; paramAccessibilityDelegateCompat = localAccessibilityDelegateCompat.getBridge())
    {
      paramView.setAccessibilityDelegate(paramAccessibilityDelegateCompat);
      return;
    }
  }
  
  @UiThread
  public static void setAccessibilityHeading(View paramView, boolean paramBoolean)
  {
    accessibilityHeadingProperty().set(paramView, Boolean.valueOf(paramBoolean));
  }
  
  public static void setAccessibilityLiveRegion(@NonNull View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramView.setAccessibilityLiveRegion(paramInt);
    }
  }
  
  @UiThread
  public static void setAccessibilityPaneTitle(View paramView, CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      paneTitleProperty().set(paramView, paramCharSequence);
      if (paramCharSequence != null) {
        sAccessibilityPaneVisibilityManager.addAccessibilityPane(paramView);
      }
    }
    else
    {
      return;
    }
    sAccessibilityPaneVisibilityManager.removeAccessibilityPane(paramView);
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
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setAutofillHints(paramVarArgs);
    }
  }
  
  public static void setBackground(@NonNull View paramView, @Nullable Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(paramDrawable);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public static void setBackgroundTintList(@NonNull View paramView, ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setBackgroundTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramColorStateList = paramView.getBackground();
        if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null)) {
          break label72;
        }
        i = 1;
        if ((paramColorStateList != null) && (i != 0))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramView.getDrawableState());
          }
          paramView.setBackground(paramColorStateList);
        }
      }
    }
    label72:
    while (!(paramView instanceof TintableBackgroundView)) {
      for (;;)
      {
        return;
        int i = 0;
      }
    }
    ((TintableBackgroundView)paramView).setSupportBackgroundTintList(paramColorStateList);
  }
  
  public static void setBackgroundTintMode(@NonNull View paramView, PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setBackgroundTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramMode = paramView.getBackground();
        if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null)) {
          break label72;
        }
        i = 1;
        if ((paramMode != null) && (i != 0))
        {
          if (paramMode.isStateful()) {
            paramMode.setState(paramView.getDrawableState());
          }
          paramView.setBackground(paramMode);
        }
      }
    }
    label72:
    while (!(paramView instanceof TintableBackgroundView)) {
      for (;;)
      {
        return;
        int i = 0;
      }
    }
    ((TintableBackgroundView)paramView).setSupportBackgroundTintMode(paramMode);
  }
  
  @Deprecated
  public static void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
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
  
  public static void setClipBounds(@NonNull View paramView, Rect paramRect)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      paramView.setClipBounds(paramRect);
    }
  }
  
  public static void setElevation(@NonNull View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setElevation(paramFloat);
    }
  }
  
  @Deprecated
  public static void setFitsSystemWindows(View paramView, boolean paramBoolean)
  {
    paramView.setFitsSystemWindows(paramBoolean);
  }
  
  public static void setFocusedByDefault(@NonNull View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setFocusedByDefault(paramBoolean);
    }
  }
  
  public static void setHasTransientState(@NonNull View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramView.setHasTransientState(paramBoolean);
    }
  }
  
  public static void setImportantForAccessibility(@NonNull View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramView.setImportantForAccessibility(paramInt);
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    int i = paramInt;
    if (paramInt == 4) {
      i = 2;
    }
    paramView.setImportantForAccessibility(i);
  }
  
  public static void setImportantForAutofill(@NonNull View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setImportantForAutofill(paramInt);
    }
  }
  
  public static void setKeyboardNavigationCluster(@NonNull View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setKeyboardNavigationCluster(paramBoolean);
    }
  }
  
  public static void setLabelFor(@NonNull View paramView, @IdRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      paramView.setLabelFor(paramInt);
    }
  }
  
  public static void setLayerPaint(@NonNull View paramView, Paint paramPaint)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramView.setLayerPaint(paramPaint);
      return;
    }
    paramView.setLayerType(paramView.getLayerType(), paramPaint);
    paramView.invalidate();
  }
  
  @Deprecated
  public static void setLayerType(View paramView, int paramInt, Paint paramPaint)
  {
    paramView.setLayerType(paramInt, paramPaint);
  }
  
  public static void setLayoutDirection(@NonNull View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      paramView.setLayoutDirection(paramInt);
    }
  }
  
  public static void setNestedScrollingEnabled(@NonNull View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setNestedScrollingEnabled(paramBoolean);
    }
    while (!(paramView instanceof NestedScrollingChild)) {
      return;
    }
    ((NestedScrollingChild)paramView).setNestedScrollingEnabled(paramBoolean);
  }
  
  public static void setNextClusterForwardId(@NonNull View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setNextClusterForwardId(paramInt);
    }
  }
  
  public static void setOnApplyWindowInsetsListener(@NonNull View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramOnApplyWindowInsetsListener == null) {
        paramView.setOnApplyWindowInsetsListener(null);
      }
    }
    else {
      return;
    }
    paramView.setOnApplyWindowInsetsListener(new ViewCompat.1(paramOnApplyWindowInsetsListener));
  }
  
  @Deprecated
  public static void setOverScrollMode(View paramView, int paramInt)
  {
    paramView.setOverScrollMode(paramInt);
  }
  
  public static void setPaddingRelative(@NonNull View paramView, @Px int paramInt1, @Px int paramInt2, @Px int paramInt3, @Px int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramView.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
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
    if (Build.VERSION.SDK_INT >= 24) {
      if (paramPointerIconCompat == null) {
        break label29;
      }
    }
    label29:
    for (paramPointerIconCompat = paramPointerIconCompat.getPointerIcon();; paramPointerIconCompat = null)
    {
      paramView.setPointerIcon((PointerIcon)paramPointerIconCompat);
      return;
    }
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
  
  @UiThread
  public static void setScreenReaderFocusable(View paramView, boolean paramBoolean)
  {
    screenReaderFocusableProperty().set(paramView, Boolean.valueOf(paramBoolean));
  }
  
  public static void setScrollIndicators(@NonNull View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramView.setScrollIndicators(paramInt);
    }
  }
  
  public static void setScrollIndicators(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramView.setScrollIndicators(paramInt1, paramInt2);
    }
  }
  
  public static void setTooltipText(@NonNull View paramView, @Nullable CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setTooltipText(paramCharSequence);
    }
  }
  
  public static void setTransitionName(@NonNull View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setTransitionName(paramString);
      return;
    }
    if (sTransitionNameMap == null) {
      sTransitionNameMap = new WeakHashMap();
    }
    sTransitionNameMap.put(paramView, paramString);
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
  
  public static void setTranslationZ(@NonNull View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setTranslationZ(paramFloat);
    }
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
  
  public static void setZ(@NonNull View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setZ(paramFloat);
    }
  }
  
  public static boolean startDragAndDrop(@NonNull View paramView, ClipData paramClipData, View.DragShadowBuilder paramDragShadowBuilder, Object paramObject, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return paramView.startDragAndDrop(paramClipData, paramDragShadowBuilder, paramObject, paramInt);
    }
    return paramView.startDrag(paramClipData, paramDragShadowBuilder, paramObject, paramInt);
  }
  
  public static boolean startNestedScroll(@NonNull View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.startNestedScroll(paramInt);
    }
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).startNestedScroll(paramInt);
    }
    return false;
  }
  
  public static boolean startNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView instanceof NestedScrollingChild2)) {
      return ((NestedScrollingChild2)paramView).startNestedScroll(paramInt1, paramInt2);
    }
    if (paramInt2 == 0) {
      return startNestedScroll(paramView, paramInt1);
    }
    return false;
  }
  
  public static void stopNestedScroll(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.stopNestedScroll();
    }
    while (!(paramView instanceof NestedScrollingChild)) {
      return;
    }
    ((NestedScrollingChild)paramView).stopNestedScroll();
  }
  
  public static void stopNestedScroll(@NonNull View paramView, int paramInt)
  {
    if ((paramView instanceof NestedScrollingChild2)) {
      ((NestedScrollingChild2)paramView).stopNestedScroll(paramInt);
    }
    while (paramInt != 0) {
      return;
    }
    stopNestedScroll(paramView);
  }
  
  private static void tickleInvalidationFlag(View paramView)
  {
    float f = paramView.getTranslationY();
    paramView.setTranslationY(1.0F + f);
    paramView.setTranslationY(f);
  }
  
  public static void updateDragShadow(@NonNull View paramView, View.DragShadowBuilder paramDragShadowBuilder)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      paramView.updateDragShadow(paramDragShadowBuilder);
    }
  }
  
  static class AccessibilityPaneVisibilityManager
    implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener
  {
    private WeakHashMap<View, Boolean> mPanesToVisible = new WeakHashMap();
    
    @RequiresApi(19)
    private void checkPaneVisibility(View paramView, boolean paramBoolean)
    {
      if (paramView.getVisibility() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (paramBoolean != bool)
        {
          if (bool) {
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(paramView, 16);
          }
          this.mPanesToVisible.put(paramView, Boolean.valueOf(bool));
        }
        return;
      }
    }
    
    @RequiresApi(19)
    private void registerForLayoutCallback(View paramView)
    {
      paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
    
    @RequiresApi(19)
    private void unregisterForLayoutCallback(View paramView)
    {
      paramView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    
    @RequiresApi(19)
    void addAccessibilityPane(View paramView)
    {
      WeakHashMap localWeakHashMap = this.mPanesToVisible;
      if (paramView.getVisibility() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localWeakHashMap.put(paramView, Boolean.valueOf(bool));
        paramView.addOnAttachStateChangeListener(this);
        if (paramView.isAttachedToWindow()) {
          registerForLayoutCallback(paramView);
        }
        return;
      }
    }
    
    @RequiresApi(19)
    public void onGlobalLayout()
    {
      Iterator localIterator = this.mPanesToVisible.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        checkPaneVisibility((View)localEntry.getKey(), ((Boolean)localEntry.getValue()).booleanValue());
      }
    }
    
    @RequiresApi(19)
    public void onViewAttachedToWindow(View paramView)
    {
      registerForLayoutCallback(paramView);
    }
    
    public void onViewDetachedFromWindow(View paramView) {}
    
    @RequiresApi(19)
    void removeAccessibilityPane(View paramView)
    {
      this.mPanesToVisible.remove(paramView);
      paramView.removeOnAttachStateChangeListener(this);
      unregisterForLayoutCallback(paramView);
    }
  }
  
  static abstract class AccessibilityViewProperty<T>
  {
    private final int mContentChangeType;
    private final int mFrameworkMinimumSdk;
    private final int mTagKey;
    private final Class<T> mType;
    
    AccessibilityViewProperty(int paramInt1, Class<T> paramClass, int paramInt2)
    {
      this(paramInt1, paramClass, 0, paramInt2);
    }
    
    AccessibilityViewProperty(int paramInt1, Class<T> paramClass, int paramInt2, int paramInt3)
    {
      this.mTagKey = paramInt1;
      this.mType = paramClass;
      this.mContentChangeType = paramInt2;
      this.mFrameworkMinimumSdk = paramInt3;
    }
    
    private boolean extrasAvailable()
    {
      return Build.VERSION.SDK_INT >= 19;
    }
    
    private boolean frameworkAvailable()
    {
      return Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk;
    }
    
    boolean booleanNullToFalseEquals(Boolean paramBoolean1, Boolean paramBoolean2)
    {
      boolean bool3 = false;
      boolean bool1;
      if (paramBoolean1 == null)
      {
        bool1 = false;
        if (paramBoolean2 != null) {
          break label36;
        }
      }
      label36:
      for (boolean bool2 = false;; bool2 = paramBoolean2.booleanValue())
      {
        if (bool1 == bool2) {
          bool3 = true;
        }
        return bool3;
        bool1 = paramBoolean1.booleanValue();
        break;
      }
    }
    
    abstract T frameworkGet(View paramView);
    
    abstract void frameworkSet(View paramView, T paramT);
    
    T get(View paramView)
    {
      if (frameworkAvailable()) {
        paramView = frameworkGet(paramView);
      }
      Object localObject;
      do
      {
        return paramView;
        if (!extrasAvailable()) {
          break;
        }
        localObject = paramView.getTag(this.mTagKey);
        paramView = localObject;
      } while (this.mType.isInstance(localObject));
      return null;
    }
    
    void set(View paramView, T paramT)
    {
      if (frameworkAvailable()) {
        frameworkSet(paramView, paramT);
      }
      while ((!extrasAvailable()) || (!shouldUpdate(get(paramView), paramT))) {
        return;
      }
      ViewCompat.getOrCreateAccessibilityDelegateCompat(paramView);
      paramView.setTag(this.mTagKey, paramT);
      ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(paramView, 0);
    }
    
    boolean shouldUpdate(T paramT1, T paramT2)
    {
      return !paramT2.equals(paramT1);
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface FocusDirection {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface FocusRealDirection {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface FocusRelativeDirection {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface NestedScrollType {}
  
  public static abstract interface OnUnhandledKeyEventListenerCompat
  {
    public abstract boolean onUnhandledKeyEvent(View paramView, KeyEvent paramKeyEvent);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface ScrollAxis {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface ScrollIndicators {}
  
  static class UnhandledKeyEventManager
  {
    private static final ArrayList<WeakReference<View>> sViewsWithListeners = new ArrayList();
    private SparseArray<WeakReference<View>> mCapturedKeys = null;
    private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;
    @Nullable
    private WeakHashMap<View, Boolean> mViewsContainingListeners = null;
    
    static UnhandledKeyEventManager at(View paramView)
    {
      UnhandledKeyEventManager localUnhandledKeyEventManager2 = (UnhandledKeyEventManager)paramView.getTag(2131379236);
      UnhandledKeyEventManager localUnhandledKeyEventManager1 = localUnhandledKeyEventManager2;
      if (localUnhandledKeyEventManager2 == null)
      {
        localUnhandledKeyEventManager1 = new UnhandledKeyEventManager();
        paramView.setTag(2131379236, localUnhandledKeyEventManager1);
      }
      return localUnhandledKeyEventManager1;
    }
    
    @Nullable
    private View dispatchInOrder(View paramView, KeyEvent paramKeyEvent)
    {
      Object localObject;
      if ((this.mViewsContainingListeners == null) || (!this.mViewsContainingListeners.containsKey(paramView))) {
        localObject = null;
      }
      do
      {
        return localObject;
        if ((paramView instanceof ViewGroup))
        {
          localObject = (ViewGroup)paramView;
          int i = ((ViewGroup)localObject).getChildCount() - 1;
          while (i >= 0)
          {
            View localView = dispatchInOrder(((ViewGroup)localObject).getChildAt(i), paramKeyEvent);
            if (localView != null) {
              return localView;
            }
            i -= 1;
          }
        }
        localObject = paramView;
      } while (onUnhandledKeyEvent(paramView, paramKeyEvent));
      return null;
    }
    
    private SparseArray<WeakReference<View>> getCapturedKeys()
    {
      if (this.mCapturedKeys == null) {
        this.mCapturedKeys = new SparseArray();
      }
      return this.mCapturedKeys;
    }
    
    private boolean onUnhandledKeyEvent(@NonNull View paramView, @NonNull KeyEvent paramKeyEvent)
    {
      ArrayList localArrayList = (ArrayList)paramView.getTag(2131379237);
      if (localArrayList != null)
      {
        int i = localArrayList.size() - 1;
        while (i >= 0)
        {
          if (((ViewCompat.OnUnhandledKeyEventListenerCompat)localArrayList.get(i)).onUnhandledKeyEvent(paramView, paramKeyEvent)) {
            return true;
          }
          i -= 1;
        }
      }
      return false;
    }
    
    private void recalcViewsWithUnhandled()
    {
      if (this.mViewsContainingListeners != null) {
        this.mViewsContainingListeners.clear();
      }
      if (sViewsWithListeners.isEmpty()) {
        return;
      }
      for (;;)
      {
        int i;
        synchronized (sViewsWithListeners)
        {
          if (this.mViewsContainingListeners == null) {
            this.mViewsContainingListeners = new WeakHashMap();
          }
          i = sViewsWithListeners.size() - 1;
          if (i >= 0)
          {
            Object localObject1 = (View)((WeakReference)sViewsWithListeners.get(i)).get();
            if (localObject1 == null)
            {
              sViewsWithListeners.remove(i);
            }
            else
            {
              this.mViewsContainingListeners.put(localObject1, Boolean.TRUE);
              localObject1 = ((View)localObject1).getParent();
              if ((localObject1 instanceof View))
              {
                this.mViewsContainingListeners.put((View)localObject1, Boolean.TRUE);
                localObject1 = ((ViewParent)localObject1).getParent();
                continue;
              }
            }
          }
          else
          {
            return;
          }
        }
        i -= 1;
      }
    }
    
    static void registerListeningView(View paramView)
    {
      synchronized (sViewsWithListeners)
      {
        Iterator localIterator = sViewsWithListeners.iterator();
        while (localIterator.hasNext()) {
          if (((WeakReference)localIterator.next()).get() == paramView) {
            return;
          }
        }
        sViewsWithListeners.add(new WeakReference(paramView));
        return;
      }
    }
    
    static void unregisterListeningView(View paramView)
    {
      ArrayList localArrayList = sViewsWithListeners;
      int i = 0;
      for (;;)
      {
        try
        {
          if (i < sViewsWithListeners.size())
          {
            if (((WeakReference)sViewsWithListeners.get(i)).get() == paramView) {
              sViewsWithListeners.remove(i);
            }
          }
          else {
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    boolean dispatch(View paramView, KeyEvent paramKeyEvent)
    {
      if (paramKeyEvent.getAction() == 0) {
        recalcViewsWithUnhandled();
      }
      paramView = dispatchInOrder(paramView, paramKeyEvent);
      if (paramKeyEvent.getAction() == 0)
      {
        int i = paramKeyEvent.getKeyCode();
        if ((paramView != null) && (!KeyEvent.isModifierKey(i))) {
          getCapturedKeys().put(i, new WeakReference(paramView));
        }
      }
      return paramView != null;
    }
    
    boolean preDispatch(KeyEvent paramKeyEvent)
    {
      if ((this.mLastDispatchedPreViewKeyEvent != null) && (this.mLastDispatchedPreViewKeyEvent.get() == paramKeyEvent)) {
        return false;
      }
      this.mLastDispatchedPreViewKeyEvent = new WeakReference(paramKeyEvent);
      Object localObject2 = null;
      SparseArray localSparseArray = getCapturedKeys();
      Object localObject1 = localObject2;
      if (paramKeyEvent.getAction() == 1)
      {
        int i = localSparseArray.indexOfKey(paramKeyEvent.getKeyCode());
        localObject1 = localObject2;
        if (i >= 0)
        {
          localObject1 = (WeakReference)localSparseArray.valueAt(i);
          localSparseArray.removeAt(i);
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (WeakReference)localSparseArray.get(paramKeyEvent.getKeyCode());
      }
      if (localObject2 != null)
      {
        localObject1 = (View)((WeakReference)localObject2).get();
        if ((localObject1 != null) && (ViewCompat.isAttachedToWindow((View)localObject1))) {
          onUnhandledKeyEvent((View)localObject1, paramKeyEvent);
        }
        return true;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.view.ViewCompat
 * JD-Core Version:    0.7.0.1
 */