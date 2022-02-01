package com.tencent.qqmail.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import android.widget.ZoomButtonsController;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TitleBarWebView2
  extends WebView
{
  protected static final String TAG = TitleBarWebView2.class.getSimpleName();
  private static final int TOOLBAR_OFFSET_HEIGHT = 100;
  private final Runnable checkScrollIdle = new TitleBarWebView2.4(this);
  private boolean hasSetContentHeight = false;
  private Rect mClipBounds = new Rect();
  private boolean mHasHandledDonwEvent = false;
  private View mInsideTitleBar;
  private boolean mIntercepted = false;
  private long mLastGetSelectionTime = 0L;
  private float mLastX;
  private float mLastY;
  private View.OnLongClickListener mLongClickListener = new TitleBarWebView2.5(this);
  private Matrix mMatrix = new Matrix();
  private Method mNativeGetTitleHeightMethod;
  private Method mNativeGetVisibleTitleHeightMethod;
  private View.OnLongClickListener mOldLongClickListener;
  private OnScrollListener mOnScrollListener;
  private boolean mReadyShowToolbar = false;
  private int mRealContentHeight;
  private Scroller mScroller;
  private boolean mScrolling = false;
  private boolean mSelectingMode = false;
  protected View mTitleBar;
  private int mTitleBarOffs;
  private View mToolBar;
  private boolean mTouchInTitleBar;
  private boolean mTouchInToolBar;
  private boolean mTouchMove;
  private int mTouchSlot;
  private float oldScale;
  private float scaleDensity = 1.0F;
  
  public TitleBarWebView2(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public TitleBarWebView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public TitleBarWebView2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private int calculateToolbarPosition()
  {
    int j = getTitleHeightCompat();
    int k = (int)(getContentHeight() * getScale());
    int m = getToolHeight();
    if (needTitlebarFilled()) {}
    for (int i = getTitleHeightCompat();; i = 0) {
      return j + k - m - i;
    }
  }
  
  public static TitleBarWebView2 getInstance(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new JBTitleBarWebView2(paramContext);
    }
    return new TitleBarWebView2(paramContext);
  }
  
  private String getSelection()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return null;
    }
    Object localObject1;
    if (Build.VERSION.SDK_INT <= 16) {
      localObject1 = WebView.class;
    }
    for (;;)
    {
      try
      {
        localObject1 = ((Class)localObject1).getMethod("getSelection", new Class[] { (Class)null });
        ((Method)localObject1).setAccessible(true);
        localObject1 = (String)((Method)localObject1).invoke(this, (Object[])null);
        Log.d(TAG, "isSelectionMode text:" + (String)localObject1);
        return localObject1;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        QMLog.log(5, TAG, "no Provider", localException1);
      }
      break;
      try
      {
        Object localObject2 = WebView.class.getDeclaredField("mProvider");
        ((Field)localObject2).setAccessible(true);
        localObject2 = ((Field)localObject2).get(this).getClass();
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        QMLog.log(5, TAG, "no Provider", localException2);
        Object localObject3 = null;
      }
    }
  }
  
  private int getToolHeight()
  {
    if (this.mToolBar != null) {
      return this.mToolBar.getHeight();
    }
    return 0;
  }
  
  private int getViewHeightWithTitle()
  {
    int j = getHeight();
    int i = j;
    if (isHorizontalScrollBarEnabled())
    {
      i = j;
      if (!overlayHorizontalScrollbar()) {
        i = j - getHorizontalScrollbarHeight();
      }
    }
    return i;
  }
  
  private void init()
  {
    try
    {
      this.mNativeGetVisibleTitleHeightMethod = WebView.class.getDeclaredMethod("getVisibleTitleHeight", new Class[0]);
      this.mNativeGetTitleHeightMethod = WebView.class.getDeclaredMethod("getTitleHeight", new Class[0]);
      this.mNativeGetVisibleTitleHeightMethod.setAccessible(true);
      this.mNativeGetTitleHeightMethod.setAccessible(true);
      this.mTouchSlot = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      setZoomControlGone();
      QMLog.log(4, TAG, "HARDWARD_ACCELERATED: " + QMApplicationContext.enableAccelerating);
      super.setOnLongClickListener(this.mLongClickListener);
      removeJavascriptInterface("searchBoxJavaBridge_");
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.w(TAG, "Could not retrieve native hidden getVisibleTitleHeight method");
      }
    }
  }
  
  public static boolean needTitlebarFilled()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  private void requestSelectionRange() {}
  
  private void resetContentHeight()
  {
    int i = 0;
    int j = getToolHeight();
    QMLog.log(4, TAG, "resetContentHeight2_2: " + hashCode() + ", " + this.hasSetContentHeight + ", " + j + ", " + getContentHeight());
    if ((j > 0) && (this.hasSetContentHeight))
    {
      int k = (int)(100.0F * this.scaleDensity);
      int m = getHeight();
      j = (int)(this.mRealContentHeight * getScale());
      k = m - k - getTitleHeightCompat();
      if (j < k) {
        i = (int)((k - j) / getScale());
      }
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder().append("javascript:setBarFillDivHeight(");
      float f = getToolHeight() / getScale();
      loadUrl((int)(i + f) + "," + 0 + ");");
      this.mReadyShowToolbar = true;
      invalidate();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, TAG, "resetContentHeight2_3:", localException);
      }
    }
  }
  
  private void scrollBegin()
  {
    if (!this.mScrolling)
    {
      this.mScrolling = true;
      if (this.mOnScrollListener != null) {
        this.mOnScrollListener.onScrollBegin();
      }
    }
  }
  
  private void setEmbeddedTitleBarJellyBean(View paramView)
  {
    if (this.mTitleBar == paramView) {
      return;
    }
    if (this.mTitleBar != null) {
      removeView(this.mTitleBar);
    }
    Object localObject = paramView;
    AbsoluteLayout.LayoutParams localLayoutParams;
    if (paramView != null)
    {
      if ((paramView.getParent() != null) && ((paramView.getParent() instanceof ViewGroup))) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      localLayoutParams = new AbsoluteLayout.LayoutParams(-1, -2, 0, 0);
      if (Build.VERSION.SDK_INT < 16) {
        break label119;
      }
      localObject = new TitleBarWrapperView(getContext());
      ((TitleBarWrapperView)localObject).addView(paramView, new FrameLayout.LayoutParams(-1, -2));
      addView((View)localObject, localLayoutParams);
    }
    for (;;)
    {
      this.mTitleBar = ((View)localObject);
      return;
      label119:
      addView(paramView, localLayoutParams);
      localObject = paramView;
    }
  }
  
  @TargetApi(11)
  private void setZoomControlGone()
  {
    try
    {
      if ((Build.BRAND.contains("vivo")) && (Build.VERSION.SDK_INT < 11)) {
        return;
      }
      if (Build.VERSION.SDK_INT >= 11) {
        getSettings().setDisplayZoomControls(false);
      }
      Field localField = WebView.class.getDeclaredField("mZoomButtonsController");
      localField.setAccessible(true);
      ZoomButtonsController localZoomButtonsController = new ZoomButtonsController(this);
      localZoomButtonsController.getZoomControls().setVisibility(8);
      try
      {
        localField.set(this, localZoomButtonsController);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        return;
      }
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      return;
    }
    catch (Exception localException)
    {
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  private void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 < 0) {
      this.mScroller.startScroll(getScrollX(), getScrollY(), paramInt1, paramInt2);
    }
    for (;;)
    {
      invalidate();
      return;
      this.mScroller.startScroll(getScrollX(), getScrollY(), paramInt1, paramInt2, paramInt3);
    }
  }
  
  private void startCheckSelection()
  {
    if (getScrollY() == 0)
    {
      this.mSelectingMode = true;
      if (Build.VERSION.SDK_INT < 19) {}
    }
  }
  
  public void computeScroll()
  {
    try
    {
      if ((this.mScroller != null) && (this.mScroller.computeScrollOffset()))
      {
        scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
        postInvalidate();
      }
      super.computeScroll();
      return;
    }
    catch (Exception localException) {}
  }
  
  protected int computeVerticalScrollExtent()
  {
    if (this.mTitleBar == null) {
      return super.computeVerticalScrollExtent();
    }
    return getViewHeightWithTitle();
  }
  
  protected int computeVerticalScrollOffset()
  {
    if (this.mTitleBar == null) {
      return super.computeVerticalScrollOffset();
    }
    return Math.max(getScrollY() - getTitleHeightCompat(), 0);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((needTitlebarFilled()) && (this.mTitleBar != null)) {}
    try
    {
      this.mTitleBar.dispatchKeyEvent(paramKeyEvent);
      label22:
      Log.d("ahang", paramKeyEvent.getKeyCode() + "");
      if (paramKeyEvent.getKeyCode() == 5) {
        return true;
      }
      try
      {
        boolean bool = super.dispatchKeyEvent(paramKeyEvent);
        return bool;
      }
      catch (IllegalStateException paramKeyEvent)
      {
        return false;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label22;
    }
  }
  
  public boolean dispatchSuperTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getActionMasked() == 0)
    {
      this.mIntercepted = false;
      this.mHasHandledDonwEvent = false;
      this.mLastX = paramMotionEvent.getX();
      this.mLastY = paramMotionEvent.getY();
      requestSelectionRange();
    }
    if (((paramMotionEvent.getActionMasked() != 2) || (Math.abs(paramMotionEvent.getX() - this.mLastX) > this.mTouchSlot) || (Math.abs(paramMotionEvent.getY() - this.mLastY) <= this.mTouchSlot)) || ((this.mTitleBar != null) || (this.mToolBar != null)))
    {
      int i = calculateToolbarPosition();
      int j = getScrollY();
      int k = getVisibleTitleHeightCompat();
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      switch (paramMotionEvent.getActionMasked())
      {
      default: 
        if ((this.mTouchInTitleBar) && (this.mTitleBar != null))
        {
          paramMotionEvent.setLocation(f1, j + f2);
          i = paramMotionEvent.getAction();
          if (this.mIntercepted) {
            paramMotionEvent.setAction(3);
          }
          this.mTitleBar.dispatchTouchEvent(paramMotionEvent);
          if (this.mIntercepted)
          {
            paramMotionEvent.setAction(i);
            this.mTouchInTitleBar = false;
          }
          paramMotionEvent.setLocation(f1, f2);
        }
        break;
      }
      for (;;)
      {
        return super.dispatchTouchEvent(paramMotionEvent);
        if (f2 <= k)
        {
          this.mTouchInTitleBar = true;
          this.mTouchInToolBar = false;
          break;
        }
        this.mTouchInTitleBar = false;
        if ((f2 >= i - j) && (f2 <= getToolHeight() + i - j))
        {
          this.mTouchInToolBar = true;
          break;
        }
        this.mTouchInToolBar = false;
        break;
        this.mTouchMove = true;
        break;
        this.mTouchMove = false;
        break;
        if ((this.mTouchInToolBar) && (this.mToolBar != null))
        {
          paramMotionEvent.setLocation(f1, Math.max(0, (int)f2 - i + j));
          ((TouchFrameLayout)this.mToolBar).setAbleConsume(true);
          this.mToolBar.dispatchTouchEvent(paramMotionEvent);
          ((TouchFrameLayout)this.mToolBar).setAbleConsume(false);
          paramMotionEvent.setLocation(f1, f2);
        }
        else if (this.mTitleBar != null)
        {
          if (this.mTouchInTitleBar)
          {
            paramMotionEvent.setLocation(f1, j + f2);
          }
          else
          {
            if (!this.mTouchMove) {
              this.mTitleBarOffs = getVisibleTitleHeightCompat();
            }
            paramMotionEvent.setLocation(f1, Math.max(0.0F, f2));
          }
        }
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    paramCanvas.save();
    if (paramView == this.mTitleBar)
    {
      this.mTitleBar.offsetLeftAndRight(getScrollX() - this.mTitleBar.getLeft());
      if (Build.VERSION.SDK_INT < 16)
      {
        this.mMatrix.set(paramCanvas.getMatrix());
        this.mMatrix.postTranslate(0.0F, -getScrollY());
        paramCanvas.setMatrix(this.mMatrix);
      }
    }
    if (paramView == this.mToolBar)
    {
      this.mToolBar.offsetLeftAndRight(getScrollX() - this.mToolBar.getLeft());
      if (getContentHeight() <= 0)
      {
        paramCanvas.restore();
        return false;
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)this.mToolBar.getLayoutParams();
        if (localLayoutParams.y == 0) {}
        for (int i = 1;; i = 0)
        {
          localLayoutParams.y = calculateToolbarPosition();
          this.mToolBar.setLayoutParams(localLayoutParams);
          if (i == 0) {
            break;
          }
          paramCanvas.restore();
          return false;
        }
      }
      paramCanvas.translate(0.0F, calculateToolbarPosition());
    }
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restore();
    return bool;
  }
  
  public int getContentWidth()
  {
    return computeHorizontalScrollRange();
  }
  
  public int getTitleHeightCompat()
  {
    if ((this.mTitleBar == null) && (this.mNativeGetTitleHeightMethod != null)) {}
    for (;;)
    {
      try
      {
        i = ((Integer)this.mNativeGetTitleHeightMethod.invoke(this, new Object[0])).intValue();
        if (this.mTitleBar != null) {
          i = this.mTitleBar.getHeight();
        }
        return i;
      }
      catch (Exception localException)
      {
        i = 0;
        continue;
      }
      int i = 0;
    }
  }
  
  public int getVisibleTitleHeightCompat()
  {
    if ((this.mTitleBar == null) && (this.mNativeGetVisibleTitleHeightMethod != null)) {
      try
      {
        int i = ((Integer)this.mNativeGetVisibleTitleHeightMethod.invoke(this, new Object[0])).intValue();
        return i;
      }
      catch (Exception localException) {}
    }
    return Math.max(getTitleHeightCompat() - Math.max(0, getScrollY()), 0);
  }
  
  public int getWebViewTitleBarHeight()
  {
    if ((this.mTitleBar != null) && ((this.mTitleBar instanceof TitleBarWrapperView)) && (((TitleBarWrapperView)this.mTitleBar).mTitlebarHeight > 0)) {
      return ((TitleBarWrapperView)this.mTitleBar).mTitlebarHeight;
    }
    return -1;
  }
  
  public boolean isSelectingAndTop()
  {
    return this.mSelectingMode;
  }
  
  public boolean isSelectionMode()
  {
    return this.mSelectingMode;
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    this.hasSetContentHeight = false;
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    invalidate();
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    int i;
    if ((paramView != this.mTitleBar) && (paramView != this.mToolBar))
    {
      i = paramInt2;
      if (paramView != this.mInsideTitleBar) {}
    }
    else
    {
      int j = View.MeasureSpec.getMode(paramInt2);
      if (j != -2147483648)
      {
        i = paramInt2;
        if (j != 1073741824) {}
      }
      else
      {
        i = View.MeasureSpec.makeMeasureSpec(2147483647, -2147483648);
      }
    }
    super.measureChild(paramView, paramInt1, i);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      try
      {
        super.onDraw(paramCanvas);
        return;
      }
      catch (Exception paramCanvas)
      {
        QMLog.log(6, TAG, "onDraw:", paramCanvas);
        return;
      }
    }
    paramCanvas.save();
    if (this.mTitleBar != null)
    {
      int i = getScrollY();
      int j = getScrollX();
      this.mClipBounds.top = i;
      this.mClipBounds.left = j;
      this.mClipBounds.right = (this.mClipBounds.left + getWidth());
      this.mClipBounds.bottom = (this.mClipBounds.top + getHeight());
      paramCanvas.clipRect(this.mClipBounds);
      this.mMatrix.set(paramCanvas.getMatrix());
      j = getVisibleTitleHeightCompat();
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.mMatrix.postTranslate(0.0F, i);
      paramCanvas.setMatrix(this.mMatrix);
    }
    super.onDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onDrawVerticalScrollBar(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getScrollY();
    int i = paramInt2;
    if (j < 0) {
      i = paramInt2 - j;
    }
    paramDrawable.setBounds(paramInt1, i, paramInt3, paramInt4 - getVisibleTitleHeightCompat());
    paramDrawable.draw(paramCanvas);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    if (this.mIntercepted)
    {
      if (!this.mHasHandledDonwEvent)
      {
        paramMotionEvent.setAction(0);
        onTouchEvent(paramMotionEvent);
        paramMotionEvent.setAction(2);
      }
      bool = true;
    }
    return bool;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    scrollBegin();
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mOnScrollListener != null)
    {
      this.mOnScrollListener.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      getHandler().removeCallbacks(this.checkScrollIdle);
      getHandler().postDelayed(this.checkScrollIdle, ViewConfiguration.getScrollDefaultDelay());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getActionMasked() == 0) {
      this.mHasHandledDonwEvent = true;
    }
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
  
  public void resetContentHeight2()
  {
    QMLog.log(4, TAG, "resetContentHeight2:" + hashCode());
    Threads.runOnMainThread(new TitleBarWebView2.1(this));
    Threads.runOnMainThread(new TitleBarWebView2.2(this), 500L);
  }
  
  public void setEmbeddedTitleBarCompat(View paramView)
  {
    try
    {
      getClass().getMethod("setEmbeddedTitleBar", new Class[] { View.class }).invoke(this, new Object[] { paramView });
      this.mInsideTitleBar = paramView;
      return;
    }
    catch (Exception localException)
    {
      Log.d(TAG, "Native setEmbeddedTitleBar not available. Starting workaround");
      setEmbeddedTitleBarJellyBean(paramView);
    }
  }
  
  public void setEmbeddedToolBarCompat(View paramView)
  {
    if (this.mToolBar == paramView) {
      return;
    }
    if (this.mToolBar != null) {
      removeView(this.mToolBar);
    }
    if (paramView != null)
    {
      if ((paramView.getParent() != null) && ((paramView.getParent() instanceof ViewGroup))) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      addView(paramView, new AbsoluteLayout.LayoutParams(-1, -2, 0, 0));
    }
    this.mToolBar = paramView;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.mOldLongClickListener = paramOnLongClickListener;
  }
  
  public void setOnScrollChanged(OnScrollListener paramOnScrollListener)
  {
    this.mOnScrollListener = paramOnScrollListener;
  }
  
  public void setRealContentHeight(float paramFloat)
  {
    this.mRealContentHeight = ((int)paramFloat);
    this.hasSetContentHeight = true;
  }
  
  public void setScaleDensity(float paramFloat)
  {
    this.scaleDensity = paramFloat;
  }
  
  public void setSelectionRanger(int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mSelectingMode = bool;
      return;
    }
  }
  
  public void setZoomEnabled(boolean paramBoolean)
  {
    WebSettings localWebSettings = getSettings();
    if (localWebSettings != null)
    {
      localWebSettings.setSupportZoom(paramBoolean);
      localWebSettings.setBuiltInZoomControls(paramBoolean);
    }
  }
  
  public void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mScroller != null)
    {
      this.mScroller.abortAnimation();
      this.mScroller = null;
    }
    this.mScroller = new Scroller(getContext());
    smoothScrollBy(paramInt1 - getScrollX(), paramInt2 - getScrollY(), paramInt3);
  }
  
  public void smoothToToolBar()
  {
    View localView;
    int j;
    int k;
    int m;
    int n;
    if (this.mToolBar != null)
    {
      localView = this.mToolBar.findViewById(2131376803);
      localView.measure(-2147483648, 0);
      i = localView.getMeasuredHeight();
      j = (int)localView.getContext().getResources().getDimension(2131299235) + i;
      Log.v(TAG, "oneAttachmentHeight: " + j);
      k = getToolHeight();
      m = getHeight();
      n = calculateToolbarPosition();
      if (!needTitlebarFilled()) {
        break label296;
      }
    }
    int i1;
    label296:
    for (int i = 0;; i = getTitleHeightCompat())
    {
      i1 = getScrollY();
      Log.v(TAG, "smoothToToolBar th: " + k + ", oah:" + j + ", sy:" + i1 + ", " + (n + k - m) + ", " + (n - m));
      if ((k > j) || (i1 > n + k - m) || (i1 < n - m)) {
        break;
      }
      localView.setVisibility(0);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772036);
      localAnimation.setAnimationListener(new TitleBarWebView2.3(this, localView));
      localAnimation.setDuration(1000L);
      localView.setAnimation(localAnimation);
      invalidate();
      Log.v(TAG, "smoothToToolBar A: " + localView);
      return;
    }
    if (k > m)
    {
      Log.v(TAG, "smoothToToolBar B: " + (n - m) + ", scrollToY:" + Math.max(i + n - getVisibleTitleHeightCompat(), 0));
      smoothScrollTo(getScrollX(), Math.max(i + n - getVisibleTitleHeightCompat(), 0), -1);
      return;
    }
    Log.v(TAG, "smoothToToolBar C: " + (k + n - m) + ", scrollToY:" + (computeVerticalScrollRange() + i - m) + ", sy: " + i1 + ", sx:" + getScrollX());
    smoothScrollTo(getScrollX(), Math.max(0, i + computeVerticalScrollRange() - m), -1);
  }
  
  public void smoothToTop()
  {
    if (getScrollY() != 0) {
      smoothScrollTo(getScrollX(), 0, -1);
    }
  }
  
  public ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    try
    {
      paramCallback = super.startActionMode(paramCallback);
      return paramCallback;
    }
    catch (Exception paramCallback) {}
    return null;
  }
  
  public ActionMode startActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    try
    {
      paramCallback = super.startActionMode(paramCallback, paramInt);
      return paramCallback;
    }
    catch (Exception paramCallback) {}
    return null;
  }
  
  public static abstract interface OnScrollListener
  {
    public abstract void onScrollBegin();
    
    public abstract void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void onScrollEnd();
  }
  
  class TitleBarWrapperView
    extends FrameLayout
  {
    private float mMinScale = -1.0F;
    int mTitlebarHeight = -1;
    
    public TitleBarWrapperView(Context paramContext)
    {
      super();
      setId(2131379773);
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      if (!TitleBarWebView2.this.mTouchInTitleBar) {
        return false;
      }
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        if ((!bool) && (paramMotionEvent.getActionMasked() == 0)) {
          TitleBarWebView2.access$002(TitleBarWebView2.this, false);
        }
        return bool;
        TitleBarWebView2.access$002(TitleBarWebView2.this, false);
      }
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((TitleBarWebView2.this.mTitleBar == this) && (TitleBarWebView2.needTitlebarFilled()))
      {
        if (this.mMinScale < 0.0F) {
          this.mMinScale = TitleBarWebView2.this.getScale();
        }
        this.mTitlebarHeight = ((int)(TitleBarWebView2.this.getTitleHeightCompat() / this.mMinScale));
      }
      try
      {
        TitleBarWebView2.this.loadUrl("javascript:if(typeof window.updateTitleBar != \"undefined\"){window.updateTitleBar(" + this.mTitlebarHeight + ");}");
        return;
      }
      catch (Exception localException)
      {
        Log.e(TitleBarWebView2.TAG, "nTitleBarHeight", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.TitleBarWebView2
 * JD-Core Version:    0.7.0.1
 */