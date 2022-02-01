package com.tencent.mobileqq.multiaio.widget;

import aajx;
import ajin;
import ajiy;
import ajiz;
import ajja;
import ajjb;
import ajjc;
import ajjd;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.OverScroller;
import aqdf.a;
import aute;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import tog;
import top;

public class TabPageIndicator
  extends HorizontalScrollView
  implements ajiz, aqdf.a
{
  private static float MAX_SCALE = 1.333F;
  private static float MIN_SCALE = 1.0F;
  private List<RecentBaseData> Di;
  private ajiy jdField_a_of_type_Ajiy;
  private ajjd jdField_a_of_type_Ajjd;
  private IcsLinearLayout jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout;
  private MultiAIOBaseViewPager jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager;
  private b jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator$b;
  private d jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator$d;
  private e jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator$e;
  private long acT;
  private QQAppInterface app;
  private MultiAIOBaseViewPager.g c;
  private final View.OnClickListener ce = new ajja(this);
  private boolean coT;
  private boolean coU;
  private int count;
  private long decodeFaceStartTime;
  private int djn;
  private int djq = -1;
  private int djr;
  private int djs = 2147483647;
  private Hashtable<String, Bitmap> faceCache = new Hashtable();
  private View.OnClickListener fs;
  private int itemWidth;
  private int leftPadding;
  private BaseActivity mActivity;
  protected aajx mFaceDecoder;
  private GestureDetector mGestureDetector;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private LayoutInflater mInflater;
  private boolean mIsBeingDragged;
  private List<c> mOnPageChangeListeners;
  private int mScreenWidth;
  private int mScrollState = 0;
  private int mSelectedTabIndex;
  private Runnable mTabSelector;
  private int[] mTmpLocation = new int[2];
  private final int maxNum = 99;
  private float xm;
  
  public TabPageIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabPageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabPageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramInt);
  }
  
  private void J(View paramView, boolean paramBoolean)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof a)) {}
    for (paramView = (a)paramView;; paramView = null)
    {
      if (paramView != null)
      {
        paramView = paramView.arrow;
        if (!paramBoolean) {
          break label38;
        }
      }
      label38:
      for (int i = 0;; i = 4)
      {
        paramView.setVisibility(i);
        return;
      }
    }
  }
  
  private void QX(int paramInt)
  {
    J(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(paramInt), false);
  }
  
  private void QY(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "onPageScrollStateChangedInternal() called with: state = [" + paramInt + "]");
    }
    switch (paramInt)
    {
    }
  }
  
  private void a(a parama, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if ((parama == null) || (paramRecentBaseData == null)) {
      return;
    }
    Drawable localDrawable = paramDrawable;
    int i;
    if (paramDrawable == null)
    {
      i = paramRecentBaseData.ng();
      if ((!(paramRecentBaseData instanceof RecentCallItem)) || (!((RecentCallItem)paramRecentBaseData).WD())) {
        break label68;
      }
      i = 3002;
    }
    label68:
    for (;;)
    {
      localDrawable = this.mFaceDecoder.a(i, paramRecentBaseData.qx());
      b(parama, paramRecentBaseData, localDrawable);
      return;
    }
  }
  
  private void animateToTab(int paramInt)
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(paramInt);
    if (localView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "animateToTab error, tabView is null!");
      }
      return;
    }
    if (this.mTabSelector != null) {
      removeCallbacks(this.mTabSelector);
    }
    this.mTabSelector = new TabPageIndicator.5(this, localView);
    post(this.mTabSelector);
  }
  
  private boolean aqT()
  {
    return ((this.mScrollState == 1) || (this.mScrollState == 2)) && (this.djr == 0);
  }
  
  private boolean aqU()
  {
    try
    {
      if (this.coU)
      {
        Field localField = HorizontalScrollView.class.getDeclaredField("mScroller");
        localField.setAccessible(true);
        boolean bool = ((OverScroller)localField.get(this)).isFinished();
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "isFinishScroll: ", localException);
    }
    return true;
  }
  
  private void b(a parama, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if ((parama == null) || (paramRecentBaseData == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("TabPageIndicator", 2, "holder|param invalidate");
      }
    }
    label176:
    label204:
    label367:
    label376:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "getView position: ");
      }
      int j;
      int i;
      boolean bool;
      if (needDynamic(paramRecentBaseData))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TabPageIndicator", 2, "bindview user:" + paramRecentBaseData.qx());
        }
        j = ((Integer)aajx.a(this.app, paramRecentBaseData.ng(), paramRecentBaseData.qx()).first).intValue();
        i = j;
        if (j == 103) {
          i = 1;
        }
        RecentDynamicAvatarView localRecentDynamicAvatarView = parama.d;
        QQAppInterface localQQAppInterface = this.app;
        String str = paramRecentBaseData.qx();
        if (this.app.a.Bd() == 1)
        {
          bool = true;
          localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, str, 100, false, bool, 0);
          parama.arrow.setVisibility(4);
          j = paramRecentBaseData.mUnreadNum;
          if (j <= 99) {
            break label318;
          }
          parama.bRC = "99+";
          if (j <= 0) {
            break label367;
          }
          if (paramRecentBaseData.mUnreadFlag != 3) {
            break label330;
          }
          i = 2130845715;
          parama.l.setDragViewType(1, null);
          parama.l.setTextColor(this.mActivity.getResources().getColor(2131166108));
          label251:
          aute.updateCustomNoteTxt(parama.l, 3, j, i, 99, null);
        }
      }
      for (;;)
      {
        if ((!"1103".equals(ThemeUtil.curThemeId)) && (!"2920".equals(ThemeUtil.curThemeId))) {
          break label376;
        }
        parama.arrow.setImageResource(2130838184);
        return;
        bool = false;
        break;
        parama.d.setImageDrawable(paramDrawable);
        break label176;
        parama.bRC = String.valueOf(j);
        break label204;
        i = 2130851404;
        parama.l.setDragViewType(0, null);
        parama.l.setTextColor(this.mActivity.getResources().getColor(2131167429));
        break label251;
        parama.l.setVisibility(4);
      }
    }
  }
  
  private void dispatchOnScrollStateChanged(int paramInt)
  {
    if (this.mOnPageChangeListeners != null)
    {
      int j = this.mOnPageChangeListeners.size();
      int i = 0;
      while (i < j)
      {
        c localc = (c)this.mOnPageChangeListeners.get(i);
        if (localc != null) {
          localc.onPageScrollStateChanged(paramInt);
        }
        i += 1;
      }
    }
    QY(paramInt);
  }
  
  private void dxN()
  {
    try
    {
      Object localObject = HorizontalScrollView.class.getDeclaredField("mVelocityTracker");
      ((Field)localObject).setAccessible(true);
      localObject = (VelocityTracker)((Field)localObject).get(this);
      if (localObject != null) {
        this.xm = ((VelocityTracker)localObject).getXVelocity();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "readLastInitVelocity: ", localException);
    }
  }
  
  private void dxO()
  {
    try
    {
      Field localField = HorizontalScrollView.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      ajiy localajiy = new ajiy(getContext());
      localField.set(this, localajiy);
      this.jdField_a_of_type_Ajiy = ((ajiy)localajiy);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "replaceOverScroller: ", localException);
    }
  }
  
  private void dxP()
  {
    try
    {
      Field localField = (Field)Class.class.getDeclaredMethod("getDeclaredField", new Class[] { String.class }).invoke(HorizontalScrollView.class, new Object[] { "mMaximumVelocity" });
      localField.setAccessible(true);
      int i = localField.getInt(this);
      this.djn = ajin.s(getContext(), i);
      localField.set(this, Integer.valueOf(this.djn));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "setMaxVelocity: ", localException);
    }
  }
  
  private void dxQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "onFinishScroll() called");
    }
    this.djs = 2147483647;
    this.coU = false;
    setScrollState(0);
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.isFakeDragging())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "computeScroll() isFakeDragging");
      }
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.endFakeDrag();
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getCurrentItem();
    this.mSelectedTabIndex = j;
    int k = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount();
    int i = 0;
    if (i < k)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(i);
      if (i == j) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        i += 1;
        break;
      }
    }
    this.djq = j;
  }
  
  private void hf(View paramView)
  {
    paramView.setFocusable(true);
    paramView.setOnClickListener(this.ce);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.removeView(paramView);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.addView(paramView, new LinearLayout.LayoutParams(-2, -1));
  }
  
  private void init(Context paramContext, int paramInt)
  {
    this.mInflater = LayoutInflater.from(paramContext);
    setHorizontalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout = new IcsLinearLayout(paramContext, paramInt);
    this.mGestureDetector = new GestureDetector(getContext(), new ajjb(this), new Handler(Looper.getMainLooper()));
    addView(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout, new ViewGroup.LayoutParams(-2, -1));
    dxO();
    this.jdField_a_of_type_Ajiy.a(new ajjc(this));
    dxP();
  }
  
  public View O(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "getView position: " + paramInt);
    }
    RecentBaseData localRecentBaseData = (RecentBaseData)this.Di.get(paramInt);
    a locala = new a();
    View localView = this.mInflater.inflate(2131558672, null);
    locala.d = ((RecentDynamicAvatarView)localView.findViewById(2131379150));
    locala.l = ((DragTextView)localView.findViewById(2131381236));
    locala.arrow = ((ImageView)localView.findViewById(2131362978));
    locala.index = paramInt;
    localView.setTag(locala);
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.mFaceDecoder != null) {}
    for (Drawable localDrawable = this.mFaceDecoder.a(localRecentBaseData);; localDrawable = null)
    {
      b(locala, localRecentBaseData, localDrawable);
      localStringBuilder.append(localRecentBaseData.getTitleName());
      if (AppSetting.enableTalkBack) {
        localView.setContentDescription(localStringBuilder.toString());
      }
      return localView;
    }
  }
  
  public void a(a parama, RecentBaseData paramRecentBaseData)
  {
    if ((parama == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TabPageIndicator", 2, "updateItem|invalidate error");
      }
      return;
    }
    int j = paramRecentBaseData.mUnreadNum;
    int i;
    if (j > 99)
    {
      parama.bRC = "99+";
      if (j <= 0) {
        break label287;
      }
      if (paramRecentBaseData.ng() != 1) {
        break label170;
      }
      i = this.app.cs(paramRecentBaseData.qx());
      if (i != 1) {
        break label147;
      }
      paramRecentBaseData.mUnreadFlag = 1;
      label79:
      if (paramRecentBaseData.mUnreadFlag != 3) {
        break label251;
      }
      i = 2130845715;
      parama.l.setDragViewType(1, null);
      parama.l.setTextColor(this.mActivity.getResources().getColor(2131166108));
    }
    for (;;)
    {
      aute.updateCustomNoteTxt(parama.l, 3, j, i, 99, null);
      return;
      parama.bRC = String.valueOf(j);
      break;
      label147:
      if ((i != 2) && (i != 3) && (i != 4)) {
        break label79;
      }
      paramRecentBaseData.mUnreadFlag = 3;
      break label79;
      label170:
      if (paramRecentBaseData.ng() == 3000)
      {
        if (top.g(this.app, paramRecentBaseData.qx(), paramRecentBaseData.ng()))
        {
          paramRecentBaseData.mUnreadFlag = 3;
          break label79;
        }
        paramRecentBaseData.mUnreadFlag = 1;
        break label79;
      }
      if (paramRecentBaseData.ng() != 0) {
        break label79;
      }
      if (FriendsStatusUtil.g(paramRecentBaseData.qx(), this.app))
      {
        paramRecentBaseData.mUnreadFlag = 3;
        break label79;
      }
      paramRecentBaseData.mUnreadFlag = 1;
      break label79;
      label251:
      i = 2130851404;
      parama.l.setDragViewType(0, null);
      parama.l.setTextColor(this.mActivity.getResources().getColor(2131167429));
    }
    label287:
    parama.l.setVisibility(4);
  }
  
  public void a(c paramc)
  {
    if (this.mOnPageChangeListeners == null) {
      this.mOnPageChangeListeners = new ArrayList();
    }
    this.mOnPageChangeListeners.add(paramc);
  }
  
  public void aU(float paramFloat)
  {
    try
    {
      Field localField = (Field)Class.class.getDeclaredMethod("getDeclaredField", new Class[] { String.class }).invoke(HorizontalScrollView.class, new Object[] { "mMaximumVelocity" });
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf((int)(this.djn * paramFloat)));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "updateMaxVelocity: ", localException);
    }
  }
  
  public void abortAnimation()
  {
    try
    {
      Field localField = HorizontalScrollView.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      ((OverScroller)localField.get(this)).abortAnimation();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "abortAnimation: ", localException);
    }
  }
  
  public boolean aqL()
  {
    try
    {
      Field localField = HorizontalScrollView.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      boolean bool = ((OverScroller)localField.get(this)).isFinished();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("TabPageIndicator", 1, "isScrollerFinished: ", localException);
    }
    return false;
  }
  
  public boolean aqS()
  {
    return (this.djr == 1) && (this.mScrollState == 0);
  }
  
  public void c(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity)
  {
    this.app = paramQQAppInterface;
    this.mActivity = paramFragmentActivity;
    this.leftPadding = this.mActivity.getResources().getDimensionPixelSize(2131298725);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.setPadding(this.leftPadding, 0, this.leftPadding, 0);
    this.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
    this.mFaceDecoder = new aajx(paramQQAppInterface, this, false);
  }
  
  public void computeScroll()
  {
    this.coT = false;
    int i = this.jdField_a_of_type_Ajiy.getFinalX();
    super.computeScroll();
    if ((this.jdField_a_of_type_Ajiy.getFinalX() < i) && (QLog.isColorLevel())) {
      QLog.d("TabPageIndicator", 2, "computeScroll() called afterComputeFinalX < beforeComputeFinalX");
    }
    requestLayout();
    if (this.mScrollState == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "computeScroll() ScrollX = " + getScrollX() + ", Scroller.FinialX = " + this.jdField_a_of_type_Ajiy.getFinalX());
      }
      if (this.coT) {
        break label187;
      }
      if (!aqU()) {
        break label171;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "computeScroll() mCallOnScrollChanged = false, I'm not scrolling ? Build.MANUFACTURER = " + Build.MANUFACTURER + ", Build.MODEL = " + Build.MODEL);
      }
      dxQ();
    }
    label171:
    label187:
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("TabPageIndicator", 2, "computeScroll() isFinishScroll = false");
      return;
    }
    QLog.d("TabPageIndicator", 2, "computeScroll() mCallOnScrollChanged = true");
  }
  
  public void destroy()
  {
    if (this.mFaceDecoder != null) {
      this.mFaceDecoder.onDestory();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "dispatchTouchEvent() called with: ev = [" + paramMotionEvent + "]");
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "dispatchTouchEvent() called with: ev = [" + paramMotionEvent + "], handled = " + bool);
    }
    if (bool) {
      if (this.jdField_a_of_type_Ajjd != null) {
        this.jdField_a_of_type_Ajjd.g(this, paramMotionEvent);
      }
    }
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
    case 0: 
      do
      {
        return bool;
        this.mIsBeingDragged = true;
        this.coU = false;
        setScrollState(1);
      } while (!QLog.isColorLevel());
      QLog.d("TabPageIndicator", 2, "dispatchTouchEvent()  ACTION_DOWN called with: mScrollState = " + this.mScrollState);
      return bool;
    }
    if ((!this.mIsBeingDragged) || (this.coU)) {}
    for (;;)
    {
      this.mIsBeingDragged = false;
      setScrollState(2);
      invalidate();
      return bool;
      this.jdField_a_of_type_Ajiy.forceFinished(true);
      if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator$b != null)
      {
        int i = (int)this.xm;
        this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator$b.QR(i);
      }
    }
  }
  
  public void fk(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "updateUnReadMsgState called with:");
    }
    int i = 0;
    if (i < this.Di.size() - 1)
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)this.Di.get(i);
      Object localObject;
      if ((TextUtils.equals(paramString, localRecentBaseData.qx())) && (paramInt == localRecentBaseData.ng()))
      {
        localObject = this.app.a();
        if (localObject == null) {
          break label128;
        }
        localRecentBaseData.mUnreadNum = ((tog)localObject).A(localRecentBaseData.qx(), localRecentBaseData.ng());
        label102:
        if ((this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getCurrentItem() != i) || (localRecentBaseData.mUnreadNum <= 0)) {
          break label137;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label128:
        localRecentBaseData.mUnreadNum = 0;
        break label102;
        label137:
        localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(i).getTag();
        if ((localObject instanceof a))
        {
          localObject = (a)localObject;
          this.mHandler.post(new TabPageIndicator.1(this, (a)localObject, localRecentBaseData));
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("TabPageIndicator", 2, "updateUnReadMsgState() called with: MultiAIOHolder is null!");
        }
      }
    }
  }
  
  public void fling(int paramInt)
  {
    long l = SystemClock.uptimeMillis();
    this.coU = true;
    boolean bool;
    int n;
    int i1;
    int j;
    int i;
    float f;
    if (paramInt > 0)
    {
      bool = true;
      n = getWidth() - getPaddingRight() - getPaddingLeft();
      i1 = getChildAt(0).getWidth();
      this.jdField_a_of_type_Ajiy.fling(getScrollX(), getScrollY(), paramInt, 0, 0, Math.max(0, i1 - n), 0, 0, n / 2, 0);
      j = this.jdField_a_of_type_Ajiy.getFinalX();
      i = j / this.itemWidth;
      f = j * 1.0F / this.itemWidth;
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "fling() called with: getScrollX() = " + getScrollX() + ", velocityX = [" + paramInt + "], pageFloat = " + f + ", pageInt = " + i + ", flingFromRight2Left = " + bool + ", flingDistance = " + (j - getScrollX()));
      }
      if (!bool) {
        break label489;
      }
      if (f - i < 0.5F) {
        break label724;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "fling() 手向左滑 增加滑动一点到下一页");
      }
      j = 1;
      i += 1;
    }
    for (;;)
    {
      label236:
      int k = i;
      if (i < 0) {
        k = 0;
      }
      this.djs = (k * this.itemWidth);
      i = 0;
      int m = 2147483647;
      k = paramInt;
      paramInt = m;
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "fling() called mPendingFinalX = [" + this.djs + "], currentFinalX = [" + this.jdField_a_of_type_Ajiy.getFinalX() + "]");
      }
      m = Math.abs(this.jdField_a_of_type_Ajiy.getFinalX() - this.djs);
      if ((paramInt != 2147483647) && (m > paramInt + 1)) {
        QLog.e("TabPageIndicator", 1, "fling: error state deltaDistance " + m + ", lastDeltaDistance = " + paramInt);
      }
      label489:
      while (m == 0)
      {
        this.jdField_a_of_type_Ajiy.forceFinished(true);
        setScrollState(2);
        super.fling(k);
        if (QLog.isColorLevel()) {
          QLog.d("TabPageIndicator", 2, "fling() called with: velocityX = [" + k + "], final ScrollX = " + this.jdField_a_of_type_Ajiy.getFinalX() + ", exec time = " + (SystemClock.uptimeMillis() - l) + " ms");
        }
        return;
        bool = false;
        break;
        if (f - i >= 0.5F)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TabPageIndicator", 2, "fling() 手向右滑 增加滑动一点到下一页");
          }
          j = 0;
          i += 1;
          break label236;
        }
        j = 1;
        break label236;
      }
      while (!this.jdField_a_of_type_Ajiy.isFinished()) {
        this.jdField_a_of_type_Ajiy.forceFinished(true);
      }
      if (bool) {
        if (j != 0) {
          paramInt = k + m;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TabPageIndicator", 2, "fling() called with: try " + i + ", velocityX = [" + paramInt + "], deltaVelocity = " + m + ", deltaDistance = " + m);
        }
        this.jdField_a_of_type_Ajiy.fling(getScrollX(), getScrollY(), paramInt, 0, 0, Math.max(0, i1 - n), 0, 0, n / 2, 0);
        k = m;
        i += 1;
        m = paramInt;
        paramInt = k;
        k = m;
        break;
        paramInt = k - m;
        continue;
        if (j != 0) {
          paramInt = k - m;
        } else {
          paramInt = k + m;
        }
      }
      label724:
      j = 0;
    }
  }
  
  public void hideArrow()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(i);
      if (localView != null) {
        J(localView, false);
      }
      i += 1;
    }
  }
  
  protected boolean needDynamic(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.ng();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008);
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.removeAllViews();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getAdapter();
    this.count = ((PagerAdapter)localObject).getCount();
    if ((localObject instanceof MultiAIOPagerAdapter))
    {
      this.Di = ((MultiAIOPagerAdapter)localObject).be();
      int i = 0;
      while (i < this.count)
      {
        new LinearLayout.LayoutParams(-2, -2).gravity = 17;
        long l = SystemClock.elapsedRealtime();
        localObject = O(i);
        if (QLog.isColorLevel()) {
          QLog.d("TabPageIndicator", 2, "createView() cost " + (SystemClock.elapsedRealtime() - l) + " ms");
        }
        hf((View)localObject);
        i += 1;
      }
      if (this.mSelectedTabIndex > this.count) {
        this.mSelectedTabIndex = (this.count - 1);
      }
      setCurrentItem(this.mSelectedTabIndex);
      requestLayout();
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mTabSelector != null) {
      post(this.mTabSelector);
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String arg3, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(???)) {}
    long l;
    for (;;)
    {
      return;
      if ((paramBitmap != null) || (paramInt1 <= 0))
      {
        if (paramBitmap != null) {}
        try
        {
          this.faceCache.put(paramInt2 + ":" + ???, paramBitmap);
          l = System.currentTimeMillis();
          if ((this.decodeFaceStartTime > 0L) && (l - this.decodeFaceStartTime > 300L))
          {
            paramInt2 = 1;
            if ((paramInt1 > 0) && (paramInt2 == 0)) {
              continue;
            }
            synchronized (this.faceCache)
            {
              if (this.faceCache.size() == 0) {
                return;
              }
            }
          }
        }
        catch (OutOfMemoryError ???)
        {
          for (;;)
          {
            System.gc();
            ???.printStackTrace();
            QLog.i("TabPageIndicator", 1, "onDecodeTaskCompleted error:" + ???.getMessage());
            continue;
            paramInt2 = 0;
          }
        }
      }
    }
    boolean bool;
    if (paramInt1 == 0)
    {
      this.decodeFaceStartTime = 0L;
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount();
      paramInt1 = 0;
      bool = false;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        paramBitmap = (RecentBaseData)this.Di.get(paramInt1);
        if (paramBitmap == null)
        {
          break label432;
          this.decodeFaceStartTime = l;
          break;
        }
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(paramInt1).getTag();
        if (!(localObject1 instanceof a)) {
          break label432;
        }
        localObject1 = (a)localObject1;
        int i = paramBitmap.ng();
        i = ((Integer)aajx.a(this.app, i, paramBitmap.qx()).first).intValue();
        if (i == -2147483648) {
          break label432;
        }
        Object localObject2 = i + ":" + paramBitmap.qx();
        localObject2 = (Bitmap)this.faceCache.get(localObject2);
        if (localObject2 == null) {
          break label432;
        }
        a((a)localObject1, paramBitmap, new BitmapDrawable(this.mActivity.getResources(), (Bitmap)localObject2));
        bool = true;
        break label432;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("TabPageIndicator", 4, "decodecomplete|faceCache size = " + this.faceCache.size() + ", isNeedUpdateAvatar=" + bool);
      }
      this.faceCache.clear();
      return;
      label432:
      paramInt1 += 1;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mTabSelector != null) {
      removeCallbacks(this.mTabSelector);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount();
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(paramInt1);
      ((View)localObject).getLocationOnScreen(this.mTmpLocation);
      paramInt3 = Math.abs(this.mTmpLocation[0] - this.leftPadding);
      float f = paramInt3 / this.itemWidth;
      double d;
      if (paramInt3 <= this.itemWidth) {
        d = MIN_SCALE;
      }
      for (f = Math.min((float)(Math.cos(f * 1.570796326794897D) * (MAX_SCALE - MIN_SCALE) + d), MAX_SCALE);; f = MIN_SCALE)
      {
        localObject = ((View)localObject).getTag();
        if ((localObject instanceof a))
        {
          localObject = (a)localObject;
          ((a)localObject).d.setScaleX(f);
          ((a)localObject).d.setScaleY(f);
        }
        paramInt1 += 1;
        break;
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {}
    for (boolean bool = true;; bool = false)
    {
      setFillViewport(bool);
      int i = getMeasuredWidth();
      super.onMeasure(paramInt1, paramInt2);
      paramInt1 = getMeasuredWidth();
      if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount() > 0)
      {
        this.itemWidth = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(0).getMeasuredWidth();
        paramInt2 = this.mScreenWidth;
        int j = this.itemWidth;
        int k = this.leftPadding;
        this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getPaddingTop(), paramInt2 - j - k, this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getPaddingBottom());
      }
      if ((bool) && (i != paramInt1)) {
        setCurrentItem(this.mSelectedTabIndex);
      }
      return;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, " onPageScrollStateChanged  state = " + paramInt);
    }
    if (this.c != null) {
      this.c.onPageScrollStateChanged(paramInt);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(this.mSelectedTabIndex).getTag();
    if ((localObject instanceof a)) {
      localObject = (a)localObject;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      ((a)localObject).arrow.setVisibility(0);
      return;
    }
    ((a)localObject).arrow.setVisibility(4);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.c != null) {
      this.c.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    paramInt1 = (int)((paramInt1 + paramFloat) * this.itemWidth);
    if (aqS())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "onPageScrolled() scrollFromViewPager ");
      }
      smoothScrollTo(paramInt1, 0);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "onPageSelected() called with: position = [" + paramInt + "]");
    }
    setCurrentItem(paramInt);
    if (this.c != null) {
      this.c.onPageSelected(paramInt);
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.coT = true;
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (aqT())
    {
      paramInt3 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getWidth() - this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getPaddingLeft() - this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getPaddingRight() + this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getPageMargin();
      paramInt2 = paramInt1 / this.itemWidth;
      float f1 = paramInt1 % this.itemWidth * 1.0F / this.itemWidth;
      float f2 = paramInt2 * paramInt3;
      paramInt1 = (int)(paramInt3 * f1 + f2);
      if ((this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.isFakeDragging()) || (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.beginFakeDrag()))
      {
        f1 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getScrollX() - paramInt1;
        paramInt1 = Math.abs(paramInt2 - this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getCurrentItem());
        if (QLog.isColorLevel()) {
          QLog.d("TabPageIndicator", 2, "onScrollChanged() CurrentItem = [" + this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getCurrentItem() + "], position = [" + paramInt2 + "], deltaPosition = " + paramInt1);
        }
        if (paramInt1 != 0) {
          this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.populate(paramInt2);
        }
        this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.fakeDragBy(f1);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    int k = 1;
    int i = k;
    if (this.acT > 0L)
    {
      i = k;
      if (SystemClock.uptimeMillis() - this.acT < 250L) {
        i = 0;
      }
    }
    if (!aqL()) {
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        this.mGestureDetector.onTouchEvent(paramMotionEvent);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "onTouchEvent() called with: ev = [" + paramMotionEvent + "]");
      }
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "onTouchEvent() called with: ev = [" + paramMotionEvent + "], handled = " + bool);
      }
      return bool;
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "setCurrentItem() called with: item = [" + paramInt + "], mSelectedTabIndex = [" + this.mSelectedTabIndex + "]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager == null) {
      throw new IllegalStateException("ViewPager has not been bound.");
    }
    if (this.djq == paramInt)
    {
      animateToTab(paramInt);
      return;
    }
    this.mSelectedTabIndex = paramInt;
    int j = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool) {
          animateToTab(paramInt);
        }
        if (this.djq == i) {
          QX(this.djq);
        }
        i += 1;
        break;
      }
    }
    this.djq = paramInt;
  }
  
  public void setOnActionUpNotFling(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator$b = paramb;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.fs = paramOnClickListener;
  }
  
  public void setOnPageChangeListener(MultiAIOBaseViewPager.g paramg)
  {
    this.c = paramg;
  }
  
  public void setOnTabClickListener(d paramd)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator$d = paramd;
  }
  
  public void setOnTabReselectedListener(e parame)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator$e = parame;
  }
  
  public void setScrollState(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
    dispatchOnScrollStateChanged(paramInt);
  }
  
  public void setTouchEventConsumer(ajjd paramajjd)
  {
    this.jdField_a_of_type_Ajjd = paramajjd;
  }
  
  public void setViewPager(MultiAIOBaseViewPager paramMultiAIOBaseViewPager)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager == paramMultiAIOBaseViewPager) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.setOnPageChangeListener(null);
    }
    if (paramMultiAIOBaseViewPager.getAdapter() == null) {
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    }
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager = paramMultiAIOBaseViewPager;
    paramMultiAIOBaseViewPager.setOnPageChangeListener(this);
    notifyDataSetChanged();
  }
  
  public void setViewPager(MultiAIOBaseViewPager paramMultiAIOBaseViewPager, int paramInt)
  {
    setViewPager(paramMultiAIOBaseViewPager);
    setCurrentItem(paramInt);
  }
  
  public void setViewPagerBusy(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.djr = i;
      if (QLog.isColorLevel()) {
        QLog.d("TabPageIndicator", 2, "setViewPagerBusy() called with: mViewPagerBusy = " + this.djr);
      }
      return;
    }
  }
  
  public void showArrow()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager.getCurrentItem();
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetIcsLinearLayout.getChildAt(i);
      if (localView != null) {
        if (j != i) {
          break label57;
        }
      }
      label57:
      for (boolean bool = true;; bool = false)
      {
        J(localView, bool);
        i += 1;
        break;
      }
    }
  }
  
  public static class a
  {
    public ImageView arrow;
    String bRC;
    RecentDynamicAvatarView d;
    public int index;
    DragTextView l;
  }
  
  public static abstract interface b
  {
    public abstract void QR(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void onPageScrollStateChanged(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void wu(int paramInt);
  }
  
  public static abstract interface e
  {
    public abstract void QZ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.TabPageIndicator
 * JD-Core Version:    0.7.0.1
 */