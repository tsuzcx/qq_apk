package com.tencent.qqmail.calendar.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.data.CalendarDayData;
import com.tencent.qqmail.calendar.data.QMSchedule;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.scroller.ScreenScroller;
import com.tencent.qqmail.scroller.ScreenScrollerListener;
import com.tencent.qqmail.scroller.effector.SubScreenEffector;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Calendar;
import java.util.LinkedList;

public class CalendarScrollView
  extends ScrollableGridView<ScreenScroller>
  implements ScreenScrollerListener
{
  public static final int DAYS_OF_WEEK = 7;
  public static final int GAP_OF_DAYS = 1;
  public static final int MAX_WEEKS_OF_MONTH = 6;
  public static final int MIN_WEEKS_OF_MONTH = 4;
  private long lastClickTime = 0L;
  private DateActionListener mCalenderListener;
  private PerformSelectedDayChange mDayChange;
  private SubScreenEffector mDeskScreenEffector;
  private int mDuration = 600;
  private boolean mFindTodayTarget;
  private boolean mFlingToToday;
  private boolean mIsSeletedDayChangeAuto = true;
  private TimeLineViewListener mListener;
  private PerformMonthChange mMonthChange;
  private PerformNotifyAnimation mPerformNotifyAnimation;
  private boolean mRelayout;
  private int mScrollingBounce = 0;
  private AbsDayView mSelectedView;
  private int mSpecificPosition;
  
  public CalendarScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CalendarScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int getWeeksOfMonth(Calendar paramCalendar)
  {
    paramCalendar.set(5, 1);
    int i = paramCalendar.get(7);
    int j = paramCalendar.get(1);
    int k = paramCalendar.get(2);
    return (int)Math.ceil((i - 1 + QMCalendarManager.getDaysOfMonth(QMCalendarManager.isLeapYear(j), k + 1)) * 1.0D / 7.0D);
  }
  
  private void jumpToSelectScreen(int paramInt)
  {
    try
    {
      AbsDayView localAbsDayView = this.mSelectedView;
      ((ScreenScroller)this.mScroller).setCurrentScreen(paramInt);
      Object localObject = (DaysGridView)getCurrentScreenView();
      if (localObject != null) {}
      for (localObject = ((DaysGridView)localObject).getSelectView();; localObject = null)
      {
        this.mSelectedView = ((AbsDayView)localObject);
        if (localAbsDayView != this.mSelectedView) {
          localAbsDayView.changeToNormalStyle();
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "snapToSelectDay", "setCurrentScreen error");
    }
  }
  
  private void performMonthChange()
  {
    if (this.mMonthChange != null)
    {
      this.mMonthChange.run();
      this.mMonthChange = null;
    }
  }
  
  private void performNotifyAnimation()
  {
    if (this.mPerformNotifyAnimation != null)
    {
      this.mPerformNotifyAnimation.run();
      this.mPerformNotifyAnimation = null;
    }
  }
  
  private void performSelectedDayChange()
  {
    if (this.mDayChange != null)
    {
      this.mDayChange.run();
      this.mDayChange = null;
    }
  }
  
  @SuppressLint({"WrongCall"})
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    int i = getWidth();
    int j = Math.max(this.mMinHeight, getHeight());
    int k;
    if (isVerticalScroll())
    {
      k = getScrollY();
      paramCanvas.clipRect(0, k, i, j + k);
      if ((this.mScroller == null) || (((ScreenScroller)this.mScroller).isFinished())) {
        break label107;
      }
      ((ScreenScroller)this.mScroller).onDraw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      k = getScrollX();
      paramCanvas.clipRect(k, 0, i + k, j);
      break;
      label107:
      long l = getDrawingTime();
      View localView = getChildAt(this.mCurrentScreen - this.mFirstItemPosition);
      if ((localView != null) && (localView.getVisibility() == 0)) {
        drawChild(paramCanvas, localView, l);
      }
    }
  }
  
  public void forceRelayout()
  {
    ((MonthAdapter)this.mAdapter).setDirty();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      this.mAdapter.getView(this.mFirstItemPosition + i, getChildAt(i), this);
      i += 1;
    }
    requestLayout();
  }
  
  public void forceRelayout(int paramInt)
  {
    this.mRelayout = true;
    for (View localView = getChildAt(0); localView != null; localView = getChildAt(0))
    {
      detachViewFromParent(0);
      this.mCachedItemViews.addLast(localView);
      localView.forceLayout();
    }
    this.mSpecificPosition = paramInt;
    this.mFirstItemPosition = paramInt;
    this.mLastItemPosition = paramInt;
    requestLayout();
  }
  
  public int getCurrentMonthHeight()
  {
    if (this.mRelayout) {
      return getScreenSizeByIndex(this.mSpecificPosition);
    }
    return getScreenSizeByIndex(this.mCurrentScreen);
  }
  
  protected View getCurrentScreenView()
  {
    return getChildAt(this.mCurrentScreen - this.mFirstItemPosition);
  }
  
  public int getFirstVisiableScreenIndex(int paramInt)
  {
    int j = 0;
    int m = 0;
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      localObject = getChildAt(i);
      if ((((View)localObject).getTop() <= paramInt) && (paramInt < ((View)localObject).getBottom())) {
        return this.mFirstItemPosition + i;
      }
      i += 1;
    }
    k = Math.abs(paramInt) / this.mGridCellHeight;
    Object localObject = Calendar.getInstance();
    i = j;
    j = k;
    if (paramInt < 0)
    {
      paramInt = m;
      for (;;)
      {
        m = paramInt;
        if (k <= 0) {
          break;
        }
        ((Calendar)localObject).add(2, -1);
        i = k - getWeeksOfMonth((Calendar)localObject);
        k = i;
        if (i >= 0)
        {
          paramInt -= 1;
          k = i;
        }
      }
    }
    for (;;)
    {
      m = i;
      if (j <= 0) {
        break;
      }
      paramInt = j - getWeeksOfMonth((Calendar)localObject);
      ((Calendar)localObject).add(2, 1);
      j = paramInt;
      if (paramInt >= 0)
      {
        i += 1;
        j = paramInt;
      }
    }
    Log.i("wuziyi", "backup funtion:" + m);
    return m;
  }
  
  public ScreenScroller getScreenScroller()
  {
    return (ScreenScroller)this.mScroller;
  }
  
  public int getScreenSizeByIndex(int paramInt)
  {
    int i = paramInt - this.mFirstItemPosition;
    if (getChildAt(i) == null)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.add(2, paramInt);
      return getWeeksOfMonth(localCalendar) * this.mGridCellHeight;
    }
    return getChildAt(i).getHeight();
  }
  
  public int getScreenTopByIndex(int paramInt)
  {
    int i = 0;
    if (paramInt == 0) {
      return 0;
    }
    int j = paramInt - this.mFirstItemPosition;
    if (getChildAt(j) == null)
    {
      Calendar localCalendar = Calendar.getInstance();
      while (paramInt != 0) {
        if (paramInt < 0)
        {
          localCalendar.add(2, -1);
          i -= getWeeksOfMonth(localCalendar);
          paramInt += 1;
        }
        else
        {
          i += getWeeksOfMonth(localCalendar);
          paramInt -= 1;
          localCalendar.add(2, 1);
        }
      }
      return i * this.mGridCellHeight;
    }
    return getChildAt(j).getTop();
  }
  
  public Calendar getSelectedDay()
  {
    return ((MonthAdapter)this.mAdapter).getSelectedDay();
  }
  
  protected void initScroller(Context paramContext)
  {
    this.mScroller = new ScreenScroller(paramContext, this);
    this.mDeskScreenEffector = new SubScreenEffector((ScreenScroller)this.mScroller);
  }
  
  protected void initViews(Context paramContext)
  {
    super.initViews(paramContext);
    this.mNumColumns = 7;
    this.mNumRows = 6;
  }
  
  public boolean isForceRelayout()
  {
    return this.mRelayout;
  }
  
  public boolean isSeletedDayChangeAuto()
  {
    return this.mIsSeletedDayChangeAuto;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ((MonthAdapter)this.mAdapter).setDirty();
  }
  
  protected void onChildAdd(View paramView)
  {
    if ((this.mFlingToToday) && (!this.mFindTodayTarget))
    {
      paramView = ((DaysGridView)paramView).findTodayView();
      if (paramView != null)
      {
        this.mDayChange = new PerformSelectedDayChange(null);
        PerformSelectedDayChange.access$502(this.mDayChange, Calendar.getInstance());
        PerformSelectedDayChange.access$602(this.mDayChange, paramView);
        performSelectedDayChange();
        this.mFindTodayTarget = true;
      }
    }
  }
  
  protected void onInitLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mSelectedView = ((DaysGridView)getChildAt(this.mCurrentScreen - this.mFirstItemPosition)).findSelectedView();
    this.mRect.set(paramInt1, -getHeight() / 3, paramInt3, getHeight() + getHeight() / 3);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    DaysGridView localDaysGridView;
    if (this.mSelectedView != paramView)
    {
      if (this.mSelectedView != null) {
        this.mSelectedView.changeToNormalStyle();
      }
      this.mSelectedView = ((AbsDayView)paramView);
      localDaysGridView = (DaysGridView)getCurrentScreenView();
      if ((localDaysGridView != null) && (this.mSelectedView != null) && (this.mSelectedView.getDayInfo() != null))
      {
        MonthAdapter localMonthAdapter = (MonthAdapter)this.mAdapter;
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.set(localDaysGridView.getYear(), localDaysGridView.getMonth() - 1, this.mSelectedView.getDayInfo().getDay());
        localMonthAdapter.setSelectedDay(localCalendar);
        this.mSelectedView.changeToFocusStyle(false);
        this.mCalenderListener.onSelectDate(localDaysGridView.getYear(), localDaysGridView.getMonth(), this.mSelectedView.getDayInfo(), this.mSelectedView);
      }
    }
    for (;;)
    {
      this.lastClickTime = l;
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      localDaysGridView = (DaysGridView)getCurrentScreenView();
      this.mCalenderListener.onDayViewDoubleClick(localDaysGridView.getYear(), localDaysGridView.getMonth(), this.mSelectedView.getDayInfo(), this.mSelectedView);
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.mSelectedView != paramView)
    {
      this.mSelectedView.changeToNormalStyle();
      this.mSelectedView = ((AbsDayView)paramView);
      paramAdapterView = (DaysGridView)getCurrentScreenView();
      paramView = (MonthAdapter)this.mAdapter;
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(paramAdapterView.getYear(), paramAdapterView.getMonth() - 1, this.mSelectedView.getDayInfo().getDay());
      paramView.setSelectedDay(localCalendar);
      this.mSelectedView.changeToFocusStyle(false);
      this.mCalenderListener.onSelectDate(paramAdapterView.getYear(), paramAdapterView.getMonth(), this.mSelectedView.getDayInfo(), this.mSelectedView);
      this.mCalenderListener.onLongClickDate(this.mSelectedView.getDayInfo(), this.mSelectedView);
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      this.mRect.set(0, 0, getWidth(), getHeight());
      this.mGridCellWidth = (getWidth() / this.mNumColumns);
      this.mGridCellHeight = (getHeight() / this.mNumRows);
    }
    if (this.mRelayout) {
      ((ScreenScroller)this.mScroller).setCurrentScreen(this.mSpecificPosition);
    }
    setGridPaddingBottom(1);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mRelayout)
    {
      if (this.mMonthChange == null)
      {
        this.mMonthChange = new PerformMonthChange(null);
        performMonthChange();
      }
      this.mRelayout = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2) + 6, View.MeasureSpec.getMode(paramInt2)));
  }
  
  public void onScreenChanged(int paramInt1, int paramInt2)
  {
    this.mCurrentScreen = paramInt1;
    if (this.mRelayout) {
      return;
    }
    paramInt2 = getScreenSizeByIndex(paramInt1) - getScreenSizeByIndex(paramInt2);
    if (paramInt2 != 0)
    {
      if (this.mPerformNotifyAnimation != null) {
        break label151;
      }
      this.mPerformNotifyAnimation = new PerformNotifyAnimation(paramInt2);
      if (!isTouchScrolling()) {
        performNotifyAnimation();
      }
    }
    for (;;)
    {
      if (paramInt1 == ((ScreenScroller)this.mScroller).getTouchDownScreen()) {
        break label162;
      }
      if ((this.mDayChange == null) && (this.mIsSeletedDayChangeAuto) && (!this.mFlingToToday))
      {
        this.mDayChange = new PerformSelectedDayChange(null);
        if (!isTouchScrolling()) {
          performSelectedDayChange();
        }
      }
      if (this.mMonthChange != null) {
        break;
      }
      this.mMonthChange = new PerformMonthChange(null);
      if (isTouchScrolling()) {
        break;
      }
      performMonthChange();
      return;
      label151:
      this.mPerformNotifyAnimation.addDeltaY(paramInt2);
    }
    label162:
    this.mDayChange = null;
    this.mMonthChange = null;
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2)
  {
    if (this.mRelayout) {
      return;
    }
    super.onScrollChanged(paramInt1, paramInt2);
  }
  
  public void onScrollFinish(int paramInt)
  {
    if (this.mFlingToToday) {
      this.mFlingToToday = false;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      performNotifyAnimation();
      performSelectedDayChange();
      performMonthChange();
    }
  }
  
  public void release()
  {
    ((MonthAdapter)this.mAdapter).release();
  }
  
  public void setAutoTweakElasicity(boolean paramBoolean)
  {
    ((ScreenScroller)this.mScroller).setEffectorMaxOvershootEnabled(paramBoolean);
  }
  
  public void setDateActionListener(DateActionListener paramDateActionListener)
  {
    this.mCalenderListener = paramDateActionListener;
  }
  
  public void setOvershootAmount(int paramInt)
  {
    if (this.mScrollingBounce == paramInt) {
      return;
    }
    this.mScrollingBounce = paramInt;
    ((ScreenScroller)this.mScroller).setMaxOvershootPercent(paramInt);
  }
  
  public void setScrollDuration(int paramInt)
  {
    this.mDuration = paramInt;
    ((ScreenScroller)this.mScroller).setDuration(this.mDuration);
  }
  
  public void setSelectedDay(Calendar paramCalendar)
  {
    ((MonthAdapter)this.mAdapter).setSelectedDay(paramCalendar);
  }
  
  public void setSeletedDayChangeAuto(boolean paramBoolean)
  {
    this.mIsSeletedDayChangeAuto = paramBoolean;
  }
  
  public void setTimeLineViewListener(TimeLineViewListener paramTimeLineViewListener)
  {
    this.mListener = paramTimeLineViewListener;
  }
  
  protected void setupScroller()
  {
    setOvershootAmount(this.mScrollingBounce);
    setScrollDuration(this.mDuration);
    super.setupScroller();
  }
  
  public void snapToSelectDay()
  {
    if (this.mScroller == null) {}
    int i;
    do
    {
      return;
      i = ((MonthAdapter)this.mAdapter).getSelectPosition();
      if (Math.abs(i - ((ScreenScroller)this.mScroller).getCurrentScreen()) > 2)
      {
        jumpToSelectScreen(i);
        return;
      }
    } while (this.mScroller == null);
    ((ScreenScroller)this.mScroller).gotoScreen(i);
  }
  
  public void snapToSelectDay(Calendar paramCalendar)
  {
    setSelectedDay(paramCalendar);
    MonthAdapter localMonthAdapter = (MonthAdapter)this.mAdapter;
    int i = localMonthAdapter.getCalendarPosition(paramCalendar);
    localMonthAdapter.setDirty();
    if (i != 0) {
      jumpToSelectScreen(i);
    }
    localMonthAdapter.notifyDataSetChanged();
  }
  
  public void snapToTodayScreen()
  {
    if (this.mScroller == null) {}
    for (;;)
    {
      return;
      if (Math.abs(((MonthAdapter)this.mAdapter).getTodayPosition() - ((ScreenScroller)this.mScroller).getCurrentScreen()) > 6)
      {
        setSelectedDay(Calendar.getInstance());
        forceRelayout(0);
        return;
      }
      if (this.mScroller != null)
      {
        this.mFlingToToday = ((ScreenScroller)this.mScroller).gotoStartScreen();
        int j = getChildCount();
        int i = 0;
        while (i < j)
        {
          AbsDayView localAbsDayView = ((DaysGridView)getChildAt(i)).findTodayView();
          if (localAbsDayView != null)
          {
            this.mFindTodayTarget = true;
            this.mDayChange = new PerformSelectedDayChange(null);
            PerformSelectedDayChange.access$502(this.mDayChange, Calendar.getInstance());
            PerformSelectedDayChange.access$602(this.mDayChange, localAbsDayView);
            performSelectedDayChange();
            return;
          }
          this.mFindTodayTarget = false;
          i += 1;
        }
      }
    }
  }
  
  public static abstract interface CalenderListener
    extends CalendarScrollView.DateActionListener
  {
    public abstract void onScheduleItemClick(QMSchedule paramQMSchedule);
    
    public abstract boolean onScheduleItemLongClick(QMSchedule paramQMSchedule);
  }
  
  public static abstract interface DateActionListener
  {
    public abstract void onChangeMonth(int paramInt1, int paramInt2);
    
    public abstract void onDayViewDoubleClick(int paramInt1, int paramInt2, CalendarDayData paramCalendarDayData, View paramView);
    
    public abstract void onLongClickDate(CalendarDayData paramCalendarDayData, View paramView);
    
    public abstract void onSelectDate(int paramInt1, int paramInt2, CalendarDayData paramCalendarDayData, View paramView);
  }
  
  class PerformMonthChange
    implements Runnable
  {
    private PerformMonthChange() {}
    
    public void run()
    {
      DaysGridView localDaysGridView = (DaysGridView)CalendarScrollView.this.getCurrentScreenView();
      if (localDaysGridView != null) {
        CalendarScrollView.this.mCalenderListener.onChangeMonth(localDaysGridView.getMonth(), localDaysGridView.getYear());
      }
    }
  }
  
  class PerformNotifyAnimation
    implements Runnable
  {
    private int mDeltaY;
    
    public PerformNotifyAnimation(int paramInt)
    {
      this.mDeltaY = paramInt;
    }
    
    public void addDeltaY(int paramInt)
    {
      this.mDeltaY += paramInt;
    }
    
    public void run()
    {
      if ((CalendarScrollView.this.mListener != null) && (this.mDeltaY != 0)) {
        CalendarScrollView.this.mListener.notifyAnimation(this.mDeltaY);
      }
    }
  }
  
  class PerformSelectedDayChange
    implements Runnable
  {
    private Calendar mTargetDay;
    private AbsDayView mTargetView;
    
    private PerformSelectedDayChange() {}
    
    public void run()
    {
      if (CalendarScrollView.this.mSelectedView != null) {
        CalendarScrollView.this.mSelectedView.changeToNormalStyle();
      }
      if (this.mTargetView == null)
      {
        DaysGridView localDaysGridView = (DaysGridView)CalendarScrollView.this.getChildAt(CalendarScrollView.this.mCurrentScreen - CalendarScrollView.this.mFirstItemPosition);
        Calendar localCalendar = Calendar.getInstance();
        if (localDaysGridView != null)
        {
          if ((localDaysGridView.getMonth() != localCalendar.get(2) + 1) || (localDaysGridView.getYear() != localCalendar.get(1))) {
            break label191;
          }
          CalendarScrollView.access$302(CalendarScrollView.this, localDaysGridView.findTodayView());
        }
        for (;;)
        {
          CalendarScrollView.this.mSelectedView.changeToFocusStyle(true);
          MonthAdapter localMonthAdapter = (MonthAdapter)CalendarScrollView.this.mAdapter;
          localCalendar.set(localDaysGridView.getYear(), localDaysGridView.getMonth() - 1, CalendarScrollView.this.mSelectedView.getDayInfo().getDay());
          localMonthAdapter.setSelectedDay(localCalendar);
          CalendarScrollView.this.mCalenderListener.onSelectDate(localDaysGridView.getYear(), localDaysGridView.getMonth(), CalendarScrollView.this.mSelectedView.getDayInfo(), CalendarScrollView.this.mSelectedView);
          return;
          label191:
          CalendarScrollView.access$302(CalendarScrollView.this, localDaysGridView.getFirstDayView());
        }
      }
      CalendarScrollView.access$302(CalendarScrollView.this, this.mTargetView);
      CalendarScrollView.this.mSelectedView.changeToFocusStyle(false);
      ((MonthAdapter)CalendarScrollView.this.mAdapter).setSelectedDay(this.mTargetDay);
      CalendarScrollView.this.mCalenderListener.onSelectDate(this.mTargetDay.get(1), this.mTargetDay.get(2) + 1, CalendarScrollView.this.mSelectedView.getDayInfo(), CalendarScrollView.this.mSelectedView);
    }
  }
  
  public static abstract interface TimeLineViewListener
  {
    public abstract void notifyAnimation(int paramInt);
    
    public abstract void notifyAnimation(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.CalendarScrollView
 * JD-Core Version:    0.7.0.1
 */