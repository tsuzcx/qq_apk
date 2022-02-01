package com.tencent.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filter.FilterListener;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import aqfp;
import auqs;
import aure;
import ause;
import ausf;
import autl;
import auup;
import auvm;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbsListView
  extends AdapterView<ListAdapter>
  implements TextWatcher, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener, Filter.FilterListener
{
  private static final int[] ABSLISTVIEW = getStyleableValues("AbsListView");
  private static final int ABSLISTVIEW_CACHECOLORHINT;
  private static final int ABSLISTVIEW_CHOICEMODE;
  private static final int ABSLISTVIEW_DRAWSELECTORONTOP = getStyleableValue("AbsListView_drawSelectorOnTop");
  private static final int ABSLISTVIEW_FASTSCROLLALWAYSVISIBLE;
  private static final int ABSLISTVIEW_FASTSCROLLENABLED;
  private static final int ABSLISTVIEW_LIST_SELECTOR = getStyleableValue("AbsListView_listSelector");
  private static final int ABSLISTVIEW_SCROLLINGCACHE;
  private static final int ABSLISTVIEW_SMOOTHSCROLLBAR;
  private static final int ABSLISTVIEW_STACKFROMBOTTOM;
  private static final int ABSLISTVIEW_TEXTFILTERENABLED;
  private static final int ABSLISTVIEW_TRANSCRIPTMODE;
  private static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
  public static final int CHOICE_MODE_MULTIPLE = 2;
  public static final int CHOICE_MODE_MULTIPLE_MODAL = 3;
  public static final int CHOICE_MODE_NONE = 0;
  public static final int CHOICE_MODE_SINGLE = 1;
  public static final int INVALID_POINTER = -1;
  static final int LAYOUT_FORCE_BOTTOM = 3;
  static final int LAYOUT_FORCE_TOP = 1;
  static final int LAYOUT_MOVE_SELECTION = 6;
  static final int LAYOUT_NORMAL = 0;
  static final int LAYOUT_SET_SELECTION = 2;
  static final int LAYOUT_SPECIFIC = 4;
  static final int LAYOUT_SPECIFIC_BOTTOM = 100;
  static final int LAYOUT_SYNC = 5;
  private static final int[] NOTHING = { 0 };
  static final int OVERSCROLL_LIMIT_DIVISOR = 3;
  private static final int OVER_FLING_DISTANCE = 30;
  public static final int OVER_SCROLL_TOUCH_MODE_FAST = 1;
  public static final int OVER_SCROLL_TOUCH_MODE_NORMAL = 0;
  private static final boolean PROFILE_FLINGING = false;
  private static final boolean PROFILE_SCROLLING = false;
  protected static final int TOUCH_MODE_DONE_WAITING = 2;
  protected static final int TOUCH_MODE_DOWN = 0;
  protected static final int TOUCH_MODE_FLING = 4;
  private static final int TOUCH_MODE_OFF = 1;
  private static final int TOUCH_MODE_ON = 0;
  protected static final int TOUCH_MODE_OVERFLING = 6;
  protected static final int TOUCH_MODE_OVERSCROLL = 5;
  protected static final int TOUCH_MODE_REST = -1;
  protected static final int TOUCH_MODE_SCROLL = 3;
  protected static final int TOUCH_MODE_TAP = 1;
  private static final int TOUCH_MODE_UNKNOWN = -1;
  public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
  public static final int TRANSCRIPT_MODE_DISABLED = 0;
  public static final int TRANSCRIPT_MODE_NORMAL = 1;
  private int mActivePointerId = -1;
  ListAdapter mAdapter;
  int mBottomOverflingDistance;
  private MoveToBottomScroller mBottomScroller;
  int mCacheColorHint;
  boolean mCachingActive;
  boolean mCachingStarted;
  private boolean mCallbackOnUnClickItem;
  SparseBooleanArray mCheckStates;
  aure<Integer> mCheckedIdStates;
  int mCheckedItemCount;
  ActionMode mChoiceActionMode;
  int mChoiceMode = 0;
  private Runnable mClearScrollingCache;
  private ContextMenu.ContextMenuInfo mContextMenuInfo;
  a mDataSetObserver;
  private InputConnection mDefInputConnection;
  private boolean mDeferNotifyDataSetChanged;
  private float mDensityScale;
  private int mDirection;
  private boolean mDisableOverScrollTop;
  boolean mDrawSelectorOnTop = false;
  private boolean mEdgeEffectEnabled;
  public autl mEdgeGlowBottom;
  public autl mEdgeGlowTop;
  public boolean mEnableStory;
  boolean mFastScrollEnabled;
  FastScroller mFastScroller;
  private boolean mFiltered;
  private int mFirstPositionDistanceGuess;
  private boolean mFlingProfilingStarted;
  private FlingRunnable mFlingRunnable;
  private Object mFlingStrictSpan;
  public boolean mForContacts;
  public boolean mForHongBao;
  public boolean mForStory;
  private boolean mForceTranscriptScroll;
  private boolean mGlobalLayoutListenerAddedFilter;
  private int mGlowPaddingLeft;
  private int mGlowPaddingRight;
  boolean mIsAttached;
  private boolean mIsChildViewEnabled;
  private boolean mIsNeedScrollPositionTop;
  final boolean[] mIsScrap = new boolean[1];
  private int mLastAccessibilityScrollEventFromIndex;
  private int mLastAccessibilityScrollEventToIndex;
  private int mLastHandledItemCount;
  private int mLastPositionDistanceGuess;
  private int mLastScrollState = 0;
  private int mLastTouchMode = -1;
  int mLastY;
  int mLayoutMode = 0;
  protected Rect mListPadding = new Rect();
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  int mMotionCorrection;
  int mMotionPosition;
  int mMotionViewNewTop;
  int mMotionViewOriginalTop;
  int mMotionX;
  int mMotionY;
  c mMultiChoiceModeCallback;
  private boolean mNeedCheckSpringback;
  private d mOnScrollButtomListener;
  private e mOnScrollListener;
  private ArrayList<e> mOnScrollListenerList = new ArrayList();
  private int mOverScrollMode;
  private int mOverScrollTouchMode = 0;
  int mOverscrollDistance;
  int mOverscrollMax;
  private CheckForKeyLongPress mPendingCheckForKeyLongPress;
  private CheckForLongPress mPendingCheckForLongPress;
  private Runnable mPendingCheckForTap;
  private PerformClick mPerformClick;
  PopupWindow mPopup;
  private boolean mPopupHidden;
  PositionScroller mPositionScroller;
  private InputConnectionWrapper mPublicInputConnection;
  final f mRecycler = new f();
  int mResurrectToPosition = -1;
  View mScrollDown;
  private boolean mScrollProfilingStarted;
  private Object mScrollStrictSpan;
  protected boolean mScrollToBottom;
  View mScrollUp;
  boolean mScrollingCacheEnabled;
  int mSelectedTop = 0;
  protected int mSelectionBottomPadding = 0;
  int mSelectionLeftPadding = 0;
  int mSelectionRightPadding = 0;
  int mSelectionTopPadding = 0;
  Drawable mSelector;
  int mSelectorPosition = -1;
  Rect mSelectorRect = new Rect();
  private boolean mSmoothScrollbarEnabled = true;
  boolean mStackFromBottom;
  EditText mTextFilter;
  private boolean mTextFilterEnabled;
  int mTopOverflingDistance;
  private Rect mTouchFrame;
  protected int mTouchMode = -1;
  private Runnable mTouchModeReset;
  private int mTouchSlop;
  private int mTranscriptMode;
  private float mVelocityScale = 1.0F;
  private VelocityTracker mVelocityTracker;
  int mWidthMeasureSpec = 0;
  Method method = null;
  
  static
  {
    ABSLISTVIEW_FASTSCROLLALWAYSVISIBLE = getStyleableValue("AbsListView_fastScrollAlwaysVisible");
    ABSLISTVIEW_CHOICEMODE = getStyleableValue("AbsListView_choiceMode");
    ABSLISTVIEW_SMOOTHSCROLLBAR = getStyleableValue("AbsListView_smoothScrollbar");
    ABSLISTVIEW_FASTSCROLLENABLED = getStyleableValue("AbsListView_fastScrollEnabled");
    ABSLISTVIEW_CACHECOLORHINT = getStyleableValue("AbsListView_cacheColorHint");
    ABSLISTVIEW_TRANSCRIPTMODE = getStyleableValue("AbsListView_transcriptMode");
    ABSLISTVIEW_TEXTFILTERENABLED = getStyleableValue("AbsListView_textFilterEnabled");
    ABSLISTVIEW_SCROLLINGCACHE = getStyleableValue("AbsListView_scrollingCache");
    ABSLISTVIEW_STACKFROMBOTTOM = getStyleableValue("AbsListView_stackFromBottom");
  }
  
  public AbsListView(Context paramContext)
  {
    super(paramContext);
    initAbsListView();
    setVerticalScrollBarEnabled(true);
    paramContext = paramContext.obtainStyledAttributes(getStyleableValues("View"));
    initializeScrollbars(paramContext);
    paramContext.recycle();
  }
  
  public AbsListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842858);
  }
  
  public AbsListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initAbsListView();
    paramContext = new auvm(paramContext.obtainStyledAttributes(paramAttributeSet, ABSLISTVIEW, paramInt, 0));
    try
    {
      paramAttributeSet = paramContext.getDrawable(ABSLISTVIEW_LIST_SELECTOR);
      if (paramAttributeSet != null) {
        setSelector(paramAttributeSet);
      }
    }
    catch (Throwable paramAttributeSet)
    {
      for (;;)
      {
        QLog.e("XListView", 1, "AbsListView init error:" + paramAttributeSet.getMessage());
      }
    }
    this.mDrawSelectorOnTop = paramContext.getBoolean(ABSLISTVIEW_DRAWSELECTORONTOP, false);
    setStackFromBottom(paramContext.getBoolean(ABSLISTVIEW_STACKFROMBOTTOM, false));
    setScrollingCacheEnabled(paramContext.getBoolean(ABSLISTVIEW_SCROLLINGCACHE, true));
    setTextFilterEnabled(paramContext.getBoolean(ABSLISTVIEW_TEXTFILTERENABLED, false));
    setTranscriptMode(paramContext.getInt(ABSLISTVIEW_TRANSCRIPTMODE, 0));
    setCacheColorHint(paramContext.getColor(ABSLISTVIEW_CACHECOLORHINT, 0));
    setFastScrollEnabled(paramContext.getBoolean(ABSLISTVIEW_FASTSCROLLENABLED, false));
    setSmoothScrollbarEnabled(paramContext.getBoolean(ABSLISTVIEW_SMOOTHSCROLLBAR, true));
    setChoiceMode(paramContext.getInt(ABSLISTVIEW_CHOICEMODE, 0));
    setFastScrollAlwaysVisible(paramContext.getBoolean(ABSLISTVIEW_FASTSCROLLALWAYSVISIBLE, false));
    paramContext.recycle();
  }
  
  private boolean acceptFilter()
  {
    return (this.mTextFilterEnabled) && ((getAdapter() instanceof Filterable)) && (((Filterable)getAdapter()).getFilter() != null);
  }
  
  private boolean checkScrap(ArrayList<View> paramArrayList)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramArrayList == null) {
      return bool2;
    }
    int j = paramArrayList.size();
    int i = 0;
    for (;;)
    {
      bool2 = bool1;
      if (i >= j) {
        break;
      }
      View localView = (View)paramArrayList.get(i);
      if (localView.getParent() != null) {
        bool1 = false;
      }
      if (indexOfChild(localView) >= 0) {
        bool1 = false;
      }
      i += 1;
    }
  }
  
  private void clearScrollingCache()
  {
    if (this.mClearScrollingCache == null) {
      this.mClearScrollingCache = new AbsListView.2(this);
    }
    Handler localHandler2 = getHandler();
    Handler localHandler1 = localHandler2;
    if (localHandler2 == null) {
      localHandler1 = new Handler(Looper.getMainLooper());
    }
    localHandler1.post(this.mClearScrollingCache);
  }
  
  private boolean contentFits()
  {
    int i = getChildCount();
    if (i == 0) {}
    do
    {
      return true;
      if (i != this.mItemCount) {
        return false;
      }
    } while ((getChildAt(0).getTop() >= this.mListPadding.top) && (getChildAt(i - 1).getBottom() <= getHeight() - this.mListPadding.bottom));
    return false;
  }
  
  private void createScrollingCache()
  {
    if ((this.mScrollingCacheEnabled) && (!this.mCachingStarted))
    {
      setChildrenDrawnWithCacheEnabled(true);
      setChildrenDrawingCacheEnabled(true);
      this.mCachingActive = true;
      this.mCachingStarted = true;
    }
  }
  
  private void createTextFilter(boolean paramBoolean)
  {
    if (this.mPopup == null)
    {
      Context localContext = getContext();
      PopupWindow localPopupWindow = new PopupWindow(localContext);
      this.mTextFilter = ((EditText)((LayoutInflater)localContext.getSystemService("layout_inflater")).inflate(2131563291, null));
      this.mTextFilter.setRawInputType(177);
      this.mTextFilter.setImeOptions(268435456);
      this.mTextFilter.addTextChangedListener(this);
      localPopupWindow.setFocusable(false);
      localPopupWindow.setTouchable(false);
      localPopupWindow.setInputMethodMode(2);
      localPopupWindow.setContentView(this.mTextFilter);
      localPopupWindow.setWidth(-2);
      localPopupWindow.setHeight(-2);
      localPopupWindow.setBackgroundDrawable(null);
      this.mPopup = localPopupWindow;
      getViewTreeObserver().addOnGlobalLayoutListener(this);
      this.mGlobalLayoutListenerAddedFilter = true;
    }
    if (paramBoolean)
    {
      this.mPopup.setAnimationStyle(2131755032);
      return;
    }
    this.mPopup.setAnimationStyle(2131755033);
  }
  
  private void dismissPopup()
  {
    if (this.mPopup != null) {
      this.mPopup.dismiss();
    }
  }
  
  private void dispatchStartTemporaryDetachForView(View paramView)
  {
    onDetachChildView(paramView);
    try
    {
      if (this.method == null) {
        this.method = View.class.getMethod("dispatchStartTemporaryDetach", new Class[0]);
      }
      this.method.invoke(paramView, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      paramView.onStartTemporaryDetach();
    }
  }
  
  private void drawSelector(Canvas paramCanvas)
  {
    if (!this.mSelectorRect.isEmpty())
    {
      Drawable localDrawable = this.mSelector;
      localDrawable.setBounds(this.mSelectorRect);
      localDrawable.draw(paramCanvas);
    }
  }
  
  @TargetApi(9)
  private Object enterCriticalSpan(String paramString)
  {
    return null;
  }
  
  private void finishGlows()
  {
    if (this.mEdgeGlowTop != null)
    {
      this.mEdgeGlowTop.finish();
      this.mEdgeGlowBottom.finish();
    }
  }
  
  @TargetApi(9)
  private Object finishSpan(Object paramObject)
  {
    return null;
  }
  
  static int getDistance(Rect paramRect1, Rect paramRect2, int paramInt)
  {
    int k;
    int j;
    int i;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
    case 66: 
      k = paramRect1.right;
      j = paramRect1.top + paramRect1.height() / 2;
      i = paramRect2.left;
      paramInt = paramRect2.top + paramRect2.height() / 2;
    }
    for (;;)
    {
      i -= k;
      paramInt -= j;
      return paramInt * paramInt + i * i;
      k = paramRect1.left + paramRect1.width() / 2;
      j = paramRect1.bottom;
      paramInt = paramRect2.left;
      i = paramRect2.width() / 2 + paramInt;
      paramInt = paramRect2.top;
      continue;
      k = paramRect1.left;
      j = paramRect1.top + paramRect1.height() / 2;
      i = paramRect2.right;
      paramInt = paramRect2.top + paramRect2.height() / 2;
      continue;
      k = paramRect1.left + paramRect1.width() / 2;
      j = paramRect1.top;
      paramInt = paramRect2.left;
      i = paramRect2.width() / 2 + paramInt;
      paramInt = paramRect2.bottom;
      continue;
      k = paramRect1.right + paramRect1.width() / 2;
      j = paramRect1.top + paramRect1.height() / 2;
      paramInt = paramRect2.left;
      i = paramRect2.width() / 2 + paramInt;
      paramInt = paramRect2.top + paramRect2.height() / 2;
    }
  }
  
  @TargetApi(9)
  private void initAbsListView()
  {
    setClickable(true);
    setFocusableInTouchMode(true);
    setWillNotDraw(false);
    setAlwaysDrawnWithCacheEnabled(false);
    setScrollingCacheEnabled(true);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    this.mMinimumVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    float f = getResources().getDisplayMetrics().density;
    this.mOverscrollDistance = ((int)(0.0F * f + 0.5F));
    int i = (int)(f * 30.0F + 0.5F);
    this.mBottomOverflingDistance = i;
    this.mTopOverflingDistance = i;
    this.mDensityScale = getContext().getResources().getDisplayMetrics().density;
    setOverScrollMode(0);
    setVerticalFadingEdgeEnabled(false);
  }
  
  private void initOrResetVelocityTracker()
  {
    if (this.mVelocityTracker == null)
    {
      this.mVelocityTracker = VelocityTracker.obtain();
      return;
    }
    this.mVelocityTracker.clear();
  }
  
  private void initVelocityTrackerIfNotExists()
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private boolean isValidPosition(int paramInt1, int paramInt2)
  {
    return (this.mItemCount > 0) && (paramInt1 != -1) && (paramInt1 < paramInt2);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i != 0) {
        break label65;
      }
    }
    label65:
    for (i = 1;; i = 0)
    {
      this.mMotionX = ((int)paramMotionEvent.getX(i));
      this.mMotionY = ((int)paramMotionEvent.getY(i));
      this.mMotionCorrection = 0;
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      return;
    }
  }
  
  private void positionPopup()
  {
    int i = getResources().getDisplayMetrics().heightPixels;
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    i = i - arrayOfInt[1] - getHeight() + (int)(this.mDensityScale * 20.0F);
    if (!this.mPopup.isShowing())
    {
      this.mPopup.showAtLocation(this, 81, arrayOfInt[0], i);
      return;
    }
    this.mPopup.update(arrayOfInt[0], i, -1, -1);
  }
  
  private void positionSelector(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mSelectorRect.set(paramInt1 - this.mSelectionLeftPadding, paramInt2 - this.mSelectionTopPadding, this.mSelectionRightPadding + paramInt3, this.mSelectionBottomPadding + paramInt4);
  }
  
  private void recycleVelocityTracker()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  static View retrieveFromScrap(ArrayList<View> paramArrayList, int paramInt)
  {
    int j = paramArrayList.size();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        View localView = (View)paramArrayList.get(i);
        if (((LayoutParams)localView.getLayoutParams()).scrappedFromPosition == paramInt)
        {
          paramArrayList.remove(i);
          return localView;
        }
        i += 1;
      }
      return (View)paramArrayList.remove(j - 1);
    }
    return null;
  }
  
  private int reviseOverScrollByTouch(int paramInt)
  {
    if (this.mScrollY * paramInt < 0) {}
    while (this.mLayoutHeight == 0) {
      return paramInt;
    }
    if (this.mOverScrollTouchMode == 1) {}
    for (paramInt = (this.mLayoutHeight - Math.abs(this.mScrollY)) * paramInt / this.mLayoutHeight * 2 / 3;; paramInt = (this.mLayoutHeight - Math.abs(this.mScrollY)) * paramInt / this.mLayoutHeight / 2) {
      return paramInt;
    }
  }
  
  @TargetApi(9)
  private void scrollIfNeeded(int paramInt)
  {
    int n = paramInt - this.mMotionY;
    int m = n - this.mMotionCorrection;
    int j;
    Object localObject;
    int i;
    if (this.mLastY != -2147483648)
    {
      j = paramInt - this.mLastY;
      if (this.mTouchMode != 3) {
        break label425;
      }
      if (this.mScrollStrictSpan == null) {
        this.mScrollStrictSpan = enterCriticalSpan("AbsListView-scroll");
      }
      if (paramInt != this.mLastY)
      {
        if (((this.mGroupFlags & 0x80000) == 0) && (Math.abs(n) > this.mTouchSlop))
        {
          localObject = getParent();
          if (localObject != null) {
            ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
          }
        }
        if (this.mMotionPosition < 0) {
          break label370;
        }
        i = this.mMotionPosition - this.mFirstPosition;
        label127:
        localObject = getChildAt(i);
        if (localObject == null) {
          break label774;
        }
      }
    }
    label385:
    label513:
    label774:
    for (int k = ((View)localObject).getTop();; k = 0)
    {
      if (j != 0) {}
      for (boolean bool = trackMotionScroll(m, j);; bool = false)
      {
        localObject = getChildAt(i);
        if (localObject != null)
        {
          i = ((View)localObject).getTop();
          if (bool)
          {
            j = -j - (i - k);
            k = reviseOverScrollByTouch(j);
            if ((this.mForHongBao) && (k > 0)) {
              break label380;
            }
            i = 1;
            label211:
            if (i != 0) {
              overScrollBy(0, k, 0, getScrollY(), 0, 0, 0, this.mOverscrollDistance, true);
            }
            if ((Math.abs(this.mOverscrollDistance) == Math.abs(getScrollY())) && (this.mVelocityTracker != null)) {
              this.mVelocityTracker.clear();
            }
            k = getOverScrollMode();
            if ((i != 0) && ((k == 0) || ((k == 1) && (!contentFits()))))
            {
              this.mDirection = 0;
              this.mTouchMode = 5;
              if (this.mEdgeGlowTop != null)
              {
                if (n <= 0) {
                  break label385;
                }
                this.mEdgeGlowTop.onPull(j / getHeight());
                if (!this.mEdgeGlowBottom.isFinished()) {
                  this.mEdgeGlowBottom.onRelease();
                }
              }
            }
          }
          label349:
          this.mMotionY = paramInt;
          invalidate();
        }
        else
        {
          this.mLastY = paramInt;
        }
        label370:
        label380:
        do
        {
          return;
          j = m;
          break;
          i = getChildCount() / 2;
          break label127;
          i = 0;
          break label211;
          if (n >= 0) {
            break label349;
          }
          this.mEdgeGlowBottom.onPull(j / getHeight());
          if (this.mEdgeGlowTop.isFinished()) {
            break label349;
          }
          this.mEdgeGlowTop.onRelease();
          break label349;
        } while ((this.mTouchMode != 5) || (paramInt == this.mLastY));
        label425:
        m = getScrollY();
        int i1 = m - j;
        if (paramInt > this.mLastY)
        {
          i = 1;
          if (this.mDirection == 0) {
            this.mDirection = i;
          }
          k = -j;
          if (((i1 >= 0) || (m < 0)) && ((i1 <= 0) || (m > 0))) {
            break label717;
          }
          m = -m;
          k = m;
          j += m;
          if (k != 0)
          {
            m = getScrollY();
            overScrollBy(0, reviseOverScrollByTouch(k), 0, m, 0, 0, 0, this.mOverscrollDistance, true);
            m = getOverScrollMode();
            if ((m == 0) || ((m == 1) && (!contentFits())))
            {
              if (this.mEdgeGlowTop != null)
              {
                if (n <= 0) {
                  break label722;
                }
                this.mEdgeGlowTop.onPull(k / getHeight());
                if (!this.mEdgeGlowBottom.isFinished()) {
                  this.mEdgeGlowBottom.onRelease();
                }
              }
              label616:
              invalidate();
            }
          }
          if (j != 0)
          {
            this.mScrollY = 0;
            invalidateParentIfNeeded();
            if (j != 0) {
              trackMotionScroll(j, j);
            }
            this.mTouchMode = 3;
            k = findClosestMotionRow(paramInt);
            this.mMotionCorrection = 0;
            localObject = getChildAt(k - this.mFirstPosition);
            if (localObject == null) {
              break label763;
            }
          }
        }
        label717:
        label722:
        label763:
        for (j = ((View)localObject).getTop();; j = 0)
        {
          this.mMotionViewOriginalTop = j;
          this.mMotionY = paramInt;
          this.mMotionPosition = k;
          this.mLastY = paramInt;
          this.mDirection = i;
          return;
          i = -1;
          break;
          j = 0;
          break label513;
          if (n >= 0) {
            break label616;
          }
          this.mEdgeGlowBottom.onPull(k / getHeight());
          if (this.mEdgeGlowTop.isFinished()) {
            break label616;
          }
          this.mEdgeGlowTop.onRelease();
          break label616;
        }
      }
    }
  }
  
  private void showPopup()
  {
    if (getWindowVisibility() == 0)
    {
      createTextFilter(true);
      positionPopup();
      checkFocus();
    }
  }
  
  private void useDefaultSelector()
  {
    setSelector(getResources().getDrawable(17301602));
  }
  
  protected void abordFling()
  {
    if (this.mFlingRunnable != null) {
      this.mFlingRunnable.ewF();
    }
  }
  
  public void addChildrenForAccessibility(ArrayList<View> paramArrayList)
  {
    int j;
    int i;
    do
    {
      try
      {
        super.addChildrenForAccessibility(paramArrayList);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        j = getChildCount();
        i = 0;
      }
    } while (i >= j);
    View localView = getChildAt(i);
    if (localView.getVisibility() == 0)
    {
      if (!localView.includeForAccessibility()) {
        break label57;
      }
      paramArrayList.add(localView);
    }
    for (;;)
    {
      i += 1;
      break;
      label57:
      localView.addChildrenForAccessibility(paramArrayList);
    }
  }
  
  public void addOnScrollListener(e parame)
  {
    this.mOnScrollListenerList.add(parame);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int j = getChildCount();
    int k = this.mFirstPosition;
    ListAdapter localListAdapter = this.mAdapter;
    if (localListAdapter == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        if (localListAdapter.isEnabled(k + i)) {
          paramArrayList.add(localView);
        }
        localView.addTouchables(paramArrayList);
        i += 1;
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    return paramView == this.mTextFilter;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void clearChoices()
  {
    if (this.mCheckStates != null) {
      this.mCheckStates.clear();
    }
    if (this.mCheckedIdStates != null) {
      this.mCheckedIdStates.clear();
    }
    this.mCheckedItemCount = 0;
  }
  
  public void clearTextFilter()
  {
    if (this.mFiltered)
    {
      this.mTextFilter.setText("");
      this.mFiltered = false;
      if ((this.mPopup != null) && (this.mPopup.isShowing())) {
        dismissPopup();
      }
    }
  }
  
  protected int computeVerticalScrollExtent()
  {
    int k = getChildCount();
    if (k > 0)
    {
      if (this.mSmoothScrollbarEnabled)
      {
        int j = k * 100;
        View localView = getChildAt(0);
        int m = localView.getTop();
        int n = localView.getHeight();
        int i = j;
        if (n > 0) {
          i = j + m * 100 / n;
        }
        localView = getChildAt(k - 1);
        k = localView.getBottom();
        m = localView.getHeight();
        j = i;
        if (m > 0) {
          j = i - (k - getHeight()) * 100 / m;
        }
        return j;
      }
      return 1;
    }
    return 0;
  }
  
  protected int computeVerticalScrollOffset()
  {
    int k = 0;
    int j = 0;
    int m = this.mFirstPosition;
    int n = getChildCount();
    int i = j;
    if (m >= 0)
    {
      i = j;
      if (n > 0)
      {
        if (!this.mSmoothScrollbarEnabled) {
          break label91;
        }
        View localView = getChildAt(0);
        k = localView.getTop();
        n = localView.getHeight();
        i = j;
        if (n > 0) {
          i = Math.max(m * 100 - k * 100 / n, 0);
        }
      }
    }
    return i;
    label91:
    j = this.mItemCount;
    if (m == 0) {
      i = k;
    }
    for (;;)
    {
      float f1 = m;
      float f2 = n;
      return (int)(i / j * f2 + f1);
      if (m + n == j) {
        i = j;
      } else {
        i = n / 2 + m;
      }
    }
  }
  
  protected int computeVerticalScrollRange()
  {
    if (this.mSmoothScrollbarEnabled) {
      return Math.max(this.mItemCount * 100, 0);
    }
    return this.mItemCount;
  }
  
  @TargetApi(11)
  void confirmCheckedPositionsById()
  {
    this.mCheckStates.clear();
    int i = 0;
    int j = 0;
    long l;
    int n;
    int k;
    if (i < this.mCheckedIdStates.size())
    {
      l = this.mCheckedIdStates.keyAt(i);
      n = ((Integer)this.mCheckedIdStates.valueAt(i)).intValue();
      if (l != this.mAdapter.getItemId(n))
      {
        k = Math.max(0, n - 20);
        m = Math.min(n + 20, this.mItemCount);
        label89:
        if (k >= m) {
          break label251;
        }
        if (l == this.mAdapter.getItemId(k))
        {
          this.mCheckStates.put(k, true);
          this.mCheckedIdStates.setValueAt(i, Integer.valueOf(k));
        }
      }
    }
    label251:
    for (int m = 1;; m = 0)
    {
      k = i;
      if (m == 0)
      {
        this.mCheckedIdStates.delete(l);
        this.mCheckedItemCount -= 1;
        if ((this.mChoiceActionMode != null) && (this.mMultiChoiceModeCallback != null)) {
          this.mMultiChoiceModeCallback.onItemCheckedStateChanged(this.mChoiceActionMode, n, l, false);
        }
        k = i - 1;
        j = 1;
      }
      for (i = j;; i = j)
      {
        j = i;
        i = k + 1;
        break;
        k += 1;
        break label89;
        this.mCheckStates.put(n, true);
        k = i;
      }
      if ((j != 0) && (this.mChoiceActionMode != null)) {
        this.mChoiceActionMode.invalidate();
      }
      return;
    }
  }
  
  ContextMenu.ContextMenuInfo createContextMenuInfo(View paramView, int paramInt, long paramLong)
  {
    return new AdapterView.a(paramView, paramInt, paramLong);
  }
  
  public void deferNotifyDataSetChanged()
  {
    this.mDeferNotifyDataSetChanged = true;
  }
  
  public void disableOverScrollTop(boolean paramBoolean)
  {
    this.mDisableOverScrollTop = paramBoolean;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int j = 0;
    if ((this.mGroupFlags & 0x22) == 34) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        j = paramCanvas.save();
        int k = getScrollX();
        int m = getScrollY();
        paramCanvas.clipRect(this.mPaddingLeft + k, this.mPaddingTop + m, k + this.mRight - this.mLeft - this.mPaddingRight, m + this.mBottom - this.mTop - this.mPaddingBottom);
        this.mGroupFlags &= 0xFFFFFFDD;
      }
      boolean bool = this.mDrawSelectorOnTop;
      if (!bool) {
        drawSelector(paramCanvas);
      }
      super.dispatchDraw(paramCanvas);
      if (bool) {
        drawSelector(paramCanvas);
      }
      if (i != 0)
      {
        paramCanvas.restoreToCount(j);
        this.mGroupFlags |= 0x22;
      }
      return;
    }
  }
  
  protected void dispatchFinishTemporaryDetachForView(View paramView)
  {
    try
    {
      View.class.getMethod("dispatchFinishTemporaryDetach", new Class[0]).invoke(paramView, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      paramView.onFinishTemporaryDetach();
    }
  }
  
  protected void dispatchSetPressed(boolean paramBoolean) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (this.mNeedCheckSpringback) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
    }
    for (;;)
    {
      return bool;
      if ((this.mTouchMode == -1) && (Math.abs(this.mScrollY) > this.mTouchSlop))
      {
        if (this.mFlingRunnable == null) {
          this.mFlingRunnable = new FlingRunnable();
        }
        int i = 0;
        if ((this.mForHongBao) || (this.mForStory)) {
          i = getSpringbackOffset();
        }
        if (this.mForStory) {
          if (i != getScrollY()) {
            this.mFlingRunnable.abb(i);
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.i("ListViewOverScroll", 2, this.mForHongBao + "| absList dispatchTouchEvent, mScrollY:" + this.mScrollY + " targetY: " + i);
          return bool;
          this.mFlingRunnable.abb(i);
        }
      }
    }
  }
  
  protected void doSpringBack(int paramInt)
  {
    if (this.mFlingRunnable == null) {
      this.mFlingRunnable = new FlingRunnable();
    }
    this.mFlingRunnable.abb(paramInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i;
    int j;
    if (this.mEdgeGlowTop != null)
    {
      i = this.mScrollY;
      int k;
      int m;
      int n;
      if (!this.mEdgeGlowTop.isFinished())
      {
        j = paramCanvas.save();
        k = this.mListPadding.left + this.mGlowPaddingLeft;
        m = this.mListPadding.right;
        n = this.mGlowPaddingRight;
        int i1 = getWidth();
        paramCanvas.translate(k, Math.min(0, this.mFirstPositionDistanceGuess + i));
        this.mEdgeGlowTop.setSize(i1 - k - (m + n), getHeight());
        if (this.mEdgeGlowTop.draw(paramCanvas)) {
          invalidate();
        }
        paramCanvas.restoreToCount(j);
      }
      if (!this.mEdgeGlowBottom.isFinished())
      {
        j = paramCanvas.save();
        k = this.mListPadding.left + this.mGlowPaddingLeft;
        m = this.mListPadding.right;
        n = this.mGlowPaddingRight;
        m = getWidth() - k - (m + n);
        n = getHeight();
        paramCanvas.translate(k + -m, Math.max(n, i + this.mLastPositionDistanceGuess));
        paramCanvas.rotate(180.0F, m, 0.0F);
        this.mEdgeGlowBottom.setSize(m, n);
        if (this.mEdgeGlowBottom.draw(paramCanvas)) {
          invalidate();
        }
        paramCanvas.restoreToCount(j);
      }
    }
    if (this.mFastScroller != null)
    {
      i = this.mScrollY;
      if (i != 0)
      {
        j = paramCanvas.save();
        paramCanvas.translate(0.0F, i);
        this.mFastScroller.draw(paramCanvas);
        paramCanvas.restoreToCount(j);
      }
    }
    else
    {
      return;
    }
    this.mFastScroller.draw(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    updateSelectorState();
  }
  
  abstract void fillGap(boolean paramBoolean);
  
  protected int findClosestMotionRow(int paramInt)
  {
    int j = getChildCount();
    if (j == 0) {
      paramInt = -1;
    }
    int i;
    do
    {
      return paramInt;
      i = findMotionRow(paramInt);
      paramInt = i;
    } while (i != -1);
    return this.mFirstPosition + j - 1;
  }
  
  abstract int findMotionRow(int paramInt);
  
  protected void flingForCancel()
  {
    int i = getChildCount();
    int j;
    int k;
    int m;
    int n;
    if (i > 0)
    {
      j = getChildAt(0).getTop();
      k = getChildAt(i - 1).getBottom();
      m = this.mListPadding.top;
      n = getHeight() - this.mListPadding.bottom;
      if ((this.mFirstPosition != 0) || (j < m) || (this.mFirstPosition + i >= this.mItemCount) || (k > getHeight() - n)) {
        break label102;
      }
      this.mTouchMode = -1;
      reportScrollStateChange(0);
    }
    label102:
    do
    {
      return;
      VelocityTracker localVelocityTracker = this.mVelocityTracker;
      localVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
      if (VersionUtils.isrFroyo()) {}
      for (float f = localVelocityTracker.getYVelocity(this.mActivePointerId);; f = localVelocityTracker.getYVelocity())
      {
        int i1 = (int)(f * this.mVelocityScale);
        if ((Math.abs(i1) <= this.mMinimumVelocity) || ((this.mFirstPosition == 0) && (j == m - this.mOverscrollDistance)) || ((i + this.mFirstPosition == this.mItemCount) && (k == this.mOverscrollDistance + n))) {
          break;
        }
        if (this.mFlingRunnable == null) {
          this.mFlingRunnable = new FlingRunnable();
        }
        reportScrollStateChange(2);
        this.mFlingRunnable.start(-i1);
        return;
      }
      this.mTouchMode = -1;
      reportScrollStateChange(0);
      if (this.mFlingRunnable != null) {
        this.mFlingRunnable.ewF();
      }
      if (this.mPositionScroller != null) {
        this.mPositionScroller.stop();
      }
    } while (this.mBottomScroller == null);
    this.mBottomScroller.stop();
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -2, 0);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    int i = getChildCount();
    float f1 = super.getBottomFadingEdgeStrength();
    if (i == 0) {}
    int j;
    float f2;
    do
    {
      return f1;
      if (this.mFirstPosition + i - 1 < this.mItemCount - 1) {
        return 1.0F;
      }
      i = getChildAt(i - 1).getBottom();
      j = getHeight();
      f2 = getVerticalFadingEdgeLength();
    } while (i <= j - this.mPaddingBottom);
    return (i - j + this.mPaddingBottom) / f2;
  }
  
  protected int getBottomPaddingOffset()
  {
    if ((this.mGroupFlags & 0x22) == 34) {
      return 0;
    }
    return this.mPaddingBottom;
  }
  
  @ViewDebug.ExportedProperty(category="drawing")
  public int getCacheColorHint()
  {
    return this.mCacheColorHint;
  }
  
  public int getCheckedItemCount()
  {
    return this.mCheckedItemCount;
  }
  
  public long[] getCheckedItemIds()
  {
    int i = 0;
    Object localObject;
    if ((this.mChoiceMode == 0) || (this.mCheckedIdStates == null) || (this.mAdapter == null))
    {
      localObject = new long[0];
      return localObject;
    }
    aure localaure = this.mCheckedIdStates;
    int j = localaure.size();
    long[] arrayOfLong = new long[j];
    for (;;)
    {
      localObject = arrayOfLong;
      if (i >= j) {
        break;
      }
      arrayOfLong[i] = localaure.keyAt(i);
      i += 1;
    }
  }
  
  public int getCheckedItemPosition()
  {
    if ((this.mChoiceMode == 1) && (this.mCheckStates != null) && (this.mCheckStates.size() == 1)) {
      return this.mCheckStates.keyAt(0);
    }
    return -1;
  }
  
  public SparseBooleanArray getCheckedItemPositions()
  {
    if (this.mChoiceMode != 0) {
      return this.mCheckStates;
    }
    return null;
  }
  
  public int getChoiceMode()
  {
    return this.mChoiceMode;
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.mContextMenuInfo;
  }
  
  public float getFlingVelocity()
  {
    if ((this.mFlingRunnable != null) && (FlingRunnable.a(this.mFlingRunnable) != null)) {
      return FlingRunnable.a(this.mFlingRunnable).getCurrVelocity();
    }
    return -1.0F;
  }
  
  public float getFlingVelocityY()
  {
    if ((this.mFlingRunnable != null) && (FlingRunnable.a(this.mFlingRunnable) != null)) {
      return FlingRunnable.a(this.mFlingRunnable).getCurrVelocityY();
    }
    return -1.0F;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    View localView = getSelectedView();
    if ((localView != null) && (localView.getParent() == this))
    {
      localView.getFocusedRect(paramRect);
      offsetDescendantRectToMyCoords(localView, paramRect);
      return;
    }
    super.getFocusedRect(paramRect);
  }
  
  int getFooterViewsCount()
  {
    return 0;
  }
  
  protected int getHeaderViewsCount()
  {
    return 0;
  }
  
  protected int getLeftPaddingOffset()
  {
    if ((this.mGroupFlags & 0x22) == 34) {
      return 0;
    }
    return -getPaddingLeft();
  }
  
  public int getListPaddingBottom()
  {
    return this.mListPadding.bottom;
  }
  
  public int getListPaddingLeft()
  {
    return this.mListPadding.left;
  }
  
  public int getListPaddingRight()
  {
    return this.mListPadding.right;
  }
  
  public int getListPaddingTop()
  {
    return this.mListPadding.top;
  }
  
  public e getOnScrollListener()
  {
    return this.mOnScrollListener;
  }
  
  public int getOverScrollMode()
  {
    return this.mOverScrollMode;
  }
  
  public int getRemainFlingDisY()
  {
    if (this.mFlingRunnable != null) {
      return FlingRunnable.a(this.mFlingRunnable).getFinalY() - FlingRunnable.a(this.mFlingRunnable).getCurrY();
    }
    return -1;
  }
  
  protected int getRightPaddingOffset()
  {
    if ((this.mGroupFlags & 0x22) == 34) {
      return 0;
    }
    return this.mPaddingRight;
  }
  
  @ViewDebug.ExportedProperty
  public View getSelectedView()
  {
    if ((this.mItemCount > 0) && (this.mSelectedPosition >= 0) && (this.mSelectedPosition < this.mItemCount)) {
      return getChildAt(this.mSelectedPosition - this.mFirstPosition);
    }
    return null;
  }
  
  public Drawable getSelector()
  {
    return this.mSelector;
  }
  
  public int getSolidColor()
  {
    return this.mCacheColorHint;
  }
  
  protected int getSpringbackOffset()
  {
    return 0;
  }
  
  public CharSequence getTextFilter()
  {
    if ((this.mTextFilterEnabled) && (this.mTextFilter != null)) {
      return this.mTextFilter.getText();
    }
    return null;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    int i = getChildCount();
    float f1 = super.getTopFadingEdgeStrength();
    if (i == 0) {}
    float f2;
    do
    {
      return f1;
      if (this.mFirstPosition > 0) {
        return 1.0F;
      }
      i = getChildAt(0).getTop();
      f2 = getVerticalFadingEdgeLength();
    } while (i >= this.mPaddingTop);
    return -(i - this.mPaddingTop) / f2;
  }
  
  protected int getTopPaddingOffset()
  {
    if ((this.mGroupFlags & 0x22) == 34) {
      return 0;
    }
    return -getPaddingTop();
  }
  
  public int getTranscriptMode()
  {
    return this.mTranscriptMode;
  }
  
  public int getVerticalScrollbarWidth()
  {
    if (isFastScrollAlwaysVisible()) {
      return Math.max(super.getVerticalScrollbarWidth(), this.mFastScroller.getWidth());
    }
    return super.getVerticalScrollbarWidth();
  }
  
  protected void handleDataChanged()
  {
    int k = this.mItemCount;
    int m = this.mLastHandledItemCount;
    this.mLastHandledItemCount = this.mItemCount;
    if ((this.mChoiceMode != 0) && (this.mAdapter != null) && (this.mAdapter.hasStableIds())) {
      confirmCheckedPositionsById();
    }
    if (k > 0)
    {
      if (this.mNeedSync)
      {
        this.mNeedSync = false;
        if (this.mTranscriptMode == 2) {
          this.mScrollToBottom = true;
        }
      }
      else
      {
        switch (this.mSyncMode)
        {
        default: 
          label108:
          if (!isInTouchMode())
          {
            j = getSelectedItemPosition();
            i = j;
            if (j >= k) {
              i = k - 1;
            }
            j = i;
            if (i < 0) {
              j = 0;
            }
            i = lookForSelectablePosition(j, true);
            if (i >= 0) {
              setNextSelectedPositionInt(i);
            }
          }
          break;
        }
      }
      while (this.mResurrectToPosition >= 0)
      {
        return;
        if (this.mTranscriptMode != 1) {
          break;
        }
        if (this.mForceTranscriptScroll)
        {
          this.mForceTranscriptScroll = false;
          this.mScrollToBottom = true;
          break;
        }
        if (getChildCount() <= 0) {
          break;
        }
        int n = getChildCount();
        int j = getHeight() - this.mPaddingBottom;
        View localView = getChildAt(n - 1);
        if (localView != null) {}
        for (i = localView.getBottom(); (n + this.mFirstPosition >= m) && (i <= j); i = j)
        {
          this.mLayoutMode = 3;
          return;
        }
        if (isInTouchMode())
        {
          this.mLayoutMode = 5;
          this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), k - 1);
          return;
        }
        i = findSyncPosition();
        if ((i < 0) || (lookForSelectablePosition(i, true) != i)) {
          break label108;
        }
        this.mSyncPosition = i;
        if (this.mSyncHeight == getHeight()) {}
        for (this.mLayoutMode = 5;; this.mLayoutMode = 2)
        {
          setNextSelectedPositionInt(i);
          return;
        }
        this.mLayoutMode = 5;
        this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), k - 1);
        return;
        this.mLayoutMode = 5;
        this.mSyncPosition = Math.max(Math.min(this.mSyncPosition, k - 1), 0);
        return;
        i = lookForSelectablePosition(j, false);
        if (i < 0) {
          break label415;
        }
        setNextSelectedPositionInt(i);
        return;
      }
    }
    label415:
    if (this.mStackFromBottom) {}
    for (int i = 3;; i = 1)
    {
      this.mLayoutMode = i;
      this.mSelectedPosition = -1;
      this.mSelectedRowId = -9223372036854775808L;
      this.mNextSelectedPosition = -1;
      this.mNextSelectedRowId = -9223372036854775808L;
      this.mNeedSync = false;
      this.mSelectorPosition = -1;
      checkSelectionChanged();
      return;
    }
  }
  
  public boolean hasTextFilter()
  {
    return this.mFiltered;
  }
  
  void hideSelector()
  {
    if (this.mSelectedPosition != -1)
    {
      if (this.mLayoutMode != 4) {
        this.mResurrectToPosition = this.mSelectedPosition;
      }
      if ((this.mNextSelectedPosition >= 0) && (this.mNextSelectedPosition != this.mSelectedPosition)) {
        this.mResurrectToPosition = this.mNextSelectedPosition;
      }
      setSelectedPositionInt(-1);
      setNextSelectedPositionInt(-1);
      this.mSelectedTop = 0;
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (verifyDrawable(paramDrawable)) {
      invalidate(paramDrawable.getBounds());
    }
  }
  
  public void invalidateViews()
  {
    this.mDataChanged = true;
    rememberSyncState();
    requestLayout();
    invalidate();
  }
  
  void invokeOnItemScrollListener()
  {
    if (this.mFastScroller != null) {
      this.mFastScroller.onScroll(this, this.mFirstPosition, getChildCount(), this.mItemCount);
    }
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScroll(this, this.mFirstPosition, getChildCount(), this.mItemCount);
    }
    Iterator localIterator = this.mOnScrollListenerList.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).onScroll(this, this.mFirstPosition, getChildCount(), this.mItemCount);
    }
    onScrollChanged(0, 0, 0, 0);
  }
  
  public boolean isFastScrollAlwaysVisible()
  {
    return (this.mFastScrollEnabled) && (this.mFastScroller.aJM());
  }
  
  @ViewDebug.ExportedProperty
  public boolean isFastScrollEnabled()
  {
    return this.mFastScrollEnabled;
  }
  
  protected boolean isInFilterMode()
  {
    return this.mFiltered;
  }
  
  public boolean isItemChecked(int paramInt)
  {
    if ((this.mChoiceMode != 0) && (this.mCheckStates != null)) {
      return this.mCheckStates.get(paramInt);
    }
    return false;
  }
  
  protected boolean isPaddingOffsetRequired()
  {
    return (this.mGroupFlags & 0x22) != 34;
  }
  
  @ViewDebug.ExportedProperty
  public boolean isScrollingCacheEnabled()
  {
    return this.mScrollingCacheEnabled;
  }
  
  @ViewDebug.ExportedProperty
  public boolean isSmoothScrollbarEnabled()
  {
    return this.mSmoothScrollbarEnabled;
  }
  
  @ViewDebug.ExportedProperty
  public boolean isStackFromBottom()
  {
    return this.mStackFromBottom;
  }
  
  @ViewDebug.ExportedProperty
  public boolean isTextFilterEnabled()
  {
    return this.mTextFilterEnabled;
  }
  
  protected boolean isVerticalScrollBarHidden()
  {
    return (this.mFastScroller != null) && (this.mFastScroller.isVisible());
  }
  
  @TargetApi(11)
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.mSelector != null) {
      this.mSelector.jumpToCurrentState();
    }
  }
  
  void keyPressed()
  {
    if ((!isEnabled()) || (!isClickable())) {}
    for (;;)
    {
      return;
      Drawable localDrawable = this.mSelector;
      Object localObject = this.mSelectorRect;
      if ((localDrawable != null) && ((isFocused()) || (touchModeDrawsInPressedState())) && (!((Rect)localObject).isEmpty()))
      {
        localObject = getChildAt(this.mSelectedPosition - this.mFirstPosition);
        if (localObject != null)
        {
          if (!((View)localObject).hasFocusable()) {
            ((View)localObject).setPressed(true);
          }
        }
        else
        {
          setPressed(true);
          boolean bool = isLongClickable();
          localDrawable = localDrawable.getCurrent();
          if ((localDrawable != null) && ((localDrawable instanceof TransitionDrawable)))
          {
            if (!bool) {
              break label172;
            }
            ((TransitionDrawable)localDrawable).startTransition(ViewConfiguration.getLongPressTimeout());
          }
          while ((bool) && (!this.mDataChanged))
          {
            if (this.mPendingCheckForKeyLongPress == null) {
              this.mPendingCheckForKeyLongPress = new CheckForKeyLongPress(null);
            }
            this.mPendingCheckForKeyLongPress.cCe();
            postDelayed(this.mPendingCheckForKeyLongPress, ViewConfiguration.getLongPressTimeout());
            return;
            label172:
            ((TransitionDrawable)localDrawable).resetTransition();
          }
        }
      }
    }
  }
  
  protected void layoutChildren() {}
  
  protected a newObserver()
  {
    return new a();
  }
  
  View obtainView(int paramInt, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = false;
    View localView2 = this.mRecycler.getScrapView(paramInt);
    View localView1;
    if (localView2 != null)
    {
      localView1 = this.mAdapter.getView(paramInt, localView2, this);
      if (ViewCompat.getImportantForAccessibility(localView1) == 0) {
        ViewCompat.setImportantForAccessibility(localView1, 1);
      }
      if (localView1 != localView2)
      {
        this.mRecycler.addScrapView(localView2, paramInt);
        paramArrayOfBoolean = localView1;
        if (this.mCacheColorHint != 0)
        {
          localView1.setDrawingCacheBackgroundColor(this.mCacheColorHint);
          paramArrayOfBoolean = localView1;
        }
      }
    }
    for (;;)
    {
      onAttachChildView(paramArrayOfBoolean);
      return paramArrayOfBoolean;
      paramArrayOfBoolean[0] = true;
      dispatchFinishTemporaryDetachForView(localView1);
      paramArrayOfBoolean = localView1;
      continue;
      localView1 = this.mAdapter.getView(paramInt, null, this);
      if (this.mCacheColorHint != 0) {
        localView1.setDrawingCacheBackgroundColor(this.mCacheColorHint);
      }
      paramArrayOfBoolean = localView1;
      if (localView1 != null)
      {
        paramArrayOfBoolean = localView1;
        if (ViewCompat.getImportantForAccessibility(localView1) == 0)
        {
          ViewCompat.setImportantForAccessibility(localView1, 1);
          paramArrayOfBoolean = localView1;
        }
      }
    }
  }
  
  protected void onAttachChildView(View paramView) {}
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    localViewTreeObserver.addOnTouchModeChangeListener(this);
    if ((this.mTextFilterEnabled) && (this.mPopup != null) && (!this.mGlobalLayoutListenerAddedFilter)) {
      localViewTreeObserver.addOnGlobalLayoutListener(this);
    }
    if ((this.mAdapter != null) && (this.mDataSetObserver == null))
    {
      this.mDataSetObserver = newObserver();
      this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
      this.mDataChanged = true;
      this.mOldItemCount = this.mItemCount;
      this.mItemCount = this.mAdapter.getCount();
      requestLayout();
    }
    this.mIsAttached = true;
  }
  
  protected boolean onConsistencyCheck(int paramInt)
  {
    boolean bool1 = super.onConsistencyCheck(paramInt);
    if ((paramInt & 0x1) != 0) {}
    boolean bool2;
    for (paramInt = 1;; paramInt = 0)
    {
      bool2 = bool1;
      if (paramInt == 0) {
        break label121;
      }
      localObject = f.a(this.mRecycler);
      i = localObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        if (localObject[paramInt] != null) {
          bool1 = false;
        }
        paramInt += 1;
      }
    }
    if (!checkScrap(f.a(this.mRecycler))) {
      bool1 = false;
    }
    Object localObject = f.a(this.mRecycler);
    int i = localObject.length;
    paramInt = 0;
    for (;;)
    {
      bool2 = bool1;
      if (paramInt >= i) {
        break;
      }
      if (!checkScrap(localObject[paramInt])) {
        bool1 = false;
      }
      paramInt += 1;
    }
    label121:
    return bool2;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    Object localObject;
    if (this.mIsChildViewEnabled)
    {
      localObject = super.onCreateDrawableState(paramInt);
      return localObject;
    }
    int i = ENABLED_STATE_SET[0];
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    paramInt = arrayOfInt.length - 1;
    label36:
    if (paramInt >= 0) {
      if (arrayOfInt[paramInt] != i) {}
    }
    for (;;)
    {
      localObject = arrayOfInt;
      if (paramInt < 0) {
        break;
      }
      System.arraycopy(arrayOfInt, paramInt + 1, arrayOfInt, paramInt, arrayOfInt.length - paramInt - 1);
      return arrayOfInt;
      paramInt -= 1;
      break label36;
      paramInt = -1;
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    if (isTextFilterEnabled())
    {
      createTextFilter(false);
      if (this.mPublicInputConnection == null)
      {
        this.mDefInputConnection = new BaseInputConnection(this, false);
        this.mPublicInputConnection = new ause(this, this.mTextFilter.onCreateInputConnection(paramEditorInfo), true);
      }
      paramEditorInfo.inputType = 177;
      paramEditorInfo.imeOptions = 6;
      return this.mPublicInputConnection;
    }
    return null;
  }
  
  protected void onDetachChildView(View paramView) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    dismissPopup();
    try
    {
      this.mRecycler.clear();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      localViewTreeObserver.removeOnTouchModeChangeListener(this);
      if ((this.mTextFilterEnabled) && (this.mPopup != null))
      {
        localViewTreeObserver.removeGlobalOnLayoutListener(this);
        this.mGlobalLayoutListenerAddedFilter = false;
      }
      if ((this.mAdapter != null) && (this.mDataSetObserver != null))
      {
        this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
        this.mDataSetObserver = null;
      }
      if (this.mScrollStrictSpan != null) {
        this.mScrollStrictSpan = finishSpan(this.mScrollStrictSpan);
      }
      if (this.mFlingStrictSpan != null) {
        this.mFlingStrictSpan = finishSpan(this.mFlingStrictSpan);
      }
      if (this.mFlingRunnable != null) {
        removeCallbacks(this.mFlingRunnable);
      }
      if (this.mPositionScroller != null) {
        this.mPositionScroller.stop();
      }
      if (this.mBottomScroller != null) {
        this.mBottomScroller.stop();
      }
      if (this.mClearScrollingCache != null) {
        removeCallbacks(this.mClearScrollingCache);
      }
      if (this.mPerformClick != null) {
        removeCallbacks(this.mPerformClick);
      }
      if (this.mTouchModeReset != null)
      {
        removeCallbacks(this.mTouchModeReset);
        this.mTouchModeReset = null;
      }
      this.mIsAttached = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void onDisplayHint(int paramInt)
  {
    super.onDisplayHint(paramInt);
    switch (paramInt)
    {
    default: 
      if (paramInt != 4) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.mPopupHidden = bool;
      return;
      if ((this.mPopup == null) || (!this.mPopup.isShowing())) {
        break;
      }
      dismissPopup();
      break;
      if ((!this.mFiltered) || (this.mPopup == null) || (this.mPopup.isShowing())) {
        break;
      }
      showPopup();
      break;
    }
  }
  
  protected void onDrawVerticalScrollBar(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramDrawable.setBounds(paramInt1, this.mScrollY + paramInt2, paramInt3, this.mScrollY + paramInt4);
    paramDrawable.draw(paramCanvas);
  }
  
  public void onFilterComplete(int paramInt)
  {
    if ((this.mSelectedPosition < 0) && (paramInt > 0))
    {
      this.mResurrectToPosition = -1;
      resurrectSelection();
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if ((paramBoolean) && (this.mSelectedPosition < 0) && (!isInTouchMode()))
    {
      if ((!this.mIsAttached) && (this.mAdapter != null))
      {
        this.mDataChanged = true;
        this.mOldItemCount = this.mItemCount;
        this.mItemCount = this.mAdapter.getCount();
      }
      resurrectSelection();
    }
  }
  
  @TargetApi(12)
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getSource() & 0x2) != 0) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    int i;
    do
    {
      float f;
      do
      {
        do
        {
          return super.onGenericMotionEvent(paramMotionEvent);
        } while (this.mTouchMode != -1);
        f = paramMotionEvent.getAxisValue(9);
      } while (f == 0.0F);
      i = (int)(f * getVerticalScrollFactor());
    } while (trackMotionScroll(i, i));
    return true;
  }
  
  public void onGlobalLayout()
  {
    if (isShown()) {
      if ((this.mFiltered) && (this.mPopup != null) && (!this.mPopup.isShowing()) && (!this.mPopupHidden)) {
        showPopup();
      }
    }
    while ((this.mPopup == null) || (!this.mPopup.isShowing())) {
      return;
    }
    dismissPopup();
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(android.widget.AbsListView.class.getName());
  }
  
  @TargetApi(16)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(android.widget.AbsListView.class.getName());
    if (isEnabled())
    {
      if (getFirstVisiblePosition() > 0) {
        paramAccessibilityNodeInfo.addAction(8192);
      }
      if (getLastVisiblePosition() < getCount() - 1) {
        paramAccessibilityNodeInfo.addAction(4096);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i = paramMotionEvent.getAction();
    if ((this.mFastScroller != null) && (this.mFastScroller.onInterceptTouchEvent(paramMotionEvent))) {
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        switch (i & 0xFF)
        {
        case 4: 
        case 5: 
        default: 
          return false;
        case 0: 
          i = this.mTouchMode;
          if ((i == 6) || (i == 5))
          {
            this.mMotionCorrection = 0;
            return true;
          }
          j = (int)paramMotionEvent.getX();
          int k = (int)paramMotionEvent.getY();
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          int m = findClosestMotionRow(k);
          if ((i != 4) && (m >= 0))
          {
            this.mMotionViewOriginalTop = getChildAt(m - this.mFirstPosition).getTop();
            this.mMotionX = j;
            this.mMotionY = k;
            this.mMotionPosition = m;
            this.mTouchMode = 0;
            clearScrollingCache();
          }
          this.mLastY = -2147483648;
          initOrResetVelocityTracker();
          this.mVelocityTracker.addMovement(paramMotionEvent);
        }
      } while (i != 4);
      return true;
      switch (this.mTouchMode)
      {
      default: 
        return false;
      }
      int j = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      i = j;
      if (j == -1)
      {
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        i = 0;
      }
      if (this.mDataChanged) {
        layoutChildren();
      }
      i = (int)paramMotionEvent.getY(i);
      initVelocityTrackerIfNotExists();
      this.mVelocityTracker.addMovement(paramMotionEvent);
    } while (!startScrollIfNeeded(i));
    return true;
    this.mTouchMode = -1;
    this.mActivePointerId = -1;
    recycleVelocityTracker();
    reportScrollStateChange(0);
    return false;
    onSecondaryPointerUp(paramMotionEvent);
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    do
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      do
      {
        return bool;
      } while (!isEnabled());
    } while ((!isClickable()) || (!isPressed()) || (this.mSelectedPosition < 0) || (this.mAdapter == null) || (this.mSelectedPosition >= this.mAdapter.getCount()));
    paramKeyEvent = getChildAt(this.mSelectedPosition - this.mFirstPosition);
    if (paramKeyEvent != null)
    {
      performItemClick(paramKeyEvent, this.mSelectedPosition, this.mSelectedRowId);
      paramKeyEvent.setPressed(false);
    }
    setPressed(false);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    traceBegin("AbsListView.onLayout");
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      this.mInLayout = true;
      if (paramBoolean)
      {
        paramInt3 = getChildCount();
        paramInt1 = i;
        while (paramInt1 < paramInt3)
        {
          getChildAt(paramInt1).forceLayout();
          paramInt1 += 1;
        }
        this.mRecycler.markChildrenDirty();
      }
      if ((this.mFastScroller != null) && (this.mItemCount != this.mOldItemCount)) {
        this.mFastScroller.kY(this.mOldItemCount, this.mItemCount);
      }
      layoutChildren();
      this.mInLayout = false;
      this.mOverscrollMax = ((paramInt4 - paramInt2) / 3);
      if (this.mScrollToBottom)
      {
        if (this.mBottomScroller == null) {
          this.mBottomScroller = new MoveToBottomScroller();
        }
        this.mBottomScroller.start();
      }
      return;
    }
    finally
    {
      traceEnd();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mSelector == null) {
      useDefaultSelector();
    }
    Object localObject = this.mListPadding;
    ((Rect)localObject).left = (this.mSelectionLeftPadding + this.mPaddingLeft);
    ((Rect)localObject).top = (this.mSelectionTopPadding + this.mPaddingTop);
    ((Rect)localObject).right = (this.mSelectionRightPadding + this.mPaddingRight);
    ((Rect)localObject).bottom = (this.mSelectionBottomPadding + this.mPaddingBottom);
    if (this.mTranscriptMode == 1)
    {
      int i = getChildCount();
      if (i > 0)
      {
        paramInt2 = getHeight() - this.mPaddingBottom;
        localObject = getChildAt(i - 1);
        if (localObject == null) {
          break label148;
        }
        paramInt1 = ((View)localObject).getBottom();
        if ((i + this.mFirstPosition < this.mLastHandledItemCount) || (paramInt1 > paramInt2)) {
          break label153;
        }
      }
    }
    label148:
    label153:
    for (boolean bool = true;; bool = false)
    {
      this.mForceTranscriptScroll = bool;
      return;
      paramInt1 = paramInt2;
      break;
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (getScrollY() != paramInt2)
    {
      onScrollChanged(getScrollX(), paramInt2, getScrollX(), getScrollY());
      this.mScrollY = paramInt2;
      invalidateParentIfNeeded();
    }
    try
    {
      awakenScrollBars();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("XListView", 1, "onOverScrolled error:" + localThrowable.getMessage());
    }
  }
  
  public void onRemoteAdapterDisconnected() {}
  
  @TargetApi(11)
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.mDataChanged = true;
    this.mSyncHeight = paramParcelable.height;
    if (paramParcelable.selectedId >= 0L)
    {
      this.mNeedSync = true;
      this.mSyncRowId = paramParcelable.selectedId;
      this.mSyncPosition = paramParcelable.position;
      this.mSpecificTop = paramParcelable.esk;
      this.mSpecificBottom = paramParcelable.esk;
      this.mSyncMode = 0;
    }
    for (;;)
    {
      setFilterText(paramParcelable.cIU);
      if (paramParcelable.r != null) {
        this.mCheckStates = paramParcelable.r;
      }
      if (paramParcelable.o != null) {
        this.mCheckedIdStates = paramParcelable.o;
      }
      this.mCheckedItemCount = paramParcelable.esl;
      if ((VersionUtils.isHoneycomb()) && (paramParcelable.djS) && (this.mChoiceMode == 3) && (this.mMultiChoiceModeCallback != null)) {
        this.mChoiceActionMode = startActionMode(this.mMultiChoiceModeCallback);
      }
      requestLayout();
      return;
      if (paramParcelable.ayX >= 0L)
      {
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.mSelectorPosition = -1;
        if (paramParcelable.position != 2147483647)
        {
          this.mNeedSync = true;
          this.mSyncRowId = paramParcelable.ayX;
          if (!this.mStackFromBottom)
          {
            this.mSyncPosition = paramParcelable.position;
            this.mSpecificTop = paramParcelable.esk;
            this.mSyncMode = 1;
          }
          else
          {
            this.mSyncPosition = paramParcelable.position;
            this.mSpecificBottom = paramParcelable.esk;
            this.mSyncMode = 2;
          }
        }
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    boolean bool = true;
    int k = 0;
    dismissPopup();
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    int i;
    Object localObject;
    if ((getChildCount() > 0) && (this.mItemCount > 0))
    {
      i = 1;
      localSavedState.height = this.mLayoutHeight;
      if (this.mSelectedPosition < 0) {
        break label288;
      }
      localSavedState.selectedId = this.mNextSelectedRowId;
      if (i != 0)
      {
        localSavedState.position = getSelectedItemPosition();
        localObject = getChildAt(this.mSelectedPosition - this.mFirstPosition);
        if (localObject != null)
        {
          if (!this.mStackFromBottom) {
            break label279;
          }
          i = this.mLayoutHeight - ((View)localObject).getBottom();
          label114:
          localSavedState.esk = i;
        }
        localSavedState.ayX = -1L;
      }
      label128:
      localSavedState.cIU = null;
      if (this.mFiltered)
      {
        localObject = this.mTextFilter;
        if (localObject != null)
        {
          localObject = ((EditText)localObject).getText();
          if (localObject != null) {
            localSavedState.cIU = localObject.toString();
          }
        }
      }
      if ((this.mChoiceMode != 3) || (this.mChoiceActionMode == null)) {
        break label553;
      }
    }
    for (;;)
    {
      localSavedState.djS = bool;
      if (this.mCheckStates != null) {
        localSavedState.r = this.mCheckStates.clone();
      }
      if (this.mCheckedIdStates == null) {
        break label566;
      }
      localObject = new aure();
      int j = this.mCheckedIdStates.size();
      i = k;
      while (i < j)
      {
        ((aure)localObject).put(this.mCheckedIdStates.keyAt(i), this.mCheckedIdStates.valueAt(i));
        i += 1;
      }
      i = 0;
      break;
      label279:
      i = ((View)localObject).getTop();
      break label114;
      label288:
      if (!this.mStackFromBottom)
      {
        if ((i != 0) && (this.mFirstPosition >= 0))
        {
          localSavedState.esk = getChildAt(0).getTop();
          j = this.mFirstPosition;
          i = j;
          if (j >= this.mItemCount) {
            i = this.mItemCount - 1;
          }
          localSavedState.position = i;
          localSavedState.ayX = this.mAdapter.getItemId(i);
          break label128;
        }
        localSavedState.esk = 0;
        localSavedState.ayX = -1L;
        localSavedState.position = 0;
        break label128;
      }
      if ((i != 0) && (this.mFirstPosition >= 0))
      {
        j = getChildCount();
        if (this.mFirstPosition == -1)
        {
          i = -1;
          label414:
          localObject = getChildAt(j - 1);
          localSavedState.esk = (this.mLayoutHeight - ((View)localObject).getBottom());
          j = i;
          if (i >= this.mItemCount) {
            j = this.mItemCount - 1;
          }
          if ((((View)localObject).getBottom() > this.mLayoutHeight - this.mListPadding.bottom) || (this.mTranscriptMode != 1)) {
            break label521;
          }
        }
        label521:
        for (localSavedState.position = 2147483647;; localSavedState.position = j)
        {
          localSavedState.ayX = this.mAdapter.getItemId(j);
          break;
          i = this.mFirstPosition + j - 1;
          break label414;
        }
      }
      localSavedState.esk = 0;
      localSavedState.ayX = -1L;
      localSavedState.position = 0;
      break label128;
      label553:
      bool = false;
    }
    localSavedState.o = ((aure)localObject);
    label566:
    localSavedState.esl = this.mCheckedItemCount;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() > 0)
    {
      this.mDataChanged = true;
      rememberSyncState();
    }
    if (this.mFastScroller != null) {
      this.mFastScroller.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if ((this.mPopup != null) && (isTextFilterEnabled()))
    {
      paramInt1 = paramCharSequence.length();
      bool = this.mPopup.isShowing();
      if ((bool) || (paramInt1 <= 0)) {
        break label85;
      }
      showPopup();
    }
    for (this.mFiltered = true;; this.mFiltered = false)
    {
      label85:
      do
      {
        if ((this.mAdapter instanceof Filterable))
        {
          Filter localFilter = ((Filterable)this.mAdapter).getFilter();
          if (localFilter == null) {
            break;
          }
          localFilter.filter(paramCharSequence, this);
        }
        return;
      } while ((!bool) || (paramInt1 != 0));
      dismissPopup();
    }
    throw new IllegalStateException("You cannot call onTextChanged with a non filterable adapter");
  }
  
  @TargetApi(8)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    int i = 0;
    boolean bool1;
    if (!isEnabled()) {
      if ((isClickable()) || (isLongClickable())) {
        bool1 = true;
      }
    }
    do
    {
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
      if (this.mFastScroller == null) {
        break;
      }
      bool1 = bool2;
    } while (this.mFastScroller.onTouchEvent(paramMotionEvent));
    Object localObject = getTouchDelegate();
    if (localObject != null) {
      ((TouchDelegate)localObject).onTouchEvent(paramMotionEvent);
    }
    int j = paramMotionEvent.getAction();
    initVelocityTrackerIfNotExists();
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int k;
    switch (j & 0xFF)
    {
    case 4: 
    default: 
      return true;
    case 0: 
      switch (this.mTouchMode)
      {
      default: 
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        j = (int)paramMotionEvent.getX();
        k = (int)paramMotionEvent.getY();
        i = pointToPosition(j, getScrollY() + k);
        if (!this.mDataChanged) {
          if ((this.mTouchMode != 4) && (i >= 0) && (((ListAdapter)getAdapter()).isEnabled(i)))
          {
            this.mTouchMode = 0;
            if (this.mPendingCheckForTap == null) {
              this.mPendingCheckForTap = new CheckForTap();
            }
            postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      if (i >= 0) {
        this.mMotionViewOriginalTop = getChildAt(i - this.mFirstPosition).getTop();
      }
      this.mMotionX = j;
      this.mMotionY = k;
      this.mMotionPosition = i;
      this.mLastY = -2147483648;
      for (;;)
      {
        bool1 = bool2;
        if (!performButtonActionOnTouchDown(paramMotionEvent)) {
          break;
        }
        bool1 = bool2;
        if (this.mTouchMode != 0) {
          break;
        }
        removeCallbacks(this.mPendingCheckForTap);
        return true;
        this.mFlingRunnable.ewF();
        if (this.mPositionScroller != null) {
          this.mPositionScroller.stop();
        }
        if (this.mBottomScroller != null) {
          this.mBottomScroller.stop();
        }
        this.mTouchMode = 5;
        this.mMotionX = ((int)paramMotionEvent.getX());
        i = (int)paramMotionEvent.getY();
        this.mLastY = i;
        this.mMotionY = i;
        this.mMotionCorrection = 0;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        this.mDirection = 0;
      }
      if (this.mTouchMode == 4)
      {
        createScrollingCache();
        this.mFlingRunnable.ewF();
        this.mTouchMode = 3;
        this.mMotionCorrection = 0;
        i = findMotionRow(k);
        this.mFlingRunnable.ewG();
        continue;
        j = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (j == -1) {
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
        }
        for (;;)
        {
          if (this.mDataChanged) {
            layoutChildren();
          }
          i = (int)paramMotionEvent.getY(i);
          switch (this.mTouchMode)
          {
          case 4: 
          default: 
            return true;
          case 0: 
          case 1: 
          case 2: 
            startScrollIfNeeded(i);
            return true;
          }
          scrollIfNeeded(i);
          return true;
          switch (this.mTouchMode)
          {
          case 4: 
          default: 
          case 0: 
          case 1: 
          case 2: 
          case 3: 
            for (;;)
            {
              setPressed(false);
              if (this.mEdgeGlowTop != null)
              {
                this.mEdgeGlowTop.onRelease();
                this.mEdgeGlowBottom.onRelease();
              }
              invalidate();
              paramMotionEvent = getHandler();
              if (paramMotionEvent != null) {
                paramMotionEvent.removeCallbacks(this.mPendingCheckForLongPress);
              }
              recycleVelocityTracker();
              this.mActivePointerId = -1;
              bool1 = bool2;
              if (this.mScrollStrictSpan == null) {
                break;
              }
              this.mScrollStrictSpan = finishSpan(this.mScrollStrictSpan);
              return true;
              j = this.mMotionPosition;
              localObject = getChildAt(j - this.mFirstPosition);
              f = paramMotionEvent.getX();
              PerformClick localPerformClick;
              Handler localHandler;
              if ((f > this.mListPadding.left) && (f < getWidth() - this.mListPadding.right))
              {
                i = 1;
                if (this.mPerformClick == null) {
                  this.mPerformClick = new PerformClick(null);
                }
                localPerformClick = this.mPerformClick;
                localPerformClick.esj = j;
                localPerformClick.cCe();
                if ((localObject == null) || (((View)localObject).hasFocusable()) || (i == 0)) {
                  break label1098;
                }
                if (this.mTouchMode != 0) {
                  ((View)localObject).setPressed(false);
                }
                this.mResurrectToPosition = j;
                if ((this.mTouchMode != 0) && (this.mTouchMode != 1)) {
                  break label1060;
                }
                localHandler = getHandler();
                if (localHandler != null) {
                  if (this.mTouchMode != 0) {
                    break label1041;
                  }
                }
              }
              label1041:
              for (paramMotionEvent = this.mPendingCheckForTap;; paramMotionEvent = this.mPendingCheckForLongPress)
              {
                localHandler.removeCallbacks(paramMotionEvent);
                this.mLayoutMode = 0;
                if ((this.mDataChanged) || (!this.mAdapter.isEnabled(j))) {
                  break label1049;
                }
                this.mTouchMode = 1;
                setSelectedPositionInt(this.mMotionPosition);
                layoutChildren();
                ((View)localObject).setPressed(true);
                positionSelector(this.mMotionPosition, (View)localObject);
                setPressed(true);
                if (this.mSelector != null)
                {
                  paramMotionEvent = this.mSelector.getCurrent();
                  if ((paramMotionEvent != null) && ((paramMotionEvent instanceof TransitionDrawable))) {
                    ((TransitionDrawable)paramMotionEvent).resetTransition();
                  }
                }
                if (this.mTouchModeReset != null) {
                  removeCallbacks(this.mTouchModeReset);
                }
                this.mTouchModeReset = new AbsListView.1(this, (View)localObject, localPerformClick);
                postDelayed(this.mTouchModeReset, ViewConfiguration.getPressedStateDuration());
                return true;
                i = 0;
                break;
              }
              label1049:
              this.mTouchMode = -1;
              updateSelectorState();
              return true;
              label1060:
              if ((!this.mDataChanged) && (this.mAdapter.isEnabled(j))) {
                localPerformClick.run();
              }
              for (;;)
              {
                this.mTouchMode = -1;
                updateSelectorState();
                break;
                label1098:
                localPerformClick.run();
              }
              i = getChildCount();
              if (i > 0)
              {
                j = getChildAt(0).getTop();
                k = getChildAt(i - 1).getBottom();
                int m = this.mListPadding.top;
                int n = getHeight() - this.mListPadding.bottom;
                if ((this.mFirstPosition == 0) && (j >= m) && (this.mFirstPosition + i < this.mItemCount) && (k <= getHeight() - n))
                {
                  this.mTouchMode = -1;
                  reportScrollStateChange(0);
                }
                else
                {
                  paramMotionEvent = this.mVelocityTracker;
                  paramMotionEvent.computeCurrentVelocity(1000, this.mMaximumVelocity);
                  if (VersionUtils.isrFroyo()) {}
                  for (f = paramMotionEvent.getYVelocity(this.mActivePointerId);; f = paramMotionEvent.getYVelocity())
                  {
                    int i1 = (int)(f * this.mVelocityScale);
                    if ((Math.abs(i1) <= this.mMinimumVelocity) || ((this.mFirstPosition == 0) && (j == m - this.mOverscrollDistance)) || ((i + this.mFirstPosition == this.mItemCount) && (k == this.mOverscrollDistance + n))) {
                      break label1354;
                    }
                    if (this.mFlingRunnable == null) {
                      this.mFlingRunnable = new FlingRunnable();
                    }
                    reportScrollStateChange(2);
                    this.mFlingRunnable.start(-i1);
                    break;
                  }
                  label1354:
                  this.mTouchMode = -1;
                  reportScrollStateChange(0);
                  if (this.mFlingRunnable != null) {
                    this.mFlingRunnable.ewF();
                  }
                  if (this.mPositionScroller != null) {
                    this.mPositionScroller.stop();
                  }
                  if (this.mBottomScroller != null) {
                    this.mBottomScroller.stop();
                  }
                }
              }
              else
              {
                this.mTouchMode = -1;
                reportScrollStateChange(0);
              }
            }
          }
          if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new FlingRunnable();
          }
          reportScrollStateChange(2);
          this.mFlingRunnable.abb(getSpringbackOffset());
          localObject = this.mVelocityTracker;
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
          if (VersionUtils.isrFroyo()) {}
          for (float f = ((VelocityTracker)localObject).getYVelocity(this.mActivePointerId);; f = ((VelocityTracker)localObject).getYVelocity())
          {
            onTouchUpWithYVelocity((int)(f * this.mVelocityScale), (int)paramMotionEvent.getY());
            break;
          }
          switch (this.mTouchMode)
          {
          default: 
            if ((this.mForContacts) && (this.mTouchMode == 3)) {
              flingForCancel();
            }
            break;
          }
          for (;;)
          {
            if (this.mEdgeGlowTop != null)
            {
              this.mEdgeGlowTop.onRelease();
              this.mEdgeGlowBottom.onRelease();
            }
            this.mActivePointerId = -1;
            return true;
            if (this.mFlingRunnable == null) {
              this.mFlingRunnable = new FlingRunnable();
            }
            this.mFlingRunnable.abb(0);
            continue;
            this.mTouchMode = -1;
            setPressed(false);
            paramMotionEvent = getChildAt(this.mMotionPosition - this.mFirstPosition);
            if (paramMotionEvent != null) {
              paramMotionEvent.setPressed(false);
            }
            clearScrollingCache();
            paramMotionEvent = getHandler();
            if (paramMotionEvent != null) {
              paramMotionEvent.removeCallbacks(this.mPendingCheckForLongPress);
            }
            recycleVelocityTracker();
          }
          bool1 = bool2;
          if (!VersionUtils.isrFroyo()) {
            break;
          }
          onSecondaryPointerUp(paramMotionEvent);
          j = this.mMotionX;
          i = this.mMotionY;
          j = pointToPosition(j, i);
          if (j >= 0)
          {
            this.mMotionViewOriginalTop = getChildAt(j - this.mFirstPosition).getTop();
            this.mMotionPosition = j;
          }
          this.mLastY = i;
          return true;
          bool1 = bool2;
          if (!VersionUtils.isrFroyo()) {
            break;
          }
          k = paramMotionEvent.getActionIndex();
          i = paramMotionEvent.getPointerId(k);
          j = (int)paramMotionEvent.getX(k);
          k = (int)paramMotionEvent.getY(k);
          this.mMotionCorrection = 0;
          this.mActivePointerId = i;
          this.mMotionX = j;
          this.mMotionY = k;
          i = pointToPosition(j, k);
          if (i >= 0)
          {
            this.mMotionViewOriginalTop = getChildAt(i - this.mFirstPosition).getTop();
            this.mMotionPosition = i;
          }
          this.mLastY = k;
          return true;
          i = j;
        }
      }
    }
  }
  
  public void onTouchModeChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      hideSelector();
      if ((getHeight() > 0) && (getChildCount() > 0)) {
        layoutChildren();
      }
      updateSelectorState();
    }
    do
    {
      int i;
      do
      {
        return;
        i = this.mTouchMode;
      } while ((i != 5) && (i != 6));
      if ((this.mFlingRunnable != null) && (this.mScrollY == 0)) {
        this.mFlingRunnable.ewF();
      }
      if (this.mPositionScroller != null) {
        this.mPositionScroller.stop();
      }
      if (this.mBottomScroller != null) {
        this.mBottomScroller.stop();
      }
    } while (getScrollY() == 0);
    this.mScrollY = 0;
    invalidateParentCaches();
    finishGlows();
    invalidate();
  }
  
  public void onTouchUpWithYVelocity(int paramInt1, int paramInt2) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    int i;
    if (isInTouchMode())
    {
      i = 0;
      if (paramBoolean) {
        break label120;
      }
      if ((!this.mForHongBao) && (!this.mForStory))
      {
        setChildrenDrawingCacheEnabled(false);
        if (this.mFlingRunnable != null)
        {
          removeCallbacks(this.mFlingRunnable);
          this.mFlingRunnable.ewF();
          if (this.mPositionScroller != null) {
            this.mPositionScroller.stop();
          }
          if (this.mBottomScroller != null) {
            this.mBottomScroller.stop();
          }
          resetScrollY();
        }
        dismissPopup();
        if (i == 1) {
          this.mResurrectToPosition = this.mSelectedPosition;
        }
      }
    }
    for (;;)
    {
      this.mLastTouchMode = i;
      return;
      i = 1;
      break;
      label120:
      if ((this.mFiltered) && (!this.mPopupHidden)) {
        showPopup();
      }
      if ((i != this.mLastTouchMode) && (this.mLastTouchMode != -1)) {
        if (i == 1)
        {
          resurrectSelection();
        }
        else
        {
          hideSelector();
          this.mLayoutMode = 0;
          layoutChildren();
        }
      }
    }
  }
  
  @TargetApi(9)
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    int k = this.mOverScrollMode;
    int i;
    int j;
    if (computeHorizontalScrollRange() > computeHorizontalScrollExtent())
    {
      i = 1;
      if (computeVerticalScrollRange() <= computeVerticalScrollExtent()) {
        break label192;
      }
      j = 1;
      label34:
      if ((k != 0) && ((k != 1) || (i == 0))) {
        break label198;
      }
      i = 1;
      label53:
      if ((k != 0) && ((k != 1) || (j == 0))) {
        break label204;
      }
      j = 1;
      label72:
      paramInt3 += paramInt1;
      if (i == 0) {
        paramInt7 = 0;
      }
      paramInt4 += paramInt2;
      if (j == 0) {
        paramInt8 = 0;
      }
      paramInt2 = -paramInt7;
      paramInt5 = paramInt7 + paramInt5;
      if (!this.mDisableOverScrollTop) {
        break label210;
      }
      paramInt1 = 0;
      label118:
      paramInt6 = paramInt8 + paramInt6;
      if (paramInt3 <= paramInt5) {
        break label217;
      }
      paramInt2 = paramInt5;
      paramBoolean = true;
    }
    for (;;)
    {
      label137:
      boolean bool = false;
      if (paramInt4 > paramInt6)
      {
        bool = true;
        paramInt1 = paramInt6;
      }
      for (;;)
      {
        if ((!this.mForHongBao) || (paramInt1 <= 0)) {
          onOverScrolled(paramInt2, paramInt1, paramBoolean, bool);
        }
        if ((paramBoolean) || (bool))
        {
          return true;
          i = 0;
          break;
          label192:
          j = 0;
          break label34;
          label198:
          i = 0;
          break label53;
          label204:
          j = 0;
          break label72;
          label210:
          paramInt1 = -paramInt8;
          break label118;
          label217:
          if (paramInt3 >= paramInt2) {
            break label248;
          }
          paramBoolean = true;
          break label137;
          if (paramInt4 >= paramInt1) {
            break label242;
          }
          bool = true;
          continue;
        }
        return false;
        label242:
        paramInt1 = paramInt4;
      }
      label248:
      paramBoolean = false;
      paramInt2 = paramInt3;
    }
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramInt, paramBundle)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 4096: 
      if ((isEnabled()) && (getLastVisiblePosition() < getCount() - 1))
      {
        smoothScrollBy(getHeight() - this.mListPadding.top - this.mListPadding.bottom, 400);
        return true;
      }
      return false;
    }
    if ((isEnabled()) && (this.mFirstPosition > 0))
    {
      smoothScrollBy(-(getHeight() - this.mListPadding.top - this.mListPadding.bottom), 400);
      return true;
    }
    return false;
  }
  
  @TargetApi(14)
  protected boolean performButtonActionOnTouchDown(MotionEvent paramMotionEvent)
  {
    return (VersionUtils.isIceScreamSandwich()) && ((paramMotionEvent.getButtonState() & 0x2) != 0) && (showContextMenu(paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getMetaState()));
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    int j = 0;
    if ((isValidPosition(paramInt, ((ListAdapter)getAdapter()).getCount())) && (this.mChoiceMode != 0)) {
      if ((this.mChoiceMode == 2) || ((this.mChoiceMode == 3) && (this.mChoiceActionMode != null))) {
        if (!this.mCheckStates.get(paramInt, false))
        {
          bool1 = true;
          this.mCheckStates.put(paramInt, bool1);
          if ((this.mCheckedIdStates != null) && (this.mAdapter.hasStableIds()))
          {
            if (!bool1) {
              break label213;
            }
            this.mCheckedIdStates.put(this.mAdapter.getItemId(paramInt), Integer.valueOf(paramInt));
          }
          label126:
          if (!bool1) {
            break label233;
          }
          this.mCheckedItemCount += 1;
          label141:
          if (this.mChoiceActionMode == null) {
            break label380;
          }
          this.mMultiChoiceModeCallback.onItemCheckedStateChanged(this.mChoiceActionMode, paramInt, paramLong, bool1);
          i = j;
          label167:
          this.mDataChanged = true;
          rememberSyncState();
          requestLayout();
        }
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (i != 0) {
        bool2 = bool1 | super.performItemClick(paramView, paramInt, paramLong);
      }
      return bool2;
      bool1 = false;
      break;
      label213:
      this.mCheckedIdStates.delete(this.mAdapter.getItemId(paramInt));
      break label126;
      label233:
      this.mCheckedItemCount -= 1;
      break label141;
      if (this.mChoiceMode == 1)
      {
        if (!this.mCheckStates.get(paramInt, false)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label354;
          }
          this.mCheckStates.clear();
          this.mCheckStates.put(paramInt, true);
          if ((this.mCheckedIdStates != null) && (this.mAdapter.hasStableIds()))
          {
            this.mCheckedIdStates.clear();
            this.mCheckedIdStates.put(this.mAdapter.getItemId(paramInt), Integer.valueOf(paramInt));
          }
          this.mCheckedItemCount = 1;
          i = 1;
          break;
        }
        label354:
        if ((this.mCheckStates.size() == 0) || (!this.mCheckStates.valueAt(0))) {
          this.mCheckedItemCount = 0;
        }
      }
      label380:
      i = 1;
      break label167;
    }
  }
  
  @TargetApi(11)
  boolean performLongPress(View paramView, int paramInt, long paramLong)
  {
    boolean bool1 = true;
    if (this.mChoiceMode == 3)
    {
      bool2 = bool1;
      if (VersionUtils.isHoneycomb())
      {
        bool2 = bool1;
        if (this.mChoiceActionMode == null)
        {
          paramView = startActionMode(this.mMultiChoiceModeCallback);
          this.mChoiceActionMode = paramView;
          bool2 = bool1;
          if (paramView != null)
          {
            setItemChecked(paramInt, true);
            performHapticFeedback(0);
            bool2 = bool1;
          }
        }
      }
      return bool2;
    }
    if (this.mOnItemLongClickListener != null) {}
    for (boolean bool2 = this.mOnItemLongClickListener.a(this, paramView, paramInt, paramLong);; bool2 = false)
    {
      bool1 = bool2;
      if (!bool2)
      {
        this.mContextMenuInfo = createContextMenuInfo(paramView, paramInt, paramLong);
        bool1 = super.showContextMenuForChild(this);
      }
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      performHapticFeedback(0);
      return bool1;
    }
  }
  
  public int pointToPosition(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.mTouchFrame;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.mTouchFrame = new Rect();
      localObject1 = this.mTouchFrame;
    }
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      localObject2 = getChildAt(i);
      if ((localObject2 != null) && (((View)localObject2).getVisibility() == 0))
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return this.mFirstPosition + i;
        }
      }
      i -= 1;
    }
    return -1;
  }
  
  public long pointToRowId(int paramInt1, int paramInt2)
  {
    paramInt1 = pointToPosition(paramInt1, paramInt2);
    if (paramInt1 >= 0) {
      return this.mAdapter.getItemId(paramInt1);
    }
    return -9223372036854775808L;
  }
  
  void positionSelector(int paramInt, View paramView)
  {
    if (paramInt != -1) {
      this.mSelectorPosition = paramInt;
    }
    Rect localRect = this.mSelectorRect;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    if ((paramView instanceof h)) {
      ((h)paramView).adjustListItemSelectionBounds(localRect);
    }
    positionSelector(localRect.left, localRect.top, localRect.right, localRect.bottom);
    boolean bool = this.mIsChildViewEnabled;
    if (paramView.isEnabled() != bool) {
      if (bool) {
        break label116;
      }
    }
    label116:
    for (bool = true;; bool = false)
    {
      this.mIsChildViewEnabled = bool;
      if (getSelectedItemPosition() != -1) {
        refreshDrawableState();
      }
      return;
    }
  }
  
  public void reclaimViews(List<View> paramList)
  {
    int j = getChildCount();
    g localg = f.a(this.mRecycler);
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams != null) && (this.mRecycler.shouldRecycleViewType(localLayoutParams.viewType)))
      {
        paramList.add(localView);
        if (localg != null) {
          localg.onMovedToScrapHeap(localView);
        }
      }
      i += 1;
    }
    this.mRecycler.reclaimScrapViews(paramList);
    removeAllViewsInLayout();
  }
  
  int reconcileSelectedPosition()
  {
    int j = this.mSelectedPosition;
    int i = j;
    if (j < 0) {
      i = this.mResurrectToPosition;
    }
    return Math.min(Math.max(0, i), this.mItemCount - 1);
  }
  
  void rememberSyncState()
  {
    int i = -1;
    if (getChildCount() > 0)
    {
      this.mNeedSync = true;
      this.mSyncHeight = this.mLayoutHeight;
      if (this.mSelectedPosition >= 0)
      {
        localObject1 = getChildAt(this.mSelectedPosition - this.mFirstPosition);
        this.mSyncRowId = this.mNextSelectedRowId;
        this.mSyncPosition = this.mNextSelectedPosition;
        if (localObject1 != null)
        {
          this.mSpecificTop = ((View)localObject1).getTop();
          this.mSpecificBottom = (this.mLayoutHeight - ((View)localObject1).getBottom());
        }
        this.mSyncMode = 0;
      }
    }
    else
    {
      return;
    }
    Object localObject2;
    if (((this.mScrollY == 0) && (!this.mStackFromBottom)) || (this.mScrollY < 0))
    {
      localObject1 = getChildAt(0);
      localObject2 = (ListAdapter)getAdapter();
      if ((this.mFirstPosition >= 0) && (this.mFirstPosition < ((ListAdapter)localObject2).getCount())) {}
      for (this.mSyncRowId = ((ListAdapter)localObject2).getItemId(this.mFirstPosition);; this.mSyncRowId = -1L)
      {
        this.mSyncPosition = this.mFirstPosition;
        if (localObject1 != null)
        {
          this.mSpecificTop = ((View)localObject1).getTop();
          this.mSpecificBottom = (this.mLayoutHeight - ((View)localObject1).getBottom());
        }
        this.mSyncMode = 1;
        return;
      }
    }
    Object localObject1 = (ListAdapter)getAdapter();
    int j = getChildCount();
    if (this.mFirstPosition == -1)
    {
      localObject2 = getChildAt(j - 1);
      if ((i < 0) || (i >= ((ListAdapter)localObject1).getCount())) {
        break label318;
      }
    }
    label318:
    for (this.mSyncRowId = ((ListAdapter)localObject1).getItemId(i);; this.mSyncRowId = -1L)
    {
      this.mSyncPosition = i;
      if (localObject2 != null)
      {
        this.mSpecificTop = ((View)localObject2).getTop();
        this.mSpecificBottom = (this.mLayoutHeight - ((View)localObject2).getBottom());
      }
      this.mSyncMode = 2;
      return;
      i = this.mFirstPosition + j - 1;
      break;
    }
  }
  
  public void removeOnScrollListener(e parame)
  {
    this.mOnScrollListenerList.remove(parame);
  }
  
  protected void reportScrollStateChange(int paramInt)
  {
    if (paramInt != this.mLastScrollState)
    {
      this.mLastScrollState = paramInt;
      if (AppSetting.aNZ) {
        if (paramInt == 0) {
          break label48;
        }
      }
    }
    label48:
    for (boolean bool = true;; bool = false)
    {
      aqfp.Sz(bool);
      if (this.mOnScrollListener != null) {
        this.mOnScrollListener.onScrollStateChanged(this, paramInt);
      }
      return;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      recycleVelocityTracker();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((!this.mBlockLayoutRequests) && (!this.mInLayout))
    {
      rememberSyncState();
      super.requestLayout();
    }
  }
  
  void requestLayoutIfNecessary()
  {
    if (getChildCount() > 0)
    {
      resetList();
      requestLayout();
      invalidate();
    }
  }
  
  void resetList()
  {
    removeAllViewsInLayout();
    this.mFirstPosition = 0;
    this.mDataChanged = true;
    this.mNeedSync = false;
    this.mOldSelectedPosition = -1;
    this.mOldSelectedRowId = -9223372036854775808L;
    setSelectedPositionInt(-1);
    setNextSelectedPositionInt(-1);
    this.mSelectedTop = 0;
    this.mSelectorPosition = -1;
    this.mSelectorRect.setEmpty();
    invalidate();
  }
  
  protected void resetScrollY()
  {
    if (getScrollY() != 0)
    {
      this.mScrollY = 0;
      invalidateParentCaches();
      finishGlows();
      invalidate();
    }
  }
  
  boolean resurrectSelection()
  {
    boolean bool2 = true;
    int i3 = getChildCount();
    if (i3 <= 0) {
      return false;
    }
    int i = this.mListPadding.top;
    int j = this.mBottom - this.mTop - this.mListPadding.bottom;
    int i1 = this.mFirstPosition;
    int k = this.mResurrectToPosition;
    View localView;
    int m;
    int n;
    boolean bool1;
    if ((k >= i1) && (k < i1 + i3))
    {
      localView = getChildAt(k - this.mFirstPosition);
      m = localView.getTop();
      n = localView.getBottom();
      if (m < i) {
        i = getVerticalFadingEdgeLength() + i;
      }
      for (;;)
      {
        j = k;
        bool1 = true;
        this.mResurrectToPosition = -1;
        removeCallbacks(this.mFlingRunnable);
        if (this.mPositionScroller != null) {
          this.mPositionScroller.stop();
        }
        if (this.mBottomScroller != null) {
          this.mBottomScroller.stop();
        }
        this.mTouchMode = -1;
        clearScrollingCache();
        this.mSpecificTop = i;
        i = lookForSelectablePosition(j, bool1);
        if ((i < i1) || (i > getLastVisiblePosition())) {
          break;
        }
        this.mLayoutMode = 4;
        updateSelectorState();
        setSelectionInt(i);
        invokeOnItemScrollListener();
        label208:
        reportScrollStateChange(0);
        if (i < 0) {
          break label452;
        }
        bool1 = bool2;
        label221:
        return bool1;
        i = m;
        if (n > j) {
          i = j - localView.getMeasuredHeight() - getVerticalFadingEdgeLength();
        }
      }
    }
    if (k < i1)
    {
      m = 0;
      j = 0;
      label260:
      if (m >= i3) {
        break label493;
      }
      k = getChildAt(m).getTop();
      if (m != 0) {
        break label490;
      }
      if ((i1 <= 0) && (k >= i)) {
        break label485;
      }
      i = getVerticalFadingEdgeLength() + i;
      j = k;
      label301:
      if (k < i) {}
    }
    for (j = i1 + m;; j = i1)
    {
      i = k;
      bool1 = true;
      break;
      m += 1;
      break label260;
      int i4 = this.mItemCount;
      int i2 = i1 + i3 - 1;
      m = i3 - 1;
      i = 0;
      label352:
      if (m >= 0)
      {
        localView = getChildAt(m);
        k = localView.getTop();
        int i5 = localView.getBottom();
        if (m == i3 - 1) {
          if ((i1 + i3 < i4) || (i5 > j))
          {
            i = j - getVerticalFadingEdgeLength();
            j = k;
          }
        }
        for (;;)
        {
          if (i5 <= i)
          {
            j = i1 + m;
            i = k;
            bool1 = false;
            break;
          }
          m -= 1;
          k = i;
          i = j;
          j = k;
          break label352;
          i = -1;
          break label208;
          bool1 = false;
          break label221;
          i = j;
          j = k;
          continue;
          n = i;
          i = j;
          j = n;
        }
      }
      label452:
      bool1 = false;
      j = i2;
      break;
      label485:
      j = k;
      break label301;
      label490:
      break label301;
      label493:
      k = j;
    }
  }
  
  boolean resurrectSelectionIfNeeded()
  {
    if ((this.mSelectedPosition < 0) && (resurrectSelection()))
    {
      updateSelectorState();
      return true;
    }
    return false;
  }
  
  public void sendAccessibilityEvent(int paramInt)
  {
    if (paramInt == 4096)
    {
      int i = getFirstVisiblePosition();
      int j = getLastVisiblePosition();
      if ((this.mLastAccessibilityScrollEventFromIndex == i) && (this.mLastAccessibilityScrollEventToIndex == j)) {
        return;
      }
      this.mLastAccessibilityScrollEventFromIndex = i;
      this.mLastAccessibilityScrollEventToIndex = j;
    }
    super.sendAccessibilityEvent(paramInt);
  }
  
  boolean sendToTextFilter(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    if (!acceptFilter()) {
      return false;
    }
    boolean bool2;
    boolean bool1;
    Object localObject;
    switch (paramInt1)
    {
    default: 
      bool2 = true;
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 66: 
      for (bool1 = false;; bool1 = false)
      {
        if (bool2)
        {
          createTextFilter(true);
          if (paramKeyEvent.getRepeatCount() <= 0) {
            break;
          }
          localObject = KeyEvent.changeTimeRepeat(paramKeyEvent, paramKeyEvent.getEventTime(), 0);
        }
        switch (paramKeyEvent.getAction())
        {
        default: 
          return bool1;
          bool2 = false;
        }
      }
    case 4: 
      label118:
      if ((this.mFiltered) && (this.mPopup != null) && (this.mPopup.isShowing())) {
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localObject = getKeyDispatcherState();
          if (localObject != null) {
            ((KeyEvent.DispatcherState)localObject).startTracking(paramKeyEvent, this);
          }
          bool1 = true;
        }
      }
      label148:
      break;
    }
    for (;;)
    {
      bool2 = false;
      break;
      if ((paramKeyEvent.getAction() == 1) && (paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
      {
        this.mTextFilter.setText("");
        bool1 = true;
        continue;
        bool2 = this.mFiltered;
        bool1 = false;
        break;
        bool1 = this.mTextFilter.onKeyDown(paramInt1, (KeyEvent)localObject);
        break label148;
        bool1 = this.mTextFilter.onKeyUp(paramInt1, (KeyEvent)localObject);
        break label148;
        bool1 = this.mTextFilter.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
        break label148;
        localObject = paramKeyEvent;
        break label118;
      }
      bool1 = false;
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter != null) && (this.mChoiceMode != 0) && (this.mAdapter.hasStableIds()) && (this.mCheckedIdStates == null)) {
      this.mCheckedIdStates = new aure();
    }
    if (this.mCheckStates != null) {
      this.mCheckStates.clear();
    }
    if (this.mCheckedIdStates != null) {
      this.mCheckedIdStates.clear();
    }
  }
  
  public void setCacheColorHint(int paramInt)
  {
    if (paramInt != this.mCacheColorHint)
    {
      this.mCacheColorHint = paramInt;
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        getChildAt(i).setDrawingCacheBackgroundColor(paramInt);
        i += 1;
      }
      this.mRecycler.setCacheColorHint(paramInt);
    }
  }
  
  public void setCallbackOnUnClickItem(boolean paramBoolean)
  {
    this.mCallbackOnUnClickItem = paramBoolean;
  }
  
  @TargetApi(11)
  public void setChoiceMode(int paramInt)
  {
    this.mChoiceMode = paramInt;
    if (this.mChoiceActionMode != null)
    {
      this.mChoiceActionMode.finish();
      this.mChoiceActionMode = null;
    }
    if (this.mChoiceMode != 0)
    {
      if (this.mCheckStates == null) {
        this.mCheckStates = new SparseBooleanArray();
      }
      if ((this.mCheckedIdStates == null) && (this.mAdapter != null) && (this.mAdapter.hasStableIds())) {
        this.mCheckedIdStates = new aure();
      }
      if (this.mChoiceMode == 3)
      {
        clearChoices();
        setLongClickable(true);
      }
    }
  }
  
  public void setDrawSelectorOnTop(boolean paramBoolean)
  {
    this.mDrawSelectorOnTop = paramBoolean;
  }
  
  public void setEdgeEffectEnabled(boolean paramBoolean)
  {
    Context localContext;
    if (this.mEdgeEffectEnabled != paramBoolean)
    {
      if (!paramBoolean) {
        break label62;
      }
      if ((this.mOverScrollMode != 2) && (this.mEdgeGlowTop == null))
      {
        localContext = getContext();
        this.mEdgeGlowTop = new autl(localContext);
      }
    }
    for (this.mEdgeGlowBottom = new autl(localContext);; this.mEdgeGlowBottom = null)
    {
      this.mEdgeEffectEnabled = paramBoolean;
      return;
      label62:
      this.mEdgeGlowTop = null;
    }
  }
  
  public void setFastScrollAlwaysVisible(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.mFastScrollEnabled)) {
      setFastScrollEnabled(true);
    }
    if (this.mFastScroller != null) {
      this.mFastScroller.Wf(paramBoolean);
    }
    try
    {
      localMethod = View.class.getDeclaredMethod("computeOpaqueFlags", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[0]);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          Method localMethod = View.class.getDeclaredMethod("recomputePadding", new Class[0]);
          localMethod.setAccessible(true);
          localMethod.invoke(this, new Object[0]);
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.e("XListView", 2, localException1.getMessage(), localException1);
          }
        }
      }
      catch (Exception localException2)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("XListView", 2, localException2.getMessage(), localException2);
      }
    }
  }
  
  public void setFastScrollEnabled(boolean paramBoolean)
  {
    this.mFastScrollEnabled = paramBoolean;
    if (paramBoolean) {
      if (this.mFastScroller == null) {
        this.mFastScroller = new FastScroller(getContext(), this);
      }
    }
    while (this.mFastScroller == null) {
      return;
    }
    this.mFastScroller.stop();
    this.mFastScroller = null;
  }
  
  public void setFilterText(String paramString)
  {
    if ((this.mTextFilterEnabled) && (!TextUtils.isEmpty(paramString)))
    {
      createTextFilter(false);
      this.mTextFilter.setText(paramString);
      this.mTextFilter.setSelection(paramString.length());
      if ((this.mAdapter instanceof Filterable))
      {
        if (this.mPopup == null) {
          ((Filterable)this.mAdapter).getFilter().filter(paramString);
        }
        this.mFiltered = true;
        this.mDataSetObserver.clearSavedState();
      }
    }
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    if (bool) {
      if (getWindowVisibility() != 0) {
        break label60;
      }
    }
    label60:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((this.mFiltered) && (paramInt1 != 0) && (this.mPopup != null) && (this.mPopup.isShowing())) {
        positionPopup();
      }
      return bool;
    }
  }
  
  public void setFriction(float paramFloat)
  {
    if (this.mFlingRunnable == null) {
      this.mFlingRunnable = new FlingRunnable();
    }
    FlingRunnable.a(this.mFlingRunnable).setFriction(paramFloat);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    if (this.mFlingRunnable != null) {
      FlingRunnable.a(this.mFlingRunnable).setInterpolator(paramInterpolator);
    }
  }
  
  public void setIsNeedScrollPositionTop(boolean paramBoolean)
  {
    this.mIsNeedScrollPositionTop = paramBoolean;
  }
  
  @TargetApi(11)
  public void setItemChecked(int paramInt, boolean paramBoolean)
  {
    if (this.mChoiceMode == 0) {}
    label144:
    label226:
    label368:
    for (;;)
    {
      return;
      if ((VersionUtils.isHoneycomb()) && (paramBoolean) && (this.mChoiceMode == 3) && (this.mChoiceActionMode == null)) {
        this.mChoiceActionMode = startActionMode(this.mMultiChoiceModeCallback);
      }
      if ((this.mChoiceMode == 2) || (this.mChoiceMode == 3))
      {
        boolean bool = this.mCheckStates.get(paramInt);
        this.mCheckStates.put(paramInt, paramBoolean);
        if ((this.mCheckedIdStates != null) && (this.mAdapter.hasStableIds()))
        {
          if (paramBoolean) {
            this.mCheckedIdStates.put(this.mAdapter.getItemId(paramInt), Integer.valueOf(paramInt));
          }
        }
        else
        {
          if (bool != paramBoolean)
          {
            if (!paramBoolean) {
              break label226;
            }
            this.mCheckedItemCount += 1;
          }
          if (this.mChoiceActionMode != null)
          {
            long l = this.mAdapter.getItemId(paramInt);
            this.mMultiChoiceModeCallback.onItemCheckedStateChanged(this.mChoiceActionMode, paramInt, l, paramBoolean);
          }
        }
      }
      for (;;)
      {
        if ((this.mInLayout) || (this.mBlockLayoutRequests)) {
          break label368;
        }
        this.mDataChanged = true;
        rememberSyncState();
        requestLayout();
        return;
        this.mCheckedIdStates.delete(this.mAdapter.getItemId(paramInt));
        break;
        this.mCheckedItemCount -= 1;
        break label144;
        if ((this.mCheckedIdStates != null) && (this.mAdapter.hasStableIds())) {}
        for (int i = 1;; i = 0)
        {
          if ((paramBoolean) || (isItemChecked(paramInt)))
          {
            this.mCheckStates.clear();
            if (i != 0) {
              this.mCheckedIdStates.clear();
            }
          }
          if (!paramBoolean) {
            break label341;
          }
          this.mCheckStates.put(paramInt, true);
          if (i != 0) {
            this.mCheckedIdStates.put(this.mAdapter.getItemId(paramInt), Integer.valueOf(paramInt));
          }
          this.mCheckedItemCount = 1;
          break;
        }
        if ((this.mCheckStates.size() == 0) || (!this.mCheckStates.valueAt(0))) {
          this.mCheckedItemCount = 0;
        }
      }
    }
  }
  
  public void setMaxOverScrollTopDistance(int paramInt)
  {
    this.mBottomOverflingDistance = ((int)(getResources().getDisplayMetrics().density * paramInt + 0.5F));
  }
  
  public void setMaximumVelocity(int paramInt)
  {
    this.mMaximumVelocity = paramInt;
  }
  
  public void setMultiChoiceModeListener(b paramb)
  {
    if (this.mMultiChoiceModeCallback == null) {
      this.mMultiChoiceModeCallback = new c();
    }
    this.mMultiChoiceModeCallback.a(paramb);
  }
  
  public void setNeedCheckSpringback(boolean paramBoolean)
  {
    this.mNeedCheckSpringback = paramBoolean;
  }
  
  public void setOnScrollListener(e parame)
  {
    this.mOnScrollListener = parame;
    invokeOnItemScrollListener();
  }
  
  public void setOnScrollToButtomListener(d paramd)
  {
    this.mOnScrollButtomListener = paramd;
  }
  
  public void setOverScrollEffectPadding(int paramInt1, int paramInt2)
  {
    this.mGlowPaddingLeft = paramInt1;
    this.mGlowPaddingRight = paramInt2;
  }
  
  public void setOverScrollFlingMode(int paramInt)
  {
    if (this.mFlingRunnable == null) {
      this.mFlingRunnable = new FlingRunnable();
    }
    FlingRunnable.a(this.mFlingRunnable).setFlingMode(paramInt);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2)) {
      throw new IllegalArgumentException("Invalid overscroll mode " + paramInt);
    }
    Context localContext;
    if (paramInt != 2) {
      if ((this.mEdgeGlowTop == null) && (this.mEdgeEffectEnabled)) {
        localContext = getContext();
      }
    }
    try
    {
      this.mEdgeGlowTop = new autl(localContext);
      for (this.mEdgeGlowBottom = new autl(localContext);; this.mEdgeGlowBottom = null)
      {
        label90:
        this.mOverScrollMode = paramInt;
        return;
        this.mEdgeGlowTop = null;
      }
    }
    catch (Throwable localThrowable)
    {
      break label90;
    }
  }
  
  public void setOverScrollTouchMode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(" mode error " + paramInt);
    }
    this.mOverScrollTouchMode = paramInt;
  }
  
  public void setRecyclerListener(g paramg)
  {
    f.a(this.mRecycler, paramg);
  }
  
  public void setScrollIndicators(View paramView1, View paramView2)
  {
    this.mScrollUp = paramView1;
    this.mScrollDown = paramView2;
  }
  
  public void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if ((this.mScrollingCacheEnabled) && (!paramBoolean)) {
      clearScrollingCache();
    }
    this.mScrollingCacheEnabled = paramBoolean;
  }
  
  abstract void setSelectionInt(int paramInt);
  
  public void setSelector(int paramInt)
  {
    setSelector(getResources().getDrawable(paramInt));
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    if (this.mSelector != null)
    {
      this.mSelector.setCallback(null);
      unscheduleDrawable(this.mSelector);
    }
    this.mSelector = paramDrawable;
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    this.mSelectionLeftPadding = localRect.left;
    this.mSelectionTopPadding = localRect.top;
    this.mSelectionRightPadding = localRect.right;
    this.mSelectionBottomPadding = localRect.bottom;
    paramDrawable.setCallback(this);
    updateSelectorState();
  }
  
  public void setSmoothScrollbarEnabled(boolean paramBoolean)
  {
    this.mSmoothScrollbarEnabled = paramBoolean;
  }
  
  public void setStackFromBottom(boolean paramBoolean)
  {
    if (this.mStackFromBottom != paramBoolean)
    {
      this.mStackFromBottom = paramBoolean;
      requestLayoutIfNecessary();
    }
  }
  
  public void setStackFromBottomWithoutRequestLayoutIfNecessary(boolean paramBoolean)
  {
    if (this.mStackFromBottom != paramBoolean) {
      this.mStackFromBottom = paramBoolean;
    }
  }
  
  public void setTextFilterEnabled(boolean paramBoolean)
  {
    this.mTextFilterEnabled = paramBoolean;
  }
  
  public void setTranscriptMode(int paramInt)
  {
    this.mTranscriptMode = paramInt;
  }
  
  public void setVelocityScale(float paramFloat)
  {
    this.mVelocityScale = paramFloat;
  }
  
  public void setVerticalScrollbarPosition(int paramInt)
  {
    super.setVerticalScrollbarPosition(paramInt);
    if (this.mFastScroller != null) {
      this.mFastScroller.abf(paramInt);
    }
  }
  
  boolean shouldShowSelector()
  {
    return ((hasFocus()) && (!isInTouchMode())) || (touchModeDrawsInPressedState());
  }
  
  public boolean showContextMenu(float paramFloat1, float paramFloat2, int paramInt)
  {
    paramInt = pointToPosition((int)paramFloat1, (int)paramFloat2);
    if (paramInt != -1)
    {
      long l = this.mAdapter.getItemId(paramInt);
      View localView = getChildAt(paramInt - this.mFirstPosition);
      if (localView != null)
      {
        this.mContextMenuInfo = createContextMenuInfo(localView, paramInt, l);
        return super.showContextMenuForChild(this);
      }
    }
    return super.showContextMenu();
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    int i = getPositionForView(paramView);
    if (i >= 0)
    {
      long l = this.mAdapter.getItemId(i);
      if (this.mOnItemLongClickListener != null) {
        bool2 = this.mOnItemLongClickListener.a(this, paramView, i, l);
      }
      bool1 = bool2;
      if (!bool2)
      {
        this.mContextMenuInfo = createContextMenuInfo(getChildAt(i - this.mFirstPosition), i, l);
        bool1 = super.showContextMenuForChild(paramView);
      }
    }
    return bool1;
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2)
  {
    if (this.mFlingRunnable == null) {
      this.mFlingRunnable = new FlingRunnable();
    }
    int i = this.mFirstPosition;
    int j = getChildCount();
    int k = this.mPaddingTop;
    int m = getHeight();
    int n = this.mPaddingBottom;
    if ((paramInt1 == 0) || (this.mItemCount == 0) || (j == 0) || ((i == 0) && (getChildAt(0).getTop() == k) && (paramInt1 < 0)) || ((i + j - 1 == this.mItemCount - 1) && (getChildAt(j - 1).getBottom() == m - n) && (paramInt1 > 0)))
    {
      this.mFlingRunnable.ewF();
      if (this.mPositionScroller != null) {
        this.mPositionScroller.stop();
      }
      if (this.mBottomScroller != null) {
        this.mBottomScroller.stop();
      }
      return;
    }
    reportScrollStateChange(2);
    this.mFlingRunnable.startScroll(paramInt1, paramInt2);
  }
  
  public void smoothScrollByImmediately(int paramInt1, int paramInt2)
  {
    if (this.mFlingRunnable == null) {
      this.mFlingRunnable = new FlingRunnable();
    }
    int i = this.mFirstPosition;
    int j = getChildCount();
    int k = this.mPaddingTop;
    int m = getHeight();
    int n = this.mPaddingBottom;
    if ((paramInt1 == 0) || (this.mItemCount == 0) || (j == 0) || ((i == 0) && (getChildAt(0).getTop() == k) && (paramInt1 < 0)) || ((i + j - 1 == this.mItemCount - 1) && (getChildAt(j - 1).getBottom() == m - n) && (paramInt1 > 0)))
    {
      this.mFlingRunnable.ewF();
      if (this.mPositionScroller != null) {
        this.mPositionScroller.stop();
      }
      if (this.mBottomScroller != null) {
        this.mBottomScroller.stop();
      }
      return;
    }
    reportScrollStateChange(2);
    this.mFlingRunnable.kW(paramInt1, paramInt2);
  }
  
  void smoothScrollByOffset(int paramInt)
  {
    int i;
    if (paramInt < 0) {
      i = getFirstVisiblePosition();
    }
    for (;;)
    {
      int j;
      float f;
      if (i > -1)
      {
        View localView = getChildAt(i - getFirstVisiblePosition());
        if (localView != null)
        {
          Rect localRect = new Rect();
          j = i;
          if (localView.getGlobalVisibleRect(localRect))
          {
            j = localView.getWidth();
            int k = localView.getHeight();
            int m = localRect.width();
            f = localRect.height() * m / (k * j);
            if ((paramInt >= 0) || (f >= 0.75F)) {
              break label140;
            }
            j = i + 1;
          }
        }
      }
      for (;;)
      {
        smoothScrollToPosition(Math.max(0, Math.min(getCount(), j + paramInt)));
        return;
        if (paramInt <= 0) {
          break label166;
        }
        i = getLastVisiblePosition();
        break;
        label140:
        j = i;
        if (paramInt > 0)
        {
          j = i;
          if (f < 0.75F) {
            j = i - 1;
          }
        }
      }
      label166:
      i = -1;
    }
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (this.mPositionScroller == null) {
      this.mPositionScroller = new PositionScroller();
    }
    this.mPositionScroller.start(paramInt);
  }
  
  public void smoothScrollToPosition(int paramInt1, int paramInt2)
  {
    if (this.mPositionScroller == null) {
      this.mPositionScroller = new PositionScroller();
    }
    this.mPositionScroller.start(paramInt1, paramInt2);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2)
  {
    if (this.mPositionScroller == null) {
      this.mPositionScroller = new PositionScroller();
    }
    this.mPositionScroller.startWithOffset(paramInt1, paramInt2);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mPositionScroller == null) {
      this.mPositionScroller = new PositionScroller();
    }
    this.mPositionScroller.startWithOffset(paramInt1, paramInt2, paramInt3);
  }
  
  public void springBackTo(int paramInt)
  {
    if (this.mFlingRunnable == null) {
      this.mFlingRunnable = new FlingRunnable();
    }
    this.mFlingRunnable.abb(paramInt);
  }
  
  public boolean startScrollIfNeeded(int paramInt)
  {
    int j = paramInt - this.mMotionY;
    int k = Math.abs(j);
    int i;
    if (this.mScrollY != 0) {
      i = 1;
    }
    while (((i != 0) && (!this.mForHongBao) && (!this.mForStory)) || (k > this.mTouchSlop))
    {
      createScrollingCache();
      if (i != 0)
      {
        this.mTouchMode = 5;
        this.mMotionCorrection = 0;
        Object localObject = getHandler();
        if (localObject != null) {
          ((Handler)localObject).removeCallbacks(this.mPendingCheckForLongPress);
        }
        setPressed(false);
        localObject = getChildAt(this.mMotionPosition - this.mFirstPosition);
        if (localObject != null) {
          ((View)localObject).setPressed(false);
        }
        reportScrollStateChange(1);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        scrollIfNeeded(paramInt);
        return true;
        i = 0;
      }
      else
      {
        this.mTouchMode = 3;
        if (j > 0) {}
        for (i = this.mTouchSlop;; i = -this.mTouchSlop)
        {
          this.mMotionCorrection = i;
          break;
        }
      }
    }
    return false;
  }
  
  boolean touchModeDrawsInPressedState()
  {
    switch (this.mTouchMode)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    int i5 = getChildCount();
    if (i5 == 0) {
      return true;
    }
    traceBegin("AbsListView.trackMotionScroll");
    int i;
    int n;
    int i6;
    label235:
    boolean bool1;
    label266:
    label318:
    label332:
    int i7;
    int i8;
    label400:
    View localView;
    label425:
    label557:
    label576:
    int i1;
    for (;;)
    {
      int i2;
      int i3;
      int k;
      int j;
      int i4;
      int m;
      try
      {
        i2 = getChildAt(0).getTop();
        i3 = getChildAt(i5 - 1).getBottom();
        Rect localRect = this.mListPadding;
        k = 0;
        j = 0;
        if ((this.mGroupFlags & 0x22) == 34)
        {
          k = localRect.top;
          j = localRect.bottom;
        }
        i4 = getHeight();
        i = getHeight() - this.mPaddingBottom - this.mPaddingTop;
        if (paramInt1 < 0)
        {
          m = Math.max(-(i - 1), paramInt1);
          if (paramInt2 < 0)
          {
            n = Math.max(-(i - 1), paramInt2);
            i6 = this.mFirstPosition;
            if (i6 != 0) {
              continue;
            }
            this.mFirstPositionDistanceGuess = (i2 - localRect.top);
            if (i6 + i5 != this.mItemCount) {
              break label318;
            }
            this.mLastPositionDistanceGuess = (localRect.bottom + i3);
            if ((i6 != 0) || (i2 < localRect.top) || (n < 0)) {
              break label772;
            }
            paramInt1 = 1;
            if ((i6 + i5 != this.mItemCount) || (i3 > getHeight() - localRect.bottom) || (n > 0)) {
              break label777;
            }
            paramInt2 = 1;
            break;
            if ((this.mOnScrollButtomListener != null) && (n <= 0)) {
              this.mOnScrollButtomListener.Am(n);
            }
            if (n == 0) {
              break label782;
            }
            bool1 = true;
            return bool1;
          }
        }
        else
        {
          m = Math.min(i - 1, paramInt1);
          continue;
        }
        n = Math.min(i - 1, paramInt2);
        continue;
        this.mFirstPositionDistanceGuess += n;
        continue;
        this.mLastPositionDistanceGuess += n;
      }
      finally
      {
        traceEnd();
      }
      continue;
      for (;;)
      {
        boolean bool2 = isInTouchMode();
        if (bool2) {
          hideSelector();
        }
        i7 = getHeaderViewsCount();
        i8 = this.mItemCount - getFooterViewsCount();
        paramInt2 = 0;
        if (!bool1) {
          break label616;
        }
        paramInt1 = -n;
        paramInt2 = paramInt1;
        if ((this.mGroupFlags & 0x22) != 34) {
          break label799;
        }
        paramInt2 = paramInt1 + localObject.top;
        break label799;
        if (i >= i5) {
          break label806;
        }
        localView = getChildAt(i);
        if (localView.getBottom() < paramInt2) {
          break;
        }
        break label806;
        this.mMotionViewNewTop = (this.mMotionViewOriginalTop + m);
        this.mBlockLayoutRequests = true;
        if (paramInt1 > 0) {
          detachViewsFromParent(paramInt2, paramInt1);
        }
        offsetChildrenTopAndBottom(n);
        if (bool1) {
          this.mFirstPosition = (paramInt1 + this.mFirstPosition);
        }
        invalidate();
        paramInt1 = Math.abs(n);
        if ((k - i2 < paramInt1) || (i3 - (i4 - j) < paramInt1)) {
          fillGap(bool1);
        }
        if ((bool2) || (this.mSelectedPosition == -1)) {
          break label705;
        }
        paramInt1 = this.mSelectedPosition - this.mFirstPosition;
        if ((paramInt1 >= 0) && (paramInt1 < getChildCount())) {
          positionSelector(this.mSelectedPosition, getChildAt(paramInt1));
        }
        this.mBlockLayoutRequests = false;
        invokeOnItemScrollListener();
        awakenScrollBars();
        traceEnd();
        return false;
        bool1 = false;
      }
      i1 = i6 + i;
      if ((i1 < i7) || (i1 >= i8)) {
        break label811;
      }
      this.mRecycler.addScrapView(localView, i1);
      break label811;
      label616:
      paramInt1 = getHeight() - n;
      i1 = paramInt1;
      if ((this.mGroupFlags & 0x22) != 34) {
        break label822;
      }
      i1 = paramInt1 - localView.bottom;
      break label822;
    }
    for (;;)
    {
      if (i >= 0)
      {
        localView = getChildAt(i);
        if (localView.getTop() <= i1) {
          break label425;
        }
        paramInt2 = i6 + i;
        if ((paramInt2 < i7) || (paramInt2 >= i8)) {
          break label832;
        }
        this.mRecycler.addScrapView(localView, paramInt2);
        break label832;
        label705:
        if (this.mSelectorPosition != -1)
        {
          paramInt1 = this.mSelectorPosition - this.mFirstPosition;
          if ((paramInt1 < 0) || (paramInt1 >= getChildCount())) {
            break label557;
          }
          positionSelector(-1, getChildAt(paramInt1));
          break label557;
        }
        this.mSelectorRect.setEmpty();
        break label557;
      }
      break label425;
      for (;;)
      {
        if (paramInt1 != 0) {
          break label780;
        }
        if (paramInt2 == 0) {
          break label788;
        }
        break label235;
        label772:
        paramInt1 = 0;
        break;
        label777:
        paramInt2 = 0;
      }
      label780:
      break label235;
      label782:
      bool1 = false;
      break label266;
      label788:
      if (n >= 0) {
        break label576;
      }
      bool1 = true;
      break label332;
      label799:
      paramInt1 = 0;
      i = 0;
      break label400;
      label806:
      paramInt2 = 0;
      break label425;
      label811:
      i += 1;
      paramInt1 += 1;
      break label400;
      label822:
      paramInt1 = 0;
      i = i5 - 1;
      continue;
      label832:
      paramInt1 += 1;
      paramInt2 = i;
      i -= 1;
    }
  }
  
  void updateScrollIndicators()
  {
    int m = 1;
    int k = 0;
    int i;
    int j;
    label56:
    View localView;
    if (this.mScrollUp != null)
    {
      if (this.mFirstPosition > 0)
      {
        i = 1;
        j = i;
        if (i == 0)
        {
          j = i;
          if (getChildCount() > 0)
          {
            if (getChildAt(0).getTop() >= this.mListPadding.top) {
              break label161;
            }
            j = 1;
          }
        }
        localView = this.mScrollUp;
        if (j == 0) {
          break label166;
        }
        i = 0;
        label68:
        localView.setVisibility(i);
      }
    }
    else if (this.mScrollDown != null)
    {
      j = getChildCount();
      if (this.mFirstPosition + j >= this.mItemCount) {
        break label171;
      }
      i = 1;
      label101:
      if ((i != 0) || (j <= 0)) {
        break label186;
      }
      if (getChildAt(j - 1).getBottom() <= this.mBottom - this.mListPadding.bottom) {
        break label176;
      }
      i = m;
    }
    label137:
    label161:
    label166:
    label171:
    label176:
    label186:
    for (;;)
    {
      localView = this.mScrollDown;
      if (i != 0) {}
      for (i = k;; i = 4)
      {
        localView.setVisibility(i);
        return;
        i = 0;
        break;
        j = 0;
        break label56;
        i = 4;
        break label68;
        i = 0;
        break label101;
        i = 0;
        break label137;
      }
    }
  }
  
  void updateSelectorState()
  {
    if (this.mSelector != null)
    {
      if (shouldShowSelector()) {
        this.mSelector.setState(getDrawableState());
      }
    }
    else {
      return;
    }
    this.mSelector.setState(NOTHING);
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    return (this.mSelector == paramDrawable) || (super.verifyDrawable(paramDrawable));
  }
  
  class CheckForKeyLongPress
    extends AbsListView.i
    implements Runnable
  {
    private CheckForKeyLongPress()
    {
      super(null);
    }
    
    public void run()
    {
      View localView;
      if ((AbsListView.this.isPressed()) && (AbsListView.this.mSelectedPosition >= 0))
      {
        int i = AbsListView.this.mSelectedPosition;
        int j = AbsListView.this.mFirstPosition;
        localView = AbsListView.this.getChildAt(i - j);
        if (AbsListView.this.mDataChanged) {
          break label108;
        }
        if (!aJL()) {
          break label128;
        }
      }
      label128:
      for (boolean bool = AbsListView.this.performLongPress(localView, AbsListView.this.mSelectedPosition, AbsListView.this.mSelectedRowId);; bool = false)
      {
        if (bool)
        {
          AbsListView.this.setPressed(false);
          localView.setPressed(false);
        }
        label108:
        do
        {
          return;
          AbsListView.this.setPressed(false);
        } while (localView == null);
        localView.setPressed(false);
        return;
      }
    }
  }
  
  class CheckForLongPress
    extends AbsListView.i
    implements Runnable
  {
    private CheckForLongPress()
    {
      super(null);
    }
    
    public void run()
    {
      int i = AbsListView.this.mMotionPosition;
      View localView = AbsListView.this.getChildAt(i - AbsListView.this.mFirstPosition);
      long l;
      if (localView != null)
      {
        i = AbsListView.this.mMotionPosition;
        l = AbsListView.this.mAdapter.getItemId(AbsListView.this.mMotionPosition);
        if ((!aJL()) || (AbsListView.this.mDataChanged)) {
          break label126;
        }
      }
      label126:
      for (boolean bool = AbsListView.this.performLongPress(localView, i, l);; bool = false)
      {
        if (bool)
        {
          AbsListView.this.mTouchMode = -1;
          AbsListView.this.setPressed(false);
          localView.setPressed(false);
          return;
        }
        AbsListView.this.mTouchMode = 2;
        return;
      }
    }
  }
  
  final class CheckForTap
    implements Runnable
  {
    CheckForTap() {}
    
    public void run()
    {
      Object localObject;
      int i;
      boolean bool;
      if (AbsListView.this.mTouchMode == 0)
      {
        AbsListView.this.mTouchMode = 1;
        localObject = AbsListView.this.getChildAt(AbsListView.this.mMotionPosition - AbsListView.this.mFirstPosition);
        if ((localObject != null) && (!((View)localObject).hasFocusable()))
        {
          AbsListView.this.mLayoutMode = 0;
          if (AbsListView.this.mDataChanged) {
            break label249;
          }
          ((View)localObject).setPressed(true);
          AbsListView.this.setPressed(true);
          AbsListView.this.layoutChildren();
          AbsListView.this.positionSelector(AbsListView.this.mMotionPosition, (View)localObject);
          AbsListView.this.refreshDrawableState();
          i = ViewConfiguration.getLongPressTimeout();
          bool = AbsListView.this.isLongClickable();
          if (AbsListView.this.mSelector != null)
          {
            localObject = AbsListView.this.mSelector.getCurrent();
            if ((localObject != null) && ((localObject instanceof TransitionDrawable)))
            {
              if (!bool) {
                break label230;
              }
              ((TransitionDrawable)localObject).startTransition(i);
            }
          }
        }
      }
      while (bool)
      {
        if (AbsListView.this.mPendingCheckForLongPress == null) {
          AbsListView.access$702(AbsListView.this, new AbsListView.CheckForLongPress(AbsListView.this, null));
        }
        AbsListView.this.mPendingCheckForLongPress.cCe();
        AbsListView.this.postDelayed(AbsListView.this.mPendingCheckForLongPress, i);
        return;
        label230:
        ((TransitionDrawable)localObject).resetTransition();
      }
      AbsListView.this.mTouchMode = 2;
      return;
      label249:
      AbsListView.this.mTouchMode = 2;
    }
  }
  
  class FlingRunnable
    implements Runnable
  {
    private final Runnable ix = new AbsListView.FlingRunnable.1(this);
    private int mLastFlingY;
    private final auup mScroller = new auup(AbsListView.this.getContext());
    
    FlingRunnable() {}
    
    void abb(int paramInt)
    {
      if (this.mScroller.springBack(0, AbsListView.this.getScrollY(), paramInt, paramInt, paramInt, paramInt))
      {
        AbsListView.this.mTouchMode = 6;
        AbsListView.this.invalidate();
        if (Build.VERSION.SDK_INT >= 16)
        {
          AbsListView.this.postOnAnimation(this);
          return;
        }
        AbsListView.this.post(this);
        return;
      }
      AbsListView.this.mTouchMode = -1;
      AbsListView.this.reportScrollStateChange(0);
    }
    
    @TargetApi(9)
    void abc(int paramInt)
    {
      int i = 0;
      if (AbsListView.this.mForHongBao) {
        i = AbsListView.this.getSpringbackOffset();
      }
      auup localauup = this.mScroller;
      int j;
      if (paramInt > 0)
      {
        j = AbsListView.this.mTopOverflingDistance;
        localauup.notifyVerticalEdgeReached(paramInt, i, j);
        i = AbsListView.this.getOverScrollMode();
        if ((i != 0) && ((i != 1) || (AbsListView.this.contentFits()))) {
          break label165;
        }
        AbsListView.this.mTouchMode = 6;
        i = (int)this.mScroller.getCurrVelocity();
        if (AbsListView.this.mEdgeGlowTop != null)
        {
          if (paramInt <= 0) {
            break label151;
          }
          AbsListView.this.mEdgeGlowTop.onAbsorb(i);
        }
      }
      for (;;)
      {
        AbsListView.this.invalidate();
        if (Build.VERSION.SDK_INT < 16) {
          break label216;
        }
        AbsListView.this.postOnAnimation(this);
        return;
        j = AbsListView.this.mBottomOverflingDistance;
        break;
        label151:
        AbsListView.this.mEdgeGlowBottom.onAbsorb(i);
        continue;
        label165:
        AbsListView.this.mTouchMode = -1;
        if (AbsListView.this.mPositionScroller != null) {
          AbsListView.this.mPositionScroller.stop();
        }
        if (AbsListView.this.mBottomScroller != null) {
          AbsListView.this.mBottomScroller.stop();
        }
      }
      label216:
      AbsListView.this.post(this);
    }
    
    void ewF()
    {
      AbsListView.this.mTouchMode = -1;
      AbsListView.this.removeCallbacks(this);
      AbsListView.this.removeCallbacks(this.ix);
      AbsListView.this.reportScrollStateChange(0);
      AbsListView.this.clearScrollingCache();
      this.mScroller.abortAnimation();
      if (AbsListView.this.mFlingStrictSpan != null) {
        AbsListView.access$1602(AbsListView.this, AbsListView.this.finishSpan(AbsListView.this.mFlingStrictSpan));
      }
    }
    
    void ewG()
    {
      AbsListView.this.postDelayed(this.ix, 40L);
    }
    
    void kW(int paramInt1, int paramInt2)
    {
      this.mScroller.computeScrollOffset();
      int i = this.mScroller.getCurrY();
      i = this.mLastFlingY - i;
      if (i != 0)
      {
        i = -i;
        if (paramInt1 >= 0) {
          break label167;
        }
      }
      label167:
      for (int j = 2147483647;; j = 0)
      {
        this.mLastFlingY = j;
        this.mScroller.startScroll(0, j + i, 0, paramInt1 - i, paramInt2);
        AbsListView.this.mTouchMode = 4;
        AbsListView.this.invalidate();
        AbsListView.this.removeCallbacks(this);
        if (Build.VERSION.SDK_INT < 16) {
          break label173;
        }
        AbsListView.this.postOnAnimation(this);
        return;
        Interpolator localInterpolator = this.mScroller.getInterpolator();
        if (localInterpolator != null)
        {
          i = (int)localInterpolator.getInterpolation(16.0F / paramInt2) * paramInt1;
          break;
        }
        float f = 16.0F / paramInt2;
        i = (int)(1.0F - (1.0F - f) * (1.0F - f)) * paramInt1;
        break;
      }
      label173:
      AbsListView.this.post(this);
    }
    
    @TargetApi(9)
    public void run()
    {
      int k = 1;
      int i;
      int j;
      switch (AbsListView.this.mTouchMode)
      {
      case 5: 
      default: 
        ewF();
      case 3: 
        do
        {
          return;
        } while (this.mScroller.isFinished());
      case 4: 
        AdapterView.traceBegin("AbsListView.FlingRunable.onfling");
        for (;;)
        {
          try
          {
            if (AbsListView.this.mDataChanged) {
              AbsListView.this.layoutChildren();
            }
            if ((AbsListView.this.mItemCount == 0) || (AbsListView.this.getChildCount() == 0))
            {
              ewF();
              return;
            }
            Object localObject1 = this.mScroller;
            boolean bool = ((auup)localObject1).computeScrollOffset();
            int m = ((auup)localObject1).getCurrY();
            i = this.mLastFlingY - m;
            if (i > 0)
            {
              AbsListView.this.mMotionPosition = AbsListView.this.mFirstPosition;
              localObject1 = AbsListView.this.getChildAt(0);
              AbsListView.this.mMotionViewOriginalTop = ((View)localObject1).getTop();
              i = Math.min(AbsListView.this.getHeight() - AbsListView.this.mPaddingBottom - AbsListView.this.mPaddingTop - 1, i);
              localObject1 = AbsListView.this.getChildAt(AbsListView.this.mMotionPosition - AbsListView.this.mFirstPosition);
              if (localObject1 == null) {
                break;
              }
              j = ((View)localObject1).getTop();
              if ((!AbsListView.this.trackMotionScroll(i, i)) || (i == 0)) {
                break label652;
              }
              label254:
              if (k != 0) {
                if (localObject1 != null)
                {
                  j = -(i - (((View)localObject1).getTop() - j));
                  if ((!AbsListView.this.mForHongBao) || (j <= 0))
                  {
                    i = j;
                    if (bool)
                    {
                      abc(j);
                      i = this.mScroller.getCurrY();
                    }
                    AbsListView.this.overScrollBy(0, i, 0, AbsListView.this.getScrollY(), 0, 0, 0, AbsListView.this.mOverscrollDistance, false);
                  }
                }
              }
            }
            else
            {
              j = AbsListView.this.getChildCount() - 1;
              AbsListView.this.mMotionPosition = (AbsListView.this.mFirstPosition + j);
              localObject1 = AbsListView.this.getChildAt(j);
              AbsListView.this.mMotionViewOriginalTop = ((View)localObject1).getTop();
              i = Math.max(-(AbsListView.this.getHeight() - AbsListView.this.mPaddingBottom - AbsListView.this.mPaddingTop - 1), i);
              continue;
            }
            if ((bool) && (k == 0))
            {
              AbsListView.this.invalidate();
              this.mLastFlingY = m;
              if (Build.VERSION.SDK_INT >= 16)
              {
                AbsListView.this.postOnAnimation(this);
                return;
              }
              AbsListView.this.post(this);
              continue;
            }
            ewF();
          }
          finally
          {
            AdapterView.traceEnd();
          }
        }
      }
      label642:
      label652:
      label657:
      for (;;)
      {
        auup localauup;
        label560:
        try
        {
          localauup = this.mScroller;
          if (!localauup.computeScrollOffset()) {
            break label642;
          }
          j = AbsListView.this.getScrollY();
          k = localauup.getCurrY();
          if (!AbsListView.this.overScrollBy(0, k - j, 0, j, 0, 0, 0, AbsListView.this.mOverscrollDistance, false)) {
            break label608;
          }
          if ((j > 0) || (k <= 0)) {
            break label592;
          }
          i = 1;
          break label657;
        }
        finally {}
        k = (int)localauup.getCurrVelocity();
        i = k;
        if (j != 0) {
          i = -k;
        }
        localauup.abortAnimation();
        start(i);
        return;
        label592:
        i = 0;
        break label657;
        label597:
        j = 0;
        label608:
        do
        {
          abb(0);
          return;
          AbsListView.this.invalidate();
          if (Build.VERSION.SDK_INT >= 16)
          {
            AbsListView.this.postOnAnimation(this);
            return;
          }
          AbsListView.this.post(this);
          return;
          ewF();
          return;
          j = 0;
          break;
          k = 0;
          break label254;
          if ((j < 0) || (k >= 0)) {
            break label597;
          }
          j = 1;
          if (i != 0) {
            break label560;
          }
        } while (j == 0);
      }
    }
    
    void start(int paramInt)
    {
      int i;
      if (paramInt < 0)
      {
        i = 2147483647;
        this.mLastFlingY = i;
        this.mScroller.fling(0, i, 0, paramInt, 0, 2147483647, 0, 2147483647);
        AbsListView.this.mTouchMode = 4;
        if (Build.VERSION.SDK_INT < 16) {
          break label87;
        }
        AbsListView.this.postOnAnimation(this);
      }
      for (;;)
      {
        if (AbsListView.this.mFlingStrictSpan == null) {
          AbsListView.access$1602(AbsListView.this, AbsListView.this.enterCriticalSpan("AbsListView-fling"));
        }
        return;
        i = 0;
        break;
        label87:
        AbsListView.this.post(this);
      }
    }
    
    void startScroll(int paramInt1, int paramInt2)
    {
      if (paramInt1 < 0) {}
      for (int i = 2147483647;; i = 0)
      {
        this.mLastFlingY = i;
        this.mScroller.startScroll(0, i, 0, paramInt1, paramInt2);
        AbsListView.this.mTouchMode = 4;
        if (Build.VERSION.SDK_INT < 16) {
          break;
        }
        AbsListView.this.postOnAnimation(this);
        return;
      }
      AbsListView.this.post(this);
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    @ViewDebug.ExportedProperty(category="list")
    boolean djQ;
    @ViewDebug.ExportedProperty(category="list")
    boolean djR;
    int scrappedFromPosition;
    @ViewDebug.ExportedProperty(category="list", mapping={@android.view.ViewDebug.IntToString(from=-1, to="ITEM_VIEW_TYPE_IGNORE"), @android.view.ViewDebug.IntToString(from=-2, to="ITEM_VIEW_TYPE_HEADER_OR_FOOTER")})
    public int viewType;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2);
      this.viewType = paramInt3;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  class MoveToBottomScroller
    implements Runnable
  {
    private int bPG;
    private boolean beE;
    private float mCurrVelocity;
    private int mDistance;
    private int mDuration;
    private long mStartTime;
    private int mStatus;
    private int mTargetPosition;
    private float pM;
    private float pN;
    
    MoveToBottomScroller() {}
    
    public void run()
    {
      int i = 0;
      AdapterView.traceBegin("AbsListView.MoveToBottomScroller.run");
      for (;;)
      {
        int j;
        try
        {
          j = (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
          switch (this.mStatus)
          {
          case 0: 
            i -= this.bPG;
            if (AbsListView.this.trackMotionScroll(-i, -i)) {
              break label564;
            }
            i = AbsListView.this.getChildCount();
            int k = AbsListView.this.mFirstPosition;
            if ((this.mStatus == 3) || (this.mStatus == 1) || (k + i - 1 < this.mTargetPosition)) {
              break label524;
            }
            k = AbsListView.this.mBottom;
            int m = AbsListView.this.mTop;
            int n = AbsListView.this.mListPadding.bottom;
            this.mDistance = (AbsListView.this.getChildAt(i - 1).getBottom() - (k - m - n));
            if (this.mDistance != 0) {
              break label426;
            }
            stop();
            return;
          }
        }
        finally
        {
          AdapterView.traceEnd();
        }
        if (j > 100)
        {
          this.mCurrVelocity = this.pN;
          i = (int)(this.pN * j - this.pN * 400.0F / 8.0F);
          this.pM = 0.0F;
          this.mStatus = 2;
        }
        else
        {
          this.mCurrVelocity = (this.pM * j);
          i = (int)(this.mCurrVelocity * j / 2.0F);
          continue;
          i = (int)(this.pN * j - this.pN * 400.0F / 8.0F);
          continue;
          if (j > this.mDuration)
          {
            i = this.mDistance - this.bPG;
            AbsListView.this.trackMotionScroll(-i, -i);
            AdapterView.traceEnd();
            return;
          }
          this.mCurrVelocity -= this.pM * j;
          i = (int)(this.mDistance - this.mCurrVelocity * (this.mDuration - j) / 2.0F);
          continue;
          if (j > this.mDuration)
          {
            i = this.mDistance - this.bPG;
            AbsListView.this.trackMotionScroll(-i, -i);
            AdapterView.traceEnd();
            return;
          }
          float f = j;
          i = (int)(auqs.viscousFluid(f / this.mDuration) * this.mDistance);
          continue;
          label426:
          this.mDuration = (400 - j);
          if (this.mDuration < 100) {
            this.mDuration = 100;
          }
          this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
          this.bPG = 0;
          if ((this.mCurrVelocity * 1000.0F > AbsListView.this.mMinimumVelocity) && (!this.beE))
          {
            this.mStatus = 1;
            this.mCurrVelocity = (this.mDistance * 2.0F / this.mDuration);
            this.pM = (this.mCurrVelocity / this.mDuration);
            label524:
            if (Build.VERSION.SDK_INT < 16) {
              break label552;
            }
            AbsListView.this.postOnAnimation(this);
          }
          for (;;)
          {
            AdapterView.traceEnd();
            return;
            this.mStatus = 3;
            break;
            label552:
            AbsListView.this.post(this);
            continue;
            label564:
            stop();
          }
        }
      }
    }
    
    void start()
    {
      boolean bool = true;
      int i = AbsListView.this.mFirstPosition;
      int j = AbsListView.this.getChildCount();
      i = AbsListView.this.mItemCount - (i + j - 1) - 1;
      if (i == 0)
      {
        i = AbsListView.this.mBottom;
        j = AbsListView.this.mTop;
        int k = AbsListView.this.mListPadding.bottom;
        this.mDistance = (AbsListView.this.getChildAt(AbsListView.this.getChildCount() - 1).getBottom() - (i - j - k));
        if (this.mDistance == 0)
        {
          stop();
          return;
        }
        this.mDuration = 400;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.bPG = 0;
        this.mStatus = 3;
        if (Build.VERSION.SDK_INT >= 16)
        {
          AbsListView.this.postOnAnimation(this);
          return;
        }
        AbsListView.this.post(this);
        return;
      }
      this.pN = (AbsListView.this.getHeight() * i / AbsListView.this.getChildCount() / 300.0F);
      this.pM = (this.pN / 100.0F);
      this.mCurrVelocity = 0.0F;
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.mStatus = 0;
      this.bPG = 0;
      this.mTargetPosition = (AbsListView.this.mItemCount - 1);
      if (i == 1) {}
      for (;;)
      {
        this.beE = bool;
        if (Build.VERSION.SDK_INT < 16) {
          break;
        }
        AbsListView.this.postOnAnimation(this);
        return;
        bool = false;
      }
      AbsListView.this.post(this);
    }
    
    void stop()
    {
      AbsListView.this.removeCallbacks(this);
      AbsListView.this.mScrollToBottom = false;
    }
  }
  
  class PerformClick
    extends AbsListView.i
    implements Runnable
  {
    int esj;
    
    private PerformClick()
    {
      super(null);
    }
    
    public void run()
    {
      if (AbsListView.this.mDataChanged) {}
      ListAdapter localListAdapter;
      int i;
      boolean bool;
      View localView;
      do
      {
        do
        {
          return;
          localListAdapter = AbsListView.this.mAdapter;
          i = this.esj;
          bool = AbsListView.this.isValidPosition(i, AbsListView.this.mAdapter.getCount());
        } while ((localListAdapter == null) || ((!bool) && (!AbsListView.this.mCallbackOnUnClickItem)) || (!aJL()));
        localView = AbsListView.this.getChildAt(i - AbsListView.this.mFirstPosition);
      } while ((localView == null) && (!AbsListView.this.mCallbackOnUnClickItem));
      AbsListView localAbsListView = AbsListView.this;
      if (bool) {}
      for (long l = localListAdapter.getItemId(i);; l = 0L)
      {
        localAbsListView.performItemClick(localView, i, l);
        return;
      }
    }
  }
  
  class PositionScroller
    implements Runnable
  {
    private int mBoundPos;
    private final int mExtraScroll = ViewConfiguration.get(AbsListView.this.getContext()).getScaledFadingEdgeLength();
    private int mLastSeenPos;
    private int mMode;
    private int mOffsetFromTop;
    private int mScrollDuration;
    private int mTargetPos;
    
    PositionScroller() {}
    
    public void run()
    {
      int i = 0;
      int j = 0;
      int m = AbsListView.this.getHeight();
      int k = AbsListView.this.mFirstPosition;
      switch (this.mMode)
      {
      default: 
      case 1: 
      case 3: 
      case 2: 
      case 4: 
        label944:
        do
        {
          do
          {
            do
            {
              int i1;
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          i = AbsListView.this.getChildCount() - 1;
                          n = k + i;
                        } while (i < 0);
                        if ((!AbsListView.this.mIsNeedScrollPositionTop) && (n == this.mLastSeenPos))
                        {
                          if (Build.VERSION.SDK_INT >= 16)
                          {
                            AbsListView.this.postOnAnimation(this);
                            return;
                          }
                          AbsListView.this.post(this);
                          return;
                        }
                        if ((!AbsListView.this.mIsNeedScrollPositionTop) || (n < this.mTargetPos) || (k > this.mTargetPos)) {
                          break;
                        }
                        i = this.mTargetPos;
                        i = AbsListView.this.getChildAt(i - k).getTop();
                        AbsListView.this.smoothScrollBy(i, 200);
                      } while (!QLog.isColorLevel());
                      QLog.d("XListView", 2, "fight.scroolTop..firstPos = " + k + ",targetPos = " + this.mTargetPos);
                      return;
                      localView = AbsListView.this.getChildAt(i);
                      k = localView.getHeight();
                      i1 = localView.getTop();
                      int i2 = AbsListView.this.mListPadding.bottom;
                      i = j;
                      if (n < this.mTargetPos)
                      {
                        i = j;
                        if (n < AbsListView.this.mItemCount - 1) {
                          i = this.mExtraScroll;
                        }
                      }
                      AbsListView.this.smoothScrollBy(i + (k - (m - i1 - i2)), this.mScrollDuration);
                      this.mLastSeenPos = n;
                    } while (n >= this.mTargetPos);
                    if (Build.VERSION.SDK_INT >= 16)
                    {
                      AbsListView.this.postOnAnimation(this);
                      return;
                    }
                    AbsListView.this.post(this);
                    return;
                    i = AbsListView.this.getChildCount();
                  } while ((k == this.mBoundPos) || (i <= 1) || (i + k >= AbsListView.this.mItemCount));
                  i = k + 1;
                  if (i == this.mLastSeenPos)
                  {
                    if (Build.VERSION.SDK_INT >= 16)
                    {
                      AbsListView.this.postOnAnimation(this);
                      return;
                    }
                    AbsListView.this.post(this);
                    return;
                  }
                  localView = AbsListView.this.getChildAt(1);
                  j = localView.getHeight();
                  k = localView.getTop();
                  m = this.mExtraScroll;
                  if (i < this.mBoundPos)
                  {
                    AbsListView.this.smoothScrollBy(Math.max(0, k + j - m), this.mScrollDuration);
                    this.mLastSeenPos = i;
                    if (Build.VERSION.SDK_INT >= 16)
                    {
                      AbsListView.this.postOnAnimation(this);
                      return;
                    }
                    AbsListView.this.post(this);
                    return;
                  }
                } while (k <= m);
                AbsListView.this.smoothScrollBy(k - m, this.mScrollDuration);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("XListView", 2, new Object[] { " MOVE_UP_POS:firstPos=", Integer.valueOf(k), " mLastSeenPos=", Integer.valueOf(this.mLastSeenPos), " mTargetPos", Integer.valueOf(this.mTargetPos) });
                }
              } while ((k == this.mLastSeenPos) && (k <= this.mTargetPos));
              if ((AbsListView.this.mIsNeedScrollPositionTop) && (this.mTargetPos == 0))
              {
                m = AbsListView.this.getChildCount();
                if ((AbsListView.this.mItemCount > 30) && (k + m - 1 > m * 3 - 1))
                {
                  j = this.mScrollDuration * m / 2;
                  i = j;
                  if (j < 30) {
                    i = 30;
                  }
                  j = AbsListView.this.getHeight();
                  n = AbsListView.this.mListPadding.top;
                  i1 = AbsListView.this.mListPadding.bottom;
                  AbsListView.this.smoothScrollBy(-(j - n - i1), i);
                  if (QLog.isColorLevel()) {
                    QLog.d("XListView", 2, "fight.scroolTop..firstPos = " + k + ",targetPos = " + this.mTargetPos + ",duration = " + i + ",childCount " + m);
                  }
                  this.mLastSeenPos = k;
                  if (Build.VERSION.SDK_INT >= 16)
                  {
                    AbsListView.this.postOnAnimation(this);
                    return;
                  }
                  AbsListView.this.post(this);
                  return;
                }
              }
              localView = AbsListView.this.getChildAt(0);
            } while (localView == null);
            j = localView.getTop();
            if (k > 0) {}
            for (i = this.mExtraScroll;; i = AbsListView.this.mListPadding.top)
            {
              AbsListView.this.smoothScrollBy(j - i, this.mScrollDuration);
              this.mLastSeenPos = k;
              if (k <= this.mTargetPos) {
                break;
              }
              if (Build.VERSION.SDK_INT < 16) {
                break label944;
              }
              AbsListView.this.postOnAnimation(this);
              return;
            }
            AbsListView.this.post(this);
            return;
            j = AbsListView.this.getChildCount() - 2;
          } while (j < 0);
          i = k + j;
          if (i == this.mLastSeenPos)
          {
            if (Build.VERSION.SDK_INT >= 16)
            {
              AbsListView.this.postOnAnimation(this);
              return;
            }
            AbsListView.this.post(this);
            return;
          }
          View localView = AbsListView.this.getChildAt(j);
          j = localView.getHeight();
          k = localView.getTop();
          this.mLastSeenPos = i;
          if (i > this.mBoundPos)
          {
            AbsListView.this.smoothScrollBy(-(m - k - this.mExtraScroll), this.mScrollDuration);
            if (Build.VERSION.SDK_INT >= 16)
            {
              AbsListView.this.postOnAnimation(this);
              return;
            }
            AbsListView.this.post(this);
            return;
          }
          i = m - this.mExtraScroll;
          j = k + j;
        } while (i <= j);
        AbsListView.this.smoothScrollBy(-(i - j), this.mScrollDuration);
        return;
      }
      if (this.mLastSeenPos == k)
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          AbsListView.this.postOnAnimation(this);
          return;
        }
        AbsListView.this.post(this);
        return;
      }
      this.mLastSeenPos = k;
      j = AbsListView.this.getChildCount();
      m = this.mTargetPos;
      int n = k + j - 1;
      if (m < k) {
        i = k - m + 1;
      }
      float f;
      for (;;)
      {
        f = Math.min(Math.abs(i / j), 1.0F);
        if (m >= k) {
          break label1292;
        }
        AbsListView.this.smoothScrollBy((int)(f * -AbsListView.this.getHeight()), this.mScrollDuration);
        if (Build.VERSION.SDK_INT < 16) {
          break;
        }
        AbsListView.this.postOnAnimation(this);
        return;
        if (m > n) {
          i = m - n;
        }
      }
      AbsListView.this.post(this);
      return;
      label1292:
      if (m > n)
      {
        AbsListView.this.smoothScrollBy((int)(f * AbsListView.this.getHeight()), this.mScrollDuration);
        if (Build.VERSION.SDK_INT >= 16)
        {
          AbsListView.this.postOnAnimation(this);
          return;
        }
        AbsListView.this.post(this);
        return;
      }
      i = AbsListView.this.getChildAt(m - k).getTop() - this.mOffsetFromTop;
      j = Math.abs((int)(this.mScrollDuration * (i / AbsListView.this.getHeight())));
      AbsListView.this.smoothScrollBy(i, j);
    }
    
    void start(int paramInt)
    {
      stop();
      int i = AbsListView.this.mFirstPosition;
      int j = AbsListView.this.getChildCount() + i - 1;
      if (paramInt <= i)
      {
        i = i - paramInt + 1;
        this.mMode = 2;
        if (i <= 0) {
          break label126;
        }
      }
      label126:
      for (this.mScrollDuration = (400 / i);; this.mScrollDuration = 400)
      {
        this.mTargetPos = paramInt;
        this.mBoundPos = -1;
        this.mLastSeenPos = -1;
        if (Build.VERSION.SDK_INT < 16) {
          break label136;
        }
        AbsListView.this.postOnAnimation(this);
        do
        {
          return;
          if (paramInt >= j)
          {
            i = paramInt - j + 1;
            this.mMode = 1;
            break;
          }
        } while (!AbsListView.this.mIsNeedScrollPositionTop);
        i = paramInt - i;
        this.mMode = 1;
        break;
      }
      label136:
      AbsListView.this.post(this);
    }
    
    void start(int paramInt1, int paramInt2)
    {
      stop();
      if (paramInt2 == -1) {
        start(paramInt1);
      }
      int j;
      do
      {
        return;
        i = AbsListView.this.mFirstPosition;
        j = AbsListView.this.getChildCount() + i - 1;
        if (paramInt1 > i) {
          break;
        }
        j -= paramInt2;
      } while (j < 1);
      int i = i - paramInt1 + 1;
      j -= 1;
      if (j < i)
      {
        this.mMode = 4;
        i = j;
        label79:
        if (i <= 0) {
          break label187;
        }
      }
      label185:
      label187:
      for (this.mScrollDuration = (400 / i);; this.mScrollDuration = 400)
      {
        this.mTargetPos = paramInt1;
        this.mBoundPos = paramInt2;
        this.mLastSeenPos = -1;
        if (Build.VERSION.SDK_INT < 16) {
          break label197;
        }
        AbsListView.this.postOnAnimation(this);
        return;
        for (this.mMode = 2;; this.mMode = 1)
        {
          break label79;
          if (paramInt1 < j) {
            break label185;
          }
          int k = paramInt2 - i;
          if (k < 1) {
            break;
          }
          i = paramInt1 - j + 1;
          j = k - 1;
          if (j < i)
          {
            this.mMode = 3;
            i = j;
            break label79;
          }
        }
        break;
      }
      label197:
      AbsListView.this.post(this);
    }
    
    void startWithOffset(int paramInt1, int paramInt2)
    {
      startWithOffset(paramInt1, paramInt2, 400);
    }
    
    void startWithOffset(int paramInt1, int paramInt2, int paramInt3)
    {
      stop();
      this.mTargetPos = paramInt1;
      this.mOffsetFromTop = paramInt2;
      this.mBoundPos = -1;
      this.mLastSeenPos = -1;
      this.mMode = 5;
      int j = AbsListView.this.mFirstPosition;
      int i = AbsListView.this.getChildCount();
      int k = j + i - 1;
      if (paramInt1 < j) {
        paramInt1 = j - paramInt1;
      }
      for (;;)
      {
        float f = paramInt1 / i;
        this.mScrollDuration = ((int)(paramInt3 / f));
        this.mLastSeenPos = -1;
        if (Build.VERSION.SDK_INT < 16) {
          break label148;
        }
        AbsListView.this.postOnAnimation(this);
        return;
        if (paramInt1 <= k) {
          break;
        }
        paramInt1 -= k;
      }
      paramInt1 = AbsListView.this.getChildAt(paramInt1 - j).getTop();
      AbsListView.this.smoothScrollBy(paramInt1 - paramInt2, paramInt3);
      return;
      label148:
      AbsListView.this.post(this);
    }
    
    void stop()
    {
      AbsListView.this.removeCallbacks(this);
      if (AbsListView.this.mBottomScroller != null) {
        AbsListView.this.mBottomScroller.stop();
      }
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new ausf();
    long ayX;
    String cIU;
    boolean djS;
    int esk;
    int esl;
    int height;
    aure<Integer> o;
    public int position;
    SparseBooleanArray r;
    long selectedId = -1L;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.selectedId = paramParcel.readLong();
      this.ayX = paramParcel.readLong();
      this.esk = paramParcel.readInt();
      this.position = paramParcel.readInt();
      this.height = paramParcel.readInt();
      this.cIU = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.djS = bool;
        this.esl = paramParcel.readInt();
        this.r = paramParcel.readSparseBooleanArray();
        int j = paramParcel.readInt();
        if (j <= 0) {
          break;
        }
        this.o = new aure();
        while (i < j)
        {
          long l = paramParcel.readLong();
          int k = paramParcel.readInt();
          this.o.put(l, Integer.valueOf(k));
          i += 1;
        }
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " firstId=" + this.ayX + " viewTop=" + this.esk + " position=" + this.position + " height=" + this.height + " filter=" + this.cIU + " checkState=" + this.r + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 0;
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeLong(this.selectedId);
      paramParcel.writeLong(this.ayX);
      paramParcel.writeInt(this.esk);
      paramParcel.writeInt(this.position);
      paramParcel.writeInt(this.height);
      paramParcel.writeString(this.cIU);
      if (this.djS)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.esl);
        paramParcel.writeSparseBooleanArray(this.r);
        if (this.o == null) {
          break label154;
        }
      }
      label154:
      for (paramInt = this.o.size();; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        while (i < paramInt)
        {
          paramParcel.writeLong(this.o.keyAt(i));
          paramParcel.writeInt(((Integer)this.o.valueAt(i)).intValue());
          i += 1;
        }
        paramInt = 0;
        break;
      }
    }
  }
  
  class a
    extends AdapterView<ListAdapter>.b
  {
    a()
    {
      super();
    }
    
    public void onChanged()
    {
      super.onChanged();
      if (AbsListView.this.mFastScroller != null) {
        AbsListView.this.mFastScroller.ewM();
      }
    }
    
    public void onInvalidated()
    {
      super.onInvalidated();
      if (AbsListView.this.mFastScroller != null) {
        AbsListView.this.mFastScroller.ewM();
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public static abstract interface b
    extends ActionMode.Callback
  {
    public abstract void onItemCheckedStateChanged(ActionMode paramActionMode, int paramInt, long paramLong, boolean paramBoolean);
  }
  
  @SuppressLint({"NewApi"})
  class c
    implements AbsListView.b
  {
    private AbsListView.b a;
    
    c() {}
    
    public void a(AbsListView.b paramb)
    {
      this.a = paramb;
    }
    
    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return this.a.onActionItemClicked(paramActionMode, paramMenuItem);
    }
    
    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      boolean bool = false;
      if (this.a.onCreateActionMode(paramActionMode, paramMenu))
      {
        AbsListView.this.setLongClickable(false);
        bool = true;
      }
      return bool;
    }
    
    public void onDestroyActionMode(ActionMode paramActionMode)
    {
      this.a.onDestroyActionMode(paramActionMode);
      AbsListView.this.mChoiceActionMode = null;
      AbsListView.this.clearChoices();
      AbsListView.this.mDataChanged = true;
      AbsListView.this.rememberSyncState();
      AbsListView.this.requestLayout();
      AbsListView.this.setLongClickable(true);
    }
    
    public void onItemCheckedStateChanged(ActionMode paramActionMode, int paramInt, long paramLong, boolean paramBoolean)
    {
      this.a.onItemCheckedStateChanged(paramActionMode, paramInt, paramLong, paramBoolean);
      if (AbsListView.this.getCheckedItemCount() == 0) {
        paramActionMode.finish();
      }
    }
    
    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return this.a.onPrepareActionMode(paramActionMode, paramMenu);
    }
  }
  
  public static abstract interface d
  {
    public abstract void Am(int paramInt);
  }
  
  public static abstract interface e
  {
    public abstract void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void onScrollStateChanged(AbsListView paramAbsListView, int paramInt);
  }
  
  class f
  {
    private AbsListView.g a;
    private View[] mActiveViews = new View[0];
    private ArrayList<View> mCurrentScrap;
    private int mFirstActivePosition;
    private ArrayList<View>[] mScrapViews;
    private int mViewTypeCount;
    
    f() {}
    
    private void pruneScrapViews()
    {
      int m = this.mActiveViews.length;
      int n = this.mViewTypeCount;
      ArrayList[] arrayOfArrayList = this.mScrapViews;
      int i = 0;
      while (i < n)
      {
        ArrayList localArrayList = arrayOfArrayList[i];
        int i1 = localArrayList.size();
        int j = i1 - 1;
        int k = 0;
        while (k < i1 - m)
        {
          AbsListView.this.removeDetachedView((View)localArrayList.remove(j), false);
          k += 1;
          j -= 1;
        }
        i += 1;
      }
    }
    
    void addScrapView(View paramView, int paramInt)
    {
      AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams == null) {}
      for (;;)
      {
        return;
        int i = localLayoutParams.viewType;
        if (!shouldRecycleViewType(i))
        {
          if (i != -2) {
            AbsListView.this.removeDetachedView(paramView, false);
          }
        }
        else
        {
          localLayoutParams.scrappedFromPosition = paramInt;
          if (this.mViewTypeCount == 1)
          {
            AbsListView.this.dispatchStartTemporaryDetachForView(paramView);
            this.mCurrentScrap.add(paramView);
          }
          while (this.a != null)
          {
            this.a.onMovedToScrapHeap(paramView);
            return;
            AbsListView.this.dispatchStartTemporaryDetachForView(paramView);
            if (i < this.mScrapViews.length) {
              this.mScrapViews[i].add(paramView);
            }
          }
        }
      }
    }
    
    void clear()
    {
      ArrayList localArrayList;
      int j;
      if (this.mViewTypeCount == 1)
      {
        localArrayList = this.mCurrentScrap;
        j = localArrayList.size();
        i = 0;
        while (i < j)
        {
          AbsListView.this.removeDetachedView((View)localArrayList.remove(j - 1 - i), false);
          i += 1;
        }
      }
      int k = this.mViewTypeCount;
      int i = 0;
      while (i < k)
      {
        localArrayList = this.mScrapViews[i];
        int m = localArrayList.size();
        j = 0;
        while (j < m)
        {
          AbsListView.this.removeDetachedView((View)localArrayList.remove(m - 1 - j), false);
          j += 1;
        }
        i += 1;
      }
    }
    
    void fillActiveViews(int paramInt1, int paramInt2)
    {
      if (this.mActiveViews.length < paramInt1) {
        this.mActiveViews = new View[paramInt1];
      }
      this.mFirstActivePosition = paramInt2;
      View[] arrayOfView = this.mActiveViews;
      paramInt2 = 0;
      while (paramInt2 < paramInt1)
      {
        View localView = AbsListView.this.getChildAt(paramInt2);
        AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams != null) && (localLayoutParams.viewType != -2)) {
          arrayOfView[paramInt2] = localView;
        }
        paramInt2 += 1;
      }
    }
    
    View getActiveView(int paramInt)
    {
      paramInt -= this.mFirstActivePosition;
      View[] arrayOfView = this.mActiveViews;
      if ((paramInt >= 0) && (paramInt < arrayOfView.length))
      {
        View localView = arrayOfView[paramInt];
        arrayOfView[paramInt] = null;
        return localView;
      }
      return null;
    }
    
    View getScrapView(int paramInt)
    {
      if (this.mViewTypeCount == 1) {
        return AbsListView.retrieveFromScrap(this.mCurrentScrap, paramInt);
      }
      int i = AbsListView.this.mAdapter.getItemViewType(paramInt);
      if ((i >= 0) && (this.mScrapViews != null) && (i < this.mScrapViews.length)) {
        return AbsListView.retrieveFromScrap(this.mScrapViews[i], paramInt);
      }
      return null;
    }
    
    public void markChildrenDirty()
    {
      int i = 0;
      ArrayList localArrayList;
      int j;
      if (this.mViewTypeCount == 1)
      {
        localArrayList = this.mCurrentScrap;
        j = localArrayList.size();
        while (i < j)
        {
          ((View)localArrayList.get(i)).forceLayout();
          i += 1;
        }
      }
      int k = this.mViewTypeCount;
      i = 0;
      while (i < k)
      {
        localArrayList = this.mScrapViews[i];
        int m = localArrayList.size();
        j = 0;
        while (j < m)
        {
          ((View)localArrayList.get(j)).forceLayout();
          j += 1;
        }
        i += 1;
      }
    }
    
    void reclaimScrapViews(List<View> paramList)
    {
      if (this.mViewTypeCount == 1) {
        paramList.addAll(this.mCurrentScrap);
      }
      for (;;)
      {
        return;
        int j = this.mViewTypeCount;
        ArrayList[] arrayOfArrayList = this.mScrapViews;
        int i = 0;
        while (i < j)
        {
          paramList.addAll(arrayOfArrayList[i]);
          i += 1;
        }
      }
    }
    
    void scrapActiveViews()
    {
      View[] arrayOfView = this.mActiveViews;
      int i;
      int j;
      label25:
      Object localObject1;
      int k;
      label37:
      View localView;
      Object localObject2;
      int m;
      if (this.a != null)
      {
        i = 1;
        if (this.mViewTypeCount <= 1) {
          break label128;
        }
        j = 1;
        localObject1 = this.mCurrentScrap;
        k = arrayOfView.length - 1;
        if (k < 0) {
          break label200;
        }
        localView = arrayOfView[k];
        localObject2 = localObject1;
        if (localView != null)
        {
          localObject2 = (AbsListView.LayoutParams)localView.getLayoutParams();
          m = ((AbsListView.LayoutParams)localObject2).viewType;
          arrayOfView[k] = null;
          if (shouldRecycleViewType(m)) {
            break label133;
          }
          localObject2 = localObject1;
          if (m != -2)
          {
            AbsListView.this.removeDetachedView(localView, false);
            localObject2 = localObject1;
          }
        }
      }
      for (;;)
      {
        k -= 1;
        localObject1 = localObject2;
        break label37;
        i = 0;
        break;
        label128:
        j = 0;
        break label25;
        label133:
        if (j != 0) {
          localObject1 = this.mScrapViews[m];
        }
        AbsListView.this.dispatchStartTemporaryDetachForView(localView);
        ((AbsListView.LayoutParams)localObject2).scrappedFromPosition = (this.mFirstActivePosition + k);
        ((ArrayList)localObject1).add(localView);
        localObject2 = localObject1;
        if (i != 0)
        {
          this.a.onMovedToScrapHeap(localView);
          localObject2 = localObject1;
        }
      }
      label200:
      pruneScrapViews();
    }
    
    void setCacheColorHint(int paramInt)
    {
      if (this.mViewTypeCount == 1)
      {
        localObject1 = this.mCurrentScrap;
        j = ((ArrayList)localObject1).size();
        i = 0;
        while (i < j)
        {
          ((View)((ArrayList)localObject1).get(i)).setDrawingCacheBackgroundColor(paramInt);
          i += 1;
        }
      }
      int k = this.mViewTypeCount;
      int i = 0;
      while (i < k)
      {
        localObject1 = this.mScrapViews[i];
        int m = ((ArrayList)localObject1).size();
        j = 0;
        while (j < m)
        {
          ((View)((ArrayList)localObject1).get(j)).setDrawingCacheBackgroundColor(paramInt);
          j += 1;
        }
        i += 1;
      }
      Object localObject1 = this.mActiveViews;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          localObject2.setDrawingCacheBackgroundColor(paramInt);
        }
        i += 1;
      }
    }
    
    public void setViewTypeCount(int paramInt)
    {
      if (paramInt < 1) {
        throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
      }
      ArrayList[] arrayOfArrayList = new ArrayList[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        arrayOfArrayList[i] = new ArrayList();
        i += 1;
      }
      this.mViewTypeCount = paramInt;
      this.mCurrentScrap = arrayOfArrayList[0];
      this.mScrapViews = arrayOfArrayList;
    }
    
    public boolean shouldRecycleViewType(int paramInt)
    {
      return paramInt >= 0;
    }
  }
  
  public static abstract interface g
  {
    public abstract void onMovedToScrapHeap(View paramView);
  }
  
  public static abstract interface h
  {
    public abstract void adjustListItemSelectionBounds(Rect paramRect);
  }
  
  class i
  {
    private int esm;
    
    private i() {}
    
    public boolean aJL()
    {
      return (AbsListView.this.hasWindowFocus()) && (AbsListView.this.getWindowAttachCount() == this.esm);
    }
    
    public void cCe()
    {
      this.esm = AbsListView.this.getWindowAttachCount();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.widget.AbsListView
 * JD-Core Version:    0.7.0.1
 */