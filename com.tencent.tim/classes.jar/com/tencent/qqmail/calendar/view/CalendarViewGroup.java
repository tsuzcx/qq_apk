package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qqmail.calendar.data.CalendarDayData;
import com.tencent.qqmail.calendar.data.QMSchedule;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import java.util.Calendar;

public class CalendarViewGroup
  extends ViewGroup
  implements CalendarScrollView.CalenderListener, CalendarScrollView.TimeLineViewListener
{
  public static final int ORIENTATION_HORIZONTAL = 0;
  public static final int ORIENTATION_VERTICAL = 1;
  private boolean mAnimating;
  private OffsetAnimationListener mAnimationListener;
  private CalendarScrollView mCalender;
  private CalendarScrollView.CalenderListener mCalenderListener;
  private ScheduleListView mTimeLineListView;
  private int mTopOffset;
  
  public CalendarViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CalendarViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View getContent()
  {
    return this.mTimeLineListView;
  }
  
  public Calendar getSelectedDay()
  {
    return this.mCalender.getSelectedDay();
  }
  
  public boolean isMoving()
  {
    return this.mAnimating;
  }
  
  public void notifyAnimation(int paramInt)
  {
    if (this.mAnimationListener == null) {
      this.mAnimationListener = new OffsetAnimationListener(null);
    }
    int i = this.mTimeLineListView.getLeft();
    int j = this.mTimeLineListView.getTop();
    int k = this.mTimeLineListView.getRight();
    int m = this.mTimeLineListView.getBottom();
    this.mTopOffset += paramInt;
    Object localObject = this.mTimeLineListView.getAnimation();
    if ((localObject instanceof TranslateValueAnimation))
    {
      localObject = (TranslateValueAnimation)localObject;
      ((TranslateValueAnimation)localObject).reStartValueAnimation(0.0F, ((TranslateValueAnimation)localObject).getToDeltaY() + paramInt);
    }
    for (;;)
    {
      OffsetAnimationListener localOffsetAnimationListener = this.mAnimationListener;
      OffsetAnimationListener.access$102(localOffsetAnimationListener, localOffsetAnimationListener.mOffsetY + paramInt);
      ((TranslateValueAnimation)localObject).setFillAfter(true);
      ((TranslateValueAnimation)localObject).setDuration(250L);
      ((TranslateValueAnimation)localObject).setAnimationListener(this.mAnimationListener);
      this.mTimeLineListView.startAnimation((Animation)localObject);
      return;
      localObject = new TranslateValueAnimation(0.0F, 0.0F, 0.0F, paramInt, 250L);
      this.mTimeLineListView.layout(i, j, k, Math.max(m, m - this.mTopOffset));
    }
  }
  
  public void notifyAnimation(int paramInt, float paramFloat) {}
  
  public void onChangeMonth(int paramInt1, int paramInt2)
  {
    if (this.mCalenderListener != null) {
      this.mCalenderListener.onChangeMonth(paramInt1, paramInt2);
    }
  }
  
  public void onDayViewDoubleClick(int paramInt1, int paramInt2, CalendarDayData paramCalendarDayData, View paramView)
  {
    if (this.mCalenderListener != null) {
      this.mCalenderListener.onDayViewDoubleClick(paramInt1, paramInt2, paramCalendarDayData, paramView);
    }
  }
  
  protected void onFinishInflate()
  {
    this.mCalender = ((CalendarScrollView)findViewById(2131364177));
    if (this.mCalender == null) {
      throw new IllegalArgumentException("The handle attribute is must refer to an existing child.");
    }
    MonthAdapter localMonthAdapter = new MonthAdapter(getContext());
    localMonthAdapter.setOnItemClickListener(this.mCalender);
    localMonthAdapter.setOnItemLongClickListener(this.mCalender);
    this.mCalender.setAdapter(localMonthAdapter);
    this.mCalender.setTimeLineViewListener(this);
    this.mCalender.setDateActionListener(this);
    this.mTimeLineListView = ((ScheduleListView)findViewById(2131379705));
    if (this.mTimeLineListView == null) {
      throw new IllegalArgumentException("The content attribute is must refer to an existing child.");
    }
    this.mTimeLineListView.setCalenderListener(this);
    this.mTimeLineListView.setAdapter(new ScheduleListAdapter(getContext()));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = 0;
    long l1 = System.currentTimeMillis();
    Object localObject;
    if ((paramBoolean) || (this.mCalender.isForceRelayout()))
    {
      paramInt1 = this.mCalender.getMeasuredWidth();
      paramInt2 = this.mCalender.getMeasuredHeight();
      localObject = this.mTimeLineListView;
      paramInt3 = (getWidth() - 6) / 7;
      paramInt3 = getWidth() - paramInt3 * 7 - 6;
      this.mCalender.setGridPaddingLeft(paramInt3 / 2);
      this.mCalender.setGridPaddingRight(paramInt3 / 2);
      this.mCalender.layout(0, 0, paramInt1, paramInt2);
      this.mTopOffset = (this.mCalender.getCurrentMonthHeight() - paramInt2 - 1);
      ((View)localObject).layout(0, this.mTopOffset + paramInt2, ((View)localObject).getMeasuredWidth(), getHeight());
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      Log.i("wuziyi", "View group onLayout:" + (l2 - l1));
      return;
      paramInt2 = getChildCount();
      while (paramInt1 < paramInt2)
      {
        localObject = getChildAt(paramInt1);
        if (((View)localObject).getVisibility() != 8) {
          ((View)localObject).layout(((View)localObject).getLeft(), ((View)localObject).getTop(), ((View)localObject).getRight(), ((View)localObject).getBottom());
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onLongClickDate(CalendarDayData paramCalendarDayData, View paramView)
  {
    if (this.mCalenderListener != null) {
      this.mCalenderListener.onLongClickDate(paramCalendarDayData, paramView);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    if ((k == 0) || (m == 0)) {
      throw new RuntimeException("SlidingDrawer cannot have UNSPECIFIED dimensions");
    }
    measureChild(this.mCalender, paramInt1, paramInt2);
    paramInt1 = this.mTopOffset;
    this.mTimeLineListView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1 + j, 1073741824));
    setMeasuredDimension(i, j);
  }
  
  public void onScheduleItemClick(QMSchedule paramQMSchedule)
  {
    if (this.mCalenderListener != null) {
      this.mCalenderListener.onScheduleItemClick(paramQMSchedule);
    }
  }
  
  public boolean onScheduleItemLongClick(QMSchedule paramQMSchedule)
  {
    if (this.mCalenderListener != null) {
      return this.mCalenderListener.onScheduleItemLongClick(paramQMSchedule);
    }
    return false;
  }
  
  public void onSelectDate(int paramInt1, int paramInt2, CalendarDayData paramCalendarDayData, View paramView)
  {
    if (paramCalendarDayData.hasSchedule()) {
      this.mTimeLineListView.updateScheduleAsyn(paramInt1, paramInt2, paramCalendarDayData.getDay(), new CalendarViewGroup.1(this));
    }
    for (;;)
    {
      this.mTimeLineListView.setSelection(0);
      if (this.mCalenderListener != null) {
        this.mCalenderListener.onSelectDate(paramInt1, paramInt2, paramCalendarDayData, paramView);
      }
      return;
      this.mTimeLineListView.setNoSchedule();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void reDraw()
  {
    this.mCalender.forceRelayout();
  }
  
  public void refreshSelectedDaySchedule()
  {
    Calendar localCalendar = this.mCalender.getSelectedDay();
    this.mTimeLineListView.updateSchedule(localCalendar.get(1), localCalendar.get(2) + 1, localCalendar.get(5));
  }
  
  public void release()
  {
    this.mCalender.release();
  }
  
  public void setCalenderListener(CalendarScrollView.CalenderListener paramCalenderListener)
  {
    this.mCalenderListener = paramCalenderListener;
  }
  
  public void setStartPageMonth(Calendar paramCalendar)
  {
    this.mCalender.setSelectedDay(paramCalendar);
    int i = QMCalendarUtil.getDiffMonths(paramCalendar, Calendar.getInstance());
    this.mCalender.forceRelayout(i);
  }
  
  public void snapToTodayScreen()
  {
    if (this.mCalender != null)
    {
      this.mCalender.snapToTodayScreen();
      refreshSelectedDaySchedule();
    }
  }
  
  class OffsetAnimationListener
    implements Animation.AnimationListener
  {
    private int mOffsetY;
    
    private OffsetAnimationListener() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      CalendarViewGroup.this.mTimeLineListView.clearAnimation();
      CalendarViewGroup.access$302(CalendarViewGroup.this, false);
      if (this.mOffsetY < 0) {
        CalendarViewGroup.this.mTimeLineListView.offsetTopAndBottom(this.mOffsetY);
      }
      for (;;)
      {
        this.mOffsetY = 0;
        return;
        if (this.mOffsetY > 0) {
          CalendarViewGroup.this.mTimeLineListView.layout(0, CalendarViewGroup.this.mCalender.getHeight() + CalendarViewGroup.this.mTopOffset, CalendarViewGroup.this.mTimeLineListView.getWidth(), CalendarViewGroup.this.getHeight());
        }
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.CalendarViewGroup
 * JD-Core Version:    0.7.0.1
 */