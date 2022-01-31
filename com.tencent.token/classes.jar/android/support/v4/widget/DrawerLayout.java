package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
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
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout
  extends ViewGroup
{
  private static final boolean ALLOW_EDGE_LOCK = false;
  static final boolean CAN_HIDE_DESCENDANTS;
  private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
  private static final int DEFAULT_SCRIM_COLOR = -1728053248;
  private static final int DRAWER_ELEVATION = 10;
  static final int[] LAYOUT_ATTRS;
  public static final int LOCK_MODE_LOCKED_CLOSED = 1;
  public static final int LOCK_MODE_LOCKED_OPEN = 2;
  public static final int LOCK_MODE_UNDEFINED = 3;
  public static final int LOCK_MODE_UNLOCKED = 0;
  private static final int MIN_DRAWER_MARGIN = 64;
  private static final int MIN_FLING_VELOCITY = 400;
  private static final int PEEK_DELAY = 160;
  private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  private static final String TAG = "DrawerLayout";
  private static final int[] THEME_ATTRS;
  private static final float TOUCH_SLOP_SENSITIVITY = 1.0F;
  private final DrawerLayout.ChildAccessibilityDelegate mChildAccessibilityDelegate = new DrawerLayout.ChildAccessibilityDelegate();
  private boolean mChildrenCanceledTouch;
  private boolean mDisallowInterceptRequested;
  private boolean mDrawStatusBarBackground;
  private float mDrawerElevation;
  private int mDrawerState;
  private boolean mFirstLayout = true;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private Object mLastInsets;
  private final DrawerLayout.ViewDragCallback mLeftCallback;
  private final ViewDragHelper mLeftDragger;
  @Nullable
  private DrawerLayout.DrawerListener mListener;
  private List mListeners;
  private int mLockModeEnd = 3;
  private int mLockModeLeft = 3;
  private int mLockModeRight = 3;
  private int mLockModeStart = 3;
  private int mMinDrawerMargin;
  private final ArrayList mNonDrawerViews;
  private final DrawerLayout.ViewDragCallback mRightCallback;
  private final ViewDragHelper mRightDragger;
  private int mScrimColor = -1728053248;
  private float mScrimOpacity;
  private Paint mScrimPaint = new Paint();
  private Drawable mShadowEnd = null;
  private Drawable mShadowLeft = null;
  private Drawable mShadowLeftResolved;
  private Drawable mShadowRight = null;
  private Drawable mShadowRightResolved;
  private Drawable mShadowStart = null;
  private Drawable mStatusBarBackground;
  private CharSequence mTitleLeft;
  private CharSequence mTitleRight;
  
  static
  {
    boolean bool2 = true;
    THEME_ATTRS = new int[] { 16843828 };
    LAYOUT_ATTRS = new int[] { 16842931 };
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = true;
      CAN_HIDE_DESCENDANTS = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label58;
      }
    }
    label58:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      SET_DRAWER_SHADOW_FROM_ELEVATION = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public DrawerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DrawerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f1 = getResources().getDisplayMetrics().density;
    this.mMinDrawerMargin = ((int)(64.0F * f1 + 0.5F));
    float f2 = 400.0F * f1;
    this.mLeftCallback = new DrawerLayout.ViewDragCallback(this, 3);
    this.mRightCallback = new DrawerLayout.ViewDragCallback(this, 5);
    this.mLeftDragger = ViewDragHelper.create(this, 1.0F, this.mLeftCallback);
    this.mLeftDragger.setEdgeTrackingEnabled(1);
    this.mLeftDragger.setMinVelocity(f2);
    this.mLeftCallback.setDragger(this.mLeftDragger);
    this.mRightDragger = ViewDragHelper.create(this, 1.0F, this.mRightCallback);
    this.mRightDragger.setEdgeTrackingEnabled(2);
    this.mRightDragger.setMinVelocity(f2);
    this.mRightCallback.setDragger(this.mRightDragger);
    setFocusableInTouchMode(true);
    ViewCompat.setImportantForAccessibility(this, 1);
    ViewCompat.setAccessibilityDelegate(this, new DrawerLayout.AccessibilityDelegate(this));
    setMotionEventSplittingEnabled(false);
    if (ViewCompat.getFitsSystemWindows(this))
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label337;
      }
      setOnApplyWindowInsetsListener(new DrawerLayout.1(this));
      setSystemUiVisibility(1280);
      paramContext = paramContext.obtainStyledAttributes(THEME_ATTRS);
    }
    for (;;)
    {
      try
      {
        this.mStatusBarBackground = paramContext.getDrawable(0);
        paramContext.recycle();
        this.mDrawerElevation = (f1 * 10.0F);
        this.mNonDrawerViews = new ArrayList();
        return;
      }
      finally
      {
        paramContext.recycle();
      }
      label337:
      this.mStatusBarBackground = null;
    }
  }
  
  static String gravityToString(int paramInt)
  {
    if ((paramInt & 0x3) == 3) {
      return "LEFT";
    }
    if ((paramInt & 0x5) == 5) {
      return "RIGHT";
    }
    return Integer.toHexString(paramInt);
  }
  
  private static boolean hasOpaqueBackground(View paramView)
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
  
  private boolean hasPeekingDrawer()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      if (((DrawerLayout.LayoutParams)getChildAt(i).getLayoutParams()).isPeeking) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean hasVisibleDrawer()
  {
    return findVisibleDrawer() != null;
  }
  
  static boolean includeChildForAccessibility(View paramView)
  {
    return (ViewCompat.getImportantForAccessibility(paramView) != 4) && (ViewCompat.getImportantForAccessibility(paramView) != 2);
  }
  
  private boolean mirror(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable == null) || (!DrawableCompat.isAutoMirrored(paramDrawable))) {
      return false;
    }
    DrawableCompat.setLayoutDirection(paramDrawable, paramInt);
    return true;
  }
  
  private Drawable resolveLeftShadow()
  {
    int i = ViewCompat.getLayoutDirection(this);
    if (i == 0)
    {
      if (this.mShadowStart != null)
      {
        mirror(this.mShadowStart, i);
        return this.mShadowStart;
      }
    }
    else if (this.mShadowEnd != null)
    {
      mirror(this.mShadowEnd, i);
      return this.mShadowEnd;
    }
    return this.mShadowLeft;
  }
  
  private Drawable resolveRightShadow()
  {
    int i = ViewCompat.getLayoutDirection(this);
    if (i == 0)
    {
      if (this.mShadowEnd != null)
      {
        mirror(this.mShadowEnd, i);
        return this.mShadowEnd;
      }
    }
    else if (this.mShadowStart != null)
    {
      mirror(this.mShadowStart, i);
      return this.mShadowStart;
    }
    return this.mShadowRight;
  }
  
  private void resolveShadowDrawables()
  {
    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
      return;
    }
    this.mShadowLeftResolved = resolveLeftShadow();
    this.mShadowRightResolved = resolveRightShadow();
  }
  
  private void updateChildrenImportantForAccessibility(View paramView, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (((!paramBoolean) && (!isDrawerView(localView))) || ((paramBoolean) && (localView == paramView))) {
        ViewCompat.setImportantForAccessibility(localView, 1);
      }
      for (;;)
      {
        i += 1;
        break;
        ViewCompat.setImportantForAccessibility(localView, 4);
      }
    }
  }
  
  public void addDrawerListener(@NonNull DrawerLayout.DrawerListener paramDrawerListener)
  {
    if (paramDrawerListener == null) {
      return;
    }
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramDrawerListener);
  }
  
  public void addFocusables(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    int k = 0;
    if (getDescendantFocusability() == 393216) {
      return;
    }
    int m = getChildCount();
    int i = 0;
    int j = 0;
    View localView;
    if (i < m)
    {
      localView = getChildAt(i);
      if (isDrawerView(localView)) {
        if (isDrawerOpen(localView))
        {
          j = 1;
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        this.mNonDrawerViews.add(localView);
      }
    }
    if (j == 0)
    {
      j = this.mNonDrawerViews.size();
      i = k;
      while (i < j)
      {
        localView = (View)this.mNonDrawerViews.get(i);
        if (localView.getVisibility() == 0) {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
        i += 1;
      }
    }
    this.mNonDrawerViews.clear();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((findOpenDrawer() != null) || (isDrawerView(paramView))) {
      ViewCompat.setImportantForAccessibility(paramView, 4);
    }
    for (;;)
    {
      if (!CAN_HIDE_DESCENDANTS) {
        ViewCompat.setAccessibilityDelegate(paramView, this.mChildAccessibilityDelegate);
      }
      return;
      ViewCompat.setImportantForAccessibility(paramView, 1);
    }
  }
  
  void cancelChildViewTouch()
  {
    int i = 0;
    if (!this.mChildrenCanceledTouch)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      int j = getChildCount();
      while (i < j)
      {
        getChildAt(i).dispatchTouchEvent(localMotionEvent);
        i += 1;
      }
      localMotionEvent.recycle();
      this.mChildrenCanceledTouch = true;
    }
  }
  
  boolean checkDrawerViewAbsoluteGravity(View paramView, int paramInt)
  {
    return (getDrawerViewAbsoluteGravity(paramView) & paramInt) == paramInt;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof DrawerLayout.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void closeDrawer(int paramInt)
  {
    closeDrawer(paramInt, true);
  }
  
  public void closeDrawer(int paramInt, boolean paramBoolean)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(paramInt));
    }
    closeDrawer(localView, paramBoolean);
  }
  
  public void closeDrawer(@NonNull View paramView)
  {
    closeDrawer(paramView, true);
  }
  
  public void closeDrawer(@NonNull View paramView, boolean paramBoolean)
  {
    if (!isDrawerView(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
    if (this.mFirstLayout)
    {
      localLayoutParams.onScreen = 0.0F;
      localLayoutParams.openState = 0;
    }
    for (;;)
    {
      invalidate();
      return;
      if (paramBoolean)
      {
        localLayoutParams.openState |= 0x4;
        if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
          this.mLeftDragger.smoothSlideViewTo(paramView, -paramView.getWidth(), paramView.getTop());
        } else {
          this.mRightDragger.smoothSlideViewTo(paramView, getWidth(), paramView.getTop());
        }
      }
      else
      {
        moveDrawerToOffset(paramView, 0.0F);
        updateDrawerState(localLayoutParams.gravity, 0, paramView);
        paramView.setVisibility(4);
      }
    }
  }
  
  public void closeDrawers()
  {
    closeDrawers(false);
  }
  
  void closeDrawers(boolean paramBoolean)
  {
    int n = getChildCount();
    int j = 0;
    int i = 0;
    while (j < n)
    {
      View localView = getChildAt(j);
      DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
      int k = i;
      if (isDrawerView(localView))
      {
        if ((paramBoolean) && (!localLayoutParams.isPeeking)) {
          k = i;
        }
      }
      else
      {
        j += 1;
        i = k;
        continue;
      }
      int m = localView.getWidth();
      if (checkDrawerViewAbsoluteGravity(localView, 3)) {
        i |= this.mLeftDragger.smoothSlideViewTo(localView, -m, localView.getTop());
      }
      for (;;)
      {
        localLayoutParams.isPeeking = false;
        m = i;
        break;
        i |= this.mRightDragger.smoothSlideViewTo(localView, getWidth(), localView.getTop());
      }
    }
    this.mLeftCallback.removeCallbacks();
    this.mRightCallback.removeCallbacks();
    if (i != 0) {
      invalidate();
    }
  }
  
  public void computeScroll()
  {
    int j = getChildCount();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f = Math.max(f, ((DrawerLayout.LayoutParams)getChildAt(i).getLayoutParams()).onScreen);
      i += 1;
    }
    this.mScrimOpacity = f;
    boolean bool1 = this.mLeftDragger.continueSettling(true);
    boolean bool2 = this.mRightDragger.continueSettling(true);
    if ((bool1) || (bool2)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void dispatchOnDrawerClosed(View paramView)
  {
    DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
    if ((localLayoutParams.openState & 0x1) == 1)
    {
      localLayoutParams.openState = 0;
      if (this.mListeners != null)
      {
        int i = this.mListeners.size() - 1;
        while (i >= 0)
        {
          ((DrawerLayout.DrawerListener)this.mListeners.get(i)).onDrawerClosed(paramView);
          i -= 1;
        }
      }
      updateChildrenImportantForAccessibility(paramView, false);
      if (hasWindowFocus())
      {
        paramView = getRootView();
        if (paramView != null) {
          paramView.sendAccessibilityEvent(32);
        }
      }
    }
  }
  
  void dispatchOnDrawerOpened(View paramView)
  {
    DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
    if ((localLayoutParams.openState & 0x1) == 0)
    {
      localLayoutParams.openState = 1;
      if (this.mListeners != null)
      {
        int i = this.mListeners.size() - 1;
        while (i >= 0)
        {
          ((DrawerLayout.DrawerListener)this.mListeners.get(i)).onDrawerOpened(paramView);
          i -= 1;
        }
      }
      updateChildrenImportantForAccessibility(paramView, true);
      if (hasWindowFocus()) {
        sendAccessibilityEvent(32);
      }
    }
  }
  
  void dispatchOnDrawerSlide(View paramView, float paramFloat)
  {
    if (this.mListeners != null)
    {
      int i = this.mListeners.size() - 1;
      while (i >= 0)
      {
        ((DrawerLayout.DrawerListener)this.mListeners.get(i)).onDrawerSlide(paramView, paramFloat);
        i -= 1;
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i2 = getHeight();
    boolean bool1 = isContentView(paramView);
    int k = 0;
    int n = 0;
    int i = getWidth();
    int i3 = paramCanvas.save();
    int j = i;
    int m;
    View localView;
    if (bool1)
    {
      int i4 = getChildCount();
      m = 0;
      k = n;
      for (;;)
      {
        if (m < i4)
        {
          localView = getChildAt(m);
          if ((localView != paramView) && (localView.getVisibility() == 0) && (hasOpaqueBackground(localView)) && (isDrawerView(localView)))
          {
            if (localView.getHeight() < i2)
            {
              n = k;
              j = i;
              m += 1;
              i = j;
              k = n;
              continue;
            }
            if (checkDrawerViewAbsoluteGravity(localView, 3))
            {
              j = localView.getRight();
              if (j <= k) {
                break label534;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      n = j;
      j = i;
      break;
      int i1 = localView.getLeft();
      j = i1;
      n = k;
      if (i1 < i) {
        break;
      }
      j = i;
      n = k;
      break;
      paramCanvas.clipRect(k, 0, i, getHeight());
      j = i;
      boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i3);
      if ((this.mScrimOpacity > 0.0F) && (bool1))
      {
        i = (int)(((this.mScrimColor & 0xFF000000) >>> 24) * this.mScrimOpacity);
        m = this.mScrimColor;
        this.mScrimPaint.setColor(i << 24 | m & 0xFFFFFF);
        paramCanvas.drawRect(k, 0.0F, j, getHeight(), this.mScrimPaint);
      }
      do
      {
        return bool2;
        if ((this.mShadowLeftResolved != null) && (checkDrawerViewAbsoluteGravity(paramView, 3)))
        {
          i = this.mShadowLeftResolved.getIntrinsicWidth();
          j = paramView.getRight();
          k = this.mLeftDragger.getEdgeSize();
          f = Math.max(0.0F, Math.min(j / k, 1.0F));
          this.mShadowLeftResolved.setBounds(j, paramView.getTop(), i + j, paramView.getBottom());
          this.mShadowLeftResolved.setAlpha((int)(255.0F * f));
          this.mShadowLeftResolved.draw(paramCanvas);
          return bool2;
        }
      } while ((this.mShadowRightResolved == null) || (!checkDrawerViewAbsoluteGravity(paramView, 5)));
      i = this.mShadowRightResolved.getIntrinsicWidth();
      j = paramView.getLeft();
      k = getWidth();
      m = this.mRightDragger.getEdgeSize();
      float f = Math.max(0.0F, Math.min((k - j) / m, 1.0F));
      this.mShadowRightResolved.setBounds(j - i, paramView.getTop(), j, paramView.getBottom());
      this.mShadowRightResolved.setAlpha((int)(255.0F * f));
      this.mShadowRightResolved.draw(paramCanvas);
      return bool2;
      label534:
      j = k;
    }
  }
  
  View findDrawerWithGravity(int paramInt)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    int j = getChildCount();
    paramInt = 0;
    while (paramInt < j)
    {
      View localView = getChildAt(paramInt);
      if ((getDrawerViewAbsoluteGravity(localView) & 0x7) == (i & 0x7)) {
        return localView;
      }
      paramInt += 1;
    }
    return null;
  }
  
  View findOpenDrawer()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((((DrawerLayout.LayoutParams)localView.getLayoutParams()).openState & 0x1) == 1) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  View findVisibleDrawer()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((isDrawerView(localView)) && (isDrawerVisible(localView))) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new DrawerLayout.LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new DrawerLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof DrawerLayout.LayoutParams)) {
      return new DrawerLayout.LayoutParams((DrawerLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new DrawerLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new DrawerLayout.LayoutParams(paramLayoutParams);
  }
  
  public float getDrawerElevation()
  {
    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
      return this.mDrawerElevation;
    }
    return 0.0F;
  }
  
  public int getDrawerLockMode(int paramInt)
  {
    int i = ViewCompat.getLayoutDirection(this);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      if (this.mLockModeLeft != 3) {
        return this.mLockModeLeft;
      }
      if (i == 0) {}
      for (paramInt = this.mLockModeStart; paramInt != 3; paramInt = this.mLockModeEnd) {
        return paramInt;
      }
      if (this.mLockModeRight != 3) {
        return this.mLockModeRight;
      }
      if (i == 0) {}
      for (paramInt = this.mLockModeEnd; paramInt != 3; paramInt = this.mLockModeStart) {
        return paramInt;
      }
      if (this.mLockModeStart != 3) {
        return this.mLockModeStart;
      }
      if (i == 0) {}
      for (paramInt = this.mLockModeLeft; paramInt != 3; paramInt = this.mLockModeRight) {
        return paramInt;
      }
      if (this.mLockModeEnd != 3) {
        return this.mLockModeEnd;
      }
      if (i == 0) {}
      for (paramInt = this.mLockModeRight; paramInt != 3; paramInt = this.mLockModeLeft) {
        return paramInt;
      }
    }
  }
  
  public int getDrawerLockMode(@NonNull View paramView)
  {
    if (!isDrawerView(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    return getDrawerLockMode(((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity);
  }
  
  @Nullable
  public CharSequence getDrawerTitle(int paramInt)
  {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if (paramInt == 3) {
      return this.mTitleLeft;
    }
    if (paramInt == 5) {
      return this.mTitleRight;
    }
    return null;
  }
  
  int getDrawerViewAbsoluteGravity(View paramView)
  {
    return GravityCompat.getAbsoluteGravity(((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
  }
  
  float getDrawerViewOffset(View paramView)
  {
    return ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).onScreen;
  }
  
  @Nullable
  public Drawable getStatusBarBackgroundDrawable()
  {
    return this.mStatusBarBackground;
  }
  
  boolean isContentView(View paramView)
  {
    return ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity == 0;
  }
  
  public boolean isDrawerOpen(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView != null) {
      return isDrawerOpen(localView);
    }
    return false;
  }
  
  public boolean isDrawerOpen(@NonNull View paramView)
  {
    if (!isDrawerView(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    return (((DrawerLayout.LayoutParams)paramView.getLayoutParams()).openState & 0x1) == 1;
  }
  
  boolean isDrawerView(View paramView)
  {
    int i = GravityCompat.getAbsoluteGravity(((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(paramView));
    if ((i & 0x3) != 0) {
      return true;
    }
    return (i & 0x5) != 0;
  }
  
  public boolean isDrawerVisible(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView != null) {
      return isDrawerVisible(localView);
    }
    return false;
  }
  
  public boolean isDrawerVisible(@NonNull View paramView)
  {
    if (!isDrawerView(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    return ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).onScreen > 0.0F;
  }
  
  void moveDrawerToOffset(View paramView, float paramFloat)
  {
    float f = getDrawerViewOffset(paramView);
    int i = paramView.getWidth();
    int j = (int)(f * i);
    i = (int)(i * paramFloat) - j;
    if (checkDrawerViewAbsoluteGravity(paramView, 3)) {}
    for (;;)
    {
      paramView.offsetLeftAndRight(i);
      setDrawerViewOffset(paramView, paramFloat);
      return;
      i = -i;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i;
    if ((this.mDrawStatusBarBackground) && (this.mStatusBarBackground != null))
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label77;
      }
      if (this.mLastInsets == null) {
        break label72;
      }
      i = ((WindowInsets)this.mLastInsets).getSystemWindowInsetTop();
    }
    for (;;)
    {
      if (i > 0)
      {
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), i);
        this.mStatusBarBackground.draw(paramCanvas);
      }
      return;
      label72:
      i = 0;
      continue;
      label77:
      i = 0;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    int i = paramMotionEvent.getActionMasked();
    boolean bool2 = this.mLeftDragger.shouldInterceptTouchEvent(paramMotionEvent);
    boolean bool3 = this.mRightDragger.shouldInterceptTouchEvent(paramMotionEvent);
    switch (i)
    {
    default: 
      i = 0;
      if (((bool2 | bool3)) || (i != 0) || (hasPeekingDrawer()) || (this.mChildrenCanceledTouch)) {
        bool1 = true;
      }
      return bool1;
    case 0: 
      label63:
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      if (this.mScrimOpacity > 0.0F)
      {
        paramMotionEvent = this.mLeftDragger.findTopChildUnder((int)f1, (int)f2);
        if ((paramMotionEvent == null) || (!isContentView(paramMotionEvent))) {
          break;
        }
      }
      break;
    }
    for (i = 1;; i = 0)
    {
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
      break label63;
      if (!this.mLeftDragger.checkTouchSlop(3)) {
        break;
      }
      this.mLeftCallback.removeCallbacks();
      this.mRightCallback.removeCallbacks();
      i = 0;
      break label63;
      closeDrawers(true);
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
      break;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (hasVisibleDrawer()))
    {
      paramKeyEvent.startTracking();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = findVisibleDrawer();
      if ((paramKeyEvent != null) && (getDrawerLockMode(paramKeyEvent) == 0)) {
        closeDrawers();
      }
      return paramKeyEvent != null;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mInLayout = true;
    int m = paramInt3 - paramInt1;
    int n = getChildCount();
    paramInt3 = 0;
    if (paramInt3 < n)
    {
      View localView = getChildAt(paramInt3);
      if (localView.getVisibility() == 8) {}
      DrawerLayout.LayoutParams localLayoutParams;
      for (;;)
      {
        paramInt3 += 1;
        break;
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if (!isContentView(localView)) {
          break label113;
        }
        localView.layout(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.leftMargin + localView.getMeasuredWidth(), localLayoutParams.topMargin + localView.getMeasuredHeight());
      }
      label113:
      int i1 = localView.getMeasuredWidth();
      int i2 = localView.getMeasuredHeight();
      int i;
      float f;
      label167:
      int j;
      if (checkDrawerViewAbsoluteGravity(localView, 3))
      {
        paramInt1 = -i1;
        i = (int)(i1 * localLayoutParams.onScreen) + paramInt1;
        f = (i1 + i) / i1;
        if (f == localLayoutParams.onScreen) {
          break label314;
        }
        j = 1;
        label181:
        switch (localLayoutParams.gravity & 0x70)
        {
        default: 
          localView.layout(i, localLayoutParams.topMargin, i1 + i, i2 + localLayoutParams.topMargin);
          label241:
          if (j != 0) {
            setDrawerViewOffset(localView, f);
          }
          if (localLayoutParams.onScreen <= 0.0F) {
            break;
          }
        }
      }
      for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4)
      {
        localView.setVisibility(paramInt1);
        break;
        i = m - (int)(i1 * localLayoutParams.onScreen);
        f = (m - i) / i1;
        break label167;
        label314:
        j = 0;
        break label181;
        paramInt1 = paramInt4 - paramInt2;
        localView.layout(i, paramInt1 - localLayoutParams.bottomMargin - localView.getMeasuredHeight(), i1 + i, paramInt1 - localLayoutParams.bottomMargin);
        break label241;
        int i3 = paramInt4 - paramInt2;
        int k = (i3 - i2) / 2;
        if (k < localLayoutParams.topMargin) {
          paramInt1 = localLayoutParams.topMargin;
        }
        for (;;)
        {
          localView.layout(i, paramInt1, i1 + i, i2 + paramInt1);
          break;
          paramInt1 = k;
          if (k + i2 > i3 - localLayoutParams.bottomMargin) {
            paramInt1 = i3 - localLayoutParams.bottomMargin - i2;
          }
        }
      }
    }
    this.mInLayout = false;
    this.mFirstLayout = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int j;
    if (n == 1073741824)
    {
      j = i;
      if (m == 1073741824) {}
    }
    else if (isInEditMode())
    {
      if (n == -2147483648)
      {
        if (m != -2147483648) {
          break label162;
        }
        j = i;
        i = k;
      }
    }
    for (;;)
    {
      label71:
      setMeasuredDimension(j, i);
      if ((this.mLastInsets != null) && (ViewCompat.getFitsSystemWindows(this))) {}
      int i3;
      int i1;
      View localView;
      for (n = 1;; n = 0)
      {
        i3 = ViewCompat.getLayoutDirection(this);
        k = 0;
        m = 0;
        int i4 = getChildCount();
        i1 = 0;
        for (;;)
        {
          if (i1 >= i4) {
            break label792;
          }
          localView = getChildAt(i1);
          if (localView.getVisibility() != 8) {
            break;
          }
          i1 += 1;
        }
        if (n != 0) {
          break;
        }
        i = 300;
        break;
        label162:
        j = i;
        if (m != 0) {
          break label793;
        }
        k = 300;
        j = i;
        i = k;
        break label71;
        throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
      }
      DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
      int i2;
      WindowInsets localWindowInsets2;
      WindowInsets localWindowInsets1;
      if (n != 0)
      {
        i2 = GravityCompat.getAbsoluteGravity(localLayoutParams.gravity, i3);
        if (!ViewCompat.getFitsSystemWindows(localView)) {
          break label382;
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          localWindowInsets2 = (WindowInsets)this.mLastInsets;
          if (i2 != 3) {
            break label346;
          }
          localWindowInsets1 = localWindowInsets2.replaceSystemWindowInsets(localWindowInsets2.getSystemWindowInsetLeft(), localWindowInsets2.getSystemWindowInsetTop(), 0, localWindowInsets2.getSystemWindowInsetBottom());
          label282:
          localView.dispatchApplyWindowInsets(localWindowInsets1);
        }
      }
      for (;;)
      {
        if (isContentView(localView))
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(j - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(i - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
          break;
          label346:
          localWindowInsets1 = localWindowInsets2;
          if (i2 != 5) {
            break label282;
          }
          localWindowInsets1 = localWindowInsets2.replaceSystemWindowInsets(0, localWindowInsets2.getSystemWindowInsetTop(), localWindowInsets2.getSystemWindowInsetRight(), localWindowInsets2.getSystemWindowInsetBottom());
          break label282;
          label382:
          if (Build.VERSION.SDK_INT >= 21)
          {
            localWindowInsets2 = (WindowInsets)this.mLastInsets;
            if (i2 == 3) {
              localWindowInsets1 = localWindowInsets2.replaceSystemWindowInsets(localWindowInsets2.getSystemWindowInsetLeft(), localWindowInsets2.getSystemWindowInsetTop(), 0, localWindowInsets2.getSystemWindowInsetBottom());
            }
            for (;;)
            {
              localLayoutParams.leftMargin = localWindowInsets1.getSystemWindowInsetLeft();
              localLayoutParams.topMargin = localWindowInsets1.getSystemWindowInsetTop();
              localLayoutParams.rightMargin = localWindowInsets1.getSystemWindowInsetRight();
              localLayoutParams.bottomMargin = localWindowInsets1.getSystemWindowInsetBottom();
              break;
              localWindowInsets1 = localWindowInsets2;
              if (i2 == 5) {
                localWindowInsets1 = localWindowInsets2.replaceSystemWindowInsets(0, localWindowInsets2.getSystemWindowInsetTop(), localWindowInsets2.getSystemWindowInsetRight(), localWindowInsets2.getSystemWindowInsetBottom());
              }
            }
          }
        }
      }
      if (isDrawerView(localView))
      {
        if ((SET_DRAWER_SHADOW_FROM_ELEVATION) && (ViewCompat.getElevation(localView) != this.mDrawerElevation)) {
          ViewCompat.setElevation(localView, this.mDrawerElevation);
        }
        int i5 = getDrawerViewAbsoluteGravity(localView) & 0x7;
        if (i5 == 3) {}
        for (i2 = 1; ((i2 != 0) && (k != 0)) || ((i2 == 0) && (m != 0)); i2 = 0) {
          throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(i5) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
        }
        if (i2 != 0)
        {
          i2 = 1;
          k = m;
          m = i2;
        }
        for (;;)
        {
          localView.measure(getChildMeasureSpec(paramInt1, this.mMinDrawerMargin + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
          i2 = m;
          m = k;
          k = i2;
          break;
          i2 = 1;
          m = k;
          k = i2;
        }
      }
      throw new IllegalStateException("Child " + localView + " at index " + i1 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
      label792:
      return;
      label793:
      i = k;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof DrawerLayout.SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      paramParcelable = (DrawerLayout.SavedState)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getSuperState());
      if (paramParcelable.openDrawerGravity != 0)
      {
        View localView = findDrawerWithGravity(paramParcelable.openDrawerGravity);
        if (localView != null) {
          openDrawer(localView);
        }
      }
      if (paramParcelable.lockModeLeft != 3) {
        setDrawerLockMode(paramParcelable.lockModeLeft, 3);
      }
      if (paramParcelable.lockModeRight != 3) {
        setDrawerLockMode(paramParcelable.lockModeRight, 5);
      }
      if (paramParcelable.lockModeStart != 3) {
        setDrawerLockMode(paramParcelable.lockModeStart, 8388611);
      }
    } while (paramParcelable.lockModeEnd == 3);
    setDrawerLockMode(paramParcelable.lockModeEnd, 8388613);
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    resolveShadowDrawables();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    DrawerLayout.SavedState localSavedState = new DrawerLayout.SavedState(super.onSaveInstanceState());
    int m = getChildCount();
    int i = 0;
    for (;;)
    {
      DrawerLayout.LayoutParams localLayoutParams;
      int j;
      if (i < m)
      {
        localLayoutParams = (DrawerLayout.LayoutParams)getChildAt(i).getLayoutParams();
        if (localLayoutParams.openState != 1) {
          break label119;
        }
        j = 1;
        if (localLayoutParams.openState != 2) {
          break label124;
        }
      }
      label119:
      label124:
      for (int k = 1;; k = 0)
      {
        if ((j == 0) && (k == 0)) {
          break label129;
        }
        localSavedState.openDrawerGravity = localLayoutParams.gravity;
        localSavedState.lockModeLeft = this.mLockModeLeft;
        localSavedState.lockModeRight = this.mLockModeRight;
        localSavedState.lockModeStart = this.mLockModeStart;
        localSavedState.lockModeEnd = this.mLockModeEnd;
        return localSavedState;
        j = 0;
        break;
      }
      label129:
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mLeftDragger.processTouchEvent(paramMotionEvent);
    this.mRightDragger.processTouchEvent(paramMotionEvent);
    float f1;
    float f2;
    boolean bool;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return true;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
      return true;
    case 1: 
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      paramMotionEvent = this.mLeftDragger.findTopChildUnder((int)f2, (int)f1);
      if ((paramMotionEvent != null) && (isContentView(paramMotionEvent)))
      {
        f2 -= this.mInitialMotionX;
        f1 -= this.mInitialMotionY;
        int i = this.mLeftDragger.getTouchSlop();
        if (f2 * f2 + f1 * f1 < i * i)
        {
          paramMotionEvent = findOpenDrawer();
          if (paramMotionEvent != null) {
            if (getDrawerLockMode(paramMotionEvent) == 2) {
              bool = true;
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      closeDrawers(bool);
      this.mDisallowInterceptRequested = false;
      return true;
      bool = false;
      continue;
      closeDrawers(true);
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
      return true;
      bool = true;
    }
  }
  
  public void openDrawer(int paramInt)
  {
    openDrawer(paramInt, true);
  }
  
  public void openDrawer(int paramInt, boolean paramBoolean)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(paramInt));
    }
    openDrawer(localView, paramBoolean);
  }
  
  public void openDrawer(@NonNull View paramView)
  {
    openDrawer(paramView, true);
  }
  
  public void openDrawer(@NonNull View paramView, boolean paramBoolean)
  {
    if (!isDrawerView(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
    if (this.mFirstLayout)
    {
      localLayoutParams.onScreen = 1.0F;
      localLayoutParams.openState = 1;
      updateChildrenImportantForAccessibility(paramView, true);
    }
    for (;;)
    {
      invalidate();
      return;
      if (paramBoolean)
      {
        localLayoutParams.openState |= 0x2;
        if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
          this.mLeftDragger.smoothSlideViewTo(paramView, 0, paramView.getTop());
        } else {
          this.mRightDragger.smoothSlideViewTo(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
        }
      }
      else
      {
        moveDrawerToOffset(paramView, 1.0F);
        updateDrawerState(localLayoutParams.gravity, 0, paramView);
        paramView.setVisibility(0);
      }
    }
  }
  
  public void removeDrawerListener(@NonNull DrawerLayout.DrawerListener paramDrawerListener)
  {
    if (paramDrawerListener == null) {}
    while (this.mListeners == null) {
      return;
    }
    this.mListeners.remove(paramDrawerListener);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.mDisallowInterceptRequested = paramBoolean;
    if (paramBoolean) {
      closeDrawers(true);
    }
  }
  
  public void requestLayout()
  {
    if (!this.mInLayout) {
      super.requestLayout();
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setChildInsets(Object paramObject, boolean paramBoolean)
  {
    this.mLastInsets = paramObject;
    this.mDrawStatusBarBackground = paramBoolean;
    if ((!paramBoolean) && (getBackground() == null)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setWillNotDraw(paramBoolean);
      requestLayout();
      return;
    }
  }
  
  public void setDrawerElevation(float paramFloat)
  {
    this.mDrawerElevation = paramFloat;
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (isDrawerView(localView)) {
        ViewCompat.setElevation(localView, this.mDrawerElevation);
      }
      i += 1;
    }
  }
  
  @Deprecated
  public void setDrawerListener(DrawerLayout.DrawerListener paramDrawerListener)
  {
    if (this.mListener != null) {
      removeDrawerListener(this.mListener);
    }
    if (paramDrawerListener != null) {
      addDrawerListener(paramDrawerListener);
    }
    this.mListener = paramDrawerListener;
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    setDrawerLockMode(paramInt, 3);
    setDrawerLockMode(paramInt, 5);
  }
  
  public void setDrawerLockMode(int paramInt1, int paramInt2)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt2, ViewCompat.getLayoutDirection(this));
    Object localObject;
    switch (paramInt2)
    {
    default: 
      if (paramInt1 != 0)
      {
        if (i == 3)
        {
          localObject = this.mLeftDragger;
          label67:
          ((ViewDragHelper)localObject).cancel();
        }
      }
      else {
        switch (paramInt1)
        {
        }
      }
      break;
    }
    do
    {
      do
      {
        return;
        this.mLockModeLeft = paramInt1;
        break;
        this.mLockModeRight = paramInt1;
        break;
        this.mLockModeStart = paramInt1;
        break;
        this.mLockModeEnd = paramInt1;
        break;
        localObject = this.mRightDragger;
        break label67;
        localObject = findDrawerWithGravity(i);
      } while (localObject == null);
      openDrawer((View)localObject);
      return;
      localObject = findDrawerWithGravity(i);
    } while (localObject == null);
    closeDrawer((View)localObject);
  }
  
  public void setDrawerLockMode(int paramInt, @NonNull View paramView)
  {
    if (!isDrawerView(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a " + "drawer with appropriate layout_gravity");
    }
    setDrawerLockMode(paramInt, ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity);
  }
  
  public void setDrawerShadow(@DrawableRes int paramInt1, int paramInt2)
  {
    setDrawerShadow(ContextCompat.getDrawable(getContext(), paramInt1), paramInt2);
  }
  
  public void setDrawerShadow(Drawable paramDrawable, int paramInt)
  {
    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
      return;
    }
    if ((paramInt & 0x800003) == 8388611) {
      this.mShadowStart = paramDrawable;
    }
    for (;;)
    {
      resolveShadowDrawables();
      invalidate();
      return;
      if ((paramInt & 0x800005) == 8388613)
      {
        this.mShadowEnd = paramDrawable;
      }
      else if ((paramInt & 0x3) == 3)
      {
        this.mShadowLeft = paramDrawable;
      }
      else
      {
        if ((paramInt & 0x5) != 5) {
          break;
        }
        this.mShadowRight = paramDrawable;
      }
    }
  }
  
  public void setDrawerTitle(int paramInt, @Nullable CharSequence paramCharSequence)
  {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if (paramInt == 3) {
      this.mTitleLeft = paramCharSequence;
    }
    while (paramInt != 5) {
      return;
    }
    this.mTitleRight = paramCharSequence;
  }
  
  void setDrawerViewOffset(View paramView, float paramFloat)
  {
    DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
    if (paramFloat == localLayoutParams.onScreen) {
      return;
    }
    localLayoutParams.onScreen = paramFloat;
    dispatchOnDrawerSlide(paramView, paramFloat);
  }
  
  public void setScrimColor(@ColorInt int paramInt)
  {
    this.mScrimColor = paramInt;
    invalidate();
  }
  
  public void setStatusBarBackground(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = ContextCompat.getDrawable(getContext(), paramInt);; localDrawable = null)
    {
      this.mStatusBarBackground = localDrawable;
      invalidate();
      return;
    }
  }
  
  public void setStatusBarBackground(@Nullable Drawable paramDrawable)
  {
    this.mStatusBarBackground = paramDrawable;
    invalidate();
  }
  
  public void setStatusBarBackgroundColor(@ColorInt int paramInt)
  {
    this.mStatusBarBackground = new ColorDrawable(paramInt);
    invalidate();
  }
  
  void updateDrawerState(int paramInt1, int paramInt2, View paramView)
  {
    paramInt1 = this.mLeftDragger.getViewDragState();
    int i = this.mRightDragger.getViewDragState();
    DrawerLayout.LayoutParams localLayoutParams;
    if ((paramInt1 == 1) || (i == 1))
    {
      paramInt1 = 1;
      if ((paramView != null) && (paramInt2 == 0))
      {
        localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
        if (localLayoutParams.onScreen != 0.0F) {
          break label145;
        }
        dispatchOnDrawerClosed(paramView);
      }
    }
    for (;;)
    {
      if (paramInt1 == this.mDrawerState) {
        return;
      }
      this.mDrawerState = paramInt1;
      if (this.mListeners == null) {
        return;
      }
      paramInt2 = this.mListeners.size() - 1;
      while (paramInt2 >= 0)
      {
        ((DrawerLayout.DrawerListener)this.mListeners.get(paramInt2)).onDrawerStateChanged(paramInt1);
        paramInt2 -= 1;
      }
      if ((paramInt1 == 2) || (i == 2))
      {
        paramInt1 = 2;
        break;
      }
      paramInt1 = 0;
      break;
      label145:
      if (localLayoutParams.onScreen == 1.0F) {
        dispatchOnDrawerOpened(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayout
 * JD-Core Version:    0.7.0.1
 */