package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.coreui.R.attr;
import android.support.coreui.R.style;
import android.support.coreui.R.styleable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.NestedScrollingParent2;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.DirectedAcyclicGraph;
import android.support.v4.widget.ViewGroupUtils;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewTreeObserver;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout
  extends ViewGroup
  implements NestedScrollingParent2
{
  static final Class[] CONSTRUCTOR_PARAMS;
  static final int EVENT_NESTED_SCROLL = 1;
  static final int EVENT_PRE_DRAW = 0;
  static final int EVENT_VIEW_REMOVED = 2;
  static final String TAG = "CoordinatorLayout";
  static final Comparator TOP_SORTED_CHILDREN_COMPARATOR;
  private static final int TYPE_ON_INTERCEPT = 0;
  private static final int TYPE_ON_TOUCH = 1;
  static final String WIDGET_PACKAGE_NAME;
  static final ThreadLocal sConstructors;
  private static final Pools.Pool sRectPool;
  private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
  private View mBehaviorTouchView;
  private final DirectedAcyclicGraph mChildDag = new DirectedAcyclicGraph();
  private final List mDependencySortedChildren = new ArrayList();
  private boolean mDisallowInterceptReset;
  private boolean mDrawStatusBarBackground;
  private boolean mIsAttachedToWindow;
  private int[] mKeylines;
  private WindowInsetsCompat mLastInsets;
  private boolean mNeedsPreDrawListener;
  private final NestedScrollingParentHelper mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
  private View mNestedScrollingTarget;
  ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
  private CoordinatorLayout.OnPreDrawListener mOnPreDrawListener;
  private Paint mScrimPaint;
  private Drawable mStatusBarBackground;
  private final List mTempDependenciesList = new ArrayList();
  private final int[] mTempIntPair = new int[2];
  private final List mTempList1 = new ArrayList();
  
  static
  {
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null)
    {
      localObject = ((Package)localObject).getName();
      WIDGET_PACKAGE_NAME = (String)localObject;
      if (Build.VERSION.SDK_INT < 21) {
        break label82;
      }
    }
    label82:
    for (TOP_SORTED_CHILDREN_COMPARATOR = new CoordinatorLayout.ViewElevationComparator();; TOP_SORTED_CHILDREN_COMPARATOR = null)
    {
      CONSTRUCTOR_PARAMS = new Class[] { Context.class, AttributeSet.class };
      sConstructors = new ThreadLocal();
      sRectPool = new Pools.SynchronizedPool(12);
      return;
      localObject = null;
      break;
    }
  }
  
  public CoordinatorLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.coordinatorLayoutStyle);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramInt == 0) {}
    for (paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);; paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout, paramInt, 0))
    {
      paramInt = paramAttributeSet.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
      if (paramInt == 0) {
        break;
      }
      paramContext = paramContext.getResources();
      this.mKeylines = paramContext.getIntArray(paramInt);
      float f = paramContext.getDisplayMetrics().density;
      int j = this.mKeylines.length;
      paramInt = i;
      while (paramInt < j)
      {
        this.mKeylines[paramInt] = ((int)(this.mKeylines[paramInt] * f));
        paramInt += 1;
      }
    }
    this.mStatusBarBackground = paramAttributeSet.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
    paramAttributeSet.recycle();
    setupForInsets();
    super.setOnHierarchyChangeListener(new CoordinatorLayout.HierarchyChangeListener(this));
  }
  
  @NonNull
  private static Rect acquireTempRect()
  {
    Rect localRect2 = (Rect)sRectPool.acquire();
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect();
    }
    return localRect1;
  }
  
  private void constrainChildRect(CoordinatorLayout.LayoutParams paramLayoutParams, Rect paramRect, int paramInt1, int paramInt2)
  {
    int j = getWidth();
    int i = getHeight();
    j = Math.max(getPaddingLeft() + paramLayoutParams.leftMargin, Math.min(paramRect.left, j - getPaddingRight() - paramInt1 - paramLayoutParams.rightMargin));
    i = Math.max(getPaddingTop() + paramLayoutParams.topMargin, Math.min(paramRect.top, i - getPaddingBottom() - paramInt2 - paramLayoutParams.bottomMargin));
    paramRect.set(j, i, j + paramInt1, i + paramInt2);
  }
  
  private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (paramWindowInsetsCompat.isConsumed()) {
      return paramWindowInsetsCompat;
    }
    int j = getChildCount();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = getChildAt(i);
      if (ViewCompat.getFitsSystemWindows((View)localObject))
      {
        CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)((View)localObject).getLayoutParams()).getBehavior();
        if (localBehavior != null)
        {
          localObject = localBehavior.onApplyWindowInsets(this, (View)localObject, paramWindowInsetsCompat);
          paramWindowInsetsCompat = (WindowInsetsCompat)localObject;
          if (!((WindowInsetsCompat)localObject).isConsumed()) {}
        }
      }
    }
    for (;;)
    {
      return localObject;
      i += 1;
      break;
      localObject = paramWindowInsetsCompat;
    }
  }
  
  private void getDesiredAnchoredChildRectWithoutConstraints(View paramView, int paramInt1, Rect paramRect1, Rect paramRect2, CoordinatorLayout.LayoutParams paramLayoutParams, int paramInt2, int paramInt3)
  {
    int k = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(paramLayoutParams.gravity), paramInt1);
    int i = GravityCompat.getAbsoluteGravity(resolveGravity(paramLayoutParams.anchorGravity), paramInt1);
    label102:
    int j;
    switch (i & 0x7)
    {
    default: 
      paramInt1 = paramRect1.left;
      switch (i & 0x70)
      {
      default: 
        i = paramRect1.top;
        j = paramInt1;
        switch (k & 0x7)
        {
        default: 
          j = paramInt1 - paramInt2;
        case 5: 
          label142:
          paramInt1 = i;
          switch (k & 0x70)
          {
          }
          break;
        }
        break;
      }
      break;
    }
    for (paramInt1 = i - paramInt3;; paramInt1 = i - paramInt3 / 2)
    {
      paramRect2.set(j, paramInt1, j + paramInt2, paramInt1 + paramInt3);
      return;
      paramInt1 = paramRect1.right;
      break;
      paramInt1 = paramRect1.left;
      paramInt1 = paramRect1.width() / 2 + paramInt1;
      break;
      i = paramRect1.bottom;
      break label102;
      i = paramRect1.top + paramRect1.height() / 2;
      break label102;
      j = paramInt1 - paramInt2 / 2;
      break label142;
    }
  }
  
  private int getKeyline(int paramInt)
  {
    if (this.mKeylines == null)
    {
      Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + paramInt);
      return 0;
    }
    if ((paramInt < 0) || (paramInt >= this.mKeylines.length))
    {
      Log.e("CoordinatorLayout", "Keyline index " + paramInt + " out of range for " + this);
      return 0;
    }
    return this.mKeylines[paramInt];
  }
  
  private void getTopSortedChildren(List paramList)
  {
    paramList.clear();
    boolean bool = isChildrenDrawingOrderEnabled();
    int k = getChildCount();
    int i = k - 1;
    if (i >= 0)
    {
      if (bool) {}
      for (int j = getChildDrawingOrder(k, i);; j = i)
      {
        paramList.add(getChildAt(j));
        i -= 1;
        break;
      }
    }
    if (TOP_SORTED_CHILDREN_COMPARATOR != null) {
      Collections.sort(paramList, TOP_SORTED_CHILDREN_COMPARATOR);
    }
  }
  
  private boolean hasDependencies(View paramView)
  {
    return this.mChildDag.hasOutgoingEdges(paramView);
  }
  
  private void layoutChild(View paramView, int paramInt)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    Rect localRect1 = acquireTempRect();
    localRect1.set(getPaddingLeft() + localLayoutParams.leftMargin, getPaddingTop() + localLayoutParams.topMargin, getWidth() - getPaddingRight() - localLayoutParams.rightMargin, getHeight() - getPaddingBottom() - localLayoutParams.bottomMargin);
    if ((this.mLastInsets != null) && (ViewCompat.getFitsSystemWindows(this)) && (!ViewCompat.getFitsSystemWindows(paramView)))
    {
      localRect1.left += this.mLastInsets.getSystemWindowInsetLeft();
      localRect1.top += this.mLastInsets.getSystemWindowInsetTop();
      localRect1.right -= this.mLastInsets.getSystemWindowInsetRight();
      localRect1.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
    }
    Rect localRect2 = acquireTempRect();
    GravityCompat.apply(resolveGravity(localLayoutParams.gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect1, localRect2, paramInt);
    paramView.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
    releaseTempRect(localRect1);
    releaseTempRect(localRect2);
  }
  
  private void layoutChildWithAnchor(View paramView1, View paramView2, int paramInt)
  {
    Object localObject = (CoordinatorLayout.LayoutParams)paramView1.getLayoutParams();
    localObject = acquireTempRect();
    Rect localRect = acquireTempRect();
    try
    {
      getDescendantRect(paramView2, (Rect)localObject);
      getDesiredAnchoredChildRect(paramView1, paramInt, (Rect)localObject, localRect);
      paramView1.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
      return;
    }
    finally
    {
      releaseTempRect((Rect)localObject);
      releaseTempRect(localRect);
    }
  }
  
  private void layoutChildWithKeyline(View paramView, int paramInt1, int paramInt2)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    int i1 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(localLayoutParams.gravity), paramInt2);
    int n = getWidth();
    int m = getHeight();
    int j = paramView.getMeasuredWidth();
    int k = paramView.getMeasuredHeight();
    int i = paramInt1;
    if (paramInt2 == 1) {
      i = n - paramInt1;
    }
    paramInt1 = getKeyline(i) - j;
    paramInt2 = 0;
    switch (i1 & 0x7)
    {
    default: 
      switch (i1 & 0x70)
      {
      }
      break;
    }
    for (;;)
    {
      paramInt1 = Math.max(getPaddingLeft() + localLayoutParams.leftMargin, Math.min(paramInt1, n - getPaddingRight() - j - localLayoutParams.rightMargin));
      paramInt2 = Math.max(getPaddingTop() + localLayoutParams.topMargin, Math.min(paramInt2, m - getPaddingBottom() - k - localLayoutParams.bottomMargin));
      paramView.layout(paramInt1, paramInt2, paramInt1 + j, paramInt2 + k);
      return;
      paramInt1 += j;
      break;
      paramInt1 += j / 2;
      break;
      paramInt2 = 0 + k;
      continue;
      paramInt2 = 0 + k / 2;
    }
  }
  
  private void offsetChildByInset(View paramView, Rect paramRect, int paramInt)
  {
    if (!ViewCompat.isLaidOut(paramView)) {}
    while ((paramView.getWidth() <= 0) || (paramView.getHeight() <= 0)) {
      return;
    }
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    CoordinatorLayout.Behavior localBehavior = localLayoutParams.getBehavior();
    Rect localRect1 = acquireTempRect();
    Rect localRect2 = acquireTempRect();
    localRect2.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    if ((localBehavior != null) && (localBehavior.getInsetDodgeRect(this, paramView, localRect1)))
    {
      if (!localRect2.contains(localRect1)) {
        throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + localRect1.toShortString() + " | Bounds:" + localRect2.toShortString());
      }
    }
    else {
      localRect1.set(localRect2);
    }
    releaseTempRect(localRect2);
    if (localRect1.isEmpty())
    {
      releaseTempRect(localRect1);
      return;
    }
    int j = GravityCompat.getAbsoluteGravity(localLayoutParams.dodgeInsetEdges, paramInt);
    if ((j & 0x30) == 48)
    {
      paramInt = localRect1.top - localLayoutParams.topMargin - localLayoutParams.mInsetOffsetY;
      if (paramInt < paramRect.top) {
        setInsetOffsetY(paramView, paramRect.top - paramInt);
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      int i = paramInt;
      int k;
      if ((j & 0x50) == 80)
      {
        k = getHeight() - localRect1.bottom - localLayoutParams.bottomMargin + localLayoutParams.mInsetOffsetY;
        i = paramInt;
        if (k < paramRect.bottom)
        {
          setInsetOffsetY(paramView, k - paramRect.bottom);
          i = 1;
        }
      }
      if (i == 0) {
        setInsetOffsetY(paramView, 0);
      }
      if ((j & 0x3) == 3)
      {
        paramInt = localRect1.left - localLayoutParams.leftMargin - localLayoutParams.mInsetOffsetX;
        if (paramInt < paramRect.left) {
          setInsetOffsetX(paramView, paramRect.left - paramInt);
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if ((j & 0x5) == 5)
        {
          i = getWidth();
          j = localRect1.right;
          k = localLayoutParams.rightMargin;
          i = localLayoutParams.mInsetOffsetX + (i - j - k);
          if (i < paramRect.right)
          {
            setInsetOffsetX(paramView, i - paramRect.right);
            paramInt = 1;
          }
        }
        for (;;)
        {
          if (paramInt == 0) {
            setInsetOffsetX(paramView, 0);
          }
          releaseTempRect(localRect1);
          return;
        }
      }
    }
  }
  
  static CoordinatorLayout.Behavior parseBehavior(Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str;
    if (paramString.startsWith(".")) {
      str = paramContext.getPackageName() + paramString;
    }
    label227:
    for (;;)
    {
      try
      {
        paramString = (Map)sConstructors.get();
        if (paramString != null) {
          break label227;
        }
        paramString = new HashMap();
        sConstructors.set(paramString);
        Constructor localConstructor2 = (Constructor)paramString.get(str);
        Constructor localConstructor1 = localConstructor2;
        if (localConstructor2 == null)
        {
          localConstructor1 = paramContext.getClassLoader().loadClass(str).getConstructor(CONSTRUCTOR_PARAMS);
          localConstructor1.setAccessible(true);
          paramString.put(str, localConstructor1);
        }
        paramContext = (CoordinatorLayout.Behavior)localConstructor1.newInstance(new Object[] { paramContext, paramAttributeSet });
        return paramContext;
      }
      catch (Exception paramContext)
      {
        throw new RuntimeException("Could not inflate Behavior subclass " + str, paramContext);
      }
      str = paramString;
      if (paramString.indexOf('.') < 0)
      {
        str = paramString;
        if (!TextUtils.isEmpty(WIDGET_PACKAGE_NAME)) {
          str = WIDGET_PACKAGE_NAME + '.' + paramString;
        }
      }
    }
  }
  
  private boolean performIntercept(MotionEvent paramMotionEvent, int paramInt)
  {
    boolean bool1 = false;
    int i = 0;
    MotionEvent localMotionEvent = null;
    int k = paramMotionEvent.getActionMasked();
    List localList = this.mTempList1;
    getTopSortedChildren(localList);
    int m = localList.size();
    int j = 0;
    View localView;
    CoordinatorLayout.Behavior localBehavior;
    if (j < m)
    {
      localView = (View)localList.get(j);
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
      localBehavior = localLayoutParams.getBehavior();
      if (((bool1) || (i != 0)) && (k != 0))
      {
        if (localBehavior == null) {
          break label330;
        }
        if (localMotionEvent == null)
        {
          long l = SystemClock.uptimeMillis();
          localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          switch (paramInt)
          {
          }
          for (;;)
          {
            label140:
            j += 1;
            break;
            localBehavior.onInterceptTouchEvent(this, localView, localMotionEvent);
            continue;
            localBehavior.onTouchEvent(this, localView, localMotionEvent);
          }
        }
      }
      else
      {
        boolean bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (localBehavior == null) {}
        }
        switch (paramInt)
        {
        default: 
          label220:
          bool2 = bool1;
          if (bool1)
          {
            this.mBehaviorTouchView = localView;
            bool2 = bool1;
          }
          bool1 = bool2;
          bool2 = localLayoutParams.didBlockInteraction();
          boolean bool3 = localLayoutParams.isBlockingInteractionBelow(this, localView);
          if ((bool3) && (!bool2))
          {
            i = 1;
            label272:
            if ((!bool3) || (i != 0)) {
              break label324;
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      localList.clear();
      return bool1;
      bool1 = localBehavior.onInterceptTouchEvent(this, localView, paramMotionEvent);
      break label220;
      bool1 = localBehavior.onTouchEvent(this, localView, paramMotionEvent);
      break label220;
      i = 0;
      break label272;
      label324:
      break label140;
      break;
      label330:
      break label140;
    }
  }
  
  private void prepareChildren()
  {
    this.mDependencySortedChildren.clear();
    this.mChildDag.clear();
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      View localView1 = getChildAt(i);
      CoordinatorLayout.LayoutParams localLayoutParams = getResolvedLayoutParams(localView1);
      localLayoutParams.findAnchorView(this, localView1);
      this.mChildDag.addNode(localView1);
      int j = 0;
      if (j < k)
      {
        if (j == i) {}
        for (;;)
        {
          j += 1;
          break;
          View localView2 = getChildAt(j);
          if (localLayoutParams.dependsOn(this, localView1, localView2))
          {
            if (!this.mChildDag.contains(localView2)) {
              this.mChildDag.addNode(localView2);
            }
            this.mChildDag.addEdge(localView2, localView1);
          }
        }
      }
      i += 1;
    }
    this.mDependencySortedChildren.addAll(this.mChildDag.getSortedList());
    Collections.reverse(this.mDependencySortedChildren);
  }
  
  private static void releaseTempRect(@NonNull Rect paramRect)
  {
    paramRect.setEmpty();
    sRectPool.release(paramRect);
  }
  
  private void resetTouchBehaviors(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)localView.getLayoutParams()).getBehavior();
      MotionEvent localMotionEvent;
      if (localBehavior != null)
      {
        long l = SystemClock.uptimeMillis();
        localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        if (!paramBoolean) {
          break label82;
        }
        localBehavior.onInterceptTouchEvent(this, localView, localMotionEvent);
      }
      for (;;)
      {
        localMotionEvent.recycle();
        i += 1;
        break;
        label82:
        localBehavior.onTouchEvent(this, localView, localMotionEvent);
      }
    }
    i = 0;
    while (i < j)
    {
      ((CoordinatorLayout.LayoutParams)getChildAt(i).getLayoutParams()).resetTouchBehaviorTracking();
      i += 1;
    }
    this.mBehaviorTouchView = null;
    this.mDisallowInterceptReset = false;
  }
  
  private static int resolveAnchoredChildGravity(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 17;
    }
    return i;
  }
  
  private static int resolveGravity(int paramInt)
  {
    if ((paramInt & 0x7) == 0) {
      paramInt = 0x800003 | paramInt;
    }
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      return i;
    }
  }
  
  private static int resolveKeylineGravity(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 8388661;
    }
    return i;
  }
  
  private void setInsetOffsetX(View paramView, int paramInt)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.mInsetOffsetX != paramInt)
    {
      ViewCompat.offsetLeftAndRight(paramView, paramInt - localLayoutParams.mInsetOffsetX);
      localLayoutParams.mInsetOffsetX = paramInt;
    }
  }
  
  private void setInsetOffsetY(View paramView, int paramInt)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.mInsetOffsetY != paramInt)
    {
      ViewCompat.offsetTopAndBottom(paramView, paramInt - localLayoutParams.mInsetOffsetY);
      localLayoutParams.mInsetOffsetY = paramInt;
    }
  }
  
  private void setupForInsets()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (ViewCompat.getFitsSystemWindows(this))
    {
      if (this.mApplyWindowInsetsListener == null) {
        this.mApplyWindowInsetsListener = new CoordinatorLayout.1(this);
      }
      ViewCompat.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
      setSystemUiVisibility(1280);
      return;
    }
    ViewCompat.setOnApplyWindowInsetsListener(this, null);
  }
  
  void addPreDrawListener()
  {
    if (this.mIsAttachedToWindow)
    {
      if (this.mOnPreDrawListener == null) {
        this.mOnPreDrawListener = new CoordinatorLayout.OnPreDrawListener(this);
      }
      getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
    }
    this.mNeedsPreDrawListener = true;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof CoordinatorLayout.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void dispatchDependentViewsChanged(View paramView)
  {
    List localList = this.mChildDag.getIncomingEdges(paramView);
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        View localView = (View)localList.get(i);
        CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)localView.getLayoutParams()).getBehavior();
        if (localBehavior != null) {
          localBehavior.onDependentViewChanged(this, localView, paramView);
        }
        i += 1;
      }
    }
  }
  
  public boolean doViewsOverlap(View paramView1, View paramView2)
  {
    boolean bool2 = true;
    if ((paramView1.getVisibility() == 0) && (paramView2.getVisibility() == 0))
    {
      Rect localRect = acquireTempRect();
      boolean bool1;
      if (paramView1.getParent() != this) {
        bool1 = true;
      }
      for (;;)
      {
        getChildRect(paramView1, bool1, localRect);
        paramView1 = acquireTempRect();
        if (paramView2.getParent() != this)
        {
          bool1 = true;
          label57:
          getChildRect(paramView2, bool1, paramView1);
        }
        try
        {
          if ((localRect.left <= paramView1.right) && (localRect.top <= paramView1.bottom) && (localRect.right >= paramView1.left))
          {
            int i = localRect.bottom;
            int j = paramView1.top;
            if (i >= j)
            {
              bool1 = bool2;
              return bool1;
              bool1 = false;
              continue;
              bool1 = false;
              break label57;
            }
          }
          return false;
        }
        finally
        {
          releaseTempRect(localRect);
          releaseTempRect(paramView1);
        }
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.mBehavior != null)
    {
      float f = localLayoutParams.mBehavior.getScrimOpacity(this, paramView);
      if (f > 0.0F)
      {
        if (this.mScrimPaint == null) {
          this.mScrimPaint = new Paint();
        }
        this.mScrimPaint.setColor(localLayoutParams.mBehavior.getScrimColor(this, paramView));
        this.mScrimPaint.setAlpha(MathUtils.clamp(Math.round(f * 255.0F), 0, 255));
        int i = paramCanvas.save();
        if (paramView.isOpaque()) {
          paramCanvas.clipRect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom(), Region.Op.DIFFERENCE);
        }
        paramCanvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
        paramCanvas.restoreToCount(i);
      }
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.mStatusBarBackground;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = false | localDrawable.setState(arrayOfInt);
      }
    }
    if (bool1) {
      invalidate();
    }
  }
  
  void ensurePreDrawListener()
  {
    int m = 0;
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      int k = m;
      if (i < j)
      {
        if (hasDependencies(getChildAt(i))) {
          k = 1;
        }
      }
      else
      {
        if (k != this.mNeedsPreDrawListener)
        {
          if (k == 0) {
            break;
          }
          addPreDrawListener();
        }
        return;
      }
      i += 1;
    }
    removePreDrawListener();
  }
  
  protected CoordinatorLayout.LayoutParams generateDefaultLayoutParams()
  {
    return new CoordinatorLayout.LayoutParams(-2, -2);
  }
  
  public CoordinatorLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new CoordinatorLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected CoordinatorLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof CoordinatorLayout.LayoutParams)) {
      return new CoordinatorLayout.LayoutParams((CoordinatorLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new CoordinatorLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new CoordinatorLayout.LayoutParams(paramLayoutParams);
  }
  
  void getChildRect(View paramView, boolean paramBoolean, Rect paramRect)
  {
    if ((paramView.isLayoutRequested()) || (paramView.getVisibility() == 8))
    {
      paramRect.setEmpty();
      return;
    }
    if (paramBoolean)
    {
      getDescendantRect(paramView, paramRect);
      return;
    }
    paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  @NonNull
  public List getDependencies(@NonNull View paramView)
  {
    paramView = this.mChildDag.getOutgoingEdges(paramView);
    this.mTempDependenciesList.clear();
    if (paramView != null) {
      this.mTempDependenciesList.addAll(paramView);
    }
    return this.mTempDependenciesList;
  }
  
  @VisibleForTesting
  final List getDependencySortedChildren()
  {
    prepareChildren();
    return Collections.unmodifiableList(this.mDependencySortedChildren);
  }
  
  @NonNull
  public List getDependents(@NonNull View paramView)
  {
    paramView = this.mChildDag.getIncomingEdges(paramView);
    this.mTempDependenciesList.clear();
    if (paramView != null) {
      this.mTempDependenciesList.addAll(paramView);
    }
    return this.mTempDependenciesList;
  }
  
  void getDescendantRect(View paramView, Rect paramRect)
  {
    ViewGroupUtils.getDescendantRect(this, paramView, paramRect);
  }
  
  void getDesiredAnchoredChildRect(View paramView, int paramInt, Rect paramRect1, Rect paramRect2)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    getDesiredAnchoredChildRectWithoutConstraints(paramView, paramInt, paramRect1, paramRect2, localLayoutParams, i, j);
    constrainChildRect(localLayoutParams, paramRect2, i, j);
  }
  
  void getLastChildRect(View paramView, Rect paramRect)
  {
    paramRect.set(((CoordinatorLayout.LayoutParams)paramView.getLayoutParams()).getLastChildRect());
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public final WindowInsetsCompat getLastWindowInsets()
  {
    return this.mLastInsets;
  }
  
  public int getNestedScrollAxes()
  {
    return this.mNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  CoordinatorLayout.LayoutParams getResolvedLayoutParams(View paramView)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.mBehaviorResolved)
    {
      if ((paramView instanceof CoordinatorLayout.AttachedBehavior))
      {
        paramView = ((CoordinatorLayout.AttachedBehavior)paramView).getBehavior();
        if (paramView == null) {
          Log.e("CoordinatorLayout", "Attached behavior class is null");
        }
        localLayoutParams.setBehavior(paramView);
        localLayoutParams.mBehaviorResolved = true;
      }
    }
    else {
      return localLayoutParams;
    }
    Class localClass = paramView.getClass();
    paramView = null;
    View localView;
    for (;;)
    {
      localView = paramView;
      if (localClass == null) {
        break;
      }
      paramView = (CoordinatorLayout.DefaultBehavior)localClass.getAnnotation(CoordinatorLayout.DefaultBehavior.class);
      localView = paramView;
      if (paramView != null) {
        break;
      }
      localClass = localClass.getSuperclass();
    }
    if (localView != null) {}
    try
    {
      localLayoutParams.setBehavior((CoordinatorLayout.Behavior)localView.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      localLayoutParams.mBehaviorResolved = true;
      return localLayoutParams;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.e("CoordinatorLayout", "Default behavior class " + localView.value().getName() + " could not be instantiated. Did you forget" + " a default constructor?", paramView);
      }
    }
  }
  
  @Nullable
  public Drawable getStatusBarBackground()
  {
    return this.mStatusBarBackground;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
  }
  
  public boolean isPointInChildBounds(View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = acquireTempRect();
    getDescendantRect(paramView, localRect);
    try
    {
      boolean bool = localRect.contains(paramInt1, paramInt2);
      return bool;
    }
    finally
    {
      releaseTempRect(localRect);
    }
  }
  
  void offsetChildToAnchor(View paramView, int paramInt)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    Rect localRect1;
    Rect localRect2;
    Rect localRect3;
    int i;
    int j;
    if (localLayoutParams.mAnchorView != null)
    {
      localRect1 = acquireTempRect();
      localRect2 = acquireTempRect();
      localRect3 = acquireTempRect();
      getDescendantRect(localLayoutParams.mAnchorView, localRect1);
      getChildRect(paramView, false, localRect2);
      i = paramView.getMeasuredWidth();
      j = paramView.getMeasuredHeight();
      getDesiredAnchoredChildRectWithoutConstraints(paramView, paramInt, localRect1, localRect3, localLayoutParams, i, j);
      if ((localRect3.left == localRect2.left) && (localRect3.top == localRect2.top)) {
        break label206;
      }
    }
    label206:
    for (paramInt = 1;; paramInt = 0)
    {
      constrainChildRect(localLayoutParams, localRect3, i, j);
      i = localRect3.left - localRect2.left;
      j = localRect3.top - localRect2.top;
      if (i != 0) {
        ViewCompat.offsetLeftAndRight(paramView, i);
      }
      if (j != 0) {
        ViewCompat.offsetTopAndBottom(paramView, j);
      }
      if (paramInt != 0)
      {
        CoordinatorLayout.Behavior localBehavior = localLayoutParams.getBehavior();
        if (localBehavior != null) {
          localBehavior.onDependentViewChanged(this, paramView, localLayoutParams.mAnchorView);
        }
      }
      releaseTempRect(localRect1);
      releaseTempRect(localRect2);
      releaseTempRect(localRect3);
      return;
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    resetTouchBehaviors(false);
    if (this.mNeedsPreDrawListener)
    {
      if (this.mOnPreDrawListener == null) {
        this.mOnPreDrawListener = new CoordinatorLayout.OnPreDrawListener(this);
      }
      getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
    }
    if ((this.mLastInsets == null) && (ViewCompat.getFitsSystemWindows(this))) {
      ViewCompat.requestApplyInsets(this);
    }
    this.mIsAttachedToWindow = true;
  }
  
  final void onChildViewsChanged(int paramInt)
  {
    int k = ViewCompat.getLayoutDirection(this);
    int m = this.mDependencySortedChildren.size();
    Rect localRect1 = acquireTempRect();
    Rect localRect2 = acquireTempRect();
    Rect localRect3 = acquireTempRect();
    int i = 0;
    while (i < m)
    {
      View localView = (View)this.mDependencySortedChildren.get(i);
      Object localObject1 = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
      if ((paramInt == 0) && (localView.getVisibility() == 8))
      {
        i += 1;
      }
      else
      {
        int j = 0;
        Object localObject2;
        while (j < i)
        {
          localObject2 = (View)this.mDependencySortedChildren.get(j);
          if (((CoordinatorLayout.LayoutParams)localObject1).mAnchorDirectChild == localObject2) {
            offsetChildToAnchor(localView, k);
          }
          j += 1;
        }
        getChildRect(localView, true, localRect2);
        if ((((CoordinatorLayout.LayoutParams)localObject1).insetEdge != 0) && (!localRect2.isEmpty()))
        {
          j = GravityCompat.getAbsoluteGravity(((CoordinatorLayout.LayoutParams)localObject1).insetEdge, k);
          switch (j & 0x70)
          {
          default: 
            label200:
            switch (j & 0x7)
            {
            }
            break;
          }
        }
        CoordinatorLayout.Behavior localBehavior;
        for (;;)
        {
          if ((((CoordinatorLayout.LayoutParams)localObject1).dodgeInsetEdges != 0) && (localView.getVisibility() == 0)) {
            offsetChildByInset(localView, localRect1, k);
          }
          if (paramInt != 2)
          {
            getLastChildRect(localView, localRect3);
            if (localRect3.equals(localRect2)) {
              break;
            }
            recordLastChildRect(localView, localRect2);
          }
          j = i + 1;
          while (j < m)
          {
            localObject1 = (View)this.mDependencySortedChildren.get(j);
            localObject2 = (CoordinatorLayout.LayoutParams)((View)localObject1).getLayoutParams();
            localBehavior = ((CoordinatorLayout.LayoutParams)localObject2).getBehavior();
            if ((localBehavior != null) && (localBehavior.layoutDependsOn(this, (View)localObject1, localView)))
            {
              if ((paramInt != 0) || (!((CoordinatorLayout.LayoutParams)localObject2).getChangedAfterNestedScroll())) {
                break label467;
              }
              ((CoordinatorLayout.LayoutParams)localObject2).resetChangedAfterNestedScroll();
            }
            j += 1;
          }
          localRect1.top = Math.max(localRect1.top, localRect2.bottom);
          break label200;
          localRect1.bottom = Math.max(localRect1.bottom, getHeight() - localRect2.top);
          break label200;
          localRect1.left = Math.max(localRect1.left, localRect2.right);
          continue;
          localRect1.right = Math.max(localRect1.right, getWidth() - localRect2.left);
        }
        label467:
        switch (paramInt)
        {
        }
        for (boolean bool = localBehavior.onDependentViewChanged(this, (View)localObject1, localView); paramInt == 1; bool = true)
        {
          ((CoordinatorLayout.LayoutParams)localObject2).setChangedAfterNestedScroll(bool);
          break;
          localBehavior.onDependentViewRemoved(this, (View)localObject1, localView);
        }
      }
    }
    releaseTempRect(localRect1);
    releaseTempRect(localRect2);
    releaseTempRect(localRect3);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    resetTouchBehaviors(false);
    if ((this.mNeedsPreDrawListener) && (this.mOnPreDrawListener != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
    }
    if (this.mNestedScrollingTarget != null) {
      onStopNestedScroll(this.mNestedScrollingTarget);
    }
    this.mIsAttachedToWindow = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.mDrawStatusBarBackground) && (this.mStatusBarBackground != null)) {
      if (this.mLastInsets == null) {
        break label61;
      }
    }
    label61:
    for (int i = this.mLastInsets.getSystemWindowInsetTop();; i = 0)
    {
      if (i > 0)
      {
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), i);
        this.mStatusBarBackground.draw(paramCanvas);
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      resetTouchBehaviors(true);
    }
    boolean bool = performIntercept(paramMotionEvent, 0);
    if (0 != 0) {
      throw new NullPointerException();
    }
    if ((i == 1) || (i == 3)) {
      resetTouchBehaviors(true);
    }
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = ViewCompat.getLayoutDirection(this);
    paramInt3 = this.mDependencySortedChildren.size();
    paramInt1 = 0;
    if (paramInt1 < paramInt3)
    {
      View localView = (View)this.mDependencySortedChildren.get(paramInt1);
      if (localView.getVisibility() == 8) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)localView.getLayoutParams()).getBehavior();
        if ((localBehavior == null) || (!localBehavior.onLayoutChild(this, localView, paramInt2))) {
          onLayoutChild(localView, paramInt2);
        }
      }
    }
  }
  
  public void onLayoutChild(View paramView, int paramInt)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.checkAnchorChanged()) {
      throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }
    if (localLayoutParams.mAnchorView != null)
    {
      layoutChildWithAnchor(paramView, localLayoutParams.mAnchorView, paramInt);
      return;
    }
    if (localLayoutParams.keyline >= 0)
    {
      layoutChildWithKeyline(paramView, localLayoutParams.keyline, paramInt);
      return;
    }
    layoutChild(paramView, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    prepareChildren();
    ensurePreDrawListener();
    int i5 = getPaddingLeft();
    int i6 = getPaddingTop();
    int i7 = getPaddingRight();
    int i8 = getPaddingBottom();
    int i9 = ViewCompat.getLayoutDirection(this);
    int n;
    int i10;
    int i11;
    int i12;
    int i13;
    int k;
    int j;
    int i;
    if (i9 == 1)
    {
      n = 1;
      i10 = View.MeasureSpec.getMode(paramInt1);
      i11 = View.MeasureSpec.getSize(paramInt1);
      i12 = View.MeasureSpec.getMode(paramInt2);
      i13 = View.MeasureSpec.getSize(paramInt2);
      k = getSuggestedMinimumWidth();
      j = getSuggestedMinimumHeight();
      i = 0;
      if ((this.mLastInsets == null) || (!ViewCompat.getFitsSystemWindows(this))) {
        break label184;
      }
    }
    View localView;
    label184:
    for (int i1 = 1;; i1 = 0)
    {
      int i14 = this.mDependencySortedChildren.size();
      int i2 = 0;
      for (;;)
      {
        if (i2 >= i14) {
          break label536;
        }
        localView = (View)this.mDependencySortedChildren.get(i2);
        if (localView.getVisibility() != 8) {
          break;
        }
        m = i;
        i = k;
        k = m;
        i2 += 1;
        m = i;
        i = k;
        k = m;
      }
      n = 0;
      break;
    }
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
    int i3 = 0;
    int m = i3;
    int i4;
    int i15;
    if (localLayoutParams.keyline >= 0)
    {
      m = i3;
      if (i10 != 0)
      {
        i4 = getKeyline(localLayoutParams.keyline);
        i15 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(localLayoutParams.gravity), i9) & 0x7;
        if (((i15 != 3) || (n != 0)) && ((i15 != 5) || (n == 0))) {
          break label492;
        }
        m = Math.max(0, i11 - i7 - i4);
      }
    }
    label289:
    if ((i1 != 0) && (!ViewCompat.getFitsSystemWindows(localView)))
    {
      i3 = this.mLastInsets.getSystemWindowInsetLeft();
      int i16 = this.mLastInsets.getSystemWindowInsetRight();
      i4 = this.mLastInsets.getSystemWindowInsetTop();
      i15 = this.mLastInsets.getSystemWindowInsetBottom();
      i3 = View.MeasureSpec.makeMeasureSpec(i11 - (i3 + i16), i10);
      i4 = View.MeasureSpec.makeMeasureSpec(i13 - (i4 + i15), i12);
    }
    for (;;)
    {
      CoordinatorLayout.Behavior localBehavior = localLayoutParams.getBehavior();
      if ((localBehavior == null) || (!localBehavior.onMeasureChild(this, localView, i3, m, i4, 0))) {
        onMeasureChild(localView, i3, m, i4, 0);
      }
      k = Math.max(k, localView.getMeasuredWidth() + (i5 + i7) + localLayoutParams.leftMargin + localLayoutParams.rightMargin);
      j = Math.max(j, localView.getMeasuredHeight() + (i6 + i8) + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
      m = View.combineMeasuredStates(i, localView.getMeasuredState());
      i = k;
      k = m;
      break;
      label492:
      if ((i15 != 5) || (n != 0))
      {
        m = i3;
        if (i15 != 3) {
          break label289;
        }
        m = i3;
        if (n == 0) {
          break label289;
        }
      }
      m = Math.max(0, i4 - i5);
      break label289;
      label536:
      setMeasuredDimension(View.resolveSizeAndState(k, paramInt1, 0xFF000000 & i), View.resolveSizeAndState(j, paramInt2, i << 16));
      return;
      i4 = paramInt2;
      i3 = paramInt1;
    }
  }
  
  public void onMeasureChild(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    boolean bool = false;
    View localView;
    if (i < j)
    {
      localView = getChildAt(i);
      if (localView.getVisibility() != 8) {}
    }
    for (;;)
    {
      i += 1;
      break;
      Object localObject = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
      if (((CoordinatorLayout.LayoutParams)localObject).isNestedScrollAccepted(0))
      {
        localObject = ((CoordinatorLayout.LayoutParams)localObject).getBehavior();
        if (localObject != null)
        {
          bool = ((CoordinatorLayout.Behavior)localObject).onNestedFling(this, localView, paramView, paramFloat1, paramFloat2, paramBoolean) | bool;
          continue;
          if (bool) {
            onChildViewsChanged(1);
          }
          return bool;
        }
      }
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    int j = getChildCount();
    int i = 0;
    boolean bool = false;
    View localView;
    if (i < j)
    {
      localView = getChildAt(i);
      if (localView.getVisibility() != 8) {}
    }
    for (;;)
    {
      i += 1;
      break;
      Object localObject = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
      if (((CoordinatorLayout.LayoutParams)localObject).isNestedScrollAccepted(0))
      {
        localObject = ((CoordinatorLayout.LayoutParams)localObject).getBehavior();
        if (localObject != null)
        {
          bool = ((CoordinatorLayout.Behavior)localObject).onNestedPreFling(this, localView, paramView, paramFloat1, paramFloat2) | bool;
          continue;
          return bool;
        }
      }
    }
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    int j = 0;
    int i = 0;
    int k = 0;
    int i1 = getChildCount();
    int m = 0;
    View localView;
    int n;
    if (m < i1)
    {
      localView = getChildAt(m);
      if (localView.getVisibility() == 8)
      {
        n = k;
        k = j;
        j = i;
        i = n;
      }
    }
    for (;;)
    {
      n = m + 1;
      m = k;
      k = i;
      i = j;
      j = m;
      m = n;
      break;
      Object localObject = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
      if (!((CoordinatorLayout.LayoutParams)localObject).isNestedScrollAccepted(paramInt3))
      {
        n = k;
        k = j;
        j = i;
        i = n;
      }
      else
      {
        localObject = ((CoordinatorLayout.LayoutParams)localObject).getBehavior();
        if (localObject != null)
        {
          int[] arrayOfInt = this.mTempIntPair;
          this.mTempIntPair[1] = 0;
          arrayOfInt[0] = 0;
          ((CoordinatorLayout.Behavior)localObject).onNestedPreScroll(this, localView, paramView, paramInt1, paramInt2, this.mTempIntPair, paramInt3);
          if (paramInt1 > 0)
          {
            k = Math.max(j, this.mTempIntPair[0]);
            label191:
            if (paramInt2 <= 0) {
              break label234;
            }
          }
          label234:
          for (i = Math.max(i, this.mTempIntPair[1]);; i = Math.min(i, this.mTempIntPair[1]))
          {
            j = i;
            i = 1;
            break;
            k = Math.min(j, this.mTempIntPair[0]);
            break label191;
          }
          paramArrayOfInt[0] = j;
          paramArrayOfInt[1] = i;
          if (k != 0) {
            onChildViewsChanged(1);
          }
          return;
        }
        n = k;
        k = j;
        j = i;
        i = n;
      }
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int k = getChildCount();
    int i = 0;
    int j = 0;
    View localView;
    if (j < k)
    {
      localView = getChildAt(j);
      if (localView.getVisibility() != 8) {}
    }
    for (;;)
    {
      j += 1;
      break;
      Object localObject = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
      if (((CoordinatorLayout.LayoutParams)localObject).isNestedScrollAccepted(paramInt5))
      {
        localObject = ((CoordinatorLayout.LayoutParams)localObject).getBehavior();
        if (localObject != null)
        {
          ((CoordinatorLayout.Behavior)localObject).onNestedScroll(this, localView, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
          i = 1;
          continue;
          if (i != 0) {
            onChildViewsChanged(1);
          }
          return;
        }
      }
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    onNestedScrollAccepted(paramView1, paramView2, paramInt, 0);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    this.mNestedScrollingParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt1, paramInt2);
    this.mNestedScrollingTarget = paramView2;
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      Object localObject = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
      if (!((CoordinatorLayout.LayoutParams)localObject).isNestedScrollAccepted(paramInt2)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = ((CoordinatorLayout.LayoutParams)localObject).getBehavior();
        if (localObject != null) {
          ((CoordinatorLayout.Behavior)localObject).onNestedScrollAccepted(this, localView, paramView1, paramView2, paramInt1, paramInt2);
        }
      }
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof CoordinatorLayout.SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    for (;;)
    {
      return;
      paramParcelable = (CoordinatorLayout.SavedState)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getSuperState());
      paramParcelable = paramParcelable.behaviorStates;
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        int k = localView.getId();
        CoordinatorLayout.Behavior localBehavior = getResolvedLayoutParams(localView).getBehavior();
        if ((k != -1) && (localBehavior != null))
        {
          Parcelable localParcelable = (Parcelable)paramParcelable.get(k);
          if (localParcelable != null) {
            localBehavior.onRestoreInstanceState(this, localView, localParcelable);
          }
        }
        i += 1;
      }
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    CoordinatorLayout.SavedState localSavedState = new CoordinatorLayout.SavedState(super.onSaveInstanceState());
    SparseArray localSparseArray = new SparseArray();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(i);
      int k = ((View)localObject).getId();
      CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)((View)localObject).getLayoutParams()).getBehavior();
      if ((k != -1) && (localBehavior != null))
      {
        localObject = localBehavior.onSaveInstanceState(this, (View)localObject);
        if (localObject != null) {
          localSparseArray.append(k, localObject);
        }
      }
      i += 1;
    }
    localSavedState.behaviorStates = localSparseArray;
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return onStartNestedScroll(paramView1, paramView2, paramInt, 0);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool1 = false;
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 8) {}
      for (;;)
      {
        i += 1;
        break;
        CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
        CoordinatorLayout.Behavior localBehavior = localLayoutParams.getBehavior();
        if (localBehavior != null)
        {
          boolean bool2 = localBehavior.onStartNestedScroll(this, localView, paramView1, paramView2, paramInt1, paramInt2);
          bool1 |= bool2;
          localLayoutParams.setNestedScrollAccepted(paramInt2, bool2);
        }
        else
        {
          localLayoutParams.setNestedScrollAccepted(paramInt2, false);
        }
      }
    }
    return bool1;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    onStopNestedScroll(paramView, 0);
  }
  
  public void onStopNestedScroll(View paramView, int paramInt)
  {
    this.mNestedScrollingParentHelper.onStopNestedScroll(paramView, paramInt);
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.isNestedScrollAccepted(paramInt)) {}
      for (;;)
      {
        i += 1;
        break;
        CoordinatorLayout.Behavior localBehavior = localLayoutParams.getBehavior();
        if (localBehavior != null) {
          localBehavior.onStopNestedScroll(this, localView, paramView, paramInt);
        }
        localLayoutParams.resetNestedScroll(paramInt);
        localLayoutParams.resetChangedAfterNestedScroll();
      }
    }
    this.mNestedScrollingTarget = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = null;
    int i = paramMotionEvent.getActionMasked();
    boolean bool2;
    if (this.mBehaviorTouchView == null)
    {
      bool2 = performIntercept(paramMotionEvent, 1);
      if (!bool2) {}
    }
    for (;;)
    {
      CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)this.mBehaviorTouchView.getLayoutParams()).getBehavior();
      boolean bool1;
      if (localBehavior != null) {
        bool1 = localBehavior.onTouchEvent(this, this.mBehaviorTouchView, paramMotionEvent);
      }
      for (;;)
      {
        boolean bool3;
        if (this.mBehaviorTouchView == null)
        {
          bool3 = bool1 | super.onTouchEvent(paramMotionEvent);
          paramMotionEvent = localObject;
        }
        do
        {
          if (((bool3) || (i != 0)) || (paramMotionEvent != null)) {
            paramMotionEvent.recycle();
          }
          if ((i == 1) || (i == 3)) {
            resetTouchBehaviors(false);
          }
          return bool3;
          paramMotionEvent = localObject;
          bool3 = bool1;
        } while (!bool2);
        long l;
        if (0 == 0) {
          l = SystemClock.uptimeMillis();
        }
        for (paramMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);; paramMotionEvent = null)
        {
          super.onTouchEvent(paramMotionEvent);
          bool3 = bool1;
          break;
        }
        bool1 = false;
        continue;
        bool1 = false;
      }
      bool2 = false;
    }
  }
  
  void recordLastChildRect(View paramView, Rect paramRect)
  {
    ((CoordinatorLayout.LayoutParams)paramView.getLayoutParams()).setLastChildRect(paramRect);
  }
  
  void removePreDrawListener()
  {
    if ((this.mIsAttachedToWindow) && (this.mOnPreDrawListener != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
    }
    this.mNeedsPreDrawListener = false;
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)paramView.getLayoutParams()).getBehavior();
    if ((localBehavior != null) && (localBehavior.onRequestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean))) {
      return true;
    }
    return super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!this.mDisallowInterceptReset))
    {
      resetTouchBehaviors(false);
      this.mDisallowInterceptReset = true;
    }
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    super.setFitsSystemWindows(paramBoolean);
    setupForInsets();
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    this.mOnHierarchyChangeListener = paramOnHierarchyChangeListener;
  }
  
  public void setStatusBarBackground(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    if (this.mStatusBarBackground != paramDrawable)
    {
      if (this.mStatusBarBackground != null) {
        this.mStatusBarBackground.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.mStatusBarBackground = localDrawable;
      if (this.mStatusBarBackground != null)
      {
        if (this.mStatusBarBackground.isStateful()) {
          this.mStatusBarBackground.setState(getDrawableState());
        }
        DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
        paramDrawable = this.mStatusBarBackground;
        if (getVisibility() != 0) {
          break label114;
        }
      }
    }
    label114:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.mStatusBarBackground.setCallback(this);
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
  }
  
  public void setStatusBarBackgroundColor(@ColorInt int paramInt)
  {
    setStatusBarBackground(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarBackgroundResource(@DrawableRes int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = ContextCompat.getDrawable(getContext(), paramInt);; localDrawable = null)
    {
      setStatusBarBackground(localDrawable);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.mStatusBarBackground != null) && (this.mStatusBarBackground.isVisible() != bool)) {
        this.mStatusBarBackground.setVisible(bool, false);
      }
      return;
    }
  }
  
  final WindowInsetsCompat setWindowInsets(WindowInsetsCompat paramWindowInsetsCompat)
  {
    boolean bool2 = true;
    WindowInsetsCompat localWindowInsetsCompat = paramWindowInsetsCompat;
    if (!ObjectsCompat.equals(this.mLastInsets, paramWindowInsetsCompat))
    {
      this.mLastInsets = paramWindowInsetsCompat;
      if ((paramWindowInsetsCompat == null) || (paramWindowInsetsCompat.getSystemWindowInsetTop() <= 0)) {
        break label74;
      }
      bool1 = true;
      this.mDrawStatusBarBackground = bool1;
      if ((this.mDrawStatusBarBackground) || (getBackground() != null)) {
        break label79;
      }
    }
    label74:
    label79:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      setWillNotDraw(bool1);
      localWindowInsetsCompat = dispatchApplyWindowInsetsToBehaviors(paramWindowInsetsCompat);
      requestLayout();
      return localWindowInsetsCompat;
      bool1 = false;
      break;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.mStatusBarBackground);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.design.widget.CoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */